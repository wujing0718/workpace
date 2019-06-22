package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyCaQuan;

import java.util.List;

public class JingXuanAdapter extends BaseQuickAdapter<MyCaQuan.ResultBean,BaseViewHolder> {
    public JingXuanAdapter(int layoutResId, @Nullable List<MyCaQuan.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCaQuan.ResultBean item) {

    }
}
