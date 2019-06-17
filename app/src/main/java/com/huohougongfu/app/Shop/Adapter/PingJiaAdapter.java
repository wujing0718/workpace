package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShangPinGson;

import java.util.List;

public class PingJiaAdapter extends BaseQuickAdapter<ShangPinGson.DataBean.ListBean,BaseViewHolder> {
    public PingJiaAdapter(int layoutResId, @Nullable List<ShangPinGson.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShangPinGson.DataBean.ListBean item) {

    }
}
