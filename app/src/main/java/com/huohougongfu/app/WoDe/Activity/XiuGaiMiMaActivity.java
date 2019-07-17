package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.LoginActivity;
import com.huohougongfu.app.Gson.Code;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

import io.rong.imkit.RongIM;
import io.rong.imkit.utils.RongOperationPermissionUtils;
import io.rong.push.RongPushClient;
import io.rong.push.rongpush.RongPush;

public class XiuGaiMiMaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_xinpd1,edt_xinpd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiu_gai_mi_ma);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_xiugai).setOnClickListener(this);
        edt_xinpd1 = findViewById(R.id.edt_xinpd1);
        edt_xinpd2 = findViewById(R.id.edt_xinpd2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
            case R.id.bt_xiugai:
                if (!utils.isDoubleClick()){
                    initData();
                }
                break;
        }
    }

    private void initData() {
        String password1 = edt_xinpd1.getText().toString();
        String password = utils.makeMD5(password1);
        Map<String,String> map = new HashMap<>();
        map.put("tel",MyApp.instance.getString("phone"));
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
                            Intent intent = new Intent();
                            intent.setClass(XiuGaiMiMaActivity.this,LoginActivity.class);
                            startActivity(intent);
                            //如果断开连接后，有新消息时，不想收到任何推送通知，调用 logout() 方法。
                            RongIM.getInstance().logout();
                            ToastUtils.showShort("密码修改成功，请重新登录");
                        }else{
                            ToastUtils.showShort(code.getMsg());
                        }
                    }
                });
    }

}
