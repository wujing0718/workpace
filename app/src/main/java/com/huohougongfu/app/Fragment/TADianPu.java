package com.huohougongfu.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ShopGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Adapter.ShopAdapter;
import com.huohougongfu.app.ShouYe.Fragment.ChaTaiOneFragment;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zyf.vc.common.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class TADianPu extends Fragment {

    private static final String KEY ="Mid";
    private View inflate;
    private String mId;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_ta_dianpu;
    private ShopAdapter shangPinAdapter;
    private int page = 2;
    public TADianPu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_tadian_pu, container, false);
        mId = getArguments().getString(KEY);
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_ta_dianpu = inflate.findViewById(R.id.rec_ta_dianpu);
        initData();
        return inflate;
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",mId);
        map.put("pageNo","1");
        map.put("pageSize","10");
        OkGo.<String>post(Contacts.URl1+"/my/store")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ShopGson shop = gson.fromJson(body, ShopGson.class);
                        if (shop.getStatus() == 1){
                            initRec(shop);
                        }
                    }
                });
    }

    private void initRec(ShopGson shop) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(getActivity(),2);
        //设置RecyclerView 布局
        rec_ta_dianpu.setLayoutManager(layoutmanager);
        if (shop.getResult().getList().size()>0){
            smartrefreshlayout.setVisibility(View.VISIBLE);
            shangPinAdapter = new ShopAdapter(R.layout.item_shangpin,shop.getResult().getList());
            rec_ta_dianpu.setAdapter(shangPinAdapter);
            shangPinAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent intent = new Intent();
                    intent.putExtra("userid",mId);
                    intent.putExtra("id",shop.getResult().getList().get(position).getId());
                    intent.setClass(getActivity(),ShangPinDetailActivity.class);
                    startActivity(intent);
                }
            });

            //刷新
            smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    initData();
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
        }else{
            smartrefreshlayout.setVisibility(View.GONE);
        }
    }

    private void initAdd() {
        Map<String, String> map = new HashMap<>();
        map.put("mId",mId);
        map.put("page",String.valueOf(page++));
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


    public static Fragment newInstance(String str){
        TADianPu fragment = new TADianPu();
        Bundle bundle = new Bundle();
        bundle.putString(KEY,str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
