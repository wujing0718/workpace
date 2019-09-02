package com.huohougongfu.app.ShouYe.Activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChaTaiGson;
import com.huohougongfu.app.Gson.ChaTaiYouHuiQuan;
import com.huohougongfu.app.Gson.MaiChaDetail;
import com.huohougongfu.app.Gson.OKGson;
import com.huohougongfu.app.Gson.TeaDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.CTYouHuiQuan;
import com.huohougongfu.app.PopupView.ChaTaiZhiFu;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
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

public class MyDingDanPaoChaActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_photo,img_chami_check;
    private TextView tv_name,tv_standard,tv_price_value,tv_total_price,
            tv_chami_dikou,tv_manjian1,tv_manjian2,tv_price_key;
    private AnimShopButton amountview;
    private String yedi,nongdu,photo,machineId;
    private int num;
    private TeaDetail teaDetail;
    private ChaTaiYouHuiQuan.ResultBean myouhuiquan;
    private View bt_chami_dikou;
    private boolean isDikou = true;
    private double total_price;
    private JSONArray array;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    public static  MyDingDanPaoChaActivity activity ;


    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    xuanzeyouhuiquan = (ChaTaiYouHuiQuan.ResultBean.CouponsBean)msg.obj;
                    tv_manjian1.setText(xuanzeyouhuiquan.getTitle());
                    tv_manjian2.setText("");
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.activity_my_ding_dan_pao_cha);
        yedi = getIntent().getStringExtra("yedi");
        nongdu = getIntent().getStringExtra("nongdu");
        resultBean = (MaiChaDetail.ResultBean)getIntent().getSerializableExtra("买茶");
        teaDetail = (TeaDetail)getIntent().getSerializableExtra("teaDetail");
        num = getIntent().getIntExtra("num",0);
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
            array = new JSONArray();
                    try {
                        JSONObject object =new JSONObject();
                        object.put("id","");
                        object.put("concentration",nongdu);
                        object.put("teaId",teaDetail.getTeaId());
                        object.put("hasDust",yedi);
                        object.put("num",num);
                        array.put(object);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String teanum = String.valueOf(num);
                    String price = String.valueOf(teaDetail.getPrice());
                    dikou  = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                    double v = Double.parseDouble(teanum);
                    double v1 = Double.parseDouble(price);
                    total_price = total_price + v * v1;
                    if (dikou>=total_price){
                        orderprice = decimalFormat.format(0.00);
                        tv_total_price.setText("¥" + price);
                    }else{
                        orderprice = decimalFormat.format(total_price - dikou);
                        tv_total_price.setText("¥" + price);
                    }
        }else{
            //合计的计算
            total_price = 0.00;
            tv_total_price.setText("¥0.00");
            array = new JSONArray();
                    try {
                        JSONObject object =new JSONObject();
                        object.put("id","");
                        object.put("concentration",nongdu);
                        object.put("teaId",teaDetail.getTeaId());
                        object.put("hasDust",yedi);
                        object.put("num",num);
                        array.put(object);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String teanum = String.valueOf(num);
                    String price = String.valueOf(teaDetail.getPrice());
                    double v = Double.parseDouble(teanum);
                    double v1 = Double.parseDouble(price);
                    total_price = total_price + v * v1;
            orderprice = decimalFormat.format(total_price);
                    tv_total_price.setText("¥" + orderprice);
                }
    }

    private void initUI() {
        tv_manjian1 = findViewById(R.id.tv_manjian1);
        tv_manjian2 = findViewById(R.id.tv_manjian2);
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
        if (teaDetail!=null){
            amountview.setCount(num);
            initDiKou();
            Glide.with(MyApp.context).load(teaDetail.getPicture()).into(iv_photo);
            tv_name.setText(teaDetail.getTeaName());
            tv_price_value.setText(teaDetail.getPrice());
            tv_price_value.setTextColor(getResources().getColor(R.color.colorBlack));
            tv_price_value.setTextSize(17);
            tv_price_key.setTextColor(getResources().getColor(R.color.colorBlack));
            tv_price_key.setTextSize(17);
            tv_total_price.setText("¥"+teaDetail.getPrice());
            amountview.setOnAddDelListener(new IOnAddDelListener() {
                @Override
                public void onAddSuccess(int i) {
                    num = i;
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    if (!isDikou){
                        //合计的计算
                        total_price = 0.00;
                        tv_total_price.setText("¥0.00");
                        array = new JSONArray();
                        JSONObject object =new JSONObject();
                        try {
//                        object.put("id",teaDetail.getId());
                            object.put("concentration",nongdu);
                            object.put("teaId",teaDetail.getTeaId());
                            object.put("hasDust",yedi);
                            object.put("num",i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        array.put(object);
                        String teanum = String.valueOf(i);
                        String price = String.valueOf(teaDetail.getPrice());
                        dikou  = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                        double v = Double.parseDouble(teanum);
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        if (dikou>=total_price){
                            tv_total_price.setText("¥" + decimalFormat.format(0.00));
                        }else{
                            tv_total_price.setText("¥" + decimalFormat.format(total_price-dikou));
                        }
                    }else{
                        //合计的计算
                        total_price = 0.00;
                        tv_total_price.setText("¥0.00");
                        array = new JSONArray();
                        try {
                            JSONObject object =new JSONObject();
//                                object.put("id",resultBean.getId());
                            object.put("concentration",nongdu);
                            object.put("teaId",teaDetail.getTeaId());
                            object.put("hasDust",yedi);
                            object.put("num",i);
                            array.put(object);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String teanum = String.valueOf(i);
                        String price = String.valueOf(teaDetail.getPrice());
                        double v = Double.parseDouble(teanum);
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        tv_total_price.setText("¥" + decimalFormat.format(total_price));
                    }
                }

                @Override
                public void onAddFailed(int i, FailType failType) {

                }

                @Override
                public void onDelSuccess(int i) {
                    num = i;
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    if (!isDikou){
                        //合计的计算
                        total_price = 0.00;
                        tv_total_price.setText("¥0.00");
                        array = new JSONArray();
                        JSONObject object =new JSONObject();
                        try {
//                        object.put("id",teaDetail.getId());
                            object.put("concentration",nongdu);
                            object.put("teaId",teaDetail.getTeaId());
                            object.put("hasDust",yedi);
                            object.put("num",i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        array.put(object);
                        String teanum = String.valueOf(i);
                        String price = String.valueOf(teaDetail.getPrice());
                        double dikou  = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                        double v = Double.parseDouble(teanum);
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        if (dikou>=total_price){
                            orderprice = decimalFormat.format(0.00);
                            tv_total_price.setText("¥" + orderprice);
                        }else{
                            orderprice = decimalFormat.format(total_price-dikou);
                            tv_total_price.setText("¥" + orderprice);
                        }
                    }else{
                        //合计的计算
                        total_price = 0.00;
                        tv_total_price.setText("¥0.00");
                        array = new JSONArray();
                        try {
                            JSONObject object =new JSONObject();
//                                object.put("id",resultBean.getId());
                            object.put("concentration",nongdu);
                            object.put("teaId",teaDetail.getTeaId());
                            object.put("hasDust",yedi);
                            object.put("num",i);
                            array.put(object);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String teanum = String.valueOf(i);
                        String price = String.valueOf(teaDetail.getPrice());
                        double v = Double.parseDouble(teanum);
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        orderprice = decimalFormat.format(total_price);
                        tv_total_price.setText("¥" + orderprice);
                    }
                }

                @Override
                public void onDelFaild(int i, FailType failType) {

                }
            });
        }else{
            amountview.setVisibility(View.GONE);
            Glide.with(MyApp.context).load(resultBean.getMasterGraph()).into(iv_photo);
            tv_name.setText(resultBean.getName());
            tv_price_value.setText(String.valueOf(resultBean.getProductPrice()));
            tv_price_value.setTextColor(getResources().getColor(R.color.colorBlack));
            tv_price_value.setTextSize(17);
            tv_price_key.setTextColor(getResources().getColor(R.color.colorBlack));
            tv_price_key.setTextSize(17);
            tv_total_price.setText("¥"+String.valueOf(resultBean.getProductPrice()));
            amountview.setOnAddDelListener(new IOnAddDelListener() {
                @Override
                public void onAddSuccess(int i) {
                    num = i;
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    if (!isDikou){
                        //合计的计算
                        total_price = 0.00;
                        tv_total_price.setText("¥0.00");
                        array = new JSONArray();
                        JSONObject object =new JSONObject();
                        try {
//                        object.put("id",teaDetail.getId());
                            object.put("concentration",nongdu);
                            object.put("teaId",teaDetail.getTeaId());
                            object.put("hasDust",yedi);
                            object.put("num",i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        array.put(object);
                        String teanum = String.valueOf(i);
                        String price = String.valueOf(teaDetail.getPrice());
                        dikou  = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                        double v = Double.parseDouble(teanum);
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        if (dikou>=total_price){
                            tv_total_price.setText("¥" + decimalFormat.format(0.00));
                        }else{
                            tv_total_price.setText("¥" + decimalFormat.format(total_price-dikou));
                        }
                    }else{
                        //合计的计算
                        total_price = 0.00;
                        tv_total_price.setText("¥0.00");
                        array = new JSONArray();
                        try {
                            JSONObject object =new JSONObject();
//                                object.put("id",resultBean.getId());
                            object.put("concentration",nongdu);
                            object.put("teaId",teaDetail.getTeaId());
                            object.put("hasDust",yedi);
                            object.put("num",i);
                            array.put(object);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String teanum = String.valueOf(i);
                        String price = String.valueOf(teaDetail.getPrice());
                        double v = Double.parseDouble(teanum);
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        tv_total_price.setText("¥" + decimalFormat.format(total_price));
                    }
                }

                @Override
                public void onAddFailed(int i, FailType failType) {

                }

                @Override
                public void onDelSuccess(int i) {
                    num = i;
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    if (!isDikou){
                        //合计的计算
                        total_price = 0.00;
                        tv_total_price.setText("¥0.00");
                        array = new JSONArray();
                        JSONObject object =new JSONObject();
                        try {
//                        object.put("id",teaDetail.getId());
                            object.put("concentration",nongdu);
                            object.put("teaId",teaDetail.getTeaId());
                            object.put("hasDust",yedi);
                            object.put("num",i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        array.put(object);
                        String teanum = String.valueOf(i);
                        String price = String.valueOf(teaDetail.getPrice());
                        double dikou  = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                        double v = Double.parseDouble(teanum);
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        if (dikou>=total_price){
                            orderprice = decimalFormat.format(0.00);
                            tv_total_price.setText("¥" + orderprice);
                        }else{
                            orderprice = decimalFormat.format(total_price-dikou);
                            tv_total_price.setText("¥" + orderprice);
                        }
                    }else{
                        //合计的计算
                        total_price = 0.00;
                        tv_total_price.setText("¥0.00");
                        array = new JSONArray();
                        try {
                            JSONObject object =new JSONObject();
//                                object.put("id",resultBean.getId());
                            object.put("concentration",nongdu);
                            object.put("teaId",teaDetail.getTeaId());
                            object.put("hasDust",yedi);
                            object.put("num",i);
                            array.put(object);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String teanum = String.valueOf(i);
                        String price = String.valueOf(teaDetail.getPrice());
                        double v = Double.parseDouble(teanum);
                        double v1 = Double.parseDouble(price);
                        total_price = total_price + v * v1;
                        orderprice = decimalFormat.format(total_price);
                        tv_total_price.setText("¥" + orderprice);
                    }
                }

                @Override
                public void onDelFaild(int i, FailType failType) {

                }
            });
        }
    }

    /*
       优惠券列表数据
    */
    private void initYouHuiQuan() {
        Map<String,String> map = new HashMap<>();
        map.put("tel",MyApp.instance.getString("phone"));
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("machineId",machineId);
        OkGo.<String>post(Contacts.URl1+"/machine/getPreferential")
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
                            if (myouhuiquan.getCoupons().size()>1){
                                tv_manjian1.setText(myouhuiquan.getCoupons().get(0).getServiceRegulations());
                                tv_manjian2.setText(myouhuiquan.getCoupons().get(1).getServiceRegulations());
                            }else if(myouhuiquan.getCoupons().size() ==1){
                                tv_manjian1.setText(myouhuiquan.getCoupons().get(0).getServiceRegulations());
                            }else if (myouhuiquan.getCoupons().size()<0){
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
                if (teaDetail!=null){
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
                        tv_total_price.setText("¥" + decimalFormat.format(total_price));
                        img_chami_check.setImageResource(R.mipmap.unselect);
                        isDikou = true;
                    }
                }else{
                    // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                    if (isDikou){
                        dikou = myouhuiquan.getTeaRice()*myouhuiquan.getProportion();
                        if (dikou<=resultBean.getProductPrice()){
                            double total_price1 = resultBean.getProductPrice()-dikou;
                            tv_total_price.setText("¥" + decimalFormat.format(total_price1));
                        }else{
                            tv_total_price.setText("¥" + 0.00);
                        }
                        img_chami_check.setImageResource(R.mipmap.select);
                        isDikou = false;
                    }else{
                        tv_total_price.setText("¥" + decimalFormat.format(resultBean.getProductPrice()));
                        img_chami_check.setImageResource(R.mipmap.unselect);
                        isDikou = true;
                    }
                }

                break;
            case R.id.bt_detail_lingquan:
                if (!utils.isDoubleClick()) {
                    if (myouhuiquan != null) {
                        if (myouhuiquan.getCoupons().size()>0){
                            new XPopup.Builder(this)
                                    .asCustom(new CTYouHuiQuan(this, myouhuiquan.getCoupons(),mHandler))
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
                Double d = total_priceorder*100;
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
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                new XPopup.Builder(MyDingDanPaoChaActivity.this)
                                        .asCustom(new ChaTaiZhiFu(MyDingDanPaoChaActivity.this,jsonObject.getString("result"),orderprice))
                                        .show();
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
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
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                new XPopup.Builder(MyDingDanPaoChaActivity.this)
                                        .asCustom(new ChaTaiZhiFu(MyDingDanPaoChaActivity.this,jsonObject.getString("result"),orderprice))
                                        .show();
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
