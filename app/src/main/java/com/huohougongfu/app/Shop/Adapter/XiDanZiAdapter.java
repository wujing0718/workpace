package com.huohougongfu.app.Shop.Adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.huohougongfu.app.Gson.ChaTaiGson;
import com.huohougongfu.app.Gson.ShopDingDan;
import com.huohougongfu.app.R;
import com.mcxtzhang.lib.AnimShopButton;
import com.mcxtzhang.lib.IOnAddDelListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.List;


public class XiDanZiAdapter extends BaseAdapter {
    private final Context context;
    private List<ShopDingDan.ResultBean.OrderListBean.MallStoresBean.MallProductsBean> list;
    private TextView tv_total_price;
    private boolean isDikou = true;
    private double total_price,teaRice;
    private View bt_chami_dikou;
    private ImageView img_chami_check;

    public XiDanZiAdapter(Context context, TextView tv_total_price, double teaRice, View bt_chami_dikou, ImageView img_chami_check) {
        this.context = context;
        this.tv_total_price =tv_total_price;
        this.teaRice = teaRice;
        this.bt_chami_dikou = bt_chami_dikou;
        this.img_chami_check = img_chami_check;
    }
//    public XiDanZiAdapter(int layoutResId, @Nullable List<ShopDingDan.ResultBean.OrderListBean.MallStoresBean.MallProductsBean> data) {
//        super(layoutResId, data);
//    }


    public void setData(List<ShopDingDan.ResultBean.OrderListBean.MallStoresBean.MallProductsBean> list) {
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
        XiDanZiAdapter.GroupViewHolder groupViewHolder;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item_dingdan_zi, null);
            groupViewHolder = new XiDanZiAdapter.GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        }else{
            groupViewHolder = (XiDanZiAdapter.GroupViewHolder) convertView.getTag();
        }
        tv_total_price.setText("￥"+list.get(position).getPrice());
        groupViewHolder.tv_dingdan_title.setText(list.get(position).getName());
        groupViewHolder.tv_dingdan_guige.setText(list.get(position).getStandard());
        groupViewHolder.tv_dingdan_price.setText("￥"+list.get(position).getPrice());
        groupViewHolder.amountview.setCount(list.get(position).getNum());
        groupViewHolder.amountview.setOnAddDelListener(new IOnAddDelListener() {
            @Override
            public void onAddSuccess(int i) {
                list.get(position).setNum(i);
                notifyDataSetChanged();
            }

            @Override
            public void onAddFailed(int i, FailType failType) {

            }

            @Override
            public void onDelSuccess(int i) {
                if (i == 0){
                    groupViewHolder.amountview.setCount(0);
                    notifyDataSetChanged();
                }else{
                    list.get(position).setNum(i);
                    notifyDataSetChanged();
                }
            }

            @Override
            public void onDelFaild(int i, FailType failType) {

            }
        });

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (!isDikou){
            //合计的计算
            total_price = 0.00;
            tv_total_price.setText("¥0.00");
//            array = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                ShopDingDan.ResultBean.OrderListBean.MallStoresBean.MallProductsBean mallProductsBean = list.get(i);
//                if (isSelect) {
//                    try {
//                        JSONObject object =new JSONObject();
//                        object.put("id",resultBean.getId());
//                        object.put("concentration",resultBean.getConcentration());
//                        object.put("hasDust",resultBean.getHasDust());
//                        object.put("num",resultBean.getNum());
//                        array.put(object);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                    String num = String.valueOf(mallProductsBean.getNum());
                    String price = String.valueOf(mallProductsBean.getPrice());
                    double dikou  = teaRice*0.01;
                    double v = Double.parseDouble(num);
                    double v1 = Double.parseDouble(price);
                    total_price = total_price + v * v1;
                    if (dikou>=total_price){
                        tv_total_price.setText("¥" + decimalFormat.format(0.00));
                    }else{
                        tv_total_price.setText("¥" + decimalFormat.format(total_price-dikou));
                    }
                }
//            }
        }else{
            //合计的计算
            total_price = 0.00;
            tv_total_price.setText("¥0.00");
//            array = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                ShopDingDan.ResultBean.OrderListBean.MallStoresBean.MallProductsBean mallProductsBean = list.get(i);
//                ChaTaiGson.ResultBean resultBean = list.get(i);
//                boolean isSelect = resultBean.getIsSelect();
////                if (isSelect) {
//                    try {
//                        JSONObject object =new JSONObject();
//                        object.put("id",resultBean.getId());
//                        object.put("concentration",resultBean.getConcentration());
//                        object.put("hasDust",resultBean.getHasDust());
//                        object.put("num",resultBean.getNum());
//                        array.put(object);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                String num = String.valueOf(mallProductsBean.getNum());
                String price = String.valueOf(mallProductsBean.getPrice());
                double v = Double.parseDouble(num);
                double v1 = Double.parseDouble(price);
                total_price = total_price + v * v1;
                tv_total_price.setText("¥" + decimalFormat.format(total_price));
                }
            }

        bt_chami_dikou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler(context.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                        if (isDikou){
                            double chamiprice = teaRice*0.01;
                            if (chamiprice<=total_price){
                                total_price = total_price-chamiprice;
                                tv_total_price.setText("¥" + decimalFormat.format(total_price));
                            }else{
                                tv_total_price.setText("¥" + 0.00);
                            }
                            img_chami_check.setImageResource(R.mipmap.select);
                            isDikou = false;
                        }else{
                            tv_total_price.setText("¥" + decimalFormat.format(total_price));
                            img_chami_check.setImageResource(R.mipmap.unselect);
                            isDikou = true;
                        }
                    }
                });
                notifyDataSetChanged();
            }
        });


        return convertView;
    }

//    @Override
//    protected void convert(BaseViewHolder helper, ShopDingDan.ResultBean.OrderListBean.MallStoresBean.MallProductsBean item) {
//        ImageView img_dingdan_photo = helper.getView(R.id.img_dingdan_photo);
//        AnimShopButton amountview = helper.getView(R.id.amountview);
//        Glide.with(MyApp.context).load(item.getCoverUrl()).into(img_dingdan_photo);
//        helper.setText(R.id.tv_dingdan_title,item.getName());
//        helper.setText(R.id.tv_dingdan_guige,item.getStandard()+"g");
//        helper.setText(R.id.tv_dingdan_price,""+item.getPrice());
//        amountview.setCount(item.getNum());
//    }

    static class GroupViewHolder extends RecyclerView.ViewHolder {
        ImageView img_dingdan_photo;
        TextView tv_dingdan_title,tv_dingdan_guige,tv_dingdan_price;
        AnimShopButton amountview;
        public GroupViewHolder(View convertView) {
            super(convertView);
            img_dingdan_photo = convertView.findViewById(R.id.img_dingdan_photo);
            tv_dingdan_title = convertView.findViewById(R.id.tv_dingdan_title);
            tv_dingdan_guige = convertView.findViewById(R.id.tv_dingdan_guige);
            tv_dingdan_price = convertView.findViewById(R.id.tv_dingdan_price);
            amountview = convertView.findViewById(R.id.amountview);

        }
    }
}
