package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ZhuanKeYes;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class ZhuanKeYesAdapter extends BaseQuickAdapter<ZhuanKeYes.ResultBean.ListBean,BaseViewHolder>{
    public ZhuanKeYesAdapter(int layoutResId, @Nullable List<ZhuanKeYes.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhuanKeYes.ResultBean.ListBean item) {
        if(item.getMallProduct()!=null){
            String[] split = item.getMallProduct().getCoverUrl().split(",");
            ImageView img_shangpin_photo = helper.getView(R.id.img_shangpin_photo);
            helper.setText(R.id.tv_shangpin_title,item.getMallProduct().getName());
            helper.setText(R.id.tv_shangpin_collect_num,item.getMallProduct().getCollectionNum()+"人收藏");
            helper.setText(R.id.tv_shangpin_price,"¥"+item.getMallProduct().getPrice());
            if (split.length>0){
                Glide.with(MyApp.context).load(split[0]).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_shangpin_photo);
            }else{
                Glide.with(MyApp.context).load(R.mipmap.img_zhanweitu).into(img_shangpin_photo);
            }
        }
    }
}
