package com.huohougongfu.app.WoDe.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ChaTaiDingDanAdapter;
import com.huohougongfu.app.Fragment.SiLiaoFragment;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Activity.DingDanDetailActivity;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class DingDanFragment extends Fragment {


    private View inflate;
    private ShangPinGson shangPinGson;
    private RecyclerView rec_chatai_dingdan;
    private ChaTaiDingDanAdapter mAdapter;
    private Intent intent;

    public DingDanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_my_ding_dan, container, false);
        intent = new Intent();
//        initData();
        return inflate;
    }
//    private void initData() {
//        Map<String, String> map = new HashMap<>();
//        map.put("service","App.Mixed_Jinse.Zx");
//        map.put("channel", "www");
//        OkGo.<String>post(Contacts.URl)
//                .params(map)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        WaitDialog.dismiss();
//                        Gson gson = new Gson();
//                        shangPinGson = gson.fromJson(response.body(), ShangPinGson.class);
//                        if (shangPinGson.getCode() == 200) {
//                            initRec(shangPinGson.getData());
//                        }
//                    }
//                    @Override
//                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getActivity(), "载入中...");
//                        super.onStart(request);
//                    }
//                });
//    }

//    private void initRec(ShangPinGson.DataBean data) {
//        rec_chatai_dingdan = inflate.findViewById(R.id.rec_mydingdan);
//        rec_chatai_dingdan.setLayoutManager(new LinearLayoutManager(getActivity()));
////        mAdapter = new ChaTaiDingDanAdapter(R.layout.item_dingdan, data.getList());
//        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                intent.setClass(getActivity(),DingDanDetailActivity.class);
//                startActivity(intent);
//            }
//        });
//        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                ToastUtils.showShort("确认支付"+position);
//            }
//        });
//        rec_chatai_dingdan.setAdapter(mAdapter);
//    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        DingDanFragment fragment = new DingDanFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
