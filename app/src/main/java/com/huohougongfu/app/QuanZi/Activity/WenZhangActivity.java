package com.huohougongfu.app.QuanZi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.MallGson;
import com.huohougongfu.app.Gson.QuanZiDetail;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.Gson.QuanZiShare;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.WenZhangAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.MallAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
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
import java.util.Map;

public class WenZhangActivity extends AppCompatActivity {

    private RecyclerView rec_quanzi_wenzhang;
    private String phone;
    private SmartRefreshLayout smartrefreshlayout;
    private int page = 2;
    private WenZhangAdapter wenzhangadapter;
    private int mId;
    private EditText edt_shop_sousuo;
    private InputMethodManager manager;
    private String token;
    private QuanZiShare share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wen_zhang);
        phone = MyApp.instance.getString("phone");
        mId = MyApp.instance.getInt("id");
        manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        token = MyApp.instance.getString("token");
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edt_shop_sousuo = findViewById(R.id.edt_shop_sousuo);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        rec_quanzi_wenzhang = findViewById(R.id.rec_quanzi_wenzhang);
        initData("");
        edt_shop_sousuo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(edt_shop_sousuo.getApplicationWindowToken(), 0);
                    }
                    initData(edt_shop_sousuo.getText().toString());
                }
                //记得返回false
                return false;
            }
        });
        edt_shop_sousuo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()){
                    initData("");
                    manager.hideSoftInputFromWindow(edt_shop_sousuo.getApplicationWindowToken(), 0);
                }
            }
        });
    }
    private void initData(String sousuo) {
        Map<String, String> map = new HashMap<>();
        map.put("type","2");
        map.put("pageNo","1");
        map.put("mId",String.valueOf(mId));
        map.put("pageSize","10");
        map.put("condition",sousuo);
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/data")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        smartrefreshlayout.finishRefresh();
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        QuanZiFaXian faxian = gson.fromJson(response.body(), QuanZiFaXian.class);
                        if (faxian.getStatus() == 1) {
                            if (faxian.getResult().getDatas().getList().size()>0){
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec(faxian);
                            }else{
                                smartrefreshlayout.setVisibility(View.GONE);
                            }
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(WenZhangActivity.this, "载入中...");
                        super.onStart(request);
                    }
                });
    }



    private void initRec(QuanZiFaXian wenzhang) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_quanzi_wenzhang.setLayoutManager(layoutmanager);
        wenzhangadapter = new WenZhangAdapter(R.layout.item_quanzi_wenzhang,wenzhang.getResult().getDatas().getList());
        rec_quanzi_wenzhang.setAdapter(wenzhangadapter);
        wenzhangadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("dId",wenzhang.getResult().getDatas().getList().get(position).getId());
                intent.putExtra("userid",wenzhang.getResult().getDatas().getList().get(position).getMember().getUserId());
                startActivity(intent.setClass(WenZhangActivity.this,WenZhangDetailActivity.class));
            }
        });
        wenzhangadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ImageView img_faixan_shoucang = view.findViewById(R.id.img_xihuan);
                TextView tv_dianzan_num = view.findViewById(R.id.tv_xihuan_num);
                if (!"".equals(token)){
                    if (wenzhang.getResult().getDatas().getList().get(position).getIsPraise() == 0){
                        initDianZan("1",wenzhang.getResult().getDatas().getList().get(position),img_faixan_shoucang,tv_dianzan_num);
                    }else{
                        if (!utils.isDoubleClick()){
                            initQuXiaoDianZan("0",wenzhang.getResult().getDatas().getList().get(position),img_faixan_shoucang,tv_dianzan_num);
                        }
                    }
                }else{
                    ToastUtils.showShort(R.string.denglu);
                }
            }
        });
        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData("");
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

    //取消点赞
    private void initQuXiaoDianZan(String type, QuanZiFaXian.ResultBean.DatasBean.ListBean listBean, ImageView img_faixan_shoucang, TextView tv_dianzan_num) {
        Map<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("dataId",String.valueOf(listBean.getId()));
        map.put("mId",String.valueOf(mId));
        map.put("token",token);
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
    private void initDianZan(String type, QuanZiFaXian.ResultBean.DatasBean.ListBean listBean, ImageView img_faixan_shoucang, TextView tv_dianzan_num) {
        String num = tv_dianzan_num.getText().toString();
        Map<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("dataId",String.valueOf(listBean.getId()));
        map.put("mId",String.valueOf(mId));
        map.put("token",token);
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
        Map<String, String> map = new HashMap<>();
        map.put("type","2");
        map.put("pageNo",String.valueOf(page++));
        map.put("mId",String.valueOf(mId));
        map.put("pageSize","10");
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/data")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        QuanZiFaXian faxian = gson.fromJson(body, QuanZiFaXian.class);
                        if (faxian.getResult().getDatas().getList().size()>0){
                            wenzhangadapter.add(faxian.getResult().getDatas().getList());
                            smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                        }else {
                            smartrefreshlayout. finishLoadMore();
                        }
                    }
                });
    }
}
