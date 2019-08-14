package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChanPinCanShu;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.CanShuAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

public class ShopCanShuActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rec_chanpin_canshu;
    private String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_can_shu);
        categoryName = getIntent().getStringExtra("categoryName");
        initUI();
        initData();
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"productManage/getProductAttributByCategory")
                .params("categoryName",categoryName)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        ChanPinCanShu canshu = new Gson().fromJson(body, ChanPinCanShu.class);
                        if (canshu.getStatus() == 1){
                            initRec(canshu.getResult().getKeys());
                        }
                    }
                });
    }

    private void initRec(List<String> keys) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rec_chanpin_canshu.setLayoutManager(layoutManager);
        CanShuAdapter canShuAdapter = new CanShuAdapter(R.layout.item_tianjia_shop_canshu,keys);
        rec_chanpin_canshu.setAdapter(canShuAdapter);
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        rec_chanpin_canshu = findViewById(R.id.rec_chanpin_canshu);
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
