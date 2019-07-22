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
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.huohougongfu.app.Activity.DaKaActivity;
import com.huohougongfu.app.Activity.DingWeiActivity;
import com.huohougongfu.app.Activity.LoginActivity;
import com.huohougongfu.app.Gson.AddressBean;
import com.huohougongfu.app.Gson.BannerGson;
import com.huohougongfu.app.Gson.JiQiLieBiao;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.Paocha;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Activity.ChaTaiActivity;
import com.huohougongfu.app.ShouYe.Activity.JiQiAcyivity;
import com.huohougongfu.app.ShouYe.Activity.MyKaBaoActivity;
import com.huohougongfu.app.ShouYe.Activity.PleaseTeaActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.suke.widget.SwitchButton;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.CONTEXT_RESTRICTED;

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

    private String token,id,phone;
    private ImmersionBar mImmersionBar;
    private Fragment currentFragment;
    private String lon,lat;
    private JiQiLieBiao lieiao;
    private TextView tv_jiqijuli,tv_jiqiweizhi;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_home, container, false);
        intent = new Intent();
        lon = MyApp.instance.getString("lon");
        lat = MyApp.instance.getString("lat");
        //设置默认显示内容
        initUI();
        initJiQi();
        return inflate;
    }

    @Override
    public void onResume() {
        //设置定位监听
        initbanner();
        super.onResume();
    }


    private void setDefaultFragment(String equipmentId) {
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, PaoChaFragment.newInstance(equipmentId));
        transaction.commit();
    }

    private void initJiQi() {
        Map<String, String> map = new HashMap<>();
        map.put("longitude",lon);
        map.put("latitude", lat);
        OkGo.<String>post(Contacts.URl1+"/machine/near")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        lieiao = gson.fromJson(response.body(), JiQiLieBiao.class);
                        if (lieiao.getStatus() == 1) {
                            if (lieiao.getResult().size()>0){
                                setDefaultFragment(lieiao.getResult().get(0).getEquipmentId());
                                tv_jiqiweizhi.setText(lieiao.getResult().get(0).getDetailAddress()+"(No."+lieiao.getResult().get(0).getEquipmentId()+")");
                                DecimalFormat formater = new DecimalFormat();
                                formater.setMaximumFractionDigits(2);
                                formater.setGroupingSize(0);
                                formater.setRoundingMode(RoundingMode.FLOOR);
                                String result = formater.format(Double.valueOf(lieiao.getResult().get(0).getDistance()));
                                tv_jiqijuli.setText(result+"m");

                            }
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initUI() {

        amap = inflate.findViewById(R.id.amap);
        tv_jiqijuli = inflate.findViewById(R.id.tv_jiqijuli);
        tv_jiqiweizhi = inflate.findViewById(R.id.tv_jiqiweizhi);

        inflate.findViewById(R.id.bt_pleasetea).setOnClickListener(this);
        inflate.findViewById(R.id.bt_daka).setOnClickListener(this);
        inflate.findViewById(R.id.bt_mykabao).setOnClickListener(this);
        inflate.findViewById(R.id.bt_chatai).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingwei).setOnClickListener(this);
        inflate.findViewById(R.id.bt_xiadan).setOnClickListener(this);

        banner = inflate.findViewById(R.id.banner);
        bt_switch = inflate.findViewById(R.id.bt_switch);
        bt_switch.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {

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
            case R.id.bt_xiadan:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(getContext())
                            .asCustom(new Paocha(getContext()))
                            .show();
                }
                break;
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
                    startActivityForResult(new Intent(getActivity(), DingWeiActivity.class), CONTEXT_RESTRICTED);
                }

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CONTEXT_RESTRICTED){
           JiQiLieBiao.ResultBean jiQiLieBiao =  (JiQiLieBiao.ResultBean)data.getSerializableExtra("data");
           if (jiQiLieBiao!=null){
               DecimalFormat formater = new DecimalFormat();
               formater.setMaximumFractionDigits(2);
               formater.setGroupingSize(0);
               formater.setRoundingMode(RoundingMode.FLOOR);
               String result = formater.format(Double.valueOf(jiQiLieBiao.getDistance()));
               tv_jiqijuli.setText(result+"m");
               tv_jiqiweizhi.setText(jiQiLieBiao.getDetailAddress()+"(No."+jiQiLieBiao.getEquipmentId()+")");

           }
        }
    }
}
