package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.PingLunGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class PingLunAdapter extends BaseQuickAdapter<PingLunGson.ResultBean.ListBean,BaseViewHolder> {
    public PingLunAdapter(int layoutResId, @Nullable List<PingLunGson.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PingLunGson.ResultBean.ListBean item) {
        ImageView img_pinglun_touxiang = helper.getView(R.id.img_pinglun_touxiang);
        Glide.with(MyApp.context).load(item.getMember().getPhoto()).into(img_pinglun_touxiang);
        helper.setText(R.id.tv_pinglun_name,item.getMember().getNickName());
        helper.setText(R.id.tv_pinglun_content,item.getContent());
        helper.setText(R.id.tv_pinglun_time,item.getCreateTime());
    }
}
