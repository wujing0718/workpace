package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.RenZhengZhuangTai;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class SucceedViewActivity extends AppCompatActivity implements View.OnClickListener {

    private int id;
    private TextView tv_name,tv_renzheng_level,tv_renzheng_idCard;
    private String code;
    private TextView bt_zanburenzheng,bt_jixurenzheng,tv_renzheng_shanchang;
    private RenZhengZhuangTai renZhengZhuangTai;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succeed_view);
        code = getIntent().getStringExtra("code");
        intent = new Intent();
        id = MyApp.instance.getInt("id");
        initUI();
        initData();
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        bt_zanburenzheng = findViewById(R.id.bt_zanburenzheng);
        bt_zanburenzheng.setOnClickListener(this);
        bt_jixurenzheng = findViewById(R.id.bt_jixurenzheng);
        bt_jixurenzheng.setOnClickListener(this);

        tv_name = findViewById(R.id.tv_renzheng_name);
        tv_renzheng_shanchang = findViewById(R.id.tv_renzheng_shanchang);
        tv_renzheng_level = findViewById(R.id.tv_renzheng_level);
        tv_renzheng_idCard = findViewById(R.id.tv_renzheng_idCard);

    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"/my/certificationStatus/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                         renZhengZhuangTai = gson.fromJson(body, RenZhengZhuangTai.class);
                        if (renZhengZhuangTai.getStatus() == 1){
                            if (renZhengZhuangTai.getResult().getPerson().getCode() == 2){
                                initView(renZhengZhuangTai);
                            }
                        }
                    }
                });
    }

    private void initView(RenZhengZhuangTai renZhengZhuangTai) {
        if ("茶师认证成功".equals(code)){
            tv_renzheng_shanchang.setVisibility(View.VISIBLE);
            tv_name.setText("姓名："+renZhengZhuangTai.getResult().getMaster().getInfo().getRealName());
            tv_renzheng_level.setText("职称："+renZhengZhuangTai.getResult().getMaster().getInfo().getLevel());
            tv_renzheng_idCard.setText("身份证号："+renZhengZhuangTai.getResult().getMaster().getInfo().getIdCard());
            tv_renzheng_shanchang.setText("擅长："+renZhengZhuangTai.getResult().getMaster().getInfo().getSpecialty());
            if (renZhengZhuangTai.getResult().getStore().getCode() ==2){
                if (renZhengZhuangTai.getResult().getSpecialBrand().getCode() ==2){
                    bt_zanburenzheng.setVisibility(View.GONE);
                    bt_jixurenzheng.setVisibility(View.GONE);
                }else{
                    bt_zanburenzheng.setVisibility(View.GONE);
                    bt_jixurenzheng.setText("特约品牌认证");
                }
            }else{
                bt_zanburenzheng.setVisibility(View.GONE);
                bt_jixurenzheng.setText("进行商户认证");
            }
        }else if ("商户认证成功".equals(code)){
            if (renZhengZhuangTai.getResult().getMaster().getCode() == 2){
                if (renZhengZhuangTai.getResult().getSpecialBrand().getCode() == 2){
                    bt_zanburenzheng.setVisibility(View.GONE);
                    bt_jixurenzheng.setVisibility(View.GONE);
                }else{
                    bt_zanburenzheng.setVisibility(View.GONE);
                    bt_jixurenzheng.setText("特约品牌认证");
                }
            }else{
                bt_zanburenzheng.setText("进行茶师认证");
                bt_jixurenzheng.setText("特约品牌认证");
            }
            tv_renzheng_shanchang.setVisibility(View.VISIBLE);
            tv_name.setText("店铺名："+renZhengZhuangTai.getResult().getStore().getInfo().getStoreName());
            tv_renzheng_level.setText("经营者："+renZhengZhuangTai.getResult().getStore().getInfo().getRealName());
            tv_renzheng_idCard.setText("身份证号："+renZhengZhuangTai.getResult().getStore().getInfo().getIdCard());
            tv_renzheng_shanchang.setText("银行卡："+renZhengZhuangTai.getResult().getStore().getInfo().getBankCard());
        }else if ("个人认证成功".equals(code)){
            tv_renzheng_shanchang.setVisibility(View.GONE);
            tv_name.setText("姓名："+renZhengZhuangTai.getResult().getPerson().getInfo().getRealName());
            tv_renzheng_level.setText("职称："+renZhengZhuangTai.getResult().getPerson().getInfo().getLevel());
            tv_renzheng_idCard.setText("身份证号："+renZhengZhuangTai.getResult().getPerson().getInfo().getIdCard());
            bt_zanburenzheng.setVisibility(View.GONE);
            bt_jixurenzheng.setVisibility(View.GONE);
        }else if("特约品牌认证成功".equals(code)){
            tv_renzheng_shanchang.setVisibility(View.VISIBLE);
            tv_name.setText("店铺名："+renZhengZhuangTai.getResult().getSpecialBrand().getInfo().getStoreName());
            tv_renzheng_level.setText("经营者："+renZhengZhuangTai.getResult().getSpecialBrand().getInfo().getRealName());
            tv_renzheng_idCard.setText("身份证号："+renZhengZhuangTai.getResult().getSpecialBrand().getInfo().getIdCard());
            tv_renzheng_shanchang.setText("银行卡："+renZhengZhuangTai.getResult().getSpecialBrand().getInfo().getBankCard());
            if (renZhengZhuangTai.getResult().getMaster().getCode() == 2){
                bt_zanburenzheng.setVisibility(View.GONE);
                bt_jixurenzheng.setVisibility(View.GONE);
            }else{
                bt_zanburenzheng.setVisibility(View.GONE);
                bt_jixurenzheng.setText("进行茶师认证");
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_zanburenzheng:
                String renzhengone = bt_zanburenzheng.getText().toString();
                if ("特约品牌认证".equals(renzhengone)){
                    intent.setClass(SucceedViewActivity.this,SpecialBrandActivity.class);
                    startActivity(intent);
                }else if ("进行商户认证".equals(renzhengone)){
                    intent.setClass(SucceedViewActivity.this,ShangHuRenZhengActivity.class);
                }else if ("进行茶师认证".equals(renzhengone)){
                    intent.setClass(SucceedViewActivity.this,ChaShiRenZhengActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_jixurenzheng:
                String renzhengtwo = bt_jixurenzheng.getText().toString();
                if ("特约品牌认证".equals(renzhengtwo)){
                    intent.setClass(SucceedViewActivity.this,SpecialBrandActivity.class);
                    startActivity(intent);
                }else if ("进行商户认证".equals(renzhengtwo)){
                    intent.setClass(SucceedViewActivity.this,ShangHuRenZhengActivity.class);
                    startActivity(intent);
                }else if ("进行茶师认证".equals(renzhengtwo)){
                    intent.setClass(SucceedViewActivity.this,ChaShiRenZhengActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
