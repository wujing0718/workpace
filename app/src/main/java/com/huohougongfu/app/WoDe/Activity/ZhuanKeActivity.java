package com.huohougongfu.app.WoDe.Activity;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Gson.OKGson;
import com.huohougongfu.app.Gson.ZhuanKeVIP;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.SouSuoDaShiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoPinPaiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoShopFragment;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Fragment.ZhuanKeFragment;
import com.kongzue.dialog.v2.MessageDialog;
import com.kongzue.dialog.v2.TipDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

public class ZhuanKeActivity extends AppCompatActivity implements View.OnClickListener{

    private final List<String> mTitles =new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private ImageView img_zhuanke_bg;
    private TextView tv_biaoyu,tv_guize;
    private ZhuanKeVIP zhuanKeVIP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuan_ke);
        img_zhuanke_bg = findViewById(R.id.img_zhuanke_bg);
        tv_biaoyu = findViewById(R.id.tv_biaoyu);
        tv_guize = findViewById(R.id.tv_guize);
        tv_guize.setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initData();
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"earn/earnPage")
                .params("userId",String.valueOf(MyApp.instance.getInt("id")))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        zhuanKeVIP = new Gson().fromJson(body, ZhuanKeVIP.class);
                        if (zhuanKeVIP.getStatus() == 1){
//                            Glide.with(MyApp.context).load(zhuanKeVIP.getResult().getRule().getPicture())
//                                    .apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_zhuanke_bg);
//                            tv_biaoyu.setText(zhuanKeVIP.getResult().getRule().getSlogan());
//                            tv_guize.setText(zhuanKeVIP.getResult().getRule().getRegulation());
                            mTitles.clear();
                            for (int i = 0; i <zhuanKeVIP.getResult().getEarnPordut().size() ; i++) {
                                mTitles.add(zhuanKeVIP.getResult().getEarnPordut().get(i).getName());
                            }
                            initTablayout(zhuanKeVIP.getResult().getEarnPordut());
                        }
                    }
                });
    }

    private void initTablayout(List<ZhuanKeVIP.ResultBean.EarnPordutBean> earnPordut) {
        mFragments.clear();
        SlidingTabLayout stl = findViewById(R.id.stl);
        ViewPager mViewPager = findViewById(R.id.vp);
        for (int i = 0;i<mTitles.size();i++){
            mFragments.add(ZhuanKeFragment.newInstance(earnPordut.get(i)));
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mTitles);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_guize:
                if (null!=zhuanKeVIP && null!=zhuanKeVIP.getResult()){
//                    TipDialog.show(this, , TipDialog.SHOW_TIME_SHORT, TipDialog.TYPE_CUSTOM_DRAWABLE);
                    MessageDialog.show(this, "规则详情", zhuanKeVIP.getResult().getRule().getRegulation(), "取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
//                    ToastUtils.showShort();
                }
                break;
        }
    }
}
