package com.huohougongfu.app.Shop.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShangPinAdapter;
import com.huohougongfu.app.Gson.DaShi;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.Gson.ZhaoRenGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;
import com.huohougongfu.app.Shop.Adapter.DaShiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class SouSuoDaShiFragment extends Fragment implements IListener {


    private View inflate;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_sousuo_dashi;

    public SouSuoDaShiFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListenerManager.getInstance().registerListtener(this);
        inflate = inflater.inflate(R.layout.fragment_sou_suo_da_shi, container, false);
        initUI();
        initData();
        return inflate;
    }

    @Override
    public void onStart() {
        super.onStart();
        String sousuo = getArguments().getString("SOUSUO");
    }

    private void initUI() {
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_sousuo_dashi = inflate.findViewById(R.id.rec_sousuo_dashi);
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        OkGo.<String>get(Contacts.URl2+"/query/queryMasterList")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        DaShi dashi = gson.fromJson(response.body(), DaShi.class);
                        if (dashi.getStatus() == 1) {
                            initRec(dashi.getResult());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(List<DaShi.ResultBean> result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_sousuo_dashi.setLayoutManager(layoutmanager);
        DaShiAdapter shangPinAdapter = new DaShiAdapter(R.layout.item_shop_sousuo_dashi, result);
        rec_sousuo_dashi.setAdapter(shangPinAdapter);
        shangPinAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),ShangPinDetailActivity.class);
                startActivity(intent);
            }
        });
    }
    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        SouSuoDaShiFragment fragment = new SouSuoDaShiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 0){
            Log.e("++++++++",status);
        }
    }
}
