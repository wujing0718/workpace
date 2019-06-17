package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ChaTaiAdapter;
import com.huohougongfu.app.Adapter.ShangPinAdapter;
import com.huohougongfu.app.Fragment.SimpleCardFragment;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.AmountView;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.SmoothCheckBox;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.ocnyang.cartlayout.bean.ICartItem;
import com.ocnyang.cartlayout.listener.CartOnCheckChangeListener;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChaTaiOneFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private SmoothCheckBox mCheckBoxAll;
    private RecyclerView rec_chatai;
    private ChaTaiAdapter shangPinAdapter;
    private ShangPinGson shangPinGson;
    private TextView mTvTotal;
    private Button mBtnSubmit;
    private ChaTaiAdapter mAdapter;

    public ChaTaiOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_cha_tai_one, container, false);
        initUI();
        initData();
        return inflate;
    }

    private void initUI() {
        mTvTotal = inflate.findViewById(R.id.tv_total_price);
        mBtnSubmit =inflate.findViewById(R.id.btn_go_to_pay);
        inflate.findViewById(R.id.bt_checkbox).setOnClickListener(this);
        mCheckBoxAll = inflate.findViewById(R.id.checkbox);
        mBtnSubmit.setOnClickListener(this);
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
                        shangPinGson = gson.fromJson(response.body(), ShangPinGson.class);
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
        rec_chatai = inflate.findViewById(R.id.rec_chatai);
        rec_chatai.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ChaTaiAdapter(R.layout.item_shouye_chataione, data.getList());
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SmoothCheckBox checkbox = view.findViewById(R.id.checkbox);
                if (checkbox.isChecked()){
                    checkbox.setChecked(false);
                }else{
                    checkbox.setChecked(true);
                }
            }
        });
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
            case R.id.bt_checkbox:
                if (!utils.isDoubleClick()){
                    if (mCheckBoxAll.isChecked()){
                        //选中
                        mAdapter.selectAll();
                        mCheckBoxAll.setChecked(false,true);
                    }else{
                        //未选中
                        mAdapter.revertSelected();
                        mCheckBoxAll.setChecked(true,true);
                    }
                }
                break;
        }
    }
}
