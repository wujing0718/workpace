package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyDianPu;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

public class MyDianPuActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private TextView tv_visitNum,tv_visitNumOfDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dian_pu);
        intent = new Intent();
        initUI();
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("token",MyApp.instance.getString("token"));
        map.put("phone",MyApp.instance.getString("phone"));
        OkGo.<String>get(Contacts.URl1+"order/getStoreVisitNum")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyDianPu myDianPu = gson.fromJson(body, MyDianPu.class);
                        if (myDianPu.getStatus() == 1){
                            if (myDianPu.getResult()!=null){
                                tv_visitNum.setText(String.valueOf(myDianPu.getResult().getVisitNum()));
                                tv_visitNumOfDay.setText(String.valueOf(myDianPu.getResult().getVisitNumOfDay()));
                            }
                        }
                    }
                });
    }

    private void initUI() {
        tv_visitNum = findViewById(R.id.tv_visitNum);
        tv_visitNumOfDay = findViewById(R.id.tv_visitNumOfDay);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_my_dianpu_shopguanli).setOnClickListener(this);
        findViewById(R.id.bt_my_dianpu_dingdanguanli).setOnClickListener(this);
        findViewById(R.id.bt_my_dianpu_shoppingjia).setOnClickListener(this);
        findViewById(R.id.bt_my_dianpu_tongji).setOnClickListener(this);
        findViewById(R.id.bt_my_dianpu_setting).setOnClickListener(this);
        findViewById(R.id.bt_my_dianpu_zhiyin).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
            case R.id.bt_my_dianpu_shopguanli:
                if (!utils.isDoubleClick()){
                    intent.setClass(MyDianPuActivity.this,ShopGuanLIActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_my_dianpu_dingdanguanli:
                if (!utils.isDoubleClick()){
                    intent.setClass(MyDianPuActivity.this,DingDanGuanLi.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_my_dianpu_shoppingjia:
                if (!utils.isDoubleClick()){
                    intent.setClass(MyDianPuActivity.this,ShopPingJiaActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_my_dianpu_tongji:
                if (!utils.isDoubleClick()){
                    intent.setClass(MyDianPuActivity.this,DianPuTongJiActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_my_dianpu_setting:
                if (!utils.isDoubleClick()){
                    intent.setClass(MyDianPuActivity.this,DianPuSettingActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
