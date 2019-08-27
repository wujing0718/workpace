package com.huohougongfu.app.ShouYe.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChaMi;
import com.huohougongfu.app.Gson.ZhuanZengChengGong;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.ChaMiGuiZe;
import com.huohougongfu.app.PopupView.Paocha;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanZengFragment extends Fragment implements View.OnClickListener {


    private View inflate;
    private EditText edt_chamishu,edt_qiaoqiaohua;
    private String[] mqiaoqiaohua = new String[]{"茶米送给你，快乐分享给你","你要收下我的茶米，也要收下我","送你我的茶米， 我们一起发家致富"};
    private int i;
    private String chamishu,qiaoqiaohua;
    private String token,tel,id;
    private TextView tv_my_cezengsong,tv_my_chami;
    private ChaMi chaMi;
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

    public ZhuanZengFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_zhuan_zeng, container, false);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        initData();
        return inflate;
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("tel",tel);
        map.put("mId",id);
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/wallet/teaRice")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        chaMi = gson.fromJson(body, ChaMi.class);
                        if (chaMi.getStatus() == 1){
                            initView(chaMi);
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initView(ChaMi chaMi) {
        tv_my_cezengsong.setText("可转赠茶米数"+chaMi.getResult().getMe());
        tv_my_chami.setText(String.valueOf(chaMi.getResult().getMe()+chaMi.getResult().getSent()));
    }


    private void initUI() {
        tv_my_chami = inflate.findViewById(R.id.tv_my_chami);
        tv_my_cezengsong = inflate.findViewById(R.id.tv_my_cezengsong);
        edt_chamishu = inflate.findViewById(R.id.edt_chamishu);
        edt_qiaoqiaohua = inflate.findViewById(R.id.edt_qiaoqiaohua);
        inflate.findViewById(R.id.bt_qiaoqiaohua_huanyihuan).setOnClickListener(this);
        inflate.findViewById(R.id.bt_zhuanzengchami).setOnClickListener(this);
        inflate.findViewById(R.id.bt_guize).setOnClickListener(this);
    }

    public static Fragment newInstance(String str){
        ZhuanZengFragment fragment = new ZhuanZengFragment();
        Bundle bundle = new Bundle();
        bundle.putString("",str);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_qiaoqiaohua_huanyihuan:
                Random random = new Random();
                i = random.nextInt(mqiaoqiaohua.length);
                    if (i<mqiaoqiaohua.length){
                        edt_qiaoqiaohua.setText(mqiaoqiaohua[i]);
                }
                break;
            case R.id.bt_zhuanzengchami:
                chamishu = edt_chamishu.getText().toString();
                qiaoqiaohua = edt_qiaoqiaohua.getText().toString();
                if (!utils.isDoubleClick()){
                    if (!token.isEmpty()){
                        initDada();
                    }else{
                        ToastUtils.showShort("暂未登陆");
                    }
                }
                break;
            case R.id.bt_guize:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(getContext())
                            .asCustom(new ChaMiGuiZe(getContext()))
                            .show();
                }
                break;
        }
    }

    private void initDada() {
        Map<String, String> map = new HashMap<>();
        if (!chamishu.isEmpty()){
            if (!"".equals(chamishu)){
                int chamishuone = Integer.valueOf(chamishu);
                if (chamishuone<=chaMi.getResult().getMe()/2){
                    map.put("tel",tel);
                    map.put("mId",id);
                    map.put("token",token);
                    map.put("count",chamishu);
                    map.put("pillowTalk",qiaoqiaohua);
                    OkGo.<String>post(Contacts.URl1+"/wallet/teaRice/send")
                            .params(map)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(Response<String> response) {
                                    WaitDialog.dismiss();
                                    String body = response.body();
                                    Gson gson = new Gson();
                                    ZhuanZengChengGong zhuanzeng = gson.fromJson(body, ZhuanZengChengGong.class);
                                    if (zhuanzeng.getStatus() == 1){

                                        UMWeb web = new UMWeb("http://"+zhuanzeng.getResult().getUrl());//连接地址
                                        web.setTitle(zhuanzeng.getResult().getTitle());//标题
                                        web.setDescription(zhuanzeng.getResult().getContent());//描述
                                        if (TextUtils.isEmpty("")) {
                                            web.setThumb(new UMImage(getActivity(), R.mipmap.img_back));  //本地缩略图
                                        } else {
                                            web.setThumb(new UMImage(getActivity(), zhuanzeng.getResult().getPhoto()));  //网络缩略图
                                        }
                                        new ShareAction(getActivity())
                                                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,
                                                        SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                                                .withMedia(web)
                                                .setCallback(umShareListener).open();
                                    }else {
                                        ToastUtils.showShort(zhuanzeng.getMsg());
                                    }
                                }

                                @Override
                                public void onStart(Request<String, ? extends Request> request) {
                                    WaitDialog.show(getActivity(), "载入中...");
                                    super.onStart(request);
                                }
                            });
                }else{
                    ToastUtils.showShort("超过可赠送茶米数");
                }
            }else{
                ToastUtils.showShort("请输入赠送的茶米数");
            }
        }else{
            ToastUtils.showShort("赠送的茶米数为空");
        }
    }
}
