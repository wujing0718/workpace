package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.VIP;
import com.huohougongfu.app.R;

import java.util.List;

public class ChengZhangAdapter extends BaseQuickAdapter<VIP.ResultBean.IntegralRecordBean,BaseViewHolder> {
    public ChengZhangAdapter(int layoutResId, @Nullable List<VIP.ResultBean.IntegralRecordBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VIP.ResultBean.IntegralRecordBean item) {
        helper.setText(R.id.tv_name,item.getComment());
        helper.setText(R.id.tv_chengzhangzhi,String.valueOf(item.getNum()));
    }
}
