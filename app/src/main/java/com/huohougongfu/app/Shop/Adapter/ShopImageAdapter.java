package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.huohougongfu.app.R;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;

import java.util.List;

public class ShopImageAdapter extends EasyAdapter<Object> {
    private List<Object> mlist;
    public ShopImageAdapter(List<Object> mlist) {
        super(mlist, R.layout.item_shop_detail_photo);
        this.mlist = mlist;
    }

    @Override
    protected void bind(@NonNull final ViewHolder holder, @NonNull final Object s, final int position) {
        final ImageView imageView = holder.<ImageView>getView(R.id.img_shop_detail);
        //1. 加载图片, 由于ImageView是centerCrop，必须指定Target.SIZE_ORIGINAL，禁止Glide裁剪图片；
        // 这样我就能拿到原始图片的Matrix，才能有完美的过渡效果
        Glide.with(imageView).load(s).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)
                .override(Target.SIZE_ORIGINAL))
                .into(imageView);

        //2. 设置点击
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new XPopup.Builder(holder.itemView.getContext()).asImageViewer(imageView, position, mlist, new OnSrcViewUpdateListener() {
                    @Override
                    public void onSrcViewUpdate(ImageViewerPopupView popupView, int position) {
                        RecyclerView rv = (RecyclerView) holder.itemView.getParent();
                        popupView.updateSrcView((ImageView)rv.getChildAt(position));
                    }
                }, new PingJiaAdapter.ImageLoader())
                        .show();
            }
        });
    }
}

