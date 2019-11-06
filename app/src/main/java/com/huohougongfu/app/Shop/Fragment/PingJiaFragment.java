package com.huohougongfu.app.Shop.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.PingJia;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.PingJiaAdapter;
import com.huohougongfu.app.Utils.Contacts;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class PingJiaFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_detail_pingjia;
    private String token,tel,userid;
    private int shopid;
    private SmartRefreshLayout smartrefreshlayout;
    private int page = 2;
    private PingJiaAdapter pingjiaadapter;

    public PingJiaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_ping_jia, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        userid = String.valueOf(MyApp.instance.getInt("id"));
        shopid = getArguments().getInt("id");
        initUI();
        initData();
        return inflate;
    }

    private void initUI() {
        rec_detail_pingjia = inflate.findViewById(R.id.rec_detail_pingjia);
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("id",String.valueOf(shopid));
        map.put("page","1");
        map.put("pageSize","10");
        map.put("userId",String.valueOf(userid));
        OkGo.<String>get(Contacts.URl2+"/selectAppraise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        PingJia shangPinGson = gson.fromJson(response.body(), PingJia.class);
                        if (shangPinGson.getStatus() == 1) {
                            if (shangPinGson.getResult().getList().size()>0){
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec(shangPinGson.getResult().getList());
                            }else{
                                smartrefreshlayout.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        WaitDialog.dismiss();
                        super.onError(response);
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(List<PingJia.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_detail_pingjia.setLayoutManager(layoutmanager);
        pingjiaadapter = new PingJiaAdapter(R.layout.item_detail_pingjia,list,getActivity());
        rec_detail_pingjia.setAdapter(pingjiaadapter);
        pingjiaadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ImageView img_dianzan = view.findViewById(R.id.img_dianzan);
                TextView tv_dianzan_num = view.findViewById(R.id.tv_dianzan_num);
                if (list.get(position).getStatus()){
                    if (!utils.isDoubleClick()){
                        initNoDianZan(list.get(position), img_dianzan, tv_dianzan_num);
                    }
                }else{
                    if (!utils.isDoubleClick()){
                        initDianZan(list.get(position),img_dianzan,tv_dianzan_num);
                    }
                }
            }
        });
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData();
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

    private void initNoDianZan(PingJia.ResultBean.ListBean listBean, ImageView img_dianzan, TextView tv_dianzan_num) {
        Map<String,String> map = new HashMap<>();
        Integer integer = Integer.valueOf(tv_dianzan_num.getText().toString());
        map.put("id",String.valueOf(listBean.getId()));
        map.put("userId",String.valueOf(userid));
        OkGo.<String>post(Contacts.URl2+"giveFavour")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                tv_dianzan_num.setText(String.valueOf(integer-1));
                                listBean.setStatus(false);
                                img_dianzan.setImageResource(R.mipmap.img_dianzan);
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initDianZan(PingJia.ResultBean.ListBean listBean, ImageView img_dianzan, TextView tv_dianzan_num) {
        Map<String,String> map = new HashMap<>();
        map.put("id",String.valueOf(listBean.getId()));
        Integer integer = Integer.valueOf(tv_dianzan_num.getText().toString());
        map.put("userId",String.valueOf(userid));
        OkGo.<String>post(Contacts.URl2+"giveFavour")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                img_dianzan.setImageResource(R.mipmap.img_dianzan);
                                tv_dianzan_num.setText(String.valueOf(integer+1));
                                listBean.setStatus(true);
                                img_dianzan.setImageResource(R.mipmap.img_dianzanok);
                                ToastUtils.showShort(jsonObject.getString("msg"));
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
        Map<String, String> map = new HashMap<>();
        map.put("id",String.valueOf(shopid));
        map.put("page",String.valueOf(page++));
        map.put("pageSize","10");
        OkGo.<String>get(Contacts.URl2+"/selectAppraise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        PingJia pinjia = gson.fromJson(response.body(), PingJia.class);
                        if (pinjia.getStatus() ==1){
                            if (pinjia.getResult().getList().size()>0){
                                pingjiaadapter.add(pinjia.getResult().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else {
                                smartrefreshlayout. finishLoadmoreWithNoMoreData();
                            }
                        }else{
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                    }
                });
    }


    public static Fragment newInstance(int str, String 挑选){
        PingJiaFragment fragment = new PingJiaFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id",str);
        bundle.putString("挑选",挑选);
        fragment.setArguments(bundle);
        return fragment;
    }
}
