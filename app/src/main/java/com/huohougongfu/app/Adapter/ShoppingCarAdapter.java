package com.huohougongfu.app.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.huohougongfu.app.Gson.ShoppingCarDataBean;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.AmountView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 购物车的adapter
 * 因为使用的是ExpandableListView，所以继承BaseExpandableListAdapter
 */
public class ShoppingCarAdapter extends BaseExpandableListAdapter {

    private final Context context;
    private final LinearLayout llSelectAll;
    private final ImageView ivSelectAll;
    private final Button btnOrder;
    private final Button btnDelete;
    private final RelativeLayout rlTotalPrice;
    private final TextView tvTotalPrice;
    private List<ShoppingCarDataBean.ResultBean> data;
    private boolean isSelectAll = false;
    private double total_price;

    public ShoppingCarAdapter(Context context, LinearLayout llSelectAll,
                              ImageView ivSelectAll, Button btnOrder, Button btnDelete,
                              RelativeLayout rlTotalPrice, TextView tvTotalPrice) {
        this.context = context;
        this.llSelectAll = llSelectAll;
        this.ivSelectAll = ivSelectAll;
        this.btnOrder = btnOrder;
        this.btnDelete = btnDelete;
        this.rlTotalPrice = rlTotalPrice;
        this.tvTotalPrice = tvTotalPrice;
    }

