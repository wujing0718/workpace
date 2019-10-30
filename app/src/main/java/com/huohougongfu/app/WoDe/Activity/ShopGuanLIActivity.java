package com.huohougongfu.app.WoDe.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Adapter.ShoppingCarAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Fragment.ChaMiNumFragment;
import com.huohougongfu.app.ShouYe.Fragment.ChaYinFragment;
import com.huohougongfu.app.ShouYe.Fragment.ShopQuanFragment;
import com.huohougongfu.app.ShouYe.Fragment.ZhangDanFragment;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.WoDe.Fragment.CangKuFragment;
import com.huohougongfu.app.WoDe.Fragment.YiShangJiaFragment;

import java.util.ArrayList;
import java.util.List;

public class ShopGuanLIActivity extends AppCompatActivity implements View.OnClickListener,IListener {

    private final String[] mTitles = {"已上架", "仓库"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private View bt_guanli;
    private static final int MYLIVE_MODE_CHECK = 0;
    private static final int MYLIVE_MODE_EDIT = 1;
    private int mEditMode = MYLIVE_MODE_CHECK;
    private TextView tv_guanli;
    private boolean editorStatus = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListenerManager.getInstance().registerListtener(this);
        setContentView(R.layout.activity_shop_guan_li);
        bt_guanli = findViewById(R.id.bt_guanli);
        bt_guanli.setOnClickListener(this);
        tv_guanli = findViewById(R.id.tv_guanli);
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
        mFragments.add(YiShangJiaFragment.newInstance(""));
        mFragments.add(CangKuFragment.newInstance(""));
        for (int i = 0;i<mTitles.length;i++){
            mtabtitle.add(mTitles[i]);
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                ListenerManager.getInstance().sendBroadCast(4,"已上架");
                ListenerManager.getInstance().sendBroadCast(4,"仓库");
                tv_guanli.setText("管理");
                editorStatus = true;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        stl.setViewPager(mViewPager);
        stl.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                ListenerManager.getInstance().sendBroadCast(4,"已上架");
                ListenerManager.getInstance().sendBroadCast(4,"仓库");
                tv_guanli.setText("管理");
                editorStatus = true;
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_guanli:
                updataEditMode();
                break;
            case R.id.bt_finish:

                break;
        }
    }
    private void updataEditMode() {
        if (editorStatus) {
            tv_guanli.setText("完成");
            ListenerManager.getInstance().sendBroadCast(4,"已上架");
            ListenerManager.getInstance().sendBroadCast(4,"仓库");
            editorStatus = false;
        } else {
            ListenerManager.getInstance().sendBroadCast(4,"已上架");
            ListenerManager.getInstance().sendBroadCast(4,"仓库");
            tv_guanli.setText("管理");
            editorStatus = true;
//            clearAll();
        }
    }
    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 12){
            if ("已上架".equals(status)){
                tv_guanli.setText("管理");
                editorStatus = true;
            }else{
                tv_guanli.setText("管理");
                editorStatus = true;
            }
        }
    }
}
