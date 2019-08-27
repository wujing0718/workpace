package com.huohougongfu.app.Shop.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.SouSuoShopGson;
import com.huohougongfu.app.Gson.TeiHuiGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.ShaiXuanDrawerPopupView;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Adapter.SouSuoShopAdapter;
import com.huohougongfu.app.Shop.Adapter.TeHuiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SouSuoShopFragment extends Fragment implements View.OnClickListener ,IListener {


    private View inflate;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_sousuo_shangpin;
    private int page = 2;
    private SouSuoShopAdapter teHuiAdapter;
    Map<String, String> map = new HashMap<>();
    private  String indexParams = "0";
    private TextView bt_shop_zonghe,bt_shop_xiaoliang,bt_shop_xinpin,tv_shop_jiage;
    private boolean isjiage;
    private String sortPrice = "";
    private ImageView img_shop_sortPrice;
    private String name;
    private BasePopupView xpopup;

    public SouSuoShopFragment() {
        // Required empty public constructor
    }

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListenerManager.getInstance().registerListtener(this);
        inflate = inflater.inflate(R.layout.fragment_sou_suo_shop, container, false);
        initUI();
        initData(map);
        xpopup = new XPopup.Builder(getContext())
                .popupPosition(PopupPosition.Right)//右边
                .asCustom(new ShaiXuanDrawerPopupView(getContext(), mHandler));

        return inflate;
    }

    private void initUI() {
        img_shop_sortPrice = inflate.findViewById(R.id.img_shop_sortPrice);
        bt_shop_zonghe = inflate.findViewById(R.id.bt_shop_zonghe);
        tv_shop_jiage = inflate.findViewById(R.id.tv_shop_jiage);
        bt_shop_zonghe.setOnClickListener(this);
        bt_shop_xiaoliang = inflate.findViewById(R.id.bt_shop_xiaoliang);
        bt_shop_xiaoliang.setOnClickListener(this);
        bt_shop_xinpin = inflate.findViewById(R.id.bt_shop_xinpin);
        bt_shop_xinpin.setOnClickListener(this);
        inflate.findViewById(R.id.bt_shop_jiage).setOnClickListener(this);

        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_sousuo_shangpin = inflate.findViewById(R.id.rec_sousuo_shangpin);
        inflate.findViewById(R.id.bt_sousuo_shaixuan).setOnClickListener(this);
    }

    private void initData(Map<String,String> map1) {
        map.clear();
        map.putAll(map1);
        map.put("page","1");
        map.put("pageSize","10");
        map.put("indexParams",indexParams);
        if (!"".equals(sortPrice)){
            map.put("sortPrice",sortPrice);
        }
        if (name!=null){
            map.put("name",name);
        }else{
            map.put("name",name);
        }
        OkGo.<String>get(Contacts.URl2+"query/queryProductFilter")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        SouSuoShopGson shop = gson.fromJson(response.body(), SouSuoShopGson.class);
                        if (shop.getStatus() == 1) {
                            initRec(shop.getResult().getResultList());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        if (getActivity() != null) {
                            WaitDialog.show(getActivity(), "载入中...");
                        }
                        super.onStart(request);
                    }
                });
    }

    private void initRec(SouSuoShopGson.ResultBean.ResultListBean data) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(getActivity(),2);
        //设置RecyclerView 布局
        rec_sousuo_shangpin.setLayoutManager(layoutmanager);
        teHuiAdapter = new SouSuoShopAdapter(R.layout.item_shangpin,data.getList());
        rec_sousuo_shangpin.setAdapter(teHuiAdapter);
        teHuiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("id",data.getList().get(position).getId());
                intent.setClass(getActivity(),ShangPinDetailActivity.class);
                startActivity(intent);
            }
        });
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                map.clear();
                initData(map);
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
        Map<String, String> map = new HashMap<>();
        map.put("page",String.valueOf(page++));
        map.put("pageSize","10");
        map.put("indexParams",indexParams);
        if (!"".equals(sortPrice)){
            map.put("sortPrice",sortPrice);
        }
        if (name!=null){
            map.put("name",name);
        }else{
            map.put("name",name);
        }
        OkGo.<String>get(Contacts.URl2+"query/queryProductFilter")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        SouSuoShopGson shop = gson.fromJson(response.body(), SouSuoShopGson.class);
                        if (shop.getResult().getResultList().getList().size()>0){
                            teHuiAdapter.add(shop.getResult().getResultList().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadmoreWithNoMoreData();
                        }
                    }
                });
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        SouSuoShopFragment fragment = new SouSuoShopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_sousuo_shaixuan:
                if (!utils.isDoubleClick()){
                    xpopup.show();
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

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 0){
            name = status;
            initData(map);
        }
    }
}
