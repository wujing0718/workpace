package com.huohougongfu.app.Shop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.DaShiJianJie;
import com.huohougongfu.app.Gson.TeYuePingPai;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.VedioDetailActivity;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
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

import java.util.HashMap;
import java.util.Map;

public class DaShiJianJieActivity extends AppCompatActivity implements View.OnClickListener {

    private String dashiid;
    private TextView tv_dashi_name,tv_dashi_level,tv_introduceContent,bt_dashi_guanzhu;
    private ImageView img_dashi_photo;
    private DaShiJianJie daShiJianJie;
    private int mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_shi_jian_jie);
        mId = MyApp.instance.getInt("id");
        dashiid = getIntent().getStringExtra("id");
        initUI();
        initData();
    }

    private void initUI() {
         tv_dashi_name = findViewById(R.id.tv_dashi_name);
        tv_dashi_level = findViewById(R.id.tv_dashi_level);
        tv_introduceContent = findViewById(R.id.tv_introduceContent);
        img_dashi_photo = findViewById(R.id.img_dashi_photo);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_dashi_zhuye).setOnClickListener(this);
        bt_dashi_guanzhu = findViewById(R.id.bt_dashi_guanzhu);
        bt_dashi_guanzhu.setOnClickListener(this);
        findViewById(R.id.bt_share).setOnClickListener(this);
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(mId));
        map.put("masterId",dashiid);
        OkGo.<String>get(Contacts.URl1+"query/allCatory/masterOwnPage")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        daShiJianJie = new Gson().fromJson(body, DaShiJianJie.class);
                        if (daShiJianJie.getStatus() == 1){
                            initView(daShiJianJie);
                            if (daShiJianJie.getResult().getIsCollection()==1){
                                bt_dashi_guanzhu.setBackgroundResource(R.drawable.yiguanzhu);
                                bt_dashi_guanzhu.setText("已关注");
                            }else{
                                bt_dashi_guanzhu.setBackgroundResource(R.drawable.guanzhu);
                                bt_dashi_guanzhu.setText("+关注");
                            }
                        }
                    }
                });
    }

    private void initView(DaShiJianJie daShiJianJie) {
        tv_dashi_name.setText(daShiJianJie.getResult().getName());
        tv_dashi_level.setText(daShiJianJie.getResult().getLevel());
        tv_introduceContent.setText(daShiJianJie.getResult().getIntroduceContent());
        Glide.with(MyApp.context).load(daShiJianJie.getResult().getPhoto()).into(img_dashi_photo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_dashi_guanzhu:
                if (daShiJianJie.getResult().getIsCollection()== 1){
                    initNoGuanZhu();
                }else{
                    initGuanZhu();
                }
            break;
            case R.id.bt_dashi_zhuye:
                ToastUtils.showShort("主页");
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_share:
                UMWeb web = new UMWeb("http://www.baidu.com");//连接地址
                web.setTitle("火后功夫");//标题
                web.setDescription("123456");//描述
                if (TextUtils.isEmpty("")) {
                    web.setThumb(new UMImage(DaShiJianJieActivity.this, R.mipmap.img_back));  //本地缩略图
                } else {
                    web.setThumb(new UMImage(DaShiJianJieActivity.this, ""));  //网络缩略图
                }
                new ShareAction(DaShiJianJieActivity.this)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,
                                SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                        .withMedia(web)
                        .setCallback(new UMShareListener() {
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
                        }).open();

                break;
        }
    }

    private void initGuanZhu() {
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(mId));
        map.put("masterId",String.valueOf(dashiid));
        OkGo.<String>get(Contacts.URl1+"query/allCatory/masterCollection")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                bt_dashi_guanzhu.setBackgroundResource(R.drawable.yiguanzhu);
                                bt_dashi_guanzhu.setText("已关注");
                                daShiJianJie.getResult().setIsCollection(1);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initNoGuanZhu() {
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(mId));
        map.put("masterId",String.valueOf(dashiid));
        OkGo.<String>get(Contacts.URl1+"query/allCatory/masterCollection")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                bt_dashi_guanzhu.setBackgroundResource(R.drawable.guanzhu);
                                bt_dashi_guanzhu.setText("+关注");
                                daShiJianJie.getResult().setIsCollection(0);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
