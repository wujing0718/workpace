package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.Gson.MyPingJia;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.DianPuShopPingJiaAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopPingJiaActivity extends AppCompatActivity {

    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_shop_pingjia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_ping_jia);
        initUI();
        initData();
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rec_shop_pingjia = findViewById(R.id.rec_shop_pingjia);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("page",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>get(Contacts.URl1+"findAppraiseOfSeller")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyPingJia myCollect = gson.fromJson(body, MyPingJia.class);
                        if (myCollect.getStatus() == 1){
                            if (myCollect.getResult().getList().size()==0){
                                smartrefreshlayout.setVisibility(View.GONE);
                            }else{
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec(myCollect.getResult().getList());
                            }
                        }
                    }
                });
    }

    private void initRec(List<MyPingJia.ResultBean.ListBean> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(ShopPingJiaActivity.this);
        rec_shop_pingjia.setLayoutManager(layoutManager);
        DianPuShopPingJiaAdapter dianPuShopPingJiaAdapter = new DianPuShopPingJiaAdapter(R.layout.item_dianpu_shop_pingjia, list);
        rec_shop_pingjia.setAdapter(dianPuShopPingJiaAdapter);
        dianPuShopPingJiaAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("shopid",list.get(position).getId());
                intent.setClass(ShopPingJiaActivity.this,ShopPingJiaDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
