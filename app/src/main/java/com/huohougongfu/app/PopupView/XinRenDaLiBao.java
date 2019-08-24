package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;

import com.huohougongfu.app.R;
import com.lxj.xpopup.core.BottomPopupView;

public class XinRenDaLiBao extends BottomPopupView {

    public XinRenDaLiBao(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_xinrendalibao;
    }
}
