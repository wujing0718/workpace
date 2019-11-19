package com.huohougongfu.app.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.PaySucceedActivity;
import com.huohougongfu.app.Shop.Activity.XiaDanActivity;
import com.huohougongfu.app.ShouYe.Activity.ChaTaiDingDanDetail;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.DingDanDetailActivity;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;


/**
 * 输入支付密码
 *
 * @author lining
 */
public class PopEnterPassword extends PopupWindow implements IListener {

    private final double total_price;
    private final String orderNo;
    private final int type;
    private String orderId;
    private PasswordView pwdView;

    private View mMenuView;

    private Activity mContext;

    public PopEnterPassword(int type, final Activity context, double total_price, String orderNo) {

        super(context);
        this.type  = type;
        this.mContext = context;
        this.total_price = total_price;
        this.orderNo = orderNo;

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ListenerManager.getInstance().registerListtener(this);
        mMenuView = inflater.inflate(R.layout.pop_enter_password, null);
        TextView textAmount = mMenuView.findViewById(R.id.textAmount);
        textAmount.setText("￥"+total_price);
        pwdView = (PasswordView) mMenuView.findViewById(R.id.pwd_view);

        if (type == 1){
            //添加密码输入完成的响应
            pwdView.setOnFinishInput(new OnPasswordInputFinish() {
                @Override
                public void inputFinish(final String zhifupassword) {
                    String password = utils.makeMD5(zhifupassword);
                    Map<String,String> map = new HashMap<>();
                    map.put("orderNo",orderNo);
                    map.put("mId", String.valueOf(MyApp.instance.getInt("id")));
                    map.put("payPassword",password);
                    OkGo.<String>post(Contacts.URl1+"/machine/balancePayment")
                            .params(map)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    WaitDialog.dismiss();
                                    String body = response.body();
                                    try {
                                        JSONObject jsonObject = new JSONObject(body);
                                        if (jsonObject.getInt("status") == 1){
                                            dismiss();
                                            ListenerManager.getInstance().sendBroadCast(200,"成功");
                                            ToastUtils.showShort(jsonObject.getString("msg"));
                                        }else{
                                            ToastUtils.showShort(jsonObject.getString("msg"));
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onStart(Request<String, ? extends Request> request) {
                                    WaitDialog.show(context,"请稍后。。。");
                                    super.onStart(request);
                                }
                            });
                }
            });
        }else if (type == 2){
            pwdView.setOnFinishInput(new OnPasswordInputFinish() {
                @Override
                public void inputFinish(final String zhifupassword) {
                    String password = utils.makeMD5(zhifupassword);
                    Map<String,String> map = new HashMap<>();
                    map.put("orderNo",orderNo);
                    map.put("mId", String.valueOf(MyApp.instance.getInt("id")));
                    map.put("payPassword",password);
                    OkGo.<String>post(Contacts.URl1+"/order/balancePayment")
                            .params(map)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    WaitDialog.dismiss();
                                    String body = response.body();
                                try {
                                    JSONObject jsonObject = new JSONObject(body);
                                    if (jsonObject.getInt("status") == 1){
                                        dismiss();
                                        startActivity(new Intent().setClass(mContext, PaySucceedActivity.class));
                                        XiaDanActivity.activity.finish();
                                        ToastUtils.showShort(jsonObject.getString("msg"));
                                        }else{
                                        ToastUtils.showShort(jsonObject.getString("msg"));
                                        }
                                        } catch (JSONException e) {
                                    e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onStart(Request<String, ? extends Request> request) {
                                    WaitDialog.show(context,"请稍后。。。");
                                    super.onStart(request);
                                }
                            });
                    }
            });

        }

        // 监听X关闭按钮
        pwdView.getImgCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // 监听键盘上方的返回
        pwdView.getVirtualKeyboardView().getLayoutBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.pop_add_ainm);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x66000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);

    }

    public PopEnterPassword(int type, Activity context, double total_price, String orderNo, String orderId) {
        super(context);
        this.type  = type;
        this.mContext = context;
        this.total_price = total_price;
        this.orderNo = orderNo;
        this.orderId = orderId;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ListenerManager.getInstance().registerListtener(this);
        mMenuView = inflater.inflate(R.layout.pop_enter_password, null);
        TextView textAmount = mMenuView.findViewById(R.id.textAmount);
        textAmount.setText("￥"+total_price);
        pwdView = (PasswordView) mMenuView.findViewById(R.id.pwd_view);

        if (type == 1){
            //添加密码输入完成的响应
            pwdView.setOnFinishInput(new OnPasswordInputFinish() {
                @Override
                public void inputFinish(final String zhifupassword) {
                    String password = utils.makeMD5(zhifupassword);
                    Map<String,String> map = new HashMap<>();
                    map.put("orderNo",orderNo);
                    map.put("mId", String.valueOf(MyApp.instance.getInt("id")));
                    map.put("payPassword",password);
                    OkGo.<String>post(Contacts.URl1+"/machine/balancePayment")
                            .params(map)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    WaitDialog.dismiss();
                                    String body = response.body();
                                    try {
                                        JSONObject jsonObject = new JSONObject(body);
                                        if (jsonObject.getInt("status") == 1){
                                            dismiss();
                                            if (ChaTaiDingDanDetail.activity!=null){
                                                ChaTaiDingDanDetail.activity.finish();
                                                Intent orderNo1 = new Intent().putExtra("orderNo", orderId);
                                                orderNo1.setClass(mContext,ChaTaiDingDanDetail.class);
                                                startActivity(orderNo1);
//                                                ListenerManager.getInstance().sendBroadCast(200,"成功");
                                            }else{
                                                Intent orderNo1 = new Intent().putExtra("orderNo", orderId);
                                                orderNo1.setClass(mContext,ChaTaiDingDanDetail.class);
                                                startActivity(orderNo1);
                                            }
                                            ToastUtils.showShort(jsonObject.getString("msg"));
                                        }else{
                                            ToastUtils.showShort(jsonObject.getString("msg"));
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onStart(Request<String, ? extends Request> request) {
                                    WaitDialog.show(context,"请稍后。。。");
                                    super.onStart(request);
                                }
                            });
                }
            });
        }else if (type == 2){
            pwdView.setOnFinishInput(new OnPasswordInputFinish() {
                @Override
                public void inputFinish(final String zhifupassword) {
                    String password = utils.makeMD5(zhifupassword);
                    Map<String,String> map = new HashMap<>();
                    map.put("orderNo",orderNo);
                    map.put("mId", String.valueOf(MyApp.instance.getInt("id")));
                    map.put("payPassword",password);
                    OkGo.<String>post(Contacts.URl1+"/order/balancePayment")
                            .params(map)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    WaitDialog.dismiss();
                                    String body = response.body();
                                    try {
                                        JSONObject jsonObject = new JSONObject(body);
                                        if (jsonObject.getInt("status") == 1){
                                            dismiss();
                                            ListenerManager.getInstance().sendBroadCast(200,"成功");
                                            ToastUtils.showShort(jsonObject.getString("msg"));
                                        }else{
                                            ToastUtils.showShort(jsonObject.getString("msg"));
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onStart(Request<String, ? extends Request> request) {
                                    WaitDialog.show(context,"请稍后。。。");
                                    super.onStart(request);
                                }
                            });
                }
            });

        }

        // 监听X关闭按钮
        pwdView.getImgCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // 监听键盘上方的返回
        pwdView.getVirtualKeyboardView().getLayoutBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.pop_add_ainm);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x66000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {

    }
}
