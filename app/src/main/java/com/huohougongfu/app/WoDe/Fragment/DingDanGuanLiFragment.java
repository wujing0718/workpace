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
import com.huohougongfu.app.Gson.DingDanGuanLi;
import com.huohougongfu.app.Gson.QueRenFaHuo;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.QuXiaoDingDan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.DingDanDetailActivity;
import com.huohougongfu.app.WoDe.Activity.DingDanPingJiaActivity;
import com.huohougongfu.app.WoDe.Activity.TianXieWuLiuActivity;
import com.huohougongfu.app.WoDe.Activity.WuLiuActivity;
import com.huohougongfu.app.WoDe.Adapter.DingDanGuanLiAdapter;
import com.kongzue.dialog.v2.SelectDialog;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.imkit.RongIM;

/**
 * A simple {@link Fragment} subclass.
 */
public class DingDanGuanLiFragment extends Fragment {


    private View inflate;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_dingdan_guanli;
    private String status;
    private Intent intent;
    private int id;
    private DingDanGuanLiAdapter dingDanGuanLiAdapter;
    private String token;

    public DingDanGuanLiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_ding_dan_guan_li, container, false);
        status = getArguments().getString("ARGS");
        id = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        intent = new Intent();
        initUI();
        return inflate;
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initUI() {
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_dingdan_guanli = inflate.findViewById(R.id.rec_dingdan_guanli);
    }
    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
        map.put("status",status);
        OkGo.<String>get(Contacts.URl1+"order/orderManage/getOrderByStatus")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        DingDanGuanLi myCollect = gson.fromJson(body, DingDanGuanLi.class);
                        if (myCollect.getStatus() == 1){
                            if (myCollect.getResult().size()==0){
                                smartrefreshlayout.setVisibility(View.GONE);
                            }else{
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec(myCollect.getResult());
                            }
                        }
                    }
                });
    }

    private void initRec(List<DingDanGuanLi.ResultBean> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rec_dingdan_guanli.setLayoutManager(layoutManager);
        dingDanGuanLiAdapter = new DingDanGuanLiAdapter(R.layout.item_dingdan_guanli, list);
        rec_dingdan_guanli.setAdapter(dingDanGuanLiAdapter);
        dingDanGuanLiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                intent.putExtra("orderNo",list.get(position).getOrderNo());
                intent.putExtra("orderStatus",list.get(position).getOrderStatus());
                intent.putExtra("ofManager",1);
                intent.setClass(getActivity(),DingDanDetailActivity.class);
                startActivity(intent);
            }
        });
        dingDanGuanLiAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.bt_anniu_one:
                        if (list.get(position).getOrderStatus()==1||list.get(position).getOrderStatus()==0){
                            initQuanXiao(list.get(position).getOrderNo(),list.get(position).getOrderStatus());
                        }else if (list.get(position).getOrderStatus()==2||list.get(position).getOrderStatus()==3){
                            intent.setClass(getActivity(),WuLiuActivity.class);
                            startActivity(intent);
                        }else if (list.get(position).getOrderStatus() == -1){
                            //支付
//                                new ShopZhiFu(getActivity(),result.get(position).getOrderNo(),result.get(position));
                        }
                        break;
                    case R.id.bt_anniu_two:
                        if (list.get(position).getOrderStatus()==-4){
                            initDelete(list.get(position).getOrderNo());
                        }else if(list.get(position).getOrderStatus() == 3){
                            intent.setClass(getActivity(),DingDanPingJiaActivity.class);
                            startActivity(intent);
                        }else  if (list.get(position).getOrderStatus() == 0){
                            if (!utils.isDoubleClick()){
                                if (!token.isEmpty()){
                                    RongIM.getInstance().startPrivateChat(getActivity(),
                                            list.get(position).getPhone(),list.get(position).getPhone());
                                }else{
                                    ToastUtils.showShort("请登录后操作");
                                }
                            }
                        }else  if (list.get(position).getOrderStatus() == -1){
                            initDelete(list.get(position).getOrderNo());
                        }else  if (list.get(position).getOrderStatus() == 1){
                            Intent intent = new Intent();
                            intent.putExtra("orderNo",list.get(position).getOrderNo());
                            intent.setClass(getActivity(), TianXieWuLiuActivity.class);
                            startActivity(intent);
                        }
                        break;
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
                                                    dingDanGuanLiAdapter.notifyDataSetChanged();
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


    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        DingDanGuanLiFragment fragment = new DingDanGuanLiFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
