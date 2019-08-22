package com.huohougongfu.app.Shop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

public class ShopDetailPhoto  extends RecyclerView.Adapter<ShopDetailPhoto.ViewHolder> {
    private Context context;
    private String[] photo;
    public ShopDetailPhoto(Context context, String[] split) {
        this.context = context;
        this.photo = split;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop_detail_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RequestOptions placeholder = new RequestOptions().placeholder(R.mipmap.img_zhanweitu);
        Glide.with(MyApp.context).load(photo[i]).apply(placeholder).into(viewHolder.img_shop_detail);
    }

    @Override
    public int getItemCount() {
        return photo.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_shop_detail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_shop_detail = itemView.findViewById(R.id.img_shop_detail);
        }
    }
}
