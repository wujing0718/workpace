package com.huohougongfu.app.WoDe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.DingDanGuanLi;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.DingDanGuanLiAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class DingDanGuanLiFragment extends Fragment {


    private View inflate;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_dingdan_guanli;
    private String status;

    public DingDanGuanLiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_ding_dan_guan_li, container, false);
        status = getArguments().getString("ARGS");
        initUI();
        initData();
        return inflate;
    }

    private void initUI() {
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_dingdan_guanli = inflate.findViewById(R.id.rec_dingdan_guanli);
    }
    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
        map.put("status",status);
        OkGo.<String>get(Contacts.URl1+"order/orderManage/getOrderByStatus")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        DingDanGuanLi myCollect = gson.fromJson(body, DingDanGuanLi.class);
                        if (myCollect.getStatus() == 1){
                            if (myCollect.getResult().size()==0){
                                smartrefreshlayout.setVisibility(View.GONE);
                            }else{
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec(myCollect.getResult());
                            }
                        }
                    }
                });
    }

    private void initRec(List<DingDanGuanLi.ResultBean> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rec_dingdan_guanli.setLayoutManager(layoutManager);
        DingDanGuanLiAdapter dingDanGuanLiAdapter = new DingDanGuanLiAdapter(R.layout.item_dingdan_guanli, list);
        rec_dingdan_guanli.setAdapter(dingDanGuanLiAdapter);
    }


    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        DingDanGuanLiFragment fragment = new DingDanGuanLiFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
