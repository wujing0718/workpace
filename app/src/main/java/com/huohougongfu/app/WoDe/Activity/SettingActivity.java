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
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.LoginActivity;
import com.huohougongfu.app.Activity.MainActivity;
import com.huohougongfu.app.Activity.XieYiActivity;
import com.huohougongfu.app.Gson.JsonBean;
import com.huohougongfu.app.Gson.MyZhuYe;
import com.huohougongfu.app.Gson.RenZhengZhuangTai;
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
import java.util.HashMap;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;
import io.rong.imkit.RongIM;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private ImageView img_my_touxiang;
    private TextView tv_my_name,tv_my_vipnum,tv_my_jianjie,tv_my_fenlei,tv_my_weizhi;
    private int id;
    private View view_weizhi;
    private TextView tv_huancun;
    private RenZhengZhuangTai renZhengZhuangTai;
    private String token,phone;
    private TextView bt_tuichudenglu;
    private SPUtils instance;
    private TextView tv_dianpu;
    private View view_vip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        instance = SPUtils.getInstance("登录");
        id = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        phone = MyApp.instance.getString("phone");
        intent = new Intent();
        initUI();
    }

    @Override
    protected void onResume() {
        initData();
        super.onResume();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(id));
        map.put("userId",String.valueOf(id));
        OkGo.<String>post(Contacts.URl1+"/homepage/info/")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyZhuYe xinxi = gson.fromJson(body, MyZhuYe.class);
                        if (xinxi.getStatus() == 1){
                            if (xinxi.getResult()!=null){
                                initView(xinxi.getResult());
                            }
                        }
                    }
                });
        OkGo.<String>get(Contacts.URl1+"/my/certificationStatus/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        renZhengZhuangTai = gson.fromJson(body, RenZhengZhuangTai.class);
                    }
                });
    }

    private void initView(MyZhuYe.ResultBean result) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(result.getPhoto()).apply(requestOptions).into(img_my_touxiang);
        if (result.isVip()){
            view_vip.setVisibility(View.VISIBLE);
            tv_my_vipnum.setText("."+result.getMemberLevel());
        }else{
            view_vip.setVisibility(View.GONE);
        }
        tv_my_name.setText(result.getNickName());
        if (result.isIsMerchant()){
            tv_dianpu.setVisibility(View.VISIBLE);
        }else {
            tv_dianpu.setVisibility(View.GONE);
        }
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
        tv_dianpu = findViewById(R.id.tv_dianpu);
         view_vip = findViewById(R.id.view_vip);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_bianji).setOnClickListener(this);
        findViewById(R.id.bt_shouhuodizhi).setOnClickListener(this);
        findViewById(R.id.bt_renzheng).setOnClickListener(this);
        findViewById(R.id.bt_anquanzhongxin).setOnClickListener(this);
        bt_tuichudenglu = findViewById(R.id.bt_tuichudenglu);
        bt_tuichudenglu.setOnClickListener(this);
        if (!token.isEmpty()){
            bt_tuichudenglu.setText("退出当前账户");
        }else{
            bt_tuichudenglu.setText("登录");
        }
        findViewById(R.id.bt_qingchuhuancun).setOnClickListener(this);
        findViewById(R.id.bt_obout).setOnClickListener(this);
        findViewById(R.id.bt_yonghuxieyi).setOnClickListener(this);
        view_weizhi = findViewById(R.id.view_weizhi);
        tv_huancun = findViewById(R.id.tv_huancun);
        img_my_touxiang = findViewById(R.id.img_my_touxiang);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(R.mipmap.img_zhanweitu).apply(requestOptions).into(img_my_touxiang);
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
                    //认证
                    initReView();
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
                    if (!token.isEmpty()){
                        SelectDialog.show(SettingActivity.this, "提示", "是否退出登录",
                                "确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(!utils.isDoubleClick()){
                                            //如果断开连接后，有新消息时，不想收到任何推送通知，调用 logout() 方法。
                                            instance.clear(true);
                                            RongIM.getInstance().logout();
                                            JPushInterface.stopPush(SettingActivity.this);
                                            intent.setClass(SettingActivity.this,LoginActivity.class);
                                            startActivity(intent);
                                            MainActivity.activity.finish();
                                            finish();
                                        }
                                    }
                                },
                                "取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });
                    }else{
                        JPushInterface.stopPush(SettingActivity.this);
                        intent.setClass(SettingActivity.this,LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
                break;
        }
    }

    private void initReView() {
        if (renZhengZhuangTai!=null){
            if (renZhengZhuangTai.getStatus() == 1){
                if (renZhengZhuangTai.getResult().getPerson().getCode() == 0){
                    intent.setClass(SettingActivity.this,GeRenRenZhengActivity.class);
                    startActivity(intent);
                }else if (renZhengZhuangTai.getResult().getPerson().getCode() == 2){
                    if (renZhengZhuangTai.getResult().getStore().getCode() ==3 && renZhengZhuangTai.getResult().getMaster().getCode() ==3){
                        intent.setClass(SettingActivity.this,RealNameActivity.class);
                        startActivity(intent);
                    }else if (renZhengZhuangTai.getResult().getMaster().getCode() == 0) {
                        //茶师认证失败
                        intent.putExtra("code","茶师认证失败");
                        intent.setClass(SettingActivity.this,FailedViewActivity.class);
                        startActivity(intent);
                    } else if (renZhengZhuangTai.getResult().getStore().getCode() == 0) {
                        //商户认证失败
                        intent.putExtra("code","商户认证失败");
                        intent.setClass(SettingActivity.this,FailedViewActivity.class);
                        startActivity(intent);
                    } else  if (renZhengZhuangTai.getResult().getStore().getCode() ==2) {
                        if (renZhengZhuangTai.getResult().getSpecialBrand().getCode() == 2){
                            //特约品牌认证成功界面
                            intent.putExtra("code","特约品牌认证成功");
                            intent.setClass(SettingActivity.this,SucceedViewActivity.class);
                            startActivity(intent);
                        }else{
                            //商户认证成功界面
                            intent.putExtra("code","商户认证成功");
                            intent.setClass(SettingActivity.this,SucceedViewActivity.class);
                            startActivity(intent);
                        }
                    } else if (renZhengZhuangTai.getResult().getMaster().getCode() == 1 || renZhengZhuangTai.getResult().getStore().getCode() ==1) {
                        //茶师认证或者商户认证审核中
                        //茶师认证或者商户审核中界面
                        finish();
                        intent.setClass(SettingActivity.this,ReviewViewActivity.class);
                        startActivity(intent);
                    } else if (renZhengZhuangTai.getResult().getMaster().getCode() ==2){
                        //茶师认证成功界面
                        intent.putExtra("code","茶师认证成功");
                        intent.setClass(SettingActivity.this,SucceedViewActivity.class);
                        startActivity(intent);
                    }else{
                        intent.setClass(SettingActivity.this,RealNameActivity.class);
                        startActivity(intent);
                    }
                }
            }
        }else{
            //茶师认证成功界面
            intent.putExtra("code","个人认证成功");
            intent.setClass(SettingActivity.this,SucceedViewActivity.class);
            startActivity(intent);
        }
    }
}
