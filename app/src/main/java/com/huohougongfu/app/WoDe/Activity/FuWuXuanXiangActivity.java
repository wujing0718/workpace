package com.huohougongfu.app.WoDe.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huohougongfu.app.PopupView.FuHuoShiJian;
import com.huohougongfu.app.PopupView.Paocha;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.XPopup;

import java.util.Map;

public class FuWuXuanXiangActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private TextView tv_fahuo_time;
    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                   String fahuoshijian = (String)msg.obj;
                    tv_fahuo_time.setText(fahuoshijian);
                    break;
                default:
                    break;
            }
        }

    };
    private ImageView img_check_xinyongka;
    private boolean isxinyongka = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fu_wu_xuan_xiang);
        intent = new Intent();
        initUI();

    }

    private void initUI() {
        findViewById(R.id.bt_xuanze_time).setOnClickListener(this);
        findViewById(R.id.bt_xinyongka).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        img_check_xinyongka = findViewById(R.id.img_check_xinyongka);
        tv_fahuo_time = findViewById(R.id.tv_fahuo_time);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_xuanze_time:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(this)
                            .asCustom(new FuHuoShiJian(this,mHandler))
                            .show();
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_xinyongka:
                if (isxinyongka ==true){
                    img_check_xinyongka.setImageResource(R.mipmap.select);
                    isxinyongka = false;
                }else{
                    img_check_xinyongka.setImageResource(R.mipmap.unselect);
                    isxinyongka = true;
                }
                break;
        }
    }
}
