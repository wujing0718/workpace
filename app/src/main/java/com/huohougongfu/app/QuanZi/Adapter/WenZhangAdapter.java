package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MallGson;

import java.util.List;

public class WenZhangAdapter extends BaseQuickAdapter<MallGson.ResultBean,BaseViewHolder> {
    public WenZhangAdapter(int layoutResId, @Nullable List<MallGson.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MallGson.ResultBean item) {

    }
}
