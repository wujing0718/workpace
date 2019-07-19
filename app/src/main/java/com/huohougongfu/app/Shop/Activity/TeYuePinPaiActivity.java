package com.huohougongfu.app.Shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShangPinTuiJianAdapter;
import com.huohougongfu.app.Gson.BannerGson;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.TeYuePingPai;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.PinPaiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeYuePinPaiActivity extends AppCompatActivity {

    private Banner banner;
    private List<Integer> mlist = new ArrayList<>();
    private RecyclerView rec_cainixihuan,rec_quanbupinpai;
    private View head_teyue;
    private List<String> mbanner = new ArrayList<>();
    private List<String> mbannerimg = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_te_yue_pin_pai);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        inituUI();
        initData();
        initbanner();
    }

    private void inituUI() {
        rec_quanbupinpai = findViewById(R.id.rec_quanbupinpai);
        head_teyue = getLayoutInflater().inflate(R.layout.head_teyue, (ViewGroup) rec_quanbupinpai.getParent(), false);
        rec_cainixihuan = head_teyue.findViewById(R.id.rec_cainixihuan);
        banner = head_teyue.findViewById(R.id.banner);

    }

    private void initData() {
        OkGo.<String>get(Contacts.URl2+"query/brand/isSpecial")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        TeYuePingPai shangPinGson = gson.fromJson(response.body(), TeYuePingPai.class);
                        if (shangPinGson.getStatus() == 1) {
                            initRec(shangPinGson.getResult().getIsSpecial());
                            initRec2(shangPinGson.getResult().getResultList());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initbanner() {
//设置指示器位置
        banner.setIndicatorGravity(BannerConfig.CENTER);
        OkGo.<String>get(Contacts.URl1+"/setting/banner/3")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        BannerGson bannergson = gson.fromJson(body, BannerGson.class);
                        if (bannergson.getStatus()==1){
                            if (bannergson.getResult()!=null){
                                mbanner.clear();
                                for (int i = 0;i < bannergson.getResult().size();i++){
                                    mbanner.add(bannergson.getResult().get(i).getPictureUrl());
                                }
                            }
                            initBanner(mbanner);
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        ProgressBar.setVisibility(View.VISIBLE);
                        super.onStart(request);
                    }

                    private void initBanner(List<String> mbanner) {
                        //加载网络图片
                        banner.setImages(mbanner)
                                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                                .setImageLoader(new GlideImageLoader())
                                .start();
                    }
                });

    }

    private void initRec(List<TeYuePingPai.ResultBean.IsSpecialBean> isSpecial) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置RecyclerView 布局
        rec_cainixihuan.setLayoutManager(layoutmanager);
        ShangPinTuiJianAdapter shangPinTuiJianAdapter = new ShangPinTuiJianAdapter(R.layout.item_shop_cainixihuan,isSpecial);
        rec_cainixihuan.setAdapter(shangPinTuiJianAdapter);
    }

    private void initRec2(List<TeYuePingPai.ResultBean.ResultListBean> resultList) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(TeYuePinPaiActivity.this){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        //设置RecyclerView 布局
        rec_quanbupinpai.setLayoutManager(layoutmanager);
        PinPaiAdapter pinPaiItemAdapter = new PinPaiAdapter(R.layout.item_shop_pinpai,resultList);
        pinPaiItemAdapter.addHeaderView(head_teyue);
        rec_quanbupinpai.setAdapter(pinPaiItemAdapter);
    }

}
