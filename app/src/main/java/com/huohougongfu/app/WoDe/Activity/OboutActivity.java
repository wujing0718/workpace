package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;

public class OboutActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obout);
        intent = new Intent();
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_gongnengjieshao).setOnClickListener(this);
        findViewById(R.id.bt_banbengengxin).setOnClickListener(this);
        findViewById(R.id.bt_yijianfankui).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
            case R.id.bt_gongnengjieshao:
                if (!utils.isDoubleClick()){
                    intent.setClass(OboutActivity.this,GongNengJieShao.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_banbengengxin:
                if (!utils.isDoubleClick()){

                }
                break;
            case R.id.bt_yijianfankui:
                if (!utils.isDoubleClick()){
                    intent.setClass(OboutActivity.this,FanKuiActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
