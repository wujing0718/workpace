package com.huohougongfu.app.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.Code;
import com.huohougongfu.app.Gson.Login;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private long firstTime = 0;
    private View yanzhengmadenglu,mimadenglu;
    private EditText phone,code,password;
    private String login_phone,login_code,login_password;
    private TextView tv_login_code;
    private LoginActivity.TimerCount timerCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        timerCount = new LoginActivity.TimerCount(60000, 1000);
        intent = new Intent();
        initUI();
    }

    private void initUI() {
        yanzhengmadenglu = findViewById(R.id.yanzhengmadenglu);
        mimadenglu = findViewById(R.id.mimadenglu);
        phone = findViewById(R.id.edt_login_phone);
        code = findViewById(R.id.edt_login_code);
        password = findViewById(R.id.edt_login_password);

        tv_login_code = findViewById(R.id.tv_login_code);
        findViewById(R.id.bt_yanzhengmadenglu).setOnClickListener(this);
        findViewById(R.id.bt_zhaohuimima).setOnClickListener(this);
        findViewById(R.id.bt_mimadenglu).setOnClickListener(this);
        findViewById(R.id.bt_login_code).setOnClickListener(this);
        findViewById(R.id.bt_login).setOnClickListener(this);
        findViewById(R.id.bt_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                if (!utils.isDoubleClick()){
                    if (yanzhengmadenglu.getVisibility() == View.VISIBLE){
                        //验证码登录
                        CodeLogin();
                    }else{
                        //密码登录
                        PasswordLogin();
                    }
                }
                break;
            case R.id.bt_zhaohuimima:
                if (!utils.isDoubleClick()){
                    intent.setClass(LoginActivity.this,WangJiMiMa.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_register:
                if (!utils.isDoubleClick()){
                    intent.setClass(LoginActivity.this,RegisterActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_mimadenglu:
                if (!utils.isDoubleClick()){
                    mimadenglu.setVisibility(View.VISIBLE);
                    yanzhengmadenglu.setVisibility(View.GONE);
                }
                break;
            case R.id.bt_yanzhengmadenglu:
                if (!utils.isDoubleClick()){
                    yanzhengmadenglu.setVisibility(View.VISIBLE);
                    mimadenglu.setVisibility(View.GONE);
                }
                break;
            case R.id.bt_login_code:
                if (!utils.isDoubleClick()){
                    login_code = code.getText().toString();
                    login_phone = phone.getText().toString();
                    ///判断是否为空
                    if (!login_phone.isEmpty()){
                        //判断是否为正确手机号
                        if (RegexUtils.isMobileExact(login_phone)){
                            initCode(login_phone);
                        }else{
                            ToastUtils.showShort("请输入正确手机号");
                        }
                    }else{
                        ToastUtils.showShort("请输入手机号");
                    }
                }
                break;
        }
    }

    private void initCode(String phone) {
        Map map = new HashMap();
        map.put("tel",phone);
        map.put("type","login");
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

    //密码登录
    private void PasswordLogin() {
        login_phone = phone.getText().toString();
        login_password = password.getText().toString();
        ///判断是否为空
        if (!login_phone.isEmpty()) {
            //判断是否为正确手机号
            if (RegexUtils.isMobileExact(login_phone)) {
                if(!login_password.isEmpty()){
                    Map<String,String> map = new HashMap<>();
                    map.put("tel",login_phone);
                    map.put("codeOrPass",login_password);
                    OkGo.<String>post(Contacts.URl1+"/member/login")
                            .params(map)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    String body = response.body();
                                    Gson gson = new Gson();
                                    Login login = gson.fromJson(body, Login.class);
                                    if (login.getStatus() == 1){
                                        intent.setClass(LoginActivity.this,MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                        ToastUtils.showShort("登录成功");
                                    }else{
                                        ToastUtils.showShort(login.getMsg());
                                    }
                                }
                            });
                }else{
                    ToastUtils.showShort("请输入密码");
                }
            } else {
                ToastUtils.showShort("请输入正确手机号");
            }
        }else {
            ToastUtils.showShort("请输入手机号");
        }
    }

    //验证码登录
    private void CodeLogin() {
        login_phone = phone.getText().toString();
        login_code = code.getText().toString();
        ///判断是否为空
        if (!login_phone.isEmpty()) {
            //判断是否为正确手机号
            if (RegexUtils.isMobileExact(login_phone)) {
                if(!login_code.isEmpty()){
                    Map<String,String> map = new HashMap<>();
                    map.put("tel",login_phone);
                    map.put("codeOrPass",login_code);
                    OkGo.<String>post(Contacts.URl1+"/member/login")
                            .params(map)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    String body = response.body();
                                    Gson gson = new Gson();
                                    Login login = gson.fromJson(body, Login.class);
                                    if (login.getStatus() == 1){
                                        intent.setClass(LoginActivity.this,MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                        ToastUtils.showShort("登录成功");
                                    }else{
                                        ToastUtils.showShort(login.getMsg());
                                    }
                                }
                            });
                }else{
                    ToastUtils.showShort("请输入验证码");
                }
            } else {
                ToastUtils.showShort("请输入正确手机号");
            }
        }else {
            ToastUtils.showShort("请输入手机号");
        }
    }

    //双击退出
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(LoginActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }

        return super.onKeyUp(keyCode, event);
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
            tv_login_code.setClickable(false);
            tv_login_code.setText("重新发送"+millisUntilFinished / 1000 + "s");
            tv_login_code.setTextColor(LoginActivity.this.getResources().getColor(R.color.colorBlack));
        }

        /**
         * Callback fired when the time is up.
         */
        @Override
        public void onFinish() {//计时完成的回调
            tv_login_code.setClickable(true);
            tv_login_code.setText("重新发送");
            tv_login_code.setTextColor(LoginActivity.this.getResources().getColor(R.color.colorBlack));
        }
    }
}
