package com.huohougongfu.app.Shop.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShangPinAdapter;
import com.huohougongfu.app.Gson.PingJia;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Adapter.PingJiaAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class PingJiaFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_detail_pingjia;
    private String token,tel,id;
    private int shopid;

    public PingJiaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_ping_jia, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        shopid = getArguments().getInt("id");
        initUI();
        initData();
        return inflate;
    }

    private void initUI() {
        rec_detail_pingjia = inflate.findViewById(R.id.rec_detail_pingjia);
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("id",String.valueOf(44));
        map.put("page","1");
        OkGo.<String>get(Contacts.URl1+"/selectAppraise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        PingJia shangPinGson = gson.fromJson(response.body(), PingJia.class);
                        if (shangPinGson.getStatus() == 1) {
                            initRec(shangPinGson.getResult().getList());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(List<PingJia.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_detail_pingjia.setLayoutManager(layoutmanager);
        PingJiaAdapter pingjiaadapter = new PingJiaAdapter(R.layout.item_detail_pingjia,list);
        rec_detail_pingjia.setAdapter(pingjiaadapter);
//        pingjiaadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Intent intent = new Intent();
//                intent.setClass(getActivity(),ShangPinDetailActivity.class);
//                startActivity(intent);
//            }
//        });
    }


    public static Fragment newInstance(int str){
        PingJiaFragment fragment = new PingJiaFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
