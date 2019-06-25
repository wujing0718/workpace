package com.huohougongfu.app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.DaKa;
import com.huohougongfu.app.Gson.DaKaOne;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class DaKaActivity extends AppCompatActivity {

    private int id;
    private ImageView img1,img2,img3,img4,img5,img6,img7;
    private TextView tv_yidaka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_ka);
        id = MyApp.instance.getInt("id");
        initUI();
        initData();
    }

    private void initData() {
        OkGo.<String>post(Contacts.URl1+"/index/punch/info")
                .params("id",String.valueOf(id))
                .execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String body = response.body();
                Gson gson = new Gson();
                DaKa daKa = gson.fromJson(body, DaKa.class);
                if (daKa.getStatus() == 1){
                    if (daKa.getResult().getIsPunch() == 1 ){
                        findViewById(R.id.bt_daka).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtils.showShort("今日已打卡");
                            }
                        });
                        tv_yidaka.setVisibility(View.VISIBLE);
                    }else{
                        findViewById(R.id.bt_daka).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                initDaKa();
                            }
                        });
                        tv_yidaka.setVisibility(View.GONE);
                    }
                    if (daKa.getResult().getArr().get(0) == 0){
                        img1.setImageResource(R.mipmap.ic_launcher);
                    }else if (daKa.getResult().getArr().get(0) == 1){
                        img1.setImageResource(R.mipmap.img_back);
                    }
                    if (daKa.getResult().getArr().get(1) == 0){
                        img2.setImageResource(R.mipmap.ic_launcher);
                    }else if (daKa.getResult().getArr().get(1) == 1){
                        img2.setImageResource(R.mipmap.img_back);
                    }
                    if (daKa.getResult().getArr().get(2) == 0){
                        img3.setImageResource(R.mipmap.ic_launcher);
                    }else if (daKa.getResult().getArr().get(2) == 1){
                        img3.setImageResource(R.mipmap.img_back);
                    }
                    if (daKa.getResult().getArr().get(3) == 0){
                        img4.setImageResource(R.mipmap.ic_launcher);
                    }else if (daKa.getResult().getArr().get(3) == 1){
                        img4.setImageResource(R.mipmap.img_back);
                    }
                    if (daKa.getResult().getArr().get(4) == 0){
                        img5.setImageResource(R.mipmap.ic_launcher);
                    }else if (daKa.getResult().getArr().get(4) == 1){
                        img5.setImageResource(R.mipmap.img_back);
                    }
                    if (daKa.getResult().getArr().get(5) == 0){
                        img6.setImageResource(R.mipmap.ic_launcher);
                    }else if (daKa.getResult().getArr().get(5) == 1){
                        img6.setImageResource(R.mipmap.img_back);
                    }
                    if (daKa.getResult().getArr().get(6) == 0){
                        img7.setImageResource(R.mipmap.ic_launcher);
                    }else if (daKa.getResult().getArr().get(6) == 1){
                        img7.setImageResource(R.mipmap.img_back);
                    }
                }
            }
        });

    }

    private void initUI() {
        tv_yidaka = findViewById(R.id.tv_yidaka);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
                        String body = response.body();
                        Gson gson = new Gson();
                        DaKaOne daKa = gson.fromJson(body, DaKaOne.class);
                        if (daKa.getStatus() == 1){
                            if (daKa.getResult().get(0) == 0){
                                img1.setImageResource(R.mipmap.ic_launcher);
                            }else if (daKa.getResult().get(0) == 1){
                                img1.setImageResource(R.mipmap.img_back);
                            }
                            if (daKa.getResult().get(1) == 0){
                                img2.setImageResource(R.mipmap.ic_launcher);
                            }else if (daKa.getResult().get(1) == 1){
                                img2.setImageResource(R.mipmap.img_back);
                            }
                            if (daKa.getResult().get(2) == 0){
                                img3.setImageResource(R.mipmap.ic_launcher);
                            }else if (daKa.getResult().get(2) == 1){
                                img3.setImageResource(R.mipmap.img_back);
                            }
                            if (daKa.getResult().get(3) == 0){
                                img4.setImageResource(R.mipmap.ic_launcher);
                            }else if (daKa.getResult().get(3) == 1){
                                img4.setImageResource(R.mipmap.img_back);
                            }
                            if (daKa.getResult().get(4) == 0){
                                img5.setImageResource(R.mipmap.ic_launcher);
                            }else if (daKa.getResult().get(4) == 1){
                                img5.setImageResource(R.mipmap.img_back);
                            }
                            if (daKa.getResult().get(5) == 0){
                                img6.setImageResource(R.mipmap.ic_launcher);
                            }else if (daKa.getResult().get(5) == 1){
                                img6.setImageResource(R.mipmap.img_back);
                            }
                            if (daKa.getResult().get(6) == 0){
                                img7.setImageResource(R.mipmap.ic_launcher);
                            }else if (daKa.getResult().get(6) == 1){
                                img7.setImageResource(R.mipmap.img_back);
                            }
                        }
                    }
                });
    }
}
