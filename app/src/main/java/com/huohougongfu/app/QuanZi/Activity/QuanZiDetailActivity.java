package com.huohougongfu.app.QuanZi.Activity;

import android.Manifest;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.DiaPuZhuYeActivity;
import com.huohougongfu.app.Gson.GuanZhu;
import com.huohougongfu.app.Gson.PingLunGson;
import com.huohougongfu.app.Gson.QuanZiDetail;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.Gson.QuanZiShare;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.PingLunAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GlideImageLoader;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.AddRegionActivity;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.huohougongfu.app.R.drawable.yiguanzhu;

public class QuanZiDetailActivity extends AppCompatActivity implements View.OnClickListener,UMShareListener {

    private Banner banner;
    private ImageView img_quanzi_touxiang;
    private TextView tv_quanzi_name,tv_quanzi_chenghu,tv_quanzi_weizhi,tv_quanzi_time,tv_quanzi_content;
    private List<String> mbanner = new ArrayList<>();
    private View view_detail_pinglun;
    private RecyclerView rec_wenzhang_pinglun;
    private EditText edt_quanzi_pinglun;
    private int mId;
    private int dId;
    private View view_pinglun_fasong;
    private View view_detail_weizhi;
    private TextView pinglunnum,xihuannum;
    private QuanZiDetail detail;
    private ImageView img_shoucang;
    private View bt_gengduo;
    private PingLunGson pinglun;
    private TextView tv_guanzhu;
    private Intent intent;
    private List<Integer> guanzhuId = new ArrayList<>();
    private int userid;
    private String token;
    private View view_vip;
    private TextView tv_vip_num;
    private QuanZiShare share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_zi_detail);
        dId = getIntent().getIntExtra("dId", 0);
        userid = getIntent().getIntExtra("userid", 0);
        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        intent = new Intent();
        initUI();
        initData();
    }


    private void initUI() {
        view_vip = findViewById(R.id.view_vip);
        tv_vip_num = findViewById(R.id.tv_vip_num);
        findViewById(R.id.bt_geren_zhuye).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        bt_gengduo = findViewById(R.id.bt_gengduo);
        bt_gengduo.setOnClickListener(this);
        findViewById(R.id.bt_guanzhu).setOnClickListener(this);
        findViewById(R.id.bt_dianzan).setOnClickListener(this);
        pinglunnum = findViewById(R.id.tv_detail_pinglunnum);
        xihuannum = findViewById(R.id.tv_detail_xihuannum);
        tv_guanzhu = findViewById(R.id.tv_guanzhu);
        img_shoucang = findViewById(R.id.img_shoucang);
        edt_quanzi_pinglun = findViewById(R.id.edt_quanzi_pinglun);
        view_detail_weizhi = findViewById(R.id.view_detail_weizhi);
        findViewById(R.id.bt_fasong_pinglun).setOnClickListener(this);
        rec_wenzhang_pinglun = findViewById(R.id.rec_wenzhang_pinglun);
        view_detail_pinglun = findViewById(R.id.view_detail_pinglun);
        view_pinglun_fasong = findViewById(R.id.view_pinglun_fasong);
        banner = findViewById(R.id.banner);
        img_quanzi_touxiang = findViewById(R.id.img_quanzi_touxiang);
        tv_quanzi_name = findViewById(R.id.tv_quanzi_name);
        tv_quanzi_chenghu = findViewById(R.id.tv_quanzi_chenghu);
        tv_quanzi_content = findViewById(R.id.tv_quanzi_content);
        tv_quanzi_weizhi = findViewById(R.id.tv_quanzi_weizhi);
        tv_quanzi_time = findViewById(R.id.tv_quanzi_time);
//        findViewById(R.id.bt_zhankaipinglun).setOnClickListener(this);
        initPingLun();
    }

    private void initPingLun() {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(dId));
        map.put("mId",String.valueOf(mId));
        map.put("pageNo","1");
        map.put("pageSize","10");
        OkGo.<String>post(Contacts.URl1+"/circle/comments/list")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        PingLunGson pinglun1 = gson.fromJson(body, PingLunGson.class);
                        if (pinglun1.getStatus() == 1){
                            pinglun = pinglun1;
                            initRec(pinglun1.getResult().getList());
                        }
                    }
                });

    }

    private void initRec(List<PingLunGson.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_wenzhang_pinglun.setLayoutManager(layoutmanager);
        PingLunAdapter pingLunAdapter = new PingLunAdapter(R.layout.item_quanzi_pinglun, list);
        rec_wenzhang_pinglun.setAdapter(pingLunAdapter);
        pingLunAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView dianzannum = view.findViewById(R.id.tv_pinglun_dianzannum);
                ImageView img_pinglun_dianzan = view.findViewById(R.id.img_pinglun_dianzan);
                if (list.get(position).getIsPraise() == 1){
                    initQuXiaoPinglunDianZan(0,list.get(position),dianzannum,img_pinglun_dianzan);
                }else if (list.get(position).getIsPraise() == 0){
                    initPinglunDianZan(1,list.get(position),dianzannum,img_pinglun_dianzan);
                }
            }
        });
    }

    private void initPinglunDianZan(int i, PingLunGson.ResultBean.ListBean listBean, TextView dianzannum, ImageView img_pinglun_dianzan) {
        String num = dianzannum.getText().toString();
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("commentId",String.valueOf(listBean.getId()));
        map.put("commentMId",String.valueOf(listBean.getMember().getUserId()));
        map.put("type",String.valueOf(i));
        OkGo.<String>post(Contacts.URl1+"/circle/comment/praise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort("点赞成功");
                                Integer integer = Integer.valueOf(num);
                                dianzannum.setText(String.valueOf(integer+1));
                                listBean.setIsPraise(1);
                                img_pinglun_dianzan.setImageResource(R.mipmap.img_dianzanok);
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initQuXiaoPinglunDianZan(int i, PingLunGson.ResultBean.ListBean listBean, TextView dianzannum, ImageView img_pinglun_dianzan) {
        String num = dianzannum.getText().toString();
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("commentId",String.valueOf(listBean.getId()));
        map.put("commentMId",String.valueOf(listBean.getMember().getUserId()));
        map.put("type",String.valueOf(i));
        OkGo.<String>post(Contacts.URl1+"/circle/comment/praise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort("取消点赞");
                                Integer integer = Integer.valueOf(num);
                                dianzannum.setText(String.valueOf(integer-1));
                                listBean.setIsPraise(0);
                                img_pinglun_dianzan.setImageResource(R.mipmap.img_dianzan);
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initData() {
        Map<String ,String> map = new HashMap<>();
        if (userid != 0){
            map.put("userId",String.valueOf(userid));
        }
        map.put("dId",String.valueOf(dId));
        map.put("mId",String.valueOf(mId));
        OkGo.<String>post(Contacts.URl1+"/circle/data/info")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        detail = gson.fromJson(body, QuanZiDetail.class);
                        if (detail.getStatus() == 1){
                            initView(detail.getResult());
                            initShare(detail);
                            if (detail.getResult().getIsPraise() == 1){
                                img_shoucang.setImageResource(R.mipmap.img_xihuan2);
                            }else{
                                img_shoucang.setImageResource(R.mipmap.img_xihuan);
                            }
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(QuanZiDetailActivity.this,"载入中...");
                        super.onStart(request);
                    }
                });
    }

    // 获取圈子分享链接
    private void initShare(QuanZiDetail detail) {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(detail.getResult().getId()));
        map.put("type",String.valueOf(detail.getResult().getType()));
        map.put("photoUrl",detail.getResult().getMember().getPhoto());
        OkGo.<String>post(Contacts.URl1+"/circle/getShareUrl")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        QuanZiShare quanZiShare = new Gson().fromJson(body, QuanZiShare.class);
                        if (quanZiShare.getStatus() == 1){
                            share = quanZiShare;
                        }
                    }
                });
    }

    private void initView(QuanZiDetail.ResultBean result) {
        xihuannum.setText(String.valueOf(result.getPraiseNum()));
        pinglunnum.setText(String.valueOf(result.getCommentNum()));
        if (result.getAddress() !=null){
            view_detail_weizhi.setVisibility(View.VISIBLE);
            tv_quanzi_weizhi.setText(result.getAddress());
        }else{
            view_detail_weizhi.setVisibility(View.GONE);
        }
        if (result!=null){
            String picture = result.getPicture();
            String[] split = picture.split(",");
            if (split.length>0) {
                for (int i = 0; i < split.length; i++) {
                    mbanner.add(split[i]);
                }
            }
        }
        if (result.getMember().getVip()){
            tv_vip_num.setText("."+result.getMember().getMemberLevel());
            view_vip.setVisibility(View.VISIBLE);
        }else{
            view_vip.setVisibility(View.GONE);
        }
        if (result.getMember().getIsAttention() ==1){
            tv_guanzhu.setBackgroundResource(R.drawable.yiguanzhu);
            tv_guanzhu.setText("已关注");
            tv_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorWhite));
        }else{
            tv_guanzhu.setText("+关注");
            tv_guanzhu.setBackgroundResource(R.drawable.guanzhu);
            tv_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.black));
        }
        //加载网络图片
        banner.setImages(mbanner)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .start();
        String time = utils.transForDate2(Long.valueOf(result.getCreateTime()));
        tv_quanzi_content.setText(result.getContent());
        tv_quanzi_time.setText(time);
        tv_quanzi_name.setText(result.getMember().getNickName());
        tv_quanzi_chenghu.setText(result.getMember().getMaster().getLevel());
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(QuanZiDetailActivity.this).load(result.getMember().getPhoto()).apply(requestOptions).into(img_quanzi_touxiang);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_guanzhu:
                if (!utils.isDoubleClick()){
                    if (!"".equals(token)){
                        if (detail.getResult().getMember().getIsAttention() == 1){
                        initNoGuanZhu(0);
                    }else if (detail.getResult().getMember().getIsAttention() == 0){
                        initGuanZhu(1);
                    }
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                    }
                }
                break;
            case R.id.bt_geren_zhuye:
                if (!utils.isDoubleClick()){
                    Intent intent = new Intent();
                    intent.putExtra("id",String.valueOf(userid));
                    intent.setClass(QuanZiDetailActivity.this,DiaPuZhuYeActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.bt_dianzan:
                if (!utils.isDoubleClick()){
                    if (!"".equals(token)){
                        if (detail.getResult().getIsPraise() == 1){
                        initQuXiaoDianZan("0");
                    }else{
                        initDianZan("1");
                    }
                }else{
                    ToastUtils.showShort(R.string.denglu);
                    }
                }
                break;
            case R.id.bt_gengduo:
                String[] caozuo;
                if (userid == MyApp.instance.getInt("id")){
                    caozuo = new String[]{"分享", "举报","删除"};
                }else{
                    caozuo= new String[]{"分享", "举报"};
                }
                new XPopup.Builder(QuanZiDetailActivity.this)
                        .hasShadowBg(false)
//                        .popupAnimation(PopupAnimation.NoAnimation) //NoAnimation表示禁用动画
//                        .isCenterHorizontal(true) //是否与目标水平居中对齐
                        .offsetY(-10)
                        .offsetX(00)
                        .popupPosition(PopupPosition.Left) //手动指定弹窗的位置
                        .atView(bt_gengduo)  // 依附于所点击的View，内部会自动判断在上方或者下方显示
                        .asAttachList(caozuo, new int[]{},
                                new OnSelectListener() {
                                    @Override
                                    public void onSelect(int position, String text) {
                                        if ("分享".equals(text)){
                                            UMWeb web = new UMWeb(share.getResult().getUrl());//连接地址
                                            web.setTitle(share.getResult().getTitle());//标题
                                            web.setDescription(share.getResult().getContent());//描述
                                            if (share.getResult().getPhoto()!=null) {
                                                web.setThumb(new UMImage(QuanZiDetailActivity.this, share.getResult().getPhoto()));  //网络缩略图
                                            } else {
                                                web.setThumb(new UMImage(QuanZiDetailActivity.this, R.mipmap.img_zhanweitu));  //本地缩略图
                                            }
                                            new ShareAction(QuanZiDetailActivity.this)
                                                    .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,
                                                            SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                                                    .withMedia(web)
                                                    .setCallback(QuanZiDetailActivity.this).open();
                                        }else if ("举报".equals(text)){
                                            intent.putExtra("dataId",String.valueOf(dId));
                                            intent.putExtra("username",detail.getResult().getMember().getNickName());
                                            intent.putExtra("photo",detail.getResult().getPicture());
                                            intent.putExtra("title",detail.getResult().getContent());
                                            intent.setClass(QuanZiDetailActivity.this,JuBaoActivity.class);
                                            startActivity(intent);
                                        }else if ("删除".equals(text))
                                            SelectDialog.show(QuanZiDetailActivity.this, "提示", "是否删除该条圈子",
                                                    "确定", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            //删除这条圈子
                                                            initDel(dId);
                                                        }
                                                    },
                                                    "取消", new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                        }
                                                    });
                                    }
                                })
                        .show();
                break;
            case R.id.bt_fasong_pinglun:
                String pinglun_content = edt_quanzi_pinglun.getText().toString();
                if (!utils.isDoubleClick()){
                    if (!pinglun_content.isEmpty()){
                        if (!"".equals(token)){
                            initFaSongPingLun(pinglun_content);
                        }else{
                            ToastUtils.showShort(R.string.denglu);
                        }
                    }else{
                        ToastUtils.showShort("请输入评论内容");
                    }
                }
                break;
