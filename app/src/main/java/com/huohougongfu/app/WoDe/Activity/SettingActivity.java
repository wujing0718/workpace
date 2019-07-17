package com.huohougongfu.app.WoDe.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.LoginActivity;
import com.huohougongfu.app.Activity.XieYiActivity;
import com.huohougongfu.app.Gson.JsonBean;
import com.huohougongfu.app.Gson.MyZhuYe;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.DataCleanManager;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.SelectDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;

import cn.jpush.android.api.JPushInterface;
import io.rong.imkit.RongIM;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private ImageView img_my_touxiang;
    private TextView tv_my_name,tv_my_vipnum,tv_my_jianjie,tv_my_fenlei,tv_my_weizhi;
    private int id;
    private View view_weizhi;
    private TextView tv_huancun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        id = MyApp.instance.getInt("id");
        intent = new Intent();
        initUI();
    }

    @Override
    protected void onResume() {
        initData();
        super.onResume();
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"/homepage/info/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyZhuYe xinxi = gson.fromJson(body, MyZhuYe.class);
                        if (xinxi.getStatus() == 1){
                            initView(xinxi.getResult());
                        }
                    }
                });
    }

    private void initView(MyZhuYe.ResultBean result) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(this).load(result.getPhoto()).apply(requestOptions).into(img_my_touxiang);
        tv_my_name.setText(result.getNickName());
        tv_my_vipnum.setText("1");

        if (result.getPlace()!=null){
            view_weizhi.setVisibility(View.VISIBLE);
            tv_my_weizhi.setText(result.getPlace());
        }else{
            view_weizhi.setVisibility(View.GONE);
        }
        if (result.getPersonalProfile()!= null){
            tv_my_jianjie.setText(result.getPersonalProfile());
        }else{
            tv_my_jianjie.setText("暂无简介");
        }
        tv_my_fenlei.setText(result.getMaster().getLevel());
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_bianji).setOnClickListener(this);
        findViewById(R.id.bt_shouhuodizhi).setOnClickListener(this);
        findViewById(R.id.bt_renzheng).setOnClickListener(this);
        findViewById(R.id.bt_anquanzhongxin).setOnClickListener(this);
        findViewById(R.id.bt_tuichudenglu).setOnClickListener(this);
        findViewById(R.id.bt_qingchuhuancun).setOnClickListener(this);
        findViewById(R.id.bt_obout).setOnClickListener(this);
        findViewById(R.id.bt_yonghuxieyi).setOnClickListener(this);
        view_weizhi = findViewById(R.id.view_weizhi);
        tv_huancun = findViewById(R.id.tv_huancun);
        img_my_touxiang = findViewById(R.id.img_my_touxiang);
        tv_my_name = findViewById(R.id.tv_my_name);
        tv_my_vipnum = findViewById(R.id.tv_my_vipnum);
        tv_my_jianjie = findViewById(R.id.tv_my_jianjie);
        tv_my_fenlei = findViewById(R.id.tv_my_fenlei);
        tv_my_weizhi = findViewById(R.id.tv_my_weizhi);
        try {
            String totalCacheSize = DataCleanManager.getTotalCacheSize(SettingActivity.this);
            tv_huancun.setText(totalCacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_shouhuodizhi:
                if (!utils.isDoubleClick()){
                    intent.setClass(SettingActivity.this,AddressActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_bianji:
                if (!utils.isDoubleClick()){
                    intent.setClass(SettingActivity.this,PersonalActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_renzheng:
                if (!utils.isDoubleClick()){
                    intent.setClass(SettingActivity.this,RenZhengActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_anquanzhongxin:
                if (!utils.isDoubleClick()){
                    intent.setClass(SettingActivity.this,AnQuanZhongXinActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_obout:
                if (!utils.isDoubleClick()){
                    intent.setClass(SettingActivity.this,OboutActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_yonghuxieyi:
                if (!utils.isDoubleClick()){
                    intent.setClass(SettingActivity.this,XieYiActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_qingchuhuancun:
                if (!utils.isDoubleClick()){
                    if (tv_huancun.getText().toString().equals("0KB")){
                        ToastUtils.showShort("已经很干净了！");
                    }else {
                        SelectDialog.show(SettingActivity.this, "提示", "是否清除缓存",
                                "确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(!utils.isDoubleClick()){
                                            DataCleanManager.clearAllCache(SettingActivity.this);
                                            ToastUtils.showShort("清除成功");
                                            tv_huancun.setText("0KB");
                                        }
                                    }
                                },
                                "取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                    }
                }
                break;
            case R.id.bt_tuichudenglu:
                if (!utils.isDoubleClick()){
                    SelectDialog.show(SettingActivity.this, "提示", "是否退出登录",
                            "确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if(!utils.isDoubleClick()){
                                        //如果断开连接后，有新消息时，不想收到任何推送通知，调用 logout() 方法。
                                        RongIM.getInstance().logout();
                                        JPushInterface.stopPush(SettingActivity.this);
                                        intent.setClass(SettingActivity.this,LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            },
                            "取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });

                }
                break;
        }
    }
}
