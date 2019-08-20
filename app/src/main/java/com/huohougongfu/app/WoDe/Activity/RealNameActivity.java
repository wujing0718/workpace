package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.RenZhengZhuangTai;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.FuWu;
import com.huohougongfu.app.PopupView.XingBie;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RealNameActivity extends AppCompatActivity implements View.OnClickListener {


    private int id;
    private View view_renzheng;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_name);
        id = MyApp.instance.getInt("id");
        intent = new Intent();
        initUI();
    }

    private void initUI() {
        view_renzheng = findViewById(R.id.view_renzheng);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_chashi_renzheng).setOnClickListener(this);
        findViewById(R.id.bt_shanghu_renzheng).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_chashi_renzheng:
                startActivity(intent.setClass(RealNameActivity.this,ChaShiRenZhengActivity.class));
                break;
            case R.id.bt_shanghu_renzheng:
                startActivity(intent.setClass(RealNameActivity.this,ShangHuRenZhengActivity.class));
                break;
            case R.id.bt_finish:
                finish();
                break;
        }
    }
}
