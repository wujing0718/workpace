package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

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
        TextView tv_jiangli = helper.getView(R.id.tv_jiangli);
        helper.setText(R.id.tv_name,item.getNickName());
        helper.setText(R.id.tv_dengji,item.getMemberLevel());
        helper.addOnClickListener(R.id.tv_jiangli);
        if (item.getGetReelStatus() == 0){
            tv_jiangli.setText("立即领取");
        }else if (item.getGetReelStatus() == 1){
            tv_jiangli.setText("已经领取");
            tv_jiangli.setBackgroundResource(R.color.colorHui);
        }
    }
}
