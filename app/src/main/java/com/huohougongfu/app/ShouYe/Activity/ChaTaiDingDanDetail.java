package com.huohougongfu.app.ShouYe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.ChaTaiDetailAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class ChaTaiDingDanDetail extends AppCompatActivity implements View.OnClickListener {

    private int teaid;
    private TextView tv_zhifu_zhuangtai,tv_quhuoma,tv_chami_dikou,tv_youhuiquan,tv_xiadan_time;
    private RecyclerView rec_chatai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha_tai_ding_dan_detail);
        teaid = getIntent().getIntExtra("teaid", 0);
        initUI();
        initData();
    }

    private void initUI() {
        tv_zhifu_zhuangtai = findViewById(R.id.tv_zhifu_zhuangtai);
        tv_quhuoma = findViewById(R.id.tv_quhuoma);
        tv_chami_dikou = findViewById(R.id.tv_chami_dikou);
        tv_youhuiquan = findViewById(R.id.tv_youhuiquan);
        tv_xiadan_time = findViewById(R.id.tv_xiadan_time);
        rec_chatai = findViewById(R.id.rec_chatai);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_zhuanzeng_cha).setOnClickListener(this);
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"/machine/teaTable/orderInfo/"+teaid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        com.huohougongfu.app.Gson.ChaTaiDingDanDetail chaTaiDingDanDetail = new Gson().fromJson(body, com.huohougongfu.app.Gson.ChaTaiDingDanDetail.class);
                        if (chaTaiDingDanDetail.getStatus() == 1){
                            initView(chaTaiDingDanDetail.getResult());
                        }
                    }
                });
    }

    private void initView(com.huohougongfu.app.Gson.ChaTaiDingDanDetail.ResultBean result) {
        if (result.getOrderStatus().equals("1")){
            tv_zhifu_zhuangtai.setText("待取货");
            tv_quhuoma.setText(result.getVerificationCode());
            tv_chami_dikou.setText(String.valueOf(result.getTeaRiceNum()));
            if (result.getCoupon()!=null){
                tv_youhuiquan.setText(result.getCoupon().getTitle());
            }else{
                tv_youhuiquan.setText("---");
            }
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            rec_chatai.setLayoutManager(layoutManager);
            ChaTaiDetailAdapter chaTaiDetailAdapter = new ChaTaiDetailAdapter(R.layout.item_dingdanxiangqing_chatai, result.getDetails());
            rec_chatai.setAdapter(chaTaiDetailAdapter);
        }else if (result.getOrderStatus().equals("2")){
            tv_zhifu_zhuangtai.setText("已消费");
        }else if (result.getOrderStatus().equals("0")){
            tv_zhifu_zhuangtai.setText("待支付");
        }
        tv_xiadan_time.setText(result.getCreateTime());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_zhuanzeng_cha:

                break;
        }
    }
}
