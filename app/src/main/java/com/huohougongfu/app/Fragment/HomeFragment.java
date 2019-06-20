package com.huohougongfu.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.DaKaActivity;
import com.huohougongfu.app.Activity.DingWeiActivity;
import com.huohougongfu.app.Activity.LoginActivity;
import com.huohougongfu.app.Gson.BannerGson;
import com.huohougongfu.app.PopupView.QianDao;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Activity.ChaTaiActivity;
import com.huohougongfu.app.ShouYe.Activity.MyKaBaoActivity;
import com.huohougongfu.app.ShouYe.Activity.PleaseTeaActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.utils;
import com.kyleduo.switchbutton.SwitchButton;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private List<Integer> mlist = new ArrayList<>();
    private List<String> mbanner = new ArrayList<>();
    private Banner banner;
    private SwitchButton bt_switch;
    private Intent intent;
    private MapView amap;
    //定位需要的声明
    private AMapLocationClient mLocationClient = null;//定位发起端
    private AMapLocationClientOption mLocationOption = null;//定位参数
    private LocationSource.OnLocationChangedListener mListener = null;//定位监听器
    boolean isFirstLoc = true;
    private String lat;
    private String lon;


    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_home, container, false);
        intent = new Intent();
        String token = SPUtils.getInstance("登录").getString("token");
        //设置默认显示内容
        setDefaultFragment();
        initUI();
        //设置定位监听
        initbanner();
        return inflate;
    }

    @Override
    public void onResume() {
        initLoc();
        super.onResume();
    }
    //定位
    private void initLoc() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getActivity().getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                        //获取纬度
                        double lat1 = aMapLocation.getLatitude();
                        double lon1 = aMapLocation.getLongitude();//获取经度
                        lat = String.valueOf(lat1);
                        lon = String.valueOf(lon1);
                        if (isFirstLoc) {
                            //获取定位信息
                            StringBuffer buffer = new StringBuffer();
                            buffer.append(aMapLocation.getCountry() + ""
                                    + aMapLocation.getProvince() + ""
                                    + aMapLocation.getCity() + ""
                                    + aMapLocation.getProvince() + ""
                                    + aMapLocation.getDistrict() + ""
                                    + aMapLocation.getStreet() + ""
                                    + aMapLocation.getStreetNum());
                            LogUtils.e(lat+"经纬度"+lon);
                            isFirstLoc = false;
                        }
                    }else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("地图错误","定位失败, 错误码:" + aMapLocation.getErrorCode() + ", 错误信息:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        });
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(true);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, PaoChaFragment.newInstance("主页"));
        transaction.commit();
    }

    private void initUI() {
        amap = inflate.findViewById(R.id.amap);
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
        banner.setIndicatorGravity(BannerConfig.CENTER);
        OkGo.<String>get(Contacts.URl1+"/setting/banner/1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        BannerGson bannergson = gson.fromJson(body, BannerGson.class);
                        if (bannergson.getStatus()==1){
                            if (bannergson.getResult()!=null){
                                mbanner.clear();
                                for (int i = 0;i < bannergson.getResult().size();i++){
                                    mbanner.add(bannergson.getResult().get(i).getPictureUrl());
                                }
                            }
                            initBanner(mbanner);
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        ProgressBar.setVisibility(View.VISIBLE);
                        super.onStart(request);
                    }

                    private void initBanner(List<String> mbanner) {
                        //加载网络图片
                        banner.setImages(mbanner)
                                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                                .setImageLoader(new GlideImageLoader())
                                .start();
                    }
                });
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
                    intent.setClass(getActivity(),DaKaActivity.class);
                    startActivity(intent);
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
