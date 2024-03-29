package com.huohougongfu.app.PopupView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ALiPay;
import com.huohougongfu.app.Gson.Over;
import com.huohougongfu.app.Gson.WXPay;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.PaySucceedActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.PayResult;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.View.PopEnterPassword;
import com.huohougongfu.app.WoDe.Activity.MyDingDanActivity;
import com.huohougongfu.app.WoDe.Activity.SetKeyBoardActivity;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.tencent.mm.opensdk.modelpay.PayReq;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class DingDanZhiFu extends BottomPopupView implements View.OnClickListener {
    private String OrderNo;
    private double priceTotal;
    private List<String> orderNo;
    private Activity context;
    private CheckBox check_yue,check_ali,check_weixin;
    private String alitoken;
    private static final int SDK_PAY_FLAG = 1001;
    private Over over;
    private String orderId = "";

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
                        Intent intent = new Intent();
                        intent.setClass(context, PaySucceedActivity.class);
                        context.startActivity(intent);
                        Message msg1 = Message.obtain();
                        msg1.what = 0;
                        msg1.obj = true;
                        mHandler.sendMessage(msg1);
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
    private TextView tv_over;
    private ALiPay aLiPay;
    private String substring;

    public DingDanZhiFu(@NonNull Activity context, String alitoken, double priceTotal, String OrderNo) {
        super(context);
        this.context= context;
        this.alitoken = alitoken;
        this.priceTotal = priceTotal;
        this.OrderNo = OrderNo;
    }
    public DingDanZhiFu(@NonNull Activity context, String alitoken, double priceTotal, String OrderNo,Handler mHandler) {
        super(context);
        this.context= context;
        this.alitoken = alitoken;
        this.priceTotal = priceTotal;
        this.OrderNo = OrderNo;
        this.mHandler = mHandler;
    }

    public DingDanZhiFu(@NonNull Activity  context, List<String> orderNo) {
        super(context);
        this.context= context;
        this.orderNo = orderNo;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_zhifu;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        initALi();
        initWX();
        tv_over = findViewById(R.id.tv_over);
        check_yue = findViewById(R.id.check_yue);
        check_ali = findViewById(R.id.check_ali);
        check_weixin = findViewById(R.id.check_weixin);
        tv_total_price = findViewById(R.id.tv_total_price);
        check_yue.setClickable(false);
        check_ali.setClickable(false);
        check_weixin.setClickable(false);
        findViewById(R.id.bt_pay).setOnClickListener(this);
        findViewById(R.id.bt_guanbi).setOnClickListener(this);
        findViewById(R.id.bt_yue).setOnClickListener(this);
        findViewById(R.id.bt_alipay).setOnClickListener(this);
        findViewById(R.id.bt_weixin).setOnClickListener(this);
        initOver();
        initInspection();
    }

    private void initALi() {
        if (orderNo!=null){
            for (int i = 0; i < orderNo.size(); i++) {
                orderId =orderNo.get(i)+","+ orderId;
                substring = orderId.substring(0, orderId.length() - 1);
            }
            OkGo.<String>post(Contacts.URl1 + "apliyConfirmPaymentMoreOrderNo")
                    .params("orderNos", substring)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            WaitDialog.dismiss();
                            String body = response.body();
                            aLiPay = new Gson().fromJson(body, ALiPay.class);
                            if (aLiPay.getStatus() == 1) {
                                priceTotal = aLiPay.getResult().getPriceTotal();
                                alitoken = aLiPay.getResult().getOrderString();
                                tv_total_price.setText("￥"+aLiPay.getResult().getPriceTotal());
                            }
                        }

                        @Override
                        public void onError(Response<String> response) {
                            WaitDialog.dismiss();
                            super.onError(response);
                        }

                        @Override
                        public void onStart(Request<String, ? extends Request> request) {
                            WaitDialog.show(context,"请稍后。。。");
                            super.onStart(request);
                        }
                    });
        }
        if (OrderNo != null){
            OkGo.<String>post(Contacts.URl1 + "apliyConfirmPaymentMoreOrderNo")
                    .params("orderNos", OrderNo)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            WaitDialog.dismiss();
                            String body = response.body();
                            aLiPay = new Gson().fromJson(body, ALiPay.class);
                            if (aLiPay.getStatus() == 1) {
                                priceTotal = aLiPay.getResult().getPriceTotal();
                                alitoken = aLiPay.getResult().getOrderString();
                                tv_total_price.setText("￥"+aLiPay.getResult().getPriceTotal());
                            }
                        }

                        @Override
                        public void onError(Response<String> response) {
                            WaitDialog.dismiss();
                            super.onError(response);
                        }

                        @Override
                        public void onStart(Request<String, ? extends Request> request) {
                            WaitDialog.show(context,"请稍后。。。");
                            super.onStart(request);
                        }
                    });
        }
    }


    private void initOver() {
        OkGo.<String>get(Contacts.URl1+"/member/balance/"+MyApp.instance.getInt("id"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Over over = new Gson().fromJson(response.body(), Over.class);
                        if (over.getStatus() == 1){
                            tv_over.setText("(剩余：¥"+String.valueOf(over.getResult().getBalance())+")");
                        }
                    }
                });
    }

    //检查用户有无支付密码
    private void initInspection() {
        OkGo.<String>post(Contacts.URl1+"/wallet/checkPayPassword")
                .params("mId",MyApp.instance.getInt("id"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Over over1 = new Gson().fromJson(response.body(), Over.class);
                        if (over1.getStatus() == 1){
                            over = over1;
                        }else{
                            ToastUtils.showShort(over1.getMsg());
                        }
                    }
                });
    }



    private void initWX(){
        String orderId = "";
        if (orderNo!=null){
            for (int i = 0; i < orderNo.size(); i++) {
                orderId =orderNo.get(i)+","+ orderId;
            }
            String substring = orderId.substring(0, orderId.length() - 1);
            OkGo.<String>post(Contacts.URl1+"/pay/wxpay")
                    .params("orderNo",substring)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    wxtoken = jsonObject.getString("result");
//                                initWeiXin();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }else{
            OkGo.<String>post(Contacts.URl1+"/pay/wxpay")
                    .params("orderNo",OrderNo)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    wxtoken = jsonObject.getString("result");
//                                initWeiXin();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
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
                    if (over.getResult().isHasPayPassword()){
                        dismiss();
                        String orderId ="";
                        if (orderNo!=null){
                            for (int i = 0; i < orderNo.size(); i++) {
                                orderId =orderNo.get(i)+","+ orderId;
                            }
                            String substring = orderId.substring(0, orderId.length() - 1);
                            PopEnterPassword popEnterPassword = new PopEnterPassword(2,context,priceTotal,substring);
                            // 显示窗口
                            popEnterPassword.showAtLocation(getPopupContentView(),
                                    Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
                        }if (OrderNo !=null){
                            PopEnterPassword popEnterPassword = new PopEnterPassword(2,context,priceTotal,OrderNo);
                            // 显示窗口
                            popEnterPassword.showAtLocation(getPopupContentView(),
                                    Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
                        }

                    }else{
                        dismiss();
                        Intent intent = new Intent();
                        intent.setClass(context, SetKeyBoardActivity.class);
                        context.startActivity(intent);
                    }
                }else if (check_ali.isChecked()){
                    check_yue.setChecked(false);
                    check_weixin.setChecked(false);
                    initALiPay();
                }else{
                    check_yue.setChecked(false);
                    check_ali.setChecked(false);
                    initWXPay();
                }
                break;
        }
    }

    private void initWeiXin() {
        OkGo.<String>post(Contacts.URl1+"/pay/wxpay")
                .params("orderNo",wxtoken)
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
                if (alitoken!=null){
                    //获取支付结果
                    Map<String, String> result = alipay.payV2(alitoken, true);
                    Message msg = new Message();
                    msg.what = SDK_PAY_FLAG;
                    msg.obj = result;
                    mHandler.sendMessage(msg);
                }
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}
