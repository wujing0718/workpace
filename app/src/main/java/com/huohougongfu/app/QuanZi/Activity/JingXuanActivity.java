package com.huohougongfu.app.QuanZi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyCaQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.JingXuanAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.MyKaQuanAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JingXuanActivity extends AppCompatActivity {

    private RecyclerView rec_jingxuan_wenzhang,rec_tuijianyonghu;
    private String token,tel,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jing_xuan);
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
        map.put("type","enableSend");
        OkGo.<String>post(Contacts.URl1+"/wallet/coupons")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        MyCaQuan chaQuan = gson.fromJson(response.body(), MyCaQuan.class);
                        if (chaQuan.getStatus() == 1) {
                            initRecWoDe(chaQuan.getResult());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(JingXuanActivity.this, "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRecWoDe(List<MyCaQuan.ResultBean> result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置RecyclerView 布局
        rec_jingxuan_wenzhang.setLayoutManager(layoutmanager);
        JingXuanAdapter wodeadapter = new JingXuanAdapter(R.layout.item_quanzi_jingxuanwenzhang,result);
        rec_jingxuan_wenzhang.setAdapter(wodeadapter);
    }


    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
         rec_jingxuan_wenzhang = findViewById(R.id.rec_jingxuan_wenzhang);
         rec_tuijianyonghu = findViewById(R.id.rec_tuijianyonghu);
    }
}
