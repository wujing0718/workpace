package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.QuanZiShare;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PopupCoupon extends BottomPopupView implements View.OnClickListener{
    private final FragmentActivity activity;
    private final Context context;
    private final int id;

    private String[] mqiaoqiaohua = new String[]{"小可爱，给你点了杯茶，记得去喝哦",
            "茶里有故事，故事里有你我","感谢你给我的每一个拥抱","茶里是我对你真挚的祝福","你有多努力就有多特殊","茶凉就不好喝了，快去喝吧"};
    private int i;
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Log.e("onStart","1");
        }

        @Override
        public void onResult(SHARE_MEDIA share_media) {
            Log.e("onResult","1");
        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
            Log.e("onError",throwable.getMessage());
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {
            Log.e("onCancel","1");
        }
    };
    private EditText edt_qiaoqiaohua;
    private QuanZiShare quanZiShare;

    public PopupCoupon(Context context, FragmentActivity activity, int id) {
        super(context);
        this.activity = activity;
        this.context = context;
        this.id = id;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        findViewById(R.id.bt_fenxiang).setOnClickListener(this);
        findViewById(R.id.bt_qiaoqiaohua_huanyihuan).setOnClickListener(this);
        edt_qiaoqiaohua = findViewById(R.id.edt_qiaoqiaohua);
    }

    private void initData() {
        Map<String,String> map1 = new HashMap<>();
        map1.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map1.put("couponId",String.valueOf(id));
        map1.put("pillowTalk",edt_qiaoqiaohua.getText().toString());
        OkGo.<String>post(Contacts.URl1+"/wallet/coupon/send")
                .params(map1)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        quanZiShare = new Gson().fromJson(body, QuanZiShare.class);
                            if (quanZiShare.getStatus() == 1){
                                UMWeb web = new UMWeb(quanZiShare.getResult().getUrl());//连接地址
                                web.setTitle(quanZiShare.getResult().getTitle());//标题
                                web.setDescription(quanZiShare.getResult().getContent());//描述
                                if (quanZiShare.getResult().getPhoto()!=null) {
                                    web.setThumb(new UMImage(context, quanZiShare.getResult().getPhoto()));  //网络缩略图
                                } else {
                                    web.setThumb(new UMImage(context, R.mipmap.img_zhanweitu));  //本地缩略图
                                }
                                new ShareAction(activity)
                                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,
                                                SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                                        .withMedia(web)
                                        .setCallback(umShareListener)
                                        .open();
                        }
                    }
                });
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_coupon;
    }

    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext()) * .65f);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_fenxiang:
                if (!utils.isDoubleClick()){
                    dismiss();
                    initData();
                }
                break;
            case R.id.bt_qiaoqiaohua_huanyihuan:
                    Random random = new Random();
                    i = random.nextInt(mqiaoqiaohua.length);
                    if (i<mqiaoqiaohua.length){
                        edt_qiaoqiaohua.setText(mqiaoqiaohua[i]);
                    }
                break;
        }
    }
}
