package com.huohougongfu.app.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShoppingCarAdapter;
import com.huohougongfu.app.Gson.ShoppingCarDataBean;
import com.huohougongfu.app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GouWuCheActivity extends AppCompatActivity implements OnClickListener {

    //模拟的购物车数据（实际开发中使用后台返回的数据）
    private String shoppingCarData = "{\n" +
            "    \"code\": 200,\n" +
            "    \"datas\": [\n" +
            "        {\n" +
            "            \"goods\": [\n" +
            "                {\n" +
            "                    \"goods_id\": \"111111\",\n" +
            "                    \"goods_image\": \"http://pic.58pic.com/58pic/15/62/69/34K58PICbmZ_1024.jpg\",\n" +
            "                    \"goods_name\": \"习近平谈治国理政(第二卷)(平装)\",\n" +
            "                    \"goods_num\": \"1\",\n" +
            "                    \"goods_price\": \"18.00\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"store_id\": \"1\",\n" +
            "            \"store_name\": \"一号小书店\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"goods\": [\n" +
            "                {\n" +
            "                    \"goods_id\": \"222221\",\n" +
            "                    \"goods_image\": \"http://file06.16sucai.com/2016/0511/9711205e4c003182edeed83355e6f1c7.jpg\",\n" +
            "                    \"goods_name\": \"爱茶之人代购 黄山毛峰顶尖级毛峰150g袋装\",\n" +
            "                    \"goods_num\": \"2\",\n" +
            "                    \"goods_price\": \"28.00\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"goods_id\": \"222222\",\n" +
            "                    \"goods_image\": \"http://img01.taopic.com/150424/240473-1504240U13615.jpg\",\n" +
            "                    \"goods_name\": \"爱茶之人代购 黄山毛峰顶尖级毛峰150g袋装\",\n" +
            "                    \"goods_num\": \"2\",\n" +
            "                    \"goods_price\": \"228.00\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"store_id\": \"2\",\n" +
            "            \"store_name\": \"二号中书店\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"goods\": [\n" +
            "                {\n" +
            "                    \"goods_id\": \"333331\",\n" +
            "                    \"goods_image\": \"http://pic22.nipic.com/20120718/8002769_100147127333_2.jpg\",\n" +
            "                    \"goods_name\": \"爱茶之人代购 黄山毛峰顶尖级毛峰150g袋装\",\n" +
            "                    \"goods_num\": \"3\",\n" +
            "                    \"goods_price\": \"38.00\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"goods_id\": \"333332\",\n" +
            "                    \"goods_image\": \"http://pic.58pic.com/58pic/14/71/50/40e58PICy54_1024.jpg\",\n" +
            "                    \"goods_name\": \"爱茶之人代购 黄山毛峰顶尖级毛峰150g袋装\",\n" +
            "                    \"goods_num\": \"3\",\n" +
            "                    \"goods_price\": \"338.00\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"goods_id\": \"333333\",\n" +
            "                    \"goods_image\": \"http://img01.taopic.com/150518/318750-15051PS40671.jpg\",\n" +
            "                    \"goods_name\": \"爱茶之人代购 黄山毛峰顶尖级毛峰150g袋装\",\n" +
            "                    \"goods_num\": \"3\",\n" +
            "                    \"goods_price\": \"3.80\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"store_id\": \"3\",\n" +
            "            \"store_name\": \"三号大书店\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    private List<ShoppingCarDataBean.DatasBean> datas;
    private ShoppingCarAdapter shoppingCarAdapter;
    private ExpandableListView elvShoppingCar;
    private TextView tvTitlebarCenter,tvTitlebarRight,tvTotalPrice;
    private ImageView ivSelectAll;
    private LinearLayout llSelectAll;
    private Button btnOrder,btnDelete;
    private RelativeLayout rlTotalPrice,rl,rlNoContant;
    private ImageView ivNoContant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wu_che);
        initUI();
        initExpandableListView();
        initData();
    }

    private void initUI() {
        elvShoppingCar = findViewById(R.id.elv_shopping_car);
        tvTitlebarCenter = findViewById(R.id.tv_titlebar_center);
        tvTitlebarRight = findViewById(R.id.tv_titlebar_right);
        tvTitlebarRight.setOnClickListener(this);
        tvTotalPrice = findViewById(R.id.tv_total_price);
        rlTotalPrice = findViewById(R.id.rl_total_price);
        rl = findViewById(R.id.rl);
        rlNoContant = findViewById(R.id.rl_no_contant);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        ivSelectAll = findViewById(R.id.iv_select_all);
        ivNoContant = findViewById(R.id.iv_no_contant);

        llSelectAll = findViewById(R.id.ll_select_all);
        btnOrder = findViewById(R.id.btn_order);
        btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(this);
    }


    /**
     * 初始化ExpandableListView
     * 创建数据适配器adapter，并进行初始化操作
     */
    private void initExpandableListView() {
        shoppingCarAdapter = new ShoppingCarAdapter(GouWuCheActivity.this, llSelectAll, ivSelectAll, btnOrder, btnDelete, rlTotalPrice, tvTotalPrice);
        elvShoppingCar.setAdapter(shoppingCarAdapter);
        //删除的回调
        shoppingCarAdapter.setOnDeleteListener(new ShoppingCarAdapter.OnDeleteListener() {
            @Override
            public void onDelete() {
                initDelete();
                /**
                 * 实际开发中，在此请求删除接口，删除成功后，
                 * 通过initExpandableListViewData（）方法刷新购物车数据。
                 * 注：通过bean类中的DatasBean的isSelect_shop属性，判断店铺是否被选中；
                 *                  GoodsBean的isSelect属性，判断商品是否被选中，
                 *                  （true为选中，false为未选中）
                 */
            }
        });

        //修改商品数量的回调
        shoppingCarAdapter.setOnChangeCountListener(new ShoppingCarAdapter.OnChangeCountListener() {
            @Override
            public void onChangeCount(String goods_id) {
                /**
                 * 实际开发中，在此请求修改商品数量的接口，商品数量修改成功后，
                 * 通过initExpandableListViewData（）方法刷新购物车数据。
                 */
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        //使用Gson解析购物车数据，
        //ShoppingCarDataBean为bean类，Gson按照bean类的格式解析数据
        /**
         * 实际开发中，通过请求后台接口获取购物车数据并解析
         */
        Gson gson = new Gson();
        ShoppingCarDataBean shoppingCarDataBean = gson.fromJson(shoppingCarData, ShoppingCarDataBean.class);
        datas = shoppingCarDataBean.getDatas();

        initExpandableListViewData(datas);
    }

    private void initExpandableListViewData(List<ShoppingCarDataBean.DatasBean> datas) {
        if (datas != null && datas.size() > 0) {
            //刷新数据时，保持当前位置
            shoppingCarAdapter.setData(datas);
            //使所有组展开
            for (int i = 0; i < shoppingCarAdapter.getGroupCount(); i++) {
                elvShoppingCar.expandGroup(i);
            }

            //使组点击无效果
            elvShoppingCar.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
                    return true;
                }
            });

            tvTitlebarRight.setVisibility(View.VISIBLE);
            tvTitlebarRight.setText("编辑");
            rlNoContant.setVisibility(View.GONE);
            elvShoppingCar.setVisibility(View.VISIBLE);
            rl.setVisibility(View.VISIBLE);
            rlTotalPrice.setVisibility(View.VISIBLE);
            btnOrder.setVisibility(View.VISIBLE);
            btnDelete.setVisibility(View.GONE);
        } else {
            tvTitlebarRight.setVisibility(View.GONE);
            rlNoContant.setVisibility(View.VISIBLE);
            elvShoppingCar.setVisibility(View.GONE);
            rl.setVisibility(View.GONE);
        }
    }

    /**
     * 判断是否要弹出删除的dialog
     * 通过bean类中的DatasBean的isSelect_shop属性，判断店铺是否被选中；
     * GoodsBean的isSelect属性，判断商品是否被选中，
     */
    private void initDelete() {
        //判断是否有店铺或商品被选中
        //true为有，则需要刷新数据；反之，则不需要；
        boolean hasSelect = false;
        //创建临时的List，用于存储没有被选中的购物车数据
        List<ShoppingCarDataBean.DatasBean> datasTemp = new ArrayList<>();

        for (int i = 0; i < datas.size(); i++) {
            List<ShoppingCarDataBean.DatasBean.GoodsBean> goods = datas.get(i).getGoods();
            boolean isSelect_shop = datas.get(i).getIsSelect_shop();

            if (isSelect_shop) {
                hasSelect = true;
                //跳出本次循环，继续下次循环。
                continue;
            } else {
                datasTemp.add(datas.get(i).clone());
                datasTemp.get(datasTemp.size() - 1).setGoods(new ArrayList<ShoppingCarDataBean.DatasBean.GoodsBean>());
            }

            for (int y = 0; y < goods.size(); y++) {
                ShoppingCarDataBean.DatasBean.GoodsBean goodsBean = goods.get(y);
                boolean isSelect = goodsBean.getIsSelect();

                if (isSelect) {
                    hasSelect = true;
                } else {
                    datasTemp.get(datasTemp.size() - 1).getGoods().add(goodsBean);
                }
            }
        }

        if (hasSelect) {
            initExpandableListViewData(datasTemp);
//            showDeleteDialog(datasTemp);
        } else {
            ToastUtils.showShort("请选择要删除的商品");
        }
    }

