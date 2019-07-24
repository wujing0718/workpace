package com.huohougongfu.app.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ChaTaiDingDan;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;

import java.util.List;

public class ChaTaiDingDanAdapter extends BaseQuickAdapter<ChaTaiDingDan.ResultBean.ListBean,BaseViewHolder> {
    public ChaTaiDingDanAdapter(int layoutResId, @Nullable List<ChaTaiDingDan.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChaTaiDingDan.ResultBean.ListBean item) {
        helper.addOnClickListener(R.id.btn_queidng);
        helper.setText(R.id.tv_chatai_verificationCode,item.getVerificationCode());
        if ("0".equals(item.getOrderStatus())){
            helper.setText(R.id.tv_chatai_orderStatus,"未支付");
        }else if ("1".equals(item.getOrderStatus())){
            helper.setText(R.id.tv_chatai_orderStatus,"待提货");
        }else if ("2".equals(item.getOrderStatus())){
            helper.setText(R.id.tv_chatai_orderStatus,"已消费");
        }
        helper.setText(R.id.tv_chatai_teas,item.getTeas());
        helper.setText(R.id.tv_chatai_teaNum,"共"+item.getTeaNum()+"件");
        helper.setText(R.id.tv_chatai_orderTotal,"合计：¥ "+item.getOrderTotal());
        Long aLong = Long.valueOf(item.getCreateTime());
        String time = utils.transForDate2(aLong);
        helper.setText(R.id.tv_chatai_createTime,"下单时间："+time);

    }
}
