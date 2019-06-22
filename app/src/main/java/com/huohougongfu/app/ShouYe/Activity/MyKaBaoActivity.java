package com.huohougongfu.app.ShouYe.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.QuanZi.Fragment.FaXianFragment;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Fragment.ChaMiNumFragment;
import com.huohougongfu.app.ShouYe.Fragment.ChaYinFragment;
import com.huohougongfu.app.ShouYe.Fragment.ShopQuanFragment;
import com.huohougongfu.app.ShouYe.Fragment.ZhangDanFragment;

import java.util.ArrayList;
import java.util.List;

public class MyKaBaoActivity extends AppCompatActivity {

    private final String[] mTitles = {"茶饮券", "商城券", "余额","我的账单"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ka_bao);
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

        mFragments.add(ChaYinFragment.newInstance("news"));
        mFragments.add(ShopQuanFragment.newInstance("zhengce"));
        mFragments.add(ChaMiNumFragment.newInstance("personage"));
        mFragments.add(ZhangDanFragment.newInstance(""));
        for (int i = 0;i<mTitles.length;i++){
            mtabtitle.add(mTitles[i]);
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
    }

}