//    /**
//     * 展示删除的dialog（可以自定义弹窗，不用删除即可）
//     *
//     * @param datasTemp
//     */
//    private void showDeleteDialog(final List<ShoppingCarDataBean.DatasBean> datasTemp) {
//        View view = View.inflate(context, R.layout.dialog_two_btn, null);
//        final RoundCornerDialog roundCornerDialog = new RoundCornerDialog(context, 0, 0, view, R.style.RoundCornerDialog);
//        roundCornerDialog.show();
//        roundCornerDialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
//        roundCornerDialog.setOnKeyListener(keylistener);//设置点击返回键Dialog不消失
//
//        TextView tv_message = (TextView) view.findViewById(R.id.tv_message);
//        TextView tv_logout_confirm = (TextView) view.findViewById(R.id.tv_logout_confirm);
//        TextView tv_logout_cancel = (TextView) view.findViewById(R.id.tv_logout_cancel);
//        tv_message.setText("确定要删除商品吗？");
//
//        //确定
//        tv_logout_confirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                roundCornerDialog.dismiss();
//                datas = datasTemp;
//                initExpandableListViewData(datas);
//            }
//        });
//        //取消
//        tv_logout_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                roundCornerDialog.dismiss();
//            }
//        });
//    }

    DialogInterface.OnKeyListener keylistener = new DialogInterface.OnKeyListener() {
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                return true;
            } else {
                return false;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_titlebar_right:
                String edit = tvTitlebarRight.getText().toString().trim();
                if (edit.equals("编辑")) {
                    tvTitlebarRight.setText("完成");
                    rlTotalPrice.setVisibility(View.GONE);
                    btnOrder.setVisibility(View.GONE);
                    btnDelete.setVisibility(View.VISIBLE);
                } else {
                    tvTitlebarRight.setText("编辑");
                    rlTotalPrice.setVisibility(View.VISIBLE);
                    btnOrder.setVisibility(View.VISIBLE);
                    btnDelete.setVisibility(View.GONE);
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
        }
    }
}
