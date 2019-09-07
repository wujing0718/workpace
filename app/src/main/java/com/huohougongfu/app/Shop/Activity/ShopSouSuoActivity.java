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
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Fragment.ShopFragment;
import com.huohougongfu.app.Fragment.SimpleCardFragment;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.ShangPinFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoDaShiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoPinPaiFragment;
import com.huohougongfu.app.Shop.Fragment.SouSuoShopFragment;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_sou_suo);
        ListenerManager.getInstance().registerListtener(this);
        qBadgeView = new QBadgeView(ShopSouSuoActivity.this);
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
                //记得返回false
                return false;
            }
        });


        findViewById(R.id.bt_gouwuche).setOnClickListener(new View.OnClickListener() {
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
        super.onResume();
        RongIM.getInstance().addUnReadMessageCountChangedObserver(this, conversationTypes);
    }

    private void initTablayout() {
        mFragments.clear();
        mtabtitle.clear();
        SlidingTabLayout stl = findViewById(R.id.stl);
        ViewPager mViewPager = findViewById(R.id.vp);
        mFragments.add(SouSuoShopFragment.newInstance(sousuo));
        mFragments.add(SouSuoPinPaiFragment.newInstance(sousuo));
        mFragments.add(SouSuoDaShiFragment.newInstance(sousuo));
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
