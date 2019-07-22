package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huohougongfu.app.Gson.AddressBean;
import com.huohougongfu.app.R;

import java.util.ArrayList;

public class PoiAdapter extends RecyclerView.Adapter<PoiAdapter.ViewHolder>{

    private ArrayList<AddressBean> data;

    private PoiAdapter.OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onClick(int position);
        void onLongClick(int position);
    }
    public void setOnItemClickListener(PoiAdapter.OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }

    public PoiAdapter(ArrayList<AddressBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public PoiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rcv_dizhipoi, viewGroup, false);
        PoiAdapter.ViewHolder viewHolder = new PoiAdapter.ViewHolder(inflate);
        return viewHolder;
    }

    public void refreshData( ArrayList<AddressBean> list){
        this.data = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull PoiAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.item_title.setText(data.get(i).getTitle());
        viewHolder.item_text.setText(data.get(i).getText());

        //RecyclerView的Item添加点击事件
        if( mOnItemClickListener!= null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(i);
                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(i);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView item_title,item_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.item_title);
            item_text = itemView.findViewById(R.id.item_text);
        }
    }
}
