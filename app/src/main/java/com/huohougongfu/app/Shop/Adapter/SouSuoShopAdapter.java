package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haozhang.lib.SlantedTextView;
import com.huohougongfu.app.Gson.SouSuoShopGson;
import com.huohougongfu.app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SouSuoShopAdapter extends BaseQuickAdapter<SouSuoShopGson.ResultBean.ResultListBean.ListBean,BaseViewHolder> {
    private final List<SouSuoShopGson.ResultBean.ResultListBean.ListBean> data1;
    private String type;
    public SouSuoShopAdapter(int layoutResId, @Nullable List<SouSuoShopGson.ResultBean.ResultListBean.ListBean> data, String type) {
        super(layoutResId, data);
        this.data1 = data;
        this.type = type;
    }

    @Override
    protected void convert(BaseViewHolder helper, SouSuoShopGson.ResultBean.ResultListBean.ListBean item) {
        TextView tv_yinli = helper.getView(R.id.tv_yinli);
        if(type!=null){
            if (type.equals("赚客")){
                tv_yinli.setText("赚 ¥"+String.valueOf(item.getCommission()));
                tv_yinli.setVisibility(View.VISIBLE);
            }
        }else{
            tv_yinli.setVisibility(View.GONE);
        }
        SlantedTextView slanted = helper.getView(R.id.slanted);
        if (item.getOfCheap() == 1){
            slanted.setVisibility(View.VISIBLE);
            slanted.setText("特惠");
        }else{
            slanted.setVisibility(View.GONE);
        }
        slanted.setVisibility(View.GONE);
        ImageView img_jingxuan_photo = helper.getView(R.id.img_jingxuan_photo);
        Picasso.get().load(item.getCoverUrl()).into(img_jingxuan_photo);
        helper.setText(R.id.tv_jingxuan_title,item.getName());
        helper.setText(R.id.tv_jingxuan_price,String.valueOf(item.getPrice()));
        helper.setText(R.id.tv_jingxuan_name,"【"+item.getStoreName()+"】");
        helper.setText(R.id.tv_jingxuan_num,item.getSellNum()+"人付款");

    }

    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<SouSuoShopGson.ResultBean.ResultListBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<SouSuoShopGson.ResultBean.ResultListBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
