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
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.SmoothCheckBox;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.TipDialog;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

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
    private static final int MSG_SET_ALIAS = 1001;
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SET_ALIAS:
//                    Log.d(TAG, "Set alias in handler.");
                    // 调用 JPush 接口来设置别名。
                    JPushInterface.setAliasAndTags(getApplicationContext(),
                            (String) msg.obj,
                            null,
                            mAliasCallback);
                    break;
                default:
//                    Log.i(TAG, "Unhandled msg - " + msg.what);
            }
        }
    };

    private final TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs ;
            switch (code) {
                case 0:
                    logs = "Set tag and alias success";
                    // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
                    break;
                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
                    // 延迟 60 秒来调用 Handler 设置别名
                    mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_ALIAS, alias), 1000 * 60);
                    break;
                default:
                    logs = "Failed with errorCode = " + code;
            }
//            ExampleUtil.showToast(logs, getApplicationContext());
        }
    };
    private SPUtils instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        timerCount = new TimerCount(60000, 1000);
        instance = SPUtils.getInstance("登录");
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
        String password1 = utils.makeMD5(password);
        Map map = new HashMap();
        map.put("tel",phone);
        map.put("code",code);
        map.put("password",password1);
        OkGo.<String>post(Contacts.URl1+"/member/register")
                .params(map)
                .isMultipart(true).tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        Login register = gson.fromJson(body, Login.class);
                        if (register.getStatus() == 1){
                            MyApp.instance.clear(true);
                            MyApp.instance.put("id",register.getResult().getUserInfo().getUserId(),true);
                            MyApp.instance.put("nickName",register.getResult().getUserInfo().getNickName(),true);
                            MyApp.instance.put("phone",register.getResult().getUserInfo().getPhone(),true);
                            MyApp.instance.put("photo",register.getResult().getUserInfo().getPhoto(),true);
                            MyApp.instance.put("rongToken",register.getResult().getUserInfo().getRongToken(),true);
                            MyApp.instance.put("token",register.getResult().getToken(),true);
                            intent.setClass(RegisterActivity.this,MainActivity.class);
                            String lat = MyApp.instance.getString("lat");
                            if (lat!=null){
                                ListenerManager.getInstance().sendBroadCast(10,"是");
                            }
                            // 连接成功，说明你已成功连接到融云Server
                            startActivity(intent);
                            finish();
                            // 调用 Handler 来异步设置别名
                            mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, String.valueOf(register.getResult().getUserInfo().getUserId())));
                            // 点击恢复按钮后，极光推送服务会恢复正常工作
                            JPushInterface.resumePush(getApplicationContext());
                        }else{
                            ToastUtils.showShort(register.getMsg());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        WaitDialog.dismiss();
                        super.onError(response);
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(RegisterActivity.this,"请稍后。。。");
                        super.onStart(request);
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
