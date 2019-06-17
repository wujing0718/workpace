package com.huohougongfu.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;

public class XieYiActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xie_yi);
        intent = new Intent();
        initUI();
    }

    private void initUI() {
        findViewById(R.id.bt_yinsi).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_yinsi:
                if (!utils.isDoubleClick()){
                    intent.setClass(XieYiActivity.this,YinSiActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
        }
    }
}
