package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChaMi;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
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
public class ChaMiNumFragment extends Fragment {


    private View inflate;
    private TextView tv_chami_wode,tv_chami_send,tv_chami_price,tv_chami_zong,tv_yongjin,tv_shouru;
    private String token,tel,id;

    public ChaMiNumFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_cha_mi_num, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        return inflate;
    }

    @Override
    public void onResume() {
        initData();
        super.onResume();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("mId",id);
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/wallet/teaRice")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        ChaMi chaMi = gson.fromJson(body, ChaMi.class);
                        if (chaMi.getStatus() == 1){
                            initView(chaMi);
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initView(ChaMi chaMi) {
        tv_chami_wode.setText(String.valueOf(chaMi.getResult().getMe()+"粒"));
        tv_chami_send.setText(String.valueOf(chaMi.getResult().getSent()+"粒"));
        tv_chami_zong.setText(String.valueOf(chaMi.getResult().getMe()+chaMi.getResult().getSent()+"粒"));
        tv_yongjin.setText(String.valueOf(chaMi.getResult().getCommission()+"元"));
        tv_shouru.setText(String.valueOf(chaMi.getResult().getIncome()+"元"));
        tv_chami_price.setText(String.valueOf(chaMi.getResult().getCommission()+chaMi.getResult().getIncome()+"元"));
    }

    private void initUI() {
        tv_chami_wode = inflate.findViewById(R.id.tv_chami_wode);
        tv_chami_send = inflate.findViewById(R.id.tv_chami_send);
        tv_chami_price = inflate.findViewById(R.id.tv_chami_price);
        tv_chami_zong = inflate.findViewById(R.id.tv_chami_zong);
        tv_yongjin = inflate.findViewById(R.id.tv_yongjin);
        tv_shouru = inflate.findViewById(R.id.tv_shouru);

    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        ChaMiNumFragment fragment = new ChaMiNumFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
