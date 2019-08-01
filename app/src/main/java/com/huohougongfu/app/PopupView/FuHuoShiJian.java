package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.huohougongfu.app.Gson.TeaDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.AmountView;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.animator.PopupAnimator;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.core.CenterPopupView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FuHuoShiJian extends BottomPopupView implements View.OnClickListener {

    private  Handler mHandler;
    public FuHuoShiJian(@NonNull Context context, Handler mHandler) {
        super(context);
        this.mHandler =mHandler;
    }


    // 返回自定义弹窗的布局
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_dianpu_fahuoshijian;
    }
    // 执行初始化操作，比如：findView，设置点击，或者任何你弹窗内的业务逻辑
    @Override
    protected void onCreate() {
        super.onCreate();
        findViewById(R.id.bt_quxiao).setOnClickListener(this);
        findViewById(R.id.bt_yitian).setOnClickListener(this);
        findViewById(R.id.bt_santian).setOnClickListener(this);
        findViewById(R.id.bt_qitian).setOnClickListener(this);
        findViewById(R.id.bt_shiwutian).setOnClickListener(this);
        findViewById(R.id.bt_sanshitian).setOnClickListener(this);
    }

    // 设置最大宽度，看需要而定
    @Override
    protected int getMaxWidth() {
        return super.getMaxWidth();
    }
    // 设置最大高度，看需要而定
    @Override
    protected int getMaxHeight() {
        return super.getMaxHeight();
    }
    // 设置自定义动画器，看需要而定
    @Override
    protected PopupAnimator getPopupAnimator() {
        return super.getPopupAnimator();
    }
    /**
     * 弹窗的宽度，用来动态设定当前弹窗的宽度，受getMaxWidth()限制
     *
     * @return
     */
    protected int getPopupWidth() {
        return 0;
    }

    /**
     * 弹窗的高度，用来动态设定当前弹窗的高度，受getMaxHeight()限制
     *
     * @return
     */
    protected int getPopupHeight() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_quxiao:
                dismiss();
                break;
            case R.id.bt_yitian:
                if (!utils.isDoubleClick()){
                    Message msg = Message.obtain();
                    msg.what = 0;
                    msg.obj = "24小时内";
                    mHandler.sendMessage(msg);
                    dismiss();
                }
                break;
            case R.id.bt_santian:
                if (!utils.isDoubleClick()){
                    Message msg = Message.obtain();
                    msg.what = 0;
                    msg.obj = "3天内";
                    mHandler.sendMessage(msg);
                    dismiss();
                }
                break;
            case R.id.bt_qitian:
                if (!utils.isDoubleClick()){
                    Message msg = Message.obtain();
                    msg.what = 0;
                    msg.obj = "7天内";
                    mHandler.sendMessage(msg);
                    dismiss();
                }
                break;
            case R.id.bt_shiwutian:
                if (!utils.isDoubleClick()){
                    Message msg = Message.obtain();
                    msg.what = 0;
                    msg.obj = "15天内";
                    mHandler.sendMessage(msg);
                    dismiss();
                }
                break;
            case R.id.bt_sanshitian:
                if (!utils.isDoubleClick()){
                    Message msg = Message.obtain();
                    msg.what = 0;
                    msg.obj = "30天内";
                    mHandler.sendMessage(msg);
                    dismiss();
                }
                break;
        }
    }
}
