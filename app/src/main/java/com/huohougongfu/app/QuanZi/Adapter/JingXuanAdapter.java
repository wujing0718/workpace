package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyCaQuan;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class JingXuanAdapter extends BaseQuickAdapter<QuanZiFaXian.ResultBean.DatasBean.ListBean,BaseViewHolder> {
    public JingXuanAdapter(int layoutResId, @Nullable List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, QuanZiFaXian.ResultBean.DatasBean.ListBean item) {
        String picture = item.getPicture();
        String[] split = picture.split(",");
        if (split.length>0){
            ImageView img_jingxuan_wenzhang_photo = helper.getView(R.id.img_jingxuan_wenzhang_photo);
            Glide.with(MyApp.context).load(split[0]).into(img_jingxuan_wenzhang_photo);
        }
        helper.setText(R.id.tv_jingxuan_wenzhang_title,item.getTitle());
    }
}
