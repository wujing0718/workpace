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

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Activity.LoginActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Gson.MyZhuYe;
import com.huohougongfu.app.Gson.OrderStatus;
import com.huohougongfu.app.Gson.RenZhengZhuangTai;
import com.huohougongfu.app.Gson.RongYunUsetInfo;
import com.huohougongfu.app.Gson.VIP;
import com.huohougongfu.app.Gson.WeiDuXiaoXI;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Activity.MyKaBaoActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.FailedViewActivity;
import com.huohougongfu.app.WoDe.Activity.GeRenRenZhengActivity;
import com.huohougongfu.app.WoDe.Activity.MyCollectActivity;
import com.huohougongfu.app.WoDe.Activity.MyDianPuActivity;
import com.huohougongfu.app.WoDe.Activity.MyDingDanActivity;
import com.huohougongfu.app.WoDe.Activity.MyDongTaiActivity;
import com.huohougongfu.app.WoDe.Activity.RealNameActivity;
import com.huohougongfu.app.WoDe.Activity.ReviewViewActivity;
import com.huohougongfu.app.WoDe.Activity.SettingActivity;
import com.huohougongfu.app.WoDe.Activity.VIPActivity;
import com.huohougongfu.app.WoDe.Activity.WeiRenZhengActivity;
import com.huohougongfu.app.WoDe.Activity.WoDeFenSiActivity;
import com.huohougongfu.app.WoDe.Activity.WoDeGuanZhuActivity;
import com.huohougongfu.app.WoDe.Activity.YaoQingActivity;
import com.huohougongfu.app.WoDe.Activity.ZhuanKeActivity;
import com.huohougongfu.app.WoDe.Activity.ZhuanKeYesActivity;
import com.huohougongfu.app.WoDe.Fragment.ZhuanKeYesFragment;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.rong.imkit.RongIM;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imlib.model.Conversation;
import q.rorbin.badgeview.QBadgeView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment implements View.OnClickListener,IUnReadMessageObserver {


    private View inflate;
    private ImageView img_my_touxiang;
    private TextView tv_my_name,tv_my_vipnum,tv_my_id,tv_my_guanzhunum,tv_my_fensinum,
            tv_my_jianjie,tv_my_fenlei,tv_my_weizhi,tv_mydongtai_num;
    private Intent intent;
    private int id;
    private View view_weizhi;
    private MyZhuYe xinxi;
    private RenZhengZhuangTai renZhengZhuangTai;
    private TextView bt_dianpu;
    private ImageView img_ishuiyuan,img_isdianpu,img_ischami,img_isquanxian,img_isfangsaorao,img_iskefu;
    private View view_vip;
    private View bt_xiaoxi;
    final Conversation.ConversationType[] conversationTypes = {
            Conversation.ConversationType.PRIVATE,
            Conversation.ConversationType.GROUP, Conversation.ConversationType.SYSTEM,
            Conversation.ConversationType.PUBLIC_SERVICE, Conversation.ConversationType.APP_PUBLIC_SERVICE
    };
    private QBadgeView qBadgeView;
    private QBadgeView qBadgeView1;
    private QBadgeView qBadgeView2;
    private QBadgeView qBadgeView3;
    private QBadgeView qBadgeView4;
    private QBadgeView qbadgebiewxitong;

    private View bt_my_gouwuche;
    private View bt_dingdan_daifukuan,bt_dingdan_daifahuo,bt_dingdan_daishouhuo;
    private View bt_dingdan_pingjia;
    private String phone;
    private String token;
    private TextView tv_productNum;
    private View view_line;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_my, container, false);
        id = MyApp.instance.getInt("id");
        phone = MyApp.instance.getString("phone");
        token = MyApp.instance.getString("token");
        View statusBar = inflate.findViewById(R.id.statusBarView);
        qBadgeView = new QBadgeView(getActivity());
        qBadgeView1 = new QBadgeView(getActivity());
        qBadgeView2 = new QBadgeView(getActivity());
        qBadgeView3 = new QBadgeView(getActivity());
        qBadgeView4 = new QBadgeView(getActivity());
        qbadgebiewxitong = new QBadgeView(getActivity());
        ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
        layoutParams.height = utils.getStatusBarHeight();
        initUI();
        intent = new Intent();
        return inflate;
    }


    private void initVIP() {
        OkGo.<String>get(Contacts.URl1+"/my/vipInfo/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        VIP vip = gson.fromJson(body, VIP.class);
                        if (vip.getStatus() == 1){
                            //是否VIp
                            if (vip.getResult().isIsVip()){
                                img_ishuiyuan.setImageResource(R.mipmap.img_huiyuan_yes);
                            }else{
                                img_ishuiyuan.setImageResource(R.mipmap.img_huiyuan_no);
                            }
                            //是否是线上店铺
                            if (vip.getResult().isIsMerchant()){
                                img_isdianpu.setImageResource(R.mipmap.img_dianpu_yes);
                            }else{
                                img_isdianpu.setImageResource(R.mipmap.img_dianpu_no);
                            }
                            //茶米福利
                            if (vip.getResult().isTeaRiceWelfare()){
                                img_ischami.setImageResource(R.mipmap.img_chami_yes);
                            }else{
                                img_ischami.setImageResource(R.mipmap.img_chami_no);
                            }
                            if (vip.getResult().isStickyPermissions()){
                                img_isquanxian.setImageResource(R.mipmap.img_zhiding_yes);
                            }else{
                                img_isquanxian.setImageResource(R.mipmap.img_zhiding_no);
                            }
                            if (vip.getResult().isPreventPermissions()){
                                img_isfangsaorao.setImageResource(R.mipmap.img_fangsaorao_yes);
                            }else{
                                img_isfangsaorao.setImageResource(R.mipmap.img_fangsaorao_no);
                            }
                            if (vip.getResult().isCustomerService()){
                                img_iskefu.setImageResource(R.mipmap.img_kefu_yes);
                            }else{
                                img_iskefu.setImageResource(R.mipmap.img_kefu_no);
                            }
                        }
                    }
                });
    }

    private void initRenZheng() {
        OkGo.<String>get(Contacts.URl1+"/my/certificationStatus/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        renZhengZhuangTai = gson.fromJson(body, RenZhengZhuangTai.class);
                    }
                });
    }


    @Override
    public void onResume() {
        initRenZheng();
        initVIP();
        initData();
        initShoppingCartNum();
        initOrderStatusNum();
        initNoticeIsView();
        RongIM.getInstance().addUnReadMessageCountChangedObserver(this, conversationTypes);
        super.onResume();
    }

    private void initNoticeIsView() {
        OkGo.<String>post(Contacts.URl1+"/circle/noticeIsView")
                .params("mId",String.valueOf(MyApp.instance.getInt("id")))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        WeiDuXiaoXI weiduxiaoxi = new Gson().fromJson(body, WeiDuXiaoXI.class);
                        if (weiduxiaoxi.getStatus() == 1){
                            if (weiduxiaoxi.getResult().isComments() || weiduxiaoxi.getResult().isJg() || weiduxiaoxi.getResult().isPraise()){
                                qbadgebiewxitong.bindTarget(bt_xiaoxi).setGravityOffset(8,true).setBadgeText("");
                            }else{
                                qbadgebiewxitong.hide(true);
                            }
                        }
                    }
                });
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(id));
        map.put("userId",String.valueOf(id));
        OkGo.<String>post(Contacts.URl1+"/homepage/info/")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        xinxi = gson.fromJson(body, MyZhuYe.class);
                        if (xinxi.getStatus() == 1){
                            if (xinxi.getResult()!=null){
                                initView(xinxi.getResult());
                            }
                        }
                    }
                });
    }

    private void initShoppingCartNum() {
        OkGo.<String>post(Contacts.URl1+"/cartNum")
                .params("mId",String.valueOf(MyApp.instance.getInt("id")))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                QBadgeView qBadgeView = new QBadgeView(getActivity());
                                qBadgeView.bindTarget(bt_my_gouwuche).setBadgeNumber(jsonObject.getInt("result"));
                                qBadgeView.setShowShadow(false);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initOrderStatusNum() {
        OkGo.<String>post(Contacts.URl1+"/order/orderDetailNumber")
                .params("mId",String.valueOf(MyApp.instance.getInt("id")))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        OrderStatus orderStatus = gson.fromJson(body, OrderStatus.class);
                        if (orderStatus.getStatus() == 1){
                            if (orderStatus.getResult().getNotPayOrder()>0){
                                qBadgeView1.bindTarget(bt_dingdan_daifukuan).setBadgeNumber(orderStatus.getResult().getNotPayOrder());
                            }else{
                                qBadgeView1.hide(true);
                            }
                            if (orderStatus.getResult().getNotDeliverOrder()>0){
                                qBadgeView2.bindTarget(bt_dingdan_daifahuo).setBadgeNumber(orderStatus.getResult().getNotDeliverOrder());
                            }else{
                                qBadgeView2.hide(true);
                            }
                            if (orderStatus.getResult().getWaitingForReceipt()>0){
                                qBadgeView3.bindTarget(bt_dingdan_daishouhuo).setBadgeNumber(orderStatus.getResult().getWaitingForReceipt());
                            }else{
                                qBadgeView3.hide(true);
                            }
                            if (orderStatus.getResult().getWaitingForEvaluation()>0){
                                qBadgeView4.bindTarget(bt_dingdan_pingjia).setBadgeNumber(orderStatus.getResult().getWaitingForEvaluation());
                            }else{
                                qBadgeView4.hide(true);
                            }
                        }
                    }
                });

    }

    private void initView(MyZhuYe.ResultBean result) {
        if (token.isEmpty()){
            view_vip.setVisibility(View.GONE);
            view_line.setVisibility(View.GONE);
        }else{
            view_vip.setVisibility(View.VISIBLE);
        }
        RequestOptions requestOptions = new RequestOptions().circleCrop().placeholder(R.mipmap.img_zhanweitu);
        Glide.with(getActivity()).load(result.getPhoto()).apply(requestOptions).into(img_my_touxiang);
        tv_my_name.setText(result.getNickName());
        if (result.isVip()){
            view_vip.setVisibility(View.VISIBLE);
            tv_my_vipnum.setText("."+result.getMemberLevel());
        }else{
            view_vip.setVisibility(View.GONE);
        }
        if (result.isIsMerchant()){
            bt_dianpu.setVisibility(View.VISIBLE);
        }else{
            bt_dianpu.setVisibility(View.GONE);
        }
        if (result.getPersonalProfile()!= null && !result.getPersonalProfile().isEmpty()){
            tv_my_jianjie.setText(result.getPersonalProfile());
        }else{
            tv_my_jianjie.setText("暂无简介");
        }
        tv_productNum.setText(String.valueOf(result.getProductNum()));
        tv_my_guanzhunum.setText(String.valueOf(result.getAttentionNum()));
        tv_my_fensinum.setText(String.valueOf(result.getFanCount()));
        if (result.getMaster().getLevel()!= null && !result.getMaster().getLevel().isEmpty()){
            tv_my_fenlei.setText(result.getMaster().getLevel());
            view_line.setVisibility(View.VISIBLE);
        }
        if (result.getPlace()!=null && !result.getPlace().isEmpty()){
            view_weizhi.setVisibility(View.VISIBLE);
            tv_my_weizhi.setText(result.getPlace());
        }else{
            view_weizhi.setVisibility(View.GONE);
        }
        tv_mydongtai_num.setText(String.valueOf(result.getDynamicNum()));
    }

    private void initUI() {
        view_line = inflate.findViewById(R.id.view_line);
        tv_productNum = inflate.findViewById(R.id.tv_productNum);
        view_vip = inflate.findViewById(R.id.view_vip);
        img_ishuiyuan = inflate.findViewById(R.id.img_ishuiyuan);
        img_isdianpu = inflate.findViewById(R.id.img_isdianpu);
        img_ischami = inflate.findViewById(R.id.img_ischami);
        img_isquanxian = inflate.findViewById(R.id.img_isquanxian);
        img_isfangsaorao = inflate.findViewById(R.id.img_isfangsaorao);
        img_iskefu = inflate.findViewById(R.id.img_iskefu);
        inflate.findViewById(R.id.bt_xinxi).setOnClickListener(this);
        inflate.findViewById(R.id.bt_setting).setOnClickListener(this);
        bt_my_gouwuche = inflate.findViewById(R.id.bt_my_gouwuche);
        bt_my_gouwuche.setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_shoucang).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_kabao).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_dianpu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_my_dongtai).setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_quanbu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_huiyuan_quanbu).setOnClickListener(this);
        bt_xiaoxi = inflate.findViewById(R.id.bt_xiaoxi);
        bt_xiaoxi.setOnClickListener(this);
        inflate.findViewById(R.id.bt_wodeguanzhu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_wodefensi).setOnClickListener(this);
        bt_dingdan_daifukuan = inflate.findViewById(R.id.bt_dingdan_daifukuan);
        bt_dingdan_daifukuan.setOnClickListener(this);
        bt_dingdan_daifahuo = inflate.findViewById(R.id.bt_dingdan_daifahuo);
        bt_dingdan_daifahuo.setOnClickListener(this);
        bt_dingdan_daishouhuo = inflate.findViewById(R.id.bt_dingdan_daishouhuo);
        bt_dingdan_daishouhuo.setOnClickListener(this);
        bt_dingdan_pingjia = inflate.findViewById(R.id.bt_dingdan_pingjia);
        bt_dingdan_pingjia.setOnClickListener(this);
        inflate.findViewById(R.id.bt_dingdan_shouhou).setOnClickListener(this);
        inflate.findViewById(R.id.bt_zhuanke).setOnClickListener(this);
        inflate.findViewById(R.id.bt_yaoqing).setOnClickListener(this);

        bt_dianpu = inflate.findViewById(R.id.bt_dianpu);
        view_weizhi = inflate.findViewById(R.id.view_weizhi);
        img_my_touxiang = inflate.findViewById(R.id.img_my_touxiang);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(getActivity()).load(R.mipmap.img_zhanweitu).apply(requestOptions).into(img_my_touxiang);
        tv_my_name = inflate.findViewById(R.id.tv_my_name);
        tv_my_vipnum = inflate.findViewById(R.id.tv_my_vipnum);
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            initShoppingCartNum();
            RongIM.getInstance().addUnReadMessageCountChangedObserver(this, conversationTypes);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_dingdan_shouhou:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.putExtra("position",5);
                        intent.setClass(getActivity(),MyDingDanActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_xinxi:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),SettingActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_yaoqing:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),YaoQingActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_dingdan_daifukuan:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.putExtra("position",1);
                        intent.setClass(getActivity(),MyDingDanActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_dingdan_daifahuo:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.putExtra("position",2);
                        intent.setClass(getActivity(),MyDingDanActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_dingdan_daishouhuo:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.putExtra("position",3);
                        intent.setClass(getActivity(),MyDingDanActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_dingdan_pingjia:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.putExtra("position",4);
                        intent.setClass(getActivity(),MyDingDanActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_zhuanke:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        if (xinxi!=null && xinxi.getResult()!=null){
                            if (xinxi.getResult().isZhuanKe()){
                                intent.setClass(getActivity(),ZhuanKeYesActivity.class);
                                startActivity(intent);
                            }else{
                                intent.setClass(getActivity(),ZhuanKeActivity.class);
                                startActivity(intent);
                            }
                        }
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_huiyuan_quanbu:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),VIPActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            //设置
            case R.id.bt_setting:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),SettingActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_my_gouwuche:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),GouWuCheActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_my_dianpu:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        if (null !=xinxi){
                            if (xinxi.getResult()!=null){
                                if (renZhengZhuangTai!=null && renZhengZhuangTai.getResult()!=null){
                                    if (renZhengZhuangTai.getResult().getPerson().getCode() == 2){
                                        intent.setClass(getActivity(),MyDianPuActivity.class);
                                        startActivity(intent);
                                    }else{
                                        intent.setClass(getActivity(),WeiRenZhengActivity.class);
                                        startActivity(intent);
                                    }
                                }
//                            if (xinxi.getResult().isIsMerchant() ==true){
//                                intent.setClass(getActivity(),MyDianPuActivity.class);
//                                startActivity(intent);
//                            }else{
//                                if (renZhengZhuangTai!=null){
//                                    if (renZhengZhuangTai.getStatus() == 1){
//                                        if (renZhengZhuangTai.getResult().getPerson().getCode() == 0) {
//                                            intent.setClass(getActivity(), GeRenRenZhengActivity.class);
//                                            startActivity(intent);
//                                        }else if (renZhengZhuangTai.getResult().getPerson().getCode() == 2){
//                                            if (renZhengZhuangTai.getResult().getStore().getCode() == 3){
//                                                intent.setClass(getActivity(),RealNameActivity.class);
//                                                startActivity(intent);
//                                            }else if (renZhengZhuangTai.getResult().getStore().getCode() == 1){
//                                                intent.setClass(getActivity(),ReviewViewActivity.class);
//                                                startActivity(intent);
//                                            }else if (renZhengZhuangTai.getResult().getStore().getCode() == 2){
//                                                intent.setClass(getActivity(),MyDianPuActivity.class);
//                                                startActivity(intent);
//                                            }else if (renZhengZhuangTai.getResult().getStore().getCode() == 0){
//                                                intent.setClass(getActivity(),FailedViewActivity.class);
//                                                startActivity(intent);
//                                            }
//                                        }
//                                    }
//                                }
//                            }
                            }
                        }
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_my_kabao:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),MyKaBaoActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
                //我的动态
            case R.id.bt_my_dongtai:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),MyDongTaiActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_xiaoxi:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),XiaoXiActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
                //我的收藏
            case R.id.bt_my_shoucang:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),MyCollectActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
                //我的订单全部
            case R.id.bt_dingdan_quanbu:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.putExtra("position",0);
                        intent.setClass(getActivity(),MyDingDanActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_wodeguanzhu:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),WoDeGuanZhuActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.bt_wodefensi:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getActivity(),WoDeFenSiActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                    }
                }
                break;
        }
    }

    @Override
    public void onCountChanged(int i) {
        if(i == 0){
            qbadgebiewxitong.hide(true);
        }else{
            qbadgebiewxitong.bindTarget(bt_xiaoxi).setGravityOffset(8,true).setBadgeText("");
        }
    }
}
