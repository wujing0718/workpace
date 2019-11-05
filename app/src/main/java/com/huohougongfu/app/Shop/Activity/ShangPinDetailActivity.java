package com.huohougongfu.app.Shop.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Fragment.SimpleCardFragment;
import com.huohougongfu.app.Gson.GouWuCheNum;
import com.huohougongfu.app.Gson.ShopYouHuiQuan;
import com.huohougongfu.app.Gson.WeiDuXiaoXI;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Fragment.CanShuFragment;
import com.huohougongfu.app.Shop.Fragment.PingJiaFragment;
import com.huohougongfu.app.Shop.Fragment.ShangPinFragment;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.imkit.RongIM;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imlib.model.Conversation;
import q.rorbin.badgeview.QBadgeView;

public class ShangPinDetailActivity extends AppCompatActivity implements IUnReadMessageObserver ,IListener{

    private final String[] mTitles = {"商品", "参数", "评价"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private int shopid;
    private Intent intent;
    private String 挑选;
    private String commission;
    private String isJingXuan;
    private View bt_xiaoxi;
    private QBadgeView qBadgeView;
    public static ShangPinDetailActivity activity;
    final Conversation.ConversationType[] conversationTypes = {
            Conversation.ConversationType.PRIVATE,
            Conversation.ConversationType.GROUP, Conversation.ConversationType.SYSTEM,
            Conversation.ConversationType.PUBLIC_SERVICE, Conversation.ConversationType.APP_PUBLIC_SERVICE
    };
    private View bt_gouwuche;
    private String type,userid;
    private QBadgeView qbadgebiewxitong;
    private JSONObject jsonObject;
    private GouWuCheNum gouWuCheNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shang_pin_detail);
        activity= this;
        shopid = getIntent().getIntExtra("id", 0);
        挑选 = getIntent().getStringExtra("挑选");
        commission = getIntent().getStringExtra("commission");
        isJingXuan = getIntent().getStringExtra("isJingXuan");
        userid = getIntent().getStringExtra("userid");
        type = getIntent().getStringExtra("type");
        intent = new Intent();
        ListenerManager.getInstance().registerListtener(this);
        qBadgeView = new QBadgeView(ShangPinDetailActivity.this);
        qbadgebiewxitong  = new QBadgeView(ShangPinDetailActivity.this);
        View bt_finish = findViewById(R.id.bt_finish);
        bt_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_gouwuche = findViewById(R.id.bt_gouwuche);
        bt_xiaoxi = findViewById(R.id.bt_xiaoxi);
        bt_xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(ShangPinDetailActivity.this,XiaoXiActivity.class);
                startActivity(intent);
            }
        });
        bt_gouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!utils.isDoubleClick()){
                    intent.setClass(ShangPinDetailActivity.this,GouWuCheActivity.class);
                    startActivity(intent);
                }
            }
        });

        if (挑选!=null){
            bt_gouwuche.setVisibility(View.GONE);
            bt_xiaoxi.setVisibility(View.GONE);
        }

        initTablayout();
    }

    private void initShoppingCartNum() {
        OkGo.<String>post(Contacts.URl1+"/cartNum")
                .params("mId",String.valueOf(MyApp.instance.getInt("id")))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        QBadgeView qBadgeView = new QBadgeView(ShangPinDetailActivity.this);
                        String body = response.body();
                        Gson gson = new Gson();
                        gouWuCheNum = gson.fromJson(body, GouWuCheNum.class);
                        if (gouWuCheNum.getStatus() == 1){
                            qBadgeView.bindTarget(bt_gouwuche).setBadgeNumber(gouWuCheNum.getResult());
                        }else{
                            qBadgeView.hide(true);
                            }
                        }
                });
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
                                qbadgebiewxitong.bindTarget(bt_xiaoxi).setGravityOffset(8,true).setBadgeText("");
                            }else{
                                qbadgebiewxitong.hide(true);
                            }
                        }
                    }
                });
    }


    private void initTablayout() {
        mFragments.clear();
        mtabtitle.clear();
        SlidingTabLayout stl = findViewById(R.id.stl);
        ViewPager mViewPager = findViewById(R.id.vp);
        mFragments.add(ShangPinFragment.newInstance(shopid,挑选,commission,isJingXuan,type,userid));
        mFragments.add(CanShuFragment.newInstance(shopid,挑选));
        mFragments.add(PingJiaFragment.newInstance(shopid,挑选));
        for (int i = 0;i<mTitles.length;i++){
            mtabtitle.add(mTitles[i]);
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager(),mFragments,mtabtitle);
        mViewPager.setAdapter(mAdapter);
        stl.setViewPager(mViewPager);
    }

    @Override
    public void onCountChanged(int i) {
        if(i == 0){
            qbadgebiewxitong.hide(true);
        }else{
            qbadgebiewxitong.bindTarget(bt_xiaoxi).setGravityOffset(8,true).setBadgeText("");
        }
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 300){
            if (status.equals("加入购物车")){
                    if (gouWuCheNum.getStatus() == 1){
                        gouWuCheNum.setResult(gouWuCheNum.getResult()+1);
                        qBadgeView.bindTarget(bt_gouwuche).setBadgeNumber(gouWuCheNum.getResult());
                    }else{
                        qBadgeView.hide(true);
                    }
            }
        }
    }
}
