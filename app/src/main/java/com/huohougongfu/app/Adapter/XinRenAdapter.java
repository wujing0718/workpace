package com.huohougongfu.app.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.LiBaoGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class XinRenAdapter extends BaseQuickAdapter<LiBaoGson.ResultBean.SystemBean,BaseViewHolder>{
    public XinRenAdapter(int layoutResId, @Nullable List<LiBaoGson.ResultBean.SystemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LiBaoGson.ResultBean.SystemBean item) {
//        View view = helper.getView(R.id.bt_zhuanzeng);
//        view.setVisibility(View.GONE);
        ImageView img_quan_photo = helper.getView(R.id.img_quan_photo);
        helper.addOnClickListener(R.id.bt_zhuanzeng);
        helper.addOnClickListener(R.id.bt_serviceRegulations);
        Glide.with(MyApp.context).load(item.getPicture()).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_quan_photo);
        helper.setText(R.id.tv_quan_title,item.getTitle());
        helper.setText(R.id.tv_quan_jieshao,item.getServiceRegulations());
        helper.setText(R.id.tv_quan_endTime,item.getCreateTime());
    }
}
