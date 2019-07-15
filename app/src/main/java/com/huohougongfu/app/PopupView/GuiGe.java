package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.Gson.ShopDetail;
import com.huohougongfu.app.Gson.ShopGuiGe;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.AmountView;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GuiGe extends BottomPopupView {
    private ShopGuiGe.ResultBean mallProduct;
    private ImageView img_guige_photo;
    private TextView tv_guige_name,tv_guige_price,tv_guige_kucun;
    private List<String> list=new ArrayList<String>();
    private Context context;
    private RadioGroup gadiogroup;
    private RadioButton button;
    private int standardPrice;
    private AmountView amountview;
    private int amount = 1;

    public GuiGe(@NonNull Context context, ShopGuiGe.ResultBean mallProduct) {
        super(context);
        this.mallProduct = mallProduct;
        this.context = context;
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
        gadiogroup = findViewById(R.id.gadiogroup);
        tv_guige_name = findViewById(R.id.tv_guige_name);
        tv_guige_price = findViewById(R.id.tv_guige_price);
        tv_guige_kucun = findViewById(R.id.tv_guige_kucun);
        amountview = findViewById(R.id.amountview);
        if(mallProduct.getProductStandard()!=null){
            for (int i = 0; i <mallProduct.getProductStandard().size() ; i++) {
                list.add(mallProduct.getProductStandard().get(i).getStandard());
            }
        }else{

        }
        addview(gadiogroup);
        //初始化
        findViewById(R.id.bt_gouwuche).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                initGouWuChe();
            }
        });
        findViewById(R.id.bt_goumai).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.bt_guanbi).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        Picasso.get().load(mallProduct.getProductInfo().getCoverUrl()).into(img_guige_photo);
        tv_guige_name.setText(mallProduct.getProductInfo().getName());
        tv_guige_price.setText("¥"+mallProduct.getProductStandard().get(0).getStandardPrice());
//        tv_guige_kucun.setText(mallProduct.getPrice());
    }

    private void initGouWuChe() {
        amountview.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount1) {
                amount = amount1;
            }
        });
        ToastUtils.showShort(""+amount+standardPrice);
    }

    private void addview(RadioGroup gadiogroup) {
        int index=0;
        for(String ss:list){
            button=new RadioButton(context);
            setRaidBtnAttribute(button,ss,index);
            gadiogroup.addView(button);
            LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) button
                    .getLayoutParams();
            layoutParams.setMargins(20, 0,  20, 0);//4个参数按顺序分别是左上右下
            button.setLayoutParams(layoutParams);
            index++;
        }
    }

    private void setRaidBtnAttribute( final RadioButton codeBtn, String btnContent, int id ){
        if( null == codeBtn ){
            return;
        }
        codeBtn.setBackgroundResource(R.drawable.selector_paocha);
//        codeBtn.setTextColor(this.getResources().getColorStateList(R.drawable.color_radiobutton));
        codeBtn.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));
        //codeBtn.setTextSize( ( textSize > 16 )?textSize:24 );
        codeBtn.setId(id);
        if (id == 0){
            codeBtn.setChecked(true);
            standardPrice = mallProduct.getProductStandard().get(0).getStandardPrice();
            tv_guige_price.setText("¥"+mallProduct.getProductStandard().get(0).getStandardPrice());
        }
        codeBtn.setText( btnContent );
        codeBtn.setPadding(20,6,20,6);
        codeBtn.setGravity( Gravity.CENTER );
        codeBtn.setOnClickListener( new OnClickListener( ) {
            @Override
            public void onClick(View v) {
                standardPrice = mallProduct.getProductStandard().get(id).getStandardPrice();
                tv_guige_price.setText("¥"+mallProduct.getProductStandard().get(id).getStandardPrice());
            }
        });
        //DensityUtilHelps.Dp2Px(this,40)
//        LinearLayout.LayoutParams rlp = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT , LinearLayout.LayoutParams.WRAP_CONTENT);
//        rlp.setMargins(20,0,20,0);
//        codeBtn.setLayoutParams( rlp );
    }

    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext()) * .65f);
    }
}
