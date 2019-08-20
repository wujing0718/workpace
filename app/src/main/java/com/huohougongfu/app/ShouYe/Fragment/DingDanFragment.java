package com.huohougongfu.app.ShouYe.Fragment;


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

    public DingDanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_ding_dan, container, false);
        view_zhanweitu = inflate.findViewById(R.id.view_zhanweitu);
        mId = MyApp.instance.getInt("id");
        initData();
        return inflate;

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
                intent.putExtra("teaid",data.getList().get(position).getId());
                startActivity( intent.setClass(getActivity(),ChaTaiDingDanDetail.class));
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if ("0".equals(data.getList().get(position).getOrderStatus())){
                    new XPopup.Builder(getContext())
                            .asCustom(new ChaTaiZhiFu(getContext(),data.getList().get(position).getOrderNo()))
                            .show();
                }else if ("1".equals(data.getList().get(position).getOrderStatus())){

                }else if ("2".equals(data.getList().get(position).getOrderStatus())){
                    ToastUtils.showShort("该订单已消费");
                }
            }
        });
        rec_chatai_dingdan.setAdapter(mAdapter);
    }
    
    public static Fragment newInstance(String str){
        DingDanFragment fragment = new DingDanFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
