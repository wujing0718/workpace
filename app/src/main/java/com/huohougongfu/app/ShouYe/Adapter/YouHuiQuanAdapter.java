package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ChaTaiYouHuiQuan;
import com.huohougongfu.app.Gson.ShopYouHuiQuan;
import com.huohougongfu.app.R;

import java.util.List;

public class YouHuiQuanAdapter extends BaseQuickAdapter<ChaTaiYouHuiQuan.ResultBean.CouponsBean,BaseViewHolder> {
    public YouHuiQuanAdapter(int layoutResId, @Nullable List<ChaTaiYouHuiQuan.ResultBean.CouponsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChaTaiYouHuiQuan.ResultBean.CouponsBean item) {
        helper.addOnClickListener(R.id.bt_lingquyouhuiquan);
        helper.setText(R.id.tv_youhuiquan_money,item.getTitle());
        if (item.getServiceRegulations()!=null){
            helper.setText(R.id.tv_youhuiquan_serviceRegulations,item.getServiceRegulations());
        }
        helper.setText(R.id.tv_youhuiquan_endTime,"订单有效期"+item.getEndTime());
    }
}
