package com.huohougongfu.app.Shop.Adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.ShopGson;
import com.huohougongfu.app.Gson.TeYuePingPai;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;

import java.util.List;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

public class PinPaiAdapter extends BaseQuickAdapter<TeYuePingPai.ResultBean.ResultListBean.ListBean,BaseViewHolder> {
    private  List<TeYuePingPai.ResultBean.ResultListBean.ListBean> data1;

    public PinPaiAdapter(int layoutResId, @Nullable List<TeYuePingPai.ResultBean.ResultListBean.ListBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, TeYuePingPai.ResultBean.ResultListBean.ListBean item) {
        ImageView img_quanbu_logo = helper.getView(R.id.img_quanbu_logo);
        TextView bt_pinpai_guanzhu = helper.getView(R.id.bt_pinpai_guanzhu);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(item.getImg()).apply(requestOptions).into(img_quanbu_logo);
        helper.setText(R.id.tv_quanbu_name,item.getName());
        helper.setText(R.id.tv_quanbu_jianjie,item.getStory());
        helper.addOnClickListener(R.id.bt_pinpai_guanzhu);
        if (item.getIsCollection() ==1){
            bt_pinpai_guanzhu.setBackgroundResource(R.drawable.yiguanzhu);
            bt_pinpai_guanzhu.setText("已关注");
        }else{
            bt_pinpai_guanzhu.setBackgroundResource(R.drawable.guanzhu);
            bt_pinpai_guanzhu.setText("+关注");
        }
        RecyclerView rec_pinpai_shangpin = helper.getView(R.id.rec_pinpai_shangpin);
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(MyApp.getInstances(),3);
        //设置RecyclerView 布局
        rec_pinpai_shangpin.setLayoutManager(layoutmanager);
        int firstVisibleItemPosition = layoutmanager.findFirstVisibleItemPosition()+1;
        PinPaiItemAdapter shangPinTuiJianAdapter = new PinPaiItemAdapter(MyApp.getInstances(),data1.get(firstVisibleItemPosition).getProductList());
        rec_pinpai_shangpin.setAdapter(shangPinTuiJianAdapter);
        shangPinTuiJianAdapter.setOnItemClickListener(new PinPaiItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int pos) {
                Intent intent = new Intent();
                intent.putExtra("id",item.getProductList().get(pos).getId());
                intent.setClass(MyApp.context,ShangPinDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
    }
    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<TeYuePingPai.ResultBean.ResultListBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<TeYuePingPai.ResultBean.ResultListBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
