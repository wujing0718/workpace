package com.huohougongfu.app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ShopDingDan;
import com.huohougongfu.app.Gson.ShoppingCarDataBean;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.XiaDanActivity;
import com.huohougongfu.app.Utils.AmountView;
import com.huohougongfu.app.Utils.Contacts;
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

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * 购物车的adapter
 * 因为使用的是ExpandableListView，所以继承BaseExpandableListAdapter
 */
public class ShoppingCarAdapter extends BaseExpandableListAdapter {

    private final Context context;
    private final LinearLayout llSelectAll;
    private final ImageView ivSelectAll;
    private final Button btnOrder;
    private final Button btnDelete,bt_shoucangjia;
    private final RelativeLayout rlTotalPrice;
    private final TextView tvTotalPrice;
    private List<ShoppingCarDataBean.ResultBean.MallStoresBean> data;
    private boolean isSelectAll = false;
    private double total_price;
    private ShoppingCarDataBean.ResultBean mallStores;

    public ShoppingCarAdapter(Context context, LinearLayout llSelectAll,
                              ImageView ivSelectAll, Button btnOrder, Button btnDelete,
                              RelativeLayout rlTotalPrice, TextView tvTotalPrice,Button bt_shoucangjia) {
        this.context = context;
        this.llSelectAll = llSelectAll;
        this.ivSelectAll = ivSelectAll;
        this.btnOrder = btnOrder;
        this.btnDelete = btnDelete;
        this.rlTotalPrice = rlTotalPrice;
        this.tvTotalPrice = tvTotalPrice;
        this.bt_shoucangjia = bt_shoucangjia;

    }

