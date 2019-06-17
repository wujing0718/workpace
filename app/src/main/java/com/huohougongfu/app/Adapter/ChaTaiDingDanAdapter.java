package com.huohougongfu.app.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.R;

import java.util.List;

public class ChaTaiDingDanAdapter extends BaseQuickAdapter<ShangPinGson.DataBean.ListBean,BaseViewHolder> {
    public ChaTaiDingDanAdapter(int layoutResId, @Nullable List<ShangPinGson.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShangPinGson.DataBean.ListBean item) {
        helper.addOnClickListener(R.id.btn_queidng);
    }
}
