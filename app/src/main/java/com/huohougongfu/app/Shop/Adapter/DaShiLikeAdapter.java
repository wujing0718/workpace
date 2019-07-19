package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.DSZhuanChang;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class DaShiLikeAdapter extends BaseQuickAdapter<DSZhuanChang.ResultBean.YourLikeBean,BaseViewHolder> {
    public DaShiLikeAdapter(int layoutResId, @Nullable List<DSZhuanChang.ResultBean.YourLikeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DSZhuanChang.ResultBean.YourLikeBean item) {
        ImageView img_dashi_touxiang = helper.getView(R.id.img_dashi_touxiang);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(item.getPhoto()).apply(requestOptions).into(img_dashi_touxiang);
        helper.setText(R.id.tv_cainixihuan_name,item.getName());
    }
}
