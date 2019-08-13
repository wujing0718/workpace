package com.huohougongfu.app;

import android.Manifest;
import android.app.Application;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.Utils;
import com.huohougongfu.app.Activity.MainActivity;
import com.huohougongfu.app.Activity.XiaoXiActivity;
import com.huohougongfu.app.RongYun.ConversationActivity;
import com.kongzue.dialog.v2.DialogSettings;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import io.rong.imkit.RongIM;
import io.rong.imkit.utils.RongOperationPermissionUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.push.PushType;
import io.rong.push.RongPushClient;
import io.rong.push.notification.PushMessageReceiver;
import io.rong.push.notification.PushNotificationMessage;
import io.rong.push.rongpush.RongPush;

import static com.kongzue.dialog.v2.DialogSettings.STYLE_IOS;
import static com.kongzue.dialog.v2.DialogSettings.THEME_LIGHT;

public class MyApp extends Application {

    public static Context context;
    private static final int MSG_SET_ALIAS = 1001;
    static {//static 代码段可以防止内存泄露
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorTab, android.R.color.white);//全局设置主题颜色
                return new MaterialHeader(context);//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });
    }
    //设置别名
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SET_ALIAS:
//                    Log.d(TAG, "Set alias in handler.");
                    // 调用 JPush 接口来设置别名。
                    JPushInterface.setAliasAndTags(getApplicationContext(),
                            (String) msg.obj,
                            null,
                            mAliasCallback);
                    break;
                default:
            }
        }
    };
    private final TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs ;
            switch (code) {
                case 0:
                    logs = "设置成功";
//                    LogUtils.e(logs);
                    // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
                    break;
                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
                    // 延迟 60 秒来调用 Handler 设置别名
                    mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_ALIAS, alias), 1000 * 60);
//                    LogUtils.e(logs);
                    break;
                default:
                    logs = "Failed with errorCode = " + code;
            }
//            ExampleUtil.showToast(logs, getApplicationContext());
        }
    };


    private static MyApp instances;
    public static SPUtils instance;
    private NotificationManager manager;

    @Override
    public void onCreate() {
        //设置是否启用模糊
        DialogSettings.use_blur = true;
        DialogSettings.dialog_theme = THEME_LIGHT;
        DialogSettings.style = STYLE_IOS;
        RongIM.init(this);
        context = this;
        Utils.init(getApplicationContext());
        UMConfigure.setLogEnabled(true);
        instances = this;
        UMConfigure.init(this,"5d1efbd54ca357a016000105"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        JPushInterface.init(this);
        JPushInterface.setDebugMode(true);
        //微信
        PlatformConfig.setWeixin("wxa36e44f4072c4818", "3baf1193c85774b3fd9d18447d76cab0");
        //微信支付初始化
        //QQ
        PlatformConfig.setQQZone("1107763346", "pPudlhFSifMTHqjm");
        //新浪
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");

        instance = SPUtils.getInstance("登录");
        String rongToken = instance.getString("rongToken");
        // token 就是你刚刚获取的token
        if (!"".equals(rongToken)){
            RongIM.connect(rongToken, new RongIMClient.ConnectCallback() {
                //token1参数报错
                @Override
                public void onTokenIncorrect() {
                    Log.e("TAG","参数错误");
                }

                @Override
                public void onSuccess(String s) {
                    Log.e("TAG","成功");
                    // 连接成功，说明你已成功连接到融云Server
                }

                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    Log.e("TAG","失败");
                }
            });
        }
        RongIM.setOnReceiveMessageListener(new MyReceiveMessageListener());
        RongPushClient.sendNotification(this,new PushNotificationMessage());
// 调用 Handler 来异步设置别名
        int id = MyApp.instance.getInt("id");
        if (id!=0){
            mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, String.valueOf(id)));
        }
        super.onCreate();
    }
    private class MyReceiveMessageListener implements RongIMClient.OnReceiveMessageListener {

        /**
         * 收到消息的处理。
         *
         * @param message 收到的消息实体。
         * @param left    剩余未拉取消息数目。
         * @return 收到消息是否处理完成，true 表示自己处理铃声和后台通知，false 走融云默认处理方式。
         */

        @Override
        public boolean onReceived(Message message, int left) {
            Log.e("TAG","成功");
            return false;
        }
    }

    public static MyApp getInstances(){
        return instances;
    }

}
