package com.huohougongfu.app.Shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShangPinTuiJianAdapter;
import com.huohougongfu.app.Gson.ShangPinGson;
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
        initData();
        initbanner();
    }
    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("service","App.Mixed_Jinse.Zx");
        map.put("channel", "www");
        OkGo.<String>post(Contacts.URl)
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        ShangPinGson shangPinGson = gson.fromJson(response.body(), ShangPinGson.class);
                        if (shangPinGson.getCode() == 200) {
                            initRec(shangPinGson.getData());
                            initRec2(shangPinGson.getData());
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
        banner = findViewById(R.id.banner);
//设置指示器位置
        banner.setIndicatorGravity(BannerConfig.CENTER);
        Map<String,String> map = new HashMap<>();
//        map.put("channel","wh");
//        OkGo.<String>post(Contacts.bannerurl)
//                .params(map)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        String body = response.body();
//                        Gson gson = new Gson();
//                        BannerGson bannergson = gson.fromJson(body, BannerGson.class);
//                        if (bannergson.getCode()==200){
//                            if (bannergson.getData()!=null){
//                                mlist.clear();
//                                mbannertitle.clear();
//                                for (int i = 0;i < bannergson.getData().size();i++){
//                                    mlist.add(bannergson.getData().get(i).getImg());
//                                    mtaburl.add(bannergson.getData().get(i).getUrl());
//                                    mbannertitle.add(bannergson.getData().get(i).getTitle());
//                                }
//                            }
//                            initBanner(mbannertitle,mlist,mtaburl);
//                        }
//                    }
//
//                    @Override
//                    public void onStart(Request<String, ? extends Request> request) {
////                        ProgressBar.setVisibility(View.VISIBLE);
//                        super.onStart(request);
//                    }

//                    private void initBanner(List<String> mbannertitle, List<String> mlist, List<String> mtaburl) {
        mlist.add(R.mipmap.ic_launcher);
        mlist.add(R.mipmap.ic_launcher);
        mlist.add(R.mipmap.ic_launcher);
        mlist.add(R.mipmap.ic_launcher);
        //加载网络图片
        banner.setImages(mlist)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                if (!utils.isDoubleClick()) {
                    ToastUtils.showShort("Banner"+position);
//                                    Intent intent = new Intent();
//                                    intent.putExtra("id", 3);
//                                    intent.putExtra("collect", 2);
//                                    intent = intent.setClass(getActivity(), DetailActivity.class);
//                                    intent.putExtra("title", mbannertitle.get(position));
//                                    intent.putExtra("url", mtaburl.get(position));
//                                    startActivity(intent);
                }
            }
        });
//                    }
//                });
    }

    private void initRec(ShangPinGson.DataBean data) {
        rec_cainixihuan = findViewById(R.id.rec_cainixihuan);
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置RecyclerView 布局
        rec_cainixihuan.setLayoutManager(layoutmanager);
        ShangPinTuiJianAdapter shangPinTuiJianAdapter = new ShangPinTuiJianAdapter(R.layout.item_shop_cainixihuan,data.getList());
        rec_cainixihuan.setAdapter(shangPinTuiJianAdapter);
    }

    private void initRec2(ShangPinGson.DataBean data) {
        rec_quanbupinpai = findViewById(R.id.rec_quanbupinpai);
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
        PinPaiAdapter pinPaiItemAdapter = new PinPaiAdapter(R.layout.item_shop_pinpai,data.getList());
        rec_quanbupinpai.setAdapter(pinPaiItemAdapter);
    }

}
