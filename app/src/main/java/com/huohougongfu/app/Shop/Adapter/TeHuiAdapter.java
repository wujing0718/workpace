package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haozhang.lib.SlantedTextView;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.ShopGson;
import com.huohougongfu.app.Gson.TeiHuiGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeHuiAdapter extends BaseQuickAdapter<TeiHuiGson.ResultBean.ListBean,BaseViewHolder> {

    private List<TeiHuiGson.ResultBean.ListBean> data1;

    public TeHuiAdapter(int layoutResId, @Nullable List<TeiHuiGson.ResultBean.ListBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, TeiHuiGson.ResultBean.ListBean item) {
        SlantedTextView slanted = helper.getView(R.id.slanted);
        TextView tv_yinli = helper.getView(R.id.tv_yinli);
        if (item.getOfCheap() == 1){
            slanted.setVisibility(View.VISIBLE);
            slanted.setText("特惠");
        }else{
            slanted.setVisibility(View.GONE);
        }
        if (item.getCommission()!=null){
            tv_yinli.setVisibility(View.VISIBLE);
            tv_yinli.setText("赚 ¥"+item.getCommission());
        }else{
            tv_yinli.setVisibility(View.GONE);
        }
        ImageView img_jingxuan_photo = helper.getView(R.id.img_jingxuan_photo);
        String[] split = item.getCoverUrl().split(",");
        Glide.with(MyApp.context).load(split[0]).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_jingxuan_photo);
        helper.setText(R.id.tv_jingxuan_title,item.getName());
        helper.setText(R.id.tv_jingxuan_price,String.valueOf(item.getPrice()));
        helper.setText(R.id.tv_jingxuan_name,"【"+item.getModel()+"】");
        helper.setText(R.id.tv_jingxuan_num,item.getSellNum()+"人付款");
    }
    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<TeiHuiGson.ResultBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<TeiHuiGson.ResultBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
