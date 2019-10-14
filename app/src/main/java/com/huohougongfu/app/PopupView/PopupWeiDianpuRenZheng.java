package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;

import com.huohougongfu.app.R;
import com.huohougongfu.app.WoDe.Activity.ShangHuRenZhengActivity;
import com.lxj.xpopup.core.CenterPopupView;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

public class PopupWeiDianpuRenZheng extends CenterPopupView {


    public PopupWeiDianpuRenZheng(@NonNull Context context) {
        super(context);
    }

    // 返回自定义弹窗的布局
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_weidianpurenzheng;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        findViewById(R.id.bt_renzheng).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), ShangHuRenZhengActivity.class);
                startActivity(intent);
                dismiss();
            }
        });
    }
}
