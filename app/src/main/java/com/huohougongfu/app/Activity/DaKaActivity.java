package com.huohougongfu.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChaMi;
import com.huohougongfu.app.Gson.DaKa;
import com.huohougongfu.app.Gson.DaKaOne;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DaKaActivity extends AppCompatActivity {

    private int id;
    private ImageView img1,img2,img3,img4,img5,img6,img7;
    private String token;
    private TextView tv_chami_num;
    private String tel;
    private TextView bt_daka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_ka);
        id = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        tv_chami_num = findViewById(R.id.tv_chami_num);
        initUI();
        initChaMi();
        initData();
    }

    private void initChaMi() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(id));
        map.put("token",token);
        map.put("tel",tel);
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
                            tv_chami_num.setText(String.valueOf(chaMi.getResult().getMe()));
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                    }
                });
    }


    private void initData() {
        if (!"".equals(token)) {
            OkGo.<String>post(Contacts.URl1+"/index/punch/info")
                    .params("id",String.valueOf(id))
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            WaitDialog.dismiss();
                            String body = response.body();
                            Gson gson = new Gson();
                            DaKa daKa = gson.fromJson(body, DaKa.class);
                            if (daKa.getStatus() == 1){
                                if (daKa.getResult().getIsPunch() == 1 ){
                                    bt_daka.setText("已打卡");
                                    bt_daka.setClickable(false);
                                }else{
                                    bt_daka.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            initDaKa();
                                        }
                                    });
                                }
                                if (daKa.getResult().getArr().get(0) == 0){
                                    img1.setImageResource(R.mipmap.img_nodaka);
                                }else if (daKa.getResult().getArr().get(0) == 1){
                                    img1.setImageResource(R.mipmap.img_yiqiandao);
                                }
                                if (daKa.getResult().getArr().get(1) == 0){
                                    img2.setImageResource(R.mipmap.img_nodaka);
                                }else if (daKa.getResult().getArr().get(1) == 1){
                                    img2.setImageResource(R.mipmap.img_yiqiandao);
                                }
                                if (daKa.getResult().getArr().get(2) == 0){
                                    img3.setImageResource(R.mipmap.img_nodaka);
                                }else if (daKa.getResult().getArr().get(2) == 1){
                                    img3.setImageResource(R.mipmap.img_yiqiandao);
                                }
                                if (daKa.getResult().getArr().get(3) == 0){
                                    img4.setImageResource(R.mipmap.img_nodaka);
                                }else if (daKa.getResult().getArr().get(3) == 1){
                                    img4.setImageResource(R.mipmap.img_yiqiandao);
                                }
                                if (daKa.getResult().getArr().get(4) == 0){
                                    img5.setImageResource(R.mipmap.img_nodaka);
                                }else if (daKa.getResult().getArr().get(4) == 1){
                                    img5.setImageResource(R.mipmap.img_yiqiandao);
                                }
                                if (daKa.getResult().getArr().get(5) == 0){
                                    img6.setImageResource(R.mipmap.img_nodaka);
                                }else if (daKa.getResult().getArr().get(5) == 1){
                                    img6.setImageResource(R.mipmap.img_yiqiandao);
                                }
                                if (daKa.getResult().getArr().get(6) == 0){
                                    img7.setImageResource(R.mipmap.img_nodaka);
                                }else if (daKa.getResult().getArr().get(6) == 1){
                                    img7.setImageResource(R.mipmap.img_yiqiandao);
                                }
                            }
                        }

                        @Override
                        public void onStart(Request<String, ? extends Request> request) {
                            WaitDialog.show(DaKaActivity.this,"请稍后。。。");
                            super.onStart(request);
                        }
                    });
        }else{
            ToastUtils.showShort(R.string.denglu);
            WaitDialog.dismiss();
        }

    }

    private void initUI() {
        findViewById(R.id.bt_tea_guize).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(DaKaActivity.this,TeaRuleActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt_daka = findViewById(R.id.bt_daka);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);

    }

    private void initDaKa() {
        OkGo.<String>get(Contacts.URl1+"/index/punch/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                bt_daka.setText("已打卡");
                                Gson gson = new Gson();
                                DaKaOne daKa = gson.fromJson(body, DaKaOne.class);
                                if (daKa.getStatus() == 1){
                                    if (daKa.getResult().get(0) == 0){
                                        img1.setImageResource(R.mipmap.img_nodaka);
                                    }else if (daKa.getResult().get(0) == 1){
                                        img1.setImageResource(R.mipmap.img_yiqiandao);
                                    }
                                    if (daKa.getResult().get(1) == 0){
                                        img2.setImageResource(R.mipmap.img_nodaka);
                                    }else if (daKa.getResult().get(1) == 1){
                                        img2.setImageResource(R.mipmap.img_yiqiandao);
                                    }
                                    if (daKa.getResult().get(2) == 0){
                                        img3.setImageResource(R.mipmap.img_nodaka);
                                    }else if (daKa.getResult().get(2) == 1){
                                        img3.setImageResource(R.mipmap.img_yiqiandao);
                                    }
                                    if (daKa.getResult().get(3) == 0){
                                        img4.setImageResource(R.mipmap.img_nodaka);
                                    }else if (daKa.getResult().get(3) == 1){
                                        img4.setImageResource(R.mipmap.img_yiqiandao);
                                    }
                                    if (daKa.getResult().get(4) == 0){
                                        img5.setImageResource(R.mipmap.img_nodaka);
                                    }else if (daKa.getResult().get(4) == 1){
                                        img5.setImageResource(R.mipmap.img_yiqiandao);
                                    }
                                    if (daKa.getResult().get(5) == 0){
                                        img6.setImageResource(R.mipmap.img_nodaka);
                                    }else if (daKa.getResult().get(5) == 1){
                                        img6.setImageResource(R.mipmap.img_yiqiandao);
                                    }
                                    if (daKa.getResult().get(6) == 0){
                                        img7.setImageResource(R.mipmap.img_nodaka);
                                    }else if (daKa.getResult().get(6) == 1){
                                        img7.setImageResource(R.mipmap.img_yiqiandao);
                                    }
                                }
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(DaKaActivity.this,"请稍后。。。");
                        super.onStart(request);
                    }
                });
    }
}
