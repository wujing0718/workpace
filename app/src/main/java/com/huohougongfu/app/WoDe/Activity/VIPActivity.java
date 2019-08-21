package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.huohougongfu.app.Gson.VIP;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class VIPActivity extends AppCompatActivity implements OnClickListener {


    private ImageView img_ishuiyuan,img_isdianpu,img_ischami,img_isquanxian,img_isfangsaorao,img_iskefu;
    private int id;
    private TextView tv_totalIntegralNum,tv_stavip,tv_endvip;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        ImmersionBar.with(this).init();
        View statusBar = findViewById(R.id.statusBarView);
        ViewGroup.LayoutParams layoutParams = statusBar.getLayoutParams();
        layoutParams.height = utils.getStatusBarHeight();
        id = MyApp.instance.getInt("id");
        initUI();
        initVIP();
    }

    private void initVIP() {
        OkGo.<String>get(Contacts.URl1+"/my/vipInfo/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        VIP vip = gson.fromJson(body, VIP.class);
                        if (vip.getStatus() == 1){
                            initView(vip);
                        }
                    }
                });
    }

    private void initView(VIP vip) {
        progress.setProgress(vip.getResult().getVipPercent());
        tv_stavip.setText("VIP"+vip.getResult().getVipLevel());
        tv_endvip.setText("VIP"+(Integer.valueOf(vip.getResult().getVipLevel())+1));
        tv_totalIntegralNum.setText("+"+vip.getResult().getTotalIntegralNum());
        //是否VIp
        if (vip.getResult().isIsVip()){
            img_ishuiyuan.setImageResource(R.mipmap.img_huiyuan_yes);
        }else{
            img_ishuiyuan.setImageResource(R.mipmap.img_huiyuan_no);
        }
        //是否是线上店铺
        if (vip.getResult().isIsMerchant()){
            img_ishuiyuan.setImageResource(R.mipmap.img_dianpu_yes);
        }else{
            img_ishuiyuan.setImageResource(R.mipmap.img_dianpu_no);
        }
        //茶米福利
        if (vip.getResult().isTeaRiceWelfare()){
            img_ishuiyuan.setImageResource(R.mipmap.img_chami_yes);
        }else{
            img_ishuiyuan.setImageResource(R.mipmap.img_chami_no);
        }
        if (vip.getResult().isStickyPermissions()){
            img_ishuiyuan.setImageResource(R.mipmap.img_zhiding_yes);
        }else{
            img_ishuiyuan.setImageResource(R.mipmap.img_zhiding_no);
        }
        if (vip.getResult().isPreventPermissions()){
            img_ishuiyuan.setImageResource(R.mipmap.img_fangsaorao_yes);
        }else{
            img_ishuiyuan.setImageResource(R.mipmap.img_fangsaorao_no);
        }
        if (vip.getResult().isCustomerService()){
            img_ishuiyuan.setImageResource(R.mipmap.img_kefu_yes);
        }else{
            img_ishuiyuan.setImageResource(R.mipmap.img_kefu_no);
        }
    }


    private void initUI() {
        progress = findViewById(R.id.progress);
        tv_stavip = findViewById(R.id.tv_stavip);
        tv_endvip = findViewById(R.id.tv_endvip);
        tv_totalIntegralNum = findViewById(R.id.tv_totalIntegralNum);
        img_ishuiyuan = findViewById(R.id.img_ishuiyuan);
        img_isdianpu = findViewById(R.id.img_isdianpu);
        img_ischami = findViewById(R.id.img_ischami);
        img_isquanxian = findViewById(R.id.img_isquanxian);
        img_isfangsaorao = findViewById(R.id.img_isfangsaorao);
        img_iskefu = findViewById(R.id.img_iskefu);
        findViewById(R.id.bt_finish).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
        }
    }
}
