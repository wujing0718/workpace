package com.huohougongfu.app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ViewPagerAdapter;
import com.huohougongfu.app.Gson.Machine;
import com.huohougongfu.app.Gson.TeaDetail;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.RotationPageTransformer;
import com.lwj.widget.viewpagerindicator.ViewPagerIndicator;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaoChaFragment extends Fragment {

    private final List<String> mtitles = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private ViewPagerAdapter mAdapter;
    private View inflate;
    private ViewPagerIndicator mViewPagerIndicator;
    private String machineId;

    public PaoChaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shou_ye, container, false);
        machineId = getArguments().getString("ARGS");
        initData();
        return inflate;
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"/machine/info/"+machineId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        Machine machine = gson.fromJson(body, Machine.class);
                        if (machine.getStatus() == 1){
                            if (machine.getResult().size()>0){
                                mtabtitle.clear();
                                mtitles.clear();
                                for (int i = 0; i < machine.getResult().size(); i++) {
                                    TeaDetail teaDetail = gson.fromJson(machine.getResult().get(i), TeaDetail.class);
                                    mtabtitle.add(teaDetail.getTeaName());
                                    String s = machine.getResult().get(i);
                                    mtitles.add(s);
                                }
                                initTablayout();
                            }
                        }
                    }
                });
    }

    private void initTablayout() {
        mFragments.clear();
        mViewPagerIndicator = inflate.findViewById(R.id.indicator_line);
//        SlidingTabLayout stl = inflate.findViewById(R.id.stl);
        ViewPager mViewPager = inflate.findViewById(R.id.vp);
        for (int i = 0;i<mtabtitle.size();i++){
            mFragments.add(SimpleCardFragment.newInstance(mtitles.get(i),machineId));
        }
        if(isAdded()){
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
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        PaoChaFragment fragment = new PaoChaFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
