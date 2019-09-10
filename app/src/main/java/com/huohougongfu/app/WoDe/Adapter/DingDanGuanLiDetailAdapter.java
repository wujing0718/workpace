package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyDingDanDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class DingDanGuanLiDetailAdapter extends BaseQuickAdapter<MyDingDanDetail.ResultBean.MallStoresBean.MallProductsBean,BaseViewHolder> {
    private int orderStatus;
    public DingDanGuanLiDetailAdapter(int layoutResId, @Nullable List<MyDingDanDetail.ResultBean.MallStoresBean.MallProductsBean> data, int orderStatus) {
        super(layoutResId, data);
        this.orderStatus =orderStatus;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyDingDanDetail.ResultBean.MallStoresBean.MallProductsBean item) {
        TextView tv_shenqingshouhou = helper.getView(R.id.tv_shenqingshouhou);
        TextView tv_pingjia = helper.getView(R.id.tv_pingjia);
        helper.addOnClickListener(R.id.tv_shenqingshouhou);
        helper.addOnClickListener(R.id.tv_pingjia);
        if (orderStatus ==4){
            tv_pingjia.setVisibility(View.GONE);
            tv_shenqingshouhou.setVisibility(View.GONE);
        }else if (orderStatus == 3){
            tv_pingjia.setVisibility(View.GONE);
            tv_shenqingshouhou.setVisibility(View.GONE);
        }else{
            tv_shenqingshouhou.setVisibility(View.GONE);
            tv_pingjia.setVisibility(View.GONE);
        }
        ImageView img_dingdan_photo = helper.getView(R.id.img_dingdan_photo);
        helper.setText(R.id.tv_dingdan_shangpin_title,item.getName());
        helper.setText(R.id.tv_dingdan_shangpin_guige,item.getStandard());
        helper.setText(R.id.tv_dingdan_shangpin_price,"¥"+String.valueOf(item.getPrice()));
        helper.setText(R.id.tv_dingdan_shangpin_num,"x"+String.valueOf(item.getNum()));
        String[] split = item.getCoverUrl().split(",");
        Glide.with(MyApp.context).load(split[0]).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_dingdan_photo);
    }
}