    /**
     * 自定义设置数据方法；
     * 通过notifyDataSetChanged()刷新数据，可保持当前位置
     *
     * @param data 需要刷新的数据
     */
    public void setData(List<ShoppingCarDataBean.ResultBean> data) {
        this.data = data;
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
        final ShoppingCarDataBean.ResultBean datasBean = data.get(groupPosition);
        //店铺ID
        String store_id = String.valueOf(datasBean.getId());
        //店铺名称
        String store_name = datasBean.getStoreName();

        if (store_name != null) {
            groupViewHolder.tvStoreName.setText(store_name);
        } else {
            groupViewHolder.tvStoreName.setText("");
        }

        //店铺内的商品都选中的时候，店铺的也要选中
        for (int i = 0; i < datasBean.getProducts().size(); i++) {
            ShoppingCarDataBean.ResultBean.ProductsBean goodsBean = datasBean.getProducts().get(i);
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

                List<ShoppingCarDataBean.ResultBean.ProductsBean> goods = datasBean.getProducts();
                for (int i = 0; i < goods.size(); i++) {
                    ShoppingCarDataBean.ResultBean.ProductsBean goodsBean = goods.get(i);
                    goodsBean.setIsSelect(!isSelect_shop);
                }
                notifyDataSetChanged();
            }
        });

        //当所有的选择框都是选中的时候，全选也要选中
        w:
        for (int i = 0; i < data.size(); i++) {
            List<ShoppingCarDataBean.ResultBean.ProductsBean> goods = data.get(i).getProducts();
            for (int y = 0; y < goods.size(); y++) {
                ShoppingCarDataBean.ResultBean.ProductsBean goodsBean = goods.get(y);
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
                        List<ShoppingCarDataBean.ResultBean.ProductsBean> goods = data.get(i).getProducts();
                        for (int y = 0; y < goods.size(); y++) {
                            ShoppingCarDataBean.ResultBean.ProductsBean goodsBean = goods.get(y);
                            goodsBean.setIsSelect(true);
                        }
                    }
                } else {
                    for (int i = 0; i < data.size(); i++) {
                        List<ShoppingCarDataBean.ResultBean.ProductsBean> goods = data.get(i).getProducts();
                        for (int y = 0; y < goods.size(); y++) {
                            ShoppingCarDataBean.ResultBean.ProductsBean goodsBean = goods.get(y);
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
            List<ShoppingCarDataBean.ResultBean.ProductsBean> goods = data.get(i).getProducts();
            for (int y = 0; y < goods.size(); y++) {
                ShoppingCarDataBean.ResultBean.ProductsBean goodsBean = goods.get(y);
                boolean isSelect = goodsBean.getIsSelect();
                if (isSelect) {
                    String num = String.valueOf(goodsBean.getProductNum());
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
                List<ShoppingCarDataBean.ResultBean.ProductsBean> temp = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    List<ShoppingCarDataBean.ResultBean.ProductsBean> goods = data.get(i).getProducts();
                    for (int y = 0; y < goods.size(); y++) {
                        ShoppingCarDataBean.ResultBean.ProductsBean goodsBean = goods.get(y);
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
                    ToastUtils.showShort("跳转到确认订单页面，完成后续订单流程");
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

        return convertView;
    }

    static class GroupViewHolder {
        ImageView ivSelect;
        TextView tvStoreName;
        LinearLayout ll;

        GroupViewHolder(View view) {
            ivSelect = view.findViewById(R.id.iv_select);
            tvStoreName = view.findViewById(R.id.tv_store_name);
            ll = view.findViewById(R.id.ll);
        }
    }

    //------------------------------------------------------------------------------------------------
    @Override
    public int getChildrenCount(int groupPosition) {
        if (data.get(groupPosition).getProducts() != null && data.get(groupPosition).getProducts().size() > 0) {
            return data.get(groupPosition).getProducts().size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).getProducts().get(childPosition);
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
        final ShoppingCarDataBean.ResultBean datasBean = data.get(groupPosition);
        //店铺ID
        String store_id = String.valueOf(datasBean.getId());
        //店铺名称
        String store_name = datasBean.getStoreName();
        //店铺是否在购物车中被选中
        final boolean isSelect_shop = datasBean.getIsSelect_shop();
        final ShoppingCarDataBean.ResultBean.ProductsBean goodsBean = datasBean.getProducts().get(childPosition);
        //商品图片
        String goods_image = goodsBean.getCouverUrl();
        //商品ID
        final String goods_id = String.valueOf(goodsBean.getProductId());
        //商品名称
        String goods_name = goodsBean.getName();
        //商品价格
        String goods_price = String.valueOf(goodsBean.getPrice());
        //商品数量
        String goods_num = String.valueOf(goodsBean.getProductNum());
        //商品是否被选中
        final boolean isSelect = goodsBean.getIsSelect();

        Glide.with(context)
                .load(goods_image)
                .into(childViewHolder.ivPhoto);
        if (goods_name != null) {
            childViewHolder.tvName.setText(goods_name);
        } else {
            childViewHolder.tvName.setText("");
        }
        if (goods_price != null) {
            childViewHolder.tvPriceValue.setText(goods_price);
        } else {
            childViewHolder.tvPriceValue.setText("");
        }
//        if (goods_num != null) {
//            childViewHolder.tvEditBuyNumber.setText(goods_num);
//        } else {
//            childViewHolder.tvEditBuyNumber.setText("");
//        }

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
                    datasBean.setIsSelect_shop(false);
                }
                notifyDataSetChanged();
            }
        });
        childViewHolder.amountview.setGoods_storage(data.get(groupPosition).getProductNum());
        childViewHolder.amountview.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                    goodsBean.setProductNum(amount);
                    goodsBean.setIsSelect(true);
                    notifyDataSetChanged();
            }
        });


        if (childPosition == data.get(groupPosition).getProducts().size() - 1) {
            childViewHolder.view1.setVisibility(View.GONE);
            childViewHolder.viewLast.setVisibility(View.VISIBLE);
        } else {
            childViewHolder.view1.setVisibility(View.VISIBLE);
            childViewHolder.viewLast.setVisibility(View.GONE);
        }

        return convertView;
    }

    static class ChildViewHolder {
        ImageView ivSelect;
        ImageView ivPhoto;
        TextView tvName;
        TextView tvPriceKey;
        TextView tvPriceValue;
        ImageView ivEditAdd;
        View view1;
        View viewLast;
        AmountView amountview;

        ChildViewHolder(View view) {
            ivSelect = view.findViewById(R.id.iv_select);
            ivPhoto = view.findViewById(R.id.iv_photo);
            tvName = view.findViewById(R.id.tv_name);
            tvPriceKey = view.findViewById(R.id.tv_price_key);
            tvPriceValue = view.findViewById(R.id.tv_price_value);
            view1 = view.findViewById(R.id.view);
            viewLast = view.findViewById(R.id.view_last);
            amountview = view.findViewById(R.id.amountview);

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

    //修改商品数量的回调
    public interface OnChangeCountListener {
        void onChangeCount(String goods_id);
    }

    public void setOnChangeCountListener(OnChangeCountListener listener) {
        mChangeCountListener = listener;
    }

    private OnChangeCountListener mChangeCountListener;
}
