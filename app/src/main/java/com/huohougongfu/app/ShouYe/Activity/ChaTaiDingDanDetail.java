package com.huohougongfu.app.ShouYe.Activity;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.ChaTaiZhiFu;
import com.huohougongfu.app.PopupView.PopupDingDan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.ChaTaiDetailAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChaTaiDingDanDetail extends AppCompatActivity implements View.OnClickListener {

    private int orderNo;
    private TextView tv_zhifu_zhuangtai,tv_quhuoma,tv_chami_dikou,tv_youhuiquan,tv_xiadan_time;
    private RecyclerView rec_chatai;
    private TextView bt_queding;
    private long time;
    private CountDownTimer timer;
    private TextView tv_orderTotal;
    private TextView tv_tea_num;
    private com.huohougongfu.app.Gson.ChaTaiDingDanDetail chaTaiDingDanDetail;
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {

        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {

        }
    };
    private int type;
    private View item_dingdanxiangqing_chatai;
    private TextView tv_cha_name,tv_cha_content,tv_cha_num,tv_cha_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha_tai_ding_dan_detail);
        orderNo = getIntent().getIntExtra("orderNo", 0);
        type = getIntent().getIntExtra("type", 0);
        initUI();
        initData();
    }


    @SuppressLint("CutPasteId")
    private void initUI() {
        item_dingdanxiangqing_chatai = findViewById(R.id.item_dingdanxiangqing_chatai);
        tv_cha_name = item_dingdanxiangqing_chatai.findViewById(R.id.tv_cha_name);
        tv_cha_content = item_dingdanxiangqing_chatai.findViewById(R.id.tv_cha_content);
        tv_cha_num = item_dingdanxiangqing_chatai.findViewById(R.id.tv_cha_num);
        tv_cha_price = item_dingdanxiangqing_chatai.findViewById(R.id.tv_cha_price);
        tv_zhifu_zhuangtai = findViewById(R.id.tv_zhifu_zhuangtai);
        tv_quhuoma = findViewById(R.id.tv_quhuoma);
        tv_chami_dikou = findViewById(R.id.tv_chami_dikou);
        tv_youhuiquan = findViewById(R.id.tv_youhuiquan);
        tv_xiadan_time = findViewById(R.id.tv_xiadan_time);
        rec_chatai = findViewById(R.id.rec_chatai);
        bt_queding = findViewById(R.id.bt_queding);
        tv_orderTotal = findViewById(R.id.tv_orderTotal);
        tv_tea_num = findViewById(R.id.tv_tea_num);
        bt_queding.setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_zhuanzeng_cha).setOnClickListener(this);
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"/machine/teaTable/orderInfo/"+orderNo)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                       chaTaiDingDanDetail =
                                new Gson().fromJson(body, com.huohougongfu.app.Gson.ChaTaiDingDanDetail.class);
                        if (chaTaiDingDanDetail.getStatus() == 1){
                            initView(chaTaiDingDanDetail.getResult());
                        }
                    }
                });
    }

    private void initView(com.huohougongfu.app.Gson.ChaTaiDingDanDetail.ResultBean result) {
        String nowTime = utils.getNowTime();
        String s = utils.dateToStamp(nowTime);
        String createTime = result.getCreateTime();
        String s1 = utils.dateToStamp2(createTime);
        long aLong = Long.valueOf(s);
        long aLong1 = Long.valueOf(s1);
        long q = (aLong1+900) - aLong;
        if ("0".equals(result.getOrderStatus())){
            tv_zhifu_zhuangtai.setTextColor(MyApp.context.getResources().getColor(R.color.colorRed));
            tv_zhifu_zhuangtai.setText("待支付");
            bt_queding.setText("确认支付");
            bt_queding.setVisibility(View.VISIBLE);
            if (q>0){
                time = q;
                timer = new CountDownTimer(time * 1000, 1000) {
                    /**
                     * 固定间隔被调用,就是每隔countDownInterval会回调一次方法onTick
                     * @param millisUntilFinished
                     */
                    @Override
                    public void onTick(long millisUntilFinished) {
                        tv_zhifu_zhuangtai.setTextColor(MyApp.context.getResources().getColor(R.color.colorRed));
//                                tv_chatai_orderStatus.setText("待支付："+utils.formatTime(millisUntilFinished));
                        tv_zhifu_zhuangtai.setText("待支付");

                    }

                    /**
                     * 倒计时完成时被调用
                     */
                    @Override
                    public void onFinish() {
                        tv_zhifu_zhuangtai.setTextColor(MyApp.context.getResources().getColor(R.color.colorBlack));
                        tv_zhifu_zhuangtai.setText("已过期");
                    }
                }.start();
                //将此 countDownTimer 放入list.
            }else{
                bt_queding.setText("删除订单");
                tv_zhifu_zhuangtai.setText("已过期");
                tv_zhifu_zhuangtai.setTextColor(MyApp.context.getResources().getColor(R.color.colorBlack));
            }
        }else if ("1".equals(result.getOrderStatus())){
            tv_zhifu_zhuangtai.setText("待提货");
            bt_queding.setText("待提货");
        }else if ("2".equals(result.getOrderStatus())){
            bt_queding.setText("删除订单");
            tv_zhifu_zhuangtai.setText("已消费");
        }
        if (result.getOrderStatus().equals("1")){
            tv_zhifu_zhuangtai.setText("待取货");
            tv_quhuoma.setText(result.getVerificationCode());
            tv_chami_dikou.setText(String.valueOf(result.getTeaRiceNum()));
            if (result.getCoupon()!=null){
                tv_youhuiquan.setText(result.getCoupon().getTitle());
            }else{
                tv_youhuiquan.setText("---");
            }

        }else if (result.getOrderStatus().equals("2")){
            tv_zhifu_zhuangtai.setText("已消费");
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rec_chatai.setLayoutManager(layoutManager);
        if (result.getType() == 1){
            rec_chatai.setVisibility(View.VISIBLE);
            ChaTaiDetailAdapter chaTaiDetailAdapter = new ChaTaiDetailAdapter(R.layout.item_dingdanxiangqing_chatai, result.getDetails());
            rec_chatai.setAdapter(chaTaiDetailAdapter);
        }else if (result.getType() == 2){
            com.huohougongfu.app.Gson.ChaTaiDingDanDetail.ResultBean.MachineProductBean machineProduct = result.getMachineProduct();
            rec_chatai.setVisibility(View.GONE);
            item_dingdanxiangqing_chatai.setVisibility(View.VISIBLE);
            tv_cha_name.setText(machineProduct.getName());
            tv_cha_content.setText(machineProduct.getCommodityDescription());
            tv_cha_num.setText("X"+1);
            tv_cha_price.setText("￥"+machineProduct.getProductPrice());
        }
        tv_xiadan_time.setText("下单时间"+result.getCreateTime());
        tv_orderTotal.setText("¥"+result.getOrderTotal());
        tv_tea_num.setText("共"+result.getDetails().size()+"件");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_zhuanzeng_cha:
                String zhuangtai = tv_zhifu_zhuangtai.getText().toString();
                if (!utils.isDoubleClick()){
                    if ("0".equals(chaTaiDingDanDetail.getResult().getOrderStatus())){
                        if ("已过期".equals(zhuangtai)){
                            ToastUtils.showShort("订单已过期");
                        }else{
                            ToastUtils.showShort("订单未支付");
                        }
                    }else if ("1".equals(chaTaiDingDanDetail.getResult().getOrderStatus())){
                            new XPopup.Builder(this)
                                    .asCustom(new PopupDingDan(this,ChaTaiDingDanDetail.this,chaTaiDingDanDetail.getResult().getId()))
                                    .show();

                    }else if ("2".equals(chaTaiDingDanDetail.getResult().getOrderStatus())){
                        ToastUtils.showShort("已消费");
                    }
                }
                break;
            case R.id.bt_queding:
                if (bt_queding.getText().toString().equals("删除订单")){
                    initDelect(chaTaiDingDanDetail.getResult().getId());
                }else if (bt_queding.getText().toString().equals("确认支付")){
                    new XPopup.Builder(ChaTaiDingDanDetail.this)
                            .asCustom(new ChaTaiZhiFu(ChaTaiDingDanDetail.this,chaTaiDingDanDetail.getResult().getOrderNo(),chaTaiDingDanDetail.getResult().getOrderTotal()))
                            .show();
                }
                break;
        }
    }
    private void initDelect(int id) {
        OkGo.<String>get(Contacts.URl1+"/machine/delMachineOrder/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                finish();
                                ToastUtils.showShort(jsonObject.getString("msg"));
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
