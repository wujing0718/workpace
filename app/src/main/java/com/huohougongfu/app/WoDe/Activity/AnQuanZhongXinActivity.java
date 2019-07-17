package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

public class AnQuanZhongXinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_quan_zhong_xin);
        TextView tv_phone = findViewById(R.id.tv_phone);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.bt_xiugaimima).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AnQuanZhongXinActivity.this,XiuGaiMiMaActivity.class);
                startActivity(intent);
            }
        });
        tv_phone.setText(MyApp.instance.getString("phone"));
    }
}
