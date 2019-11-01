package com.huohougongfu.app.Shop.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.DiaPuZhuYeActivity;
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Adapter.ShangPinTuiJianAdapter;
import com.huohougongfu.app.Gson.BannerGson;
import com.huohougongfu.app.Gson.TeYuePingPai;
import com.huohougongfu.app.Gson.WeiDuXiaoXI;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.PinPaiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

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

public class TeYuePinPaiActivity extends AppCompatActivity implements IUnReadMessageObserver {

    private Banner banner;
    private List<Integer> mlist = new ArrayList<>();
    private RecyclerView rec_cainixihuan,rec_quanbupinpai;
    private View head_teyue;
    private List<String> mbanner = new ArrayList<>();
    private List<String> mbannerimg = new ArrayList<>();
    private SmartRefreshLayout smartrefreshlayout;
    private EditText bt_shop_sousuo;
    private InputMethodManager manager;
    private PinPaiAdapter pinPaiItemAdapter;
    private int page =2;
    private int mId;
    private Intent intent;
    private String token;
    private QBadgeView qBadgeView;
    final Conversation.ConversationType[] conversationTypes = {
            Conversation.ConversationType.PRIVATE,
            Conversation.ConversationType.GROUP, Conversation.ConversationType.SYSTEM,
            Conversation.ConversationType.PUBLIC_SERVICE, Conversation.ConversationType.APP_PUBLIC_SERVICE
    };
    private View bt_xiaoxi;
    private View bt_gouwuche;
    private QBadgeView qbadgebiewxitong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_te_yue_pin_pai);
        qBadgeView = new QBadgeView(TeYuePinPaiActivity.this);
        qbadgebiewxitong= new QBadgeView(TeYuePinPaiActivity.this);
        manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        intent = new Intent();
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        inituUI();
        initData("");
        initbanner();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initShoppingCartNum();
        initNoticeIsView();
        RongIM.getInstance().addUnReadMessageCountChangedObserver(this, conversationTypes);
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

    private void initShoppingCartNum() {
        OkGo.<String>post(Contacts.URl1+"/cartNum")
                .params("mId",String.valueOf(MyApp.instance.getInt("id")))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        QBadgeView qBadgeView = new QBadgeView(TeYuePinPaiActivity.this);
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


    private void inituUI() {
        rec_quanbupinpai = findViewById(R.id.rec_quanbupinpai);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        bt_shop_sousuo = findViewById(R.id.bt_shop_sousuo);
        head_teyue = getLayoutInflater().inflate(R.layout.head_teyue, (ViewGroup) rec_quanbupinpai.getParent(), false);
        rec_cainixihuan = head_teyue.findViewById(R.id.rec_cainixihuan);
        banner = head_teyue.findViewById(R.id.banner);
        bt_shop_sousuo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(bt_shop_sousuo.getApplicationWindowToken(), 0);
                    }
                    //自己需要的操作
                    String sousuo = bt_shop_sousuo.getText().toString();
                    if (sousuo.isEmpty()){
                        initData(sousuo);
                    }else{
                        initData(sousuo);
                    }
                }
                //记得返回false
                return false;
            }
        });
        bt_xiaoxi = findViewById(R.id.bt_xiaoxi);
        bt_xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!utils.isDoubleClick()){
                    intent.setClass(TeYuePinPaiActivity.this,XiaoXiActivity.class);
                    startActivity(intent);
                }
            }
        });
        bt_gouwuche = findViewById(R.id.bt_gouwuche);
        bt_gouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!utils.isDoubleClick()){
                    intent.setClass(TeYuePinPaiActivity.this,GouWuCheActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void initData(String sousuo) {
        Map<String,String> map = new HashMap<>();
        map.put("page","1");
        map.put("pageSize","10");
        if (!sousuo.isEmpty()){
            map.put("name",sousuo);
        }
        map.put("userId",String.valueOf(mId));
        OkGo.<String>get(Contacts.URl1+"query/brand/isSpecial")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        TeYuePingPai shangPinGson = gson.fromJson(response.body(), TeYuePingPai.class);
                        if (shangPinGson.getStatus() == 1) {
                            if (!sousuo.isEmpty() && shangPinGson.getResult().getResultList().getList().size()==0){
                                smartrefreshlayout.setVisibility(View.GONE);
                            }else if (!sousuo.isEmpty()){
                                initRec2(shangPinGson.getResult().getResultList().getList(),sousuo);
                            }else{
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec2(shangPinGson.getResult().getResultList().getList(),sousuo);
                                initRec(shangPinGson.getResult().getIsSpecial());
                            }
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(TeYuePinPaiActivity.this, "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initbanner() {
        //设置指示器位置
        banner.setIndicatorGravity(BannerConfig.CENTER);
        OkGo.<String>get(Contacts.URl1+"/setting/banner/5")
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

    private void initRec(List<TeYuePingPai.ResultBean.IsSpecialBean> isSpecial) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置RecyclerView 布局
        rec_cainixihuan.setLayoutManager(layoutmanager);
        ShangPinTuiJianAdapter shangPinTuiJianAdapter = new ShangPinTuiJianAdapter(R.layout.item_shop_cainixihuan,isSpecial);
        rec_cainixihuan.setAdapter(shangPinTuiJianAdapter);
        shangPinTuiJianAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                intent.putExtra("id",String.valueOf(isSpecial.get(position).getUserId()));
                intent.setClass(TeYuePinPaiActivity.this,DiaPuZhuYeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initRec2(List<TeYuePingPai.ResultBean.ResultListBean.ListBean> resultList, String sousuo) {
        if (sousuo.isEmpty()){
            ViewGroup parentViewGroup = (ViewGroup) head_teyue.getParent();
            if (parentViewGroup != null) {
                parentViewGroup.removeAllViews();
            }
            //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
            LinearLayoutManager layoutmanager = new LinearLayoutManager(TeYuePinPaiActivity.this){
                @Override
                public boolean canScrollHorizontally() {
                    return false;
                }
            };
            layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
            //设置RecyclerView 布局
            rec_quanbupinpai.setLayoutManager(layoutmanager);
            pinPaiItemAdapter = new PinPaiAdapter(R.layout.item_shop_pinpai,resultList);
            pinPaiItemAdapter.addHeaderView(head_teyue);
            rec_quanbupinpai.setAdapter(pinPaiItemAdapter);

        }else{
            pinPaiItemAdapter = new PinPaiAdapter(R.layout.item_shop_pinpai,resultList);
            rec_quanbupinpai.setAdapter(pinPaiItemAdapter);

        }
        pinPaiItemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_pinpai_guanzhu = view.findViewById(R.id.bt_pinpai_guanzhu);
                switch (view.getId()){
                    case R.id.bt_pinpai:
                        if (!utils.isDoubleClick()){
                            intent.putExtra("id",String.valueOf(resultList.get(position).getUserId()));
                            intent.setClass(TeYuePinPaiActivity.this,DiaPuZhuYeActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.bt_pinpai_guanzhu:
                        if (!utils.isDoubleClick()){
                            if (resultList.get(position).getIsAttention() == 1){
                                initNoGuanZhu(bt_pinpai_guanzhu,resultList.get(position));
                            }else{
                                initGuanZhu(bt_pinpai_guanzhu,resultList.get(position));
                            }
                        }
                        break;
                }
            }
        });
        pinPaiItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (!utils.isDoubleClick()){
                    intent.putExtra("id",String.valueOf(resultList.get(position).getUserId()));
                    intent.setClass(TeYuePinPaiActivity.this,DiaPuZhuYeActivity.class);
                    startActivity(intent);
                }
            }
        });
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData("");
                smartrefreshlayout.finishRefresh(true);//传入false表示刷新失败
            }
        });
        //加载更多
        smartrefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                initAdd();
            }
        });
    }

    private void initGuanZhu(TextView bt_pinpai_guanzhu, TeYuePingPai.ResultBean.ResultListBean.ListBean listBean) {
        int userId = listBean.getUserId();
        Map<String,String> map =new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("attentionId",String.valueOf(userId));
        map.put("type",String.valueOf(1));
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/attention")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                listBean.setIsAttention(1);
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                bt_pinpai_guanzhu.setBackgroundResource(R.drawable.yiguanzhu);
                                bt_pinpai_guanzhu.setText("已关注");
                                bt_pinpai_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorWhite));
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initNoGuanZhu(TextView bt_pinpai_guanzhu, TeYuePingPai.ResultBean.ResultListBean.ListBean listBean) {
        int userId = listBean.getUserId();
        Map<String,String> map =new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("attentionId",String.valueOf(userId));
        map.put("type",String.valueOf(0));
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/attention")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                listBean.setIsAttention(0);
                                bt_pinpai_guanzhu.setText("+关注");
                                bt_pinpai_guanzhu.setBackgroundResource(R.drawable.guanzhu);
                                bt_pinpai_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.black));
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initAdd() {
        Map<String,String> map = new HashMap<>();
        map.put("page",String.valueOf(page++));
        map.put("pageSize","10");
        map.put("userId",String.valueOf(mId));
        OkGo.<String>get(Contacts.URl2+"query/brand/isSpecial")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        TeYuePingPai shangPinGson = gson.fromJson(response.body(), TeYuePingPai.class);
                        if (shangPinGson.getStatus() == 1) {
                            if (shangPinGson.getResult().getResultList().getList().size()>0){
                                pinPaiItemAdapter.add(shangPinGson.getResult().getResultList().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else {
                                smartrefreshlayout. finishLoadmoreWithNoMoreData();
                            }
                        }
                    }
                });
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
