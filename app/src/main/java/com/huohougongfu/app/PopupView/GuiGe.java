package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ShopDingDan;
import com.huohougongfu.app.Gson.ShopGuiGe;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.XiaDanActivity;
import com.huohougongfu.app.Utils.AmountView;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Activity.AddressActivity;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private int storeId;
    private int shopid;
    private int standarid;
    private String standard;

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
        amountview.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount1) {
                amount = amount1;
            }
        });
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
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
                    jsonObject.put("productId",mallProduct.getProductInfo().getId());
                    jsonObject.put("storeId",mallProduct.getProductInfo().getStoreId());
                    jsonObject.put("productNum",amount);
                    jsonObject.put("standardId",standarid);
                    jsonObject.put("standard",standard);
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.put(jsonObject);
                    initXiaDan(jsonArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        findViewById(R.id.bt_guanbi).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        Glide.with(MyApp.context).load(mallProduct.getProductInfo().getCoverUrl())
                .apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_guige_photo);
        tv_guige_name.setText(mallProduct.getProductInfo().getName());
        if (mallProduct.getProductStandard() !=null){
            tv_guige_price.setText("¥"+mallProduct.getProductStandard().get(0).getStandardPrice());
        }else{
//            tv_guige_price.setText(mallProduct.);
        }
    }

    private void initXiaDan(JSONArray jsonObject) {
        OkGo.<String>post(Contacts.URl1+"confirmOrder1")
                .params("json",jsonObject.toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        try {
                            JSONObject jsonObject1 = new JSONObject(body);
                            String result = jsonObject1.getString("result");
                            JSONObject result2 = new JSONObject(result);
                            if ("你还未设置地址".equals(result2.getString("defaultAddress"))){
                                SelectDialog.show(context, "提示", "是否前往设置收货地址",
                                        "确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent();
                                                intent.setClass(context, AddressActivity.class);
                                                context.startActivity(intent);
                                            }
                                        },
                                        "取消", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                            }
                                        });
                            }else{
                                Gson gson = new Gson();
                                ShopDingDan shopDingDan = gson.fromJson(body, ShopDingDan.class);
                                if (shopDingDan.getStatus() == 1){
                                    Intent intent = new Intent();
                                    intent.putExtra("订单详情",(Serializable) shopDingDan.getResult());
                                    intent.putExtra("standardId",standarid);
                                    intent.setClass(context,XiaDanActivity.class);
                                    context.startActivity(intent);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(context,"请稍后。。。");
                        super.onStart(request);
                    }
                });
    }

    private void initGouWuChe() {
        shopid = mallProduct.getProductInfo().getId();
        storeId = mallProduct.getProductInfo().getStoreId();
        Map<String,String> map = new HashMap<>();
        map.put("productId",String.valueOf(shopid));
        map.put("storeId",String.valueOf(storeId));
        map.put("productNum",String.valueOf(amount));
        map.put("standardId",String.valueOf(standarid));
        map.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
        OkGo.<String>post(Contacts.URl2+"addCart")
                .params(map)
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(Response<String> response) {
                                    String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                dismiss();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
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
            standarid = mallProduct.getProductStandard().get(0).getId();
            standard = mallProduct.getProductStandard().get(0).getStandard();
            tv_guige_price.setText("¥"+mallProduct.getProductStandard().get(0).getStandardPrice());
        }
        codeBtn.setText( btnContent );
        codeBtn.setPadding(20,6,20,6);
        codeBtn.setGravity( Gravity.CENTER );
        codeBtn.setOnClickListener( new OnClickListener( ) {
            @Override
            public void onClick(View v) {
                standardPrice = mallProduct.getProductStandard().get(id).getStandardPrice();
                standarid = mallProduct.getProductStandard().get(id).getId();
                standard = mallProduct.getProductStandard().get(id).getStandard();
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
