package com.huohougongfu.app.Fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Adapter.ShangPinAdapter;
import com.huohougongfu.app.Gson.BannerGson;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.ShopGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.DaShiZhuanChang;
import com.huohougongfu.app.Shop.Activity.LeiMuActivity;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Activity.ShopSouSuoActivity;
import com.huohougongfu.app.Shop.Activity.TeHuiActivity;
import com.huohougongfu.app.Shop.Activity.TeYuePinPaiActivity;
import com.huohougongfu.app.Shop.Adapter.ShopAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.imkit.RongIM;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imkit.model.Event;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import me.leolin.shortcutbadger.ShortcutBadger;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends Fragment implements View.OnClickListener,IUnReadMessageObserver{


    private View inflate;
    private Banner banner;
    private List<Integer> mlist = new ArrayList<>();
    private List<String> mbanner = new ArrayList<>();
    private List<String> mbannerimg = new ArrayList<>();
    private String token,tel,id;
    private SmartRefreshLayout smartrefreshlayout;
    private View head_shangcheng;
    private RecyclerView rec_shangcheng_shangpin;
    private Intent intent;
    private int page = 2;
    private ShopAdapter shangPinAdapter;
    private int message;
    private View bt_xiaoxi;
    final Conversation.ConversationType[] conversationTypes = {
            Conversation.ConversationType.PRIVATE,
            Conversation.ConversationType.GROUP, Conversation.ConversationType.SYSTEM,
            Conversation.ConversationType.PUBLIC_SERVICE, Conversation.ConversationType.APP_PUBLIC_SERVICE
    };
    private QBadgeView qBadgeView;

    @SuppressLint("ValidFragment")
    public ShopFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shop, container, false);
        intent = new Intent();
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        View statusBar = inflate.findViewById(R.id.statusBarView);
        ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
        layoutParams.height = utils.getStatusBarHeight();
        qBadgeView = new QBadgeView(getActivity());
        initUI();
        initbanner();
        initData();

        return inflate;
    }

    @Override
    public void onResume() {
        //未读消息
        RongIM.getInstance().addUnReadMessageCountChangedObserver(this, conversationTypes);
        smartrefreshlayout.autoRefresh();
        page = 2;
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        RongIM.getInstance().removeUnReadMessageCountChangedObserver(this);
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("page","1");
        map.put("pageSize","10");
        OkGo.<String>get(Contacts.URl1+"querySiftAndExpand")
                .params(map)
                .execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                WaitDialog.dismiss();
                String body = response.body();
                Gson gson = new Gson();
                ShopGson shop = gson.fromJson(body, ShopGson.class);
                if (shop.getStatus() == 1){
                    initRec(shop);
                    }
                }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(ShopGson list) {
        ViewGroup parentViewGroup = (ViewGroup) head_shangcheng.getParent();
        if (parentViewGroup != null) {
            parentViewGroup.removeAllViews();
        }
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(getActivity(),2);
        //设置RecyclerView 布局
        rec_shangcheng_shangpin.setLayoutManager(layoutmanager);
        shangPinAdapter = new ShopAdapter(R.layout.item_shangpin,list.getResult().getList());
        shangPinAdapter.addHeaderView(head_shangcheng);
        rec_shangcheng_shangpin.setAdapter(shangPinAdapter);
        shangPinAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("id",list.getResult().getList().get(position).getId());
                intent.putExtra("isJingXuan","是");
                intent.setClass(getActivity(),ShangPinDetailActivity.class);
                startActivity(intent);
            }
        });
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
//                initOkGO();
                smartrefreshlayout.finishRefresh(true);//传入false表示刷新失败
            }
        });
        //加载更多
        smartrefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                initAdd();
            }
        });
    }

    private void initAdd() {
        Map<String, String> map = new HashMap<>();
        map.put("page",String.valueOf(page++));
        map.put("tel",tel);
        map.put("id",id);
        map.put("token",token);
        map.put("pageSize","10");
        OkGo.<String>get(Contacts.URl2+"querySiftAndExpand")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        ShopGson shop = gson.fromJson(body, ShopGson.class);
                        if (shop.getResult().getList().size()>0){
                            shangPinAdapter.add(shop.getResult().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadmoreWithNoMoreData();
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initUI() {
        bt_xiaoxi = inflate.findViewById(R.id.bt_xiaoxi);
        bt_xiaoxi.setOnClickListener(this);
        inflate.findViewById(R.id.bt_shop_sousuo).setOnClickListener(this);
        inflate.findViewById(R.id.bt_gouwuche).setOnClickListener(this);
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_shangcheng_shangpin = inflate.findViewById(R.id.rec_shangcheng_shangpin);
        head_shangcheng = getLayoutInflater().inflate(R.layout.head_shangcheng, (ViewGroup) rec_shangcheng_shangpin.getParent(), false);
        head_shangcheng.findViewById(R.id.bt_shangpin_teyue).setOnClickListener(this);
        head_shangcheng.findViewById(R.id.bt_shangpin_dashi).setOnClickListener(this);
        head_shangcheng.findViewById(R.id.bt_shangpin_tehui).setOnClickListener(this);
        head_shangcheng.findViewById(R.id.bt_shangpin_leimu).setOnClickListener(this);
    }

    private void initbanner() {
        banner = head_shangcheng.findViewById(R.id.banner);
        //设置指示器位置
        banner.setIndicatorGravity(BannerConfig.CENTER);
        OkGo.<String>get(Contacts.URl1+"/setting/banner/2")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        BannerGson bannergson = gson.fromJson(body, BannerGson.class);
                        if (bannergson.getStatus()==1){
                            if (bannergson.getResult()!=null){
                                mbanner.clear();
                                for (int i = 0;i < bannergson.getResult().size();i++){
                                    mbanner.add(bannergson.getResult().get(i).getPictureUrl());
                                }
                            }
                            initBanner(mbanner);
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        ProgressBar.setVisibility(View.VISIBLE);
                        super.onStart(request);
                    }

                    private void initBanner(List<String> mbanner) {
                        //加载网络图片
                        banner.setImages(mbanner)
                                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                                .setImageLoader(new GlideImageLoader())
                                .start();
                    }
                });
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_shangpin_teyue:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),TeYuePinPaiActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_shangpin_dashi:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),DaShiZhuanChang.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_shangpin_tehui:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),TeHuiActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_shangpin_leimu:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),LeiMuActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_shop_sousuo:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),ShopSouSuoActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_gouwuche:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),GouWuCheActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_xiaoxi:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),XiaoXiActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            RongIM.getInstance().addUnReadMessageCountChangedObserver(this, conversationTypes);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCountChanged(int i) {
        if(i == 0){
            qBadgeView.hide(true);
        }else{
            qBadgeView.bindTarget(bt_xiaoxi).setBadgeNumber(i);
        }
    }
}
