package com.huohougongfu.app.WoDe.Fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MyDingDan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.QuXiaoDingDan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.DingDanDetailActivity;
import com.huohougongfu.app.WoDe.Activity.DingDanPingJiaActivity;
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
                            if (mydingdan.getResult().size()>0){
                                rec_chatai_dingdan.setVisibility(View.VISIBLE);
                                initRec(mydingdan.getResult());
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

    private void initRec(List<MyDingDan.ResultBean> result) {
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
                                ToastUtils.showShort("查看物流");
                            }else if (result.get(position).getOrderStatus() == -1){
                                ToastUtils.showShort("查看物流");
                            }
                            break;
                        case R.id.bt_anniu_two:
                            if (result.get(position).getOrderStatus()==-4){
                                initDelete(result.get(position).getOrderNo());
                            }else if(result.get(position).getOrderStatus() == 3){
                                intent.setClass(getActivity(),DingDanPingJiaActivity.class);
                                startActivity(intent);
                            }else  if (result.get(position).getOrderStatus() == 0){
                                ToastUtils.showShort("确认付款");
                            }else  if (result.get(position).getOrderStatus() == -1){
                                initDelete(result.get(position).getOrderNo());
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
