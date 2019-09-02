package com.huohougongfu.app.WoDe.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyDingDan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class MyDingDanAdapter extends BaseQuickAdapter<MyDingDan.ResultBean.ListBean,BaseViewHolder> {
    public MyDingDanAdapter(int layoutResId, @Nullable List<MyDingDan.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void convert(BaseViewHolder helper, MyDingDan.ResultBean.ListBean item) {
        RecyclerView rec_item_dingdan_liebiao = helper.getView(R.id.rec_item_dingdan_liebiao);
        ImageView img_dianpu_logo = helper.getView(R.id.img_dianpu_logo);
        TextView bt_anniu_one = helper.getView(R.id.bt_anniu_one);
        TextView bt_anniu_two = helper.getView(R.id.bt_anniu_two);
        helper.addOnClickListener(R.id.bt_anniu_one);
        helper.addOnClickListener(R.id.bt_anniu_two);
        if (item.getOrderStatus()==1){
            bt_anniu_one.setText("取消订单");
            bt_anniu_two.setText("提醒发货");
        }else if (item.getOrderStatus()==2){
            bt_anniu_one.setText("查看物流");
            bt_anniu_two.setText("确认收货");
        }else if (item.getOrderStatus()==3){
            bt_anniu_one.setText("查看物流");
            bt_anniu_two.setText("评价");
        }else if (item.getOrderStatus()==0){
            bt_anniu_one.setText("取消订单");
            bt_anniu_two.setText("确认付款");
        }else if (item.getOrderStatus()==-4){
            bt_anniu_one.setVisibility(View.GONE);
            bt_anniu_two.setText("删除订单");
        }
        helper.setText(R.id.tv_dingdan_num,"共计："+item.getProductTotalNum()+"件商品");
        helper.setText(R.id.tv_dingdan_price,"合计：¥"+item.getOrderAmountTotal());
        helper.setText(R.id.tv_dianpu_name,item.getMallStores().getStoreName());
        helper.setText(R.id.tv_dianpu_zhuangtai,item.getStatus());
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(item.getMallStores().getStoreLogo()).apply(requestOptions).into(img_dianpu_logo);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MyApp.context);
        rec_item_dingdan_liebiao.setLayoutManager(layoutManager);
        rec_item_dingdan_liebiao.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return helper.itemView.onTouchEvent(event);
            }
        });
        DingDanItemAdapter myDingDanAdapter = new DingDanItemAdapter(R.layout.item_dingdan_liebiao, item.getMallStores().getMallProducts());
//        myDingDanAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Intent intent = new Intent();
//                intent.putExtra("orderNo",item.getOrderNo());
//                intent.putExtra("orderStatus",item.getOrderStatus());
//                intent.setClass(MyApp.context,DingDanDetailActivity.class);
//            }
//        });
        rec_item_dingdan_liebiao.setAdapter(myDingDanAdapter);

    }
}
