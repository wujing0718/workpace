package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huohougongfu.app.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        intent = new Intent();
        initUI();
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_bianji).setOnClickListener(this);
        findViewById(R.id.bt_shouhuodizhi).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:

                finish();
                break;
            case R.id.bt_shouhuodizhi:
                intent.setClass(SettingActivity.this,AddressActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.bt_bianji:
                intent.setClass(SettingActivity.this,PersonalActivity.class);
                startActivity(intent);
                break;
        }
    }
}
