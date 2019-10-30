package com.huohougongfu.app.wxapi;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.socialize.weixin.view.WXCallbackActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class WXEntryActivity extends WXCallbackActivity implements IWXAPIEventHandler {


    private IWXAPI iwxapi;
//    private ProgressDialog mProgressDialog;
    private WXEntryActivity mContext;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //接收到分享以及登录的intent传递handleIntent方法，处理结果
        iwxapi = WXAPIFactory.createWXAPI(this, "wxa36e44f4072c4818", true);
        iwxapi.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    //请求回调结果处理
    @Override
    public void onResp(BaseResp baseResp) {
        //支付回调
        if (baseResp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            switch (baseResp.errCode) {
                case 0:
                    ToastUtils.showShort("支付成功");
                    finish();
                    break;
                case -1:
                    ToastUtils.showShort("支付取消");
                    finish();
                    break;
                case -2:
                    ToastUtils.showShort("请求失败");
                    finish();
                    break;
            }
        }else{
            //登录回调
            switch (baseResp.errCode) {
                case BaseResp.ErrCode.ERR_OK:
                    String code = ((SendAuth.Resp) baseResp).code;
                    //获取accesstoken
                    getAccessToken(code);
                    break;
                case BaseResp.ErrCode.ERR_AUTH_DENIED://用户拒绝授权
                    finish();
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL://用户取消
                    finish();
                    break;
                default:
                    finish();
                    break;
            }
        }
    }
    private void getAccessToken(String code) {
//        createProgressDialog();
        //获取授权
        StringBuffer loginUrl = new StringBuffer();
        loginUrl.append("https://api.weixin.qq.com/sns/oauth2/access_token")
                .append("?appid=")
                .append("wxa36e44f4072c4818")
                .append("&secret=")
                .append("04c7a1e26430d3ca028fc6f17a83c331")
                .append("&code=")
                .append(code)
                .append("&grant_type=authorization_code");
        Log.d("urlurl", loginUrl.toString());

        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(loginUrl.toString())
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("fan12", "onFailure: ");
//                mProgressDialog.dismiss();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseInfo = response.body().string();
                Log.d("fan12", "onResponse: " + responseInfo);
                String access = null;
                String openId = null;
                try {
                    JSONObject jsonObject = new JSONObject(responseInfo);
                    access = jsonObject.getString("access_token");
                    openId = jsonObject.getString("openid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                getUserInfo(access, openId);
            }
        });
    }
//    private void createProgressDialog() {
//        mContext=this;
//        mProgressDialog=new ProgressDialog(mContext);
//        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//转盘
//        mProgressDialog.setCancelable(false);
//        mProgressDialog.setCanceledOnTouchOutside(false);
//        mProgressDialog.setTitle("提示");
//        mProgressDialog.setMessage("登录中，请稍后");
//        mProgressDialog.show();
//    }
    private void getUserInfo(String access, String openid) {
        String getUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access + "&openid=" + openid;
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(getUserInfoUrl)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("fan12", "onFailure: ");
//                mProgressDialog.dismiss();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseInfo= response.body().string();
                Log.d("fan123", "onResponse: " + responseInfo);
                SharedPreferences.Editor editor= getSharedPreferences("userInfo", MODE_PRIVATE).edit();
                editor.putString("responseInfo", responseInfo);
                editor.commit();
                finish();
            }
        });
    }
}
