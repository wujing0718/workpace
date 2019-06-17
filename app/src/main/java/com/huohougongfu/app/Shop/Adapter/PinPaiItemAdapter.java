package com.huohougongfu.app.Shop.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huohougongfu.app.Adapter.ShangPinTuiJianAdapter;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class PinPaiItemAdapter extends RecyclerView.Adapter<PinPaiItemAdapter.ViewHolder> {

    private List<ShangPinGson.DataBean.ListBean>  data;
    private Context context;

    public PinPaiItemAdapter(Context context, List<ShangPinGson.DataBean.ListBean> item) {
        this.data = data;
        this.context = context;
    }
    @NonNull
    @Override
    public PinPaiItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shangpin_tuijian, viewGroup, false);
        PinPaiItemAdapter.ViewHolder viewHolder = new PinPaiItemAdapter.ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PinPaiItemAdapter.ViewHolder viewHolder, int i) {
//        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
//        LinearLayoutManager layoutmanager = new LinearLayoutManager(context);
//        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        //设置RecyclerView 布局
//        viewHolder.rec_pinpai_shangpin.setLayoutManager(layoutmanager);
//        ShangPinTuiJianAdapter shangPinTuiJianAdapter = new ShangPinTuiJianAdapter(R.layout.item_shangpin_tuijian,data);
//        viewHolder.rec_pinpai_shangpin.setAdapter(shangPinTuiJianAdapter);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rec_pinpai_shangpin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rec_pinpai_shangpin = itemView.findViewById(R.id.rec_pinpai_shangpin);
        }
    }
}