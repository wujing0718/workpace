package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShopGson;
import com.huohougongfu.app.Gson.ZhaoRenGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class ZhaoRenAdapter extends BaseQuickAdapter<ZhaoRenGson.ResultBean.ListBean,BaseViewHolder> {
    private List<ZhaoRenGson.ResultBean.ListBean> data1;
    public ZhaoRenAdapter(int layoutResId, @Nullable List<ZhaoRenGson.ResultBean.ListBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhaoRenGson.ResultBean.ListBean item) {
        helper.addOnClickListener(R.id.bt_zhaoren_gaunzhu);
        View view = helper.getView(R.id.tv_my_fensinum);
        View view_line = helper.getView(R.id.view_line);
        view_line.setVisibility(View.GONE);
        view.setVisibility(View.GONE);
        TextView bt_zhaoren_gaunzhu = helper.getView(R.id.bt_zhaoren_gaunzhu);
        View view_xian = helper.getView(R.id.view_xian);
        if (item.getIsAttention() == 1){
            bt_zhaoren_gaunzhu.setBackgroundResource(R.drawable.black_di);
            bt_zhaoren_gaunzhu.setText("取消关注");
            bt_zhaoren_gaunzhu.setTextColor(MyApp.context.getResources().getColor(R.color.colorWhite));
        }
        if (MyApp.instance.getInt("id") == item.getUserId()){
            bt_zhaoren_gaunzhu.setVisibility(View.GONE);
        }else{
            bt_zhaoren_gaunzhu.setVisibility(View.VISIBLE);
        }
        helper.setText(R.id.tv_my_fensinum,"粉丝："+String.valueOf(item.getFanCount()));
        helper.setText(R.id.tv_zhaoren_name,item.getNickName());
        helper.setText(R.id.tv_zhaoren_chenghu,item.getMaster().getLevel());
        if (item.getPlace() != null &&!item.getPlace().isEmpty()){
            helper.setText(R.id.tv_zhaoren_weizhi,item.getPlace());
        }else{
            view_xian.setVisibility(View.GONE);
        }
        ImageView img_zhaoren_photo = helper.getView(R.id.img_zhaoren_photo);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(item.getPhoto()).apply(requestOptions).into(img_zhaoren_photo);
    }

    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<ZhaoRenGson.ResultBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<ZhaoRenGson.ResultBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
