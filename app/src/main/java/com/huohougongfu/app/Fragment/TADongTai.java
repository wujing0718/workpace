package com.huohougongfu.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.TaDongTai;
import com.huohougongfu.app.Gson.MyDongTai;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.QuanZiDetailActivity;
import com.huohougongfu.app.QuanZi.Activity.VedioDetailActivity;
import com.huohougongfu.app.QuanZi.Activity.WenZhangDetailActivity;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.MyDongTaiActivity;
import com.huohougongfu.app.WoDe.Adapter.MyDongTaiAdapter;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TADongTai extends Fragment {
    private static final String KEY ="Mid";
    private View inflate;
    private String mId;
    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_ta_dongtai;
    private TaDongTai myDongTaiAdapter;
    private int page = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_tadong_tai, container, false);
        smartrefreshlayout = inflate.findViewById(R.id.smartrefreshlayout);
        rec_ta_dongtai = inflate.findViewById(R.id.rec_ta_dongtai);
        mId = getArguments().getString(KEY);
        initData();
        return inflate;
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/my/dynamic")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        smartrefreshlayout.finishRefresh(true);//传入false表示刷新失败
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        MyDongTai dongtai = gson.fromJson(body, MyDongTai.class);
                        if (dongtai.getStatus() == 1){
                            initRec(dongtai.getResult().getList());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        WaitDialog.dismiss();
                        super.onError(response);
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(),"载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(List<MyDongTai.ResultBean.ListBean> list) {
        if (list.size()>0){
            smartrefreshlayout.setVisibility(View.VISIBLE);
            //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
            LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
            rec_ta_dongtai.setLayoutManager(layoutmanager);
            myDongTaiAdapter = new TaDongTai(R.layout.item_wode_dongtai,list,getActivity());
            rec_ta_dongtai.setAdapter(myDongTaiAdapter);
            myDongTaiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (list.get(position).getType() == 2){
                        Intent intent = new Intent();
                        intent.putExtra("dId",list.get(position).getId());
                        startActivity(intent.setClass(getActivity(),WenZhangDetailActivity.class));
                    }else if(list.get(position).getType() == 1){
                        Intent intent = new Intent();
                        intent.putExtra("dId",list.get(position).getId());
                        startActivity(intent.setClass(getActivity(),QuanZiDetailActivity.class));
                    }else if (list.get(position).getType() == 3){
                        Intent intent = new Intent();
                        intent.putExtra("动态视频",list.get(position));
                        intent.putExtra("position",position);
                        intent.putExtra("dId",list.get(position).getId());
                        startActivity(intent.setClass(getActivity(),VedioDetailActivity.class));
                    }
                }
            });

            myDongTaiAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    ImageView img_faixan_shoucang = view.findViewById(R.id.img_xihuan);
                    TextView tv_dianzan_num = view.findViewById(R.id.tv_dongtai_xihuannum);
                        if (list.get(position).getIsPraise() == 0){
                            initDianZan("1",list.get(position),img_faixan_shoucang,tv_dianzan_num);
                        }else{
                            if (!utils.isDoubleClick()){
                                initQuXiaoDianZan("0",list.get(position),img_faixan_shoucang,tv_dianzan_num);
                            }
                        }
                }
            });
            //刷新
            smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshlayout) {
                    page = 2;
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
        }else{
            smartrefreshlayout.setVisibility(View.GONE);
        }
    }

    //取消点赞
    private void initQuXiaoDianZan(String type, MyDongTai.ResultBean.ListBean listBean, ImageView img_faixan_shoucang, TextView tv_dianzan_num) {
        Map<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("dataId",String.valueOf(listBean.getId()));
        map.put("mId",String.valueOf(mId));
        OkGo.<String>post(Contacts.URl1+"/circle/praise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                String num = tv_dianzan_num.getText().toString();
                                Integer integer = Integer.valueOf(num);
                                tv_dianzan_num.setText(String.valueOf(integer-1));
                                listBean.setIsPraise(0);
                                img_faixan_shoucang.setImageResource(R.mipmap.img_xihuan);
                                ToastUtils.showShort("取消点赞");
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //点赞
    private void initDianZan(String type, MyDongTai.ResultBean.ListBean listBean, ImageView img_faixan_shoucang, TextView tv_dianzan_num) {
        String num = tv_dianzan_num.getText().toString();
        Map<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("dataId",String.valueOf(listBean.getId()));
        map.put("mId",String.valueOf(mId));
        OkGo.<String>post(Contacts.URl1+"/circle/praise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort("点赞成功");
                                Integer integer = Integer.valueOf(num);
                                tv_dianzan_num.setText(String.valueOf(integer+1));
                                listBean.setIsPraise(1);
                                img_faixan_shoucang.setImageResource(R.mipmap.img_xihuan2);
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initAdd() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("pageNo",String.valueOf(page++));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/my/dynamic")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        MyDongTai dongtai = gson.fromJson(body, MyDongTai.class);
                        if (dongtai.getStatus() == 1){
                            if (dongtai.getResult().getList().size()>0){
                                myDongTaiAdapter.add(dongtai.getResult().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else {
                                smartrefreshlayout. finishLoadMore();
                            }
                        }
                    }
                });
    }

    public static Fragment newInstance(String str){
        TADongTai fragment = new TADongTai();
        Bundle bundle = new Bundle();
        bundle.putString(KEY,str);
        fragment.setArguments(bundle);
        return fragment;
    }
}
