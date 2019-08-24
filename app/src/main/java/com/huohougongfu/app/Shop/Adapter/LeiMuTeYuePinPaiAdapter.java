package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.QuanBuLeiMu;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class LeiMuTeYuePinPaiAdapter extends BaseQuickAdapter<QuanBuLeiMu.ResultBean.ListBean,BaseViewHolder> {
    public LeiMuTeYuePinPaiAdapter(int layoutResId, @Nullable List<QuanBuLeiMu.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, QuanBuLeiMu.ResultBean.ListBean item) {
        ImageView img_teyuepinpai = helper.getView(R.id.img_teyuepinpai);
        helper.setText(R.id.tv_teyuepingpai_story,item.getSpecialInstructions());
        helper.setText(R.id.tv_teyuepingpai_name,item.getStoreName());
        Glide.with(MyApp.context).load(item.getDoorPhoto()).into(img_teyuepinpai);
    }
}
