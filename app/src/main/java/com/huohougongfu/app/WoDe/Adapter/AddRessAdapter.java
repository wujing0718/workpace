package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.AddRess;
import com.huohougongfu.app.R;

import java.util.List;

public class AddRessAdapter extends BaseQuickAdapter<AddRess.ResultBean,BaseViewHolder> {

    public AddRessAdapter(int layoutResId, @Nullable List<AddRess.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddRess.ResultBean item) {
        int isDefault = item.getIsDefault();
        helper.addOnClickListener(R.id.bt_bianji_address);
        TextView tv_morendizhi = helper.getView(R.id.tv_morendizhi);
        tv_morendizhi.setVisibility(View.GONE);
        if (isDefault ==1){
            tv_morendizhi.setVisibility(View.VISIBLE);
        }
        helper.setText(R.id.tv_dizhi_name,item.getReceiverName());
        helper.setText(R.id.tv_dizhi_phone,item.getPhone());
        helper.setText(R.id.tv_dizhi_address,item.getProvinceName()+" "+item.getCityName()+" "+item.getAreaName()+" "+
        item.getDetailAddr());
    }
}
