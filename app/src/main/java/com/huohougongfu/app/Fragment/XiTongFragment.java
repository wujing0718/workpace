package com.huohougongfu.app.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.XiTongAdapter;
import com.huohougongfu.app.Gson.OKGson;
import com.huohougongfu.app.Gson.XiTongGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class XiTongFragment extends Fragment {


    private View inflate;
    private RecyclerView rec_xitong;
    private SmartRefreshLayout smartrefreshlayout;
    private int page = 2;
    private XiTongAdapter xiTongAdapter;

    public XiTongFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_xi_tong, container, false);
        initData();
        return inflate;
    }

    private void initData() {
        Map<String,String > map =new HashMap<>();
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/my/pushRecord")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        XiTongGson xiTongGson = new Gson().fromJson(body, XiTongGson.class);
                        if (xiTongGson.getStatus() == 1){
                            initRec(xiTongGson.getResult().getList());
                        }
                    }
                });
    }

    private void initRec(List<XiTongGson.ResultBean.ListBean> list) {
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_xitong = inflate.findViewById(R.id.rec_xitong);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rec_xitong.setLayoutManager(layoutManager);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setItemType(list.get(i).getType());
        }
        xiTongAdapter = new XiTongAdapter(list);
        rec_xitong.setAdapter(xiTongAdapter);
        xiTongAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_guanzhu = view.findViewById(R.id.bt_guanzhu);
                if (list.get(position).getMember().getMaster().getIsCollection()== 1){
                    initNoGuanZhu(list.get(position).getMember(),bt_guanzhu);
                }else{
                    initGuanZhu(list.get(position).getMember(),bt_guanzhu);
                }
            }
        });

        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData();
            }
        });
        //加载更多
        smartrefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                initAdd();
            }
        });
    }
    private void initGuanZhu(XiTongGson.ResultBean.ListBean.MemberBean master, TextView bt_guanzhu) {
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("masterId",String.valueOf(master.getUserId()));
        OkGo.<String>get(Contacts.URl1+"query/allCatory/masterCollection")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        OKGson okGson = new Gson().fromJson(response.body(), OKGson.class);
                        if (okGson.getStatus() == 1){
                            master.setIsAttention(1);
                            bt_guanzhu.setBackgroundResource(R.drawable.yiguanzhu);
                            bt_guanzhu.setText("已关注");
                            bt_guanzhu.setTextColor(getActivity().getResources().getColor(R.color.colorWhite));
                        }
                    }
                });
    }

    private void initNoGuanZhu(XiTongGson.ResultBean.ListBean.MemberBean master, TextView bt_guanzhu) {
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("masterId",String.valueOf(master.getUserId()));
        OkGo.<String>get(Contacts.URl1+"query/allCatory/masterCollection")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        OKGson okGson = new Gson().fromJson(response.body(), OKGson.class);
                        if (okGson.getStatus() == 1){
                            master.setIsAttention(0);
                            bt_guanzhu.setText("+关注");
                            bt_guanzhu.setBackgroundResource(R.drawable.guanzhu);
                            bt_guanzhu.setTextColor(getActivity().getResources().getColor(R.color.white));
                        }
                    }
                });
    }

    private void initAdd() {
        Map<String,String > map =new HashMap<>();
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("pageNo",String.valueOf(page++));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/my/pushRecord")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        XiTongGson xiTongGson = new Gson().fromJson(body, XiTongGson.class);
                        if (xiTongGson.getStatus() == 1) {
                            if (xiTongGson.getResult().getList().size()>0){
                                xiTongAdapter.add(xiTongGson.getResult().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else {
                                smartrefreshlayout. finishLoadMore();
                            }
                        }
                    }
                });
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        XiTongFragment fragment = new XiTongFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
