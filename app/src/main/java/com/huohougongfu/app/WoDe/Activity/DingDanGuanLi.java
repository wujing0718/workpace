package com.huohougongfu.app.WoDe.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Fragment.HuDongFragment;
import com.huohougongfu.app.Fragment.SiLiaoFragment;
import com.huohougongfu.app.Fragment.XiTongFragment;
import com.huohougongfu.app.R;
import com.huohougongfu.app.WoDe.Fragment.DingDanGuanLiFragment;

import java.util.ArrayList;
import java.util.List;

public class DingDanGuanLi extends AppCompatActivity {

    private final String[] mTitles = {"待发货", "未完成", "已发货","售后"};
    private final String[] status = {"1", "2", "3","4"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_dan_guan_li);
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
            mFragments.add(DingDanGuanLiFragment.newInstance(status[i]));
            mtabtitle.add(mTitles[i]);
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
    }
}
