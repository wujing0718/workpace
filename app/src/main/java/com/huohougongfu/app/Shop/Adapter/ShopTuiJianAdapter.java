package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShopDetail;
import com.huohougongfu.app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShopTuiJianAdapter extends BaseQuickAdapter<ShopDetail.ResultBean.RecommendationBean,BaseViewHolder> {
    public ShopTuiJianAdapter(int layoutResId, @Nullable List<ShopDetail.ResultBean.RecommendationBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopDetail.ResultBean.RecommendationBean item) {
        ImageView img_shangpin_photo = helper.getView(R.id.img_shangpin_photo);
        Picasso.get().load(item.getCoverUrl()).into(img_shangpin_photo);
        helper.setText(R.id.tv_shangpin_price,String.valueOf(item.getPrice()));
        helper.setText(R.id.tv_shangpin_title,item.getName());
    }
}
