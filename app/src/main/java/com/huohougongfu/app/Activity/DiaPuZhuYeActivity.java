package com.huohougongfu.app.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Fragment.TADianPu;
import com.huohougongfu.app.Fragment.TADongTai;
import com.huohougongfu.app.Gson.MyZhuYe;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiaPuZhuYeActivity extends AppCompatActivity {

    private final String[] mTitles = {"TA的店铺", "TA的动态"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private String mId;
    private String userId;
    private TextView tv_my_name,tv_my_vipnum,tv_my_id,tv_my_guanzhunum,tv_my_fensinum,
            tv_my_jianjie,tv_my_fenlei,tv_my_weizhi;
    private ImageView img_my_touxiang;
    private View view_weizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_pu_zhu_ye);
        int id = MyApp.instance.getInt("id");
        userId = String.valueOf(id);
        mId = getIntent().getStringExtra("id");
        initUI();
        initData();
        initTablayout();
    }

    private void initUI() {
        view_weizhi = findViewById(R.id.view_weizhi);
        img_my_touxiang = findViewById(R.id.img_my_touxiang);
        tv_my_name = findViewById(R.id.tv_my_name);
        tv_my_vipnum = findViewById(R.id.tv_my_vipnum);
        tv_my_id = findViewById(R.id.tv_my_id);
        tv_my_guanzhunum = findViewById(R.id.tv_my_guanzhunum);
        tv_my_fensinum = findViewById(R.id.tv_my_fensinum);
        tv_my_jianjie = findViewById(R.id.tv_my_jianjie);
        tv_my_fenlei = findViewById(R.id.tv_my_fenlei);
        tv_my_weizhi = findViewById(R.id.tv_my_weizhi);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",mId);
        map.put("userId",userId);
        OkGo.<String>post(Contacts.URl1+"/homepage/info")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyZhuYe xinxi = gson.fromJson(body, MyZhuYe.class);
                        if (xinxi.getStatus() == 1){
                            if (xinxi.getResult()!=null){
                                initView(xinxi.getResult());
                            }
                        }
                    }
                });
    }

    private void initView(MyZhuYe.ResultBean result) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(result.getPhoto()).apply(requestOptions).into(img_my_touxiang);
        tv_my_name.setText(result.getNickName());
        tv_my_vipnum.setText("1");

        if (result.getPlace()!=null){
            view_weizhi.setVisibility(View.VISIBLE);
            tv_my_weizhi.setText(result.getPlace());
        }else{
            view_weizhi.setVisibility(View.GONE);
        }
        if (result.getPersonalProfile()!= null){
            tv_my_jianjie.setText(result.getPersonalProfile());
        }else{
            tv_my_jianjie.setText("暂无简介");
        }
        tv_my_guanzhunum.setText(String.valueOf(result.getAttentionNum()));
        tv_my_fensinum.setText(String.valueOf(result.getFanCount()));
        tv_my_fenlei.setText(result.getMaster().getLevel());
    }

    private void initTablayout() {
        mFragments.clear();
        mtabtitle.clear();
        SlidingTabLayout stl = findViewById(R.id.stl);
        ViewPager mViewPager = findViewById(R.id.vp);
        mFragments.add(TADianPu.newInstance(mId));
        mFragments.add(TADongTai.newInstance(mId));
        for (int i = 0;i<mTitles.length;i++){
            mtabtitle.add(mTitles[i]);
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
    }

}
