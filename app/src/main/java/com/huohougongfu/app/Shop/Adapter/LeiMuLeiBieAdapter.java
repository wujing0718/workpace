package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.QuanBuLeiMu;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class LeiMuLeiBieAdapter extends BaseQuickAdapter<QuanBuLeiMu.ResultBean.ListBean,BaseViewHolder> {
    public

    LeiMuLeiBieAdapter(int layoutResId, @Nullable List<QuanBuLeiMu.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, QuanBuLeiMu.ResultBean.ListBean item) {
        helper.setText(R.id.tv_dianpu_name,item.getName());
        ImageView img_dianpu_logo = helper.getView(R.id.img_dianpu_logo);
        Glide.with(MyApp.context).load(item.getPic()).into(img_dianpu_logo);
    }
}
