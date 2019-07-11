package com.huohougongfu.app.Shop.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ShopCanShu;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.CanShuContentAdapter;
import com.huohougongfu.app.Shop.Adapter.CanShuNameAdapter;
import com.huohougongfu.app.Shop.Adapter.ShopAdapter;
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
public class CanShuFragment extends Fragment {


    private View inflate;
    private String token,tel,id;
    private int shopid;
    private RecyclerView rec_canshu_name,rec_canshu_content;
    private CanShuNameAdapter nameadapter;
    private CanShuContentAdapter contentadapter;

    public CanShuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_can_shu, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        shopid = getArguments().getInt("id");
        initUI();
        initData();
        return inflate;
    }

    private void initUI() {
        rec_canshu_name = inflate.findViewById(R.id.rec_canshu_name);
        rec_canshu_content = inflate.findViewById(R.id.rec_canshu_content);

    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("id",String.valueOf(shopid));
        map.put("token",token);
        OkGo.<String>get(Contacts.URl2+"selectProductAttribute")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        ShopCanShu canshu = gson.fromJson(response.body(), ShopCanShu.class);
                        if (canshu.getStatus() == 1) {
                            if (canshu.getResult()!=null) {
                                initRecName(canshu);
                                initRecContent(canshu);
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

    private void initRecContent(ShopCanShu canshu) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_canshu_content.setLayoutManager(layoutmanager);
        nameadapter = new CanShuNameAdapter(canshu.getResult().getVal());
        rec_canshu_content.setAdapter(nameadapter);
    }

    private void initRecName(ShopCanShu canshu) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_canshu_name.setLayoutManager(layoutmanager);
        contentadapter = new CanShuContentAdapter(canshu.getResult().getKeys());
        rec_canshu_name.setAdapter(contentadapter);
    }

    public static Fragment newInstance(int str){
        CanShuFragment fragment = new CanShuFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
