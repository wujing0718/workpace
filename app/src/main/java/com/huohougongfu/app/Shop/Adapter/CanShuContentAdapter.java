package com.huohougongfu.app.Shop.Adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huohougongfu.app.R;

import java.util.List;

public class CanShuContentAdapter extends RecyclerView.Adapter<CanShuContentAdapter.VH>{
    private List<String> val;
    public CanShuContentAdapter(List<String> val) {
        this.val = val;
    }

    @NonNull
    @Override
    public CanShuContentAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_canshu_name, viewGroup, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CanShuContentAdapter.VH vh, int i) {
            vh.tv_canshu_name.setText(val.get(i));
    }

    @Override
    public int getItemCount() {
        return val.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView tv_canshu_name;
        public VH(View v) {
            super(v);
            tv_canshu_name = v.findViewById(R.id.tv_canshu_name);
        }
    }
}
