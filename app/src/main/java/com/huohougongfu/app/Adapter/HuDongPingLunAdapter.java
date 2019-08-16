package com.huohougongfu.app.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.HuDongPingLun;

import java.util.List;

public class HuDongPingLunAdapter extends BaseQuickAdapter<HuDongPingLun.ResultBean.ListBean,BaseViewHolder> {
    public HuDongPingLunAdapter(int layoutResId, @Nullable List<HuDongPingLun.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HuDongPingLun.ResultBean.ListBean item) {

    }
}
