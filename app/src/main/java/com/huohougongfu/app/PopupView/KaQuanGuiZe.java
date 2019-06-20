package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.huohougongfu.app.R;
import com.lxj.xpopup.core.AttachPopupView;

public class KaQuanGuiZe extends AttachPopupView {
    private String serviceRegulations;
    public KaQuanGuiZe(@NonNull Context context, String serviceRegulations) {
        super(context);
        this.serviceRegulations = serviceRegulations;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        TextView tv_guize = findViewById(R.id.tv_guize);
        tv_guize.setText(serviceRegulations);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.doalog_kaquanguize;
    }

    @Override
    protected Drawable getPopupBackground() {
        return getResources().getDrawable(R.drawable._xpopup_round3_bg);
    }
}
