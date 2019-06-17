package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class PinPaiAdapter extends BaseQuickAdapter<ShangPinGson.DataBean.ListBean,BaseViewHolder> {
    private  List<ShangPinGson.DataBean.ListBean> data;
    public PinPaiAdapter(int layoutResId, @Nullable List<ShangPinGson.DataBean.ListBean> data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShangPinGson.DataBean.ListBean item) {
        RecyclerView rec_pinpai_shangpin = helper.getView(R.id.rec_pinpai_shangpin);
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(MyApp.getInstances());
        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置RecyclerView 布局
        rec_pinpai_shangpin.setLayoutManager(layoutmanager);
        PinPaiItemAdapter shangPinTuiJianAdapter = new PinPaiItemAdapter(MyApp.getInstances(),data);
        rec_pinpai_shangpin.setAdapter(shangPinTuiJianAdapter);
    }
}
