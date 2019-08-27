package com.huohougongfu.app.WoDe.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.WoDe.Fragment.DingDanFragment;

import java.util.ArrayList;
import java.util.List;

public class MyDingDanActivity extends AppCompatActivity {
    private final String[] mTitles = {"全部", "待付款", "待发货", "待收货", "待评价"};
    private final String[] orderStatus = {"","0", "1", "2", "3"};

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ding_dan);
        position = getIntent().getIntExtra("position", 0);
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
        for (int i = 0;i<mTitles.length;i++){
            mtabtitle.add(mTitles[i]);
            mFragments.add(DingDanFragment.newInstance(orderStatus[i]));
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(position);
        stl.setViewPager(mViewPager);
    }

}
