package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FanKuiActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_fankui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_kui);
        initUI();
    }

    private void initUI() {
        edt_fankui = findViewById(R.id.edt_fankui);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_fankui).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
            case R.id.bt_fankui:
                String fankun = edt_fankui.getText().toString();
                if (!utils.isDoubleClick()){
                    if (!"".equals(fankun)){
                        initFanKui(fankun);
                    }else{
                        ToastUtils.showShort("请输入反馈的内容");
                    }
                }
                break;
        }
    }

    private void initFanKui(String fankun) {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("content", fankun);
        OkGo.<String>post(Contacts.URl1+"/my/feedback")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                finish();
                                ToastUtils.showShort("反馈成功");
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
