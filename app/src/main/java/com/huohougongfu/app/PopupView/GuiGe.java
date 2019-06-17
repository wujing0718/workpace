package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.huohougongfu.app.R;
import com.lxj.xpopup.core.BottomPopupView;

public class GuiGe extends BottomPopupView {
    public GuiGe(@NonNull Context context) {
        super(context);
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_detail_guige;
    }
    @Override
    protected void onCreate() {
        super.onCreate();
        //初始化
        findViewById(R.id.bt_gouwuche).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        findViewById(R.id.bt_goumai).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        findViewById(R.id.bt_guanbi).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
