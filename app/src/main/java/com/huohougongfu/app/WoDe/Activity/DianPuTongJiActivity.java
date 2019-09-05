package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.TongJiGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class
DianPuTongJiActivity extends AppCompatActivity {

    private String nowTime2;
    private TextView tv_today,tv_week,tv_mouth;
    private TextView tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dian_pu_tong_ji);
        nowTime2 = utils.getNowTime4();
        initData();
        initUI();
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.bt_tongji_riqi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //时间选择器
                TimePickerView pvTime = new TimePickerBuilder(DianPuTongJiActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        SimpleDateFormat formatter_day = new SimpleDateFormat("yyyy-MM-dd");
                        nowTime2 = formatter_day.format(date);
                        tv_time.setText(nowTime2);
                        initData();
                    }
                }).build();
                pvTime.show();
            }
        });
    }

    private void initUI() {
        tv_time = findViewById(R.id.tv_time);
        tv_time.setText(nowTime2);
        tv_today = findViewById(R.id.tv_today);
        tv_mouth = findViewById(R.id.tv_mouth);
        tv_week = findViewById(R.id.tv_week);

    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId", String.valueOf(MyApp.instance.getInt("id")));
        map.put("time", nowTime2);
        OkGo.<String>post(Contacts.URl1+"/store/turnoverStatistics")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        TongJiGson tongJiGson = gson.fromJson(body, TongJiGson.class);
                        if (tongJiGson.getStatus() == 1){
                            initView(tongJiGson);
                        }
                    }
                });
    }

    private void initView(TongJiGson tongJiGson) {
        tv_today.setText(String.valueOf(tongJiGson.getResult().getToday()));
        tv_week.setText("本周总营业额："+tongJiGson.getResult().getWeek()+"元");
        tv_mouth.setText("本月总营业额："+tongJiGson.getResult().getMouth()+"元");

    }
}
