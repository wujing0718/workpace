package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyCollect;

import java.util.List;

public class DingDanGuanLiAdapter extends BaseQuickAdapter<MyCollect.ResultBean.ListBean,BaseViewHolder> {
    public DingDanGuanLiAdapter(int layoutResId, @Nullable List<MyCollect.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCollect.ResultBean.ListBean item) {

    }
}
