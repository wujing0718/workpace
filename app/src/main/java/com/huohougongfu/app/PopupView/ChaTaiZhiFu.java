package com.huohougongfu.app.PopupView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.WXPay;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Activity.MyDingDanPaoChaActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.PayResult;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.core.BottomPopupView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.mm.opensdk.modelpay.PayReq;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class ChaTaiZhiFu extends BottomPopupView implements View.OnClickListener {
    private String orderNo;
    private String result;
    private Context context;
    private double total_price;
    private CheckBox check_yue,check_ali,check_weixin;
    private String alitoken;
    private static final int SDK_PAY_FLAG = 1001;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SDK_PAY_FLAG:
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    //同步获取结果
                    String resultInfo = payResult.getResult();
//                    Log.i("Pay", "Pay:" + resultInfo);
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        dismiss();
                        Toast.makeText(context, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        dismiss();
                        Toast.makeText(context, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };
    private TextView tv_total_price;
    private String wxtoken;

    public ChaTaiZhiFu(@NonNull Context context, String result, double total_price) {
        super(context);
        this.result = result;
        this.context= context;
        this.total_price = total_price;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_zhifu;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        check_yue = findViewById(R.id.check_yue);
        check_ali = findViewById(R.id.check_ali);
        check_weixin = findViewById(R.id.check_weixin);
        tv_total_price = findViewById(R.id.tv_total_price);
        tv_total_price.setText("¥"+total_price);
        check_yue.setClickable(false);
        check_ali.setClickable(false);
        check_weixin.setClickable(false);
        findViewById(R.id.bt_pay).setOnClickListener(this);
        findViewById(R.id.bt_guanbi).setOnClickListener(this);
        findViewById(R.id.bt_yue).setOnClickListener(this);
        findViewById(R.id.bt_alipay).setOnClickListener(this);
        findViewById(R.id.bt_weixin).setOnClickListener(this);
    }

    //支付宝支付
    private void initALi() {
        if (orderNo!=null){
            OkGo.<String>post(Contacts.URl1+"/pay/alipay")
                    .params("orderNo",orderNo)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    alitoken = jsonObject.getString("result");
                                    initALiPay();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }else{
            OkGo.<String>post(Contacts.URl1+"/pay/alipay")
                    .params("orderNo",result)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    alitoken = jsonObject.getString("result");
                                    initALiPay();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }

    }

    private void initWX(){
        OkGo.<String>post(Contacts.URl1+"/pay/wxpay")
                .params("orderNo",result)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                wxtoken = jsonObject.getString("result");
                                initWXPay();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_guanbi:
                dismiss();
                break;
            case R.id.bt_yue:
                check_yue.setChecked(true);
                check_ali.setChecked(false);
                check_weixin.setChecked(false);
                break;
            case R.id.bt_alipay:
                check_yue.setChecked(false);
                check_ali.setChecked(true);
                check_weixin.setChecked(false);
                break;
            case R.id.bt_weixin:
                check_yue.setChecked(false);
                check_ali.setChecked(false);
                check_weixin.setChecked(true);
                break;
            case R.id.bt_pay:
                if (check_yue.isChecked()){
                    check_ali.setChecked(false);
                    check_weixin.setChecked(false);
                    ToastUtils.showShort("暂不支持余额支付");
                }else if (check_ali.isChecked()){
                    check_yue.setChecked(false);
                    check_weixin.setChecked(false);
                    initALi();
                }else{
                    check_yue.setChecked(false);
                    check_ali.setChecked(false);
                    initWX();
                }
                break;
        }
    }

    private void initWXPay() {
        if(!utils.isWeixinAvilible(MyApp.context)) {
            Toast.makeText(context,"您未安装最新版本微信，不支持微信支付，请安装或升级微信版本",Toast.LENGTH_SHORT).show();
        }else {
            Gson gson = new Gson();
            WXPay wxPay = gson.fromJson(wxtoken, WXPay.class);
            Runnable payRunnable = new Runnable() {  //这里注意要放在子线程
                @Override
                public void run() {
                    PayReq req = new PayReq();
                    req.appId = wxPay.getAppid();
                    req.partnerId = wxPay.getPartnerid();
                    req.prepayId = wxPay.getPrepayid();
                    req.nonceStr = wxPay.getNoncestr();
                    req.timeStamp =String.valueOf(wxPay.getTimestamp());
                    req.packageValue = wxPay.getPackageX();
                    req.sign = wxPay.getSign();
                    MyApp.wxapi.sendReq(req);
                }
            };
            Thread payThread = new Thread(payRunnable);
            payThread.start();
        }
    }

    private void initALiPay() {
        //异步处理
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                //新建任务
                PayTask alipay = new PayTask((Activity) context);
                //获取支付结果
                Map<String, String> result = alipay.payV2(alitoken, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}
