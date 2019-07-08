package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.huohougongfu.app.QuanZi.Activity.VedioDetailActivity;
import com.huohougongfu.app.R;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;

public class VedioContentDetail extends BottomPopupView {
    private String content;
    public VedioContentDetail(@NonNull Context context,String content) {
        super(context);
        this.content = content;
    }


    @Override
    protected int getImplLayoutId() {
        return R.layout.item_vedio_detail;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        TextView txt_item_text = findViewById(R.id.txt_item_text);
        txt_item_text.setText(content);
    }

    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext()) * .65f);
    }
}
