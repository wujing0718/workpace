package com.huohougongfu.app.Shop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.PingJia;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.TeiHuiGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.PingJiaFragment;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;
import com.lxj.xpopup.interfaces.XPopupImageLoader;
import com.youth.banner.loader.ImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PingJiaAdapter extends BaseQuickAdapter<PingJia.ResultBean.ListBean,BaseViewHolder> {
    private List<Object> mlist = new ArrayList<>();
    private Context context;
    private List<PingJia.ResultBean.ListBean> data1;
    public PingJiaAdapter(int layoutResId, @Nullable List<PingJia.ResultBean.ListBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, PingJia.ResultBean.ListBean item) {
        RecyclerView pinglun_photo = helper.getView(R.id.pinglun_photo);
        pinglun_photo.setLayoutManager(new GridLayoutManager(context, 3));

        View bt_pinglun_dianzan = helper.getView(R.id.view_huifu);
        helper.addOnClickListener(R.id.bt_pinglun_dianzan);
        ImageView touxiang = helper.getView(R.id.img_pinglun_touxiang);
        ImageView img_dianzan = helper.getView(R.id.img_dianzan);
        //圆头像
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(context).load(item.getPhoto()).apply(options).into(touxiang);
        helper.setText(R.id.tv_name,item.getVideo());
        helper.setText(R.id.tv_dianzan_num,String.valueOf(item.getFavour()));
        helper.setText(R.id.tv_pingjia_content,item.getAppraiseContent());
        helper.setText(R.id.tv_time,item.getCreateTime());
        helper.setText(R.id.tv_chenghu,item.getLevel());
        if (item.getStatus()){
            img_dianzan.setImageResource(R.mipmap.img_dianzanok);
        }else{
            img_dianzan.setImageResource(R.mipmap.img_dianzan);
        }
        String picture1 = item.getPicture();
        if(item.getAnswerContent()!=null){
            bt_pinglun_dianzan.setVisibility(View.VISIBLE);
            helper.setText(R.id.tv_huifu_content,item.getAnswerContent());
            helper.setText(R.id.tv_huifu_time,item.getAnswerTime());
        }else{
            bt_pinglun_dianzan.setVisibility(View.GONE);
        }
        if(picture1 !=null){
            String[] split = picture1.split(",");
            pinglun_photo.setVisibility(View.VISIBLE);
            for (int i = 0; i < split.length; i++) {
                mlist.add(split[i]);
            }
            ImageAdapter pingJiaPhotoAdapter = new ImageAdapter(mlist);
            pinglun_photo.setAdapter(pingJiaPhotoAdapter);
        }else{
            pinglun_photo.setVisibility(View.GONE);
        }
    }
    public static class ImageLoader implements XPopupImageLoader {
        @Override
        public void loadImage(int position, @NonNull Object url, @NonNull ImageView imageView) {
            //必须指定Target.SIZE_ORIGINAL，否则无法拿到原图，就无法享用天衣无缝的动画
            Glide.with(imageView).load(url).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher_round).override(Target.SIZE_ORIGINAL)).into(imageView);
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
    public void add(List<PingJia.ResultBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<PingJia.ResultBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }

}
