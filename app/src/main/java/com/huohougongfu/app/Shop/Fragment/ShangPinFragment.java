package com.huohougongfu.app.Shop.Fragment;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShangPinTuiJianAdapter;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.PopupView.FuWu;
import com.huohougongfu.app.PopupView.GuiGe;
import com.huohougongfu.app.PopupView.YouHuiQuan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
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
public class ShangPinFragment extends Fragment implements View.OnClickListener,IListener {


    private View inflate;
    private TextView tv_yuan_price;
    private RecyclerView rec_shangpin_tuijian;

    public ShangPinFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListenerManager.getInstance().registerListtener(this);
        inflate = inflater.inflate(R.layout.fragment_shang_pin, container, false);
        initData();
        initUI();
        return inflate;
    }

    private void initUI() {
        tv_yuan_price = inflate.findViewById(R.id.tv_yuan_price);

        inflate.findViewById(R.id.bt_detail_lingquan).setOnClickListener(this);
        inflate.findViewById(R.id.bt_detail_fuwu).setOnClickListener(this);
        inflate.findViewById(R.id.bt_detail_guige).setOnClickListener(this);

        rec_shangpin_tuijian = inflate.findViewById(R.id.rec_shangpin_tuijian);
        tv_yuan_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG );
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("service","App.Mixed_Jinse.Zx");
        map.put("channel", "www");
        OkGo.<String>post(Contacts.URl)
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        ShangPinGson shangPinGson = gson.fromJson(response.body(), ShangPinGson.class);
                        if (shangPinGson.getCode() == 200) {
                            initRec(shangPinGson.getData());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }


    private void initRec(ShangPinGson.DataBean data) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置RecyclerView 布局
        rec_shangpin_tuijian.setLayoutManager(layoutmanager);
        ShangPinTuiJianAdapter shangPinTuiJianAdapter = new ShangPinTuiJianAdapter(R.layout.item_shangpin_tuijian,data.getList());
        rec_shangpin_tuijian.setAdapter(shangPinTuiJianAdapter);
    }

    public static Fragment newInstance(String str){
        ShangPinFragment fragment = new ShangPinFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_detail_lingquan:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(getContext())
                            .asCustom(new YouHuiQuan(getContext()))
                            .show();
                }
                break;
            case R.id.bt_detail_fuwu:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(getContext())
                            .asCustom(new FuWu(getContext()))
                            .show();
                }
                break;
            case R.id.bt_detail_guige:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(getContext())
                            .asCustom(new GuiGe(getContext()))
                            .show();
                }
                break;
        }
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 0) {
            ToastUtils.showShort(status);
        }
    }
}
