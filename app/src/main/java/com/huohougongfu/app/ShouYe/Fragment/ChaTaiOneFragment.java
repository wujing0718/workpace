package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ChaTaiAdapter;
import com.huohougongfu.app.Gson.ChaTaiGson;
import com.huohougongfu.app.Gson.ChaTaiYouHuiQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.CTYouHuiQuan;
import com.huohougongfu.app.PopupView.ChaTaiZhiFu;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChaTaiOneFragment extends Fragment implements View.OnClickListener {


    private static final String KEY ="MachineId";
    private View inflate;
    private ListView rec_chatai;
    private ChaTaiAdapter shangPinAdapter;
    private ChaTaiGson chatai;
    private TextView tv_manjian2,tv_manjian1;
    private Button mBtnSubmit;
    private ChaTaiAdapter mAdapter;
    private View bt_checkbox;
    private Button btn_go_to_pay;
    private ImageView img_check;
    private TextView tv_total_price;
    private TextView tv_chami_dikou;
    private ImageView img_chami_check;
    private View bt_chami_dikou;
    private boolean isDikou = true;
    double price;
    private ChaTaiYouHuiQuan.ResultBean myouhuiquan;
    private String machineId;
    private ChaTaiYouHuiQuan.ResultBean.CouponsBean xuanzeyouhuiquan;

    public ChaTaiOneFragment() {
        // Required empty public constructor
    }

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    xuanzeyouhuiquan = (ChaTaiYouHuiQuan.ResultBean.CouponsBean)msg.obj;
                    tv_manjian1.setText(xuanzeyouhuiquan.getTitle());
                    tv_manjian2.setText("");
                    break;
                default:
                    break;
            }
        }

    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_cha_tai_one, container, false);
        machineId = getArguments().getString(KEY);
        initYouHuiQuan();
        initUI();
        return inflate;
    }

    @Override
    public void onResume() {
        initYouHuiQuan();
        super.onResume();
    }

    private void initUI() {
        mBtnSubmit =inflate.findViewById(R.id.btn_go_to_pay);
        inflate.findViewById(R.id.bt_checkbox).setOnClickListener(this);
        bt_checkbox = inflate.findViewById(R.id.bt_checkbox);
        bt_checkbox.setOnClickListener(this);
        btn_go_to_pay = inflate.findViewById(R.id.btn_go_to_pay);
        btn_go_to_pay.setOnClickListener(this);
        mBtnSubmit.setOnClickListener(this);
        inflate.findViewById(R.id.bt_detail_lingquan).setOnClickListener(this);
        img_check = inflate.findViewById(R.id.img_check);
        tv_total_price = inflate.findViewById(R.id.tv_total_price);
        tv_manjian1 = inflate.findViewById(R.id.tv_manjian1);
        tv_manjian2 = inflate.findViewById(R.id.tv_manjian2);
        tv_chami_dikou = inflate.findViewById(R.id.tv_chami_dikou);
        img_chami_check = inflate.findViewById(R.id.img_chami_check);
        bt_chami_dikou = inflate.findViewById(R.id.bt_chami_dikou);
//        bt_chami_dikou.setOnClickListener(this);
    }

    private void initData(ChaTaiYouHuiQuan.ResultBean myouhuiquan) {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("machineId",machineId);
        OkGo.<String>post(Contacts.URl1+"/machine/findTeaTable/")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        chatai = gson.fromJson(response.body(), ChaTaiGson.class);
                        if (chatai.getStatus() == 1) {
                            initRec(chatai.getResult(),myouhuiquan);
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    /*
        优惠券列表数据
     */
    private void initYouHuiQuan() {
        Map<String,String> map = new HashMap<>();
        map.put("tel",MyApp.instance.getString("phone"));
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("machineId",machineId);
        OkGo.<String>post(Contacts.URl1+"/machine/getPreferential")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ChaTaiYouHuiQuan youhuiquan = gson.fromJson(body, ChaTaiYouHuiQuan.class);
                        if (youhuiquan.getStatus() == 1){
                            myouhuiquan = youhuiquan.getResult();
                            initData(myouhuiquan);
                            tv_chami_dikou.setText("可用"+youhuiquan.getResult().getTeaRice()+"茶米抵扣"+
                                    (youhuiquan.getResult().getTeaRice()*youhuiquan.getResult().getProportion())+"元");
                            if (myouhuiquan.getCoupons().size()>1){
                                tv_manjian1.setText(myouhuiquan.getCoupons().get(0).getServiceRegulations());
                                tv_manjian2.setText(myouhuiquan.getCoupons().get(1).getServiceRegulations());
                            }else if(myouhuiquan.getCoupons().size() ==1){
                                tv_manjian1.setText(myouhuiquan.getCoupons().get(0).getServiceRegulations());
                            }else if (myouhuiquan.getCoupons().size()<0){
                                tv_manjian1.setText("暂无优惠券");
                            }
                        }
                    }
                });
    }

    private void initRec(List<ChaTaiGson.ResultBean> result, ChaTaiYouHuiQuan.ResultBean myouhuiquan) {
        rec_chatai = inflate.findViewById(R.id.rec_chatai);
//        rec_chatai.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rec_chatai.setHasFixedSize(true);
        mAdapter = new ChaTaiAdapter(R.layout.item_shouye_chataione,bt_checkbox,btn_go_to_pay,result,getActivity()
                ,img_check,tv_total_price,bt_chami_dikou,img_chami_check, myouhuiquan);
        mAdapter.setData(result);
        mAdapter.setOnChangeCountListener(new ChaTaiAdapter.OnChangeCountListener() {

            @Override
            public void onChangeCount(double total_price, JSONArray array, int teaRice) {
                initORder(total_price,array,teaRice);
            }

        });
        rec_chatai.setAdapter(mAdapter);
    }

    private void initORder(double total_price, JSONArray array, int teaRice) {
        Map<String,String> map = new HashMap<>();
        map.put("json",array.toString());
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("machineId",machineId);
        if (xuanzeyouhuiquan!=null){
            map.put("couponId",String.valueOf(xuanzeyouhuiquan.getId()));
        }
        map.put("totalPrice",String.valueOf(total_price));
        map.put("teaRiceNum",String.valueOf(teaRice));
        OkGo.<String>post(Contacts.URl1+"/machine/generate/orders")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                new XPopup.Builder(getContext())
                                        .asCustom(new ChaTaiZhiFu(getContext()))
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public static Fragment newInstance(String str){
        ChaTaiOneFragment fragment = new ChaTaiOneFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY,str);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_detail_lingquan:
                if (!utils.isDoubleClick()) {
                    if (myouhuiquan != null) {
                        if (myouhuiquan.getCoupons().size()>0){
                            new XPopup.Builder(getContext())
                                    .asCustom(new CTYouHuiQuan(getContext(), myouhuiquan.getCoupons(),mHandler))
                                    .show();
                        }else {
                            ToastUtils.showShort("暂无优惠券");
                        }
                    }
                }
                break;
        }
    }
}
