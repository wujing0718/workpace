package com.huohougongfu.app.QuanZi.Activity;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.PingLunGson;
import com.huohougongfu.app.Gson.QuanZiDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.PingLunAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuanZiDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private int dId;
    private Banner banner;
    private ImageView img_quanzi_touxiang;
    private TextView tv_quanzi_name,tv_quanzi_chenghu,tv_quanzi_weizhi,tv_quanzi_time,tv_quanzi_content;
    private List<String> mbanner = new ArrayList<>();
    private View view_detail_pinglun;
    private RecyclerView rec_wenzhang_pinglun;
    private EditText edt_quanzi_pinglun;
    private int mid;
    private View view_pinglun_fasong;
    private View view_detail_weizhi;
    private TextView pinglunnum,xihuannum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_zi_detail);
        dId = getIntent().getIntExtra("dId", 0);
         mid = MyApp.instance.getInt("id");
        initUI();
        initData();
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_gengduo).setOnClickListener(this);
        pinglunnum = findViewById(R.id.tv_detail_pinglunnum);
        xihuannum = findViewById(R.id.tv_detail_xihuannum);
        edt_quanzi_pinglun = findViewById(R.id.edt_quanzi_pinglun);
        view_detail_weizhi = findViewById(R.id.view_detail_weizhi);
        findViewById(R.id.bt_fasong_pinglun).setOnClickListener(this);
        rec_wenzhang_pinglun = findViewById(R.id.rec_wenzhang_pinglun);
        view_detail_pinglun = findViewById(R.id.view_detail_pinglun);
        view_pinglun_fasong = findViewById(R.id.view_pinglun_fasong);
        banner = findViewById(R.id.banner);
        img_quanzi_touxiang = findViewById(R.id.img_quanzi_touxiang);
        tv_quanzi_name = findViewById(R.id.tv_quanzi_name);
        tv_quanzi_chenghu = findViewById(R.id.tv_quanzi_chenghu);
        tv_quanzi_content = findViewById(R.id.tv_quanzi_content);
        tv_quanzi_weizhi = findViewById(R.id.tv_quanzi_weizhi);
        tv_quanzi_time = findViewById(R.id.tv_quanzi_time);
        findViewById(R.id.bt_zhankaipinglun).setOnClickListener(this);
        initPingLun();
    }

    private void initPingLun() {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(dId));
        map.put("pageNo","1");
        map.put("pageSize","10");
        OkGo.<String>post(Contacts.URl1+"/circle/comments/list")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        PingLunGson pinglun = gson.fromJson(body, PingLunGson.class);
                        if (pinglun.getStatus() == 1){
                            initRec(pinglun.getResult().getList());
                        }
                    }
                });

    }

    private void initRec(List<PingLunGson.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        android.support.v7.widget.LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_wenzhang_pinglun.setLayoutManager(layoutmanager);
        PingLunAdapter pingLunAdapter = new PingLunAdapter(R.layout.item_quanzi_pinglun, list);
        rec_wenzhang_pinglun.setAdapter(pingLunAdapter);
    }

    private void initData() {
        Map<String ,String> map = new HashMap<>();
        map.put("dId",String.valueOf(dId));
        map.put("mId",String.valueOf(mid));
        OkGo.<String>post(Contacts.URl1+"/circle/data/info")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        QuanZiDetail detail = gson.fromJson(body, QuanZiDetail.class);
                        if (detail.getStatus() == 1){
                            initView(detail.getResult());
                        }
                    }
                });
    }

    private void initView(QuanZiDetail.ResultBean result) {
        xihuannum.setText(String.valueOf(result.getPraiseNum()));
        pinglunnum.setText(String.valueOf(result.getCommentNum()));
        if (result.getAddress() !=null){
            view_detail_weizhi.setVisibility(View.VISIBLE);
            tv_quanzi_weizhi.setText(result.getAddress());
        }else{
            view_detail_weizhi.setVisibility(View.GONE);
        }
        if (result!=null){
            String picture = result.getPicture();
            String[] split = picture.split(",");
            if (split.length>0) {
                for (int i = 0; i < split.length; i++) {
                    mbanner.add(split[i]);
                }
            }
        }
        //加载网络图片
        banner.setImages(mbanner)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .start();
        tv_quanzi_content.setText(result.getContent());
        tv_quanzi_time.setText(result.getCreateTime());
        tv_quanzi_name.setText(result.getMember().getNickName());
        Glide.with(QuanZiDetailActivity.this).load(result.getMember().getPhoto()).into(img_quanzi_touxiang);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_gengduo:
                break;
            case R.id.bt_fasong_pinglun:
                String pinglun_content = edt_quanzi_pinglun.getText().toString();
                if (!utils.isDoubleClick()){
                    if (!pinglun_content.isEmpty()){
                        initFaSongPingLun(pinglun_content);
                    }else{
                        ToastUtils.showShort("请输入评论内容");
                    }
                }
                break;
            case R.id.bt_zhankaipinglun:
                view_detail_pinglun.setVisibility(View.VISIBLE);
                view_pinglun_fasong.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void initFaSongPingLun(String pinglun_content) {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(dId));
        map.put("mId",String.valueOf(mid));
        map.put("content",pinglun_content);
        OkGo.<String>post(Contacts.URl1+"/circle/comment")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                initPingLun();
                                ToastUtils.showShort("评论成功");
                                edt_quanzi_pinglun.setText("");
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
