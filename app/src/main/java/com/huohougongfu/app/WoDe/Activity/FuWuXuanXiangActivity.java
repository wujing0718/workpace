package com.huohougongfu.app.WoDe.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.FuHuoShiJian;
import com.huohougongfu.app.PopupView.Paocha;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FuWuXuanXiangActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private TextView tv_fahuo_time;
    private String fahuoshijian;
    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                   fahuoshijian = (String)msg.obj;
                   if (fahuoshijian.equals("24")){
                       tv_fahuo_time.setText("24小时内");
                   }else{
                       tv_fahuo_time.setText(fahuoshijian+"天内");
                   }
                    break;
                default:
                    break;
            }
        }

    };
    private ImageView img_check_xinyongka;
    private boolean isxinyongka = true;
    private int creditCard,deliveryTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fu_wu_xuan_xiang);
        creditCard = getIntent().getIntExtra("creditCard", 0);
        deliveryTime = getIntent().getIntExtra("deliveryTime", 0);

        intent = new Intent();
        initUI();

    }

    private void initUI() {
        findViewById(R.id.bt_xuanze_time).setOnClickListener(this);
        findViewById(R.id.bt_xinyongka).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_queding).setOnClickListener(this);
        img_check_xinyongka = findViewById(R.id.img_check_xinyongka);
        tv_fahuo_time = findViewById(R.id.tv_fahuo_time);
        if (creditCard == 1){
            img_check_xinyongka.setImageResource(R.mipmap.select);
            isxinyongka = false;
        }else{
            img_check_xinyongka.setImageResource(R.mipmap.unselect);
            isxinyongka = true;
        }
        if (deliveryTime == 1){
            tv_fahuo_time.setText("24小时内");
        }else{
            tv_fahuo_time.setText(deliveryTime+"天内");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_xuanze_time:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(this)
                            .asCustom(new FuHuoShiJian(this,mHandler))
                            .show();
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_xinyongka:
                if (isxinyongka){
                    img_check_xinyongka.setImageResource(R.mipmap.select);
                    isxinyongka = false;
                }else{
                    img_check_xinyongka.setImageResource(R.mipmap.unselect);
                    isxinyongka = true;
                }
                break;
            case R.id.bt_queding:
                if (!utils.isDoubleClick()){
                    Map<String,String> map = new HashMap<>();
                    if (!isxinyongka){
                        map.put("creditCard","1");
                    }else{
                        map.put("creditCard","0");
                    }
                    if ("24".equals(fahuoshijian)){
                        map.put("deliveryTime","1");
                    }else{
                        map.put("deliveryTime",fahuoshijian);
                    }
                    initQueDing(map);
                }
                break;
        }
    }

    private void initQueDing(Map<String,String> map) {
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        OkGo.<String>post(Contacts.URl1+"/store/serviceOptions")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                finish();
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
