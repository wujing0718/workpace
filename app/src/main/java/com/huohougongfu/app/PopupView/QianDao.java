package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.huohougongfu.app.R;
import com.lxj.xpopup.animator.PopupAnimator;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.impl.FullScreenPopupView;

public class QianDao extends FullScreenPopupView {

    public QianDao(@NonNull Context context) {
        super(context);
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_daka;
    }
    @Override
    protected void onCreate() {
        super.onCreate();
        //三秒后关闭
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        },3000);
        //初始化
    }
}
