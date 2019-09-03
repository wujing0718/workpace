package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.Random;

public class PopupCoupon extends BottomPopupView implements View.OnClickListener{
    private final FragmentActivity activity;
    private final Context context;

    private String[] mqiaoqiaohua = new String[]{"茶米送给你，快乐分享给你","你要收下我的茶米，也要收下我","送你我的茶米， 我们一起发家致富"};
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

    public PopupCoupon(Context context, FragmentActivity activity) {
        super(context);
        this.activity = activity;
        this.context = context;

    }

    @Override
    protected void onCreate() {
        super.onCreate();
        findViewById(R.id.bt_fenxiang).setOnClickListener(this);
        findViewById(R.id.bt_qiaoqiaohua_huanyihuan).setOnClickListener(this);
        edt_qiaoqiaohua = findViewById(R.id.edt_qiaoqiaohua);
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
                    UMWeb web = new UMWeb("http://www.baidu.com");//连接地址
                    web.setTitle("火后功夫");//标题
                    web.setDescription("123456");//描述
                    if (TextUtils.isEmpty("")) {
                        web.setThumb(new UMImage(context, R.mipmap.img_back));  //本地缩略图
                    } else {
                        web.setThumb(new UMImage(context, ""));  //网络缩略图
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
