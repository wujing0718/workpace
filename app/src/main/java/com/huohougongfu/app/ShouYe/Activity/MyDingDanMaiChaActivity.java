package com.huohougongfu.app.ShouYe.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChaTaiYouHuiQuan;
import com.huohougongfu.app.Gson.MaiChaDetail;
import com.huohougongfu.app.Gson.TeaDetail;
import com.huohougongfu.app.Gson.ZhiFu;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.ChaTaiZhiFu;
import com.huohougongfu.app.PopupView.MCYouHuiQuan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.mcxtzhang.lib.AnimShopButton;
import com.mcxtzhang.lib.IOnAddDelListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MyDingDanMaiChaActivity extends AppCompatActivity implements View.OnClickListener,IListener {

    private ImageView iv_photo,img_chami_check;
    private TextView tv_name,tv_standard,tv_price_value,tv_total_price,
            tv_chami_dikou,tv_manjian1,tv_price_key;
    private AnimShopButton amountview;
    private String yedi,nongdu,photo,machineId;
    private int num = 1;
    private ChaTaiYouHuiQuan.ResultBean myouhuiquan;
    private View bt_chami_dikou;
    private boolean isDikou = true;
    private double total_price;
    private JSONArray array;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    public static MyDingDanMaiChaActivity activity ;


    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    xuanzeyouhuiquan = (ChaTaiYouHuiQuan.ResultBean.CouponsBean)msg.obj;
                    tv_manjian1.setText(xuanzeyouhuiquan.getTitle());
                    initDiKou();
                    break;
                default:
                    break;
            }
        }

    };
    private ChaTaiYouHuiQuan.ResultBean.CouponsBean xuanzeyouhuiquan;
    private double dikou;
    private String orderprice;
    private MaiChaDetail.ResultBean  resultBean;
    private String equipmentId;
    private TeaDetail teaDetail;
    private ZhiFu zhiFu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_my_ding_dan_pao_cha);
        ListenerManager.getInstance().registerListtener(this);
        yedi = getIntent().getStringExtra("yedi");
        nongdu = getIntent().getStringExtra("nongdu");
        resultBean = (MaiChaDetail.ResultBean)getIntent().getSerializableExtra("买茶");
        teaDetail = (TeaDetail)getIntent().getSerializableExtra("teaDetail");
        machineId = getIntent().getStringExtra("machineId");
        equipmentId = getIntent().getStringExtra("equipmentId");
        initUI();
        initYouHuiQuan();
    }

    private void initDiKou() {
        if (!isDikou){
            //合计的计算
            total_price = 0.00;
            tv_total_price.setText("¥0.00");
                    if (xuanzeyouhuiquan!=null){
                        String price = String.valueOf(resultBean.getProductPrice());
                        dikou  = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                        double v = Double.parseDouble(String.valueOf(num));
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        total_price = total_price*xuanzeyouhuiquan.getDiscount();
                        if (dikou>=total_price){
                            orderprice = decimalFormat.format(0.00);
                            tv_total_price.setText("¥" + orderprice);
                        }else{
                            orderprice = decimalFormat.format(total_price - dikou);
                            tv_total_price.setText("¥" + orderprice);
                        }
                    }else{
                        String price = String.valueOf(resultBean.getProductPrice());
                        dikou  = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                        double v = Double.parseDouble(String.valueOf(num));
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        if (dikou>=total_price){
                            orderprice = decimalFormat.format(0.00);
                            tv_total_price.setText("¥" + orderprice);
                        }else{
                            orderprice = decimalFormat.format(total_price - dikou);
                            tv_total_price.setText("¥" + orderprice);
                        }
                    }
        }else{
            //合计的计算
            total_price = 0.00;
            tv_total_price.setText("¥0.00");
                    int dingdannum = num;
                    if (xuanzeyouhuiquan!=null){
                        String price = String.valueOf(resultBean.getProductPrice());
                        double v = Double.parseDouble(String.valueOf(dingdannum));
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        orderprice = decimalFormat.format(total_price);
                        tv_total_price.setText("¥" + orderprice);
                        if (xuanzeyouhuiquan.getCouponType()==3){
                            total_price = num * v1;
                            total_price = total_price * xuanzeyouhuiquan.getDiscount();
                            String orderprice = decimalFormat.format(total_price);
                            tv_total_price.setText("¥" + orderprice);
                        }
                    }else{
                        String price = String.valueOf(resultBean.getProductPrice());
                        double v = Double.parseDouble(String.valueOf(num));
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        orderprice = decimalFormat.format(total_price);
                        tv_total_price.setText("¥" + orderprice);
                    }
                }
    }

    private void initUI() {
        tv_manjian1 = findViewById(R.id.tv_manjian1);
        tv_chami_dikou = findViewById(R.id.tv_chami_dikou);
        img_chami_check = findViewById(R.id.img_chami_check);
        bt_chami_dikou = findViewById(R.id.bt_chami_dikou);
        tv_total_price= findViewById(R.id.tv_total_price);
        bt_chami_dikou.setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_detail_lingquan).setOnClickListener(this);
        findViewById(R.id.btn_go_to_pay).setOnClickListener(this);
        iv_photo = findViewById(R.id.iv_photo);
        tv_name = findViewById(R.id.tv_name);
        tv_standard = findViewById(R.id.tv_standard);
        tv_price_key = findViewById(R.id.tv_price_key);
        tv_price_value = findViewById(R.id.tv_price_value);
        amountview = findViewById(R.id.amountview);
        amountview.setVisibility(View.GONE);
        Glide.with(MyApp.context).load(resultBean.getMasterGraph()).into(iv_photo);
        tv_name.setText(resultBean.getName());
        tv_price_value.setText(String.valueOf(resultBean.getProductPrice()));
        tv_price_value.setTextColor(getResources().getColor(R.color.colorBlack));
        tv_price_value.setTextSize(17);
        tv_price_key.setTextColor(getResources().getColor(R.color.colorBlack));
        tv_price_key.setTextSize(17);
        initDiKou();
