package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
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

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ChaTaiAdapter;
import com.huohougongfu.app.Gson.ChaTaiGson;
import com.huohougongfu.app.Gson.ChaTaiYouHuiQuan;
import com.huohougongfu.app.Gson.ShopYouHuiQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.CTYouHuiQuan;
import com.huohougongfu.app.PopupView.YouHuiQuan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
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
public class ChaTaiOneFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private ListView rec_chatai;
    private ChaTaiAdapter shangPinAdapter;
    private ChaTaiGson chatai;
    private TextView mTvTotal,tv_manjian2,tv_manjian1;
    private Button mBtnSubmit;
    private ChaTaiAdapter mAdapter;
    private View bt_checkbox;
    private Button btn_go_to_pay;
    private ImageView img_check;
    private TextView tv_total_price;
    private List<ChaTaiYouHuiQuan.ResultBean.CouponsBean> myouhuiquan;

    public ChaTaiOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_cha_tai_one, container, false);
        initYouHuiQuan();
        initUI();
        initData();
        return inflate;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initUI() {
        mTvTotal = inflate.findViewById(R.id.tv_total_price);
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
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"/machine/findTeaTable/"+MyApp.instance.getInt("id"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        chatai = gson.fromJson(response.body(), ChaTaiGson.class);
                        if (chatai.getStatus() == 1) {
                            initRec(chatai.getResult());
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
        map.put("tel","13111111111");
        map.put("mId",String.valueOf(43));
        OkGo.<String>post(Contacts.URl1+"/machine/getPreferential")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ChaTaiYouHuiQuan youhuiquan = gson.fromJson(body, ChaTaiYouHuiQuan.class);
                        if (youhuiquan.getStatus() == 1){
                            myouhuiquan = youhuiquan.getResult().getCoupons();
                            if (myouhuiquan.size()>1){
                                tv_manjian1.setText(myouhuiquan.get(0).getServiceRegulations());
                                tv_manjian2.setText(myouhuiquan.get(1).getServiceRegulations());
                            }else if(myouhuiquan.size() ==1){
                                tv_manjian1.setText(myouhuiquan.get(0).getServiceRegulations());
                            }else if (myouhuiquan.size()<0){
                                tv_manjian1.setText("暂无优惠券");
                            }
                        }
                    }
                });
    }

    private void initRec(List<ChaTaiGson.ResultBean> result) {
        rec_chatai = inflate.findViewById(R.id.rec_chatai);
//        rec_chatai.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rec_chatai.setHasFixedSize(true);
        mAdapter = new ChaTaiAdapter(R.layout.item_shouye_chataione,bt_checkbox,btn_go_to_pay,result,getActivity(),img_check,tv_total_price);
        mAdapter.setData(result);
        rec_chatai.setAdapter(mAdapter);
    }

    public static Fragment newInstance(String str){
        ChaTaiOneFragment fragment = new ChaTaiOneFragment();
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
                    if (myouhuiquan!=null){
                        new XPopup.Builder(getContext())
                                .asCustom(new CTYouHuiQuan(getContext(),myouhuiquan))
                                .show();
                    }else{
                        ToastUtils.showShort("暂无优惠券");
                    }
                }
                break;
        }
    }
}
