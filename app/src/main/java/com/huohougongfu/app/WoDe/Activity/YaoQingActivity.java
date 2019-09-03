package com.huohougongfu.app.WoDe.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Gson.YaoQingGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Adapter.YaoQingAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YaoQingActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private ImageView img_zhuanke_bg;
    private TextView tv_biaoyu,tv_guize;
    private RecyclerView rec_yaoqing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yao_qing);
        initUI();
        initData();
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        img_zhuanke_bg = findViewById(R.id.img_zhuanke_bg);
        tv_biaoyu = findViewById(R.id.tv_biaoyu);
        tv_guize = findViewById(R.id.tv_guize);
        rec_yaoqing = findViewById(R.id.rec_yaoqing);
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("page",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>get(Contacts.URl1+"earn/invitePage")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        YaoQingGson yaoQingGson = gson.fromJson(body, YaoQingGson.class);
                        if (yaoQingGson.getStatus() == 1){
                            initView(yaoQingGson.getResult());
                        }
                    }
                });
    }

    private void initView(YaoQingGson.ResultBean result) {
        Glide.with(MyApp.context).load(result.getRule().getPicture())
                .apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_zhuanke_bg);
        tv_biaoyu.setText(result.getRule().getSlogan());
        tv_guize.setText(result.getRule().getRegulation());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rec_yaoqing.setLayoutManager(layoutManager);
        YaoQingAdapter yaoQingAdapter = new YaoQingAdapter(R.layout.item_yaoqing,result.getEarnPordut().getList());
        rec_yaoqing.setAdapter(yaoQingAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
        }
    }
}
