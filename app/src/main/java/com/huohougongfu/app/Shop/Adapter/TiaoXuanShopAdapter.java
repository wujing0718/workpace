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

public class TiaoXuanShopAdapter extends BaseQuickAdapter<SouSuoShopGson.ResultBean.ResultListBean.ListBean,BaseViewHolder> {
    private final List<SouSuoShopGson.ResultBean.ResultListBean.ListBean> data1;

    public TiaoXuanShopAdapter(int layoutResId, @Nullable List<SouSuoShopGson.ResultBean.ResultListBean.ListBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, SouSuoShopGson.ResultBean.ResultListBean.ListBean item) {
        SlantedTextView slanted = helper.getView(R.id.slanted);
        TextView tv_yinli = helper.getView(R.id.tv_yinli);
        slanted.setVisibility(View.GONE);
        tv_yinli.setVisibility(View.VISIBLE);
        tv_yinli.setText(String.valueOf("赚 ¥"+item.getCommission()));
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
