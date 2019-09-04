package com.huohougongfu.app.ShouYe.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ChaTaiAdapter;
import com.huohougongfu.app.Adapter.ChaTaiDingDanAdapter;
import com.huohougongfu.app.Gson.ChaTaiDingDan;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.ChaTaiZhiFu;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Activity.ChaTaiDingDanDetail;
import com.huohougongfu.app.ShouYe.Activity.MaiChaDetailActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.SmoothCheckBox;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
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
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class DingDanFragment extends Fragment {


    private View inflate;
    private ChaTaiDingDan shangPinGson;
    private RecyclerView rec_chatai_dingdan;
    private ChaTaiDingDanAdapter mAdapter;
    private int mId;
    private View view_zhanweitu;
    private SmartRefreshLayout smartrefreshlayout;
    private int page = 2;

    public DingDanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_ding_dan, container, false);
        view_zhanweitu = inflate.findViewById(R.id.view_zhanweitu);
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        mId = MyApp.instance.getInt("id");
        return inflate;

    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mAdapter != null) {
            mAdapter.cancelAllTimers();
        }
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pageNo", "1");
        map.put("pageSize", "10");
        OkGo.<String>post(Contacts.URl1+"/machine/teaTable/orderList")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        shangPinGson = gson.fromJson(response.body(), ChaTaiDingDan.class);
                        if (shangPinGson.getStatus() == 1) {
                            initRec(shangPinGson.getResult());
                            if(shangPinGson.getResult().getList().size()>0){
                                view_zhanweitu.setVisibility(View.GONE);
                            }else{
                                view_zhanweitu.setVisibility(View.VISIBLE);
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

    private void initRec(ChaTaiDingDan.ResultBean data) {
        rec_chatai_dingdan = inflate.findViewById(R.id.rec_chatai_dingdan);
        rec_chatai_dingdan.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ChaTaiDingDanAdapter(R.layout.item_chatai_dingdan, data.getList());
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("type",data.getList().get(position).getType());
                intent.putExtra("orderNo",data.getList().get(position).getId());
                startActivity( intent.setClass(getActivity(),ChaTaiDingDanDetail.class));
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Button bt_queding = view.findViewById(R.id.btn_queidng);
                if (bt_queding.getText().toString().equals("删除订单")){
                    initDelect(data.getList().get(position).getId());
                }else if ("0".equals(data.getList().get(position).getOrderStatus())){
                    new XPopup.Builder(getActivity())
                            .asCustom(new ChaTaiZhiFu(getActivity(),data.getList().get(position).getOrderNo(),shangPinGson.getResult().getList().get(position).getOrderTotal()))
                            .show();
                }else if ("1".equals(data.getList().get(position).getOrderStatus())){

                }else if ("2".equals(data.getList().get(position).getOrderStatus())){
                    ToastUtils.showShort("该订单已消费");
                }
            }
        });
        rec_chatai_dingdan.setAdapter(mAdapter);
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

    private void initAdd() {
        Map<String, String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pageNo", String.valueOf(page++));
        map.put("pageSize", "10");
        OkGo.<String>post(Contacts.URl1+"/machine/teaTable/orderList")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        shangPinGson = gson.fromJson(response.body(), ChaTaiDingDan.class);
                        if (shangPinGson.getStatus() == 1) {
                            if (shangPinGson.getResult().getList().size()>0){
                                mAdapter.add(shangPinGson.getResult().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else {
                                smartrefreshlayout. finishLoadmoreWithNoMoreData();
                            }
                        }
                    }
                });
    }

    private void initDelect(int id) {
        OkGo.<String>get(Contacts.URl1+"/machine/delMachineOrder/"+id)
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
    }

    public static Fragment newInstance(String str){
        DingDanFragment fragment = new DingDanFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
