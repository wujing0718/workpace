package com.huohougongfu.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.blankj.utilcode.util.ToastUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.huohougongfu.app.Activity.DingWeiActivity;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Adapter.ShangPinAdapter;
import com.huohougongfu.app.PopupView.Paocha;
import com.huohougongfu.app.PopupView.QianDao;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Activity.ChaTaiActivity;
import com.huohougongfu.app.ShouYe.Activity.MyKaBaoActivity;
import com.huohougongfu.app.ShouYe.Activity.PleaseTeaActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.kyleduo.switchbutton.SwitchButton;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private List<Integer> mlist = new ArrayList<>();
    private List<String> mbannertitle = new ArrayList<>();
    private List<String> mtaburl = new ArrayList<>();
    private Banner banner;

    private SwitchButton bt_switch;
    private Intent intent;


    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_home, container, false);
        intent = new Intent();
        //设置默认显示内容
        setDefaultFragment();
        initUI();
        initbanner();
        return inflate;
    }

    private void setDefaultFragment() {
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, PaoChaFragment.newInstance("主页"));
        transaction.commit();
    }

    private void initUI() {
        inflate.findViewById(R.id.bt_pleasetea).setOnClickListener(this);
        inflate.findViewById(R.id.bt_daka).setOnClickListener(this);
        inflate.findViewById(R.id.bt_mykabao).setOnClickListener(this);
        inflate.findViewById(R.id.bt_chatai).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingwei).setOnClickListener(this);

        banner = inflate.findViewById(R.id.banner);
        bt_switch = inflate.findViewById(R.id.bt_switch);
        bt_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    FragmentManager fm = getChildFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.replace(R.id.layFrame, MaiChaFragment.newInstance(""));
                    transaction.commit();
                }else{
                    FragmentManager fm = getChildFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.replace(R.id.layFrame, PaoChaFragment.newInstance(""));
                    transaction.commit();
                }
            }
        });
    }

    private void initbanner() {
        //设置指示器位置
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        Map<String,String> map = new HashMap<>();
//        map.put("channel","wh");
//        OkGo.<String>post(Contacts.bannerurl)
//                .params(map)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        String body = response.body();
//                        Gson gson = new Gson();
//                        BannerGson bannergson = gson.fromJson(body, BannerGson.class);
//                        if (bannergson.getCode()==200){
//                            if (bannergson.getData()!=null){
//                                mlist.clear();
//                                mbannertitle.clear();
//                                for (int i = 0;i < bannergson.getData().size();i++){
//                                    mlist.add(bannergson.getData().get(i).getImg());
//                                    mtaburl.add(bannergson.getData().get(i).getUrl());
//                                    mbannertitle.add(bannergson.getData().get(i).getTitle());
//                                }
//                            }
//                            initBanner(mbannertitle,mlist,mtaburl);
//                        }
//                    }
//
//                    @Override
//                    public void onStart(Request<String, ? extends Request> request) {
////                        ProgressBar.setVisibility(View.VISIBLE);
//                        super.onStart(request);
//                    }

//                    private void initBanner(List<String> mbannertitle, List<String> mlist, List<String> mtaburl) {
        mlist.add(R.mipmap.ic_launcher);
        mlist.add(R.mipmap.ic_launcher);
        mlist.add(R.mipmap.ic_launcher);
        mlist.add(R.mipmap.ic_launcher);
                        //加载网络图片
                        banner.setImages(mlist)
                                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                                .setImageLoader(new GlideImageLoader())
                                .start();
                        banner.setOnBannerListener(new OnBannerListener() {
                            @Override
                            public void OnBannerClick(int position) {
                                if (!utils.isDoubleClick()) {
                                    ToastUtils.showShort("Banner"+position);
//                                    Intent intent = new Intent();
//                                    intent.putExtra("id", 3);
//                                    intent.putExtra("collect", 2);
//                                    intent = intent.setClass(getActivity(), DetailActivity.class);
//                                    intent.putExtra("title", mbannertitle.get(position));
//                                    intent.putExtra("url", mtaburl.get(position));
//                                    startActivity(intent);
                                }
                            }
                        });
//                    }
//                });

    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_pleasetea:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),PleaseTeaActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_daka:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(getContext())
                            .asCustom(new QianDao(getContext()))
                            .show();
                }
                break;
            case R.id.bt_mykabao:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),MyKaBaoActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_chatai:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),ChaTaiActivity.class);
                    startActivity(intent);
                }
            case R.id.bt_dingwei:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),DingWeiActivity.class);
                    startActivity(intent);
                }

        }
    }
}
