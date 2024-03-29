package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.PingLunGson;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.Gson.ShopGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.ArrayList;
import java.util.List;

public class PingLunAdapter extends BaseQuickAdapter<PingLunGson.ResultBean.ListBean,BaseViewHolder> {

    private List<PingLunGson.ResultBean.ListBean> data1;

    public PingLunAdapter(int layoutResId, @Nullable List<PingLunGson.ResultBean.ListBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, PingLunGson.ResultBean.ListBean item) {
        helper.addOnClickListener(R.id.bt_dianzan);
        ImageView img_pinglun_touxiang = helper.getView(R.id.img_pinglun_touxiang);
        ImageView img_pinglun_dianzan = helper.getView(R.id.img_pinglun_dianzan);
        if (item.getMember().getPhoto()!=null){
            RequestOptions options = new RequestOptions().circleCrop();
            Glide.with(MyApp.context).load(item.getMember().getPhoto()).apply(options)
                    .into(img_pinglun_touxiang);
        }else{
            RequestOptions options = new RequestOptions().circleCrop();
            Glide.with(MyApp.context).load(R.mipmap.img_wode1).apply(options)
                    .into(img_pinglun_touxiang);
        }
        if (item.getIsPraise() == 1){
            img_pinglun_dianzan.setImageResource(R.mipmap.img_dianzanok);
        }else{
            img_pinglun_dianzan.setImageResource(R.mipmap.img_dianzan);
        }
        helper.setText(R.id.tv_pinglun_name,item.getMember().getNickName());
        helper.setText(R.id.tv_pinglun_content,item.getContent());
        helper.setText(R.id.tv_pinglun_time,item.getCreateTime());
        helper.setText(R.id.tv_pinglun_dianzannum,String.valueOf(item.getPraiseNum()));
    }

    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<PingLunGson.ResultBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<PingLunGson.ResultBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
