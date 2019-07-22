package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.JiQiLieBiao;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.R;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

public class DingWeiAdapter extends BaseQuickAdapter<JiQiLieBiao.ResultBean,BaseViewHolder> {
    public DingWeiAdapter(int layoutResId, @Nullable List<JiQiLieBiao.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JiQiLieBiao.ResultBean item) {
        helper.setText(R.id.tv_jiqi_weizhi,item.getDetailAddress()+"(No."+item.getEquipmentId()+")");
        DecimalFormat formater = new DecimalFormat();
        formater.setMaximumFractionDigits(2);
        formater.setGroupingSize(0);
        formater.setRoundingMode(RoundingMode.FLOOR);
        String result = formater.format(Double.valueOf(item.getDistance()));
        helper.setText(R.id.tv_jiqi_juli,"距您"+result+"m");

    }
}
