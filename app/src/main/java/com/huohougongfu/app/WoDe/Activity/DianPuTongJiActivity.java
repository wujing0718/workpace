package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.LogUtils;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DianPuTongJiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dian_pu_tong_ji);
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
                        String nowTime2 = utils.getNowTime4();
                        SimpleDateFormat formatter_day = new SimpleDateFormat("yyyy-MM-dd");
                        String format = formatter_day.format(date);
                        LogUtils.e(format+"=============="+nowTime2);
                    }
                }).build();
                pvTime.show();
            }
        });
    }
}
