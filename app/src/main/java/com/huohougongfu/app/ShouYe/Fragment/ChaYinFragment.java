package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.huohougongfu.app.Gson.QuanZiShare;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.KaQuanGuiZe;
import com.huohougongfu.app.PopupView.PopupCoupon;
import com.huohougongfu.app.QuanZi.Activity.WenZhangDetailActivity;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.MeKaQuanAdapter;
import com.huohougongfu.app.ShouYe.Adapter.SendKaQuanAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChaYinFragment extends Fragment implements UMShareListener{


    private View inflate;
    private RecyclerView rec_wodequan,rec_woshoudaoquan;
    private String phone;
    private boolean isfrist = true;
    private String token,tel,id;
    private View view_zhanweitu1,view_zhanweitu2;
    private QuanZiShare share;

    public ChaYinFragment() {
        // Required empty public constructor
    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {

        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {

        }
    };

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
        map.put("mId",id);
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
                            if (chaQuan.getResult().getMe().size()>0){
                                view_zhanweitu1.setVisibility(View.GONE);
                                rec_wodequan.setVisibility(View.VISIBLE);
                                initME(chaQuan.getResult().getMe());
                            }else{
                                rec_wodequan.setVisibility(View.GONE);
                            }
                            if (chaQuan.getResult().getReceived().size()>0){
                                view_zhanweitu2.setVisibility(View.GONE);
                                rec_woshoudaoquan.setVisibility(View.VISIBLE);
                                initSend(chaQuan.getResult().getReceived());
                            }else{
                                rec_woshoudaoquan.setVisibility(View.GONE);
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

    private void initSend(List<ChaQuan.ResultBean.ReceivedBean> send) {
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
                        if (!utils.isDoubleClick()){
                            new XPopup.Builder(getContext())
                                    .asCustom(new PopupCoupon(getContext(), getActivity(), me.get(position).getId()))
                                    .show();
                        }
                        break;
                }
            }
        });
    }

    private void initUI() {
        view_zhanweitu1 = inflate.findViewById(R.id.view_zhanweitu1);
        view_zhanweitu2 =inflate.findViewById(R.id.view_zhanweitu2);
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

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {

    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {

    }
}
