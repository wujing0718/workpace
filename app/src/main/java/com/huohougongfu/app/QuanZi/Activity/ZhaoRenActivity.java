package com.huohougongfu.app.QuanZi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.DiaPuZhuYeActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.Gson.GuanZhu;
import com.huohougongfu.app.Gson.ZhaoRenGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.ZhaoRenAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.TeYuePinPaiActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZhaoRenActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rec_zhaoren;
    private ZhaoRenAdapter zhaorendadapter;
    private int mId;
    private String token;
    private InputMethodManager manager;
    private SmartRefreshLayout smartrefreshlayout;
    private int page =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhao_ren);
        manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        initUI();
        initData("");
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_xiaoxi).setOnClickListener(this);
        rec_zhaoren = findViewById(R.id.rec_zhaoren);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        EditText edt_zhaoren_sousuo = findViewById(R.id.edt_zhaoren_sousuo);
        edt_zhaoren_sousuo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(edt_zhaoren_sousuo.getApplicationWindowToken(), 0);
                    }
                    //自己需要的操作
                    initData(edt_zhaoren_sousuo.getText().toString());
                }
                //记得返回false
                return false;
            }
        });
    }

    private void initData(String condition) {
        Map<String,String> map = new HashMap<>();
        if (!condition.isEmpty()){
            map.put("condition",condition);
        }
        map.put("pageNo","1");
        map.put("pageSize","10");
        map.put("mId",String.valueOf(mId));
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/find/people")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ZhaoRenGson zhaoRenGson = gson.fromJson(body, ZhaoRenGson.class);
                        if (zhaoRenGson.getStatus() ==1){
                            if (!zhaoRenGson.getResult().getList().isEmpty()){
                                initRec(zhaoRenGson.getResult().getList());
                            }else{
                                ToastUtils.showShort("暂无此人");
                            }
                        }else{
                            ToastUtils.showShort(zhaoRenGson.getMsg());
                        }
                    }
                });
    }

    private void initRec(List<ZhaoRenGson.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_zhaoren.setLayoutManager(layoutmanager);
        zhaorendadapter = new ZhaoRenAdapter(R.layout.item_quanzi_zhaoren,list);
        rec_zhaoren.setAdapter(zhaorendadapter);
        zhaorendadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_zhaoren_gaunzhu = view.findViewById(R.id.bt_zhaoren_gaunzhu);
                if (!utils.isDoubleClick()){
                    if (!"".equals(token)){
                        if (list.get(position).getIsAttention() == 1){
                            initNoGuanZhu(0,list.get(position),bt_zhaoren_gaunzhu);
                        }else if (list.get(position).getIsAttention() == 0){
                            initGuanZhu(1,list.get(position),bt_zhaoren_gaunzhu);
                        }
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                    }
                }
            }
        });

        zhaorendadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("id",String.valueOf(list.get(position).getUserId()));
                intent.setClass(ZhaoRenActivity.this,DiaPuZhuYeActivity.class);
                startActivity(intent);
            }
        });
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
//                initOkGO();
                smartrefreshlayout.finishRefresh(true);//传入false表示刷新失败
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

    private void initAdd() {
        Map<String,String> map = new HashMap<>();
        map.put("pageNo",String.valueOf(page++));
        map.put("pageSize","10");
        map.put("mId",String.valueOf(mId));
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/find/people")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ZhaoRenGson zhaoRenGson = gson.fromJson(body, ZhaoRenGson.class);
                        if (zhaoRenGson.getResult().getList().size()>0){
                            zhaorendadapter.add(zhaoRenGson.getResult().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadmoreWithNoMoreData();
                        }
                    }
                });
    }

    private void initGuanZhu(int type, ZhaoRenGson.ResultBean.ListBean listBean, TextView bt_zhaoren_gaunzhu) {
        int userId = listBean.getUserId();
        Map<String,String> map =new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("attentionId",String.valueOf(userId));
        map.put("type",String.valueOf(type));
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/attention")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                listBean.setIsAttention(1);
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                bt_zhaoren_gaunzhu.setBackgroundResource(R.drawable.yiguanzhu);
                                bt_zhaoren_gaunzhu.setText("已关注");
                                bt_zhaoren_gaunzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorWhite));
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initNoGuanZhu(int type, ZhaoRenGson.ResultBean.ListBean listBean, TextView bt_zhaoren_gaunzhu) {
        int userId = listBean.getUserId();
        Map<String,String> map =new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("attentionId",String.valueOf(userId));
        map.put("type",String.valueOf(type));
        map.put("token",token);

        OkGo.<String>post(Contacts.URl1+"/circle/attention")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                listBean.setIsAttention(0);
                                bt_zhaoren_gaunzhu.setText("+关注");
                                bt_zhaoren_gaunzhu.setBackgroundResource(R.drawable.guanzhu);
                                bt_zhaoren_gaunzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.black));
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

//    private void initGuanZhu(int type) {
//        int userId = detail.getResult().getMember().getUserId();
//        Map<String,String> map =new HashMap<>();
//        map.put("mId",String.valueOf(mId));
//        map.put("attentionId",String.valueOf(userId));
//        map.put("type",String.valueOf(type));
//        OkGo.<String>post(Contacts.URl1+"/circle/attention")
//                .params(map)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response.body());
//                            if (jsonObject.getInt("status") == 1){
//                                guanzhuId.add(0);
//                                ToastUtils.showShort(jsonObject.getString("msg"));
//                                tv_guanzhu.setBackgroundResource(R.drawable.yiguanzhu);
//                                tv_guanzhu.setText("已关注");
//                                tv_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorWhite));
//                            }else{
//                                ToastUtils.showShort(jsonObject.getString("msg"));
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//    }
//
//    private void initNoGuanZhu(int type) {
//        int userId = detail.getResult().getMember().getUserId();
//        Map<String,String> map =new HashMap<>();
//        map.put("mId",String.valueOf(mId));
//        map.put("attentionId",String.valueOf(userId));
//        map.put("type",String.valueOf(type));
//        OkGo.<String>post(Contacts.URl1+"/circle/attention")
//                .params(map)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response.body());
//                            if (jsonObject.getInt("status") == 1){
//                                ToastUtils.showShort(jsonObject.getString("msg"));
//                                tv_guanzhu.setText("+关注");
//                                guanzhuId.clear();
//                                tv_guanzhu.setBackgroundResource(R.drawable.guanzhu);
//                                tv_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.black));
//                            }else{
//                                ToastUtils.showShort(jsonObject.getString("msg"));
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_xiaoxi:
                Intent intent = new Intent();
                intent.setClass(ZhaoRenActivity.this,XiaoXiActivity.class);
                startActivity(intent);
                break;
        }
    }
}
