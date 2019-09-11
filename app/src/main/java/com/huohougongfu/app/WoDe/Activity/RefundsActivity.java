package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.DingDanGuanLi;
import com.huohougongfu.app.Gson.ReturnDetails;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.imkit.RongIM;

public class RefundsActivity extends AppCompatActivity {

    private TextView tv_shop_name,tv_shop_standard,tv_shop_num,tv_RefundAmount,tv_RefundPath,
            tv_reasonForReturn,tv_shenqingshijian,tv_type,tv_tuikuanbianhao;
    private String type;
    private DingDanGuanLi.ResultBean data;
    private String orderNo;
    private ImageView img_photo;
    private ReturnDetails returnDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refunds);
        orderNo = getIntent().getStringExtra("orderNo");
        initUI();
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("orderNo",orderNo);
        map.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
        OkGo.<String>get(Contacts.URl1+"order/orderManage/afterSale")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        returnDetails = gson.fromJson(body, ReturnDetails.class);
                        if (returnDetails.getStatus() == 1){
                            initView(returnDetails.getResult());
                        }
                    }
                });
    }

    private void initView(List<ReturnDetails.ResultBean> result) {
        tv_shop_name.setText(result.get(0).getProducts().get(0).getName());
        Glide.with(MyApp.context).load(result.get(0).getProducts().get(0).getCoverUrl()).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu).circleCrop())
                .into(img_photo);
        tv_shop_standard.setText(result.get(0).getProducts().get(0).getStandard());
        tv_shop_num.setText(String.valueOf(result.get(0).getProducts().get(0).getNum()));
        tv_RefundAmount.setText(String.valueOf(result.get(0).getProducts().get(0).getPrice()));
        tv_RefundPath.setText(result.get(0).getRefundChannel());
        tv_reasonForReturn.setText(result.get(0).getReason());
        tv_shenqingshijian.setText(result.get(0).getCreateTime());
        tv_tuikuanbianhao.setText(result.get(0).getOrderNo());

    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.bt_contactBuyer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().startPrivateChat(RefundsActivity.this,
                        returnDetails.getResult().get(0).getPhone(),returnDetails.getResult().get(0).getPhone());
            }
        });
        findViewById(R.id.bt_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPhone(returnDetails.getResult().get(0).getPhone());
            }
        });
        findViewById(R.id.bt_wuliu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("logisticsName",returnDetails.getResult().get(0).getExpressCompany());
                intent.putExtra("logisticsNo",returnDetails.getResult().get(0).getExpressNo());
                intent.setClass(RefundsActivity.this,WuLiuActivity.class);
                startActivity(intent);
            }
        });
        img_photo = findViewById(R.id.img_photo);
        tv_shop_name = findViewById(R.id.tv_shop_name);
        tv_shop_standard = findViewById(R.id.tv_shop_standard);
        tv_shop_num = findViewById(R.id.tv_shop_num);
        tv_RefundAmount = findViewById(R.id.tv_RefundAmount);
        tv_RefundPath = findViewById(R.id.tv_RefundPath);
        tv_reasonForReturn = findViewById(R.id.tv_reasonForReturn);
        tv_shenqingshijian = findViewById(R.id.tv_shenqingshijian);
        tv_tuikuanbianhao = findViewById(R.id.tv_tuikuanbianhao);
    }
    public void callPhone(String phoneNum){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }
}
