package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.PingJia;

import java.util.List;

public class VedioCommentAdapter extends BaseQuickAdapter<PingJia.ResultBean.ListBean,BaseViewHolder> {
    public VedioCommentAdapter(int layoutResId, @Nullable List<PingJia.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PingJia.ResultBean.ListBean item) {

    }
}
