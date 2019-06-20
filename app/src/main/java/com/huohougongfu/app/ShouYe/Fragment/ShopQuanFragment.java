package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChaQuan;
import com.huohougongfu.app.Gson.MallGson;
import com.huohougongfu.app.PopupView.KaQuanGuiZe;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.MallAdapter;
import com.huohougongfu.app.ShouYe.Adapter.SendKaQuanAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopQuanFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_shangchengquan;
    private String phone;

    public ShopQuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shop_quan, container, false);
        phone = SPUtils.getInstance("登录").getString("phone");
        rec_shangchengquan = inflate.findViewById(R.id.rec_shangchengquan);
        initData();
        return inflate;
    }
    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("tel",phone);
        map.put("type","mall");
        OkGo.<String>post(Contacts.URl1 + "/wallet/coupons")
                .params(map)
                .execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String body = response.body();
                Gson gson = new Gson();
                MallGson chaQuan = gson.fromJson(body, MallGson.class);
                if (chaQuan.getStatus() == 1) {
                    initRec(chaQuan);
                }
            }
        });
    }

    private void initRec(MallGson mall) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_shangchengquan.setLayoutManager(layoutmanager);
        MallAdapter sendadapter = new MallAdapter(R.layout.item_mallkaquan,mall.getResult());
        rec_shangchengquan.setAdapter(sendadapter);
        sendadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_serviceRegulations = view.findViewById(R.id.bt_serviceRegulations);
                switch (view.getId()){
                    case R.id.bt_serviceRegulations:
                        new XPopup.Builder(getContext())
                                .atView(bt_serviceRegulations)
                                .hasShadowBg(false) // 去掉半透明背景
                                .asCustom(new KaQuanGuiZe(getContext(),mall.getResult().get(position).getServiceRegulations()))
                                .show();
                        break;
                    case R.id.bt_zhuanzeng:

                        break;
                }
            }
        });
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        ShopQuanFragment fragment = new ShopQuanFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
