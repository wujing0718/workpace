package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.TeiHuiGson;
import com.huohougongfu.app.PopupView.TiaoXuanShopShaiXuan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Adapter.TeHuiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.enums.PopupPosition;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.Map;

public class TiaoXuanShopActivity extends AppCompatActivity implements View.OnClickListener {

    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_sousuo_shangpin;
    private int page = 2;
    private TeHuiAdapter teHuiAdapter;
    Map<String, String> map = new HashMap<>();
    private  String indexParams = "0";
    private TextView bt_shop_zonghe,bt_shop_xiaoliang,bt_shop_xinpin,tv_shop_jiage;
    private boolean isjiage;
    private String sortPrice = "";
    private ImageView img_shop_sortPrice;
    private String name;

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Map<String,String> map = (Map<String,String>)msg.obj;
                    initData(map);
                    break;
                default:
                    break;
            }
        }

    };
    private EditText bt_shop_sousuo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiao_xuan_shop);
        initUI();
        initData(map);
    }

    private void initData(Map<String,String> map1) {
        map.putAll(map1);
        map.put("page","1");
        map.put("pageSize","10");
        map.put("indexParams",indexParams);
        map.put("ofManger","1");
        if (!"".equals(sortPrice)){
            map.put("sortPrice",sortPrice);
        }
        if (name!=null){
            map.put("name",name);
        }
        OkGo.<String>get(Contacts.URl2+"query/queryProductFilter")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        TeiHuiGson shop = gson.fromJson(response.body(), TeiHuiGson.class);
                        if (shop.getStatus() == 1) {
                            initRec(shop.getResult());
                        }
                    }
                });
    }

    private void initRec(TeiHuiGson.ResultBean data) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(TiaoXuanShopActivity.this,2);
        //设置RecyclerView 布局
        rec_sousuo_shangpin.setLayoutManager(layoutmanager);
        teHuiAdapter = new TeHuiAdapter(R.layout.item_shangpin,data.getList());
        rec_sousuo_shangpin.setAdapter(teHuiAdapter);
        teHuiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("id",data.getList().get(position).getId());
                intent.putExtra("commission",String.valueOf(data.getList().get(position).getCommission()));
                intent.putExtra("挑选","挑选");
                intent.setClass(TiaoXuanShopActivity.this,ShangPinDetailActivity.class);
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
        map.remove("page");
        map.put("page",String.valueOf(page++));
        OkGo.<String>get(Contacts.URl2+"query/queryProductFilter")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        TeiHuiGson shop = gson.fromJson(response.body(), TeiHuiGson.class);
                        if (shop.getResult().getList().size()>0){
                            teHuiAdapter.add(shop.getResult().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadmoreWithNoMoreData();
                        }
                    }
                });
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        bt_shop_sousuo = findViewById(R.id.bt_shop_sousuo);
        img_shop_sortPrice = findViewById(R.id.img_shop_sortPrice);
        bt_shop_zonghe = findViewById(R.id.bt_shop_zonghe);
        tv_shop_jiage = findViewById(R.id.tv_shop_jiage);
        bt_shop_zonghe.setOnClickListener(this);
        bt_shop_xiaoliang = findViewById(R.id.bt_shop_xiaoliang);
        bt_shop_xiaoliang.setOnClickListener(this);
        bt_shop_xinpin = findViewById(R.id.bt_shop_xinpin);
        bt_shop_xinpin.setOnClickListener(this);
        findViewById(R.id.bt_shop_jiage).setOnClickListener(this);

        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        rec_sousuo_shangpin = findViewById(R.id.rec_sousuo_shangpin);
        findViewById(R.id.bt_sousuo_shaixuan).setOnClickListener(this);

        bt_shop_sousuo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                name =  s.toString();
                initData(map);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_sousuo_shaixuan:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(TiaoXuanShopActivity.this)
                            .popupPosition(PopupPosition.Right)//右边
                            .asCustom(new TiaoXuanShopShaiXuan(TiaoXuanShopActivity.this,mHandler))
                            .show();
                }
                break;
            case R.id.bt_shop_zonghe:
                if (!utils.isDoubleClick()){
                    bt_shop_zonghe.setTextColor(getResources().getColor(R.color.sousuoTab));
                    bt_shop_xiaoliang.setTextColor(getResources().getColor(R.color.colorBlack));
                    bt_shop_xinpin.setTextColor(getResources().getColor(R.color.colorBlack));
                    tv_shop_jiage.setTextColor(getResources().getColor(R.color.colorBlack));
                    img_shop_sortPrice.setImageResource(R.mipmap.img_shengjiang);
                    indexParams = "0";
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
        }
    }
}
