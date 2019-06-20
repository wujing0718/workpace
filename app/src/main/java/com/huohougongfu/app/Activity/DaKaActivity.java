package com.huohougongfu.app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.SPUtils;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class DaKaActivity extends AppCompatActivity {

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_ka);
        id = SPUtils.getInstance("登录").getInt("id");
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.bt_daka).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDaKa();
            }
        });
    }

    private void initDaKa() {
        OkGo.<String>get(Contacts.URl1+"/index/punch/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                    }
                });
    }
}
