package com.huohougongfu.app.Activity;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.Code;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class WangJiMiMa extends AppCompatActivity implements View.OnClickListener {

    private WangJiMiMa.TimerCount timerCount;
    private TextView tv_wangjimima_code;
    private EditText edt_phone,edt_code,edt_password1,edt_password2;
    private String phone,code,password1,password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang_ji_mi_ma);
        timerCount = new WangJiMiMa.TimerCount(60000, 1000);

        initUI();
    }

    private void initUI() {
        tv_wangjimima_code = findViewById(R.id.tv_wangjimima_code);
        edt_phone = findViewById(R.id.edt_zhaohuimima_phone);
        edt_code = findViewById(R.id.edt_zhaohuimima_code);
        edt_password1 = findViewById(R.id.edt_zhaohuimima_password1);
        edt_password2 = findViewById(R.id.edt_zhaohuimima_password2);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_queren).setOnClickListener(this);
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
                    phone = edt_phone.getText().toString();
                    code = edt_code.getText().toString();
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
            case R.id.bt_queren:
                phone = edt_phone.getText().toString();
                code = edt_code.getText().toString();
                password1 = edt_password1.getText().toString();
                password2 = edt_password2.getText().toString();
                if (!utils.isDoubleClick()){
                    if (!phone.isEmpty()){
                        if (!code.isEmpty()){
                            if (!password1.isEmpty()){
                                if (!password2.isEmpty()){
                                    if(password1.equals(password2)){
                                        initData();
                                    }else{
                                        ToastUtils.showShort("两次密码输入不一致");
                                    }
                                }else{
                                    ToastUtils.showShort("请确认新密码");
                                }
                            }else{
                                ToastUtils.showShort("请输入新密码");
                            }
                        }else{
                            ToastUtils.showShort("请输入验证码");
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
        map.put("type","forget");
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

    private void initData() {
        String password = utils.makeMD5(password1);
        Map<String,String> map = new HashMap<>();
        map.put("tel",phone);
        map.put("code",code);
        map.put("password",password);
        OkGo.<String>post(Contacts.URl1+"/member/forgetPass")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        Code code = gson.fromJson(body, Code.class);
                        if (code.getStatus() == 1){
                            ToastUtils.showShort(code.getMsg());
                            finish();
                        }else{
                            ToastUtils.showShort(code.getMsg());
                        }
                    }
                });
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
