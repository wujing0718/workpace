package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.Gson.MyPingJia;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class DianPuShopPingJiaAdapter extends BaseQuickAdapter<MyPingJia.ResultBean.ListBean,BaseViewHolder> {
    public DianPuShopPingJiaAdapter(int layoutResId, @Nullable List<MyPingJia.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyPingJia.ResultBean.ListBean item) {
        ImageView img_shop_photo = helper.getView(R.id.img_shop_photo);
        Glide.with(MyApp.context).load(item.getPicture()).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu).circleCrop()).into(img_shop_photo);
//        helper.setText(R.id.tv_shop_name,item.getName());
//        helper.setText(R.id.tv_shop_price,"¥"+item.getPrice());
    }
}
