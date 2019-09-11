package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.DingDanGuanLi;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class DingDanGuanLiAdapter extends BaseQuickAdapter<DingDanGuanLi.ResultBean,BaseViewHolder> {
    public DingDanGuanLiAdapter(int layoutResId, @Nullable List<DingDanGuanLi.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DingDanGuanLi.ResultBean item) {
        RecyclerView rec_item_dingdan_liebiao = helper.getView(R.id.rec_item_dingdan_liebiao);
        ImageView img_dianpu_logo = helper.getView(R.id.img_dianpu_logo);
        TextView bt_anniu_one = helper.getView(R.id.bt_anniu_one);
        TextView bt_anniu_two = helper.getView(R.id.bt_anniu_two);
        helper.addOnClickListener(R.id.bt_anniu_one);
        helper.addOnClickListener(R.id.bt_anniu_two);
        if (item.getOrderStatus()==1){
            bt_anniu_one.setVisibility(View.GONE);
            bt_anniu_two.setText("确认发货");
        }else if (item.getOrderStatus()==2){
            bt_anniu_one.setVisibility(View.GONE);
            bt_anniu_two.setVisibility(View.GONE);
        }else if (item.getOrderStatus()==3){
            bt_anniu_one.setVisibility(View.GONE);
            bt_anniu_two.setVisibility(View.GONE);
        }else if (item.getOrderStatus()==0){
            bt_anniu_one.setVisibility(View.GONE);
            bt_anniu_two.setText("联系买家");
        }else if (item.getOrderStatus()==-4){
            bt_anniu_one.setText("联系买家");
            bt_anniu_two.setText("删除订单");
        }else if (item.getOrderStatus()==-7){
            bt_anniu_one.setVisibility(View.GONE);
            bt_anniu_two.setText("联系买家");
        }else if (item.getOrderStatus()==-5){
            bt_anniu_one.setVisibility(View.GONE);
            bt_anniu_two.setText("查看详情");
        }else if (item.getOrderStatus()==-1){
            bt_anniu_one.setVisibility(View.GONE);
            bt_anniu_two.setText("查看详情");
        }
        helper.setText(R.id.tv_dingdan_num,"共计："+item.getProductNum()+"件商品");
        helper.setText(R.id.tv_dingdan_price,"合计：¥"+item.getOrderAmountTotal());
//        helper.setText(R.id.tv_dingdan_youfeiprice,"（含运费¥"+item.getLogisticsFee()+"）");
        helper.setText(R.id.tv_dingdan_bianhao,"订单编号："+item.getOrderNo());
        helper.setText(R.id.tv_dianpu_zhuangtai,item.getStatus());
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApp.context);
        rec_item_dingdan_liebiao.setLayoutManager(layoutManager);
        DingDanGuanLiItemAdapter myDingDanAdapter = new DingDanGuanLiItemAdapter(R.layout.item_dingdan_liebiao, item.getMallProducts());
        rec_item_dingdan_liebiao.setAdapter(myDingDanAdapter);
    }
}
