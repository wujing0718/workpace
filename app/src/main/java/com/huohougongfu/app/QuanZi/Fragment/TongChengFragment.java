package com.huohougongfu.app.QuanZi.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.QuanZiDetailActivity;
import com.huohougongfu.app.QuanZi.Adapter.FaXianAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class TongChengFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_faxian;
    private String channel;
    private SmartRefreshLayout smartrefreshlayout;
    private int mId;

    public TongChengFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_tong_cheng, container, false);
        channel = getArguments().getString("ARGS");
        mId = MyApp.instance.getInt("id");
        initUI();
        initData();
        return inflate;
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        //搜索
        map.put("cityCode","340");
        map.put("pageNo","1");
        map.put("mId",String.valueOf(mId));
        map.put("pageSize","4");
        OkGo.<String>post(Contacts.URl1+"/circle/data")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        QuanZiFaXian faxian = gson.fromJson(response.body(), QuanZiFaXian.class);
                        if (faxian.getStatus() == 1) {
                            initRec(faxian);
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(QuanZiFaXian faxian) {
        // 创建StaggeredGridLayoutManager实例
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //防止item 交换位置
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        // 绑定布局管理器
        rec_faxian.setLayoutManager(layoutManager);
        FaXianAdapter faXianAdapter = new FaXianAdapter(R.layout.item_quanzi_faxian,faxian.getResult().getDatas().getList());
        rec_faxian.setAdapter(faXianAdapter);
        faXianAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent().setClass(getActivity(),QuanZiDetailActivity.class));
            }
        });
    }

    private void initUI() {
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_faxian = inflate.findViewById(R.id.rec_faxian);
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        TongChengFragment fragment = new TongChengFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
