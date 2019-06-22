package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;

import com.huohougongfu.app.R;
import com.lxj.xpopup.core.CenterPopupView;

public class ChaMiGuiZe extends CenterPopupView {
    public ChaMiGuiZe(@NonNull Context context) {
        super(context);
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_chimi_zhuanzengguize;
    }
}
