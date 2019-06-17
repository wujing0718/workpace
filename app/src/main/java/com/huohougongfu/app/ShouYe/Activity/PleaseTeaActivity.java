package com.huohougongfu.app.ShouYe.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Fragment.SimpleCardFragment;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Fragment.MyKaQuanFragment;
import com.huohougongfu.app.ShouYe.Fragment.RecordFragment;
import com.huohougongfu.app.ShouYe.Fragment.ZhuanZengFragment;

import java.util.ArrayList;
import java.util.List;

public class PleaseTeaActivity extends AppCompatActivity {

    private final String[] mTitles = {"我的卡券", "转增茶米", "历史记录"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_please_tea);
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
        mFragments.add(MyKaQuanFragment.newInstance(""));
        mFragments.add(ZhuanZengFragment.newInstance(""));
        mFragments.add(RecordFragment.newInstance(""));
        for (int i = 0;i<mTitles.length;i++){
            mtabtitle.add(mTitles[i]);
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
    }

}
