package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ChanPinCanShu;
import com.huohougongfu.app.R;

import java.util.List;

public class CanShuAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public CanShuAdapter(int layoutResId, @Nullable List<String > data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_canshu_name,item+"：");
    }
}
