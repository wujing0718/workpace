package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.DiaPuZhuYeActivity;
import com.huohougongfu.app.Gson.ZhaoRenGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.QuanZiDetailActivity;
import com.huohougongfu.app.QuanZi.Adapter.ZhaoRenAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.LeiMuActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WoDeGuanZhuActivity extends AppCompatActivity implements View.OnClickListener ,UMShareListener {

    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_wodeguanzhu;
    private String token,mId;
    private ZhaoRenAdapter zhaorendadapter;
    private int page = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo_de_guan_zhu);
        token = MyApp.instance.getString("token");
        mId = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",mId);
        map.put("pageNo","1");
        map.put("pageSize","10");
        OkGo.<String>post(Contacts.URl1+"/my/myAttention")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ZhaoRenGson fensi = gson.fromJson(body, ZhaoRenGson.class);
                        if (fensi.getStatus() == 1){
                            if (fensi.getResult().getList().size()>0){
                                smartrefreshlayout.setVisibility(View.VISIBLE);
                                initRec(fensi.getResult().getList());
                            }else{
                                smartrefreshlayout.setVisibility(View.GONE);
                            }
                        }
                    }
                });
        
    }

    private void initRec(List<ZhaoRenGson.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_wodeguanzhu.setLayoutManager(layoutmanager);
        zhaorendadapter = new ZhaoRenAdapter(R.layout.item_quanzi_zhaoren,list);
        rec_wodeguanzhu.setAdapter(zhaorendadapter);
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
                intent.setClass(WoDeGuanZhuActivity.this,DiaPuZhuYeActivity.class);
                startActivity(intent);
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

    private void initAdd() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",mId);
        map.put("pageNo",String.valueOf(page++));
        map.put("pageSize","10");
        OkGo.<String>post(Contacts.URl1+"/my/myAttention")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ZhaoRenGson fensi = gson.fromJson(body, ZhaoRenGson.class);
                        if (fensi.getStatus() == 1){
                            if (fensi.getResult().getList().size()>0){
                                zhaorendadapter.add(fensi.getResult().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else {
                                smartrefreshlayout. finishLoadMore();
                            }
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


    private void initUI() {
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        rec_wodeguanzhu = findViewById(R.id.rec_wodeguanzhu);
        findViewById(R.id.bt_fenxiang).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_fenxiang:
                UMWeb web = new UMWeb("http://www.baidu.com");//连接地址
                web.setTitle("火后功夫");//标题
                web.setDescription("123456");//描述
                if (TextUtils.isEmpty("")) {
                    web.setThumb(new UMImage(WoDeGuanZhuActivity.this, R.mipmap.img_back));  //本地缩略图
                } else {
                    web.setThumb(new UMImage(WoDeGuanZhuActivity.this, ""));  //网络缩略图
                }
                new ShareAction(WoDeGuanZhuActivity.this)
                        .setDisplayList(SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QQ)
                        .withMedia(web)
                        .setCallback(this).open();
                break;
            case R.id.bt_finish:
                finish();
                break;

        }
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {

    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {

    }
}