//        tv_total_price.setText("¥"+resultBean.getProductPrice());
    }

    /*
       优惠券列表数据
    */
    private void initYouHuiQuan() {
        Map<String,String> map = new HashMap<>();
        map.put("tel",MyApp.instance.getString("phone"));
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("machineId",machineId);
        OkGo.<String>post(Contacts.URl1+"/machine/getProductPreferential")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ChaTaiYouHuiQuan youhuiquan = gson.fromJson(body, ChaTaiYouHuiQuan.class);
                        if (youhuiquan.getStatus() == 1){
                            myouhuiquan = youhuiquan.getResult();
                            String dikou = decimalFormat.format(youhuiquan.getResult().getTeaRice() * youhuiquan.getResult().getProportion());
                            tv_chami_dikou.setText("可用"+youhuiquan.getResult().getTeaRice()+"茶米抵扣"+ (dikou)+"元");
                            if (myouhuiquan.getCoupons().size()<=0){
                                tv_manjian1.setText("暂无优惠券");
                            }
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_chami_dikou:
                    // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                    if (isDikou){
                        dikou = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                        if (dikou<=total_price){
                            double total_price1 = total_price-dikou;
                            tv_total_price.setText("¥" + decimalFormat.format(total_price1));
                        }else{
                            tv_total_price.setText("¥" + 0.00);
                        }
                        img_chami_check.setImageResource(R.mipmap.select);
                        isDikou = false;
                    }else{
                        img_chami_check.setImageResource(R.mipmap.unselect);
                        orderprice = decimalFormat.format(total_price);
                        tv_total_price.setText("¥" + orderprice);
                        isDikou = true;
                }

                break;
            case R.id.bt_detail_lingquan:
                if (!utils.isDoubleClick()) {
                    if (myouhuiquan != null) {
                        if (myouhuiquan.getCoupons().size()>0){
                            new XPopup.Builder(this)
                                    .asCustom(new MCYouHuiQuan(this, myouhuiquan.getCoupons(),mHandler,resultBean))
                                    .show();
                        }else {
                            ToastUtils.showShort("暂无优惠券");
                        }
                    }
                }
                break;
            case R.id.btn_go_to_pay:
                if (resultBean!=null){
                    initMaiChaOrder();
                }else{
                    initORder();
                }
                break;
        }
    }

    private void initMaiChaOrder() {
        String s = tv_total_price.getText().toString();
        String ¥ = s.replace("¥", "");
        double orderprice = Double.parseDouble(¥);
        Map<String,String> map = new HashMap<>();
        map.put("pId",String.valueOf(resultBean.getId()));
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("machineId",equipmentId);
        if (xuanzeyouhuiquan!=null){
            map.put("couponId",String.valueOf(xuanzeyouhuiquan.getId()));
        }
        Double total_priceorder = Double.valueOf(orderprice);
        if (!isDikou){
            if (total_priceorder>=dikou){
                map.put("totalPrice",String.valueOf(total_priceorder-dikou));
                map.put("teaRiceNum",String.valueOf(myouhuiquan.getTeaRice()));
            }else{
                map.put("totalPrice",String.valueOf(orderprice));
                Double d = dikou*100;
                int teaRiceNum = d.intValue();
                map.put("teaRiceNum",String.valueOf(teaRiceNum));
            }
        }else{
            map.put("totalPrice",String.valueOf(orderprice));
        }
        OkGo.<String>post(Contacts.URl1+"/machine/generateProductOrders")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        ZhiFu zhiFu = gson.fromJson(response.body(), ZhiFu.class);
                        if (zhiFu.getStatus() == 1){
                            new XPopup.Builder(MyDingDanMaiChaActivity.this)
                                    .asCustom(new ChaTaiZhiFu(MyDingDanMaiChaActivity.this,zhiFu.getResult().getOrderNo(),String.valueOf(zhiFu.getResult().getOrderId()),orderprice))
                                    .show();
                        }else{
                            ToastUtils.showShort(zhiFu.getMsg());

                        }
                    }
                });
    }

    private void initORder() {
        String s = tv_total_price.getText().toString();
        String ¥ = s.replace("¥", "");
        double orderprice = Double.parseDouble(¥);
        Map<String,String> map = new HashMap<>();
        map.put("json",array.toString());
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("machineId",machineId);
        if (xuanzeyouhuiquan!=null){
            map.put("couponId",String.valueOf(xuanzeyouhuiquan.getId()));
        }
        Double total_priceorder = Double.valueOf(orderprice);
        if (!isDikou){
            if (total_priceorder>=dikou){
                map.put("totalPrice",String.valueOf(total_priceorder-dikou));
                map.put("teaRiceNum",String.valueOf(myouhuiquan.getTeaRice()));
            }else{
                map.put("totalPrice",String.valueOf(orderprice));
                Double d = total_priceorder*100;
                int teaRiceNum = d.intValue();
                map.put("teaRiceNum",String.valueOf(teaRiceNum));
            }
        }else{
            map.put("totalPrice",String.valueOf(orderprice));
        }

        OkGo.<String>post(Contacts.URl1+"/machine/generate/orders")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        zhiFu = gson.fromJson(response.body(), ZhiFu.class);
                        if (zhiFu.getStatus() == 1){
                            new XPopup.Builder(MyDingDanMaiChaActivity.this)
                                    .asCustom(new ChaTaiZhiFu(MyDingDanMaiChaActivity.this,zhiFu.getResult().getOrderNo(),String.valueOf(zhiFu.getResult().getOrderId()),orderprice))
                                    .show();
                        }else{
                            ToastUtils.showShort(zhiFu.getMsg());

                        }
                    }
                });
    }
    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 200){
            if ("成功".equals(status)) {
                Intent intent = new Intent().setClass(MyDingDanMaiChaActivity.this, ChaTaiDingDanDetail.class);
                if (zhiFu != null) {
                    intent.putExtra("orderNo",String.valueOf(zhiFu.getResult().getOrderId()));
                    startActivity(intent);
                    finish();
                    ListenerManager.getInstance().unRegisterListener(this);
                }
            }
        }
    }
}
