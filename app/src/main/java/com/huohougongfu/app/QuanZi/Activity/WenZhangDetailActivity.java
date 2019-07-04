package com.huohougongfu.app.QuanZi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huohougongfu.app.Activity.FaBuArticleActivity;
import com.huohougongfu.app.Gson.GuanZhu;
import com.huohougongfu.app.Gson.PingLunGson;
import com.huohougongfu.app.Gson.QuanZiDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.PingLunAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WenZhangDetailActivity extends AppCompatActivity implements View.OnClickListener {

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
    private List<Integer> guanzhuId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wen_zhang_detail);
        dId = getIntent().getIntExtra("dId", 0);
        mId = MyApp.instance.getInt("id");
        intent = new Intent();
        initUI();
        initPingLun();
    }

    private void initISGuanZhu(int userId) {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("attentionId",String.valueOf(userId));
        OkGo.<String>post(Contacts.URl1+"/circle/attention/list")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        GuanZhu guanZhu = gson.fromJson(body, GuanZhu.class);
                        if (guanZhu.getStatus() == 1){
                            if (guanZhu.getResult().size()>0){
                                guanzhuId = guanZhu.getResult();
                                tv_guanzhu.setBackgroundResource(R.drawable.yiguanzhu);
                                tv_guanzhu.setText("已关注");
                                tv_guanzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorWhite));
                            }else{
                            }
                        }
                    }
                });
    }

    private void initUI() {
        img_quanzi_touxiang = findViewById(R.id.img_quanzi_touxiang);
        tv_guanzhu = findViewById(R.id.tv_guanzhu);
        view_wenzhang = findViewById(R.id.view_wenzhang);
        tv_quanzi_name = findViewById(R.id.tv_quanzi_name);
        tv_quanzi_chenghu = findViewById(R.id.tv_quanzi_chenghu);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_guanzhu).setOnClickListener(this);
        bt_gengduo = findViewById(R.id.bt_gengduo);
        bt_gengduo.setOnClickListener(this);
        edt_quanzi_pinglun = findViewById(R.id.edt_quanzi_pinglun);
        findViewById(R.id.bt_fasong_pinglun).setOnClickListener(this);
    }

    private void initData() {
        Map<String ,String> map = new HashMap<>();
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
                            initISGuanZhu(detail.getResult().getMember().getUserId());
//                            if (detail.getResult().getIsPraise() == 1){
//                                img_shoucang.setImageResource(R.mipmap.img_xihuan2);
//                            }else{
//                                img_shoucang.setImageResource(R.mipmap.img_xihuan);
//                            }
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(WenZhangDetailActivity.this,"载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initPingLun() {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(dId));
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
                            initData();
                            pinglun = pinglun1;
                        }
                    }
                });

    }

    private void initView(QuanZiDetail.ResultBean result) {
        String content = result.getContent();
        String picture = result.getPicture();
        String[] split1 = picture.split(",");
        String[] mcontent = content.split(",,");
        int temp = 0;
            for (int i = 0;i<mcontent.length;i++){
                if ("@&$".equals(mcontent[i])){
                    ImageView imageView = new ImageView(WenZhangDetailActivity.this);
                    Glide.with(WenZhangDetailActivity.this).load(split1[temp]).into(imageView);
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
        PingLunAdapter pingLunAdapter = new PingLunAdapter(R.layout.item_quanzi_pinglun, pinglun.getResult().getList());
        rec_wenzhang_pinglun.setAdapter(pingLunAdapter);
        view_wenzhang.addView(rec_wenzhang_pinglun);
        tv_quanzi_name.setText(result.getMember().getNickName());
        Glide.with(WenZhangDetailActivity.this).load(result.getMember().getPhoto()).into(img_quanzi_touxiang);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_gengduo:
                new XPopup.Builder(WenZhangDetailActivity.this)
                        .hasShadowBg(false)
//                        .popupAnimation(PopupAnimation.NoAnimation) //NoAnimation表示禁用动画
//                        .isCenterHorizontal(true) //是否与目标水平居中对齐
                        .offsetY(-10)
                        .offsetX(80)
                        .popupPosition(PopupPosition.Left) //手动指定弹窗的位置
                        .atView(bt_gengduo)  // 依附于所点击的View，内部会自动判断在上方或者下方显示
                        .asAttachList(new String[]{"分享", "举报"},
                                new int[]{},
                                new OnSelectListener() {
                                    @Override
                                    public void onSelect(int position, String text) {
                                        if ("分享".equals(text)){

                                        }else if ("举报".equals(text)){
                                            intent.putExtra("dataId",String.valueOf(dId));
                                            intent.putExtra("username",detail.getResult().getMember().getNickName());
                                            intent.putExtra("photo",detail.getResult().getPicture());
                                            intent.putExtra("title",detail.getResult().getTitle());
                                            intent.setClass(WenZhangDetailActivity.this,JuBaoActivity.class);
                                            startActivity(intent);
                                        }
                                    }
                                })
                        .show();
                break;
            case R.id.bt_fasong_pinglun:
                String pinglun_content = edt_quanzi_pinglun.getText().toString();
                if (!utils.isDoubleClick()){
                    if (!pinglun_content.isEmpty()){
                        initFaSongPingLun(pinglun_content);
                    }else{
                        ToastUtils.showShort("请输入评论内容");
                    }
                }
                break;
            case R.id.bt_guanzhu:
                if (!utils.isDoubleClick()){
                    if (guanzhuId.size()>0){
                        initNoGuanZhu(0);
                    }else{
                        initGuanZhu(1);
                    }
                }
                break;
        }
    }

    private void initGuanZhu(int type) {
        int userId = detail.getResult().getMember().getUserId();
        Map<String,String> map =new HashMap<>();
        map.put("mId",String.valueOf(mId));
        map.put("attentionId",String.valueOf(userId));
        map.put("type",String.valueOf(type));
        OkGo.<String>post(Contacts.URl1+"/circle/attention")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            if (jsonObject.getInt("status") == 1){
                                guanzhuId.add(0);
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
                                guanzhuId.clear();
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
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

}
