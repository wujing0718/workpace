package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.PingLunGson;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.VedioDetailActivity;
import com.huohougongfu.app.QuanZi.Adapter.PingLunAdapter;
import com.huohougongfu.app.QuanZi.Adapter.VedioCommentAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class VedioComment extends BottomPopupView implements IListener{
    private final int dId;
    private final Handler mHandler;
    private Context context;
    private EditText edt_vedio_pinglun;
    private PingLunAdapter pingLunAdapter;
    private RecyclerView rec_vedio_comment;
    private Button bt_fasong_pinglun;
    private SmartRefreshLayout smartrefreshlayout;
    private int page = 2;



    public VedioComment(@NonNull Context context, int dId, Handler mHandler) {
        super(context);
        this.context = context;
        this.context = context;
        this.dId = dId;
        this.mHandler = mHandler;

    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.vedio_comment;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        ListenerManager.getInstance().registerListtener(this);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        bt_fasong_pinglun = findViewById(R.id.bt_fasong_pinglun);
        rec_vedio_comment = findViewById(R.id.rec_vedio_comment);
        edt_vedio_pinglun = findViewById(R.id.edt_vedio_pinglun);
        initData();
    }


    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(dId));
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("pageNo","1");
        map.put("pageSize","10");
        OkGo.<String>post(Contacts.URl1 + "/circle/comments/list")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        smartrefreshlayout.finishRefresh();
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        PingLunGson pinglun1 = gson.fromJson(body, PingLunGson.class);
                        if (pinglun1.getStatus() == 1) {
                            initRec(pinglun1.getResult());
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        WaitDialog.dismiss();
                        super.onError(response);
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        WaitDialog.show(context,"加载中。。。");
                    }
                });
    }


    private void initRec(PingLunGson.ResultBean result) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(context);
        //设置RecyclerView 布局
        rec_vedio_comment.setLayoutManager(layoutmanager);
        pingLunAdapter = new PingLunAdapter(R.layout.item_quanzi_pinglun,result.getList());
        rec_vedio_comment.setAdapter(pingLunAdapter);
        bt_fasong_pinglun.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                initFaSongPingLun();
            }
        });
        pingLunAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ImageView img_pinglun_dianzan = view.findViewById(R.id.img_pinglun_dianzan);
                TextView tv_pinglun_dianzannum = view.findViewById(R.id.tv_pinglun_dianzannum);
                if (!utils.isDoubleClick()){
                        if (result.getList().get(position).getIsPraise() == 1){
                            initQuXiaoDianZan("0",img_pinglun_dianzan,tv_pinglun_dianzannum,result.getList().get(position));
                        }else{
                            initDianZan("1",img_pinglun_dianzan,tv_pinglun_dianzannum,result.getList().get(position));
                        }
                }
            }
        });

        //刷新
        smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 2;
                initData();
                smartrefreshlayout.finishRefresh(true);//传入false表示刷新失败
            }
        });
        //加载更多
        smartrefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                initAdd();
            }
        });
    }

    private void initAdd() {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(dId));
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("pageNo",String.valueOf(page++));
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
                            if (pinglun1.getResult().getList().size()>0){
                                pingLunAdapter.add(pinglun1.getResult().getList());
                                smartrefreshlayout.finishLoadmore(true);//传入false表示刷新失败
                            }else{
                                smartrefreshlayout. finishLoadMore();
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        WaitDialog.dismiss();
                        super.onError(response);
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                        WaitDialog.show(context,"加载中。。。");
                    }
                });
    }

    //取消点赞
    private void initQuXiaoDianZan(String type, ImageView img_pinglun_dianzan, TextView tv_pinglun_dianzannum, PingLunGson.ResultBean.ListBean id) {
        Map<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("commentId",String.valueOf(id.getId()));
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("commentMId",String.valueOf(id.getMid()));
        OkGo.<String>post(Contacts.URl1+"/circle/comment/praise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                String num = tv_pinglun_dianzannum.getText().toString();
                                Integer integer = Integer.valueOf(num);
                                tv_pinglun_dianzannum.setText(String.valueOf(integer-1));
                                id.setIsPraise(0);
                                img_pinglun_dianzan.setImageResource(R.mipmap.img_dianzan);
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
    private void initDianZan(String type, ImageView img_pinglun_dianzan, TextView tv_pinglun_dianzannum, PingLunGson.ResultBean.ListBean id) {
        String num = tv_pinglun_dianzannum.getText().toString();
        Map<String,String> map = new HashMap<>();
        map.put("type",type);
        map.put("commentId",String.valueOf(id.getId()));
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("commentMId",String.valueOf(id.getMid()));
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
                                tv_pinglun_dianzannum.setText(String.valueOf(integer+1));
                                id.setIsPraise(1);
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
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
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
                                ToastUtils.showShort("评论成功");
                                hideInput();
                                ListenerManager.getInstance().sendBroadCast(30,"是");
                                edt_vedio_pinglun.setText("");
                                Message msg = Message.obtain();
                                msg.what = 0;
                                msg.obj = true;
                                mHandler.sendMessage(msg);
                                dismiss();
                            }else{
                                Message msg = Message.obtain();
                                msg.what = 0;
                                msg.obj = false;
                                mHandler.sendMessage(msg);
                                dismiss();
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });


    }

    /**
     * 隐藏键盘
     */
    protected void hideInput() {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        View v = VedioDetailActivity.activity.getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }


    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext()) * .65f);
    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {

    }
}
