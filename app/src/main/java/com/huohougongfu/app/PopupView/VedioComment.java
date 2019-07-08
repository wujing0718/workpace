package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.PingLunGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.PingLunAdapter;
import com.huohougongfu.app.QuanZi.Adapter.VedioCommentAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VedioComment extends BottomPopupView {
    private final int mId,dId;
    private final String token;
    private Context context;
    private List<PingLunGson.ResultBean.ListBean> list;
    private EditText edt_vedio_pinglun;
    private PingLunAdapter pingLunAdapter;
    private RecyclerView rec_vedio_comment;
    private Button bt_fasong_pinglun;


    public VedioComment(@NonNull Context context, int dId) {
        super(context);
        this.context = context;
        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        this.dId= dId;

    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.vedio_comment;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        bt_fasong_pinglun = findViewById(R.id.bt_fasong_pinglun);
        rec_vedio_comment = findViewById(R.id.rec_vedio_comment);
        edt_vedio_pinglun = findViewById(R.id.edt_vedio_pinglun);
        initPingLun();
    }

    private void initPingLun() {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(dId));
        map.put("pageNo","1");
        map.put("pageSize","10");
        OkGo.<String>post(Contacts.URl1 + "/circle/comments/list")
                .params(map)
                .execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                WaitDialog.dismiss();
                String body = response.body();
                Gson gson = new Gson();
                PingLunGson pinglun1 = gson.fromJson(body, PingLunGson.class);
                if (pinglun1.getStatus() == 1) {
                    initRec(pinglun1.getResult().getList());
                }
            }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        WaitDialog.show(context,"加载中。。。");
                    }
                });

    }

    private void initRec(List<PingLunGson.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(context);
        //设置RecyclerView 布局
        rec_vedio_comment.setLayoutManager(layoutmanager);
        pingLunAdapter = new PingLunAdapter(R.layout.item_quanzi_pinglun,list);
        rec_vedio_comment.setAdapter(pingLunAdapter);
        bt_fasong_pinglun.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                initFaSongPingLun();
            }
        });
    }

    private void initFaSongPingLun() {
        String pinglun_content = edt_vedio_pinglun.getText().toString();
        if (!utils.isDoubleClick()){
            if (!pinglun_content.isEmpty()){
                initFaSongPingLun(pinglun_content);
            }else{
                ToastUtils.showShort("请输入评论内容");
            }
        }
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
                                edt_vedio_pinglun.setText("");
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
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext()) * .65f);
    }
}
