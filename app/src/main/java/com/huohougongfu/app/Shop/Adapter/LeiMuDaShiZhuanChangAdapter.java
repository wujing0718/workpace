package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.QuanBuLeiMu;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class LeiMuDaShiZhuanChangAdapter extends BaseQuickAdapter<QuanBuLeiMu.ResultBean.ListBean,BaseViewHolder> {
    public LeiMuDaShiZhuanChangAdapter(int layoutResId, @Nullable List<QuanBuLeiMu.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, QuanBuLeiMu.ResultBean.ListBean item) {
        helper.setText(R.id.tv_dashi_name,item.getName());
        helper.setText(R.id.tv_dashi_level,item.getLevel());
        ImageView img_dashi_touxiang = helper.getView(R.id.img_dashi_touxiang);
        Glide.with(MyApp.context).load(item.getPhoto()).into(img_dashi_touxiang);
    }
}
