package com.huohougongfu.app.Shop.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Fragment.ShopFragment;
import com.huohougongfu.app.Fragment.SimpleCardFragment;
import com.huohougongfu.app.Gson.WeiDuXiaoXI;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.ShangPinFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoDaShiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoPinPaiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoShopFragment;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.RongIM;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imlib.model.Conversation;
import q.rorbin.badgeview.QBadgeView;

public class ShopSouSuoActivity extends AppCompatActivity implements IListener,IUnReadMessageObserver {

    private final String[] mTitles = {"商品", "店铺", "大师"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private EditText bt_shop_sousuo;
    private String sousuo;
    private InputMethodManager manager;
    private View bt_kefu;

    private QBadgeView qBadgeView;
    final Conversation.ConversationType[] conversationTypes = {
            Conversation.ConversationType.PRIVATE,
            Conversation.ConversationType.GROUP, Conversation.ConversationType.SYSTEM,
            Conversation.ConversationType.PUBLIC_SERVICE, Conversation.ConversationType.APP_PUBLIC_SERVICE
    };
    private View bt_gouwuche;
    private String type;
    private QBadgeView qbadgebiewxitong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_sou_suo);
        ListenerManager.getInstance().registerListtener(this);
        type = getIntent().getStringExtra("type");
        qBadgeView = new QBadgeView(ShopSouSuoActivity.this);
        qbadgebiewxitong = new QBadgeView(ShopSouSuoActivity.this);
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_shop_sousuo = findViewById(R.id.bt_shop_sousuo);
        bt_shop_sousuo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(bt_shop_sousuo.getApplicationWindowToken(), 0);
                    }
                    //自己需要的操作
                    ListenerManager.getInstance().sendBroadCast(0,bt_shop_sousuo.getText().toString());
                }
                if (bt_shop_sousuo.getText().toString().isEmpty()){
                    ListenerManager.getInstance().sendBroadCast(0,bt_shop_sousuo.getText().toString());
                }
                //记得返回false
                return false;
            }
        });
        bt_gouwuche = findViewById(R.id.bt_gouwuche);
        bt_gouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShopSouSuoActivity.this,GouWuCheActivity.class);
                startActivity(intent);
            }
        });
        bt_kefu = findViewById(R.id.bt_kefu);
        bt_kefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShopSouSuoActivity.this,XiaoXiActivity.class);
                startActivity(intent);
            }
        });
        initTablayout();
    }

    @Override
    protected void onResume() {
        initShoppingCartNum();
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
                                qbadgebiewxitong.bindTarget(bt_kefu).setGravityOffset(8,true).setBadgeText("");
                            }else{
                                qbadgebiewxitong.hide(true);
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
                        QBadgeView qBadgeView = new QBadgeView(ShopSouSuoActivity.this);
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                qBadgeView.bindTarget(bt_gouwuche).setBadgeNumber(jsonObject.getInt("result"));
                            }else{
                                qBadgeView.hide(true);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


    private void initTablayout() {
        mFragments.clear();
        mtabtitle.clear();
        SlidingTabLayout stl = findViewById(R.id.stl);
        ViewPager mViewPager = findViewById(R.id.vp);
        mFragments.add(SouSuoShopFragment.newInstance(sousuo,type));
        mFragments.add(SouSuoPinPaiFragment.newInstance(sousuo,type));
        mFragments.add(SouSuoDaShiFragment.newInstance(sousuo,type));
        for (int i = 0;i<mTitles.length;i++){
            mtabtitle.add(mTitles[i]);
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
        stl.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                bt_shop_sousuo.setText("");
            }

            @Override
            public void onTabReselect(int position) {
                bt_shop_sousuo.setText("");
            }
        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                bt_shop_sousuo.setText("");
                ListenerManager.getInstance().sendBroadCast(0,"");
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {

    }

    @Override
    public void onCountChanged(int i) {
        if(i == 0){
            qBadgeView.hide(true);
        }else{
            qBadgeView.bindTarget(bt_kefu).setBadgeNumber(i);
        }
    }
}
