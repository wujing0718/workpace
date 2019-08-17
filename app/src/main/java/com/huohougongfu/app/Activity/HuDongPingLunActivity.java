package com.huohougongfu.app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.HuDongPingLunAdapter;
import com.huohougongfu.app.Gson.HuDongPingLun;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuDongPingLunActivity extends AppCompatActivity {

    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_hudong_pinglun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hu_dong_ping_lun);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
//        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("mId",String.valueOf(43));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/my/interactive/commentList")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        HuDongPingLun huDongPingLun = new Gson().fromJson(body, HuDongPingLun.class);
                        if (huDongPingLun.getStatus() == 1){
                            initUI(huDongPingLun.getResult().getList());
                        }
                    }
                });
    }


    private void initUI(List<HuDongPingLun.ResultBean.ListBean> list) {
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        rec_hudong_pinglun = findViewById(R.id.rec_hudong_pinglun);
        LinearLayoutManager layoutManager = new LinearLayoutManager(HuDongPingLunActivity.this);
        rec_hudong_pinglun.setLayoutManager(layoutManager);
        HuDongPingLunAdapter huDongPingLunAdapter = new HuDongPingLunAdapter(R.layout.item_hudong_pinglun,list);
        rec_hudong_pinglun.setAdapter(huDongPingLunAdapter);
    }
}
