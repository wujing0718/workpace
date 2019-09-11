package com.huohougongfu.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Activity.LoginActivity;
import com.huohougongfu.app.Activity.MainActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Gson.BannerGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.JingXuanActivity;
import com.huohougongfu.app.QuanZi.Activity.WenZhangActivity;
import com.huohougongfu.app.QuanZi.Activity.ZhaoRenActivity;
import com.huohougongfu.app.QuanZi.Fragment.FaXianFragment;
import com.huohougongfu.app.QuanZi.Fragment.GuanZhuFragment;
import com.huohougongfu.app.QuanZi.Fragment.TongChengFragment;
import com.huohougongfu.app.QuanZi.Fragment.XiHuanFragment;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.SouSuoDaShiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoPinPaiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoShopFragment;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.RongIM;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imlib.model.Conversation;
import q.rorbin.badgeview.QBadgeView;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuanZiFragment extends Fragment implements View.OnClickListener,IListener ,IUnReadMessageObserver {

    private final String[] mTitles = {"发现", "同城", "关注","喜欢"};
//    private final String[] mchannel = {"www", "news", "zhengce","personage"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private View inflate;
    private Intent intent;
    private String citycode;
    private EditText edt_quanzi_sousuo;
    private InputMethodManager manager;
    private TextView tv_city;
    private Banner banner;
    private List<String> mbanner = new ArrayList<>();
    private List<String> mbannerimg = new ArrayList<>();
    final Conversation.ConversationType[] conversationTypes = {
            Conversation.ConversationType.PRIVATE,
            Conversation.ConversationType.GROUP, Conversation.ConversationType.SYSTEM,
            Conversation.ConversationType.PUBLIC_SERVICE, Conversation.ConversationType.APP_PUBLIC_SERVICE
    };
    private QBadgeView qBadgeView;
    private View bt_xiaoxi;
    private String token;

    public QuanZiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListenerManager.getInstance().registerListtener(this);
        inflate = inflater.inflate(R.layout.fragment_quan_zi, container, false);
        View statusBar = inflate.findViewById(R.id.statusBarView);
        qBadgeView = new QBadgeView(getActivity());
        manager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
        ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
        token = MyApp.instance.getString("token");
        banner = inflate.findViewById(R.id.banner);
        layoutParams.height = utils.getStatusBarHeight();
        citycode = MyApp.instance.getString("citycode");
        intent = new Intent();
        tv_city = inflate.findViewById(R.id.tv_city);
        tv_city.setText(MyApp.instance.getString("city"));
        inflate.findViewById(R.id.bt_quanzi_wenzhang).setOnClickListener(this);
        bt_xiaoxi = inflate.findViewById(R.id.bt_xiaoxi);
        bt_xiaoxi.setOnClickListener(this);
        inflate.findViewById(R.id.bt_jingxuan).setOnClickListener(this);
        inflate.findViewById(R.id.bt_quanzi_zhaoren).setOnClickListener(this);
        edt_quanzi_sousuo = inflate.findViewById(R.id.edt_quanzi_sousuo);
        edt_quanzi_sousuo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(edt_quanzi_sousuo.getApplicationWindowToken(), 0);
                    }
                    //自己需要的操作
                    ListenerManager.getInstance().sendBroadCast(3,edt_quanzi_sousuo.getText().toString());
                }
                //记得返回false
                return false;
            }
        });
        initTablayout();
        initbanner();
        return inflate;
    }

    @Override
    public void onResume() {
        super.onResume();
        RongIM.getInstance().addUnReadMessageCountChangedObserver(this, conversationTypes);
    }

    private void initbanner() {
        //设置指示器位置
        banner.setIndicatorGravity(BannerConfig.NOT_INDICATOR);
        OkGo.<String>get(Contacts.URl1+"/setting/banner/3")
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
                                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                                .setImageLoader(new GlideImageLoader())
                                .start();
                    }
                });
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
                    if (!token.isEmpty()){
                        intent.setClass(getContext(),WenZhangActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                        MainActivity.activity.finish();
                    }
                }
            break;
            case R.id.bt_jingxuan:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getContext(),JingXuanActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                        MainActivity.activity.finish();
                    }
                }
                break;
            case R.id.bt_quanzi_zhaoren:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getContext(),ZhaoRenActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                        MainActivity.activity.finish();
                    }
                }
                break;
            case R.id.bt_xiaoxi:
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        intent.setClass(getContext(),XiaoXiActivity.class);
                        startActivity(intent);
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                        intent.setClass(getActivity(),LoginActivity.class);
                        startActivity(intent);
                        MainActivity.activity.finish();
                    }
                }
                break;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            RongIM.getInstance().addUnReadMessageCountChangedObserver(this, conversationTypes);
        }
    }
    @Override
    public void notifyAllActivity(int audience_cnt, String status) {

    }

    @Override
    public void onCountChanged(int i) {
        if(i == 0){
            qBadgeView.hide(true);
        }else{
            qBadgeView.bindTarget(bt_xiaoxi).setBadgeNumber(i);
        }
    }
}
