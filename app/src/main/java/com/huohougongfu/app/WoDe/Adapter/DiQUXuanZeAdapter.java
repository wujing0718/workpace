package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.JsonBean;
import com.huohougongfu.app.R;

import java.util.ArrayList;
import java.util.List;

public class DiQUXuanZeAdapter extends RecyclerView.Adapter<DiQUXuanZeAdapter.ViewHolder> {

    private  ArrayList<String> nameList;

    private SparseBooleanArray mSelectedPositions = new SparseBooleanArray();
    private boolean mIsSelectable = false;
    public DiQUXuanZeAdapter(ArrayList<String> nameList) {
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_diquxuanz, viewGroup, false);
        return new ViewHolder(itemView);
    }

    //设置给定位置条目的选择状态
    private void setItemChecked(int position, boolean isChecked) {
        mSelectedPositions.put(position, isChecked);
    }

    //根据位置判断条目是否选中
    private boolean isItemChecked(int position) {
        return mSelectedPositions.get(position);
    }

    //获得选中条目的结果
    public ArrayList<String> getSelectedItem() {
        ArrayList<String> selectList = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            if (isItemChecked(i)) {
                selectList.add(nameList.get(i));
            }
        }
        return selectList;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv_diqu_name.setText(nameList.get(i));
        if (isItemChecked(i)){
            viewHolder.img_check_diqu.setImageResource(R.mipmap.select);
        }else{
            viewHolder.img_check_diqu.setImageResource(R.mipmap.unselect);
        }
        viewHolder.bt_check_diqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isItemChecked(i)) {
                    setItemChecked(i, false);
                } else {
                    setItemChecked(i, true);
                }
                notifyItemChanged(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_diqu_name;
        View bt_check_diqu;
        ImageView img_check_diqu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_diqu_name = itemView.findViewById(R.id.tv_diqu_name);
             bt_check_diqu = itemView.findViewById(R.id.bt_check_diqu);
            img_check_diqu = itemView.findViewById(R.id.img_check_diqu);
        }
    }
}
