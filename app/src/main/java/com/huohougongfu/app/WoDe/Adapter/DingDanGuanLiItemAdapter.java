package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.DingDanGuanLi;
import com.huohougongfu.app.Gson.MyDingDan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class DingDanGuanLiItemAdapter extends BaseQuickAdapter<DingDanGuanLi.ResultBean.MallProductsBean,BaseViewHolder> {
    public DingDanGuanLiItemAdapter(int layoutResId, @Nullable List<DingDanGuanLi.ResultBean.MallProductsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DingDanGuanLi.ResultBean.MallProductsBean item) {
        TextView tv_shenqingshouhou = helper.getView(R.id.tv_shenqingshouhou);
        tv_shenqingshouhou.setVisibility(View.GONE);
        ImageView img_dingdan_photo = helper.getView(R.id.img_dingdan_photo);
        helper.setText(R.id.tv_dingdan_shangpin_title,item.getName());
        helper.setText(R.id.tv_dingdan_shangpin_guige,item.getStandard());
        helper.setText(R.id.tv_dingdan_shangpin_price,"¥"+String.valueOf(item.getPrice()));
        helper.setText(R.id.tv_dingdan_shangpin_num,"x"+String.valueOf(item.getNum()));
        String[] split = item.getCoverUrl().split(",");
        Glide.with(MyApp.context).load(split[0]).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_dingdan_photo);
    }
}
