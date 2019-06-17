package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.ShouDaoAdapter;
import com.huohougongfu.app.ShouYe.Adapter.WoDeAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyKaQuanFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_kaquan_wode,rec_kaquan_shoudao;

    public MyKaQuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_my_ka_quan, container, false);
        initUI();
        initData();
        return inflate;
    }
    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("service","App.Mixed_Jinse.Zx");
        map.put("channel", "www");
        OkGo.<String>post(Contacts.URl)
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        ShangPinGson shangPinGson = gson.fromJson(response.body(), ShangPinGson.class);
                        if (shangPinGson.getCode() == 200) {
                            initRecShouDao(shangPinGson.getData());
                            initRecWoDe(shangPinGson.getData());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRecWoDe(ShangPinGson.DataBean data) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        //设置RecyclerView 布局
        rec_kaquan_wode.setLayoutManager(layoutmanager);
        WoDeAdapter wodeadapter = new WoDeAdapter(R.layout.item_wodekaquan,data.getList());
        rec_kaquan_wode.setAdapter(wodeadapter);

    }

    private void initRecShouDao(ShangPinGson.DataBean data) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        //设置RecyclerView 布局
        rec_kaquan_shoudao.setLayoutManager(layoutmanager);
        ShouDaoAdapter shouDaoAdapter = new ShouDaoAdapter(R.layout.item_shoudaokaquan,data.getList());
        rec_kaquan_shoudao.setAdapter(shouDaoAdapter);
    }

    private void initUI() {
        rec_kaquan_wode = inflate.findViewById(R.id.rec_kaquan_wode);
        rec_kaquan_shoudao = inflate.findViewById(R.id.rec_kaquan_shoudao);

    }

    public static Fragment newInstance(String str){
        MyKaQuanFragment fragment = new MyKaQuanFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
