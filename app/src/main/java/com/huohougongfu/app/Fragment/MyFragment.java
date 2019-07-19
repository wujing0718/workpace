package com.huohougongfu.app.Fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Gson.MyZhuYe;
import com.huohougongfu.app.Gson.RongYunUsetInfo;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.MyCollectActivity;
import com.huohougongfu.app.WoDe.Activity.MyDingDanActivity;
import com.huohougongfu.app.WoDe.Activity.MyDongTaiActivity;
import com.huohougongfu.app.WoDe.Activity.SettingActivity;
import com.huohougongfu.app.WoDe.Activity.WoDeFenSiActivity;
import com.huohougongfu.app.WoDe.Activity.WoDeGuanZhuActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.concurrent.CountDownLatch;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private ImageView img_my_touxiang;
    private TextView tv_my_name,tv_my_vipnum,tv_my_id,tv_my_guanzhunum,tv_my_fensinum,
            tv_my_jianjie,tv_my_fenlei,tv_my_weizhi,tv_mydongtai_num;
    private Intent intent;
    private int id;
    private View view_weizhi;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_my, container, false);
        id = MyApp.instance.getInt("id");
        View statusBar = inflate.findViewById(R.id.statusBarView);
        ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
        layoutParams.height = utils.getStatusBarHeight();
        initUI();
        intent = new Intent();
        return inflate;
    }


    @Override
    public void onResume() {
        initData();
        super.onResume();
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"/homepage/info/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyZhuYe xinxi = gson.fromJson(body, MyZhuYe.class);
                        if (xinxi.getStatus() == 1){
                            initView(xinxi.getResult());
                        }
                    }
                });
    }

    private void initView(MyZhuYe.ResultBean result) {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(getActivity()).load(result.getPhoto()).apply(requestOptions).into(img_my_touxiang);
        tv_my_name.setText(result.getNickName());
        tv_my_vipnum.setText("1");

        if (result.getPlace()!=null){
            view_weizhi.setVisibility(View.VISIBLE);
            tv_my_weizhi.setText(result.getPlace());
        }else{
            view_weizhi.setVisibility(View.GONE);
        }
        if (result.getPersonalProfile()!= null){
            tv_my_jianjie.setText(result.getPersonalProfile());
        }else{
            tv_my_jianjie.setText("暂无简介");
        }
        tv_my_guanzhunum.setText(String.valueOf(result.getAttentionNum()));
        tv_my_fensinum.setText(String.valueOf(result.getFanCount()));
        tv_my_fenlei.setText(result.getMaster().getLevel());
        tv_mydongtai_num.setText(String.valueOf(result.getDynamicNum()));
    }

    private void initUI() {
        inflate.findViewById(R.id.bt_setting).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_gouwuche).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_shoucang).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_kabao).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_dianpu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_dongtai).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_quanbu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_huiyuan_quanbu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_xiaoxi).setOnClickListener(this);
        inflate.findViewById(R.id.bt_wodeguanzhu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_wodefensi).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_daifukuan).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_daifahuo).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_daishouhuo).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_pingjia).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_shouhou).setOnClickListener(this);

        inflate.findViewById(R.id.bt_huiyuan_fenxiao).setOnClickListener(this);
        inflate.findViewById(R.id.bt_huiyuan_tuiguang).setOnClickListener(this);
        inflate.findViewById(R.id.bt_huiyuan_kaidian).setOnClickListener(this);

        inflate.findViewById(R.id.bt_gengduo).setOnClickListener(this);

        view_weizhi = inflate.findViewById(R.id.view_weizhi);
        img_my_touxiang = inflate.findViewById(R.id.img_my_touxiang);
        tv_my_name = inflate.findViewById(R.id.tv_my_name);
        tv_my_vipnum = inflate.findViewById(R.id.tv_my_vipnum);
        tv_my_id = inflate.findViewById(R.id.tv_my_id);
        tv_my_guanzhunum = inflate.findViewById(R.id.tv_my_guanzhunum);
        tv_my_fensinum = inflate.findViewById(R.id.tv_my_fensinum);
        tv_my_jianjie = inflate.findViewById(R.id.tv_my_jianjie);
        tv_mydongtai_num = inflate.findViewById(R.id.tv_mydongtai_num);
        tv_my_fenlei = inflate.findViewById(R.id.tv_my_fenlei);
        tv_my_weizhi = inflate.findViewById(R.id.tv_my_weizhi);


    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //设置
            case R.id.bt_setting:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),SettingActivity.class);
                    startActivity(intent);
                }
                break;
                //我的动态
            case R.id.bt_my_dongtai:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),MyDongTaiActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_xiaoxi:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),XiaoXiActivity.class);
                    startActivity(intent);
                }
                break;
                //我的收藏
            case R.id.bt_my_shoucang:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),MyCollectActivity.class);
                    startActivity(intent);
                }
//                RongIM.getInstance().startPrivateChat(getActivity(), "13888888888", "贝吉塔");
                break;
                //我的订单全部
            case R.id.bt_dingdan_quanbu:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),MyDingDanActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_wodeguanzhu:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),WoDeGuanZhuActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_wodefensi:
                if (!utils.isDoubleClick()){
                    intent.setClass(getActivity(),WoDeFenSiActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
