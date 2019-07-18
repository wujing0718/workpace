package com.huohougongfu.app.Shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.VibrateUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
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

public class DaShiZhuanChang extends AppCompatActivity {

    private Banner banner;
    private List<Integer> mlist = new ArrayList<>();
    private RecyclerView rec_cainixihuan,rec_dashizhuanchang;
    private EditText bt_dashi_sousuo;
    private View head_dashizhuanchang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_shi_zhuan_chang);
        initUI();
        initData();
        initbanner();
    }

    private void initUI() {
        rec_dashizhuanchang = findViewById(R.id.rec_dashizhuanchang);
        head_dashizhuanchang = getLayoutInflater().inflate(R.layout.head_teyue, (ViewGroup) rec_dashizhuanchang.getParent(), false);
        rec_cainixihuan = head_dashizhuanchang.findViewById(R.id.rec_cainixihuan);
        banner = head_dashizhuanchang.findViewById(R.id.banner);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_dashi_sousuo = findViewById(R.id.bt_dashi_sousuo);
        if (!KeyboardUtils.isSoftInputVisible(this)){
            KeyboardUtils.showSoftInput(this);
        }else{
            KeyboardUtils.hideSoftInput(this);
        }
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
//设置指示器位置
        banner.setIndicatorGravity(BannerConfig.CENTER);
        Map<String,String> map = new HashMap<>();
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
                }
            }
        });
    }

    private void initRec(ShangPinGson.DataBean data) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置RecyclerView 布局
        rec_cainixihuan.setLayoutManager(layoutmanager);
        ShangPinTuiJianAdapter shangPinTuiJianAdapter = new ShangPinTuiJianAdapter(R.layout.item_shop_cainixihuan,data.getList());
        rec_cainixihuan.setAdapter(shangPinTuiJianAdapter);
    }

    private void initRec2(ShangPinGson.DataBean data) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(DaShiZhuanChang.this){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        //设置RecyclerView 布局
        rec_dashizhuanchang.setLayoutManager(layoutmanager);
        ShangPinTuiJianAdapter pinPaiItemAdapter = new ShangPinTuiJianAdapter(R.layout.item_dashizhuanchang,data.getList());
        pinPaiItemAdapter.addHeaderView(head_dashizhuanchang);
        pinPaiItemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.setClass(DaShiZhuanChang.this,DaShiJianJieActivity.class);
                startActivity(intent);
            }
        });
        rec_dashizhuanchang.setAdapter(pinPaiItemAdapter);
    }
}
