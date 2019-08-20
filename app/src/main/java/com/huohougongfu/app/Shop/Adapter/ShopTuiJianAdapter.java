package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShopDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShopTuiJianAdapter extends BaseQuickAdapter<ShopDetail.ResultBean.RecommendBean,BaseViewHolder> {
    public ShopTuiJianAdapter(int layoutResId, @Nullable List<ShopDetail.ResultBean.RecommendBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopDetail.ResultBean.RecommendBean item) {
        ImageView img_shangpin_photo = helper.getView(R.id.img_shangpin_photo);
        RequestOptions options = new RequestOptions();
        Glide.with(MyApp.context).load(item.getCoverUrl()).into(img_shangpin_photo);
        helper.setText(R.id.tv_shangpin_price,String.valueOf(item.getMarketPrice()));
        helper.setText(R.id.tv_shangpin_title,item.getName());
    }
}
