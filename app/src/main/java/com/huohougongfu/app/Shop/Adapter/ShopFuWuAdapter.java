package com.huohougongfu.app.Shop.Adapter;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShopFuWuGson;
import com.huohougongfu.app.R;

import java.util.List;

public class ShopFuWuAdapter extends BaseQuickAdapter<ShopFuWuGson.ResultBean.BasicServiceBean,BaseViewHolder>{
    public ShopFuWuAdapter(int layoutResId, @Nullable List<ShopFuWuGson.ResultBean.BasicServiceBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopFuWuGson.ResultBean.BasicServiceBean item) {
        helper.setText(R.id.tv_fuwu_key,item.getKey());
        helper.setText(R.id.tv_fuwu_val,item.getVal());
    }
}
