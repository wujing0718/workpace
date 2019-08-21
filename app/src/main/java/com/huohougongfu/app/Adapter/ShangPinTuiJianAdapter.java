package com.huohougongfu.app.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.TeYuePingPai;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.PinPaiItemAdapter;

import java.util.List;

public class ShangPinTuiJianAdapter extends BaseQuickAdapter<TeYuePingPai.ResultBean.IsSpecialBean,BaseViewHolder> {

    private List<TeYuePingPai.ResultBean.IsSpecialBean> data;

    public ShangPinTuiJianAdapter(int layoutResId, @Nullable List<TeYuePingPai.ResultBean.IsSpecialBean> data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, TeYuePingPai.ResultBean.IsSpecialBean item) {
        helper.addOnClickListener(R.id.bt_dashi_jianjie);
        ImageView img_cainixihuan_photo = helper.getView(R.id.img_dashi_touxiang);
        RequestOptions requestOptions = new RequestOptions().circleCrop().placeholder(R.mipmap.img_zhanweitu);
        Glide.with(MyApp.context).load(item.getImg()).apply(requestOptions).into(img_cainixihuan_photo);
        helper.setText(R.id.tv_cainixihuan_name,item.getName());
    }
}
