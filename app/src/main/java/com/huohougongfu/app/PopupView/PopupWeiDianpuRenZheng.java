package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;

import com.google.gson.Gson;
import com.huohougongfu.app.Gson.RenZhengZhuangTai;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Activity.FailedViewActivity;
import com.huohougongfu.app.WoDe.Activity.ReviewViewActivity;
import com.huohougongfu.app.WoDe.Activity.SettingActivity;
import com.huohougongfu.app.WoDe.Activity.ShangHuRenZhengActivity;
import com.huohougongfu.app.WoDe.Activity.TiaoXuanShopActivity;
import com.lxj.xpopup.core.CenterPopupView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

public class PopupWeiDianpuRenZheng extends CenterPopupView {


    private RenZhengZhuangTai renZhengZhuangTai;

    public PopupWeiDianpuRenZheng(@NonNull Context context) {
        super(context);
    }

    // 返回自定义弹窗的布局
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_weidianpurenzheng;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        OkGo.<String>get(Contacts.URl1+"/my/certificationStatus/"+ MyApp.instance.getInt("id"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        renZhengZhuangTai = gson.fromJson(body, RenZhengZhuangTai.class);
                    }
                });
        findViewById(R.id.bt_renzheng).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (renZhengZhuangTai!=null){
                    if (renZhengZhuangTai.getStatus() == 1){
                        if (renZhengZhuangTai.getResult().getStore().getCode() == 0) {
                            Intent intent = new Intent();
                            //商户认证失败
                            intent.putExtra("code","商户认证失败");
                            intent.setClass(getContext(),FailedViewActivity.class);
                            startActivity(intent);
                        }else if (renZhengZhuangTai.getResult().getStore().getCode() == 2){
                            Intent intent = new Intent();
                            intent.setClass(getContext(), TiaoXuanShopActivity.class);
                            startActivity(intent);
                            dismiss();
                        }else if (renZhengZhuangTai.getResult().getStore().getCode() == 3){
                            Intent intent = new Intent();
                            intent.setClass(getContext(), ShangHuRenZhengActivity.class);
                            startActivity(intent);
                            dismiss();
                        }else if (renZhengZhuangTai.getResult().getStore().getCode() == 1){
                            Intent intent = new Intent();
                            intent.setClass(getContext(), ReviewViewActivity.class);
                            startActivity(intent);
                            dismiss();
                        }
                    }
                }
            }
        });
    }
}
