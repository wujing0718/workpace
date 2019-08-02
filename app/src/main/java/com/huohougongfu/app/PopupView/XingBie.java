package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;

import com.huohougongfu.app.R;
import com.lxj.xpopup.core.BottomPopupView;

public class XingBie extends BottomPopupView implements View.OnClickListener {
    private Handler mHandler;
    Message msg = Message.obtain();
    public XingBie(@NonNull Context context, Handler mHandler) {
        super(context);
        this.mHandler = mHandler;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_xiubie;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        findViewById(R.id.bt_nan).setOnClickListener(this);
        findViewById(R.id.bt_nv).setOnClickListener(this);
        findViewById(R.id.bt_quxiao).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_quxiao:
                dismiss();
                break;
            case R.id.bt_nan:
                msg.what = 0;
                msg.obj = "男";
                mHandler.sendMessage(msg);
                dismiss();
                break;
            case R.id.bt_nv:
                msg.what = 0;
                msg.obj = "女";
                mHandler.sendMessage(msg);
                dismiss();
                break;
        }
    }
}
