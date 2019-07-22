package com.huohougongfu.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ChaTaiGson;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.ShoppingCarDataBean;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.XiaDanActivity;
import com.huohougongfu.app.Utils.AmountView;
import com.huohougongfu.app.Utils.SmoothCheckBox;
import com.mcxtzhang.lib.AnimShopButton;
import com.mcxtzhang.lib.IOnAddDelListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

public class ChaTaiAdapter extends BaseAdapter {

    private  int item_shouye_chataione;
    private  View bt_checkbox;
    private  Button btn_go_to_pay;
    private  List<ChaTaiGson.ResultBean> list = new ArrayList<>();
    private Context context;
    private boolean isSelectAll = false;
    private ImageView ivSelectAll;
    private double total_price;
    private TextView tv_total_price;



    public ChaTaiAdapter(int item_shouye_chataione, View bt_checkbox, Button btn_go_to_pay,
                         List<ChaTaiGson.ResultBean> list, Context context, ImageView img_check, TextView tv_total_price) {
        this.item_shouye_chataione = item_shouye_chataione;
        this.bt_checkbox = bt_checkbox;
        this.btn_go_to_pay = btn_go_to_pay;
        this.context = context;
        this.ivSelectAll = img_check;
        this.tv_total_price =tv_total_price;

    }

    /**
     * 自定义设置数据方法；
     * 通过notifyDataSetChanged()刷新数据，可保持当前位置
     *
     * @param list 需要刷新的数据
     */
    public void setData(List<ChaTaiGson.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (list != null && list.size() > 0) {
            return list.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item_shouye_chataione, null);
            groupViewHolder = new ChaTaiAdapter.GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        }else{
            groupViewHolder = (ChaTaiAdapter.GroupViewHolder) convertView.getTag();
        }
        if (isSelectAll) {
            ivSelectAll.setBackgroundResource(R.mipmap.select);
        } else {
            ivSelectAll.setBackgroundResource(R.mipmap.unselect);
        }
        groupViewHolder.tv_chatai_title.setText(list.get(position).getTea().getTeaName());
        groupViewHolder.tv_chatai_price.setText("¥"+list.get(position).getTea().getPrice());
        if (list.get(position).getHasDust()==1){
            groupViewHolder.tv_chatai_hasDust.setText("有茶底");
        }else{
            groupViewHolder.tv_chatai_hasDust.setText("无茶底");
        }
        groupViewHolder.tv_chatai_concentration.setText(list.get(position).getConcentration());
        Glide.with(context).load(list.get(position).getTea().getPicture()).into(groupViewHolder.img_chatai_photo);
        groupViewHolder.amountview.setCount(list.get(position).getNum());
//        groupViewHolder.amountview.setMaxCount(list.get(position).getStock());
        groupViewHolder.amountview.setOnAddDelListener(new IOnAddDelListener() {
            @Override
            public void onAddSuccess(int i) {
                list.get(position).setNum(i);
                list.get(position).setIsSelect(true);
                notifyDataSetChanged();
            }

            @Override
            public void onAddFailed(int i, FailType failType) {

            }

            @Override
            public void onDelSuccess(int i) {
                if (i == 0){
                    list.get(position).setIsSelect(false);
                    groupViewHolder.amountview.setCount(0);
                    notifyDataSetChanged();
                }else{
                    list.get(position).setNum(i);
                    list.get(position).setIsSelect(true);
                    notifyDataSetChanged();
                }
            }

            @Override
            public void onDelFaild(int i, FailType failType) {

            }
        });

        boolean isSelect1 = list.get(position).getIsSelect();
        ChaTaiGson.ResultBean resultBean1 = list.get(position);
        //商品是否被选中
        if (isSelect1) {
            groupViewHolder.img_check.setImageResource(R.mipmap.select);
        } else {
            groupViewHolder.img_check.setImageResource(R.mipmap.unselect);
        }
        //当所有的选择框都是选中的时候，全选也要选中
        w:
        for (int i = 0; i < list.size(); i++) {
            boolean isSelect = list.get(i).getIsSelect();
            if (isSelect) {
                isSelectAll = true;
            } else {
                isSelectAll = false;
                break w;//根据标记，跳出嵌套循环
            }
        }
        //全选的点击事件
        bt_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelectAll = !isSelectAll;
                if (isSelectAll) {
                    for (int i = 0; i < list.size(); i++) {
                        ChaTaiGson.ResultBean goodsBean = list.get(i);
                        goodsBean.setIsSelect(true);
                    }
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        ChaTaiGson.ResultBean resultBean = list.get(i);
                        resultBean.setIsSelect(false);
                    }
                }
                notifyDataSetChanged();
            }
        });

        //合计的计算
        total_price = 0.0;
        tv_total_price.setText("¥0.00");
        for (int i = 0; i < list.size(); i++) {
            ChaTaiGson.ResultBean resultBean = list.get(i);
            boolean isSelect = resultBean.getIsSelect();
            if (isSelect) {
                String num = String.valueOf(resultBean.getNum());
                String price = String.valueOf(resultBean.getTea().getPrice());
                double v = Double.parseDouble(num);
                double v1 = Double.parseDouble(price);
                total_price = total_price + v * v1;

                //让Double类型完整显示，不用科学计数法显示大写字母E
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                tv_total_price.setText("¥" + decimalFormat.format(total_price));
            }
        }

        //商品选择框的点击事件
        groupViewHolder.bt_chatai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBean1.setIsSelect(!isSelect1);
                if (!isSelect1 == false) {
                    resultBean1.setIsSelect(false);
                }
                notifyDataSetChanged();
            }
        });

        //去结算的点击事件
        btn_go_to_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建临时的List，用于存储被选中的商品
                List<ChaTaiGson.ResultBean> temp = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    ChaTaiGson.ResultBean goodsBean = list.get(i);
                    boolean isSelect = goodsBean.getIsSelect();
                    if (isSelect) {
                        temp.add(goodsBean);
                    }
                }
                if (temp != null && temp.size() > 0) {//如果有被选中的
                    /**
                     * 实际开发中，如果有被选中的商品，
                     * 则跳转到确认订单页面，完成后续订单流程。
                     */
                    LogUtils.e(temp.get(0).getTea().getTeaName());
                    Intent intent = new Intent();
                    intent.setClass(context,XiaDanActivity.class);
                    startActivity(intent);
                } else {
                    ToastUtils.showShort("请选择要购买的商品");
                }
            }
        });
        return convertView;
    }

    static class GroupViewHolder extends RecyclerView.ViewHolder {
        ImageView img_check,img_chatai_photo;
        View bt_chatai;
        TextView tv_chatai_title,tv_chatai_hasDust,tv_chatai_price,tv_chatai_concentration;
        AnimShopButton amountview;
        public GroupViewHolder(View convertView) {
            super(convertView);
            img_check = convertView.findViewById(R.id.img_check);
            img_chatai_photo = convertView.findViewById(R.id.img_chatai_photo);
            bt_chatai = convertView.findViewById(R.id.bt_chatai);
            tv_chatai_title = convertView.findViewById(R.id.tv_chatai_title);
            tv_chatai_price = convertView.findViewById(R.id.tv_chatai_price);
            tv_chatai_hasDust = convertView.findViewById(R.id.tv_chatai_hasDust);
            tv_chatai_concentration = convertView.findViewById(R.id.tv_chatai_concentration);
            amountview = convertView.findViewById(R.id.amountview);

        }
    }
}