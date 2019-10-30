package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.DingDanQuXiaoYuanYin;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.DingDanDetailActivity;
import com.huohougongfu.app.WoDe.Adapter.QuXiaoDingDanYuanYinAdapter;
import com.kongzue.dialog.v2.SelectDialog;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class QuXiaoDingDan extends BottomPopupView implements View.OnClickListener {
    private Handler mHandler;
    private int orderStatus;
    private String orderNo;
    private RecyclerView rec_quxiao_yuanyin;
    private Context context;
    public QuXiaoDingDan(@NonNull Context context, int orderStatus, String orderNo) {
        super(context);
        this.context =context;
        this.orderStatus = orderStatus;
        this.orderNo = orderNo;

    }

    public QuXiaoDingDan(@NonNull Context context, int orderStatus, String orderNo, Handler mHandler) {
        super(context);
        this.context =context;
        this.orderStatus = orderStatus;
        this.orderNo = orderNo;
        this.mHandler = mHandler;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        rec_quxiao_yuanyin = findViewById(R.id.rec_quxiao_yuanyin);
        findViewById(R.id.vew_guanbi).setOnClickListener(this);
        initData();
    }

    private void initData() {
        OkGo.<String>post(Contacts.URl1+"order/cancelOrderReason")
                .params("type",String.valueOf(orderStatus))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        DingDanQuXiaoYuanYin dingDanQuXiaoYuanYin = gson.fromJson(body, DingDanQuXiaoYuanYin.class);
                        if (dingDanQuXiaoYuanYin.getStatus() ==1){
                            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                            rec_quxiao_yuanyin.setLayoutManager(layoutManager);
                            QuXiaoDingDanYuanYinAdapter quXiaoDingDanYuanYinAdapter = new QuXiaoDingDanYuanYinAdapter(R.layout.item_dingdan_quxiao_yuanyin,dingDanQuXiaoYuanYin.getResult());
                            rec_quxiao_yuanyin.setAdapter(quXiaoDingDanYuanYinAdapter);
                            quXiaoDingDanYuanYinAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    SelectDialog.show(context, "提示", "是否取消订单",
                                            "确定", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if(!utils.isDoubleClick()){
                                                        Map<String,String> map = new HashMap<>();
                                                        map.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
                                                        map.put("orderNo",orderNo);
                                                        map.put("ocrId",String.valueOf(dingDanQuXiaoYuanYin.getResult().get(position).getId()));
                                                        OkGo.<String>post(Contacts.URl1+"order/cancelOrder")
                                                                .params(map)
                                                                .execute(new StringCallback() {
                                                                    @Override
                                                                    public void onSuccess(Response<String> response) {
                                                                        String body = response.body();
                                                                        try {
                                                                            JSONObject jsonObject = new JSONObject(body);
                                                                            if (jsonObject.getInt("status") == 1){
                                                                                Message msg = Message.obtain();
                                                                                if (mHandler!=null){
                                                                                    msg.what = 0;
                                                                                    msg.obj = true;
                                                                                    mHandler.sendMessage(msg);
                                                                                }
                                                                                DingDanDetailActivity.activity.finish();
                                                                                ToastUtils.showShort(jsonObject.getString("msg"));
                                                                            }else{
                                                                                dismiss();
                                                                                ToastUtils.showShort(jsonObject.getString("msg"));
                                                                            }
                                                                        } catch (JSONException e) {
                                                                            e.printStackTrace();
                                                                        }
                                                                    }
                                                                });
                                                    }
                                                }
                                            },
                                            "取消", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dismiss();
                                                }
                                            });
                                }
                            });
                        }
                    }
                });
    }

    // 返回自定义弹窗的布局
    @Override
    protected int getImplLayoutId() {
        return R.layout.item_quxiaodingdan_yuanyin;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.vew_guanbi:
                dismiss();
                break;
        }
    }
    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext()) * .40f);
    }
}
