package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.huohougongfu.app.R;
import com.lxj.xpopup.core.BottomPopupView;

public class ChaTaiZhiFu extends BottomPopupView {
    public ChaTaiZhiFu(@NonNull Context context) {
        super(context);
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_zhifu;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        findViewById(R.id.bt_guanbi).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
