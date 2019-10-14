package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.huohougongfu.app.R;
import com.huohougongfu.app.SelectVideo.Utils;
import com.huohougongfu.app.Utils.utils;

public class WeiRenZhengActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wei_ren_zheng);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_renzheng).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_renzheng:
                if (!utils.isDoubleClick()){
                    Intent intent = new Intent();
                    intent.setClass(WeiRenZhengActivity.this,GeRenRenZhengActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
        }
    }
}
