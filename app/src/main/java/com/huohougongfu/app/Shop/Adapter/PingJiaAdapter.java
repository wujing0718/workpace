package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.PingJia;
import com.huohougongfu.app.Gson.ShangPinGson;

import java.util.List;

public class PingJiaAdapter extends BaseQuickAdapter<PingJia.ResultBean.ListBean,BaseViewHolder> {
    public PingJiaAdapter(int layoutResId, @Nullable List<PingJia.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PingJia.ResultBean.ListBean item) {

    }
}
