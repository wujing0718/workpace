package com.huohougongfu.app.Shop.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShangPinAdapter;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.ShopGson;
import com.huohougongfu.app.Gson.TeiHuiGson;
import com.huohougongfu.app.PopupView.ShaiXuanDrawerPopupView;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Adapter.TeHuiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
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
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SouSuoShopFragment extends Fragment implements View.OnClickListener ,IListener {


    private View inflate;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_sousuo_shangpin;
    private int page = 2;
    private TeHuiAdapter teHuiAdapter;

    public SouSuoShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListenerManager.getInstance().registerListtener(this);
        inflate = inflater.inflate(R.layout.fragment_sou_suo_shop, container, false);
        initUI();
        initData();
        return inflate;
    }

    private void initUI() {
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_sousuo_shangpin = inflate.findViewById(R.id.rec_sousuo_shangpin);
        inflate.findViewById(R.id.bt_sousuo_shaixuan).setOnClickListener(this);
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("page","1");
        map.put("pageSize","10");
        OkGo.<String>get(Contacts.URl2+"query/queryProductList")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        TeiHuiGson shop = gson.fromJson(response.body(), TeiHuiGson.class);
                        if (shop.getStatus() == 1) {
                            initRec(shop.getResult());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(TeiHuiGson.ResultBean data) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(getActivity(),2);
        //设置RecyclerView 布局
        rec_sousuo_shangpin.setLayoutManager(layoutmanager);
        teHuiAdapter = new TeHuiAdapter(R.layout.item_shangpin,data.getList());
        rec_sousuo_shangpin.setAdapter(teHuiAdapter);
        teHuiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
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
        map.put("page","1");
        map.put("pageSize",String.valueOf(page++));
        OkGo.<String>get(Contacts.URl2+"query/queryProductList")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        TeiHuiGson shop = gson.fromJson(response.body(), TeiHuiGson.class);
                        if (shop.getResult().getList().size()>0){
                            teHuiAdapter.add(shop.getResult().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadmoreWithNoMoreData();
                        }
                    }
                });
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        SouSuoShopFragment fragment = new SouSuoShopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_sousuo_shaixuan:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(getContext())
                            .popupPosition(PopupPosition.Right)//右边
                            .asCustom(new ShaiXuanDrawerPopupView(getContext()))
                            .show();
                }
                break;
        }
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 0){
            Log.e("==================",status);
        }
    }
}
