package com.huohougongfu.app.Shop.Fragment;


import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShangPinTuiJianAdapter;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.ShopDetail;
import com.huohougongfu.app.Gson.ShopGuiGe;
import com.huohougongfu.app.Gson.ShopYouHuiQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.FuWu;
import com.huohougongfu.app.PopupView.GuiGe;
import com.huohougongfu.app.PopupView.YouHuiQuan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Adapter.ShopTuiJianAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShangPinFragment extends Fragment implements View.OnClickListener,IListener {


    private View inflate;
    private TextView tv_yuan_price,tv_manjian2,tv_manjian1,tv_detail_price,tv_detail_name,tv_detail_kuaidi
            ,tv_dianpu_name,tv_dianpu_jianjie,tv_detail_xiaoliang,tv_detail_address;
    private RecyclerView rec_shangpin_tuijian;
    private String token,tel,id;
    private int shopid;
    private List<ShopYouHuiQuan.ResultBean> myouhuiquan;
    private List<String> bannerlist = new ArrayList<>();

    private ShopDetail.ResultBean.ProductDetailInfoBean mallProduct;
    private Banner banner;
    private ImageView img_dianp_logo;
    private ShopGuiGe.ResultBean guige;

    public ShangPinFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListenerManager.getInstance().registerListtener(this);
        inflate = inflater.inflate(R.layout.fragment_shang_pin, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        shopid = getArguments().getInt("id");
        initData();
        initUI();
        return inflate;
    }

    //商品详情轮播图
    private void initBanner(ShopDetail.ResultBean.ProductDetailInfoBean mallProduct)  {
        bannerlist.clear();
        String[]  mbanner = mallProduct.getProductPicture().split(",");
        bannerlist.add(mallProduct.getCoverUrl());
        for (int i = 0;i<mbanner.length;i++){
            bannerlist.add(mbanner[i]);
        }
        //加载网络图片
        banner.setImages(bannerlist)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .start();
    }
    /*
        优惠券列表数据
     */
    private void initYouHuiQuan(int storeId) {
            OkGo.<String>get(Contacts.URl2+"/selectCoupon")
                    .params("id",String.valueOf(storeId))
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            Gson gson = new Gson();
                            ShopYouHuiQuan youhuiquan = gson.fromJson(body, ShopYouHuiQuan.class);
                            if (youhuiquan.getStatus() == 1){
                                myouhuiquan = youhuiquan.getResult();
                                if (myouhuiquan.size()>1){
                                    tv_manjian1.setText(myouhuiquan.get(0).getServiceRegulations());
                                    tv_manjian2.setText(myouhuiquan.get(1).getServiceRegulations());
                                }else if(myouhuiquan.size() ==1){
                                    tv_manjian1.setText(myouhuiquan.get(0).getServiceRegulations());
                                }else if (myouhuiquan.size()<0){
                                    tv_manjian1.setText("暂无优惠券");
                                }
                            }
                        }
                    });
    }

    private void initUI() {
        tv_detail_price = inflate.findViewById(R.id.tv_detail_price);
        tv_yuan_price = inflate.findViewById(R.id.tv_yuan_price);
        tv_detail_name = inflate.findViewById(R.id.tv_detail_name);
        tv_detail_kuaidi = inflate.findViewById(R.id.tv_detail_kuaidi);

        img_dianp_logo = inflate.findViewById(R.id.img_dianp_logo);
        tv_dianpu_name = inflate.findViewById(R.id.tv_dianpu_name);
        tv_dianpu_jianjie = inflate.findViewById(R.id.tv_dianpu_jianjie);
        tv_detail_xiaoliang = inflate.findViewById(R.id.tv_detail_xiaoliang);
        tv_detail_address = inflate.findViewById(R.id.tv_detail_address);

        tv_manjian1 = inflate.findViewById(R.id.tv_manjian1);
        tv_manjian2 = inflate.findViewById(R.id.tv_manjian2);
        
        banner = inflate.findViewById(R.id.banner);
        inflate.findViewById(R.id.bt_detail_lingquan).setOnClickListener(this);
        inflate.findViewById(R.id.bt_detail_fuwu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_detail_guige).setOnClickListener(this);
        inflate.findViewById(R.id.bt_jiagouwuche).setOnClickListener(this);

        rec_shangpin_tuijian = inflate.findViewById(R.id.rec_shangpin_tuijian);
        tv_yuan_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG );
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("id",String.valueOf(shopid));
        map.put("token",token);
        map.put("showNum","10");
        OkGo.<String>get(Contacts.URl2+"queryProductDetail")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        ShopDetail shopdetail = gson.fromJson(response.body(), ShopDetail.class);
                        if (shopdetail.getStatus() == 1) {
                             mallProduct = shopdetail.getResult().getProductDetailInfo();
                            initYouHuiQuan(shopdetail.getResult().getProductDetailInfo().getStoreId());
                            initBanner(mallProduct);
                            initRec(shopdetail.getResult().getRecommend());
                            initView(mallProduct);
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
        map.remove("showNum");
        //规格
        OkGo.<String>get(Contacts.URl2+"selectStandardWithProductInfo")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        ShopGuiGe shopdetail = gson.fromJson(response.body(), ShopGuiGe.class);
                        if (shopdetail.getStatus() == 1) {
                            guige = shopdetail.getResult();
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });

    }

    private void initView(ShopDetail.ResultBean.ProductDetailInfoBean mallProduct) {
        tv_detail_price.setText(String.valueOf(mallProduct.getPrice()));
        tv_yuan_price.setText("¥"+String.valueOf(mallProduct.getMarketPrice()));
        tv_detail_kuaidi.setText("快递："+mallProduct.getDefaultTranCost());
        tv_detail_name.setText(mallProduct.getName());
        tv_detail_xiaoliang.setText("销量："+mallProduct.getSellNum());
        tv_detail_address.setText("地址："+mallProduct.getStoreAddress());
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(getActivity()).load(mallProduct.getStoreLogo()).apply(options).into(img_dianp_logo);
        tv_dianpu_name.setText(mallProduct.getStoreName());
        tv_dianpu_jianjie.setText(mallProduct.getStoreBoard());

    }


    private void initRec(List<ShopDetail.ResultBean.RecommendBean> recommendation) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置RecyclerView 布局
        rec_shangpin_tuijian.setLayoutManager(layoutmanager);
        ShopTuiJianAdapter shopTuiJianAdapter = new ShopTuiJianAdapter(R.layout.item_shangpin_tuijian,recommendation);
        rec_shangpin_tuijian.setAdapter(shopTuiJianAdapter);
        shopTuiJianAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("id",recommendation.get(position).getId());
                intent.setClass(getActivity(),ShangPinDetailActivity.class);
                startActivity(intent);
            }
        });

    }

    public static Fragment newInstance(int str){
        ShangPinFragment fragment = new ShangPinFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id",str);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_detail_lingquan:
                if (!utils.isDoubleClick()){
                    if (myouhuiquan!=null){
                        new XPopup.Builder(getContext())
                                .asCustom(new YouHuiQuan(getContext(),myouhuiquan))
                                .show();
                    }else{
                        ToastUtils.showShort("暂无优惠券");
                    }
                }
                break;
            case R.id.bt_detail_fuwu:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(getContext())
                            .asCustom(new FuWu(getContext()))
                            .show();
                }
                break;
            case R.id.bt_detail_guige:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(getContext())
                            .asCustom(new GuiGe(getContext(),guige))
                            .show();
                }
                break;
            case R.id.bt_jiagouwuche:
                if (!utils.isDoubleClick()){
                    JiaRuGouWuChe();
                }
                break;
        }
    }

    private void JiaRuGouWuChe() {
        int storeId = mallProduct.getStoreId();
        Map<String,String> map = new HashMap<>();
        map.put("productId",String.valueOf(shopid));
        map.put("storeId",String.valueOf(storeId));
        map.put("productNum",String.valueOf(3));
        map.put("createBy",id);
        map.put("createBy",id);
        OkGo.<String>post(Contacts.URl1+"")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }
                });
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 0) {
            ToastUtils.showShort(status);
        }
    }
}
