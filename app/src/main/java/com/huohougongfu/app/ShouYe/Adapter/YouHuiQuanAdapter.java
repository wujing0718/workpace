package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ChaTaiYouHuiQuan;
import com.huohougongfu.app.Gson.ShopYouHuiQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class YouHuiQuanAdapter extends BaseQuickAdapter<ChaTaiYouHuiQuan.ResultBean.CouponsBean,BaseViewHolder> {
    public YouHuiQuanAdapter(int layoutResId, @Nullable List<ChaTaiYouHuiQuan.ResultBean.CouponsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChaTaiYouHuiQuan.ResultBean.CouponsBean item) {
        helper.addOnClickListener(R.id.bt_lingquyouhuiquan);
        ImageView img_quan_photo = helper.getView(R.id.img_quan_photo);
        View view = helper.getView(R.id.bt_zhuanzeng);
        view.setVisibility(View.GONE);
        helper.addOnClickListener(R.id.bt_serviceRegulations);
        Glide.with(MyApp.context).load(item.getPicture()).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_quan_photo);
        helper.setText(R.id.tv_quan_title,item.getTitle());
        if (item.getServiceRegulations()!=null){
            helper.setText(R.id.tv_quan_jieshao,item.getServiceRegulations());
        }
        helper.setText(R.id.tv_quan_endTime,"订单有效期"+item.getEndTime());
    }
}
