package com.huohougongfu.app.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public  class MyPagerAdapter extends FragmentPagerAdapter {
    Fragment currentFragment;
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragments, List<String> mTitles) {
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

//    @Override
//    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        currentFragment = (Fragment) object;
//        super.setPrimaryItem(container, position, object);
//    }
//    public Fragment getCurrentFragment() {
//        return currentFragment;
//    }
}
