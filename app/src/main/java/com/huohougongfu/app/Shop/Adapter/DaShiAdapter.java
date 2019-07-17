package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.DaShi;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class DaShiAdapter extends BaseQuickAdapter<DaShi.ResultBean,BaseViewHolder> {
    public DaShiAdapter(int layoutResId, @Nullable List<DaShi.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DaShi.ResultBean item) {
        ImageView img_dashi_touxiang = helper.getView(R.id.img_dashi_touxiang);
        helper.setText(R.id.tv_dashi_name,item.getName());
        helper.setText(R.id.tv_dashi_level,item.getLevel());
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(item.getPortrait()).apply(requestOptions).into(img_dashi_touxiang);
    }
}
