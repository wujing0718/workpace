package com.huohougongfu.app.WoDe.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.Gson.ShopGuanLiLieBiao;
import com.huohougongfu.app.Gson.TeiHuiGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Activity.TeHuiActivity;
import com.huohougongfu.app.Shop.Adapter.TeHuiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.WoDe.Activity.ShopGuanLIActivity;
import com.huohougongfu.app.WoDe.Activity.TianJiaShangPinActivity;
import com.huohougongfu.app.WoDe.Activity.TiaoXuanShopActivity;
import com.huohougongfu.app.WoDe.Adapter.CangKuGuanLiAdapter;
import com.huohougongfu.app.WoDe.Adapter.ShopGuanLiAdapter;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class CangKuFragment extends Fragment implements IListener ,CangKuGuanLiAdapter.OnItemClickListener,View.OnClickListener {

    private View inflate;
    private String token,tel,id;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_shangpin_tehui;
    private CangKuGuanLiAdapter tehuiadapter;
    /** Fragment当前状态是否可见 */
    protected boolean isVisible;
    protected boolean isGuanLi = true;
    private boolean editorStatus = false;
    private static final int MYLIVE_MODE_CHECK = 0;
    private static final int MYLIVE_MODE_EDIT = 1;
    private int mEditMode = MYLIVE_MODE_CHECK;
    private int index = 0;
    private TextView tv_shangchuan_shop,tv_tiaoxuan_shop;
    private String status;
    private View view;
    private Intent intent;
    private int page = 2;

    public CangKuFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ListenerManager.getInstance().registerListtener(this);
        inflate = inflater.inflate(R.layout.fragment_cang_ku, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
         intent = new Intent();
        initUI();
        initData();
        return inflate;
    }

    @Override
    public void onResume() {
        initData();
        super.onResume();
    }

    private void initUI() {
        view = inflate.findViewById(R.id.view);
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_shangpin_tehui= inflate.findViewById(R.id.rec_shangpin_tehui);
        tv_shangchuan_shop = inflate.findViewById(R.id.tv_shangchuan_shop);
        tv_tiaoxuan_shop = inflate.findViewById(R.id.tv_tiaoxuan_shop);
        inflate.findViewById(R.id.bt_tiaoxuan_shop).setOnClickListener(this);
        inflate.findViewById(R.id.bt_shangchuan_shop).setOnClickListener(this);

    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("userId",id);
        map.put("token",token);
        map.put("status","2");
        map.put("page", "1");
        map.put("pageSize", "10");
        OkGo.<String>get(Contacts.URl2+"productManage/getProductResells")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        ShopGuanLiLieBiao shangPinGson = gson.fromJson(response.body(), ShopGuanLiLieBiao.class);
                        if (shangPinGson.getStatus() == 1) {
                            if (shangPinGson.getResult().getList().size()>0){
                                view.setVisibility(View.VISIBLE);
                                initRec(shangPinGson.getResult());
                            }else{
                                view.setVisibility(View.GONE);
                            }
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(ShopGuanLiLieBiao.ResultBean result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(getActivity(),2);
        //设置RecyclerView 布局
        rec_shangpin_tehui.setLayoutManager(layoutmanager);
        tehuiadapter = new CangKuGuanLiAdapter(R.layout.item_shangpin,result.getList());
        rec_shangpin_tehui.setAdapter(tehuiadapter);
        tehuiadapter.notifyAdapter(result.getList(),false);
        tehuiadapter.setOnItemClickListener(this);
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
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("userId",id);
        map.put("token",token);
        map.put("status","2");
        map.put("page", String.valueOf(page++));
        map.put("pageSize", "10");
        OkGo.<String>get(Contacts.URl2+"productManage/getProductResells")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        ShopGuanLiLieBiao shangPinGson = gson.fromJson(response.body(), ShopGuanLiLieBiao.class);
                        if (shangPinGson.getResult().getList().size()>0){
                            tehuiadapter.add(shangPinGson.getResult().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadmoreWithNoMoreData();
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        CangKuFragment fragment = new CangKuFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            isVisible = isVisibleToUser;
            initData();
        } else {
            if (isVisible) {
                isVisible = isVisibleToUser;
            }
        }
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        this.status = status;
        if(isVisible){
            if (audience_cnt == 4){
                if (status.equals("仓库")){
                    if (isGuanLi){
                        if (tehuiadapter!=null){
                            isGuanLi = false ;
                            editorStatus = true;
                            tehuiadapter.setEditMode(1);
                            tv_shangchuan_shop.setText("上架");
                        }
                        tv_tiaoxuan_shop.setText("删除");
                    }else{
                        if (tehuiadapter!=null){
                            isGuanLi = true ;
                            editorStatus = false;
                            tehuiadapter.setEditMode(0);
                            tv_shangchuan_shop.setText("上传商品");
                            tv_tiaoxuan_shop.setText("挑选商品");
                        }
                    }
                }
            }
        }else{
            if (tehuiadapter!=null){
                isGuanLi = true ;
                editorStatus = false;
                tehuiadapter.setEditMode(0);
                tv_shangchuan_shop.setText("上传商品");
                tv_tiaoxuan_shop.setText("挑选商品");
            }
        }
    }

    @Override
    public void onItemClickListener(int pos, List<ShopGuanLiLieBiao.ResultBean.ListBean> myLiveList) {
        if (editorStatus) {
            ShopGuanLiLieBiao.ResultBean.ListBean myLive = myLiveList.get(pos);
            boolean isSelect = myLive.isSelect();
            if (!isSelect) {
                index++;
                myLive.setSelect(true);
            }else{
                myLive.setSelect(false);
                index--;
            }
//            setBtnBackground(index);
            tehuiadapter.notifyDataSetChanged();
        }else{
            Intent intent = new Intent();
            intent.putExtra("id",myLiveList.get(pos).getId());
            intent.setClass(getActivity(),ShangPinDetailActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_shangchuan_shop:
                if (status.equals("仓库")){
                    if (!isGuanLi){
                        //上架
                        initShangJia();
                    }else{
                        intent.setClass(getActivity(),TianJiaShangPinActivity.class);
                        startActivity(intent);
                    }
                }else{
                    intent.setClass(getActivity(),TianJiaShangPinActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_tiaoxuan_shop:
                if (status.equals("仓库")){
                    if (isGuanLi){
                        intent.setClass(getActivity(),TiaoXuanShopActivity.class);
                        startActivity(intent);
                    }else{
                        //删除
                        initDelete();
                    }
                }else{
                    intent.setClass(getActivity(),TiaoXuanShopActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    private void initDelete() {
        String ids ="";
        for (int i = tehuiadapter.getMyLiveList().size(), j =0 ; i > j; i--) {
            ShopGuanLiLieBiao.ResultBean.ListBean myLive = tehuiadapter.getMyLiveList().get(i-1);
            if (myLive.isSelect()) {
                ids = myLive.getId()+","+ids;
            }
        }
        if (!"".equals(ids)){
            String substring = ids.substring(0, ids.length() - 1);
            Map<String,String> map = new HashMap<>();
            map.put("ids",substring);
            map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
            OkGo.<String>post(Contacts.URl1+"productManage/deleteProductBatch")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    initData();
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }else{
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }else{
            ToastUtils.showShort("请选择删除的商品");
        }
    }

    private void initShangJia() {
        String ids ="";
        for (int i = tehuiadapter.getMyLiveList().size(), j =0 ; i > j; i--) {
            ShopGuanLiLieBiao.ResultBean.ListBean myLive = tehuiadapter.getMyLiveList().get(i-1);
            if (myLive.isSelect()) {
                ids = myLive.getId()+","+ids;
            }
        }
        if (!"".equals(ids)){
            String substring = ids.substring(0, ids.length() - 1);
            Map<String,String> map = new HashMap<>();
            map.put("ids",substring);
            map.put("status","1");
            map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
            OkGo.<String>post(Contacts.URl1+"productManage/productOut")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    initData();
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }else{
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }else{
            ToastUtils.showShort("请选择上架的商品");
        }
    }
}
