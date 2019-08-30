package com.huohougongfu.app.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MaiChaDetail;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class ShouYeAdapter extends BaseQuickAdapter<MaiChaDetail.ResultBean,BaseViewHolder> {
    public ShouYeAdapter(int layoutResId, @Nullable List<MaiChaDetail.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MaiChaDetail.ResultBean item) {
        ImageView img_maicha_photo = helper.getView(R.id.img_maicha_photo);
        helper.setText(R.id.tv_maicha_title,item.getName());
        helper.setText(R.id.tv_maicha_price,String.valueOf(item.getProductPrice()));
        Glide.with(MyApp.context).load(item.getMasterGraph())
                .apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_maicha_photo);
    }
}
