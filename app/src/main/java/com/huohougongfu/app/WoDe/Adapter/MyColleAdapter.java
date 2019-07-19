package com.huohougongfu.app.WoDe.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MyColleAdapter extends RecyclerView.Adapter<MyColleAdapter.ViewHolder> {

    private static final int MYLIVE_MODE_CHECK = 0;
    int mEditMode = MYLIVE_MODE_CHECK;

    private int secret = 0;
    private String title = "";
    private Context context;
    private List<MyCollect.ResultBean.ListBean> mMyLiveList;
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClickListener(int pos,List<MyCollect.ResultBean.ListBean> myLiveList);

    }

    public MyColleAdapter(Context context) {
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

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_my_collect, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
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
        Glide.with(context).load(myLive.getCoverUrl()).into(viewHolder.img_shangpin_photo);
        viewHolder.tv_shangpin_title.setText(myLive.getName());
        viewHolder.tv_shangpin_price.setText("¥"+String.valueOf(myLive.getPrice()));
        viewHolder.tv_shangpin_collect_num.setText(String.valueOf(myLive.getCollectionNum())+"人收藏");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClickListener(viewHolder.getAdapterPosition(), mMyLiveList);
                }
            }
        });
    }

    public void setEditMode(int editMode) {
        mEditMode = editMode;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mMyLiveList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_shangpin_title,tv_shangpin_price,tv_shangpin_collect_num;
        ImageView iv_select,img_shangpin_photo;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_select = itemView.findViewById(R.id.iv_select);
            img_shangpin_photo = itemView.findViewById(R.id.img_shangpin_photo);
            tv_shangpin_title = itemView.findViewById(R.id.tv_shangpin_title);
            tv_shangpin_price = itemView.findViewById(R.id.tv_shangpin_price);
            tv_shangpin_collect_num = itemView.findViewById(R.id.tv_shangpin_collect_num);

        }
    }
}
