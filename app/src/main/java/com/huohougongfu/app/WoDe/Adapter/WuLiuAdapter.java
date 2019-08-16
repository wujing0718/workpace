package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.WuLiuGson;
import com.huohougongfu.app.Gson.WuLiuString;
import com.huohougongfu.app.R;

import java.util.List;

public class WuLiuAdapter extends BaseQuickAdapter<WuLiuString.ListBean,BaseViewHolder> {
    public WuLiuAdapter(int layoutResId, @Nullable List<WuLiuString.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WuLiuString.ListBean item) {
        helper.setText(R.id.tv_wuliu,item.getTime()+"   "+item.getStatus());
    }
}
