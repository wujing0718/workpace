package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ZhaoRenGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class ZhaoRenAdapter extends BaseQuickAdapter<ZhaoRenGson.ResultBean.ListBean,BaseViewHolder> {
    public ZhaoRenAdapter(int layoutResId, @Nullable List<ZhaoRenGson.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhaoRenGson.ResultBean.ListBean item) {
        helper.addOnClickListener(R.id.bt_zhaoren_gaunzhu);
        helper.setText(R.id.tv_zhaoren_name,item.getNickName());
        helper.setText(R.id.tv_zhaoren_chenghu,item.getNickName());
        helper.setText(R.id.tv_zhaoren_weizhi,item.getPlace());
        ImageView img_zhaoren_photo = helper.getView(R.id.img_zhaoren_photo);
        Glide.with(MyApp.context).load(item.getPhoto()).into(img_zhaoren_photo);
    }
}
