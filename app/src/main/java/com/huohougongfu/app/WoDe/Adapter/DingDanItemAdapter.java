package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyDingDan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class DingDanItemAdapter extends BaseQuickAdapter<MyDingDan.ResultBean.MallStoresBean.MallProductsBean,BaseViewHolder> {
    public DingDanItemAdapter(int layoutResId, @Nullable List<MyDingDan.ResultBean.MallStoresBean.MallProductsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyDingDan.ResultBean.MallStoresBean.MallProductsBean item) {
        ImageView img_dingdan_photo = helper.getView(R.id.img_dingdan_photo);
        helper.setText(R.id.tv_dingdan_shangpin_title,item.getName());
        helper.setText(R.id.tv_dingdan_shangpin_guige,item.getStandard());
        helper.setText(R.id.tv_dingdan_shangpin_price,"¥"+String.valueOf(item.getPrice()));
        helper.setText(R.id.tv_dingdan_shangpin_num,"x"+String.valueOf(item.getNum()));
        Glide.with(MyApp.context).load(item.getCoverUrl()).into(img_dingdan_photo);
    }
}
