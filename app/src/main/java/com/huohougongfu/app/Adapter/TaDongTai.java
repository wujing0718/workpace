package com.huohougongfu.app.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyDongTai;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.ImageAdapter;
import com.lxj.xpopup.interfaces.XPopupImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TaDongTai  extends BaseQuickAdapter<MyDongTai.ResultBean.ListBean,BaseViewHolder> {
    private Context context;
    private List<MyDongTai.ResultBean.ListBean> data1;

    public TaDongTai(int layoutResId, @Nullable List<MyDongTai.ResultBean.ListBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
        this.data1 = data;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void convert(BaseViewHolder helper, MyDongTai.ResultBean.ListBean item) {
        RecyclerView rec_dongtai_photo = helper.getView(R.id.rec_dongtai_photo);
        TextView tv_dongtai_title = helper.getView(R.id.tv_dongtai_title);
        TextView tv_dongtai_content = helper.getView(R.id.tv_dongtai_content);
        ImageView img_xihuan = helper.getView(R.id.img_xihuan);
        rec_dongtai_photo.setLayoutManager(new GridLayoutManager(context, 3));
        helper.addOnClickListener(R.id.bt_dianzan);
        rec_dongtai_photo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return helper.itemView.onTouchEvent(event);
            }
        });
        if (item.getIsPraise() == 1){
            img_xihuan.setImageResource(R.mipmap.img_xihuan2);
        }else{
            img_xihuan.setImageResource(R.mipmap.img_xihuan);
        }
        if(item.getPicture() !=null){
            String[] split = item.getPicture().split(",");
            rec_dongtai_photo.setVisibility(View.VISIBLE);
            List<Object> mlist = new ArrayList<>();
            if (item.getType() == 3){
                mlist.add(split[0]);
            }else{
                for (int i = 0; i < split.length; i++) {
                    mlist.add(split[i]);
                }
            }
            ImageAdapter pingJiaPhotoAdapter = new ImageAdapter(mlist);
            rec_dongtai_photo.setAdapter(pingJiaPhotoAdapter);
        }else{
            rec_dongtai_photo.setVisibility(View.GONE);
        }
        if (item.getTitle()!=null){
            tv_dongtai_title.setVisibility(View.VISIBLE);
            helper.setText(R.id.tv_dongtai_title,item.getTitle());
        }else{
            tv_dongtai_title.setVisibility(View.GONE);
        }
        if (item.getContent()!=null){
            tv_dongtai_content.setVisibility(View.VISIBLE);
            String わわ = item.getContent().replace("わわ", "");
            String ゐゑを = わわ.replace("ゐゑを", "");
            helper.setText(R.id.tv_dongtai_content,ゐゑを);
        }else{
            tv_dongtai_content.setVisibility(View.GONE);
        }
        if (item.getContent()!=null){
            tv_dongtai_content.setVisibility(View.VISIBLE);
            String わわ = item.getContent().replace("わわ", "");
            String ゐゑを = わわ.replace("ゐゑを", "");
            helper.setText(R.id.tv_dongtai_content,ゐゑを);
        }else{
            tv_dongtai_content.setVisibility(View.GONE);
        }
        helper.setText(R.id.tv_dongtai_time,item.getCreateTime());
        helper.setText(R.id.tv_dongtai_pingjianum,String.valueOf(item.getCommentNum()));
        helper.setText(R.id.tv_dongtai_xihuannum,String.valueOf(item.getPraiseNum()));

    }

    public static class ImageLoader implements XPopupImageLoader {
        @Override
        public void loadImage(int position, @NonNull Object url, @NonNull ImageView imageView) {
            //必须指定Target.SIZE_ORIGINAL，否则无法拿到原图，就无法享用天衣无缝的动画
            Glide.with(imageView).load(url).into(imageView);
        }

        @Override
        public File getImageFile(@NonNull Context context, @NonNull Object uri) {
            try {
                return Glide.with(context).downloadOnly().load(uri).submit().get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<MyDongTai.ResultBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<MyDongTai.ResultBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}