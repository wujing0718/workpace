package com.huohougongfu.app.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.HuDongPingLun;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class HuDongDianZanAdapter extends BaseQuickAdapter<HuDongPingLun.ResultBean.ListBean,BaseViewHolder> {
    public HuDongDianZanAdapter(int layoutResId, @Nullable List<HuDongPingLun.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HuDongPingLun.ResultBean.ListBean item) {
        RequestOptions requestOptions = new RequestOptions().circleCrop().placeholder(R.mipmap.img_zhanweitu);
        ImageView img_touxiang = helper.getView(R.id.img_touxiang);
        ImageView img_my_photo = helper.getView(R.id.img_my_photo);
        View view_vip = helper.getView(R.id.view_vip);
        helper.setText(R.id.tv_name,item.getMember().getNickName());
        helper.setText(R.id.tv_my_fenlei,item.getMember().getMaster().getLevel());
        helper.setText(R.id.tv_my_weizhi,item.getMember().getPlace());
        helper.setText(R.id.tv_time,item.getCreateTime());
        helper.setText(R.id.tv_content,item.getMember().getNickName()+"点赞了你的动态");
        if (item.getMember().isVip()){
            view_vip.setVisibility(View.VISIBLE);
            helper.setText(R.id.tv_my_vipnum,"."+item.getMember().getMemberLevel());
        }else{
            view_vip.setVisibility(View.GONE);
        }
//        helper.setText(R.id.tv_my_vipnum,item.getMember().get)
        RequestOptions placeholder = new RequestOptions().placeholder(R.mipmap.img_zhanweitu);
        if (item.getCircleData()!=null){
            helper.setText(R.id.tv_my_content,item.getCircleData().getContent());
            String[] split = item.getCircleData().getPicture().split(",");
            if (split.length>0){
                Glide.with(MyApp.context).load(split[0]).apply(placeholder).into(img_my_photo);
            }else{
                Glide.with(MyApp.context).load(R.mipmap.img_zhanweitu).apply(placeholder).into(img_my_photo);

            }
        }else{
            Glide.with(MyApp.context).load(R.mipmap.img_zhanweitu).apply(placeholder).into(img_my_photo);
        }
        Glide.with(MyApp.context).load(item.getMember().getPhoto()).apply(requestOptions).into(img_touxiang);

    }
}
