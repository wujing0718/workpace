package com.huohougongfu.app.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.Code;
import com.huohougongfu.app.Gson.JudgeGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class BindActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText phone,code;
    private String json,type;
    private String login_code;
    private String login_phone;
    private BindActivity.TimerCount timerCount;
    private TextView tv_login_code;
    private Intent intent;
    private static final int MSG_SET_ALIAS = 1001;

    //设置别名
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
            }
        }
    };

    private final TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs ;
            switch (code) {
                case 0:
                    logs = "设置成功";
                    LogUtils.e(alias);
                    // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
                    break;
                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
                    // 延迟 60 秒来调用 Handler 设置别名
                    mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_ALIAS, alias), 1000 * 60);
                    LogUtils.e(logs);
                    break;
                default:
                    logs = "Failed with errorCode = " + code;
            }
//            ExampleUtil.showToast(logs, getApplicationContext());
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind);
        timerCount = new TimerCount(60000, 1000);
        json = getIntent().getStringExtra("json");
        type = getIntent().getStringExtra("type");
        intent = new Intent();
        initUI();
    }

    private void initUI() {
        phone = findViewById(R.id.edt_login_phone);
        code = findViewById(R.id.edt_login_code);
        tv_login_code = findViewById(R.id.tv_login_code);
        findViewById(R.id.bt_login_code).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_login:
                initBind();
                break;
        }
    }
    private void initCode(String phone) {
        Map map = new HashMap();
        map.put("tel",phone);
        map.put("type","third");
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

    private void initBind() {
        login_phone = phone.getText().toString();
        login_code = code.getText().toString();
        Map<String,String> map = new HashMap<>();
        map.put("json",json);
        map.put("type",type);
        ///判断是否为空
        if (!login_phone.isEmpty()) {
            //判断是否为正确手机号
            if (RegexUtils.isMobileExact(login_phone)) {
                if (!login_code.isEmpty()) {
                    map.put("tel",login_phone);
                    map.put("code",login_code);
                    OkGo.<String>post(Contacts.URl1+"/member/thirdParty/login2")
                            .params(map)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    WaitDialog.dismiss();
                                    String body = response.body();
                                    JudgeGson judgeGson = new Gson().fromJson(body, JudgeGson.class);
                                    if (judgeGson.getStatus() == 1){
                                        initLogin(judgeGson.getResult());
                                    }else{
                                        ToastUtils.showShort(judgeGson.getMsg());
                                    }
                                }

                                @Override
                                public void onStart(Request<String, ? extends Request> request) {
//                                    WaitDialog.show(BindActivity.this,"请稍后。。。");
                                    super.onStart(request);
                                }
                            });
                }else{
                    ToastUtils.showShort("请输入验证码");
                }
            }else{
                ToastUtils.showShort("请输入正确手机号");
            }
        }else{
            ToastUtils.showShort("请输入手机号");
        }
    }

    private void initLogin(JudgeGson.ResultBean result) {
        MyApp.instance.clear(true);
        MyApp.instance.put("id",result.getUserInfo().getUserId(),true);
        MyApp.instance.put("nickName",result.getUserInfo().getNickName(),true);
        MyApp.instance.put("phone",result.getUserInfo().getPhone(),true);
        MyApp.instance.put("photo",result.getUserInfo().getPhoto(),true);
        MyApp.instance.put("rongToken",result.getUserInfo().getRongToken(),true);
        MyApp.instance.put("token",result.getToken(),true);
        intent.setClass(BindActivity.this,MainActivity.class);
        LoginActivity.activity.finish();
        finish();
        startActivity(intent);
        // 调用 Handler 来异步设置别名
        mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, String.valueOf(result.getUserInfo().getUserId())));
        // 点击恢复按钮后，极光推送服务会恢复正常工作
        JPushInterface.resumePush(getApplicationContext());
        ToastUtils.showShort("登录成功");
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
            tv_login_code.setTextColor(BindActivity.this.getResources().getColor(R.color.colorBlack));
        }

        /**
         * Callback fired when the time is up.
         */
        @Override
        public void onFinish() {//计时完成的回调
            tv_login_code.setClickable(true);
            tv_login_code.setText("重新发送");
            tv_login_code.setTextColor(BindActivity.this.getResources().getColor(R.color.colorBlack));
        }
    }
}
