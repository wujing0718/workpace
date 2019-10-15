package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;

public class FailedViewActivity extends AppCompatActivity implements View.OnClickListener {

    private String code;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed_view);
        intent = new Intent();
        code = getIntent().getStringExtra("code");
        initUI();
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_chongxinrenzheng).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_chongxinrenzheng:
                if (!utils.isDoubleClick()){
                    if ("茶师认证失败".equals(code)){
                        intent.setClass(FailedViewActivity.this,ChaShiRenZhengActivity.class);
                        startActivity(intent);
                    }else if ("商户认证失败".equals(code)){
                        intent.setClass(FailedViewActivity.this,ShangHuRenZhengActivity.class);
                        startActivity(intent);
                    }else{

                    }
                }
                break;
        }
    }
}
