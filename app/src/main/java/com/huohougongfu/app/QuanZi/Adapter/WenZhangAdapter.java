package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MallGson;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.bumptech.glide.request.target.Target.SIZE_ORIGINAL;

public class WenZhangAdapter extends BaseQuickAdapter<QuanZiFaXian.ResultBean.DatasBean.ListBean,BaseViewHolder> {
    private List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data1;
    public WenZhangAdapter(int layoutResId, @Nullable List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, QuanZiFaXian.ResultBean.DatasBean.ListBean item) {
        ImageView img_wenzhang_photo = helper.getView(R.id.img_wenzhang_photo);
        ImageView img_wenzhang_touxiang = helper.getView(R.id.img_wenzhang_touxiang);
        ImageView img_xihuan = helper.getView(R.id.img_xihuan);
        helper.addOnClickListener(R.id.bt_dianzan);
        String picture = item.getPicture();

        if (item.getIsPraise() == 1){
            img_xihuan.setImageResource(R.mipmap.img_xihuan2);
        }else{
            img_xihuan.setImageResource(R.mipmap.img_xihuan);
        }

        if (item.getMember().getPhoto()!=null){
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(MyApp.context).load(item.getMember().getPhoto()).apply(requestOptions).into(img_wenzhang_touxiang);
        }else{
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with(MyApp.context).load(R.mipmap.img_wode1).apply(requestOptions).into(img_wenzhang_touxiang);
        }
        if (picture!= null){
            String[] split = picture.split(",");
            if (split.length>0){
                //屏幕的宽度(px值）
                int screenWidth = MyApp.context.getResources().getDisplayMetrics().widthPixels;
                //Item的宽度，或图片的宽度
                int width = screenWidth/2;
                RequestOptions options = new RequestOptions()
                        .override(width, SIZE_ORIGINAL);
                Glide.with(MyApp.context).load(split[0]).apply(options)
                        .into(img_wenzhang_photo);
            }
        }else{
            Picasso.get().load(R.mipmap.ic_launcher).into(img_wenzhang_photo);
        }
        String time = utils.transForDate2(Long.valueOf(item.getCreateTime()));
        helper.setText(R.id.tv_wenzhang_name,item.getMember().getNickName());
        helper.setText(R.id.tv_wenzhang_content,item.getTitle());
        helper.setText(R.id.tv_wenzhang_time,time);
        helper.setText(R.id.tv_liulanliang_num,String.valueOf(item.getPraiseNum()));
        helper.setText(R.id.tv_pinglum_num,String.valueOf(item.getPraiseNum()));
        helper.setText(R.id.tv_xihuan_num,String.valueOf(item.getPraiseNum()));


    }

    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
