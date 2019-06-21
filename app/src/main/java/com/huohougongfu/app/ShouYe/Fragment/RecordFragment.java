package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.KaQuanRecord;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.RecordAdapter;
import com.huohougongfu.app.ShouYe.Adapter.SongChuAdapter;
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
public class RecordFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_kaquan_record;
    private String token,tel,id;
    private RecyclerView rec_shixiao,rec_songchu;

    public RecordFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_record, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        initData();
        return inflate;
    }
    private void initUI() {
        rec_shixiao = inflate.findViewById(R.id.rec_shixiao);
        rec_songchu = inflate.findViewById(R.id.rec_songchu);
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("id",id);
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/wallet/coupons/invalid")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        KaQuanRecord record = gson.fromJson(body, KaQuanRecord.class);
                        if (record.getStatus() ==1){
                            initSongChu(record.getResult());
                            initShiXiao(record.getResult());

                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initShiXiao(KaQuanRecord.ResultBean result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_shixiao.setLayoutManager(layoutmanager);
        RecordAdapter wodeadapter = new RecordAdapter(R.layout.item_shoudaokaquan,result.getInvalid());
        rec_shixiao.setAdapter(wodeadapter);
    }

    private void initSongChu(KaQuanRecord.ResultBean result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_songchu.setLayoutManager(layoutmanager);
        SongChuAdapter songchu= new SongChuAdapter(R.layout.item_shoudaokaquan,result.getSend());
        rec_songchu.setAdapter(songchu);
    }

    public static Fragment newInstance(String str){
        RecordFragment fragment = new RecordFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
