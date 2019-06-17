package com.huohougongfu.app.Activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;

import org.w3c.dom.Text;

public class WangJiMiMa extends AppCompatActivity implements View.OnClickListener {

    private WangJiMiMa.TimerCount timerCount;
    private TextView tv_wangjimima_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang_ji_mi_ma);
        timerCount = new WangJiMiMa.TimerCount(60000, 1000);

        initUI();
    }

    private void initUI() {
        tv_wangjimima_code = findViewById(R.id.tv_wangjimima_code);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_wangjimima_code).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
            case R.id.bt_wangjimima_code:
                if (!utils.isDoubleClick()){
                    timerCount.start();
                }
                break;
        }
    }
    class TimerCount extends CountDownTimer {

        public TimerCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        /**
         * Callback fired on regular interval.
         *
         * @param millisUntilFinished The amount of time until finished.
         */
        @Override
        public void onTick(long millisUntilFinished) {
            tv_wangjimima_code.setClickable(false);
            tv_wangjimima_code.setText("重新发送"+millisUntilFinished / 1000 + "s");
            tv_wangjimima_code.setTextColor(WangJiMiMa.this.getResources().getColor(R.color.colorBlack));
        }

        /**
         * Callback fired when the time is up.
         */
        @Override
        public void onFinish() {//计时完成的回调
            tv_wangjimima_code.setClickable(true);
            tv_wangjimima_code.setText("重新发送");
            tv_wangjimima_code.setTextColor(WangJiMiMa.this.getResources().getColor(R.color.colorBlack));
        }
    }
}
