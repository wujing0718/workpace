package com.huohougongfu.app.QuanZi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ZhaoRenGson;
import com.huohougongfu.app.QuanZi.Adapter.WenZhangAdapter;
import com.huohougongfu.app.QuanZi.Adapter.ZhaoRenAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZhaoRenActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rec_zhaoren;
    private ZhaoRenAdapter zhaorendadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhao_ren);
        initUI();
        initData();
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        rec_zhaoren = findViewById(R.id.rec_zhaoren);
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("condition","");
        map.put("pageNo","1");
        map.put("pageSize","10");
        OkGo.<String>post(Contacts.URl1+"/circle/find/people")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ZhaoRenGson zhaoRenGson = gson.fromJson(body, ZhaoRenGson.class);
                        if (zhaoRenGson.getStatus() ==1){
                            initRec(zhaoRenGson.getResult().getList());
                        }

                    }
                });
    }

    private void initRec(List<ZhaoRenGson.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_zhaoren.setLayoutManager(layoutmanager);
        zhaorendadapter = new ZhaoRenAdapter(R.layout.item_quanzi_zhaoren,list);
        rec_zhaoren.setAdapter(zhaorendadapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
        }
    }
}
