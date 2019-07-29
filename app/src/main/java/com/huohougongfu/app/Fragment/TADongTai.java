package com.huohougongfu.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyDongTai;
import com.huohougongfu.app.QuanZi.Activity.QuanZiDetailActivity;
import com.huohougongfu.app.QuanZi.Activity.VedioDetailActivity;
import com.huohougongfu.app.QuanZi.Activity.WenZhangDetailActivity;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Activity.MyDongTaiActivity;
import com.huohougongfu.app.WoDe.Adapter.MyDongTaiAdapter;
import com.kongzue.dialog.v2.WaitDialog;
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


public class TADongTai extends Fragment {
    private static final String KEY ="Mid";
    private View inflate;
    private String mId;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_ta_dongtai;
    private MyDongTaiAdapter myDongTaiAdapter;
    private int page = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_tadong_tai, container, false);
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_ta_dongtai = inflate.findViewById(R.id.rec_ta_dongtai);
        mId = getArguments().getString(KEY);
        initData();
        return inflate;
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/my/dynamic")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        smartrefreshlayout.finishRefresh(true);//传入false表示刷新失败
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        MyDongTai dongtai = gson.fromJson(body, MyDongTai.class);
                        if (dongtai.getStatus() == 1){
                            initRec(dongtai.getResult().getList());
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(),"载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(List<MyDongTai.ResultBean.ListBean> list) {
        if (list.size()>0){
            smartrefreshlayout.setVisibility(View.VISIBLE);
            //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
            LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
            rec_ta_dongtai.setLayoutManager(layoutmanager);
            myDongTaiAdapter = new MyDongTaiAdapter(R.layout.item_wode_dongtai,list,getActivity());
            rec_ta_dongtai.setAdapter(myDongTaiAdapter);
            myDongTaiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (list.get(position).getType() == 2){
                        Intent intent = new Intent();
                        intent.putExtra("dId",list.get(position).getId());
                        startActivity(intent.setClass(getActivity(),WenZhangDetailActivity.class));
                    }else if(list.get(position).getType() == 1){
                        Intent intent = new Intent();
                        intent.putExtra("dId",list.get(position).getId());
                        startActivity(intent.setClass(getActivity(),QuanZiDetailActivity.class));
                    }else if (list.get(position).getType() == 3){
                        Intent intent = new Intent();
                        intent.putExtra("动态视频",list.get(position));
                        intent.putExtra("position",position);
                        intent.putExtra("dId",list.get(position).getId());
                        startActivity(intent.setClass(getActivity(),VedioDetailActivity.class));
                    }
                }
            });
            //刷新
            smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    initData();
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
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(page++));
        OkGo.<String>post(Contacts.URl1+"/my/dynamic")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyDongTai dongtai = gson.fromJson(body, MyDongTai.class);
                        if (dongtai.getStatus() == 1){
                            if (dongtai.getResult().getList().size()>0){
                                myDongTaiAdapter.add(dongtai.getResult().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else {
                                smartrefreshlayout. finishLoadMore();
                            }
                        }
                    }
                });
    }

    public static Fragment newInstance(String str){
        TADongTai fragment = new TADongTai();
        Bundle bundle = new Bundle();
        bundle.putString(KEY,str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
