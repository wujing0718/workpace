package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.JingXuanRen;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class JingXuanRenAdapter extends BaseQuickAdapter<JingXuanRen.ResultBean.ListBean,BaseViewHolder> {

    public JingXuanRenAdapter(int layoutResId, @Nullable List<JingXuanRen.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JingXuanRen.ResultBean.ListBean item) {
        helper.addOnClickListener(R.id.bt_zhaoren_gaunzhu);
        TextView bt_zhaoren_gaunzhu = helper.getView(R.id.bt_zhaoren_gaunzhu);
        if (item.getIsAttention() == 1){
            bt_zhaoren_gaunzhu.setBackgroundResource(R.drawable.yiguanzhu);
            bt_zhaoren_gaunzhu.setText("已关注");
            bt_zhaoren_gaunzhu.setTextColor(MyApp.context.getResources().getColor(R.color.colorWhite));
        }
        helper.setText(R.id.tv_zhaoren_name,item.getNickName());
        helper.setText(R.id.tv_zhaoren_chenghu,item.getMaster().getLevel());
        helper.setText(R.id.tv_zhaoren_weizhi,item.getPlace());
        ImageView img_zhaoren_photo = helper.getView(R.id.img_zhaoren_photo);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(item.getPhoto()).apply(requestOptions).into(img_zhaoren_photo);
    }
}
