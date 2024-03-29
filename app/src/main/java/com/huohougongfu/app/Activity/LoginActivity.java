package com.huohougongfu.app.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.Code;
import com.huohougongfu.app.Gson.JudgeGson;
import com.huohougongfu.app.Gson.Login;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.ShareUtils;
import com.huohougongfu.app.Utils.SmoothCheckBox;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private long firstTime = 0;
    private View yanzhengmadenglu,mimadenglu;
    private EditText phone,code,password;
    private String login_phone,login_code,login_password;
    private TextView tv_login_code;
    private LoginActivity.TimerCount timerCount;
    private SPUtils instance;
    private static final int MSG_SET_ALIAS = 1001;
    public static LoginActivity activity;

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
                    logs = "设置成功";
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
    private UMShareAPI mShareAPI;
    private SmoothCheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activity = this;
        mShareAPI = UMShareAPI.get(this);
        instance = SPUtils.getInstance("登录");
        timerCount = new LoginActivity.TimerCount(60000, 1000);
        intent = new Intent();
        initUI();
    }

    private void initUI() {
        checkbox = findViewById(R.id.checkbox);
        yanzhengmadenglu = findViewById(R.id.yanzhengmadenglu);
        mimadenglu = findViewById(R.id.mimadenglu);
        phone = findViewById(R.id.edt_login_phone);
        code = findViewById(R.id.edt_login_code);
        password = findViewById(R.id.edt_login_password);

        tv_login_code = findViewById(R.id.tv_login_code);
        findViewById(R.id.bt_qq).setOnClickListener(this);
        findViewById(R.id.bt_weixin).setOnClickListener(this);
        findViewById(R.id.bt_weibo).setOnClickListener(this);
        findViewById(R.id.bt_xieyi).setOnClickListener(this);
        findViewById(R.id.bt_yinsi).setOnClickListener(this);
        findViewById(R.id.bt_yanzhengmadenglu).setOnClickListener(this);
        findViewById(R.id.bt_zhaohuimima).setOnClickListener(this);
        findViewById(R.id.bt_mimadenglu).setOnClickListener(this);
        findViewById(R.id.bt_login_code).setOnClickListener(this);
        findViewById(R.id.bt_login).setOnClickListener(this);
        findViewById(R.id.bt_register).setOnClickListener(this);
        checkbox.setChecked(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_weixin:
                ListenerManager.getInstance().sendBroadCast(10,"是");
                mShareAPI.getPlatformInfo(this,SHARE_MEDIA.WEIXIN,umAuthListener);
                break;
            case R.id.bt_qq:
                ListenerManager.getInstance().sendBroadCast(10,"是");
                mShareAPI.getPlatformInfo(this,SHARE_MEDIA.QQ,umAuthListener);
                break;
            case R.id.bt_weibo:
                ListenerManager.getInstance().sendBroadCast(10,"是");
                mShareAPI.getPlatformInfo(this,SHARE_MEDIA.SINA,umAuthListener);
                break;
            case R.id.bt_login:
                if (!utils.isDoubleClick()){
                    if (checkbox.isChecked()){
                        if (yanzhengmadenglu.getVisibility() == View.VISIBLE){
                            //验证码登录
                            CodeLogin();
                        }else{
                            //密码登录
                            PasswordLogin();
                        }
                    }else{
                        ToastUtils.showShort("请同意用户协议和隐私政策");
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
            case R.id.bt_xieyi:
                if (!utils.isDoubleClick()){
                    intent.setClass(LoginActivity.this,XieYiActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_yinsi:
                if (!utils.isDoubleClick()){
                    intent.setClass(LoginActivity.this,YinSiActivity.class);
                    startActivity(intent);
                }
        }
    }

    UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> data) {
            if (share_media == SHARE_MEDIA.WEIXIN){
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("uid",data.get("uid"));
                    jsonObject.put("name",data.get("name"));
                    jsonObject.put("iconurl",data.get("iconurl"));
                    if ("男".equals(data.get("gender"))){
                        jsonObject.put("unionGender","男");
                    }else{
                        jsonObject.put("unionGender","女");
                    }
                    initJudge(jsonObject,"weChat");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else if (share_media == SHARE_MEDIA.QQ){
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("uid",data.get("uid"));
                    jsonObject.put("name",data.get("name"));
                    jsonObject.put("iconurl",data.get("iconurl"));
                    if ("男".equals(data.get("gender"))){
                        jsonObject.put("unionGender","1");
                    }else{
                        jsonObject.put("unionGender","2");
                    }
                    initJudge(jsonObject,"qq");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }
    };

    private void initJudge(JSONObject jsonObject, String type) {
        Map<String,String> map = new HashMap<>();
        map.put("json",jsonObject.toString());
        map.put("type",type);
        OkGo.<String>post(Contacts.URl1+"/member/thirdParty/login")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        JudgeGson judgeGson = new Gson().fromJson(body, JudgeGson.class);
                        if (judgeGson.getStatus() == 1){
                            if (judgeGson.getResult().isIsExist()){
                                initLogin(judgeGson.getResult());
                            }else{
                                //绑定手机号
                                Intent intent = new Intent();
                                intent.putExtra("json",jsonObject.toString());
                                intent.putExtra("type",type);
                                intent.setClass(LoginActivity.this,BindActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                });
    }

    private void initLogin(JudgeGson.ResultBean result) {
        MyApp.instance.clear(true);
        MyApp.instance.put("id",result.getUserInfo().getUserId(),true);
        MyApp.instance.put("nickName",result.getUserInfo().getNickName(),true);
        MyApp.instance.put("phone",result.getUserInfo().getPhone(),true);
        MyApp.instance.put("photo",result.getUserInfo().getPhoto(),true);
        MyApp.instance.put("rongToken",result.getUserInfo().getRongToken(),true);
        MyApp.instance.put("token",result.getToken(),true);
        HttpParams params = new HttpParams();
        params.put("token",result.getToken());
        params.put("tokenId",String.valueOf(result.getUserInfo().getUserId()));
        OkGo.getInstance().addCommonParams(params);
        //融云登录
        RongIM.connect(result.getUserInfo().getRongToken(), new RongIMClient.ConnectCallback() {
            //token1参数报错
            @Override
            public void onTokenIncorrect() {
            }

            @Override
            public void onSuccess(String s) {
                // 调用 Handler 来异步设置别名
                mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, String.valueOf(result.getUserInfo().getUserId())));
                // 点击恢复按钮后，极光推送服务会恢复正常工作
                String lat = MyApp.instance.getString("lat");
                if (lat!=null){
                    ListenerManager.getInstance().sendBroadCast(10,"是");
                }
                JPushInterface.resumePush(getApplicationContext());
                finish();
                ToastUtils.showShort("登录成功");
                intent.setClass(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                // 连接成功，说明你已成功连接到融云Server
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
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
                    String password = utils.makeMD5(login_password);
                    Map<String,String> map = new HashMap<>();
                    map.put("tel",login_phone);
                    map.put("codeOrPass",password);
                    OkGo.<String>post(Contacts.URl1+"/member/login")
                            .params(map)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    WaitDialog.dismiss();
                                    String body = response.body();
                                    Gson gson = new Gson();
                                    Login login = gson.fromJson(body, Login.class);
                                    if (login.getStatus() == 1){
                                        MyApp.instance.put("id",login.getResult().getUserInfo().getUserId(),true);
                                        MyApp.instance.put("nickName",login.getResult().getUserInfo().getNickName(),true);
                                        MyApp.instance.put("phone",login.getResult().getUserInfo().getPhone(),true);
                                        MyApp.instance.put("photo",login.getResult().getUserInfo().getPhoto(),true);
                                        MyApp.instance.put("rongToken",login.getResult().getUserInfo().getRongToken(),true);
                                        MyApp.instance.put("token",login.getResult().getToken(),true);
                                        intent.setClass(LoginActivity.this,MainActivity.class);
                                        HttpParams params = new HttpParams();
                                        params.put("token",login.getResult().getToken());
                                        params.put("tokenId",String.valueOf(login.getResult().getUserInfo().getUserId()));
                                        OkGo.getInstance().addCommonParams(params);
                                        // 连接成功，说明你已成功连接到融云Server
                                        startActivity(intent);
                                        finish();
                                        // 调用 Handler 来异步设置别名
                                        String lat = MyApp.instance.getString("lat");
                                        if (lat!=null){
                                            ListenerManager.getInstance().sendBroadCast(10,"是");
                                        }
                                        mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, String.valueOf(login.getResult().getUserInfo().getUserId())));
                                        // 点击恢复按钮后，极光推送服务会恢复正常工作
                                        JPushInterface.resumePush(getApplicationContext());
                                        ToastUtils.showShort("登录成功");
                                    }else{
                                        ToastUtils.showShort(login.getMsg());
                                    }
                                }

                                @Override
                                public void onError(Response<String> response) {
                                    WaitDialog.dismiss();
                                    super.onError(response);
                                }

                                @Override
                                public void onStart(Request<String, ? extends Request> request) {
                                    WaitDialog.show(LoginActivity.this,"正在登录。。。");
                                    super.onStart(request);
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
                                    WaitDialog.dismiss();
                                    String body = response.body();
                                    Gson gson = new Gson();
                                    Login login = gson.fromJson(body, Login.class);
                                    if (login.getStatus() == 1){
                                        MyApp.instance.clear(true);
                                        MyApp.instance.put("id",login.getResult().getUserInfo().getUserId(),true);
                                        MyApp.instance.put("nickName",login.getResult().getUserInfo().getNickName(),true);
                                        MyApp.instance.put("phone",login.getResult().getUserInfo().getPhone(),true);
                                        MyApp.instance.put("photo",login.getResult().getUserInfo().getPhoto(),true);
                                        MyApp.instance.put("rongToken",login.getResult().getUserInfo().getRongToken(),true);
                                        MyApp.instance.put("token",login.getResult().getToken(),true);
                                        HttpParams params = new HttpParams();
                                        params.put("token",login.getResult().getToken());
                                        params.put("tokenId",String.valueOf(login.getResult().getUserInfo().getUserId()));
                                        OkGo.getInstance().addCommonParams(params);
                                        intent.setClass(LoginActivity.this,MainActivity.class);
                                        startActivity(intent);
                                        String lat = MyApp.instance.getString("lat");
                                        if (lat!=null){
                                            ListenerManager.getInstance().sendBroadCast(10,"是");
                                        }
                                        // 调用 Handler 来异步设置别名
                                        mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, String.valueOf(login.getResult().getUserInfo().getUserId())));
                                        // 点击恢复按钮后，极光推送服务会恢复正常工作
                                        JPushInterface.resumePush(getApplicationContext());
                                        finish();
                                        ToastUtils.showShort("登录成功");
                                    }else{
                                        ToastUtils.showShort(login.getMsg());
                                    }
                                }

                                @Override
                                public void onError(Response<String> response) {
                                    WaitDialog.dismiss();
                                    super.onError(response);
                                }

                                @Override
                                public void onStart(Request<String, ? extends Request> request) {
                                    WaitDialog.show(LoginActivity.this,"正在登录。。。");
                                    super.onStart(request);
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

//    //双击退出
//    @Override
//    public boolean onKeyUp(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
//            long secondTime = System.currentTimeMillis();
//            if (secondTime - firstTime > 2000) {
//                ToastUtils.showShort("再按一次退出程序");
//                firstTime = secondTime;
//                return true;
//            } else {
//                System.exit(0);
//            }
//        }
//
//        return super.onKeyUp(keyCode, event);
//    }

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
