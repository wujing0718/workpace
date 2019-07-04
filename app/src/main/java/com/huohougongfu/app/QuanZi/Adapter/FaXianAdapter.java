package com.huohougongfu.app.QuanZi.Adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.ShopGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.bumptech.glide.request.target.Target.SIZE_ORIGINAL;

public class FaXianAdapter extends BaseQuickAdapter<QuanZiFaXian.ResultBean.DatasBean.ListBean,BaseViewHolder> {

    private List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data1;
    public FaXianAdapter(int layoutResId, @Nullable List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        //屏幕的宽度(px值）
        int screenWidth = MyApp.context.getResources().getDisplayMetrics().widthPixels;
        //Item的宽度，或图片的宽度
        int width = screenWidth/2+10;

    }

    @Override
    protected void convert(BaseViewHolder helper, QuanZiFaXian.ResultBean.DatasBean.ListBean item) {
        helper.addOnClickListener(R.id.bt_dianzan);
        View view_dingwei = helper.getView(R.id.view_dingwei);
        ImageView img_quanzi_photo = helper.getView(R.id.img_quanzi_photo);
        ImageView img_faixan_touxiang = helper.getView(R.id.img_faixan_touxiang);
        ImageView img_faixan_shoucang = helper.getView(R.id.img_faixan_shoucang);

        String picture = item.getPicture();
        if (item.getAddress() != null){
            view_dingwei.setVisibility(View.VISIBLE);
        }else{
            view_dingwei.setVisibility(View.GONE);
        }
        if (item.getMember().getPhoto()!=null){
            Picasso.get().load(R.mipmap.ic_launcher).into(img_faixan_touxiang);
        }else{
            Picasso.get().load(R.mipmap.ic_launcher).into(img_faixan_touxiang);
        }

        if (item.getIsPraise() == 1){
            img_faixan_shoucang.setImageResource(R.mipmap.img_xihuan2);
        }else{
            img_faixan_shoucang.setImageResource(R.mipmap.img_xihuan);
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
                        .into(img_quanzi_photo);
            }
        }else{
            Picasso.get().load(R.mipmap.ic_launcher).into(img_quanzi_photo);
        }
        String time = utils.transForDate2(Long.valueOf(item.getCreateTime()));
        helper.setText(R.id.tv_faxian_name,item.getMember().getNickName());
        helper.setText(R.id.tv_faxian_content,item.getContent());
        helper.setText(R.id.tv_faxian_time,time);
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
