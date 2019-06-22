package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyCaQuan;
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
        helper.addOnClickListener(R.id.bt_zhuanzeng);
        helper.addOnClickListener(R.id.bt_serviceRegulations);
        Picasso.get().load(item.getImgUrl()).into(img_quan_photo);
        helper.setText(R.id.tv_quan_title,item.getTitle());
        helper.setText(R.id.tv_quan_jieshao,(String)item.getIntroduction());
        helper.setText(R.id.tv_quan_endTime,item.getEndTime());
    }
}
