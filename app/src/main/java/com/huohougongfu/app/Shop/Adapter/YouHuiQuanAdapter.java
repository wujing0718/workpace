package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShopYouHuiQuan;
import com.huohougongfu.app.R;

import java.util.List;

public class YouHuiQuanAdapter extends BaseQuickAdapter<ShopYouHuiQuan.ResultBean,BaseViewHolder> {
    public YouHuiQuanAdapter(int layoutResId, @Nullable List<ShopYouHuiQuan.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopYouHuiQuan.ResultBean item) {
        helper.addOnClickListener(R.id.bt_lingquyouhuiquan);
        helper.setText(R.id.tv_youhuiquan_money,"¥"+String.valueOf(item.getMoney()));
        helper.setText(R.id.tv_youhuiquan_serviceRegulations,item.getServiceRegulations());
        helper.setText(R.id.tv_youhuiquan_endTime,"订单有效期"+item.getEndTime());
    }
}
