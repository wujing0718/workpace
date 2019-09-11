package com.huohougongfu.app.WoDe.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.MyPagerAdapter;
import com.huohougongfu.app.Gson.QuanZiShare;
import com.huohougongfu.app.Gson.YaoQingGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.QuanZiDetailActivity;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Adapter.YaoQingAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YaoQingActivity extends AppCompatActivity implements View.OnClickListener,UMShareListener {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<String> mtabtitle = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private ImageView img_zhuanke_bg;
    private TextView tv_biaoyu,tv_guize;
    private RecyclerView rec_yaoqing;
    private QuanZiShare share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yao_qing);
        initUI();
        initData();
        initShare();
    }

    private void initShare() {
        OkGo.<String>post(Contacts.URl1+"earn/getInviteUrl")
                .params("userId",String.valueOf(MyApp.instance.getInt("id")))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        QuanZiShare quanZiShare = new Gson().fromJson(body, QuanZiShare.class);
                        if (quanZiShare.getStatus() == 1){
                            share = quanZiShare;
                        }
                    }
                });
    }

    private void initUI() {
        findViewById(R.id.bt_lijiyaoqing).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        img_zhuanke_bg = findViewById(R.id.img_zhuanke_bg);
        tv_biaoyu = findViewById(R.id.tv_biaoyu);
        tv_guize = findViewById(R.id.tv_guize);
        rec_yaoqing = findViewById(R.id.rec_yaoqing);
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("page",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>get(Contacts.URl1+"earn/invitePage")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        YaoQingGson yaoQingGson = gson.fromJson(body, YaoQingGson.class);
                        if (yaoQingGson.getStatus() == 1){
                            initView(yaoQingGson.getResult());
                        }
                    }
                });
    }

    private void initView(YaoQingGson.ResultBean result) {
//        Glide.with(MyApp.context).load(result.getRule().getPicture())
//                .apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_zhuanke_bg);
//        tv_biaoyu.setText(result.getRule().getSlogan());
//        tv_guize.setText(result.getRule().getRegulation());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rec_yaoqing.setLayoutManager(layoutManager);
        YaoQingAdapter yaoQingAdapter = new YaoQingAdapter(R.layout.item_yaoqing,result.getEarnPordut().getList());
        rec_yaoqing.setAdapter(yaoQingAdapter);
        yaoQingAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                initReceive(result.getEarnPordut().getList().get(position));
            }
        });
    }

    private void initReceive(YaoQingGson.ResultBean.EarnPordutBean.ListBean listBean) {
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("inviteeId",String.valueOf(listBean.getUserId()));
        OkGo.<String>post(Contacts.URl1+"earn/getReel")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                initData();
                                ToastUtils.showShort("领取成功");
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_finish:
                if (!utils.isDoubleClick()){
                    finish();
                }
                break;
            case R.id.bt_lijiyaoqing:
                if (!utils.isDoubleClick()){
                    UMWeb web = new UMWeb(share.getResult().getUrl());//连接地址
                    web.setTitle(share.getResult().getTitle());//标题
                    web.setDescription(share.getResult().getContent());//描述
                    if (share.getResult().getPhoto()!=null) {
                        web.setThumb(new UMImage(YaoQingActivity.this, share.getResult().getPhoto()));  //网络缩略图
                    } else {
                        web.setThumb(new UMImage(YaoQingActivity.this, R.mipmap.img_zhanweitu));  //本地缩略图
                    }
                    new ShareAction(YaoQingActivity.this)
                            .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,
                                    SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                            .withMedia(web)
                            .setCallback(this).open();
                }
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
