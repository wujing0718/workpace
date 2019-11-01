package com.huohougongfu.app.Shop.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.AddRess;
import com.huohougongfu.app.Gson.ShopDingDan;
import com.huohougongfu.app.Gson.ShopYouHuiQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.XiaDanAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.AddressActivity;
import com.huohougongfu.app.WoDe.Activity.MyDingDanActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.text.DecimalFormat;
import java.util.List;

public class XiaDanActivity extends AppCompatActivity implements View.OnClickListener ,IListener{

    private int mId;
    private ExpandableListView rec_xiadan;
    private ShopDingDan.ResultBean resultBean;
    private TextView tv_shouhuo_name,tv_shouhuo_phone,tv_shouhuo_address;
    private TextView tv_chami_dikou;
    private View bt_chami_dikou;
    private Button btn_go_to_pay;
    private ImageView img_chami_check;
    private TextView tv_total_price;
    private XiaDanAdapter xiaDanAdapter;
    private AddRess.ResultBean address;
    private int transId = 0;
    public static XiaDanActivity activity;
    private ShopYouHuiQuan.ResultBean coupon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_xia_dan);
        mId = MyApp.instance.getInt("id");
        ListenerManager.getInstance().registerListtener(this);
        activity = this;
        coupon = (ShopYouHuiQuan.ResultBean)getIntent().getSerializableExtra("coupon");
        resultBean = (ShopDingDan.ResultBean)getIntent().getSerializableExtra("订单详情");
        initUI();
        initExpandableListViewData(resultBean);
    }

    private void initExpandableListViewData(ShopDingDan.ResultBean resultBean) {
        if (resultBean != null && resultBean.getOrderList().size() > 0) {
            //刷新数据时，保持当前位置
            xiaDanAdapter.setData(resultBean,transId);
            //使所有组展开
            for (int i = 0; i < xiaDanAdapter.getGroupCount(); i++) {
                rec_xiadan.expandGroup(i);
            }

            //使组点击无效果
            rec_xiadan.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v,
                                            int groupPosition, long id) {
                    return true;
                }
            });
        }
    }

    private void initRec() {
        tv_total_price.setText("1000");
        xiaDanAdapter = new XiaDanAdapter(this,bt_chami_dikou,btn_go_to_pay,tv_chami_dikou,
                img_chami_check,tv_total_price,resultBean.getTeaRice(),coupon);
        rec_xiadan.setAdapter(xiaDanAdapter);
    }

    private void initUI() {
        tv_shouhuo_name = findViewById(R.id.tv_shouhuo_name);
        tv_shouhuo_phone = findViewById(R.id.tv_shouhuo_phone);
        tv_shouhuo_address = findViewById(R.id.tv_shouhuo_address);
        tv_chami_dikou = findViewById(R.id.tv_chami_dikou);
        bt_chami_dikou = findViewById(R.id.bt_chami_dikou);
        btn_go_to_pay = findViewById(R.id.btn_go_to_pay);
        img_chami_check = findViewById(R.id.img_chami_check);
        tv_total_price = findViewById(R.id.tv_total_price);
        bt_chami_dikou.setOnClickListener(this);
        btn_go_to_pay.setOnClickListener(this);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = decimalFormat.format(resultBean.getTeaRice() * 0.01);
        tv_chami_dikou.setText("可用"+resultBean.getTeaRice()+"茶米抵扣"+
                format+"元");
        tv_shouhuo_name.setText(resultBean.getDefaultAddress().getReceiverName());
        tv_shouhuo_phone.setText(resultBean.getDefaultAddress().getPhone());
        tv_shouhuo_address.setText(resultBean.getDefaultAddress().getReceiverName()+resultBean.getDefaultAddress().getAreaName()+resultBean.getDefaultAddress().getDetailAddr());
        rec_xiadan = findViewById(R.id.elv_shopping_car);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_xuanze_dizhi).setOnClickListener(this);
        initRec();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
            case R.id.bt_xuanze_dizhi:
                if (!utils.isDoubleClick()){
                    Intent intent = new Intent();
                    intent.putExtra("下单","是");
                    intent.setClass(XiaDanActivity.this,AddressActivity.class);
                    startActivityForResult(intent,0);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 0){
            Bundle extras = data.getExtras();
            String 地址 = extras.getString("地址");
            if ("0".equals(地址)){
                transId = 0;
            }else{
                address = (AddRess.ResultBean)extras.get("地址");
                transId = address.getId();
                xiaDanAdapter.setData(resultBean,transId);
                tv_shouhuo_name.setText(address.getReceiverName());
                tv_shouhuo_phone.setText(address.getPhone());
                tv_shouhuo_address.setText(address.getAreaName()+address.getDetailAddr());
            }
        }
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 200){
            if ("成功".equals(status)){
                Intent intent = new Intent().setClass(XiaDanActivity.this, MyDingDanActivity.class);
                startActivity(intent);
                finish();
                ListenerManager.getInstance().unRegisterListener(this);
            }
        }
    }
}
