package com.huohougongfu.app.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;

import java.util.Timer;
import java.util.TimerTask;

public class StartPagerActivity extends AppCompatActivity implements View.OnClickListener{

    private int recLen = 6;//跳过倒计时提示5秒
    private TextView tv;
    Timer timer = new Timer();  //定义一个计时器
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_pager);
        //判断当前Activity是否是第一个activity
        if (!isTaskRoot()) {
            Intent intent = getIntent();
            String action = intent.getAction();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && action != null && action.equals(Intent.ACTION_MAIN)) {
                finish();
                return;
            }
        }
        ImageView img_startpage = findViewById(R.id.img_startpage);
        Glide.with(MyApp.context).load("http://oss.hotkungfu-tea.com/picture/startPage.jpg").into(img_startpage);
        inittiaoguo();
    }

    private void inittiaoguo() {
        //设置当前窗体为全屏显示
        initView();
        timer.schedule(task, 1000, 1000);//等待时间一秒，停顿时间一秒
        /**
         33          * 正常情况下不点击跳过
         34          */
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(StartPagerActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);//延迟3S后发送handler信息

    }

    private void initView() {
        tv = findViewById(R.id.tv);//跳过
        tv.setOnClickListener(this);//跳过监听
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() { // UI thread
                @Override
                public void run() {
                    recLen--;
                    tv.setText("跳过 " + recLen);
                    if (recLen < 0) {
                        timer.cancel();
                        tv.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                //从闪屏界面跳转到首界面
                if (!utils.isDoubleClick()) {
                    Intent intent=new Intent(StartPagerActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    if (runnable != null) {
                        handler.removeCallbacks(runnable);
                    }
                }
                break;
            default:
                break;
        }
    }
}
