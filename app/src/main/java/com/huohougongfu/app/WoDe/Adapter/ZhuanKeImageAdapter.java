package com.huohougongfu.app.WoDe.Adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.facebook.drawee.view.SimpleDraweeView;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.ViewHolder;

import java.util.List;

public class ZhuanKeImageAdapter extends EasyAdapter<Object> {
    private List<Object> mlist;
    public ZhuanKeImageAdapter(List<Object> mlist) {
        super(mlist, R.layout.item_zhuanke_detail_photo);
        this.mlist = mlist;
    }

    @Override
    protected void bind(@NonNull final ViewHolder holder, @NonNull final Object s, final int position) {
        final ImageView imageView = holder.<ImageView>getView(R.id.img_shop_detail);

        //1. 加载图片, 由于ImageView是centerCrop，必须指定Target.SIZE_ORIGINAL，禁止Glide裁剪图片；
        // 这样我就能拿到原始图片的Matrix，才能有完美的过渡效果
        Glide.with(imageView).asBitmap().load(s).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)
                .override(Target.SIZE_ORIGINAL))
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        int width = resource.getWidth();//图片原始宽度
                        int height = resource.getHeight();//图片原始高度
                        //屏幕的宽度(px值）
                        double screenWidth = MyApp.context.getResources().getDisplayMetrics().widthPixels;
                        //Item的宽度，或图片的宽度
                        double width1 = screenWidth-30;
                        ViewGroup.LayoutParams para = imageView.getLayoutParams();
                        double hight1 = width1/width*height;
                        para.width = (int) width1;
                        para.height = (int) hight1;
                        imageView.setLayoutParams(para);
                        imageView.setImageBitmap(resource);
                    }
                });

        //2. 设置点击
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new XPopup.Builder(holder.itemView.getContext()).asImageViewer(imageView, position, mlist, new OnSrcViewUpdateListener() {
//                    @Override
//                    public void onSrcViewUpdate(ImageViewerPopupView popupView, int position) {
//                        RecyclerView rv = (RecyclerView) holder.itemView.getParent();
//                        popupView.updateSrcView((ImageView)rv.getChildAt(position));
//                    }
//                }, new PingJiaAdapter.ImageLoader())
//                        .show();
//            }
//        });
    }
}

