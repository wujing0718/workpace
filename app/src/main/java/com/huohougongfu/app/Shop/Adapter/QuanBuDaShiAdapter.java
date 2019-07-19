package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.DSZhuanChang;
import com.huohougongfu.app.Gson.TeYuePingPai;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class QuanBuDaShiAdapter extends BaseQuickAdapter<DSZhuanChang.ResultBean.AllMasterBean,BaseViewHolder> {
    private List<DSZhuanChang.ResultBean.AllMasterBean> data1;
    public QuanBuDaShiAdapter(int layoutResId, @Nullable List<DSZhuanChang.ResultBean.AllMasterBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, DSZhuanChang.ResultBean.AllMasterBean item) {
        helper.addOnClickListener(R.id.bt_dashi_jianjie);
        helper.addOnClickListener(R.id.bt_dashi_zhuye
        );
        ImageView img_quanbudashi_photo = helper.getView(R.id.img_quanbudashi_photo);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(item.getPhoto()).apply(requestOptions).into(img_quanbudashi_photo);
        helper.setText(R.id.tv_quanbudashi_name,item.getName());
        helper.setText(R.id.tv_quanbudashi_level,item.getLevel());

    }

    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<DSZhuanChang.ResultBean.AllMasterBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<DSZhuanChang.ResultBean.AllMasterBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
