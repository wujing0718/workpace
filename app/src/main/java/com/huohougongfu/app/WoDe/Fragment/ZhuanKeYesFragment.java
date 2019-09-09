package com.huohougongfu.app.WoDe.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ZhuanKeVIP;
import com.huohougongfu.app.Gson.ZhuanKeYes;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShopSouSuoActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.ZhuanKeYesAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanKeYesFragment extends Fragment implements OnClickListener{


    private View inflate;
    private String status;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_zhuanke;
    private View view_zhuanke;

    public ZhuanKeYesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_zhuan_ke_yes, container, false);
        status = getArguments().getString("ARGS");
        initUI();
        initData();
        return inflate;
    }

    private void initUI() {
        inflate.findViewById(R.id.bt_fenxiang_zhuanqian).setOnClickListener(this);
        view_zhuanke = inflate.findViewById(R.id.view_zhuanke);
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_zhuanke = inflate.findViewById(R.id.rec_zhuanke);
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("status",status);
        map.put("page",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        OkGo.<String>get(Contacts.URl1+"earn/showEarnMoneyListByStatus")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ZhuanKeYes zhuanKeYes = gson.fromJson(body, ZhuanKeYes.class);
                        if (zhuanKeYes.getStatus() == 1){
                            if (zhuanKeYes.getResult().getList().size()>0){
                                initRec(zhuanKeYes.getResult().getList());
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                            }else{
                                smartrefreshlayout.setVisibility(View.GONE);
                            }
                        }
                    }
                });
    }

    private void initRec(List<ZhuanKeYes.ResultBean.ListBean> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rec_zhuanke.setLayoutManager(layoutManager);
        ZhuanKeYesAdapter zhuanKeYesAdapter = new ZhuanKeYesAdapter(R.layout.item_my_collect,list);
        rec_zhuanke.setAdapter(zhuanKeYesAdapter);
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        ZhuanKeYesFragment fragment = new ZhuanKeYesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_fenxiang_zhuanqian:
                Intent intent = new Intent();
                intent.putExtra("type","赚客");
                intent.setClass(getActivity(), ShopSouSuoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
