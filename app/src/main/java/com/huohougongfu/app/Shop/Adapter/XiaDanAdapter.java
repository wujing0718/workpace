package com.huohougongfu.app.Shop.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ChaTaiAdapter;
import com.huohougongfu.app.Adapter.ShoppingCarAdapter;
import com.huohougongfu.app.Gson.ChaTaiGson;
import com.huohougongfu.app.Gson.ShopDingDan;
import com.huohougongfu.app.Gson.ShoppingCarDataBean;
import com.huohougongfu.app.Gson.TiJiaoDingDan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.ChaTaiZhiFu;
import com.huohougongfu.app.PopupView.ShopZhiFu;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.XiaDanActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.View.ChildLiistView;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.mcxtzhang.lib.AnimShopButton;
import com.mcxtzhang.lib.IOnAddDelListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class XiaDanAdapter extends BaseExpandableListAdapter {

    private ImageView img_dianpu_logo;
    private ShopDingDan.ResultBean  list;
    private View bt_chami_dikou;
    private Button btn_go_to_pay;
    private Context context;
    private boolean isDikou = true;
    private TextView tv_chami_dikou,tvTotalPrice;
    private ImageView img_chami_check;
    private double total_price;
    private double teaRice;
    private JSONArray array;
    private boolean isSelectAll = false;
    private  int transId ;
    private List<ShopDingDan.ResultBean.OrderListBean> data;

    public XiaDanAdapter(Context context, View bt_chami_dikou, Button btn_go_to_pay, TextView tv_chami_dikou,
                         ImageView img_chami_check, TextView tv_total_price, double teaRice) {
        this.bt_chami_dikou =bt_chami_dikou;
        this.btn_go_to_pay = btn_go_to_pay;
        this.context = context;
        this.tv_chami_dikou = tv_chami_dikou;
        this.img_chami_check = img_chami_check;
        this.tvTotalPrice = tv_total_price;
        this.teaRice = teaRice;
    }

    /**
     * 自定义设置数据方法；
     * 通过notifyDataSetChanged()刷新数据，可保持当前位置
     *
     * @param list 需要刷新的数据
     * @param transId
     */
    public void setData(ShopDingDan.ResultBean list, int transId) {
        data = list.getOrderList();
        this.list = list;
        this.transId = transId;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        if (data != null && data.size() > 0) {
            return data.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_dingdan_dianpu_tab, null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        ShopDingDan.ResultBean.OrderListBean mallStoresBean = data.get(groupPosition);
        //店铺ID
        String store_id = String.valueOf(mallStoresBean.getMallStore().getId());
        //店铺名称
        String store_name = mallStoresBean.getMallStore().getStoreName();

        String storeLogo = mallStoresBean.getMallStore().getStoreLogo();
        if (store_name != null) {
            groupViewHolder.tvStoreName.setText(store_name);
        } else {
            groupViewHolder.tvStoreName.setText("");
        }
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        if (storeLogo != null) {
            Glide.with(context).load(storeLogo).apply(requestOptions).into(groupViewHolder.img_dianp_logo);
        } else {
            Glide.with(context).load(R.mipmap.img_wode2).apply(requestOptions).into(groupViewHolder.img_dianp_logo);
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (!isDikou){
            //合计的计算
            total_price = 0.00;
            tvTotalPrice.setText("¥0.00");
            array = new JSONArray();
            for (int i = 0; i < data.size(); i++) {
                List<ShopDingDan.ResultBean.OrderListBean.MallStoreBean.MallProductsBean> mallProducts = data.get(i).getMallStore().getMallProducts();
                for (int y = 0; y < mallProducts.size(); y++) {
                    ShopDingDan.ResultBean.OrderListBean.MallStoreBean.MallProductsBean mallProductsBean = mallProducts.get(y);
                        String num = String.valueOf(mallProductsBean.getNum());
                        String price = String.valueOf(mallProductsBean.getPrice());
                    double dikou  = teaRice*0.01;
                    double v = Double.parseDouble(num);
                    double v1 = Double.parseDouble(price);
                    total_price = total_price + v * v1;
                    if (dikou>=total_price){
                        tvTotalPrice.setText("¥" + decimalFormat.format(0.00));
                    }else{
                        tvTotalPrice.setText("¥" + decimalFormat.format(total_price-dikou));
                    }
                }
            }
        }else{
            //合计的计算
            total_price = 0.00;
            tvTotalPrice.setText("¥0.00");
            array = new JSONArray();
            for (int i = 0; i < data.size(); i++) {
                List<ShopDingDan.ResultBean.OrderListBean.MallStoreBean.MallProductsBean> mallProducts = data.get(i).getMallStore().getMallProducts();
                for (int y = 0; y < mallProducts.size(); y++) {
                    ShopDingDan.ResultBean.OrderListBean.MallStoreBean.MallProductsBean mallProductsBean = mallProducts.get(y);
                    String num = String.valueOf(mallProductsBean.getNum());
                    String price = String.valueOf(mallProductsBean.getPrice());
                    double v = Double.parseDouble(num);
                    double v1 = Double.parseDouble(price);
                    total_price = total_price + v * v1;
                    tvTotalPrice.setText("¥" + decimalFormat.format(total_price));
                }
            }
        }

        bt_chami_dikou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                        if (isDikou){
                            double chamiprice = teaRice*0.01;
                            if (chamiprice<=total_price){
                                total_price = total_price-chamiprice;
                                tvTotalPrice.setText("¥" + decimalFormat.format(total_price));
                            }else{
                                tvTotalPrice.setText("¥" + 0.00);
                            }
                            img_chami_check.setImageResource(R.mipmap.select);
                            isDikou = false;
                        }else{
                            img_chami_check.setImageResource(R.mipmap.unselect);
                            isDikou = true;
                        }
                notifyDataSetChanged();
            }
        });

        //去结算的点击事件
        btn_go_to_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建临时的List，用于存储被选中的商品
                List<ShopDingDan.ResultBean.OrderListBean.MallStoreBean.MallProductsBean> temp = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    List<ShopDingDan.ResultBean.OrderListBean.MallStoreBean.MallProductsBean> mallProducts = data.get(i).getMallStore().getMallProducts();
                    for (int y = 0; y < mallProducts.size(); y++) {
                        ShopDingDan.ResultBean.OrderListBean.MallStoreBean.MallProductsBean mallProductsBean = mallProducts.get(y);
                        temp.add(mallProductsBean);
                    }
                }

                if (temp != null && temp.size() > 0) {//如果有被选中的
                    /**
                     * 实际开发中，如果有被选中的商品，
                     * 则跳转到确认订单页面，完成后续订单流程。
                     */
//                    LogUtils.e(temp.get(0).getName());
                    JSONArray jsonArray = new JSONArray();
                    JSONObject jsonObject = new JSONObject();
                    try {
                        for (int i = 0; i < temp.size(); i++) {
                            jsonObject.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
                            jsonObject.put("orderId",list.getOrderList().get(0).getOrderId());
                            jsonObject.put("productId",temp.get(i).getId());

                            jsonObject.put("storeId",temp.get(i).getStoreId());
                            jsonObject.put("addressId",String.valueOf(list.getDefaultAddress().getId()));
                            jsonObject.put("standard",temp.get(i).getStandard());
                            jsonObject.put("standardId",temp.get(i).getStandardId());
                            jsonObject.put("buynum",temp.get(i).getNum());
                            if(!isDikou){
                                jsonObject.put("teaRice","1");
                            }else{
                                jsonObject.put("teaRice","0");
                            }
                            if (transId == 0){
                                if (temp.get(i).getTransportTemplate()!=null){
                                    jsonObject.put("transId",temp.get(i).getTransportTemplate().getId());
                                }
                            }else{
                                jsonObject.put("transId",transId);
                            }
                            jsonArray.put(jsonObject);
                        }
                        initXiaDan(jsonArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    ToastUtils.showShort("请选择要购买的商品");
                }
            }
        });

        return convertView;
    }

    private void initXiaDan(JSONArray jsonObject) {
        OkGo.<String>post(Contacts.URl1+"submitOrder")
                .params("json",jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        TiJiaoDingDan shopDingDan = gson.fromJson(body, TiJiaoDingDan.class);
                        if (shopDingDan.getStatus() == 1){
                            new XPopup.Builder(context)
                                    .asCustom(new ShopZhiFu(context,shopDingDan.getResult(), total_price))
                                    .show();
//                            Intent intent = new Intent();
//                            intent.putExtra("订单详情",(Serializable) shopDingDan.getResult());
//                            intent.setClass(context,XiaDanActivity.class);
//                            context.startActivity(intent);
                        }
                    }
                });
    }


    static class GroupViewHolder {
        ImageView img_dianp_logo;
        TextView tvStoreName;
        LinearLayout ll;

        GroupViewHolder(View view) {
            img_dianp_logo = view.findViewById(R.id.img_dianpu_logo);
            tvStoreName = view.findViewById(R.id.tv_dianpu_name);
        }
    }

    //------------------------------------------------------------------------------------------------
    @Override
    public int getChildrenCount(int groupPosition) {
        if (data.get(groupPosition).getMallStore().getMallProducts() != null && data.get(groupPosition).getMallStore().getMallProducts().size() > 0) {
            return data.get(groupPosition).getMallStore().getMallProducts().size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).getMallStore().getMallProducts().get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_dingdan_zi, null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        ShopDingDan.ResultBean.OrderListBean.MallStoreBean.MallProductsBean mallProductsBean1 = data.get(groupPosition).getMallStore().getMallProducts().get(childPosition);
        childViewHolder.tv_dingdan_title.setText(mallProductsBean1.getName());
        childViewHolder.tv_dingdan_guige.setText(mallProductsBean1.getStandard());
        childViewHolder.tv_dingdan_price.setText(String.valueOf(mallProductsBean1.getPrice()));
        childViewHolder.amountview.setCount(mallProductsBean1.getNum());
        Glide.with(context).load(mallProductsBean1.getCoverUrl()).into(childViewHolder.img_dingdan_photo);
        childViewHolder.amountview.setOnAddDelListener(new IOnAddDelListener() {
            @Override
            public void onAddSuccess(int i) {
                mallProductsBean1.setNum(i);
                notifyDataSetChanged();
            }

            @Override
            public void onAddFailed(int i, FailType failType) {

            }

            @Override
            public void onDelSuccess(int i) {
                if (i == 0){
                    childViewHolder.amountview.setCount(0);
                    notifyDataSetChanged();
                }else{
                    mallProductsBean1.setNum(i);
                    notifyDataSetChanged();
                }
            }

            @Override
            public void onDelFaild(int i, FailType failType) {

            }
        });
        return convertView;
    }

    static class ChildViewHolder {
        ImageView img_dingdan_photo;
        ImageView ivPhoto;
        TextView tv_dingdan_title;
        TextView tv_dingdan_guige,tv_dingdan_price;
        TextView tvPriceValue;
        ImageView ivEditAdd;
        View view1;
        View viewLast;
        AnimShopButton amountview;

        ChildViewHolder(View view) {
            tv_dingdan_title = view.findViewById(R.id.tv_dingdan_title);
            tv_dingdan_guige = view.findViewById(R.id.tv_dingdan_guige);
            tv_dingdan_price = view.findViewById(R.id.tv_dingdan_price);
            img_dingdan_photo = view.findViewById(R.id.img_dingdan_photo);
            amountview =  view.findViewById(R.id.amountview);
        }
    }

    //-----------------------------------------------------------------------------------------------

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //删除的回调
    public interface OnDeleteListener {
        void onDelete();
    }

    public void setOnDeleteListener(ShoppingCarAdapter.OnDeleteListener listener) {
        mDeleteListener = listener;
    }

    private ShoppingCarAdapter.OnDeleteListener mDeleteListener;
    //收藏夹的回调
    public interface OnCollectionListener {
        void onCollection();
    }

    public void setOnCollectionListener(ShoppingCarAdapter.OnCollectionListener listener) {
        mCollectionListener = listener;
    }

    private ShoppingCarAdapter.OnCollectionListener mCollectionListener;

    //修改商品数量的回调
    public interface OnChangeCountListener {
        void onChangeCount(String goods_id);
    }

    public void setOnChangeCountListener(ShoppingCarAdapter.OnChangeCountListener listener) {
        mChangeCountListener = listener;
    }

    private ShoppingCarAdapter.OnChangeCountListener mChangeCountListener;
}
