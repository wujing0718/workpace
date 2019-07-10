package com.huohougongfu.app.Shop.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.GridView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.PingJia;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.R;

import java.util.List;

public class PingJiaAdapter extends BaseQuickAdapter<PingJia.ResultBean.ListBean,BaseViewHolder> {
    public PingJiaAdapter(int layoutResId, @Nullable List<PingJia.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PingJia.ResultBean.ListBean item) {
        GridView grv_pinglun_photo = helper.getView(R.id.grv_pinglun_photo);
        PingJiaPhotoAdapter pingJiaPhotoAdapter = new PingJiaPhotoAdapter();
        grv_pinglun_photo.setAdapter(pingJiaPhotoAdapter);

    }
}