    public void setData(ShoppingCarDataBean.ResultBean mallStores) {
        this.data = mallStores.getMallStores();
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
            convertView = View.inflate(context, R.layout.item_shopping_car_group, null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        final ShoppingCarDataBean.ResultBean.MallStoresBean datasBean = data.get(groupPosition);
        //店铺ID
        String store_id = String.valueOf(datasBean.getId());
        //店铺名称
        String store_name = datasBean.getStoreName();

        String storeLogo = datasBean.getStoreLogo();
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

        //店铺内的商品都选中的时候，店铺的也要选中
        for (int i = 0; i < datasBean.getMallProducts().size(); i++) {
            ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean goodsBean = datasBean.getMallProducts().get(i);
            boolean isSelect = goodsBean.getIsSelect();
            if (isSelect) {
                datasBean.setIsSelect_shop(true);
            } else {
                datasBean.setIsSelect_shop(false);
                break;
            }
        }

        //因为set之后要重新get，所以这一块代码要放到一起执行
        //店铺是否在购物车中被选中
        final boolean isSelect_shop = datasBean.getIsSelect_shop();

        if (isSelect_shop) {
            groupViewHolder.ivSelect.setImageResource(R.mipmap.select);
        } else {
            groupViewHolder.ivSelect.setImageResource(R.mipmap.unselect);
        }

        //店铺选择框的点击事件
        groupViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datasBean.setIsSelect_shop(!isSelect_shop);

                List<ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean> goods = datasBean.getMallProducts();
                for (int i = 0; i < goods.size(); i++) {
                    ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean goodsBean = goods.get(i);
                    goodsBean.setIsSelect(!isSelect_shop);
                }
                notifyDataSetChanged();
            }
        });

        //当所有的选择框都是选中的时候，全选也要选中
        w:
        for (int i = 0; i < data.size(); i++) {
            List<ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean> goods = data.get(i).getMallProducts();
            for (int y = 0; y < goods.size(); y++) {
                ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean goodsBean = goods.get(y);
                boolean isSelect = goodsBean.getIsSelect();
                if (isSelect) {
                    isSelectAll = true;
                } else {
                    isSelectAll = false;
                    break w;//根据标记，跳出嵌套循环
                }
            }
        }
        if (isSelectAll) {
            ivSelectAll.setBackgroundResource(R.mipmap.select);
        } else {
            ivSelectAll.setBackgroundResource(R.mipmap.unselect);
        }

        //全选的点击事件
        llSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelectAll = !isSelectAll;
                if (isSelectAll) {
                    for (int i = 0; i < data.size(); i++) {
                        List<ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean> goods = data.get(i).getMallProducts();
                        for (int y = 0; y < goods.size(); y++) {
                            ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean goodsBean = goods.get(y);
                            goodsBean.setIsSelect(true);
                        }
                    }
                } else {
                    for (int i = 0; i < data.size(); i++) {
                        List<ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean> goods = data.get(i).getMallProducts();
                        for (int y = 0; y < goods.size(); y++) {
                            ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean goodsBean = goods.get(y);
                            goodsBean.setIsSelect(false);
                        }
                    }
                }
                notifyDataSetChanged();
            }
        });

        //合计的计算
        total_price = 0.0;
        tvTotalPrice.setText("¥0.00");
        for (int i = 0; i < data.size(); i++) {
            List<ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean> goods = data.get(i).getMallProducts();
            for (int y = 0; y < goods.size(); y++) {
                ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean goodsBean = goods.get(y);
                boolean isSelect = goodsBean.getIsSelect();
                if (isSelect) {
                    String num = String.valueOf(goodsBean.getCartProductNum());
                    String price = String.valueOf(goodsBean.getPrice());
                    double v = Double.parseDouble(num);
                    double v1 = Double.parseDouble(price);

                    total_price = total_price + v * v1;

                    //让Double类型完整显示，不用科学计数法显示大写字母E
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    tvTotalPrice.setText("¥" + decimalFormat.format(total_price));
                }
            }
        }

        //去结算的点击事件
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建临时的List，用于存储被选中的商品
                List<ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean> temp = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    List<ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean> goods = data.get(i).getMallProducts();
                    for (int y = 0; y < goods.size(); y++) {
                        ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean goodsBean = goods.get(y);
                        boolean isSelect = goodsBean.getIsSelect();
                        if (isSelect) {
                            temp.add(goodsBean);
                        }
                    }
                }

                if (temp != null && temp.size() > 0) {//如果有被选中的
                    /**
                     * 实际开发中，如果有被选中的商品，
                     * 则跳转到确认订单页面，完成后续订单流程。
                     */

                        JSONArray jsonArray = new JSONArray();
                        for (int i = 0; i < temp.size(); i++) {
                            JSONObject jsonObject = new JSONObject();
                            try {
                                jsonObject.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
                                jsonObject.put("productId",temp.get(i).getId());
                                jsonObject.put("productNum",temp.get(i).getCartProductNum());
                                jsonObject.put("cartId",temp.get(i).getCartId());
                                jsonObject.put("standard",temp.get(i).getStandard());
                                jsonObject.put("standardId",temp.get(i).getStandardId());
                                jsonObject.put("storeId",store_id);
                                jsonArray.put(jsonObject);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        initXiaDan(jsonArray);
                } else {
                    ToastUtils.showShort("请选择要购买的商品");
                }
            }
        });

        //删除的点击事件
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 实际开发中，通过回调请求后台接口实现删除操作
                 */
                if (mDeleteListener != null) {
                    mDeleteListener.onDelete();
                }
            }
        });
        //收藏的点击事件
        bt_shoucangjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 实际开发中，通过回调请求后台接口实现删除操作
                 */
                if (mCollectionListener!= null) {
                    mCollectionListener.onCollection();
                }
            }
        });
        return convertView;
    }

    private void initXiaDan(JSONArray jsonObject) {
        OkGo.<String>post(Contacts.URl1+"confirmOrder1")
                .params("json",jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ShopDingDan shopDingDan = gson.fromJson(body, ShopDingDan.class);
                        if (shopDingDan.getStatus() == 1){
                            Intent intent = new Intent();
                            intent.putExtra("订单详情",(Serializable) shopDingDan.getResult());
                            intent.setClass(context,XiaDanActivity.class);
                            context.startActivity(intent);
                        }
                    }
                });
    }


    static class GroupViewHolder {
        ImageView ivSelect,img_dianp_logo;
        TextView tvStoreName;
        LinearLayout ll;

        GroupViewHolder(View view) {
            ivSelect = view.findViewById(R.id.iv_select);
            tvStoreName = view.findViewById(R.id.tv_store_name);
            img_dianp_logo = view.findViewById(R.id.img_dianpu_logo);
            ll = view.findViewById(R.id.ll);
        }
    }

    //------------------------------------------------------------------------------------------------
    @Override
    public int getChildrenCount(int groupPosition) {
        if (data.get(groupPosition).getMallProducts() != null && data.get(groupPosition).getMallProducts().size() > 0) {
            return data.get(groupPosition).getMallProducts().size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).getMallProducts().get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_shopping_car_child, null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        ShoppingCarDataBean.ResultBean.MallStoresBean mallStoresBean = data.get(groupPosition);
        //店铺ID
        String store_id = String.valueOf(mallStoresBean.getId());
        //店铺名称
        String store_name = mallStoresBean.getStoreName();
        //店铺是否在购物车中被选中
        final boolean isSelect_shop = mallStoresBean.getIsSelect_shop();
        ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean goodsBean = mallStoresBean.getMallProducts().get(childPosition);
        //商品图片
        String goods_image = goodsBean.getCoverUrl();
        //商品ID
        final String goods_id = String.valueOf(goodsBean.getId());
        //商品名称
        String goods_name = goodsBean.getName();
        //商品价格
        String goods_price = String.valueOf(goodsBean.getPrice());
        //商品数量
        String goods_num = String.valueOf(goodsBean.getCartProductNum());
        //商品是否被选中
        final boolean isSelect = goodsBean.getIsSelect();
        String standard = goodsBean.getStandard();
        Glide.with(context)
                .load(goods_image)
                .into(childViewHolder.ivPhoto);
        if (goods_name != null) {
            childViewHolder.tvName.setText(goods_name);
        } else {
            childViewHolder.tvName.setText("");
        }

        if (standard != null) {
            childViewHolder.tv_standard.setText(standard);
        } else {
            childViewHolder.tv_standard.setText("");
        }

        if (goods_price != null) {
            childViewHolder.tvPriceValue.setText(goods_price);
        } else {
            childViewHolder.tvPriceValue.setText("");
        }
        if (goods_num != null) {
            childViewHolder.amountview.setCount(goodsBean.getCartProductNum());
            childViewHolder.amountview.setMaxCount(99999);
//            childViewHolder.amountview.setMaxCount(goodsBean.getStock());
        } else {
        }

        //商品是否被选中
        if (isSelect) {
            childViewHolder.ivSelect.setImageResource(R.mipmap.select);
        } else {
            childViewHolder.ivSelect.setImageResource(R.mipmap.unselect);
        }

        //商品选择框的点击事件
        childViewHolder.ivSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodsBean.setIsSelect(!isSelect);
                if (!isSelect == false) {
                    mallStoresBean.setIsSelect_shop(false);
                }
                notifyDataSetChanged();
            }
        });
        childViewHolder.amountview.setOnAddDelListener(new IOnAddDelListener() {
            @Override
            public void onAddSuccess(int i) {
                goodsBean.setCartProductNum(i);
                goodsBean.setIsSelect(true);
                notifyDataSetChanged();
            }

            @Override
            public void onAddFailed(int i, FailType failType) {

            }

            @Override
            public void onDelSuccess(int i) {
                if (i == 0){
                    mallStoresBean.setIsSelect_shop(false);
                    goodsBean.setIsSelect(false);
                    childViewHolder.amountview.setCount(0);
                    notifyDataSetChanged();
                }else{
                    goodsBean.setCartProductNum(i);
                    goodsBean.setIsSelect(true);
                    notifyDataSetChanged();
                }
            }

            @Override
            public void onDelFaild(int i, FailType failType) {

            }
        });

        if (childPosition == data.get(groupPosition).getMallProducts().size() - 1) {
//            childViewHolder.view1.setVisibility(View.GONE);
            childViewHolder.viewLast.setVisibility(View.VISIBLE);
        } else {
//            childViewHolder.view1.setVisibility(View.VISIBLE);
            childViewHolder.viewLast.setVisibility(View.GONE);
        }

        return convertView;
    }

    static class ChildViewHolder {
        ImageView ivSelect;
        ImageView ivPhoto;
        TextView tvName;
        TextView tvPriceKey,tv_standard;
        TextView tvPriceValue;
        ImageView ivEditAdd;
//        View view1;
        View viewLast;
        AnimShopButton amountview;

        ChildViewHolder(View view) {
            ivSelect = view.findViewById(R.id.iv_select);
            ivPhoto = view.findViewById(R.id.iv_photo);
            tvName = view.findViewById(R.id.tv_name);
            tvPriceKey = view.findViewById(R.id.tv_price_key);
            tvPriceValue = view.findViewById(R.id.tv_price_value);
//            view1 = view.findViewById(R.id.view);
            viewLast = view.findViewById(R.id.view_last);
            amountview = view.findViewById(R.id.amountview);
            tv_standard = view.findViewById(R.id.tv_standard);

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

    public void setOnDeleteListener(OnDeleteListener listener) {
        mDeleteListener = listener;
    }

    private OnDeleteListener mDeleteListener;
    //收藏夹的回调
    public interface OnCollectionListener {
        void onCollection();
    }

    public void setOnCollectionListener(OnCollectionListener listener) {
        mCollectionListener = listener;
    }

    private OnCollectionListener mCollectionListener;

    //修改商品数量的回调
    public interface OnChangeCountListener {
        void onChangeCount(String goods_id);
    }

    public void setOnChangeCountListener(OnChangeCountListener listener) {
        mChangeCountListener = listener;
    }

    private OnChangeCountListener mChangeCountListener;
}
