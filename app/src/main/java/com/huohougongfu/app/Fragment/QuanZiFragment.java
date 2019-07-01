package com.huohougongfu.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.JingXuanActivity;
import com.huohougongfu.app.QuanZi.Activity.WenZhangActivity;
import com.huohougongfu.app.QuanZi.Fragment.FaXianFragment;
import com.huohougongfu.app.QuanZi.Fragment.GuanZhuFragment;
import com.huohougongfu.app.QuanZi.Fragment.TongChengFragment;
import com.huohougongfu.app.QuanZi.Fragment.XiHuanFragment;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.SouSuoDaShiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoPinPaiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoShopFragment;
import com.huohougongfu.app.Utils.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuanZiFragment extends Fragment implements View.OnClickListener {

    private final String[] mTitles = {"发现", "同城", "关注","喜欢"};
//    private final String[] mchannel = {"www", "news", "zhengce","personage"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private View inflate;
    private Intent intent;
    private String citycode;

    public QuanZiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_quan_zi, container, false);
        View statusBar = inflate.findViewById(R.id.statusBarView);
        ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
        layoutParams.height = utils.getStatusBarHeight();
        citycode = MyApp.instance.getString("citycode");
        intent = new Intent();
        inflate.findViewById(R.id.bt_quanzi_wenzhang).setOnClickListener(this);
        inflate.findViewById(R.id.bt_jingxuan).setOnClickListener(this);
        initTablayout();
        return inflate;
    }

    private void initTablayout() {
        mFragments.clear();
        mtabtitle.clear();
        SlidingTabLayout stl = inflate.findViewById(R.id.stl);
        ViewPager mViewPager = inflate.findViewById(R.id.vp);
        mFragments.add(FaXianFragment.newInstance(""));
        mFragments.add(TongChengFragment.newInstance(citycode));
        mFragments.add(GuanZhuFragment.newInstance("zhengce"));
        mFragments.add(XiHuanFragment.newInstance("personage"));
        for (int i = 0;i<mTitles.length;i++){
            mtabtitle.add(mTitles[i]);
        }
        mAdapter = new MyPagerAdapter(getChildFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        QuanZiFragment fragment = new QuanZiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_quanzi_wenzhang:
                if (!utils.isDoubleClick()){
                    intent.setClass(getContext(),WenZhangActivity.class);
                    startActivity(intent);
                }
            break;
            case R.id.bt_jingxuan:
                if (!utils.isDoubleClick()){
                    intent.setClass(getContext(),JingXuanActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
