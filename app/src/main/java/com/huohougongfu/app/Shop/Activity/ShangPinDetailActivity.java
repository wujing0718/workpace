package com.huohougongfu.app.Shop.Activity;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Fragment.SimpleCardFragment;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.CanShuFragment;
import com.huohougongfu.app.Shop.Fragment.PingJiaFragment;
import com.huohougongfu.app.Shop.Fragment.ShangPinFragment;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShangPinDetailActivity extends AppCompatActivity {

    private final String[] mTitles = {"商品", "参数", "评价"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private int shopid;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shang_pin_detail);
        shopid = getIntent().getIntExtra("id", 0);
        intent = new Intent();
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.bt_gouwuche).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!utils.isDoubleClick()){
                    intent.setClass(ShangPinDetailActivity.this,GouWuCheActivity.class);
                    startActivity(intent);
                }
            }
        });

        initTablayout();
    }

    private void initTablayout() {
        mFragments.clear();
        mtabtitle.clear();
        SlidingTabLayout stl = findViewById(R.id.stl);
        ViewPager mViewPager = findViewById(R.id.vp);
        mFragments.add(ShangPinFragment.newInstance(shopid));
        mFragments.add(CanShuFragment.newInstance(shopid));
        mFragments.add(PingJiaFragment.newInstance(shopid));
        for (int i = 0;i<mTitles.length;i++){
            mtabtitle.add(mTitles[i]);
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
    }
}
