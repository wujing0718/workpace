package com.huohougongfu.app.Activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Fragment.HuDongFragment;
import com.huohougongfu.app.Fragment.SiLiaoFragment;
import com.huohougongfu.app.Fragment.XiTongFragment;
import com.huohougongfu.app.Gson.RongYunUsetInfo;
import com.huohougongfu.app.QuanZi.Fragment.FaXianFragment;
import com.huohougongfu.app.QuanZi.Fragment.GuanZhuFragment;
import com.huohougongfu.app.QuanZi.Fragment.TongChengFragment;
import com.huohougongfu.app.QuanZi.Fragment.XiHuanFragment;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;

public class XiaoXiActivity extends AppCompatActivity {

    private final String[] mTitles = {"私聊", "互动", "系统"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao_xi);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initTablayout();
    }

    private void initTablayout() {
        mFragments.clear();
        mtabtitle.clear();
        SlidingTabLayout stl = findViewById(R.id.stl);
        ViewPager mViewPager = findViewById(R.id.vp);
        mFragments.add(SiLiaoFragment.newInstance(""));
        mFragments.add(HuDongFragment.newInstance(""));
        mFragments.add(XiTongFragment.newInstance("zhengce"));
        for (int i = 0;i<mTitles.length;i++){
            mtabtitle.add(mTitles[i]);
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
    }

}
