package com.huohougongfu.app.QuanZi.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.PingLunGson;
import com.huohougongfu.app.Gson.QuanZiDetail;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.Gson.QuanZiShare;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.PingLunAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WenZhangDetailActivity extends AppCompatActivity implements View.OnClickListener ,UMShareListener{

    private int mId;
    private int dId;
    private QuanZiDetail detail;
    private ImageView img_quanzi_touxiang;
    private TextView tv_quanzi_name,tv_quanzi_chenghu;
    private LinearLayout view_wenzhang;
    private View bt_gengduo;
    private RecyclerView rec_wenzhang_pinglun;
    private PingLunGson pinglun;
    private EditText edt_quanzi_pinglun;
    private Intent intent;
    private TextView tv_guanzhu;
    private String token;
    private int userid;
    private TextView tv_quanzi_weizhi;
    private PingLunAdapter pingLunAdapter;
    private TextView tv_wenzhang_title;
    private TextView tv_wenzhang_time,tv_liulanliang_num,tv_pinglum_num,tv_xihuan_num;
    private ImageView img_xihuan;
    private TextView tv_vip_num;
    private View view_vip;
    private QuanZiShare share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wen_zhang_detail);
        dId = getIntent().getIntExtra("dId", 0);
        userid = getIntent().getIntExtra("userid", 0);
        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        intent = new Intent();
        initUI();
    }


    private void initUI() {
        tv_vip_num = findViewById(R.id.tv_vip_num);
        view_vip = findViewById(R.id.view_vip);

        tv_wenzhang_title = findViewById(R.id.tv_wenzhang_title);
        img_quanzi_touxiang = findViewById(R.id.img_quanzi_touxiang);
        tv_guanzhu = findViewById(R.id.tv_guanzhu);
        view_wenzhang = findViewById(R.id.view_wenzhang);
        tv_quanzi_name = findViewById(R.id.tv_quanzi_name);
        tv_quanzi_chenghu = findViewById(R.id.tv_quanzi_chenghu);
        tv_quanzi_weizhi = findViewById(R.id.tv_quanzi_weizhi);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_guanzhu).setOnClickListener(this);
        bt_gengduo = findViewById(R.id.bt_gengduo);
        bt_gengduo.setOnClickListener(this);
        edt_quanzi_pinglun = findViewById(R.id.edt_quanzi_pinglun);
        findViewById(R.id.bt_fasong_pinglun).setOnClickListener(this);
        initData();
    }

    private void initData() {
        Map<String ,String> map = new HashMap<>();
        if (userid != 0){
            map.put("userId",String.valueOf(userid));
        }
        map.put("dId",String.valueOf(dId));
        map.put("mId",String.valueOf(mId));
        map.put("token",token);
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
                            initShare(detail.getResult());
                            initPingLun(detail.getResult());
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(WenZhangDetailActivity.this,"载入中...");
                        super.onStart(request);
                    }
                });
    }
    // 获取圈子分享链接
    private void initShare(QuanZiDetail.ResultBean result) {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(result.getId()));
        map.put("type",String.valueOf(result.getType()));
        map.put("photoUrl",result.getMember().getPhoto());
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

    private void initPingLun(QuanZiDetail.ResultBean detail) {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(dId));
        map.put("pageNo","1");
        map.put("token",token);
        map.put("mId",String.valueOf(mId));
        map.put("pageSize","10");
        OkGo.<String>post(Contacts.URl1+"/circle/comments/list")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        PingLunGson pinglun1 = gson.fromJson(body, PingLunGson.class);
                        if (pinglun1.getStatus() == 1){
                            pinglun = pinglun1;
                            initView(detail,pinglun1);
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(WenZhangDetailActivity.this,"载入中...");
                        super.onStart(request);
                    }
                });

    }

    private void initView(QuanZiDetail.ResultBean result,PingLunGson pinglun) {

        if (result.getMember().getVip()){
            tv_vip_num.setText("."+result.getMember().getMemberLevel());
            view_vip.setVisibility(View.VISIBLE);
        }else{
            view_vip.setVisibility(View.GONE);
        }
        String content = result.getContent();
        String picture = result.getPicture();
        String[] split1 = picture.split(",");
        String[] mcontent = content.split("わわ");
        if (result.getMember().getIsAttention() ==1){
            tv_guanzhu.setBackgroundResource(R.drawable.yiguanzhu);
            tv_guanzhu.setText("已关注");
            tv_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorWhite));
        }else{
            tv_guanzhu.setText("+关注");
            tv_guanzhu.setBackgroundResource(R.drawable.guanzhu);
            tv_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.black));
        }
        tv_wenzhang_title.setText(result.getTitle());
        tv_quanzi_weizhi.setText(result.getAddress());
        view_wenzhang.removeAllViews();
        int temp = 0;
            for (int i = 0;i<mcontent.length;i++){
                if ("ゐゑを".equals(mcontent[i])){
                    ImageView imageView = new ImageView(WenZhangDetailActivity.this);
                    Glide.with(MyApp.context).load(split1[temp]).into(imageView);
                    temp+=1;
                    view_wenzhang.addView(imageView);
                }else{
                    TextView textView = new TextView(WenZhangDetailActivity.this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(20,20,20,20);
                    textView.setText(mcontent[i]);
                    textView.setLayoutParams(layoutParams);
                    textView.setText(mcontent[i]);
                    view_wenzhang.addView(textView);
                }
            }
        rec_wenzhang_pinglun = new RecyclerView(WenZhangDetailActivity.this);
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_wenzhang_pinglun.setLayoutManager(layoutmanager);
        View wenzhang_view_time = LayoutInflater.from(this).inflate(R.layout.wenzhang_view_time, null, false);
        wenzhang_view_time.findViewById(R.id.bt_dianzan).setOnClickListener(this);
        img_xihuan = wenzhang_view_time.findViewById(R.id.img_xihuan);
        if (result.getIsPraise() == 1){
            img_xihuan.setImageResource(R.mipmap.img_xihuan2);
        }else{
            img_xihuan.setImageResource(R.mipmap.img_xihuan);
        }
        tv_liulanliang_num = wenzhang_view_time.findViewById(R.id.tv_liulanliang_num);
        tv_pinglum_num = wenzhang_view_time.findViewById(R.id.tv_pinglum_num);
        tv_xihuan_num = wenzhang_view_time.findViewById(R.id.tv_xihuan_num);
        tv_wenzhang_time = wenzhang_view_time.findViewById(R.id.tv_wenzhang_time);
        tv_pinglum_num.setText(String.valueOf(result.getCommentNum()));
        tv_liulanliang_num.setText(String.valueOf(result.getBrowseCount()));
        tv_xihuan_num.setText(String.valueOf(result.getPraiseNum()));
        pingLunAdapter = new PingLunAdapter(R.layout.item_quanzi_pinglun, pinglun.getResult().getList());
        rec_wenzhang_pinglun.setAdapter(pingLunAdapter);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,20,10,20);
        wenzhang_view_time.setLayoutParams(layoutParams);
        view_wenzhang.addView(wenzhang_view_time);
        view_wenzhang.addView(rec_wenzhang_pinglun);
        tv_quanzi_name.setText(result.getMember().getNickName());
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(WenZhangDetailActivity.this).load(result.getMember().getPhoto()).apply(requestOptions).into(img_quanzi_touxiang);

        pingLunAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView dianzannum = view.findViewById(R.id.tv_pinglun_dianzannum);
                ImageView img_pinglun_dianzan = view.findViewById(R.id.img_pinglun_dianzan);
                if (pinglun.getResult().getList().get(position).getIsPraise() == 1){
                    initQuXiaoPinglunDianZan(0,pinglun.getResult().getList().get(position),dianzannum,img_pinglun_dianzan);
                }else if (pinglun.getResult().getList().get(position).getIsPraise() == 0){
                    initPinglunDianZan(1,pinglun.getResult().getList().get(position),dianzannum,img_pinglun_dianzan);
                }
            }
        });

    }

    private void initPinglunDianZan(int i, PingLunGson.ResultBean.ListBean result, TextView dianzannum, ImageView img_pinglun_dianzan) {
        String num = dianzannum.getText().toString();
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("commentId",String.valueOf(result.getId()));
        map.put("commentMId",String.valueOf(result.getMember().getUserId()));
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
                                result.setIsPraise(1);
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

    private void initQuXiaoPinglunDianZan(int i,PingLunGson.ResultBean.ListBean result, TextView dianzannum, ImageView img_pinglun_dianzan) {
        String num = dianzannum.getText().toString();
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("commentId",String.valueOf(result.getId()));
        map.put("commentMId",String.valueOf(result.getMember().getUserId()));
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
                                result.setIsPraise(0);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_dianzan:
                if (!utils.isDoubleClick()){
                    if (!"".equals(token)){
                        if (detail.getResult().getIsPraise() == 0){
                            initDianZan("1");
                        }else{
                            initQuXiaoDianZan("0");
                        }
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                    }
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_gengduo:
                String[] caozuo;
                if (userid == MyApp.instance.getInt("id")){
                    caozuo = new String[]{"分享", "举报","删除"};
                }else{
                    caozuo= new String[]{"分享", "举报"};
                }
                new XPopup.Builder(WenZhangDetailActivity.this)
                        .hasShadowBg(false)
//                        .popupAnimation(PopupAnimation.NoAnimation) //NoAnimation表示禁用动画
//                        .isCenterHorizontal(true) //是否与目标水平居中对齐
                        .offsetY(-10)
                        .offsetX(80)
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
                                                web.setThumb(new UMImage(WenZhangDetailActivity.this, share.getResult().getPhoto()));  //网络缩略图
                                            } else {
                                                web.setThumb(new UMImage(WenZhangDetailActivity.this, R.mipmap.img_zhanweitu));  //本地缩略图
                                            }
                                            new ShareAction(WenZhangDetailActivity.this)
                                                    .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,
                                                    SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                                                    .withMedia(web)
                                                    .setCallback(WenZhangDetailActivity.this).open();
                                        }else if ("举报".equals(text)){
                                            intent.putExtra("dataId",String.valueOf(dId));
                                            intent.putExtra("username",detail.getResult().getMember().getNickName());
                                            intent.putExtra("photo",detail.getResult().getPicture());
                                            intent.putExtra("title",detail.getResult().getTitle());
                                            intent.setClass(WenZhangDetailActivity.this,JuBaoActivity.class);
                                            startActivity(intent);
                                        }else if ("删除".equals(text))
                                            SelectDialog.show(WenZhangDetailActivity.this, "提示", "是否删除该条圈子",
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


    //取消点赞
    private void initQuXiaoDianZan(String type) {
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
                                String num = tv_xihuan_num.getText().toString();
                                Integer integer = Integer.valueOf(num);
                                tv_xihuan_num.setText(String.valueOf(integer-1));
                                detail.getResult().setIsPraise(0);
                                img_xihuan.setImageResource(R.mipmap.img_xihuan);
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
        String num = tv_xihuan_num.getText().toString();
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
                                tv_xihuan_num.setText(String.valueOf(integer+1));
                                detail.getResult().setIsPraise(1);
                                img_xihuan.setImageResource(R.mipmap.img_xihuan2);
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
                                tv_guanzhu.setText("+关注");
                                detail.getResult().getMember().setIsAttention(0);
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
                                ToastUtils.showShort("评论成功");
                                initPingLun(detail.getResult());
                                edt_quanzi_pinglun.setText("");
                                initData();
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(WenZhangDetailActivity.this,"请稍后。。。");
                        super.onStart(request);
                    }
                });
    }

    //分享回调
    @Override
    public void onStart(SHARE_MEDIA share_media) {
    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {
        ToastUtils.showShort("分享成功");
    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {
        ToastUtils.showShort("取消分享");

    }
}
