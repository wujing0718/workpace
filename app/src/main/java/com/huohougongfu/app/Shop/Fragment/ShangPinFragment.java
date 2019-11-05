package com.huohougongfu.app.Shop.Fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.huohougongfu.app.Activity.DiaPuZhuYeActivity;
import com.huohougongfu.app.Gson.ChaTaiYouHuiQuan;
import com.huohougongfu.app.Gson.QuanZiShare;
import com.huohougongfu.app.Gson.ShopDetail;
import com.huohougongfu.app.Gson.ShopFuWuGson;
import com.huohougongfu.app.Gson.ShopGuiGe;
import com.huohougongfu.app.Gson.ShopYouHuiQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.FuWu;
import com.huohougongfu.app.PopupView.GuiGe;
import com.huohougongfu.app.PopupView.YouHuiQuan;
import com.huohougongfu.app.QuanZi.Activity.WenZhangDetailActivity;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Adapter.ShopImageAdapter;
import com.huohougongfu.app.Shop.Adapter.ShopTuiJianAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.imkit.RongIM;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShangPinFragment extends Fragment implements View.OnClickListener,IListener ,UMShareListener {


    private View inflate;
    private TextView tv_yuan_price,tv_manjian2,tv_manjian1,tv_detail_price,tv_detail_name,tv_detail_kuaidi
            ,tv_dianpu_name,tv_dianpu_jianjie,tv_detail_xiaoliang,tv_detail_address,tv_fuwu1,tv_fuwu2;
    private RecyclerView rec_shangpin_tuijian;
    private String token,tel,id;
    private int shopid;
    private List<ShopYouHuiQuan.ResultBean> myouhuiquan;
    private List<String> bannerlist = new ArrayList<>();

    private ShopDetail.ResultBean.ProductDetailInfoBean mallProduct;
    private Banner banner;
    private ImageView img_dianp_logo;
    private ShopGuiGe.ResultBean guige;
    private ShopFuWuGson.ResultBean fuwu;
    private View bt_detail_fuwu;
    private ImageView img_dian_shoucang;
    private TextView tv_dian_shoucang;
    private String 挑选;
    private TextView bt_commission,tv_lijigoumai ;
    private View bt_detail_fenxiang;
    private String commission;
    private View bt_shoucang;
    private View bt_jiagouwuche;
    private ShopDetail shopdetail;
    private RecyclerView rec_shop_detail_photo;
    private List<Object> mlist = new ArrayList<>();
    private ImageView img_dianpu_ditu;
    private String isjingxuan;
    private ShopYouHuiQuan youhuiquan;
    private ShopYouHuiQuan.ResultBean xuanzeyouhuiquan;
    private boolean isgouwuche;
    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    xuanzeyouhuiquan = (ShopYouHuiQuan.ResultBean)msg.obj;
                    tv_manjian1.setText("满"+xuanzeyouhuiquan.getFullMoney()+"减"+xuanzeyouhuiquan.getMoney());
                    tv_manjian2.setText("");
                    break;
                default:
                    break;
            }
        }

    };
    private BasePopupView fuwupopup;
    private View view_caozuo;
    private QuanZiShare share;
    private String type;
    private View bt_goumai;
    private TextView tv_specialNote;
    private TextView tv_guige;
    private String userid;

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
        挑选 = getArguments().getString("挑选");
        commission = getArguments().getString("commission");
        isjingxuan = getArguments().getString("isjingxuan");
        type = getArguments().getString("type");
        userid = getArguments().getString("userid");
        initUI();
        return inflate;
    }

    @Override
    public void onStart() {
        initShopShare();
        initData();
        super.onStart();
    }

    private void initShopShare() {
        Map<String,String> map = new HashMap<>();
        if ("赚客".equals(type)){
            map.put("type","1");
        }
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("productId",String.valueOf(shopid));
        OkGo.<String>post(Contacts.URl1+"showOfMallProduct")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        QuanZiShare quanZiShare = new Gson().fromJson(body, QuanZiShare.class);
                        if (quanZiShare.getStatus() == 1){
                            share = quanZiShare;
                            view_caozuo.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initFuWu(int storeId) {
        OkGo.<String>get(Contacts.URl2+"selectBasicService")
                .params("storeId",String.valueOf(storeId))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ShopFuWuGson fuwu1 = gson.fromJson(body, ShopFuWuGson.class);
                        if (fuwu1.getStatus() == 1){
                            fuwu = fuwu1.getResult();
                            if (fuwu!=null){
                                if (null != getContext()){
                                    fuwupopup = new XPopup.Builder(getContext())
                                            .asCustom(new FuWu(getContext(), fuwu));
                                    initView(mallProduct);
                                }
                            }
                        }
                    }
                });
    }

    //商品详情轮播图
    private void initBanner(ShopDetail.ResultBean.ProductDetailInfoBean mallProduct)  {
        bannerlist.clear();
        String[]  mbanner = mallProduct.getProductPicture().split(",");
        for (int i = 0; i < mbanner.length; i++) {
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
                            youhuiquan = gson.fromJson(body, ShopYouHuiQuan.class);
                            if (youhuiquan.getStatus() == 1){
                                myouhuiquan = youhuiquan.getResult();
                                if (myouhuiquan.size()>1){
                                    tv_manjian1.setText("满"+myouhuiquan.get(0).getFullMoney()+"减"+myouhuiquan.get(0).getMoney());
                                    tv_manjian2.setText("满"+myouhuiquan.get(1).getFullMoney()+"减"+myouhuiquan.get(1).getMoney());
                                }else if(myouhuiquan.size() ==1){
                                    tv_manjian1.setText("满"+myouhuiquan.get(0).getFullMoney()+"减"+myouhuiquan.get(0).getMoney());
                                }else if (myouhuiquan.size()<0){
                                    tv_manjian1.setText("暂无优惠券");
                                }
                            }
                        }
                    });
    }

    private void initUI() {

        tv_guige = inflate.findViewById(R.id.tv_guige);
        tv_specialNote = inflate.findViewById(R.id.tv_specialNote);
        view_caozuo = inflate.findViewById(R.id.view_caozuo);
        img_dianpu_ditu = inflate.findViewById(R.id.img_dianpu_ditu);
        tv_detail_price = inflate.findViewById(R.id.tv_detail_price);
        tv_yuan_price = inflate.findViewById(R.id.tv_yuan_price);
        tv_detail_name = inflate.findViewById(R.id.tv_detail_name);
        tv_detail_kuaidi = inflate.findViewById(R.id.tv_detail_kuaidi);
        img_dianp_logo = inflate.findViewById(R.id.img_dianp_logo);
        tv_dianpu_name = inflate.findViewById(R.id.tv_dianpu_name);
        tv_dianpu_jianjie = inflate.findViewById(R.id.tv_dianpu_jianjie);
        tv_detail_xiaoliang = inflate.findViewById(R.id.tv_detail_xiaoliang);
        tv_detail_address = inflate.findViewById(R.id.tv_detail_address);
        tv_fuwu1 = inflate.findViewById(R.id.tv_fuwu1);
        tv_fuwu2 = inflate.findViewById(R.id.tv_fuwu2);
        rec_shop_detail_photo = inflate.findViewById(R.id.rec_shop_detail_photo);
        tv_lijigoumai = inflate.findViewById(R.id.tv_lijigoumai);
        tv_manjian1 = inflate.findViewById(R.id.tv_manjian1);
        tv_manjian2 = inflate.findViewById(R.id.tv_manjian2);
        bt_detail_fenxiang = inflate.findViewById(R.id.bt_detail_fenxiang);
        bt_detail_fenxiang.setOnClickListener(this);
        bt_goumai = inflate.findViewById(R.id.bt_goumai);
        bt_goumai.setOnClickListener(this);
        img_dian_shoucang = inflate.findViewById(R.id.img_dian_shoucang);
        tv_dian_shoucang = inflate.findViewById(R.id.tv_dian_shoucang);

        banner = inflate.findViewById(R.id.banner);
        inflate.findViewById(R.id.bt_detail_lingquan).setOnClickListener(this);
        inflate.findViewById(R.id.bt_tade_dianpu).setOnClickListener(this);
        bt_detail_fuwu = inflate.findViewById(R.id.bt_detail_fuwu);
        bt_detail_fuwu.setOnClickListener(this);
        bt_shoucang = inflate.findViewById(R.id.bt_shoucang);
        bt_shoucang.setOnClickListener(this);
        inflate.findViewById(R.id.bt_detail_guige).setOnClickListener(this);
        bt_jiagouwuche = inflate.findViewById(R.id.bt_jiagouwuche);
        bt_jiagouwuche.setOnClickListener(this);
        inflate.findViewById(R.id.bt_kefu).setOnClickListener(this);
        bt_commission = inflate.findViewById(R.id.bt_commission);
        rec_shangpin_tuijian = inflate.findViewById(R.id.rec_shangpin_tuijian);
        tv_yuan_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG );

        if ("是".equals(isjingxuan)){
            tv_yuan_price.setVisibility(View.GONE);
        }else{
            tv_yuan_price.setVisibility(View.VISIBLE);
        }
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("id",String.valueOf(shopid));
        map.put("token",token);
        map.put("showNum","10");
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        OkGo.<String>get(Contacts.URl2 + "queryProductDetail")
                .params(map)
                .params("id",shopid)
                .execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                WaitDialog.dismiss();
                Gson gson = new Gson();
                shopdetail = gson.fromJson(response.body(), ShopDetail.class);
                if (shopdetail.getStatus() == 1) {
                    mallProduct = shopdetail.getResult().getProductDetailInfo();
                    initYouHuiQuan(shopdetail.getResult().getProductDetailInfo().getStoreId());
                    initRec(shopdetail.getResult().getRecommend());
                    initRecShopDetail(shopdetail.getResult().getProductDetailInfo().getDetailPic());
                    initFuWu(mallProduct.getStoreId());
                    if (mallProduct != null) {
                        initBanner(mallProduct);
                        initView(mallProduct);
                    }
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
        map.put("id",String.valueOf(shopid));
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

    private void initRecShopDetail(String picture1) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        //设置RecyclerView 布局
        rec_shop_detail_photo.setLayoutManager(layoutmanager);
        if(picture1 !=null){
            mlist.clear();
            String[] split = picture1.split(",");
            rec_shop_detail_photo.setVisibility(View.VISIBLE);
            for (int i = 0; i < split.length; i++) {
                mlist.add(split[i]);
            }
            ShopImageAdapter pingJiaPhotoAdapter = new ShopImageAdapter(mlist);
            rec_shop_detail_photo.setAdapter(pingJiaPhotoAdapter);
        }else{
            rec_shop_detail_photo.setVisibility(View.GONE);
        }
    }

    private void initView(ShopDetail.ResultBean.ProductDetailInfoBean mallProduct) {
        tv_specialNote.setText(mallProduct.getSpecialInstructions());

        if ("赚客".equals(type)){
            tv_yuan_price.setVisibility(View.GONE);
            bt_jiagouwuche.setVisibility(View.GONE);
            tv_lijigoumai.setText("分享赚钱");
            bt_goumai.setVisibility(View.VISIBLE);
            bt_commission.setVisibility(View.VISIBLE);
            bt_detail_fenxiang.setVisibility(View.GONE);
            if(!"null".equals(commission)){
                bt_commission.setText("赚 ¥"+commission);
            }else{
                bt_commission.setText("");
            }
        }else if (挑选!=null){
            bt_commission.setVisibility(View.VISIBLE);
            bt_detail_fenxiang.setVisibility(View.GONE);
            tv_lijigoumai.setText("放入仓库");
            bt_goumai.setVisibility(View.VISIBLE);
            if(!"null".equals(commission)){
                bt_commission.setText("赚 ¥"+commission);
            }else{
                bt_commission.setText("");
            }
            bt_shoucang.setVisibility(View.GONE);
            bt_jiagouwuche.setVisibility(View.GONE);
        }else{
            tv_lijigoumai.setText("立即购买");
            bt_commission.setVisibility(View.GONE);
            bt_shoucang.setVisibility(View.VISIBLE);
            bt_jiagouwuche.setVisibility(View.VISIBLE);
            bt_goumai.setVisibility(View.VISIBLE);
            bt_detail_fenxiang.setVisibility(View.VISIBLE);
        }
        if (mallProduct.getUserId() == Integer.valueOf(id)){
            view_caozuo.setVisibility(View.GONE);
        }else{
            view_caozuo.setVisibility(View.VISIBLE);
        }
        tv_detail_price.setText(String.valueOf(mallProduct.getPrice()));
        tv_yuan_price.setText("¥"+String.valueOf(mallProduct.getMarketPrice()));
        tv_detail_kuaidi.setText("快递："+mallProduct.getDefaultTranCost());
        tv_detail_name.setText(mallProduct.getName());
        tv_detail_xiaoliang.setText("销量："+mallProduct.getSellNum());
        if(mallProduct.getSendAddress()!=null){
            tv_detail_address.setText("地址："+mallProduct.getSendAddress());
        }
        RequestOptions options = new RequestOptions().circleCrop();
        if(getContext()!=null){
            Glide.with(MyApp.context).load(mallProduct.getUserHeadPic()).apply(options).into(img_dianp_logo);
        }
        tv_dianpu_name.setText(mallProduct.getStoreName());
        tv_dianpu_jianjie.setText(mallProduct.getSpecialInstructions());
        Glide.with(MyApp.context).load(mallProduct.getDoorPhoto()).into(img_dianpu_ditu);
        if (mallProduct.getProductCollection()==1){
            tv_dian_shoucang.setText("已收藏");
            img_dian_shoucang.setImageResource(R.mipmap.img_shoucang2);
        }else{
            tv_dian_shoucang.setText("收藏");
            img_dian_shoucang.setImageResource(R.mipmap.img_shoucang);
        }
        if (fuwu!=null){
            bt_detail_fuwu.setVisibility(View.VISIBLE);
            if (fuwu.getBasicService().size()>1){
                tv_fuwu1.setText(fuwu.getBasicService().get(0).getKey());
                tv_fuwu2.setText(fuwu.getBasicService().get(1).getKey());
            }else if (fuwu.getBasicService().size()==1){
                tv_fuwu1.setText(fuwu.getBasicService().get(0).getKey());
            }
        }else{
            bt_detail_fuwu.setVisibility(View.GONE);
        }
        if (guige!=null){
            if (guige.getProductStandard().size()>0){
                tv_guige.setText(guige.getProductStandard().get(0).getStandard());
            }
        }
        if (userid!=null){
            if (!userid.equals(String.valueOf(mallProduct.getUserId()))){
                bt_jiagouwuche.setVisibility(View.GONE);
            }else{
                bt_jiagouwuche.setVisibility(View.VISIBLE);
            }
        }
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

    public static Fragment newInstance(int str, String 挑选, String commission, String isjingxuan, String type,String userid){
        ShangPinFragment fragment = new ShangPinFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id",str);
        bundle.putString("挑选",挑选);
        bundle.putString("commission",commission);
        bundle.putString("isjingxuan",isjingxuan);
        bundle.putString("type",type);
        bundle.putString("userid",userid);
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
                                .asCustom(new YouHuiQuan(getContext(),myouhuiquan,mHandler))
                                .show();
                    }else{
                        ToastUtils.showShort("暂无优惠券");
                    }
                }
                break;
            case R.id.bt_detail_fuwu:
                if (!utils.isDoubleClick()){
                    if (fuwu.getBasicService().size()>0){
                        fuwupopup.show();
                    }else{
                        ToastUtils.showShort("暂无服务");
                    }
                }
                break;
            case R.id.bt_shoucang:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        initShouCang();
                    }else{
                        ToastUtils.showShort("请登录后操作");
                    }
                }
                break;
            case R.id.bt_kefu:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        RongIM.getInstance().startPrivateChat(getActivity(),
                                shopdetail.getResult().getProductDetailInfo().getStorePhone(),shopdetail.getResult().getProductDetailInfo().getStoreName());
                    }else{
                        ToastUtils.showShort("请登录后操作");
                    }
                }
                break;
            case R.id.bt_detail_guige:
                if (!utils.isDoubleClick()){
                    if (mallProduct.getUserId() == Integer.valueOf(id)){
                        ToastUtils.showShort("不能购买自己的商品");
                    }else{
                        if (xuanzeyouhuiquan!=null){
                            XPopup.Builder builder = new XPopup.Builder(getContext());
                            builder.asCustom(new GuiGe(getContext(),guige,xuanzeyouhuiquan,userid))
                                    .show();
                        }else{
                            XPopup.Builder builder = new XPopup.Builder(getContext());
                            builder.asCustom(new GuiGe(getContext(),guige,userid))
                                    .show();
                        }
                    }
                }
                break;
            case R.id.bt_goumai:
                if (!utils.isDoubleClick()){
                    if ("赚客".equals(type)){
                        UMWeb web = new UMWeb(share.getResult().getUrl());//连接地址
                        web.setTitle(share.getResult().getTitle());//标题
                        web.setDescription(share.getResult().getContent());//描述
                        if (share.getResult().getPhoto()!=null) {
                            web.setThumb(new UMImage(getActivity(), share.getResult().getPhoto()));  //网络缩略图
                        } else {
                            web.setThumb(new UMImage(getActivity(), R.mipmap.img_zhanweitu));  //本地缩略图
                        }
                        new ShareAction(getActivity())
                                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,
                                        SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                                .withMedia(web)
                                .setCallback(this).open();
                    }else if (挑选!=null){
                        initAddCangKu();
                    }else{
                        if (!"-1".equals(id)) {
                            if (xuanzeyouhuiquan!=null){
                                XPopup.Builder builder = new XPopup.Builder(getContext());
                                builder.asCustom(new GuiGe(getContext(),guige,xuanzeyouhuiquan,userid))
                                        .show();
                            }else{
                                XPopup.Builder builder = new XPopup.Builder(getContext());
                                builder.asCustom(new GuiGe(getContext(),guige,userid))
                                        .show();
                            }
                        }else{
                            ToastUtils.showShort("请登录后操作");
                        }
                    }
                }
                break;
            case R.id.bt_jiagouwuche:
                if (!utils.isDoubleClick()){
                    if (!"-1".equals(id)) {
                        XPopup.Builder builder = new XPopup.Builder(getContext());
                        builder.asCustom(new GuiGe(getContext(),guige,userid))
                                .show();
                    }else{
                        ToastUtils.showShort("请登录后操作");
                    }
                }
                break;
            case R.id.bt_tade_dianpu:
                if (!utils.isDoubleClick()){
                    Intent intent = new Intent();
                    intent.putExtra("id",String.valueOf(mallProduct.getUserId()));
                    intent.setClass(getActivity(),DiaPuZhuYeActivity.class);
                    startActivity(intent);
                }
                break;

            case R.id.bt_detail_fenxiang:
                if (!utils.isDoubleClick()){
                    UMWeb web = new UMWeb(share.getResult().getUrl());//连接地址
                    web.setTitle(share.getResult().getTitle());//标题
                    web.setDescription(share.getResult().getContent());//描述
                    if (share.getResult().getPhoto()!=null) {
                        web.setThumb(new UMImage(getActivity(), share.getResult().getPhoto()));  //网络缩略图
                    } else {
                        web.setThumb(new UMImage(getActivity(), R.mipmap.img_zhanweitu));  //本地缩略图
                    }
                    new ShareAction(getActivity())
                            .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,
                                    SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                            .withMedia(web)
                            .setCallback(this).open();

                }
                break;
        }
    }

    private void initAddCangKu() {
        Map<String,String> map = new HashMap<>();
        map.put("pid",String.valueOf(shopid));
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        OkGo.<String>post(Contacts.URl1+"productManage/putWarehouse")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                getActivity().finish();
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

    private void initShouCang() {
        Map<String,String> map = new HashMap<>();
        map.put("productId",String.valueOf(shopid));
        map.put("userId",String.valueOf(id));
        OkGo.<String>post(Contacts.URl2+"collectionProduct")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if ("已取消关注".equals(jsonObject.getString("result"))){
                                img_dian_shoucang.setImageResource(R.mipmap.img_shoucang);
                                tv_dian_shoucang.setText("收藏");
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }else if ("商品收藏成功".equals(jsonObject.getString("result"))){
                                img_dian_shoucang.setImageResource(R.mipmap.img_shoucang2);
                                tv_dian_shoucang.setText("已收藏");
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }else if ("再次收藏成功".equals(jsonObject.getString("result"))){
                                img_dian_shoucang.setImageResource(R.mipmap.img_shoucang2);
                                tv_dian_shoucang.setText("已收藏");
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 0) {
        }
    }

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
        ToastUtils.showShort("取消分享");
    }
}
