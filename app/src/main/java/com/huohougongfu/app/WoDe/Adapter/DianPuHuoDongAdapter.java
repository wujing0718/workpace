package com.huohougongfu.app.WoDe.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.R;

import java.util.ArrayList;
import java.util.List;


public class DianPuHuoDongAdapter extends RecyclerView.Adapter<DianPuHuoDongAdapter.ViewHolder>{
    private Context context;
    private static final int MYLIVE_MODE_CHECK = 0;
    int mEditMode = MYLIVE_MODE_CHECK;

    private int secret = 0;
    private String title = "";
    private List<MyCollect.ResultBean.ListBean> mMyLiveList;
    private DianPuHuoDongAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(DianPuHuoDongAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClickListener(int pos,List<MyCollect.ResultBean.ListBean> myLiveList);

    }

    public DianPuHuoDongAdapter(Context context) {
        this.context = context;
    }


    public void notifyAdapter(List<MyCollect.ResultBean.ListBean> myLiveList, boolean isAdd) {
        if (!isAdd) {
            this.mMyLiveList = myLiveList;
        } else {
            this.mMyLiveList.addAll(myLiveList);
        }
        notifyDataSetChanged();
    }

    public List<MyCollect.ResultBean.ListBean> getMyLiveList() {
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my_collect, viewGroup, false);
        DianPuHuoDongAdapter.ViewHolder holder = new DianPuHuoDongAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DianPuHuoDongAdapter.ViewHolder viewHolder, int i) {
        final MyCollect.ResultBean.ListBean myLive = mMyLiveList.get(viewHolder.getAdapterPosition());
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_select = itemView.findViewById(R.id.iv_select);

        }
    }
}
