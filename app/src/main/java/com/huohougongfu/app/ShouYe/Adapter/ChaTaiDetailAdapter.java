package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ChaTaiDingDanDetail;
import com.huohougongfu.app.R;

import java.util.List;

public class ChaTaiDetailAdapter extends BaseQuickAdapter<ChaTaiDingDanDetail.ResultBean.DetailsBean,BaseViewHolder> {
    public ChaTaiDetailAdapter(int layoutResId, @Nullable List<ChaTaiDingDanDetail.ResultBean.DetailsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChaTaiDingDanDetail.ResultBean.DetailsBean item) {
        helper.setText(R.id.tv_cha_name,item.getTeaName());
        helper.setText(R.id.tv_cha_content,item.getConcentration());
        helper.setText(R.id.tv_cha_num,"X"+String.valueOf(item.getCount()));
        helper.setText(R.id.tv_cha_price,"￥"+String.valueOf(item.getPrice()));
    }
}
