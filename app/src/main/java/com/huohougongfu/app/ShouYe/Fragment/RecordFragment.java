package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.KaQuanRecord;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.KaQuanGuiZe;
import com.huohougongfu.app.PopupView.PopupCoupon;
import com.huohougongfu.app.QuanZi.Adapter.WenZhangAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.RecordAdapter;
import com.huohougongfu.app.ShouYe.Adapter.SongChuAdapter;
import com.huohougongfu.app.ShouYe.Adapter.WoDeAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
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
public class RecordFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_kaquan_record;
    private String token,tel,id;
    private RecyclerView rec_shixiao,rec_songchu;
    private View view_zhanweitu1,view_zhanweitu2;

    public RecordFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_record, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        initData();
        return inflate;
    }
    private void initUI() {
        view_zhanweitu1 = inflate.findViewById(R.id.view_zhanweitu1);
        view_zhanweitu2 = inflate.findViewById(R.id.view_zhanweitu2);
        rec_shixiao = inflate.findViewById(R.id.rec_shixiao);
        rec_songchu = inflate.findViewById(R.id.rec_songchu);
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("mId",id);
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/wallet/coupons/invalid")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        KaQuanRecord record = gson.fromJson(body, KaQuanRecord.class);
                        if (record.getStatus() ==1){
                            if (record.getResult().getSend().size()>0){
                                view_zhanweitu2.setVisibility(View.GONE);
                                rec_songchu.setVisibility(View.VISIBLE);
                                initSongChu(record.getResult());
                            }else{
                                view_zhanweitu2.setVisibility(View.VISIBLE);
                                rec_songchu.setVisibility(View.GONE);
                            }
                            if (record.getResult().getInvalid().size()>0){
                                view_zhanweitu1.setVisibility(View.GONE);
                                rec_shixiao.setVisibility(View.VISIBLE);
                                initShiXiao(record.getResult());
                            }else{
                                view_zhanweitu1.setVisibility(View.VISIBLE);
                                rec_shixiao.setVisibility(View.GONE);
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

    private void initShiXiao(KaQuanRecord.ResultBean result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_shixiao.setLayoutManager(layoutmanager);
        RecordAdapter recordAdapter = new RecordAdapter(R.layout.item_wodekaquan, result.getInvalid());
        rec_shixiao.setAdapter(recordAdapter);
        recordAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_serviceRegulations = view.findViewById(R.id.bt_serviceRegulations);
                switch (view.getId()){
                    case R.id.bt_serviceRegulations:
                        if (!utils.isDoubleClick()){
                            new XPopup.Builder(getContext())
                                    .atView(bt_serviceRegulations)
                                    .hasShadowBg(false) // 去掉半透明背景
                                    .asCustom(new KaQuanGuiZe(getContext(),result.getInvalid().get(position).getServiceRegulations()))
                                    .show();
                        }
                        break;
                    case R.id.bt_zhuanzeng:
                        if (!utils.isDoubleClick()){
                            new XPopup.Builder(getContext())
                                    .asCustom(new PopupCoupon(getContext(), getActivity(), result.getInvalid().get(position).getId()))
                                    .show();
                        }
                        break;
                }
            }
        });

    }

    private void initSongChu(KaQuanRecord.ResultBean result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_songchu.setLayoutManager(layoutmanager);
        SongChuAdapter songchu= new SongChuAdapter(R.layout.item_wodekaquan,result.getSend());
        rec_songchu.setAdapter(songchu);
        songchu.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_serviceRegulations = view.findViewById(R.id.bt_serviceRegulations);
                switch (view.getId()){
                    case R.id.bt_serviceRegulations:
                        if (!utils.isDoubleClick()){
                            new XPopup.Builder(getContext())
                                    .atView(bt_serviceRegulations)
                                    .hasShadowBg(false) // 去掉半透明背景
                                    .asCustom(new KaQuanGuiZe(getContext(),result.getSend().get(position).getServiceRegulations()))
                                    .show();
                        }
                        break;
                    case R.id.bt_zhuanzeng:
                        if (!utils.isDoubleClick()){
                            new XPopup.Builder(getContext())
                                    .asCustom(new PopupCoupon(getContext(), getActivity(), result.getInvalid().get(position).getId()))
                                    .show();
                        }
                        break;
                }
            }
        });

    }

    public static Fragment newInstance(String str){
        RecordFragment fragment = new RecordFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
