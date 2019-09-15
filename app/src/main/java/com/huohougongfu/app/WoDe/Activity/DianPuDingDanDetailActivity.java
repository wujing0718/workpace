package com.huohougongfu.app.WoDe.Activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ALiPay;
import com.huohougongfu.app.Gson.MyDingDanDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.DingDanZhiFu;
import com.huohougongfu.app.PopupView.QuXiaoDingDan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Adapter.DingDanGuanLiDetailAdapter;
import com.huohougongfu.app.WoDe.Adapter.MyDingDanDetailAdapter;
import com.kongzue.dialog.v2.SelectDialog;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.imkit.RongIM;

public class DianPuDingDanDetailActivity extends AppCompatActivity implements OnClickListener {

    private String orderNo;
    private int id,orderStatus;
    private TextView tv_shouhuo_name,tv_shouhuo_phone,tv_shouhuo_address,tv_orderNo,tv_logisticsFee,tv_orderAmountTotal,tv_payTime
            ,tv_createTime,tv_serviceRegulations,tv_order_AmountTotal;
    private RecyclerView rec_dingdan_detail;
    private ImageView img_dianpu_logo;
    private TextView tv_dianpu_name;
    private TextView tv_dingdan_caozuo2;
    private TextView tv_dingdan_caozuo1;
    private MyDingDanDetail mydongdandetail;
    private int ofManager;
    private TextView tv_remark;
    private TextView tv_kuaidi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_dan_detail);
        id = MyApp.instance.getInt("id");
        orderNo = getIntent().getStringExtra("orderNo");
        orderStatus = getIntent().getIntExtra("orderStatus",0);
        ofManager = getIntent().getIntExtra("ofManager", 0);
        initUI();
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        if (ofManager == 1){
            map.put("ofManager",String.valueOf(ofManager));
        }
        map.put("orderNo",orderNo);
        map.put("createBy",String.valueOf(id));
        OkGo.<String>get(Contacts.URl1 + "order/orderDetailAllByStatus")
                .params(map)
                .execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String body = response.body();
                Gson gson = new Gson();
                mydongdandetail = gson.fromJson(body, MyDingDanDetail.class);
                if (mydongdandetail.getStatus() == 1) {
                    if (mydongdandetail.getResult().size()>0){
                        initView(mydongdandetail.getResult());
                        initRec(mydongdandetail.getResult().get(0));
                    }
                }
            }
        });
    }

    private void initRec(MyDingDanDetail.ResultBean resultBean) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rec_dingdan_detail.setLayoutManager(layoutManager);
        DingDanGuanLiDetailAdapter myDingDanDetailAdapter = new DingDanGuanLiDetailAdapter(R.layout.item_dingdan_liebiao, resultBean.getMallStores().getMallProducts(),orderStatus);
        rec_dingdan_detail.setAdapter(myDingDanDetailAdapter);
        myDingDanDetailAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.tv_shenqingshouhou:
                        if (!utils.isDoubleClick()){
                            Intent intent = new Intent();
                            intent.putExtra("shop",mydongdandetail.getResult().get(0).getMallStores().getMallProducts().get(position));
                            intent.putExtra("orderNo",orderNo);
                            intent.putExtra("orderStatus",orderStatus);
                            intent.setClass(DianPuDingDanDetailActivity.this,ShenQingShouHouActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.tv_pingjia:
                        if (!utils.isDoubleClick()){
                            Intent intent = new Intent();
                            intent.putExtra("shopid",mydongdandetail.getResult().get(0).getMallStores().getMallProducts().get(position).getId());
                            intent.putExtra("storeName",mydongdandetail.getResult().get(0).getMallStores().getStoreName());
                            intent.putExtra("storeLogo",mydongdandetail.getResult().get(0).getMallStores().getStoreLogo());
                            intent.putExtra("OrderNo",mydongdandetail.getResult().get(0).getOrderNo());
                            intent.setClass(DianPuDingDanDetailActivity.this,DingDanPingJiaActivity.class);
                            startActivity(intent);
                        }
                        break;
                }

            }
        });
    }
    private void initView(List<MyDingDanDetail.ResultBean> result) {
        tv_remark.setText(result.get(0).getRemark());
        tv_kuaidi.setText(result.get(0).getTransportWay());
        tv_orderNo.setText(result.get(0).getOrderNo());
        tv_createTime.setText(result.get(0).getCreateTimel());
        tv_logisticsFee.setText(String.valueOf(result.get(0).getLogisticsFee()));
        tv_orderAmountTotal.setText("¥"+String.valueOf(result.get(0).getOrderAmountTotal()));
        tv_order_AmountTotal.setText("共计：¥"+String.valueOf(result.get(0).getOrderAmountTotal()));
        tv_payTime.setText(result.get(0).getPayTime());
        tv_serviceRegulations.setText(result.get(0).getServiceRegulations());
        tv_shouhuo_name.setText(result.get(0).getReceiverName());
        tv_shouhuo_phone.setText(result.get(0).getPhone());
        tv_shouhuo_address.setText(result.get(0).getReceiverName()+result.get(0).getAreaName()+result.get(0).getDetailAddr());
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(result.get(0).getMallStores().getStoreLogo()).apply(requestOptions).into(img_dianpu_logo);
        tv_dianpu_name.setText(result.get(0).getMallStores().getStoreName());
    }

    private void initUI() {
        tv_kuaidi = findViewById(R.id.tv_kuaidi);
        tv_remark = findViewById(R.id.tv_remark);
        View view_logistics = findViewById(R.id.view_logistics);
        view_logistics.setOnClickListener(this);
        TextView tv_dingdan_zhuangtai = findViewById(R.id.tv_dingdan_zhuangtai);
        tv_dingdan_caozuo1 = findViewById(R.id.tv_dingdan_caozuo1);
        tv_dingdan_caozuo1.setOnClickListener(this);
        tv_dingdan_caozuo2 = findViewById(R.id.tv_dingdan_caozuo2);
        tv_dingdan_caozuo2.setOnClickListener(this);
        if (orderStatus == 0){
            if (ofManager == 1){
                tv_dingdan_caozuo1.setVisibility(View.GONE);
                tv_dingdan_caozuo2.setText("联系买家");
                view_logistics.setVisibility(View.GONE);
                tv_dingdan_zhuangtai.setText("待付款");
            }else{
                tv_dingdan_caozuo1.setText("取消订单");
                tv_dingdan_caozuo2.setText("确认付款");
                view_logistics.setVisibility(View.GONE);
                tv_dingdan_zhuangtai.setText("待付款");
            }
        }else if (orderStatus == 1){
            tv_dingdan_caozuo1.setText("取消订单");
            tv_dingdan_caozuo2.setText("确认发货");
            tv_dingdan_zhuangtai.setText("待发货");
            view_logistics.setVisibility(View.GONE);
        }else if (orderStatus == 2){
            tv_dingdan_caozuo1.setVisibility(View.GONE);
            tv_dingdan_caozuo2.setVisibility(View.GONE);
            tv_dingdan_zhuangtai.setText("已发货");
            view_logistics.setVisibility(View.VISIBLE);
        }else if (orderStatus == 3){
            tv_dingdan_caozuo1.setVisibility(View.GONE);
            tv_dingdan_caozuo2.setVisibility(View.GONE);
            tv_dingdan_zhuangtai.setText("已评价");
            view_logistics.setVisibility(View.VISIBLE);
        }else if (orderStatus == -2){
            tv_dingdan_caozuo1.setVisibility(View.GONE);
            tv_dingdan_caozuo2.setText("退货中");
            tv_dingdan_zhuangtai.setText("退货中");
            view_logistics.setVisibility(View.VISIBLE);
        }else if (orderStatus == -1){
            tv_dingdan_caozuo1.setVisibility(View.GONE);
            tv_dingdan_caozuo2.setText("退货中");
            tv_dingdan_zhuangtai.setText("退货中");
            view_logistics.setVisibility(View.VISIBLE);
        }else if (orderStatus == -4){
            tv_dingdan_caozuo1.setVisibility(View.GONE);
            tv_dingdan_caozuo2.setText("删除订单");
            tv_dingdan_zhuangtai.setText("已取消");
            view_logistics.setVisibility(View.VISIBLE);
        }else if (orderStatus == 4){
            tv_dingdan_caozuo1.setVisibility(View.GONE);
            tv_dingdan_caozuo2.setVisibility(View.GONE);
        } else if (orderStatus == -5){
            tv_dingdan_caozuo1.setVisibility(View.GONE);
            tv_dingdan_caozuo2.setVisibility(View.GONE);
        }else if (orderStatus == -6){
            tv_dingdan_caozuo1.setVisibility(View.GONE);
            tv_dingdan_caozuo2.setVisibility(View.GONE);
        }
        img_dianpu_logo = findViewById(R.id.img_dianpu_logo);
        tv_dianpu_name = findViewById(R.id.tv_dianpu_name);

         tv_orderNo = findViewById(R.id.tv_orderNo);
         tv_logisticsFee = findViewById(R.id.tv_logisticsFee);
         tv_orderAmountTotal = findViewById(R.id.tv_orderAmountTotal);
        tv_order_AmountTotal = findViewById(R.id.tv_order_AmountTotal);

        tv_payTime = findViewById(R.id.tv_payTime);
         tv_createTime = findViewById(R.id.tv_createTime);
         tv_serviceRegulations = findViewById(R.id.tv_serviceRegulations);


        rec_dingdan_detail = findViewById(R.id.rec_dingdan_detail);
        tv_shouhuo_name = findViewById(R.id.tv_shouhuo_name);
        tv_shouhuo_phone = findViewById(R.id.tv_shouhuo_phone);
        tv_shouhuo_address = findViewById(R.id.tv_shouhuo_address);
        findViewById(R.id.bt_finish).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.bt_fuzhi_dingdanhao).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("复制成功");
                //获取剪贴板管理器：
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 创建普通字符型ClipData
                ClipData mClipData = ClipData.newPlainText("Label", "46695448724845");
                // 将ClipData内容放到系统剪贴板里。
                cm.setPrimaryClip(mClipData);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_dingdan_caozuo2:
                if(orderStatus == -4){
                    //删除订单
                    initDelete(orderNo);
                }else if (orderStatus == 2){
                    initQueRen(orderNo);
                }else if (orderStatus == 0){
                    if (ofManager == 1){
                        RongIM.getInstance().startPrivateChat(DianPuDingDanDetailActivity.this,
                                mydongdandetail.getResult().get(0).getPhone(),mydongdandetail.getResult().get(0).getPhone());
                    }else{
                        initALi(orderNo);
                    }
                }else if (orderStatus == 1){
                    //确认发货
                    Intent intent = new Intent();
                    intent.putExtra("orderNo",orderNo);
                    intent.setClass(DianPuDingDanDetailActivity.this, TianXieWuLiuActivity.class);
                    startActivity(intent);
                }
                break;
                case R.id.tv_dingdan_caozuo1:
                    if (orderStatus == 0){
                        initQuanXiao(orderNo,orderStatus);
                    }else if (orderStatus == 1){
                        initQuanXiao(orderNo,orderStatus);
                    }
                    break;
            case R.id.view_logistics:
                if (!utils.isDoubleClick()){
                    Intent intent = new Intent();
                    intent.putExtra("logisticsName",mydongdandetail.getResult().get(0).getLogisticsName());
                    intent.putExtra("logisticsNo",mydongdandetail.getResult().get(0).getLogisticsNo());
                    intent.setClass(DianPuDingDanDetailActivity.this, WuLiuActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    //支付
    private void initALi(String orderNo) {
        OkGo.<String>post(Contacts.URl1+"apliyConfirmPaymentMoreOrderNo")
                .params("orderNos",orderNo)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        ALiPay aLiPay = new Gson().fromJson(body, ALiPay.class);
                        if (aLiPay.getStatus() == 1){
                            new XPopup.Builder(DianPuDingDanDetailActivity.this)
                                    .asCustom(new DingDanZhiFu(DianPuDingDanDetailActivity.this, aLiPay.getResult().getOrderString(),
                                            aLiPay.getResult().getPriceTotal(),orderNo))
                                    .show();
                        }
                    }
                });
    }
    //  取消订单
    private void initQuanXiao(String orderNo, int orderStatus) {
        new XPopup.Builder(DianPuDingDanDetailActivity.this)
                .asCustom(new QuXiaoDingDan(DianPuDingDanDetailActivity.this,orderStatus,orderNo))
                .show();
    }
    //  删除订单
    private void initDelete(String orderNo) {
        SelectDialog.show(DianPuDingDanDetailActivity.this, "提示", "是否删除订单",
                "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!utils.isDoubleClick()){
                            Map<String,String> map = new HashMap<>();
                            map.put("createBy",String.valueOf(id));
                            map.put("orderNo",orderNo);
                            OkGo.<String>post(Contacts.URl1+"order/deleteOrder")
                                    .params(map)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(Response<String> response) {
                                            String body = response.body();
                                            try {
                                                JSONObject jsonObject = new JSONObject(body);
                                                if (jsonObject.getInt("status") == 1){
                                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                                    finish();
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
                },
                "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
    }

    //  确认订单
    private void initQueRen(String orderNo) {
        SelectDialog.show(DianPuDingDanDetailActivity.this, "提示", "是否确认收货",
                "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!utils.isDoubleClick()){
                            Map<String,String> map = new HashMap<>();
                            map.put("createBy",String.valueOf(id));
                            map.put("orderNo",orderNo);
                            OkGo.<String>post(Contacts.URl1+"order/confirmReciver")
                                    .params(map)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(Response<String> response) {
                                            String body = response.body();
                                            try {
                                                JSONObject jsonObject = new JSONObject(body);
                                                if (jsonObject.getInt("status") == 1){
                                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                                    finish();
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
                },
                "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
    }

}
