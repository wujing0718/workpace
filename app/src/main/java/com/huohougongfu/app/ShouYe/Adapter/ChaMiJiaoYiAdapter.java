package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ChaMiJiaoYI;
import com.huohougongfu.app.Gson.ShopGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChaMiJiaoYiAdapter extends BaseQuickAdapter<ChaMiJiaoYI.ResultBean.RecordBean.ListBean,BaseViewHolder> {

    private List<ChaMiJiaoYI.ResultBean.RecordBean.ListBean> data1;
    public ChaMiJiaoYiAdapter(int layoutResId, @Nullable List<ChaMiJiaoYI.ResultBean.RecordBean.ListBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ChaMiJiaoYI.ResultBean.RecordBean.ListBean item) {
        ImageView img_quan_photo = helper.getView(R.id.img_quan_photo);
        Glide.with(MyApp.context).load(item.getPhoto()).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu).circleCrop()).into(img_quan_photo);
        helper.addOnClickListener(R.id.bt_zhuanzeng);
        helper.addOnClickListener(R.id.bt_serviceRegulations);
        helper.setText(R.id.tv_quan_title,item.getType());
        helper.setText(R.id.tv_quan_time,item.getCreateTime());
        helper.setText(R.id.tv_laizi_name,String.valueOf(item.getCount()));
    }
    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<ChaMiJiaoYI.ResultBean.RecordBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<ChaMiJiaoYI.ResultBean.RecordBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
