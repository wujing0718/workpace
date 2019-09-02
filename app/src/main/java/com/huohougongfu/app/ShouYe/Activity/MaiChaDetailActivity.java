package com.huohougongfu.app.ShouYe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huohougongfu.app.Gson.MaiChaDetail;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.utils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

public class MaiChaDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private MaiChaDetail.ResultBean resultBean;
    private TextView tv_price;
    private TextView tv_title,tv_name;
    private Banner banner;
    private List<String> mbanner = new ArrayList<>();
    private String equipmentId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mai_cha_detail);
        equipmentId = getIntent().getStringExtra("equipmentId");
        resultBean = (MaiChaDetail.ResultBean)getIntent().getSerializableExtra("买茶");
        initUI();
    }

    private void initUI() {
        mbanner.add(resultBean.getMasterGraph());
        mbanner.add(resultBean.getDetailsFigureOne());
        mbanner.add(resultBean.getDetailsFigureTwo());
        mbanner.add(resultBean.getDetailsFigureThree());
        //设置指示器位置
        banner = findViewById(R.id.banner);
        tv_price = findViewById(R.id.tv_price);
        tv_title = findViewById(R.id.tv_title);
        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(resultBean.getName());
        tv_price.setText(String.valueOf(resultBean.getProductPrice()));
        tv_title.setText(String.valueOf(resultBean.getCommodityDescription()));
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_order).setOnClickListener(this);
        initBanner();
    }

    private void initBanner() {
        banner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR);
//加载网络图片
        banner.setImages(mbanner)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
            case R.id.bt_order:
                Intent intent = new Intent();
                intent.putExtra("买茶",resultBean);
                intent.putExtra("equipmentId",equipmentId);
                intent.setClass(MaiChaDetailActivity.this,MyDingDanPaoChaActivity.class);
                startActivity(intent);
                break;
        }
    }
}
