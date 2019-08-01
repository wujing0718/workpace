package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.TeBieShuoMingActivity;
import com.huohougongfu.app.Utils.utils;

public class DianPuSettingActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_dianpu_name;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dian_pu_setting);
        intent = new Intent();
        initUI();
    }

    private void initUI() {
        edt_dianpu_name = findViewById(R.id.edt_dianpu_name);
        findViewById(R.id.bt_dianpu_renzheng).setOnClickListener(this);
        findViewById(R.id.bt_dianpu_tebieshuoming).setOnClickListener(this);
        findViewById(R.id.bt_dianpu_fuwuxuanxiang).setOnClickListener(this);
        findViewById(R.id.bt_dianpu_yunfei_setting).setOnClickListener(this);
        findViewById(R.id.bt_dianpu_manjian_youhui).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.bt_renzheng:
               if (!utils.isDoubleClick()){

               }
            break;
            case R.id.bt_dianpu_tebieshuoming:
                if (!utils.isDoubleClick()){
                    intent.setClass(DianPuSettingActivity.this,TeBieShuoMingActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_dianpu_fuwuxuanxiang:
                if (!utils.isDoubleClick()){
                    intent.setClass(DianPuSettingActivity.this,FuWuXuanXiangActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_dianpu_yunfei_setting:
                if (!utils.isDoubleClick()){
                    intent.setClass(DianPuSettingActivity.this,YunFeiSettingActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_dianpu_manjian_youhui:
                if (!utils.isDoubleClick()){
                    intent.setClass(DianPuSettingActivity.this,DianPuMainJianActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
        }
    }
}
