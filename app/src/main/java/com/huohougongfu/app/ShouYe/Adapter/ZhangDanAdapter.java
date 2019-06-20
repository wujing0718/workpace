package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ZhangDan;
import com.huohougongfu.app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ZhangDanAdapter extends BaseQuickAdapter<ZhangDan.ResultBean.RecordsBean.ListBean,BaseViewHolder> {
    public ZhangDanAdapter(int layoutResId, @Nullable List<ZhangDan.ResultBean.RecordsBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhangDan.ResultBean.RecordsBean.ListBean item) {
        helper.setText(R.id.tv_zhangdan_title,item.getNickname());
        helper.setText(R.id.tv_zhangdan_time,item.getTime());
        helper.setText(R.id.tv_zhangdan_count,String.valueOf(item.getCount()));
        ImageView img_zhangdan_photo = helper.getView(R.id.img_zhangdan_photo);
        Picasso.get().load(item.getPhoto()).into(img_zhangdan_photo);
    }
}
