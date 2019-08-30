package com.huohougongfu.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.MainActivity;
import com.huohougongfu.app.Adapter.ShouYeAdapter;
import com.huohougongfu.app.Gson.MaiChaDetail;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Activity.MaiChaDetailActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaiChaFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_bianxie;
    private String equipmentId;

    public MaiChaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_mai_cha, container, false);
        equipmentId = getArguments().getString("ARGS");
        initData();
        return inflate;
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("equipmentId",equipmentId);
        OkGo.<String>post(Contacts.URl1+"/machine/productList")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        MaiChaDetail shangPinGson = gson.fromJson(response.body(), MaiChaDetail.class);
                        if (shangPinGson.getStatus() == 1) {
                            initRec(shangPinGson.getResult());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getContext(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(List<MaiChaDetail.ResultBean> result) {
        rec_bianxie = inflate.findViewById(R.id.rec_bianxie);
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(getActivity(),3);
        //设置RecyclerView 布局
        rec_bianxie.setLayoutManager(layoutmanager);
        ShouYeAdapter shouYeAdapter = new ShouYeAdapter(R.layout.item_shouye_maicha,result);
        rec_bianxie.setAdapter(shouYeAdapter);
        shouYeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("买茶",result.get(position));
                intent.setClass(getActivity(),MaiChaDetailActivity.class);
                startActivity(intent);
            }
        });
    }


    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        MaiChaFragment fragment = new MaiChaFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
