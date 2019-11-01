package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyCaQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyKaQuanAdapter extends BaseQuickAdapter<MyCaQuan.ResultBean,BaseViewHolder> {
    public MyKaQuanAdapter(int layoutResId, @Nullable List<MyCaQuan.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCaQuan.ResultBean item) {
        ImageView img_quan_photo = helper.getView(R.id.img_quan_photo);
        View bt_zhuanzeng = helper.getView(R.id.bt_zhuanzeng);
        helper.addOnClickListener(R.id.bt_zhuanzeng);
        helper.addOnClickListener(R.id.bt_serviceRegulations);
        if (item.getCouponType()==1){
            bt_zhuanzeng.setVisibility(View.VISIBLE);
        }else{
            bt_zhuanzeng.setVisibility(View.GONE);
        }
        Glide.with(MyApp.context).load(item.getPicturel()).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_quan_photo);
        helper.setText(R.id.tv_quan_title,item.getTitle());
        helper.setText(R.id.tv_quan_jieshao,item.getServiceRegulations());
        helper.setText(R.id.tv_quan_endTime,"有效期至"+item.getEndTime());
    }
}
