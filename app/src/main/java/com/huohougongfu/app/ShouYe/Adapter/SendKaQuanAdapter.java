package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ChaQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SendKaQuanAdapter extends BaseQuickAdapter<ChaQuan.ResultBean.ReceivedBean,BaseViewHolder> {
    public SendKaQuanAdapter(int layoutResId, @Nullable List<ChaQuan.ResultBean.ReceivedBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChaQuan.ResultBean.ReceivedBean item) {
        ImageView img_quan_photo = helper.getView(R.id.img_quan_photo);
        helper.addOnClickListener(R.id.bt_zhuanzeng);
        View bt_zhuanzeng = helper.getView(R.id.bt_zhuanzeng);
        bt_zhuanzeng.setVisibility(View.GONE);
        helper.addOnClickListener(R.id.bt_serviceRegulations);
        Glide.with(MyApp.context).load(item.getPicture()).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_quan_photo);
        helper.setText(R.id.tv_quan_title,item.getTitle());
        helper.setText(R.id.tv_quan_jieshao,item.getServiceRegulations());
        helper.setText(R.id.tv_quan_endTime,item.getCreateTime());
    }
}
