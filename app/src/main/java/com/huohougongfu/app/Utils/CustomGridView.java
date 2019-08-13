package com.huohougongfu.app.Utils;

import android.content.Context;
import android.util.AttributeSet;

import com.huxq17.handygridview.HandyGridView;

public class CustomGridView extends HandyGridView {

    public CustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
