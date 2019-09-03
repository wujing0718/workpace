package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.YaoQingGson;
import com.huohougongfu.app.R;

import java.util.List;

public class YaoQingAdapter extends BaseQuickAdapter<YaoQingGson.ResultBean.EarnPordutBean.ListBean,BaseViewHolder> {
    public YaoQingAdapter(int layoutResId, @Nullable List<YaoQingGson.ResultBean.EarnPordutBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, YaoQingGson.ResultBean.EarnPordutBean.ListBean item) {
        helper.setText(R.id.tv_name,item.getNickName());
        helper.setText(R.id.tv_dengji,item.getMemberLevel());
    }
}
