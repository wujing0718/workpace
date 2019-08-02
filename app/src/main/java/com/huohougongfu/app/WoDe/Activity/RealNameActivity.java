package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.PopupView.FuWu;
import com.huohougongfu.app.PopupView.XingBie;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.XPopup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class RealNameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView bt_xingbie_xuanze,bt_shengri_xuanze;

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String xingbie = (String)msg.obj;
                    bt_xingbie_xuanze.setText(xingbie);
                    bt_xingbie_xuanze.setTextColor(getResources().getColor(R.color.colorBlack));
                    break;
                default:
                    break;
            }
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_name);
        initUI();
    }

    private void initUI() {
        findViewById(R.id.bt_chashi_renzheng).setOnClickListener(this);
        findViewById(R.id.bt_shanghu_renzheng).setOnClickListener(this);
        bt_xingbie_xuanze = findViewById(R.id.bt_xingbie_xuanze);
        bt_xingbie_xuanze.setOnClickListener(this);
        bt_shengri_xuanze = findViewById(R.id.bt_shengri_xuanze);
        bt_shengri_xuanze.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_xingbie_xuanze:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(RealNameActivity.this)
                            .asCustom(new XingBie(RealNameActivity.this,mHandler))
                            .show();
                }
                break;
            case R.id.bt_shengri_xuanze:
                //时间选择器
                TimePickerView oldTime = new TimePickerBuilder(RealNameActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        SimpleDateFormat formatter_day = new SimpleDateFormat("yyyy-MM-dd");
                        String format = formatter_day.format(date);
                        bt_shengri_xuanze.setText(format);
                        bt_shengri_xuanze.setTextColor(getResources().getColor(R.color.colorBlack));
                    }
                }).build();
                oldTime.show();
                break;
            case R.id.bt_chashi_renzheng:
                Intent intent = new Intent();
                startActivity(intent.setClass(RealNameActivity.this,ChaShiRenZhengActivity.class));
                break;
            case R.id.bt_shanghu_renzheng:
                ToastUtils.showShort("456");
                break;
        }
    }
}
