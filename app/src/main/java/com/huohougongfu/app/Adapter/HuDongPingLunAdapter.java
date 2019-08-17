package com.huohougongfu.app.Adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.HuDongPingLun;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class HuDongPingLunAdapter extends BaseQuickAdapter<HuDongPingLun.ResultBean.ListBean,BaseViewHolder> {
    public HuDongPingLunAdapter(int layoutResId, @Nullable List<HuDongPingLun.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HuDongPingLun.ResultBean.ListBean item) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        ImageView img_touxiang = helper.getView(R.id.img_touxiang);
        ImageView img_my_photo = helper.getView(R.id.img_my_photo);
        helper.setText(R.id.tv_name,item.getMember().getNickName());
        helper.setText(R.id.tv_my_fenlei,item.getMember().getMaster().getLevel());
        helper.setText(R.id.tv_my_weizhi,item.getMember().getPlace());
        helper.setText(R.id.tv_time,item.getCreateTime());
        helper.setText(R.id.tv_content,item.getContent());
        helper.setText(R.id.tv_my_content,item.getCircleData().getContent());
        Glide.with(MyApp.context).load(item.getMember().getPhoto()).apply(requestOptions).into(img_touxiang);
        Glide.with(MyApp.context).load(item.getCircleData().getPicture()).into(img_my_photo);
    }
}
