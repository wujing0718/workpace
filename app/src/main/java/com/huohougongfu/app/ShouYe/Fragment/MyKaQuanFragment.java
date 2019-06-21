package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChaQuan;
import com.huohougongfu.app.Gson.MyCaQuan;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.MyKaQuanAdapter;
import com.huohougongfu.app.ShouYe.Adapter.ShouDaoAdapter;
import com.huohougongfu.app.ShouYe.Adapter.WoDeAdapter;
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
public class MyKaQuanFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_kaquan_wode,rec_kaquan_shoudao;
    private String token,tel,id;

    public MyKaQuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_my_ka_quan, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        initData();
        return inflate;
    }
    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("id",id);
        map.put("token",token);
        map.put("type","enableSend");
        OkGo.<String>post(Contacts.URl1+"/wallet/coupons")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        MyCaQuan chaQuan = gson.fromJson(response.body(), MyCaQuan.class);
                        if (chaQuan.getStatus() == 1) {
                            initRecWoDe(chaQuan.getResult());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRecWoDe(List<MyCaQuan.ResultBean> result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        //设置RecyclerView 布局
        rec_kaquan_wode.setLayoutManager(layoutmanager);
        MyKaQuanAdapter wodeadapter = new MyKaQuanAdapter(R.layout.item_wodekaquan,result);
        rec_kaquan_wode.setAdapter(wodeadapter);

    }


    private void initUI() {
        rec_kaquan_wode = inflate.findViewById(R.id.rec_kaquan_wode);
    }

    public static Fragment newInstance(String str){
        MyKaQuanFragment fragment = new MyKaQuanFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
