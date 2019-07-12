package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyDongTai;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.MyDongTaiAdapter;
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
import java.util.List;
import java.util.Map;

public class MyDongTaiActivity extends AppCompatActivity {

    private String token;
    private int mId;
    private RecyclerView rec_wode_dongtai;
    private SmartRefreshLayout smartrefreshlayout;
    private int page = 2;
    private MyDongTaiAdapter myDongTaiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dong_tai);
        token = MyApp.instance.getString("token");
        mId = MyApp.instance.getInt("id");
        rec_wode_dongtai = findViewById(R.id.rec_wode_dongtai);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        initData();
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/my/dynamic")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        smartrefreshlayout.finishRefresh(true);//传入false表示刷新失败
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        MyDongTai dongtai = gson.fromJson(body, MyDongTai.class);
                        if (dongtai.getStatus() == 1){
                            initRec(dongtai.getResult().getList());
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(MyDongTaiActivity.this,"载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(List<MyDongTai.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        rec_wode_dongtai.setLayoutManager(layoutmanager);
         myDongTaiAdapter = new MyDongTaiAdapter(R.layout.item_wode_dongtai,list,MyDongTaiActivity.this);
        rec_wode_dongtai.setAdapter(myDongTaiAdapter);
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData();
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
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(page++));
        OkGo.<String>post(Contacts.URl1+"/my/dynamic")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyDongTai dongtai = gson.fromJson(body, MyDongTai.class);
                        if (dongtai.getStatus() == 1){
                            if (dongtai.getResult().getList().size()>0){
                                myDongTaiAdapter.add(dongtai.getResult().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else {
                                smartrefreshlayout. finishLoadMore();
                            }
                            }
                    }
                });
    }
}
