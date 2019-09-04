package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.WuLiuGson;
import com.huohougongfu.app.Gson.WuLiuString;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.WuLiuAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.Map;

public class WuLiuActivity extends AppCompatActivity {

    private RecyclerView rec_wuliu;
    private SmartRefreshLayout smartrefreshlayout;
    private TextView tv_kuaidi_name,tv_kuaidi_phone,tv_kuaidi_danhao;
    private ImageView img_duaidi_photo;
    private String logisticsName,logisticsNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wu_liu);
        logisticsName = getIntent().getStringExtra("logisticsName");
        logisticsNo = getIntent().getStringExtra("logisticsNo");
        initData();
    }

    private void initUI(WuLiuString result) {
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_duaidi_photo = findViewById(R.id.img_duaidi_photo);
        tv_kuaidi_name = findViewById(R.id.tv_kuaidi_name);
        tv_kuaidi_phone = findViewById(R.id.tv_kuaidi_phone);
        tv_kuaidi_danhao = findViewById(R.id.tv_kuaidi_danhao);
        tv_kuaidi_name.setText(result.getExpName());
        tv_kuaidi_phone.setText("官方电话："+result.getExpName());
        tv_kuaidi_danhao.setText("快递单号："+result.getNumber());
        Glide.with(WuLiuActivity.this).load(result.getLogo()).into(img_duaidi_photo);
        rec_wuliu = findViewById(R.id.rec_wuliu);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(WuLiuActivity.this);
        rec_wuliu.setLayoutManager(layoutManager);
        WuLiuAdapter wuLiuAdapter = new WuLiuAdapter(R.layout.item_wuliu, result.getList());
        rec_wuliu.setAdapter(wuLiuAdapter);
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("no",logisticsNo);
        map.put("type",logisticsName);
        OkGo.<String>post(Contacts.URl1+"/kuaidi/info")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        WuLiuGson wuLiuGson = gson.fromJson(body, WuLiuGson.class);
                        if (wuLiuGson.getStatus() == 1){
                            WuLiuString wuLiuString = gson.fromJson(wuLiuGson.getResult(), WuLiuString.class);
                            initUI(wuLiuString);
                        }
                    }
                });
    }
}
