package com.huohougongfu.app.Shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShangPinAdapter;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.ShopGson;
import com.huohougongfu.app.Gson.TeiHuiGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.TeHuiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.Map;

public class TeHuiActivity extends AppCompatActivity {

    private RecyclerView rec_shangpin_tehui;
    private String token,tel,id;
    private SmartRefreshLayout smartrefreshlayout;
    private int page = 2;
    private TeHuiAdapter tehuiadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_te_hui);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        initData();
    }
    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("id",id);
        map.put("token",token);
        map.put("page", "1");
        OkGo.<String>get(Contacts.URl1+"selectSalesPromotion")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        TeiHuiGson shangPinGson = gson.fromJson(response.body(), TeiHuiGson.class);
                        if (shangPinGson.getStatus() == 1) {
                            initRec(shangPinGson.getResult());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(TeHuiActivity.this, "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(TeiHuiGson.ResultBean result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(TeHuiActivity.this,2);
        //设置RecyclerView 布局
        rec_shangpin_tehui.setLayoutManager(layoutmanager);
         tehuiadapter = new TeHuiAdapter(R.layout.item_shangpin,result.getList());
        rec_shangpin_tehui.setAdapter(tehuiadapter);
        tehuiadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.setClass(TeHuiActivity.this,ShangPinDetailActivity.class);
                startActivity(intent);
            }
        });
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
//                initOkGO();
                smartrefreshlayout.finishRefresh(true);//传入false表示刷新失败
            }
        });
        //加载更多
        smartrefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                initAdd();
            }
        });
    }

    private void initAdd() {
        Map<String, String> map = new HashMap<>();
        map.put("page",String.valueOf(page++));
        map.put("tel",tel);
        map.put("id",id);
        map.put("token",token);
        OkGo.<String>get(Contacts.URl1+"selectSalesPromotion")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        TeiHuiGson tehui = gson.fromJson(response.body(), TeiHuiGson.class);
                        if (tehui.getResult().getList().size()>0){
                            tehuiadapter.add(tehui.getResult().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadmoreWithNoMoreData();
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(TeHuiActivity.this, "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initUI() {
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        rec_shangpin_tehui= findViewById(R.id.rec_shangpin_tehui);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
