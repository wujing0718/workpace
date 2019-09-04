package com.huohougongfu.app.WoDe.Activity;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.huohougongfu.app.Gson.VIP;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Adapter.ChengZhangAdapter;
import com.kongzue.dialog.v2.MessageDialog;
import com.kongzue.dialog.v2.Notification;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnConfirmListener;
import com.lxj.xpopup.interfaces.OnInputConfirmListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class VIPActivity extends AppCompatActivity implements OnClickListener {


    private ImageView img_ishuiyuan,img_isdianpu,img_ischami,img_isquanxian,img_isfangsaorao,img_iskefu;
    private int id;
    private TextView tv_totalIntegralNum,tv_stavip,tv_endvip;
    private ProgressBar progress;
    private RecyclerView rec_chengzhang;

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
                img_isdianpu.setImageResource(R.mipmap.img_dianpu_yes);
            }else{
                img_isdianpu.setImageResource(R.mipmap.img_dianpu_no);
            }
            //茶米福利
            if (vip.getResult().isTeaRiceWelfare()){
                img_ischami.setImageResource(R.mipmap.img_chami_yes);
            }else{
                img_ischami.setImageResource(R.mipmap.img_chami_no);
            }
            if (vip.getResult().isStickyPermissions()){
                img_isquanxian.setImageResource(R.mipmap.img_zhiding_yes);
            }else{
                img_isquanxian.setImageResource(R.mipmap.img_zhiding_no);
            }
            if (vip.getResult().isPreventPermissions()){
                img_isfangsaorao.setImageResource(R.mipmap.img_fangsaorao_yes);
            }else{
                img_isfangsaorao.setImageResource(R.mipmap.img_fangsaorao_no);
            }
            if (vip.getResult().isCustomerService()){
                img_iskefu.setImageResource(R.mipmap.img_kefu_yes);
            }else{
                img_iskefu.setImageResource(R.mipmap.img_kefu_no);
            }
        LinearLayoutManager layoutManager = new LinearLayoutManager(VIPActivity.this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rec_chengzhang.setLayoutManager(layoutManager);
        ChengZhangAdapter chengZhangAdapter = new ChengZhangAdapter(R.layout.item_vip_chengzhang, vip.getResult().getIntegralRecord());
        rec_chengzhang.setAdapter(chengZhangAdapter);
    }

    private void initUI() {
        findViewById(R.id.bt_huiyuan).setOnClickListener(this);
        findViewById(R.id.bt_dianpu).setOnClickListener(this);
        findViewById(R.id.bt_chami).setOnClickListener(this);
        findViewById(R.id.bt_zhiding).setOnClickListener(this);
        findViewById(R.id.bt_fangsaorao).setOnClickListener(this);
        findViewById(R.id.bt_kefu).setOnClickListener(this);
        rec_chengzhang = findViewById(R.id.rec_chengzhang);
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
            case R.id.bt_huiyuan:
                if (!utils.isDoubleClick()){
                    MessageDialog.show(VIPActivity.this, "会员标识", "实名认证并进行一笔消费\n" +
                            "即可拥有专属会员图标");
                }
                break;
            case R.id.bt_dianpu:
                if (!utils.isDoubleClick()){
                    MessageDialog.show(VIPActivity.this, "线上店铺", "下载注册即可自动开通线上店铺");
                }
                break;
            case R.id.bt_chami:
                if (!utils.isDoubleClick()){
                    MessageDialog.show(VIPActivity.this, "茶米福利", "实名认证并进行一笔消费\n" +
                            "即可拥转赠茶米或者在消费时进行抵扣");
                }
                break;
            case R.id.bt_zhiding:
                if (!utils.isDoubleClick()){
                    MessageDialog.show(VIPActivity.this, "制定权限", "实名认证并进行一笔消费\n" +
                            "即可置顶任意一条动态");
                }
                break;
            case R.id.bt_fangsaorao:
                if (!utils.isDoubleClick()){
                    MessageDialog.show(VIPActivity.this, "防止骚扰", "实名认证并进行一笔消费\n" +
                            "即可防止骚扰");
                }
                break;
            case R.id.bt_kefu:
                if (!utils.isDoubleClick()){
                    MessageDialog.show(VIPActivity.this, "专属客服", "实名认证并进行一笔消费\n" +
                            "即可拥有专属客服图标");
                }
                break;
        }
    }
}
