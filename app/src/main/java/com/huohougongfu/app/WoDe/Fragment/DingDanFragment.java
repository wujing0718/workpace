package com.huohougongfu.app.WoDe.Fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.LoginActivity;
import com.huohougongfu.app.Activity.MainActivity;
import com.huohougongfu.app.Gson.ALiPay;
import com.huohougongfu.app.Gson.MyDingDan;
import com.huohougongfu.app.Gson.OKGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.DingDanZhiFu;
import com.huohougongfu.app.PopupView.QuXiaoDingDan;
import com.huohougongfu.app.PopupView.ShopZhiFu;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.DingDanDetailActivity;
import com.huohougongfu.app.WoDe.Activity.DingDanPingJiaActivity;
import com.huohougongfu.app.WoDe.Activity.SettingActivity;
import com.huohougongfu.app.WoDe.Activity.WuLiuActivity;
import com.huohougongfu.app.WoDe.Adapter.MyDingDanAdapter;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;
import io.rong.imkit.RongIM;

/**
 * A simple {@link Fragment} subclass.
 */
public class DingDanFragment extends Fragment {


    private View inflate;
    private MyDingDan mydingdan;
    private RecyclerView rec_chatai_dingdan;
    private MyDingDanAdapter mydingdanadapter;
    private Intent intent;
    private String orderStatus;
    private int id;

    public DingDanFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_my_ding_dan, container, false);
        orderStatus = getArguments().getString("ARGS");
        id = MyApp.instance.getInt("id");
        intent = new Intent();
        rec_chatai_dingdan = inflate.findViewById(R.id.rec_mydingdan);
        initData();
        return inflate;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("createBy",String.valueOf(id));
        map.put("page",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        if (!"".equals(orderStatus)){
            map.put("orderStatus",orderStatus);
        }
        OkGo.<String>get(Contacts.URl1+"order/selectMyOrderAll1")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        mydingdan = gson.fromJson(response.body(), MyDingDan.class);
                        if (mydingdan.getStatus() == 1) {
                            if (mydingdan.getResult().getList().size()>0){
                                rec_chatai_dingdan.setVisibility(View.VISIBLE);
                                initRec(mydingdan.getResult().getList());
                            }else{
                                rec_chatai_dingdan.setVisibility(View.GONE);
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

    private void initRec(List<MyDingDan.ResultBean.ListBean> result) {
        if (result.size()>0){
            rec_chatai_dingdan.setLayoutManager(new LinearLayoutManager(getActivity()));
            mydingdanadapter = new MyDingDanAdapter(R.layout.item_dingdan, result);
            mydingdanadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    intent.putExtra("orderNo",result.get(position).getOrderNo());
                    intent.putExtra("orderStatus",result.get(position).getOrderStatus());
                    intent.setClass(getActivity(),DingDanDetailActivity.class);
                    startActivity(intent);
                }
            });
            mydingdanadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    switch (view.getId()){
                        case R.id.bt_anniu_one:
                            if (result.get(position).getOrderStatus()==1||result.get(position).getOrderStatus()==0){
                                initQuanXiao(result.get(position).getOrderNo(),result.get(position).getOrderStatus());
                            }else if (result.get(position).getOrderStatus()==2||result.get(position).getOrderStatus()==3){
                                intent.setClass(getActivity(),WuLiuActivity.class);
                                startActivity(intent);
                            }else if (result.get(position).getOrderStatus() == -1){
                                //支付
//                                new ShopZhiFu(getActivity(),result.get(position).getOrderNo(),result.get(position));
                            }
                            break;
                        case R.id.bt_anniu_two:
                            if (result.get(position).getOrderStatus()==-4){
                                initDelete(result.get(position).getOrderNo());
                            }else if(result.get(position).getOrderStatus() == 3){
                                String storeLogo = result.get(position).getMallStores().getStoreLogo();
                                String storeName = result.get(position).getMallStores().getStoreName();
                                intent.putExtra("storeLogo",storeLogo);
                                intent.putExtra("storeName",storeName);
                                intent.setClass(getActivity(),DingDanPingJiaActivity.class);
                                startActivity(intent);
                            }else  if (result.get(position).getOrderStatus() == 0){
                                initALi(result.get(position).getOrderNo());
                            }else  if (result.get(position).getOrderStatus() == -1){
                                initDelete(result.get(position).getOrderNo());
                            }else if ( (result.get(position).getOrderStatus() == 2)){
                                initQueRenShouHuo(result.get(position).getOrderNo());
                            }else if ((result.get(position).getOrderStatus() == 1)){
                                //提醒发货
                                initRemind(result.get(position).getOrderNo());
                            }
                            break;
                    }
                }
            });
            rec_chatai_dingdan.setAdapter(mydingdanadapter);
        }else{
            rec_chatai_dingdan.setVisibility(View.GONE);
        }
    }
    //  提醒发货
    private void initRemind(String orderNo) {
        Map<String,String> map = new HashMap<>();
        map.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
        map.put("orderNo",orderNo);
        OkGo.<String>post(Contacts.URl1+"order/orderManage/informSellerSendGoods")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        OKGson okGson = new Gson().fromJson(response.body(), OKGson.class);
                        if (okGson.getStatus() == 1){
                            ToastUtils.showShort("提醒成功");
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(),"请稍后。。。");
                        super.onStart(request);
                    }
                });
    }

    private void initQueRenShouHuo(String orderNo) {
        Map<String,String> map = new HashMap<>();
        map.put("orderNo",orderNo);
        map.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
        OkGo.<String>get(Contacts.URl1+"order/confirmReciver")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status" ) == 1){
                                SelectDialog.show(getActivity(), "提示", "是否确认收货",
                                        "确定", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if(!utils.isDoubleClick()){
                                                    initData();
                                                }
                                            }
                                        },
                                        "取消", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                            }
                                        });
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //支付宝支付
    private void initALi(String orderNo) {
        OkGo.<String>post(Contacts.URl1+"apliyConfirmPaymentMoreOrderNo")
                .params("orderNos",orderNo)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        ALiPay aLiPay = new Gson().fromJson(body, ALiPay.class);
                        if (aLiPay.getStatus() == 1){
                            new XPopup.Builder(getActivity())
                                    .asCustom(new DingDanZhiFu(getActivity(),aLiPay.getResult().getOrderString(),
                                            String.valueOf(aLiPay.getResult().getPriceTotal())))
                                    .show();
                        }
                    }
                });
    }
    //  取消订单
    private void initQuanXiao(String orderNo, int orderStatus) {
        new XPopup.Builder(getActivity())
                .asCustom(new QuXiaoDingDan(getActivity(),orderStatus,orderNo))
                .show();
    }

    //  删除订单
    private void initDelete(String orderNo) {
        SelectDialog.show(getActivity(), "提示", "是否删除订单",
                "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!utils.isDoubleClick()){
                            Map<String,String> map = new HashMap<>();
                            map.put("createBy",String.valueOf(id));
                            map.put("orderNo",orderNo);
                            OkGo.<String>post(Contacts.URl1+"order/deleteOrder")
                                    .params(map)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(Response<String> response) {
                                            String body = response.body();
                                            try {
                                                JSONObject jsonObject = new JSONObject(body);
                                                if (jsonObject.getInt("status") == 1){
                                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                                    mydingdanadapter.notifyDataSetChanged();
                                                }else{
                                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                        }
                    }
                },
                "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
    }

    public static Fragment newInstance(String orderStatus) {
        Bundle args = new Bundle();
        args.putString("ARGS", orderStatus);
        DingDanFragment fragment = new DingDanFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
