package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huohougongfu.app.Gson.MyDingDanDetail;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

public class ShenQingShouHouActivity extends AppCompatActivity implements View.OnClickListener {

    private String orderNo;
    private int orderStatus;
    private MyDingDanDetail.ResultBean.MallStoresBean.MallProductsBean bean;
    private TextView tv_shop_title,tv_shop_guige;
    private ImageView img_shop_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shen_qing_shou_hou);
        initUI();
        orderNo = getIntent().getStringExtra("orderNo");
        orderStatus = getIntent().getIntExtra("orderStatus",0);
        bean = (MyDingDanDetail.ResultBean.MallStoresBean.MallProductsBean)getIntent().getSerializableExtra("shop");
        initView();
    }

    private void initUI() {
        img_shop_photo = findViewById(R.id.img_shop_photo);
        tv_shop_title = findViewById(R.id.tv_shop_title);
        tv_shop_guige = findViewById(R.id.tv_shop_guige);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_jintuikuan).setOnClickListener(this);
        findViewById(R.id.bt_tuihuotuikuan).setOnClickListener(this);
    }
    private void initView(){
        Glide.with(ShenQingShouHouActivity.this).load(bean.getCoverUrl()).into(img_shop_photo);
        tv_shop_title.setText(bean.getName());
        tv_shop_guige.setText(bean.getStandard());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_jintuikuan:
                if (!utils.isDoubleClick()){
                    Intent intent = new Intent();
                    intent.putExtra("orderNo",orderNo);
                    intent.putExtra("orderStatus",orderStatus);
                    intent.putExtra("shop",bean);
                    intent.setClass(ShenQingShouHouActivity.this,JinTuiKuanActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_tuihuotuikuan:
                if (!utils.isDoubleClick()){
                        Intent intent = new Intent();
                        intent.putExtra("orderNo",orderNo);
                        intent.putExtra("orderStatus",orderStatus);
                        intent.putExtra("shop",bean);
                        intent.setClass(ShenQingShouHouActivity.this,TuiHuoTuiKuanActivity.class);
                        startActivity(intent);
                }
                break;
        }
    }
}
