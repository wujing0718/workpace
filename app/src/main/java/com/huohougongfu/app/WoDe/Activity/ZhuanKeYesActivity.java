package com.huohougongfu.app.WoDe.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Gson.ZhuanKeVIP;
import com.huohougongfu.app.R;
import com.huohougongfu.app.WoDe.Fragment.ZhuanKeFragment;
import com.huohougongfu.app.WoDe.Fragment.ZhuanKeYesFragment;

import java.util.ArrayList;
import java.util.List;

public class ZhuanKeYesActivity extends AppCompatActivity {

    private final String[] mTitles =new String[]{"已成交商品","已分享商品"};
    private final String[] status = new String[]{"1","0"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuan_ke_yes);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        for (int i = 0; i < mTitles.length; i++) {
            mtabtitle.add(mTitles[i]);
            mFragments.add(ZhuanKeYesFragment.newInstance(status[i]));
        }
        MyPagerAdapter mAdapter = new MyPagerAdapter(getSupportFragmentManager(), mFragments, mtabtitle);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
    }

}
