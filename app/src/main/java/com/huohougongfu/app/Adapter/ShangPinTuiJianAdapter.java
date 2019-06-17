package com.huohougongfu.app.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.PinPaiItemAdapter;

import java.util.List;

public class ShangPinTuiJianAdapter extends BaseQuickAdapter<ShangPinGson.DataBean.ListBean,BaseViewHolder> {

    private List<ShangPinGson.DataBean.ListBean> data;

    public ShangPinTuiJianAdapter(int layoutResId, @Nullable List<ShangPinGson.DataBean.ListBean> data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShangPinGson.DataBean.ListBean item) {

    }
}
