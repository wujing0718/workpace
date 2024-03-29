package com.huohougongfu.app.Shop.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.GouWuCheActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Gson.LeiMuDetail;
import com.huohougongfu.app.Gson.TeiHuiGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.ShaiXuanLeiMuView;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.TeHuiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.enums.PopupPosition;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.rong.imkit.RongIM;
import io.rong.imkit.manager.IUnReadMessageObserver;
import io.rong.imlib.model.Conversation;
import q.rorbin.badgeview.QBadgeView;

public class LeiMuDetailActivity extends AppCompatActivity implements View.OnClickListener,IUnReadMessageObserver {

    private Intent intent;
    private TextView bt_shop_zonghe,bt_shop_xiaoliang,bt_shop_xinpin,tv_shop_jiage;
    Map<String, String> map = new HashMap<>();
    private  String indexParams = "0";
    private boolean isjiage;
    private String sortPrice = "";

    private Map<String, String> map1;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    map1 = (Map<String,String>)msg.obj;
                    initData(map1);
                    break;
                default:
                    break;
            }
        }

    };
    private ImageView img_shop_sortPrice;
    private String name;
    private RecyclerView rec_leimu_detail;
    private SmartRefreshLayout smartrefreshlayout;
    private TeHuiAdapter teHuiAdapter;
    private TextView  tv_leimu_name;
    private View view_zhanweitu;
    private int page = 2;
    private QBadgeView qBadgeView;
    final Conversation.ConversationType[] conversationTypes = {
            Conversation.ConversationType.PRIVATE,
            Conversation.ConversationType.GROUP, Conversation.ConversationType.SYSTEM,
            Conversation.ConversationType.PUBLIC_SERVICE, Conversation.ConversationType.APP_PUBLIC_SERVICE
    };
    private View bt_gouwuche;
    private View bt_xiaoxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lei_mu_detail);
        qBadgeView = new QBadgeView(LeiMuDetailActivity.this);
        name = getIntent().getStringExtra("name");
        intent = new Intent();
        initUI();
        initData(map);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initShoppingCartNum();
        RongIM.getInstance().addUnReadMessageCountChangedObserver(this, conversationTypes);
    }

    private void initShoppingCartNum() {
        OkGo.<String>post(Contacts.URl1+"/cartNum")
                .params("mId",String.valueOf(MyApp.instance.getInt("id")))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        QBadgeView qBadgeView = new QBadgeView(LeiMuDetailActivity.this);
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

    private void initData(Map<String,String> map1) {
        if (map1.get("name")!=null){
            name = map1.get("name");
        }
        map.putAll(map1);
        map.put("twoName",name);
        map.put("pageNo","1");
        map.put("pageSize","10");
        map.put("indexParams",indexParams);
        if (!"".equals(sortPrice)){
            map.put("sortPrice",sortPrice);
        }
        OkGo.<String>post(Contacts.URl2+"categorySelection")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        TeiHuiGson leiMuDetail = new Gson().fromJson(body, TeiHuiGson.class);
                        if (leiMuDetail.getStatus() == 1){
                            if (leiMuDetail.getResult().getList().size()>0){
                                view_zhanweitu.setVisibility(View.GONE);
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec(leiMuDetail.getResult());
                            }else{
                                view_zhanweitu.setVisibility(View.VISIBLE);
                                smartrefreshlayout.setVisibility(View.GONE);
                            }
                        }
                    }
                });
    }

    private void initRec(TeiHuiGson.ResultBean result) {
//创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(LeiMuDetailActivity.this,2);
        //设置RecyclerView 布局
        rec_leimu_detail.setLayoutManager(layoutmanager);
        teHuiAdapter = new TeHuiAdapter(R.layout.item_shangpin,result.getList());
        rec_leimu_detail.setAdapter(teHuiAdapter);
        teHuiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("id",result.getList().get(position).getId());
                intent.setClass(LeiMuDetailActivity.this,ShangPinDetailActivity.class);
                startActivity(intent);
            }
        });
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
//                initOkGO();
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

    private void initAdd() {
        if (map1.get("name")!=null){
            name = map1.get("name");
        }
        map.putAll(map1);
        map.put("twoName",name);
        map.put("pageNo",String.valueOf(page++));
        map.put("pageSize","10");
        map.put("indexParams",indexParams);
        if (!"".equals(sortPrice)){
            map.put("sortPrice",sortPrice);
        }
        OkGo.<String>post(Contacts.URl2+"categorySelection")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        TeiHuiGson leiMuDetail = new Gson().fromJson(body, TeiHuiGson.class);
                        if (leiMuDetail.getStatus() == 1){
                            if (leiMuDetail.getResult().getList().size()>0){
                                teHuiAdapter.add(leiMuDetail.getResult().getList());
                                smartrefreshlayout.finishLoadmore(true);
                        }else {
                                smartrefreshlayout. finishLoadmoreWithNoMoreData();
                        }
                    }else{
                        smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                    }
                    }
                });
    }

    private void initUI() {
         view_zhanweitu = findViewById(R.id.view_zhanweitu);
        tv_leimu_name = findViewById(R.id.tv_leimu_name);
        tv_leimu_name.setText(name);
        rec_leimu_detail = findViewById(R.id.rec_leimu_detail);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);

        findViewById(R.id.bt_finish).setOnClickListener(this);
        bt_xiaoxi = findViewById(R.id.bt_xiaoxi);
        bt_xiaoxi.setOnClickListener(this);
        bt_gouwuche = findViewById(R.id.bt_gouwuche);
        bt_gouwuche.setOnClickListener(this);
        img_shop_sortPrice = findViewById(R.id.img_shop_sortPrice);

        bt_shop_zonghe = findViewById(R.id.bt_shop_zonghe);
        bt_shop_zonghe.setOnClickListener(this);
        bt_shop_xiaoliang = findViewById(R.id.bt_shop_xiaoliang);
        bt_shop_xiaoliang.setOnClickListener(this);
        bt_shop_xinpin = findViewById(R.id.bt_shop_xinpin);
        bt_shop_xinpin.setOnClickListener(this);
        findViewById(R.id.bt_shop_jiage).setOnClickListener(this);
        tv_shop_jiage = findViewById(R.id.tv_shop_jiage);

        findViewById(R.id.bt_sousuo_shaixuan).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_sousuo_shaixuan:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(LeiMuDetailActivity.this)
                            .popupPosition(PopupPosition.Right)//右边
                            .asCustom(new ShaiXuanLeiMuView(LeiMuDetailActivity.this,mHandler,name))
                            .show();
                }
                break;
            case R.id.bt_shop_zonghe:
                if (!utils.isDoubleClick()){
                    bt_shop_zonghe.setTextColor(getResources().getColor(R.color.sousuoTab));
                    bt_shop_xiaoliang.setTextColor(getResources().getColor(R.color.colorBlack));
                    bt_shop_xinpin.setTextColor(getResources().getColor(R.color.colorBlack));
                    tv_shop_jiage.setTextColor(getResources().getColor(R.color.colorBlack));
                    indexParams = "0";
                    img_shop_sortPrice.setImageResource(R.mipmap.img_shengjiang);
                    initData(map);
                }
                break;
            case R.id.bt_shop_xiaoliang:
                if (!utils.isDoubleClick()){
                    bt_shop_zonghe.setTextColor(getResources().getColor(R.color.colorBlack));
                    bt_shop_xiaoliang.setTextColor(getResources().getColor(R.color.sousuoTab));
                    bt_shop_xinpin.setTextColor(getResources().getColor(R.color.colorBlack));
                    tv_shop_jiage.setTextColor(getResources().getColor(R.color.colorBlack));
                    img_shop_sortPrice.setImageResource(R.mipmap.img_shengjiang);
                    indexParams = "1";
                    initData(map);
                }
                break;
            case R.id.bt_shop_xinpin:
                if (!utils.isDoubleClick()){
                    bt_shop_zonghe.setTextColor(getResources().getColor(R.color.colorBlack));
                    bt_shop_xiaoliang.setTextColor(getResources().getColor(R.color.colorBlack));
                    bt_shop_xinpin.setTextColor(getResources().getColor(R.color.sousuoTab));
                    tv_shop_jiage.setTextColor(getResources().getColor(R.color.colorBlack));
                    img_shop_sortPrice.setImageResource(R.mipmap.img_shengjiang);
                    indexParams = "2";
                    initData(map);
                }
                break;
            case R.id.bt_shop_jiage:
                if (!utils.isDoubleClick()){
                    bt_shop_zonghe.setTextColor(getResources().getColor(R.color.colorBlack));
                    bt_shop_xiaoliang.setTextColor(getResources().getColor(R.color.colorBlack));
                    bt_shop_xinpin.setTextColor(getResources().getColor(R.color.colorBlack));
                    tv_shop_jiage.setTextColor(getResources().getColor(R.color.sousuoTab));
                    indexParams = "3";
                    if (isjiage){
                        sortPrice ="asc";
                        isjiage = false;
                        img_shop_sortPrice.setImageResource(R.mipmap.img_shop_asc);
                        initData(map);
                    }else{
                        sortPrice ="desc";
                        isjiage = true;
                        img_shop_sortPrice.setImageResource(R.mipmap.img_shop_desc);
                        initData(map);
                    }

                }
                break;
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
            case R.id.bt_gouwuche:
                if (!utils.isDoubleClick()){
                    intent.setClass(LeiMuDetailActivity.this,GouWuCheActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_xiaoxi:
                if (!utils.isDoubleClick()){
                    intent.setClass(LeiMuDetailActivity.this,XiaoXiActivity.class);
                    startActivity(intent);
                }
                break;
        }
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
