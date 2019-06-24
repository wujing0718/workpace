package com.huohougongfu.app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.huohougongfu.app.Adapter.ViewPagerAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.RotationPageTransformer;
import com.lwj.widget.viewpagerindicator.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaoChaFragment extends Fragment {

    private final String[] mTitles = {"绿茶", "乌龙茶", "红茶", "白茶", "黄茶", "黑茶", "X茶", "X茶"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private ViewPagerAdapter mAdapter;
    private View inflate;
    private ViewPagerIndicator mViewPagerIndicator;

    public PaoChaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shou_ye, container, false);
        initTablayout();
        return inflate;
    }
        private void initTablayout() {
        mFragments.clear();
        mtabtitle.clear();
        mViewPagerIndicator = inflate.findViewById(R.id.indicator_line);
//        SlidingTabLayout stl = inflate.findViewById(R.id.stl);
        ViewPager mViewPager = inflate.findViewById(R.id.vp);
        for (int i = 0;i<mTitles.length;i++){
            mFragments.add(SimpleCardFragment.newInstance("分类"));
            mtabtitle.add(mTitles[i]);
        }
            mAdapter = new ViewPagerAdapter(getChildFragmentManager(),mFragments);
            mViewPager.setAdapter(mAdapter);
            mViewPager.setPageTransformer(true,new RotationPageTransformer());//设置切换动画
            mViewPager.setOffscreenPageLimit(2);
            mViewPager.setPageMargin(10);//改小间隔
            mViewPagerIndicator.setViewPager(mViewPager);
            inflate.findViewById(R.id.ly).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return mViewPager.dispatchTouchEvent(event); }
            });
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        PaoChaFragment fragment = new PaoChaFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
