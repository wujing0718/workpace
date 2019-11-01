package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.DianPuXinXi;
import com.huohougongfu.app.Gson.RenZhengZhuangTai;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.TeBieShuoMingActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

public class DianPuSettingActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_dianpu_name;
    private Intent intent;
    private DianPuXinXi dianPuXinXi;
    private RenZhengZhuangTai renZhengZhuangTai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dian_pu_setting);
        intent = new Intent();
        initUI();
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        OkGo.<String>get(Contacts.URl1+"/store/info")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        dianPuXinXi = gson.fromJson(body, DianPuXinXi.class);
                        if (dianPuXinXi.getStatus() == 1){
                            initView(dianPuXinXi);
                        }
                    }
                });
        OkGo.<String>get(Contacts.URl1+"/my/certificationStatus/"+MyApp.instance.getInt("id"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        renZhengZhuangTai = gson.fromJson(body, RenZhengZhuangTai.class);
                    }
                });
    }

    private void initView(DianPuXinXi dianPuXinXi) {
        if (dianPuXinXi.getResult()!=null){
            edt_dianpu_name.setText(dianPuXinXi.getResult().getStoreName());
        }
    }

    private void initUI() {
        edt_dianpu_name = findViewById(R.id.edt_dianpu_name);
        findViewById(R.id.bt_dianpu_renzheng).setOnClickListener(this);
        findViewById(R.id.bt_dianpu_tebieshuoming).setOnClickListener(this);
        findViewById(R.id.bt_dianpu_fuwuxuanxiang).setOnClickListener(this);
        findViewById(R.id.bt_dianpu_yunfei_setting).setOnClickListener(this);
        findViewById(R.id.bt_dianpu_manjian_youhui).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case R.id.bt_dianpu_renzheng:
               if (!utils.isDoubleClick()){
                   if (renZhengZhuangTai!=null){
                       if (renZhengZhuangTai.getStatus() == 1){
                           if (renZhengZhuangTai.getResult().getPerson().getCode() == 0){
                               intent.setClass(DianPuSettingActivity.this,GeRenRenZhengActivity.class);
                               startActivity(intent);
                           }else if (renZhengZhuangTai.getResult().getPerson().getCode() == 2){
                               if (renZhengZhuangTai.getResult().getStore().getCode() ==3 && renZhengZhuangTai.getResult().getMaster().getCode() ==3){
                                   intent.setClass(DianPuSettingActivity.this,RealNameActivity.class);
                                   startActivity(intent);
                               }else if (renZhengZhuangTai.getResult().getMaster().getCode() == 0) {
                                   //茶师认证失败
                                   intent.putExtra("code","茶师认证失败");
                                   intent.setClass(DianPuSettingActivity.this,FailedViewActivity.class);
                                   startActivity(intent);
                               } else if (renZhengZhuangTai.getResult().getStore().getCode() == 0) {
                                   //商户认证失败
                                   intent.putExtra("code","商户认证失败");
                                   intent.setClass(DianPuSettingActivity.this,FailedViewActivity.class);
                                   startActivity(intent);
                               } else if (renZhengZhuangTai.getResult().getMaster().getCode() == 6) {
                                   //商户认证失败
                                   intent.putExtra("code","大师认证失败");
                                   intent.setClass(DianPuSettingActivity.this,FailedViewActivity.class);
                                   startActivity(intent);
                               }else  if (renZhengZhuangTai.getResult().getStore().getCode() ==2) {
                                   if(renZhengZhuangTai.getResult().getMaster().getCode() == 5){
                                       //茶师认证成功界面
                                       intent.putExtra("code","茶师认证成功");
                                       intent.setClass(DianPuSettingActivity.this,SucceedViewActivity.class);
                                       startActivity(intent);
                                   }else if (renZhengZhuangTai.getResult().getMaster().getCode() == 0){
                                       //茶师认证失败
                                       intent.putExtra("code","茶师认证失败");
                                       intent.setClass(DianPuSettingActivity.this,FailedViewActivity.class);
                                       startActivity(intent);
                                   }else if (renZhengZhuangTai.getResult().getMaster().getCode() == 4){
                                       //大师认证或者商户审核中界面
                                       finish();
                                       intent.setClass(DianPuSettingActivity.this,ReviewViewActivity.class);
                                       startActivity(intent);
                                   }else if (renZhengZhuangTai.getResult().getMaster().getCode() == 6){
                                       //大师认证失败
                                       intent.putExtra("code","大师认证失败");
                                       intent.setClass(DianPuSettingActivity.this,FailedViewActivity.class);
                                       startActivity(intent);
                                   }else if(renZhengZhuangTai.getResult().getMaster().getCode() == 2){
                                       //茶师认证成功界面
                                       intent.putExtra("code","茶师认证成功");
                                       intent.setClass(DianPuSettingActivity.this,SucceedViewActivity.class);
                                       startActivity(intent);
                                   } else if(renZhengZhuangTai.getResult().getMaster().getCode() == 5){
                                       //大师认证成功界面
                                       intent.putExtra("code","大师认证成功");
                                       intent.setClass(DianPuSettingActivity.this,SucceedViewActivity.class);
                                       startActivity(intent);
                                   }else if(renZhengZhuangTai.getResult().getMaster().getCode() == 1){
                                       //茶师认证或者商户审核中界面
                                       finish();
                                       intent.setClass(DianPuSettingActivity.this,ReviewViewActivity.class);
                                       startActivity(intent);
                                   }else if(renZhengZhuangTai.getResult().getSpecialBrand().getCode() == 2) {
                                       //特约品牌认证成功
                                       intent.putExtra("code", "特约品牌认证成功");
                                       intent.setClass(DianPuSettingActivity.this, SucceedViewActivity.class);
                                       startActivity(intent);
                                   } else if (renZhengZhuangTai.getResult().getSpecialBrand().getCode() == 1){
                                       //茶师认证或者商户审核中界面
                                       finish();
                                       intent.setClass(DianPuSettingActivity.this,ReviewViewActivity.class);
                                       startActivity(intent);
                                   }else if (renZhengZhuangTai.getResult().getSpecialBrand().getCode() == 0){
                                       //特约品牌认证失败
                                       intent.putExtra("code","特约品牌认证失败");
                                       intent.setClass(DianPuSettingActivity.this,FailedViewActivity.class);
                                       startActivity(intent);
                                   }else{
                                       //商户认证成功界面
                                       intent.putExtra("code","商户认证成功");
                                       intent.setClass(DianPuSettingActivity.this,SucceedViewActivity.class);
                                       startActivity(intent);
                                   }
                               } else if (renZhengZhuangTai.getResult().getMaster().getCode() == 1 || renZhengZhuangTai.getResult().getStore().getCode() ==1 ||
                                       renZhengZhuangTai.getResult().getSpecialBrand().getCode() == 1 || renZhengZhuangTai.getResult().getMaster().getCode() ==4) {
                                   //茶师认证或者商户认证审核中
                                   //茶师认证或者商户审核中界面
                                   finish();
                                   intent.setClass(DianPuSettingActivity.this,ReviewViewActivity.class);
                                   startActivity(intent);
                               } else if (renZhengZhuangTai.getResult().getMaster().getCode() ==2){
                                   //茶师认证成功界面
                                   intent.putExtra("code","茶师认证成功");
                                   intent.setClass(DianPuSettingActivity.this,SucceedViewActivity.class);
                                   startActivity(intent);
                               }else if (renZhengZhuangTai.getResult().getMaster().getCode() ==3){
                                   intent.setClass(DianPuSettingActivity.this,RealNameActivity.class);
                                   startActivity(intent);
                               }else if (renZhengZhuangTai.getResult().getStore().getCode() ==3){
                                   intent.setClass(DianPuSettingActivity.this,RealNameActivity.class);
                                   startActivity(intent);
                               }
                           }
                       }
                   }else{
                       //茶师认证成功界面
                       intent.putExtra("code","个人认证成功");
                       intent.setClass(DianPuSettingActivity.this,SucceedViewActivity.class);
                       startActivity(intent);
                   }
               }
            break;
            case R.id.bt_dianpu_tebieshuoming:
                if (!utils.isDoubleClick()){
                    intent.putExtra("specialInstructions",dianPuXinXi.getResult().getSpecialInstructions());
                    intent.setClass(DianPuSettingActivity.this,TeBieShuoMingActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_dianpu_fuwuxuanxiang:
                if (!utils.isDoubleClick()){
                    intent.putExtra("creditCard",dianPuXinXi.getResult().getCreditCard());
                    intent.putExtra("deliveryTime",dianPuXinXi.getResult().getDeliveryTime());
                    intent.setClass(DianPuSettingActivity.this,FuWuXuanXiangActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_dianpu_yunfei_setting:
                if (!utils.isDoubleClick()){
                    intent.setClass(DianPuSettingActivity.this,YunFeiSettingActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_dianpu_manjian_youhui:
                if (!utils.isDoubleClick()){
                    intent.setClass(DianPuSettingActivity.this,DianPuMainJianActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
        }
    }
}
