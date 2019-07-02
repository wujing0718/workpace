package com.huohougongfu.app.QuanZi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.QuanZiDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class VedioDetailActivity extends AppCompatActivity {

    private JzvdStd jzvdStd;
    private int dId,mid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_detail);
        dId = getIntent().getIntExtra("dId", 0);
        mid = MyApp.instance.getInt("id");
        jzvdStd = findViewById(R.id.jz);
        initData();
    }

    private void initData() {
        Map<String ,String> map = new HashMap<>();
        map.put("dId",String.valueOf(dId));
        map.put("mId",String.valueOf(mid));
        OkGo.<String>post(Contacts.URl1+"/circle/data/info")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        QuanZiDetail detail = gson.fromJson(body, QuanZiDetail.class);
                        if (detail.getStatus() == 1){
                            initView(detail.getResult());
                        }
                    }
                });
    }

    private void initView(QuanZiDetail.ResultBean result) {
        jzvdStd.setUp(result.getPicture(), "", JzvdStd.SCREEN_WINDOW_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
    }        super.onBackPressed();
    }
}
