package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShangPinAdapter;
import com.huohougongfu.app.Gson.ChaQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.KaQuanGuiZe;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.MeKaQuanAdapter;
import com.huohougongfu.app.ShouYe.Adapter.SendKaQuanAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
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
public class ChaYinFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_wodequan,rec_woshoudaoquan;
    private String phone;
    private boolean isfrist = true;
    private String token,tel,id;

    public ChaYinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_cha_yin, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        initData();
        return inflate;
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("id",id);
        map.put("token",token);
        map.put("type","tea");
        OkGo.<String>post(Contacts.URl1+"/wallet/coupons")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        ChaQuan chaQuan = gson.fromJson(body, ChaQuan.class);
                        if (chaQuan.getStatus() == 1){
                            initME(chaQuan.getResult().getMe());
                            initSend(chaQuan.getResult().getSend());
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initSend(List<ChaQuan.ResultBean.SendBean> send) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_woshoudaoquan.setLayoutManager(layoutmanager);
        SendKaQuanAdapter sendadapter = new SendKaQuanAdapter(R.layout.item_wodekaquan,send);
        rec_woshoudaoquan.setAdapter(sendadapter);
        sendadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_serviceRegulations = view.findViewById(R.id.bt_serviceRegulations);
//                TextView tv_guize = view.findViewById(R.id.tv_guize);
                switch (view.getId()){
                    case R.id.bt_serviceRegulations:
//                        if (tv_guize.getVisibility() == View.GONE){
//                            tv_guize.setVisibility(View.VISIBLE);
//                        }else{
//                            tv_guize.setVisibility(View.GONE);
//                        }
                        new XPopup.Builder(getContext())
                                .atView(bt_serviceRegulations)
                                .hasShadowBg(false) // 去掉半透明背景
                                .asCustom(new KaQuanGuiZe(getContext(),send.get(position).getServiceRegulations()))
                                .show();
                        break;
                    case R.id.bt_zhuanzeng:
                            ToastUtils.showShort("转增");
                        break;
                }
            }
        });
    }

    private void initME(List<ChaQuan.ResultBean.MeBean> me) {
    //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_wodequan.setLayoutManager(layoutmanager);
        MeKaQuanAdapter meadapter = new MeKaQuanAdapter(R.layout.item_wodekaquan,me);
        rec_wodequan.setAdapter(meadapter);
        meadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_serviceRegulations = view.findViewById(R.id.bt_serviceRegulations);
                switch (view.getId()){
                    case R.id.bt_serviceRegulations:
                        new XPopup.Builder(getContext())
                                .atView(bt_serviceRegulations)
                                .hasShadowBg(false) // 去掉半透明背景
                                .asCustom(new KaQuanGuiZe(getContext(),me.get(position).getServiceRegulations()))
                                .show();
                        break;
                    case R.id.bt_zhuanzeng:
                        ToastUtils.showShort("转增");
                        break;
                }
            }
        });
    }

    private void initUI() {
        rec_wodequan = inflate.findViewById(R.id.rec_wodequan);
         rec_woshoudaoquan = inflate.findViewById(R.id.rec_woshoudaoquan);
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        ChaYinFragment fragment = new ChaYinFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
