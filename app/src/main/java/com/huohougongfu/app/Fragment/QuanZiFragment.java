package com.huohougongfu.app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.QuanZi.Fragment.FaXianFragment;
import com.huohougongfu.app.QuanZi.Fragment.GuanZhuFragment;
import com.huohougongfu.app.QuanZi.Fragment.TongChengFragment;
import com.huohougongfu.app.QuanZi.Fragment.XiHuanFragment;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.SouSuoDaShiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoPinPaiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoShopFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuanZiFragment extends Fragment {

    private final String[] mTitles = {"发现", "同城", "关注","喜欢"};
    private final String[] mchannel = {"www", "news", "zhengce","personage"};

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private View inflate;
    public QuanZiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_quan_zi, container, false);
        initTablayout();
        return inflate;
    }

    private void initTablayout() {
        mFragments.clear();
        mtabtitle.clear();
        SlidingTabLayout stl = inflate.findViewById(R.id.stl);
        ViewPager mViewPager = inflate.findViewById(R.id.vp);

//        mFragments.add(TongChengFragment.newInstance("news"));
//        mFragments.add(GuanZhuFragment.newInstance("zhengce"));
//        mFragments.add(XiHuanFragment.newInstance("personage"));
        for (int i = 0;i<mTitles.length;i++){
            mFragments.add(FaXianFragment.newInstance(mchannel[i]));
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
}
