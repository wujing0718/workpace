package com.huohougongfu.app;

import android.Manifest;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.Utils;
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

import static com.kongzue.dialog.v2.DialogSettings.STYLE_IOS;
import static com.kongzue.dialog.v2.DialogSettings.THEME_LIGHT;

public class MyApp extends Application {

    public static Context context;
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

    private static MyApp instances;
    public static SPUtils instance;

    @Override
    public void onCreate() {
        //设置是否启用模糊
        DialogSettings.use_blur = true;
        DialogSettings.dialog_theme = THEME_LIGHT;
        DialogSettings.style = STYLE_IOS;
        context = this;
        Utils.init(getApplicationContext());
        UMConfigure.setLogEnabled(true);
        instances = this;
        UMConfigure.init(this,"5d1efbd54ca357a016000105"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
        //微信
        PlatformConfig.setWeixin("wxa36e44f4072c4818", "3baf1193c85774b3fd9d18447d76cab0");
        //QQ
        PlatformConfig.setQQZone("1107763346", "pPudlhFSifMTHqjm");
        //新浪
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");

        instance = SPUtils.getInstance("登录");
        super.onCreate();
    }

    public static MyApp getInstances(){
        return instances;
    }

}
