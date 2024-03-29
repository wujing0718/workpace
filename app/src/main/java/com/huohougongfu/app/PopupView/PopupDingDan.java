package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.DingDanZhuanSong;
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

public class PopupDingDan extends BottomPopupView implements View.OnClickListener{
    private final FragmentActivity activity;
    private final Context context;
    private final int orderNo;

    private String[] mqiaoqiaohua = new String[]{"小可爱，给你点了杯茶，记得去喝哦。","茶里有故事，故事里有你我","感谢你给我的每一个拥抱"
            ,"茶里是我对你真挚的祝福","你有多努力就有多特殊。","茶凉就不好喝了，快去喝吧"};
    private int i;
    private UMShareListener umShareListener = new UMShareListener() {
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
    };
    private EditText edt_qiaoqiaohua;
    private DingDanZhuanSong zhuanzeng;

    public PopupDingDan(Context context, FragmentActivity activity, int orderNo) {
        super(context);
        this.activity = activity;
        this.context = context;
        this.orderNo = orderNo;

    }

    @Override
    protected void onCreate() {
        super.onCreate();
        findViewById(R.id.bt_fenxiang).setOnClickListener(this);
        findViewById(R.id.bt_qiaoqiaohua_huanyihuan).setOnClickListener(this);
        edt_qiaoqiaohua = findViewById(R.id.edt_qiaoqiaohua);
        initSend();
    }

    private void initSend() {
        Map<String,String> map = new HashMap<>();
        map.put("orderId",String.valueOf(orderNo));
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("pillowTalk",edt_qiaoqiaohua.getText().toString());
        OkGo.<String>post(Contacts.URl1+"/machine/send/order")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        DingDanZhuanSong dingDanZhuanSong = new Gson().fromJson(body, DingDanZhuanSong.class);
                        if (dingDanZhuanSong.getStatus() == 1){
                            zhuanzeng = dingDanZhuanSong;
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
                    UMWeb web = new UMWeb(zhuanzeng.getResult().getUrl());//连接地址
                    web.setTitle(zhuanzeng.getResult().getTitle());//标题
                    web.setDescription(zhuanzeng.getResult().getContent());//描述
                    if (TextUtils.isEmpty("")) {
                        web.setThumb(new UMImage(context, R.mipmap.img_back));  //本地缩略图
                    } else {
                        web.setThumb(new UMImage(context, zhuanzeng.getResult().getPhoto()));  //网络缩略图
                    }
                    new ShareAction(activity)
                            .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,
                                    SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                            .withMedia(web)
                            .setCallback(umShareListener).open();
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
