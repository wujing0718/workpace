package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.Gson.PingJia;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.DianPuShopPingJiaAdapter;
import com.huohougongfu.app.WoDe.Adapter.DianPuShopPingJiaDetailAdapter;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopPingJiaDetailActivity extends AppCompatActivity {

    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_shop_pingjia_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_ping_jia_detail);
        initUI();
        initData();
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("id",String.valueOf(45));
        map.put("page","1");
        map.put("pageSize","10");
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        OkGo.<String>get(Contacts.URl2+"/selectAppraise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        PingJia shangPinGson = gson.fromJson(response.body(), PingJia.class);
                        if (shangPinGson.getStatus() == 1) {
                            initRec(shangPinGson.getResult().getList());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }


    private void initRec(List<PingJia.ResultBean.ListBean> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(ShopPingJiaDetailActivity.this);
        rec_shop_pingjia_detail.setLayoutManager(layoutManager);
        DianPuShopPingJiaDetailAdapter dianPuShopPingJiaAdapter = new DianPuShopPingJiaDetailAdapter(R.layout.item_dianpu_pingjia, list,ShopPingJiaDetailActivity.this);
        rec_shop_pingjia_detail.setAdapter(dianPuShopPingJiaAdapter);
        dianPuShopPingJiaAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }


    private void initUI() {
        rec_shop_pingjia_detail = findViewById(R.id.rec_shop_pingjia_detail);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
