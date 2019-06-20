package com.huohougongfu.app.QuanZi.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MallGson;
import com.huohougongfu.app.QuanZi.Adapter.WenZhangAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.MallAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

public class WenZhangActivity extends AppCompatActivity {

    private RecyclerView rec_quanzi_wenzhang;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wen_zhang);
        phone = SPUtils.getInstance("登录").getString("phone");
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rec_quanzi_wenzhang = findViewById(R.id.rec_quanzi_wenzhang);
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("tel",phone);
        map.put("type","mall");
        OkGo.<String>post(Contacts.URl1 + "/wallet/coupons")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MallGson chaQuan = gson.fromJson(body, MallGson.class);
                        if (chaQuan.getStatus() == 1) {
                            initRec(chaQuan);
                        }
                    }
                });
    }

    private void initRec(MallGson chaQuan) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_quanzi_wenzhang.setLayoutManager(layoutmanager);
        WenZhangAdapter sendadapter = new WenZhangAdapter(R.layout.item_quanzi_wenzhang,chaQuan.getResult());
        rec_quanzi_wenzhang.setAdapter(sendadapter);
    }
}
