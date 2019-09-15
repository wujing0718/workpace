package com.huohougongfu.app.Shop.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.DiaPuZhuYeActivity;
import com.huohougongfu.app.Adapter.ShangPinAdapter;
import com.huohougongfu.app.Gson.DaShi;
import com.huohougongfu.app.Gson.DaShiSouSuo;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.SouSuoShopGson;
import com.huohougongfu.app.Gson.ZhaoRenGson;
import com.huohougongfu.app.PopupView.DianPuShaiXunPopup;
import com.huohougongfu.app.PopupView.ShaiXuanDaShiView;
import com.huohougongfu.app.PopupView.ShaiXuanDrawerPopupView;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Adapter.DaShiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SouSuoDaShiFragment extends Fragment implements IListener ,View.OnClickListener {


    private View inflate;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_sousuo_dashi;
    private  String indexParams = "0";
    private TextView bt_dashi_zonghe,bt_dashi_renqi;
    private String name;
    private DaShiAdapter shangPinAdapter;
    private int page =2;
    private BasePopupView xpopup;

    public SouSuoDaShiFragment() {
    }

    private Map<String, String> map = new HashMap<>();
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    map = (Map<String,String>)msg.obj;
                    initData(map);
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListenerManager.getInstance().registerListtener(this);
        inflate = inflater.inflate(R.layout.fragment_sou_suo_da_shi, container, false);
        xpopup = new XPopup.Builder(getContext())
                .popupPosition(PopupPosition.Right)//右边
                .asCustom(new ShaiXuanDaShiView(getContext(),mHandler));
        initUI();
        initData(map);
        return inflate;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void initUI() {
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_sousuo_dashi = inflate.findViewById(R.id.rec_sousuo_dashi);
        inflate.findViewById(R.id.bt_dashi_shaixuan).setOnClickListener(this);
        bt_dashi_zonghe = inflate.findViewById(R.id.bt_dashi_zonghe);
        bt_dashi_zonghe.setOnClickListener(this);
        bt_dashi_renqi = inflate.findViewById(R.id.bt_dashi_renqi);
        bt_dashi_renqi.setOnClickListener(this);
    }

    private void initData(Map<String,String> map1) {
        Map<String, String> map = new HashMap<>();
        map.clear();
        map.putAll(map1);
        map.put("page","1");
        map.put("pageSize","10");
        map.put("indexParams",indexParams);
        if (name!=null){
            map.put("name",name);
        }
        OkGo.<String>get(Contacts.URl2+"query/filter/queryMaster")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        DaShiSouSuo dashi = gson.fromJson(response.body(), DaShiSouSuo.class);
                        if (dashi.getStatus() == 1) {
                            if (dashi.getResult().getList().size()>0){
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec(dashi.getResult());
                            }else{
                                smartrefreshlayout.setVisibility(View.GONE);
                            }
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(DaShiSouSuo.ResultBean result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_sousuo_dashi.setLayoutManager(layoutmanager);
        shangPinAdapter = new DaShiAdapter(R.layout.item_shop_sousuo_dashi, result.getList());
        rec_sousuo_dashi.setAdapter(shangPinAdapter);
        shangPinAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("id",String.valueOf(result.getList().get(position).getId()));
                intent.setClass(getActivity(),DiaPuZhuYeActivity.class);
                startActivity(intent);
            }
        });
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                map.clear();
                initData(map);
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
        map.put("page",String.valueOf(page++));
        map.put("pageSize","10");
        map.put("indexParams",indexParams);
        if (name!=null){
            map.put("name",name);
        }
        OkGo.<String>get(Contacts.URl2+"query/filter/queryMaster")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        DaShiSouSuo dashi = gson.fromJson(response.body(), DaShiSouSuo.class);
                        if (dashi.getResult().getList().size()>0){
                            shangPinAdapter.add(dashi.getResult().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadmoreWithNoMoreData();
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    public static Fragment newInstance(String sousuo, String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        SouSuoDaShiFragment fragment = new SouSuoDaShiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            if (name!=null){
                initData(map);
            }
        }
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 0){
            name = status;
            if (getUserVisibleHint()){
                initData(map);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_dashi_zonghe:
                bt_dashi_zonghe.setTextColor(getResources().getColor(R.color.sousuoTab));
                bt_dashi_renqi.setTextColor(getResources().getColor(R.color.colorBlack));
                indexParams = "0";
                initData(map);
                break;
            case R.id.bt_dashi_renqi:
                bt_dashi_zonghe.setTextColor(getResources().getColor(R.color.colorBlack));
                bt_dashi_renqi.setTextColor(getResources().getColor(R.color.sousuoTab));
                indexParams = "1";
                initData(map);
                break;
            case R.id.bt_dashi_shaixuan:
                if (!utils.isDoubleClick()){
                    xpopup.show();
                }
                break;
        }
    }
}
