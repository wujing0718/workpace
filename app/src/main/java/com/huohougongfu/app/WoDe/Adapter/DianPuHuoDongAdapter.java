package com.huohougongfu.app.WoDe.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.Gson.StoreEvents;
import com.huohougongfu.app.R;

import java.util.ArrayList;
import java.util.List;


public class DianPuHuoDongAdapter extends RecyclerView.Adapter<DianPuHuoDongAdapter.ViewHolder>{
    private Context context;
    private static final int MYLIVE_MODE_CHECK = 0;
    int mEditMode = MYLIVE_MODE_CHECK;

    private int secret = 0;
    private String title = "";
    private List<StoreEvents.ResultBean> mMyLiveList;
    private DianPuHuoDongAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(DianPuHuoDongAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClickListener(int pos,List<StoreEvents.ResultBean> myLiveList);

    }

    public DianPuHuoDongAdapter(Context context) {
        this.context = context;
    }


    public void notifyAdapter(List<StoreEvents.ResultBean> myLiveList, boolean isAdd) {
        if (!isAdd) {
            this.mMyLiveList = myLiveList;
        } else {
            this.mMyLiveList.addAll(myLiveList);
        }
        notifyDataSetChanged();
    }

    public List<StoreEvents.ResultBean> getMyLiveList() {
        if (mMyLiveList == null) {
            mMyLiveList = new ArrayList<>();
        }
        return mMyLiveList;
    }

    public void setEditMode(int editMode) {
        mEditMode = editMode;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DianPuHuoDongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dianpu_huodong_guanli, viewGroup, false);
        DianPuHuoDongAdapter.ViewHolder holder = new DianPuHuoDongAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DianPuHuoDongAdapter.ViewHolder viewHolder, int i) {
        final StoreEvents.ResultBean myLive = mMyLiveList.get(viewHolder.getAdapterPosition());
//        holder.mTvTitle.setText(myLive.getTitle());
//        holder.mTvSource.setText(myLive.getSource());
        if (mEditMode == MYLIVE_MODE_CHECK) {
            viewHolder.iv_select.setVisibility(View.GONE);
        } else {
            viewHolder.iv_select.setVisibility(View.VISIBLE);
            if (myLive.isSelect()) {
                viewHolder.iv_select.setImageResource(R.mipmap.select);
            } else {
                viewHolder.iv_select.setImageResource(R.mipmap.unselect);
            }
        }
        viewHolder.tv_lijilingqu.setVisibility(View.GONE);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClickListener(viewHolder.getAdapterPosition(), mMyLiveList);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMyLiveList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_select;
        TextView tv_lijilingqu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_select = itemView.findViewById(R.id.iv_select);
            tv_lijilingqu = itemView.findViewById(R.id.tv_lijilingqu);
        }
    }
}
