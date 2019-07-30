package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;

public class MyDianPuActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dian_pu);
        intent = new Intent();
        initUI();
    }

    private void initUI() {
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
        }
    }
}
