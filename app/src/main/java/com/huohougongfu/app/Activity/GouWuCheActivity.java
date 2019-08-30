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
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.TeHuiActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GouWuCheActivity extends AppCompatActivity implements OnClickListener {

    private List<ShoppingCarDataBean.ResultBean> datas;
    private ShoppingCarAdapter shoppingCarAdapter;
    private ExpandableListView elvShoppingCar;
    private TextView tvTitlebarCenter,tvTitlebarRight,tvTotalPrice;
    private ImageView ivSelectAll;
    private LinearLayout llSelectAll;
    private Button btnOrder,btnDelete,bt_shoucangjia;
    private RelativeLayout rlTotalPrice,rl,rlNoContant;
    private ImageView ivNoContant;
    private String token,tel,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou_wu_che);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
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
        bt_shoucangjia = findViewById(R.id.bt_shoucangjia);
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
        shoppingCarAdapter = new ShoppingCarAdapter(GouWuCheActivity.this, llSelectAll, ivSelectAll, btnOrder, btnDelete, rlTotalPrice, tvTotalPrice,bt_shoucangjia);
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
        //收藏夹的回调
        shoppingCarAdapter.setOnCollectionListener(new ShoppingCarAdapter.OnCollectionListener() {
            @Override
            public void onCollection() {
                initCollection();
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

    //移入收藏夹
    private void initCollection() {
        //判断是否有店铺或商品被选中
        //true为有，则需要刷新数据；反之，则不需要；
        boolean hasSelect = false;
        //创建临时的List，用于存储没有被选中的购物车数据
        String str = "";
        for (int i = 0; i < datas.get(0).getMallStores().size(); i++) {
            List<ShoppingCarDataBean.ResultBean.MallStoresBean> mallStores = datas.get(0).getMallStores();
            boolean isSelect_shop = mallStores.get(i).getIsSelect_shop();
            if (isSelect_shop) {
                for (int y = 0; y < mallStores.get(i).getMallProducts().size(); y++) {
                    ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean mallProductsBean = mallStores.get(i).getMallProducts().get(y);
                    boolean isSelect = mallProductsBean.getIsSelect();
                    if (isSelect) {
                        str += mallProductsBean.getId()+",";
                        hasSelect = true;
                    }
                }
                hasSelect = true;
                //跳出本次循环，继续下次循环。
                continue;
            }else{
//                datasTemp.add(datas.get(i).clone());
//                datasTemp.get(datasTemp.size() - 1).setProducts(new ArrayList<ShoppingCarDataBean.ResultBean.ProductsBean>());
            }
            for (int y = 0; y < mallStores.get(i).getMallProducts().size(); y++) {
                ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean goodsBean = mallStores.get(i).getMallProducts().get(y);
                boolean isSelect = goodsBean.getIsSelect();
                if (isSelect) {
                    str += goodsBean.getId()+",";
                    hasSelect = true;
                }else{
                }
            }
        }
        if (hasSelect) {
            String substring = str.substring(0, str.length() - 1);
            Map<String,String> map = new HashMap<>();
            map.put("pids",substring);
            map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
            OkGo.<String>get(Contacts.URl2+"/moveToCollection")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    initData();
                                }else if (jsonObject.getInt("status") == 0){
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } else {
            ToastUtils.showShort("请选择要移入收藏夹的商品");
        }
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
        Map<String,String> map = new HashMap<>();
        map.put("createBy",id);
        map.put("token",token);
        map.put("tel",tel);
        OkGo.<String>get(Contacts.URl2+"queryCartByCreate")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        ShoppingCarDataBean shoppingCarDataBean = gson.fromJson(body, ShoppingCarDataBean.class);
                        datas = shoppingCarDataBean.getResult();
                        initExpandableListViewData(datas);
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(GouWuCheActivity.this, "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initExpandableListViewData(List<ShoppingCarDataBean.ResultBean> datas) {
        if (datas != null && datas.size() > 0) {
            //刷新数据时，保持当前位置
            shoppingCarAdapter.setData(datas.get(0));
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
            bt_shoucangjia.setVisibility(View.GONE);
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
        String str = "";
        for (int i = 0; i < datas.get(0).getMallStores().size(); i++) {
            ShoppingCarDataBean.ResultBean.MallStoresBean goods = datas.get(0).getMallStores().get(i);
            boolean isSelect_shop = goods.getIsSelect_shop();
            if (isSelect_shop) {
                for (int y = 0; y < goods.getMallProducts().size(); y++) {
                    List<ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean> goodsBean = datas.get(0).getMallStores().get(i).getMallProducts();
                    boolean isSelect = goodsBean.get(y).getIsSelect();
                    if (isSelect) {
                        str += goodsBean.get(y).getCartId()+",";
                        hasSelect = true;
                    }
                }
                hasSelect = true;
                //跳出本次循环，继续下次循环。
                continue;
            }else{
                for (int y = 0; y < goods.getMallProducts().size(); y++) {
                    List<ShoppingCarDataBean.ResultBean.MallStoresBean.MallProductsBean> goodsBean = datas.get(0).getMallStores().get(i).getMallProducts();
                    boolean isSelect = goodsBean.get(y).getIsSelect();
                    if (isSelect) {
                        str += goodsBean.get(y).getCartId()+",";
                        hasSelect = true;
                    }else{
                    }
                }
            }
        }

        if (hasSelect) {
            String substring = str.substring(0, str.length() - 1);
            Map<String,String> map = new HashMap<>();
            map.put("ids",substring);
            map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
            OkGo.<String>post(Contacts.URl2+"/deleteByBatch")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    initData();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } else {
            ToastUtils.showShort("请选择要删除的商品");
        }
    }


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
                    bt_shoucangjia.setVisibility(View.VISIBLE);
                } else {
                    tvTitlebarRight.setText("编辑");
                    rlTotalPrice.setVisibility(View.VISIBLE);
                    btnOrder.setVisibility(View.VISIBLE);
                    btnDelete.setVisibility(View.GONE);
                    bt_shoucangjia.setVisibility(View.GONE);
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
        }
    }
}
