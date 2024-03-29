package com.huohougongfu.app.Shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.blankj.utilcode.util.KeyboardUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.DiaPuZhuYeActivity;
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Gson.BannerGson;
import com.huohougongfu.app.Gson.DSZhuanChang;
import com.huohougongfu.app.Gson.WeiDuXiaoXI;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.DaShiLikeAdapter;
import com.huohougongfu.app.Shop.Adapter.QuanBuDaShiAdapter;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.imkit.RongIM;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imlib.model.Conversation;
import q.rorbin.badgeview.QBadgeView;

public class DaShiZhuanChang extends AppCompatActivity implements IUnReadMessageObserver {

    private Banner banner;
    private List<Integer> mlist = new ArrayList<>();
    private RecyclerView rec_cainixihuan,rec_dashizhuanchang;
    private EditText bt_dashi_sousuo;
    private View head_dashizhuanchang;
    private List<String> mbanner = new ArrayList<>();
    private List<String> mbannerimg = new ArrayList<>();
    private InputMethodManager manager;
    private SmartRefreshLayout smartrefreshlayout;
    private QuanBuDaShiAdapter quanBuDaShiAdapter;
    private int page =2;
    private Intent intent;
    private QBadgeView qBadgeView;
    final Conversation.ConversationType[] conversationTypes = {
            Conversation.ConversationType.PRIVATE,
            Conversation.ConversationType.GROUP, Conversation.ConversationType.SYSTEM,
            Conversation.ConversationType.PUBLIC_SERVICE, Conversation.ConversationType.APP_PUBLIC_SERVICE
    };
    private View bt_xiaoxi;
    private View bt_gouwuche;
    private String token;
    private QBadgeView qbadgebiewxitong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_shi_zhuan_chang);
        qBadgeView = new QBadgeView(DaShiZhuanChang.this);
        qbadgebiewxitong = new QBadgeView(DaShiZhuanChang.this);
        manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        token = MyApp.instance.getString("token");
        intent = new Intent();
        initUI();
        initData("");
        initbanner();
    }

    @Override
    protected void onResume() {
        RongIM.getInstance().addUnReadMessageCountChangedObserver(this, conversationTypes);
        initShoppingCartNum();
        initNoticeIsView();
        super.onResume();
    }

    private void initNoticeIsView() {
        OkGo.<String>post(Contacts.URl1+"/circle/noticeIsView")
                .params("mId",String.valueOf(MyApp.instance.getInt("id")))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        WeiDuXiaoXI weiduxiaoxi = new Gson().fromJson(body, WeiDuXiaoXI.class);
                        if (weiduxiaoxi.getStatus() == 1){
                            if (weiduxiaoxi.getResult().isComments() || weiduxiaoxi.getResult().isJg() || weiduxiaoxi.getResult().isPraise()){
                                qbadgebiewxitong.bindTarget(bt_xiaoxi).setGravityOffset(8,true).setBadgeText("");
                            }else{
                                qbadgebiewxitong.hide(true);
                            }
                        }
                    }
                });
    }


    private void initUI() {
        rec_dashizhuanchang = findViewById(R.id.rec_dashizhuanchang);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        head_dashizhuanchang = getLayoutInflater().inflate(R.layout.head_dashizhuanchang, (ViewGroup) rec_dashizhuanchang.getParent(), false);
        rec_cainixihuan = head_dashizhuanchang.findViewById(R.id.rec_cainixihuan);
        banner = head_dashizhuanchang.findViewById(R.id.banner);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_dashi_sousuo = findViewById(R.id.bt_dashi_sousuo);

        if (!KeyboardUtils.isSoftInputVisible(this)){
            KeyboardUtils.showSoftInput(this);
        }else{
            KeyboardUtils.hideSoftInput(this);
        }
        bt_dashi_sousuo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(bt_dashi_sousuo.getApplicationWindowToken(), 0);
                    }
                    //自己需要的操作
                    String sousuo = bt_dashi_sousuo.getText().toString();
                    if (sousuo.isEmpty()){
                        initData(sousuo);
                    }else{
                        initData(sousuo);
                    }
                }
                //记得返回false
                return false;
            }
        });
        bt_xiaoxi = findViewById(R.id.bt_xiaoxi);

        bt_xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!utils.isDoubleClick()){
                        intent.setClass(DaShiZhuanChang.this,XiaoXiActivity.class);
                        startActivity(intent);
                }
            }
        });
        bt_gouwuche = findViewById(R.id.bt_gouwuche);
        bt_gouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!utils.isDoubleClick()){
                    intent.setClass(DaShiZhuanChang.this,GouWuCheActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void initShoppingCartNum() {
        OkGo.<String>post(Contacts.URl1+"/cartNum")
                .params("mId",String.valueOf(MyApp.instance.getInt("id")))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        QBadgeView qBadgeView = new QBadgeView(DaShiZhuanChang.this);
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                qBadgeView.bindTarget(bt_gouwuche).setBadgeNumber(jsonObject.getInt("result"));
                            }else{
                                qBadgeView.hide(true);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


    private void initData(String sousuo) {
        Map<String,String> map = new HashMap<>();
        map.put("page","1");
        map.put("pageSize","10");
        if (!"".equals(sousuo)){
            map.put("name",sousuo);
        }
        OkGo.<String>get(Contacts.URl2+"query/master/masterOwn")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        DSZhuanChang shangPinGson = gson.fromJson(response.body(), DSZhuanChang.class);
                        if (shangPinGson.getStatus() == 1) {
                            if (!sousuo.isEmpty() && shangPinGson.getResult().getAllMaster().getList().size()==0){
                                smartrefreshlayout.setVisibility(View.GONE);
                            }else if (!sousuo.isEmpty()){
                                initRec2(shangPinGson.getResult().getAllMaster().getList(),sousuo);
                            }else{
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec2(shangPinGson.getResult().getAllMaster().getList(),sousuo);
                                initRec(shangPinGson.getResult().getYourLike());
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        WaitDialog.dismiss();
                        super.onError(response);
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(DaShiZhuanChang.this, "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initbanner() {
//设置指示器位置
        banner.setIndicatorGravity(BannerConfig.CENTER);
        OkGo.<String>get(Contacts.URl1+"/setting/banner/4")
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

    private void initRec(List<DSZhuanChang.ResultBean.YourLikeBean> yourLike) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置RecyclerView 布局
        rec_cainixihuan.setLayoutManager(layoutmanager);
        DaShiLikeAdapter daShiLikeAdapter = new DaShiLikeAdapter(R.layout.item_shop_cainixihuan,yourLike);
        rec_cainixihuan.setAdapter(daShiLikeAdapter);
        daShiLikeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                intent.putExtra("id",String.valueOf(yourLike.get(position).getMId()));
                intent.setClass(DaShiZhuanChang.this,DiaPuZhuYeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initRec2(List<DSZhuanChang.ResultBean.AllMasterBean.ListBean> allMaster, String sousuo) {
        if (sousuo.isEmpty()){
            //BUG
            ViewGroup parentViewGroup = (ViewGroup) head_dashizhuanchang.getParent();
            if (parentViewGroup != null) {
                parentViewGroup.removeAllViews();
            }
            //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
            LinearLayoutManager layoutmanager = new LinearLayoutManager(DaShiZhuanChang.this){
                @Override
                public boolean canScrollHorizontally() {
                    return false;
                }
            };
            layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
            //设置RecyclerView 布局
            rec_dashizhuanchang.setLayoutManager(layoutmanager);
            quanBuDaShiAdapter = new QuanBuDaShiAdapter(R.layout.item_dashizhuanchang,allMaster);
            quanBuDaShiAdapter.addHeaderView(head_dashizhuanchang);
            rec_dashizhuanchang.setAdapter(quanBuDaShiAdapter);
        }else{
            quanBuDaShiAdapter = new QuanBuDaShiAdapter(R.layout.item_dashizhuanchang,allMaster);
            rec_dashizhuanchang.setAdapter(quanBuDaShiAdapter);
        }
        quanBuDaShiAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                int dashimid = allMaster.get(position).getMId();
                int dashiid = allMaster.get(position).getId();
                switch (view.getId()){
                    case R.id.bt_dashi_jianjie:
                        intent.putExtra("id",String.valueOf(dashiid));
                        intent.setClass(DaShiZhuanChang.this,DaShiJianJieActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.bt_dashi_zhuye:
                        intent.putExtra("id",String.valueOf(dashimid));
                        intent.setClass(DaShiZhuanChang.this,DiaPuZhuYeActivity.class);
                        startActivity(intent);
                        break;
                }

            }
        });
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData("");
                smartrefreshlayout.finishRefresh(true);//传入false表示刷新失败
            }
        });
        //加载更多
        smartrefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                initAdd(sousuo);
            }
        });
    }

    private void initAdd(String sousuo) {
        Map<String,String> map = new HashMap<>();
        map.put("page",String.valueOf(page++));
        map.put("pageSize","10");
        if (!"".equals(sousuo)){
            map.put("name",sousuo);
        }
        OkGo.<String>get(Contacts.URl2+"query/master/masterOwn")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        DSZhuanChang shangPinGson = gson.fromJson(response.body(), DSZhuanChang.class);
                        if (shangPinGson.getStatus() == 1) {
                            if (shangPinGson.getResult().getAllMaster().getList().size()>0){
                                quanBuDaShiAdapter.add(shangPinGson.getResult().getAllMaster().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else {
                                smartrefreshlayout. finishLoadMore();
                            }
                        }
                    }
                });
    }
    @Override
    public void onCountChanged(int i) {
        if(i == 0){
            qbadgebiewxitong.hide(true);
        }else{
            qbadgebiewxitong.bindTarget(bt_xiaoxi).setGravityOffset(8,true).setBadgeText("");
        }
    }
}