//            case R.id.bt_zhankaipinglun:
//                view_detail_pinglun.setVisibility(View.VISIBLE);
//                view_pinglun_fasong.setVisibility(View.VISIBLE);
//                break;
        }
    }

    private void initDel(int id) {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("dataIds",String.valueOf(id));
        OkGo.<String>post(Contacts.URl1+"/circle/del")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                finish();
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initGuanZhu(int type) {
        int userId = detail.getResult().getMember().getUserId();
        Map<String,String> map =new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("attentionId",String.valueOf(userId));
        map.put("type",String.valueOf(type));
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/attention")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                detail.getResult().getMember().setIsAttention(1);
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                tv_guanzhu.setBackgroundResource(R.drawable.yiguanzhu);
                                tv_guanzhu.setText("已关注");
                                tv_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorWhite));
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initNoGuanZhu(int type) {
        int userId = detail.getResult().getMember().getUserId();
        Map<String,String> map =new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("attentionId",String.valueOf(userId));
        map.put("type",String.valueOf(type));
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/attention")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                detail.getResult().getMember().setIsAttention(0);
                                tv_guanzhu.setText("+关注");
                                tv_guanzhu.setBackgroundResource(R.drawable.guanzhu);
                                tv_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.black));
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //取消点赞
    private void initQuXiaoDianZan(String type) {
        Map<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("token",token);
        map.put("dataId",String.valueOf(detail.getResult().getId()));
        map.put("mId",String.valueOf(mId));
        OkGo.<String>post(Contacts.URl1+"/circle/praise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                String num = xihuannum.getText().toString();
                                Integer integer = Integer.valueOf(num);
                                xihuannum.setText(String.valueOf(integer-1));
                                detail.getResult().setIsPraise(0);
                                img_shoucang.setImageResource(R.mipmap.img_xihuan);
                                ToastUtils.showShort("取消点赞");
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
    //点赞
    private void initDianZan(String type) {
        String num = xihuannum.getText().toString();
        Map<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("dataId",String.valueOf(detail.getResult().getId()));
        map.put("mId",String.valueOf(mId));
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/praise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort("点赞成功");
                                Integer integer = Integer.valueOf(num);
                                xihuannum.setText(String.valueOf(integer+1));
                                detail.getResult().setIsPraise(1);
                                img_shoucang.setImageResource(R.mipmap.img_xihuan2);
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initFaSongPingLun(String pinglun_content) {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(dId));
        map.put("mId",String.valueOf(mId));
        map.put("content",pinglun_content);
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/comment")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                initPingLun();
                                ToastUtils.showShort("评论成功");
                                edt_quanzi_pinglun.setText("");
                                initData();
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

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
        ToastUtils.showShort("取消分享");
    }
}
