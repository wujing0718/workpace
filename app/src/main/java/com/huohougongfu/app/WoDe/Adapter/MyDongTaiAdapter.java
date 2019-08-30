package com.huohougongfu.app.WoDe.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyDongTai;
import com.huohougongfu.app.Gson.WoDeCollect;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.ImageAdapter;
import com.lxj.xpopup.interfaces.XPopupImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MyDongTaiAdapter extends BaseQuickAdapter<MyDongTai.ResultBean.ListBean,BaseViewHolder> {
    private Context context;
    private List<MyDongTai.ResultBean.ListBean> data1;
    private List<MyDongTai.ResultBean.ListBean> mMyLiveList;
    private static final int MYLIVE_MODE_CHECK = 0;
    int mEditMode = MYLIVE_MODE_CHECK;

    public MyDongTaiAdapter(int layoutResId, @Nullable List<MyDongTai.ResultBean.ListBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
        this.data1 = data;
    }
    public void notifyAdapter(List<MyDongTai.ResultBean.ListBean> myLiveList, boolean isAdd) {
        if (!isAdd) {
            this.mMyLiveList = myLiveList;
        } else {
            this.mMyLiveList.addAll(myLiveList);
        }
        notifyDataSetChanged();
    }

    public List<MyDongTai.ResultBean.ListBean> getMyLiveList() {
        if (mMyLiveList == null) {
            mMyLiveList = new ArrayList<>();
        }
        return mMyLiveList;
    }

    public void setEditMode(int editMode) {
        mEditMode = editMode;
        notifyDataSetChanged();
    }
    @Override
    protected void convert(BaseViewHolder helper, MyDongTai.ResultBean.ListBean item) {
        final MyDongTai.ResultBean.ListBean myLive = mMyLiveList.get(helper.getAdapterPosition());
        ImageView iv_select = helper.getView(R.id.iv_select);
//        holder.mTvTitle.setText(myLive.getTitle());
//        holder.mTvSource.setText(myLive.getSource());
        if (mEditMode == MYLIVE_MODE_CHECK) {
            iv_select.setVisibility(View.GONE);
        } else {
            iv_select.setVisibility(View.VISIBLE);
            if (myLive.getIsSelect()) {
                iv_select.setImageResource(R.mipmap.select);
            } else {
                iv_select.setImageResource(R.mipmap.unselect);
            }
        }
        RecyclerView rec_dongtai_photo = helper.getView(R.id.rec_dongtai_photo);
        TextView tv_dongtai_title = helper.getView(R.id.tv_dongtai_title);
        TextView tv_dongtai_content = helper.getView(R.id.tv_dongtai_content);
        rec_dongtai_photo.setLayoutManager(new GridLayoutManager(context, 3));
        if(item.getPicture() !=null){
            String[] split = item.getPicture().split(",");
            rec_dongtai_photo.setVisibility(View.VISIBLE);
            for (int i = 0; i < split.length; i++) {
                List<Object> mlist = new ArrayList<>();
                mlist.add(split[i]);
                ImageAdapter pingJiaPhotoAdapter = new ImageAdapter(mlist);
                rec_dongtai_photo.setAdapter(pingJiaPhotoAdapter);
            }
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
        helper.setText(R.id.tv_dongtai_time,item.getCreateTime());
        helper.setText(R.id.tv_dongtai_pingjianum,String.valueOf(item.getCommentNum()));
        helper.setText(R.id.tv_dongtai_xihuannum,String.valueOf(item.getPraiseNum()));
    }

    public static class ImageLoader implements XPopupImageLoader {
        @Override
        public void loadImage(int position, @NonNull Object url, @NonNull ImageView imageView) {
            //必须指定Target.SIZE_ORIGINAL，否则无法拿到原图，就无法享用天衣无缝的动画
            Glide.with(imageView).load(url).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu).override(Target.SIZE_ORIGINAL)).into(imageView);
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
