package com.huohougongfu.app.Shop.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.DiaPuZhuYeActivity;
import com.huohougongfu.app.Gson.SouSuoDianPu;
import com.huohougongfu.app.Gson.SouSuoShopGson;
import com.huohougongfu.app.PopupView.DianPuShaiXunPopup;
import com.huohougongfu.app.PopupView.ShaiXuanDrawerPopupView;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Adapter.SouSuoDianPuAdapter;
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
public class SouSuoPinPaiFragment extends Fragment implements IListener ,View.OnClickListener {


    private View inflate;
    private RecyclerView rec_sousuo_pinpai;
    private SmartRefreshLayout smartrefreshlayout;
    private TextView bt_dianpu_zonghe,bt_dianpu_xiaoliang,bt_dianpu_haoping,bt_dianpu_renqi;
    Map<String, String> map = new HashMap<>();
    private  String indexParam = "0";
    private String queryStoreName = null;
    private SouSuoDianPuAdapter shangPinAdapter;
    private int page = 2;
    private BasePopupView xpopup;

    public SouSuoPinPaiFragment() {
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
        inflate = inflater.inflate(R.layout.fragment_sou_suo_pin_pai, container, false);
        xpopup = new XPopup.Builder(getContext())
                .popupPosition(PopupPosition.Right)//右边
                .asCustom(new DianPuShaiXunPopup(getContext(),mHandler));
        initUI();
        initData(map);
        return inflate;
    }

    private void initUI() {
        bt_dianpu_zonghe = inflate.findViewById(R.id.bt_dianpu_zonghe);
        bt_dianpu_xiaoliang = inflate.findViewById(R.id.bt_dianpu_xiaoliang);
        bt_dianpu_haoping = inflate.findViewById(R.id.bt_dianpu_haoping);
        bt_dianpu_renqi = inflate.findViewById(R.id.bt_dianpu_renqi);
        bt_dianpu_zonghe.setOnClickListener(this);
        bt_dianpu_xiaoliang.setOnClickListener(this);
        bt_dianpu_haoping.setOnClickListener(this);
        bt_dianpu_renqi.setOnClickListener(this);
        inflate.findViewById(R.id.bt_dianpu_shaixuan).setOnClickListener(this);

        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_sousuo_pinpai = inflate.findViewById(R.id.rec_sousuo_pinpai);
    }


    private void initData(Map<String,String> map1) {
        map.clear();
        map.putAll(map1);
        map.put("showNum","3");
        map.put("page","1");
        map.put("pageSize","10");
        map.put("indexParam",indexParam);
        if (queryStoreName!=null &&queryStoreName.length()>0){
            map.put("queryStoreName",queryStoreName);
        }
        OkGo.<String>get(Contacts.URl2+"query/indexfilter/queryIndexStore")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        SouSuoDianPu dianpu = gson.fromJson(response.body(), SouSuoDianPu.class);

                        if (dianpu.getStatus() == 1) {
                            if (dianpu.getResult().getList().size()>0){
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec(dianpu.getResult());
                            }else{
                                smartrefreshlayout.setVisibility(View.GONE);
                            }
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(SouSuoDianPu.ResultBean result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_sousuo_pinpai.setLayoutManager(layoutmanager);
        shangPinAdapter = new SouSuoDianPuAdapter(R.layout.item_shop_sousuo_pinpai,result.getList());
        rec_sousuo_pinpai.setAdapter(shangPinAdapter);
        shangPinAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("userid",String.valueOf(result.getList().get(position).getUserId()));
                intent.putExtra("id",String.valueOf(result.getList().get(position).getId()));
                intent.setClass(getActivity(),DiaPuZhuYeActivity.class);
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
        map.put("showNum","3");
        map.put("page",String.valueOf(page++));
        map.put("pageSize","10");
        map.put("indexParam",indexParam);
        if (queryStoreName!=null &&queryStoreName.length()>0){
            map.put("queryStoreName",queryStoreName);
        }else{
            map.put("queryStoreName",queryStoreName);
        }
        OkGo.<String>get(Contacts.URl2+"query/indexfilter/queryIndexStore")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        SouSuoDianPu shop = gson.fromJson(response.body(), SouSuoDianPu.class);
                        if (shop.getResult().getList().size()>0){
                            shangPinAdapter.add(shop.getResult().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadmoreWithNoMoreData();
                        }
                    }
                });
    }

    public static Fragment newInstance(String sousuo, String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        SouSuoPinPaiFragment fragment = new SouSuoPinPaiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            if (queryStoreName!=null){

            }
        }
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 0){
            queryStoreName = status;
            if (getUserVisibleHint()){
                initData(map);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_dianpu_zonghe:
                bt_dianpu_zonghe.setTextColor(getResources().getColor(R.color.sousuoTab));
                bt_dianpu_xiaoliang.setTextColor(getResources().getColor(R.color.colorBlack));
                bt_dianpu_haoping.setTextColor(getResources().getColor(R.color.colorBlack));
                bt_dianpu_renqi.setTextColor(getResources().getColor(R.color.colorBlack));
                indexParam = "0";
                initData(map);
                break;
            case R.id.bt_dianpu_xiaoliang:
                bt_dianpu_zonghe.setTextColor(getResources().getColor(R.color.colorBlack));
                bt_dianpu_xiaoliang.setTextColor(getResources().getColor(R.color.sousuoTab));
                bt_dianpu_haoping.setTextColor(getResources().getColor(R.color.colorBlack));
                bt_dianpu_renqi.setTextColor(getResources().getColor(R.color.colorBlack));
                indexParam = "1";
                initData(map);
                break;
            case R.id.bt_dianpu_haoping:
                bt_dianpu_zonghe.setTextColor(getResources().getColor(R.color.colorBlack));
                bt_dianpu_xiaoliang.setTextColor(getResources().getColor(R.color.colorBlack));
                bt_dianpu_haoping.setTextColor(getResources().getColor(R.color.sousuoTab));
                bt_dianpu_renqi.setTextColor(getResources().getColor(R.color.colorBlack));
                indexParam = "2";
                initData(map);
                break;
            case R.id.bt_dianpu_renqi:
                bt_dianpu_zonghe.setTextColor(getResources().getColor(R.color.colorBlack));
                bt_dianpu_xiaoliang.setTextColor(getResources().getColor(R.color.colorBlack));
                bt_dianpu_haoping.setTextColor(getResources().getColor(R.color.colorBlack));
                bt_dianpu_renqi.setTextColor(getResources().getColor(R.color.sousuoTab));
                indexParam = "3";
                initData(map);
                break;
            case R.id.bt_dianpu_shaixuan:
                if (!utils.isDoubleClick()){
                    xpopup.show();
                }
                break;
        }
    }
}
