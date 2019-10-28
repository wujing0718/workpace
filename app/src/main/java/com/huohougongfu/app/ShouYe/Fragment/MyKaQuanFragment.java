package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChaQuan;
import com.huohougongfu.app.Gson.MyCaQuan;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.KaQuanGuiZe;
import com.huohougongfu.app.PopupView.PopupCoupon;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.MyKaQuanAdapter;
import com.huohougongfu.app.ShouYe.Adapter.ShouDaoAdapter;
import com.huohougongfu.app.ShouYe.Adapter.WoDeAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
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
public class MyKaQuanFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_kaquan_wode,rec_kaquan_shoudao;
    private String token,tel,id;
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
    public MyKaQuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_my_ka_quan, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        initData();
        return inflate;
    }
    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("mId",id);
        map.put("token",token);
        map.put("type","enableSend");
        OkGo.<String>post(Contacts.URl1+"/wallet/coupons")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        MyCaQuan chaQuan = gson.fromJson(response.body(), MyCaQuan.class);
                        if (chaQuan.getStatus() == 1) {
                            if (chaQuan.getResult().size()>0){
                                rec_kaquan_wode.setVisibility(View.VISIBLE);
                                initRecWoDe(chaQuan.getResult());
                            }else{
                                rec_kaquan_wode.setVisibility(View.GONE);
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

    private void initRecWoDe(List<MyCaQuan.ResultBean> result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        //设置RecyclerView 布局
        rec_kaquan_wode.setLayoutManager(layoutmanager);
        MyKaQuanAdapter wodeadapter = new MyKaQuanAdapter(R.layout.item_wodekaquan,result);
        rec_kaquan_wode.setAdapter(wodeadapter);
        wodeadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_serviceRegulations = view.findViewById(R.id.bt_serviceRegulations);
                switch (view.getId()){
                    case R.id.bt_serviceRegulations:
                        if (!utils.isDoubleClick()){
                            new XPopup.Builder(getContext())
                                    .atView(bt_serviceRegulations)
                                    .hasShadowBg(false) // 去掉半透明背景
                                    .asCustom(new KaQuanGuiZe(getContext(),result.get(position).getServiceRegulations()))
                                    .show();
                        }
                        break;
                    case R.id.bt_zhuanzeng:
                        if (!utils.isDoubleClick()){
                            new XPopup.Builder(getContext())
                                    .asCustom(new PopupCoupon(getContext(), getActivity(), result.get(position).getId()))
                                    .show();
                        }
                        break;
                }
            }
        });


    }


    private void initUI() {
        rec_kaquan_wode = inflate.findViewById(R.id.rec_kaquan_wode);
    }

    public static Fragment newInstance(String str){
        MyKaQuanFragment fragment = new MyKaQuanFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
