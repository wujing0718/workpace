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
import android.os.Handler;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.huohougongfu.app.Activity.LoginActivity;
import com.huohougongfu.app.Activity.MainActivity;
import com.kongzue.dialog.v2.DialogSettings;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import me.leolin.shortcutbadger.ShortcutBadger;
import okhttp3.OkHttpClient;

import static com.kongzue.dialog.v2.DialogSettings.STYLE_IOS;
import static com.kongzue.dialog.v2.DialogSettings.THEME_LIGHT;
import static io.rong.imlib.RongIMClient.ErrorCode.RC_CONN_USER_OR_PASSWD_ERROR;

public class MyApp extends Application {

    public static Context context;
    private static final int MSG_SET_ALIAS = 1001;
    public static final String APP_ID = "wxa36e44f4072c4818";
    public static IWXAPI wxapi;

    static {//static 代码段可以防止内存泄露
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorTab, android.R.color.white);//全局设置主题颜色
                //设置 Header 起始位置偏移量
                layout.setHeaderInsetStart(-10);
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
                    // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
                    break;
                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
                    // 延迟 60 秒来调用 Handler 设置别名
                    mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_ALIAS, alias), 1000 * 60);
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
//        DoraemonKit.install(this);
        //设置是否启用模糊
//        DialogSettings.use_blur = true;
        instance = SPUtils.getInstance("登录");
        DialogSettings.dialog_theme = THEME_LIGHT;//设置提示框主题为亮色主题
        DialogSettings.style = STYLE_IOS;
        DialogSettings.blur_alpha = 250;
        RongIM.init(this);
        context = this;
        Utils.init(getApplicationContext());
        instances = this;
        UMConfigure.init(this,"5d1efbd54ca357a016000105"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
//        UMConfigure.setLogEnabled(true);
        JPushInterface.init(this);
        JPushInterface.setDebugMode(true);
        //微信支付初始化
        wxapi = WXAPIFactory.createWXAPI(this, APP_ID, true);
        wxapi.registerApp(APP_ID);
        //微信
        PlatformConfig.setWeixin("wxa36e44f4072c4818", "0d66a870efd3c36ed2f6c9daea50626e");
        //QQ
        PlatformConfig.setQQZone("101767868", "64b41c424e93122ef5430ac54c194621");
        //新浪
        PlatformConfig.setSinaWeibo("3354599465", "b194e78d0a9811f19c262a37ae5205c8","https://api.weibo.com/oauth2/default.html");

        String rongToken = instance.getString("rongToken");
        // token 就是你刚刚获取的token
        if (!"".equals(rongToken)){
            RongIM.setConnectionStatusListener(new MyConnectionStatusListener());
        }
        RongIM.setOnReceiveMessageListener(new MyReceiveMessageListener());
        RongPushClient.sendNotification(this,new PushNotificationMessage());
        // 调用 Handler 来异步设置别名
        int id = MyApp.instance.getInt("id");
        if (id!=0){
            mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, String.valueOf(id)));
        }
        initOkGo();
        super.onCreate();
    }

    private void initOkGo() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpParams params = new HttpParams();
        params.put("token",MyApp.instance.getString("token"));
        params.put("tokenId",String.valueOf(MyApp.instance.getInt("id")));
        //超时时间设置，默认10秒
        builder.readTimeout(8000, TimeUnit.MILLISECONDS);      //全局的读取超时时间
        builder.writeTimeout(8000, TimeUnit.MILLISECONDS);     //全局的写入超时时间
        builder.connectTimeout(8000, TimeUnit.MILLISECONDS);   //全局的连接超时时间
        OkGo.getInstance().init(this)
                .setRetryCount(3)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonParams(params);
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

            return false;
        }
    }

    private class MyConnectionStatusListener implements RongIMClient.ConnectionStatusListener {

        @Override
        public void onChanged(ConnectionStatus connectionStatus) {

            switch (connectionStatus){

                case CONNECTED://连接成功。

                    break;
                case DISCONNECTED://断开连接。

                    break;
                case CONNECTING://连接中。

                    break;
                case NETWORK_UNAVAILABLE://网络不可用。

                    break;
                case KICKED_OFFLINE_BY_OTHER_CLIENT://用户账户在其他设备登录，本机会被踢掉线
                    Intent intent = new Intent();
                    instance.clear(true);
                    RongIM.getInstance().logout();
                    JPushInterface.stopPush(context);
                    intent.setClass(context,LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    MainActivity.activity.finish();
                    break;
            }
        }
    }

    public static MyApp getInstances(){
        return instances;
    }

}
