package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huohougongfu.app.Gson.ShopDetail;
import com.huohougongfu.app.R;
import com.lxj.xpopup.core.BottomPopupView;
import com.squareup.picasso.Picasso;

public class GuiGe extends BottomPopupView {
    private ShopDetail.ResultBean.MallProductBean mallProduct;
    private ImageView img_guige_photo;
    private TextView tv_guige_name,tv_guige_price,tv_guige_kucun;

    public GuiGe(@NonNull Context context, ShopDetail.ResultBean.MallProductBean mallProduct) {
        super(context);
        this.mallProduct = mallProduct;
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_detail_guige;
    }
    @Override
    protected void onCreate() {
        super.onCreate();
        initUI();

    }

    private void initUI() {
        img_guige_photo = findViewById(R.id.img_guige_photo);
        tv_guige_name = findViewById(R.id.tv_guige_name);
        tv_guige_price = findViewById(R.id.tv_guige_price);
        tv_guige_kucun = findViewById(R.id.tv_guige_kucun);

        //初始化
        findViewById(R.id.bt_gouwuche).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        findViewById(R.id.bt_goumai).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        findViewById(R.id.bt_guanbi).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        Picasso.get().load(mallProduct.getCoverUrl()).into(img_guige_photo);
        tv_guige_name.setText(mallProduct.getName());
        tv_guige_price.setText("¥"+mallProduct.getPrice());
//        tv_guige_kucun.setText(mallProduct.getPrice());
    }
}
