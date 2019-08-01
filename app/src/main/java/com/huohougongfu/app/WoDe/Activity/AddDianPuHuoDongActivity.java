package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.LogUtils;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddDianPuHuoDongActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_endtime,tv_starttime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dian_pu_huo_dong);
        initUI();
    }

    private void initUI() {
        tv_starttime = findViewById(R.id.tv_starttime);
        tv_endtime = findViewById(R.id.tv_endtime);

        findViewById(R.id.starttime).setOnClickListener(this);
        findViewById(R.id.oldertime).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_wancheng).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.starttime:
                //时间选择器
                TimePickerView staTime = new TimePickerBuilder(AddDianPuHuoDongActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String nowTime2 = utils.getNowTime4();
                        SimpleDateFormat formatter_day = new SimpleDateFormat("yyyy-MM-dd");
                        String format = formatter_day.format(date);
                        tv_starttime.setText(format);
                    }
                }).build();
                staTime.show();
                break;
            case R.id.oldertime:
                //时间选择器
                TimePickerView oldTime = new TimePickerBuilder(AddDianPuHuoDongActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String nowTime2 = utils.getNowTime4();
                        SimpleDateFormat formatter_day = new SimpleDateFormat("yyyy-MM-dd");
                        String format = formatter_day.format(date);
                        tv_endtime.setText(format);
                    }
                }).build();
                oldTime.show();
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_wancheng:
                break;
        }
    }
}
