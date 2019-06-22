package com.huohougongfu.app.ShouYe.Adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.KaQuanRecord;
import com.huohougongfu.app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SongChuAdapter extends BaseQuickAdapter<KaQuanRecord.ResultBean.SendBean,BaseViewHolder> {
    public SongChuAdapter(int layoutResId, @Nullable List<KaQuanRecord.ResultBean.SendBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, KaQuanRecord.ResultBean.SendBean item) {
        ImageView img_quan_photo = helper.getView(R.id.img_quan_photo);
        helper.addOnClickListener(R.id.bt_zhuanzeng);
        helper.addOnClickListener(R.id.bt_serviceRegulations);
        if (item.getImgUrl()!=null){
            Picasso.get().load((String) item.getImgUrl()).into(img_quan_photo);
        }
        if (item.getTitle()!=null){
            helper.setText(R.id.tv_quan_title,item.getTitle());
        }
        if (item.getEndTime()!=null){
            helper.setText(R.id.tv_quan_endTime,item.getEndTime());
        }
            helper.setText(R.id.tv_quan_jieshao,item.getServiceRegulations());
            helper.setText(R.id.tv_please_qiaoqiaohua,item.getCouponsLink().getPillowTalk());
            helper.setText(R.id.tv_please_name,item.getCouponsLink().getSendNick());
    }
}
