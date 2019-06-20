package com.huohougongfu.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.Code;
import com.huohougongfu.app.Gson.Login;
import com.huohougongfu.app.Gson.Register;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.SmoothCheckBox;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.TipDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private SmoothCheckBox checkbox;
    private Intent intent;
    private View view_registerok;
    private int recLen = 3;//跳过倒计时提示3秒
    Timer timer = new Timer();  //定义一个计时器
    private TextView tv_daojishi,tv_zhuce_code;
    private TimerCount timerCount;
    private EditText edt_register_phone;
    private EditText edt_register_code,edt_register_password;
    private String phone,code,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        timerCount = new TimerCount(60000, 1000);
        intent = new Intent();
        initUI();
    }

    private void initUI() {
        edt_register_phone = findViewById(R.id.edt_register_phone);
        edt_register_code = findViewById(R.id.edt_register_code);
        edt_register_password = findViewById(R.id.edt_register_password);

        findViewById(R.id.bt_finish).setOnClickListener(this);
        checkbox = findViewById(R.id.checkbox);
        view_registerok = findViewById(R.id.view_registerok);
        view_registerok.setVisibility(View.GONE);
        findViewById(R.id.bt_login).setOnClickListener(this);
        findViewById(R.id.bt_register).setOnClickListener(this);
        findViewById(R.id.bt_zhuce_code).setOnClickListener(this);
        findViewById(R.id.bt_yinsi).setOnClickListener(this);
        findViewById(R.id.bt_xieyi).setOnClickListener(this);
        tv_zhuce_code = findViewById(R.id.tv_zhuce_code);
        tv_daojishi = findViewById(R.id.tv_daojishi);
        checkbox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox checkBox, boolean isChecked) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                   finish();
                }
                break;
            case R.id.bt_login:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
            case R.id.bt_zhuce_code:
                if (!utils.isDoubleClick()){
                    phone = edt_register_phone.getText().toString();
                    ///判断是否为空
                    if (!phone.isEmpty()){
                        //判断是否为正确手机号
                        if (RegexUtils.isMobileExact(phone)){
                            initCode(phone);
                        }else{
                            ToastUtils.showShort("请输入正确手机号");
                        }
                    }else{
                        ToastUtils.showShort("请输入手机号");
                    }
                }
                break;
            case R.id.bt_register:
                if (!utils.isDoubleClick()){
                    if (checkbox.isChecked()){
                        phone = edt_register_phone.getText().toString();
                        code = edt_register_code.getText().toString();
                        password = edt_register_password.getText().toString();
                        ///判断是否为空
                        if (!phone.isEmpty()){
                            //判断是否为正确手机号
                            if (RegexUtils.isMobileExact(phone)){
                                if (!password.isEmpty()){
                                    if (!code.isEmpty()){
                                        initRegister();
                                    }else{
                                        ToastUtils.showShort("请输入验证码");
                                    }
                                }else{
                                    ToastUtils.showShort("请输入密码");
                                }
                            }else{
                                ToastUtils.showShort("请输入正确手机号");
                            }
                        }else{
                            ToastUtils.showShort("请输入手机号");
                        }
                    }else{
                        ToastUtils.showShort("请同意用户协议和隐私政策");
                    }
                }
                break;
            case R.id.bt_xieyi:
                if (!utils.isDoubleClick()){
                intent.setClass(RegisterActivity.this,XieYiActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.bt_yinsi:
                if (!utils.isDoubleClick()){
                intent.setClass(RegisterActivity.this,YinSiActivity.class);
                startActivity(intent);
            }
            break;
        }
    }

    private void initRegister() {
        Map map = new HashMap();
        map.put("tel",phone);
        map.put("code",code);
        map.put("password",password);
        OkGo.<String>post(Contacts.URl1+"/member/register")
                .params(map)
                .isMultipart(true).tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        Login register = gson.fromJson(body, Login.class);
                        if (register.getStatus() == 1){
                            SPUtils instance = SPUtils.getInstance("登录");
                            instance.put("userid",register.getResult().getUserInfo().getUserId(),true);
                            instance.put("nickName",register.getResult().getUserInfo().getNickName(),true);
                            instance.put("phone",register.getResult().getUserInfo().getPhone(),true);
                            instance.put("photo",register.getResult().getUserInfo().getPhoto(),true);
                            instance.put("rongtoken",register.getResult().getUserInfo().getRongToken(),true);
                            instance.put("token",register.getResult().getToken(),true);
                            intent.setClass(RegisterActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
//                            ToastUtils.showShort(register.getMsg());
                        }else{
                            ToastUtils.showShort(register.getMsg());
                        }
                    }
                });
    }

    private void initCode(String phone) {
        Map map = new HashMap();
        map.put("tel",phone);
        map.put("type","register");
        OkGo.<String>post(Contacts.URl1+"/getCode")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        Code code = gson.fromJson(body, Code.class);
                        if (code.getStatus() == 1){
                            timerCount.start();
                            ToastUtils.showShort(code.getMsg());
                        }else{
                            ToastUtils.showShort(code.getMsg());
                        }
                    }
                });
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() { // UI thread
                @Override
                public void run() {
                    recLen--;
                    tv_daojishi.setText("返回登陆(" + recLen+"s)");
                    if (recLen < 0) {
                        timer.cancel();
//                        tv_daojishi.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        }
    };


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
            tv_zhuce_code.setClickable(false);
            tv_zhuce_code.setText("重新发送"+millisUntilFinished / 1000 + "s");
            tv_zhuce_code.setTextColor(RegisterActivity.this.getResources().getColor(R.color.colorBlack));
        }

        /**
         * Callback fired when the time is up.
         */
        @Override
        public void onFinish() {//计时完成的回调
            tv_zhuce_code.setClickable(true);
            tv_zhuce_code.setText("重新发送");
            tv_zhuce_code.setTextColor(RegisterActivity.this.getResources().getColor(R.color.colorBlack));
        }
    }
}
