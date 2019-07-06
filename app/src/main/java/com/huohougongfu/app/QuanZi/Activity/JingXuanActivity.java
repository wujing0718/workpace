package com.huohougongfu.app.QuanZi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.JingXuanRen;
import com.huohougongfu.app.Gson.MyCaQuan;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.Gson.ZhaoRenGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.JingXuanAdapter;
import com.huohougongfu.app.QuanZi.Adapter.JingXuanRenAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.MyKaQuanAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JingXuanActivity extends AppCompatActivity {

    private RecyclerView rec_jingxuan_wenzhang,rec_tuijianyonghu;
    private String token,tel,mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jing_xuan);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        mId = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        initData();
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("pageNo","1");
        map.put("pageSize","10");
        map.put("isSift","1");
        map.put("mId",mId);
        map.put("type","2");
        map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/data")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        QuanZiFaXian faxian = gson.fromJson(response.body(), QuanZiFaXian.class);
                        if (faxian.getStatus() == 1) {
                            initRec(faxian);
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(JingXuanActivity.this, "载入中...");
                        super.onStart(request);
                    }
                });
        map.remove("isSift");
        map.remove("type");
        OkGo.<String>post(Contacts.URl1+"/circle/findPeople")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        JingXuanRen jingxuanren = gson.fromJson(response.body(), JingXuanRen.class);
                        if (jingxuanren.getStatus() == 1) {
                            initRecRen(jingxuanren.getResult().getList());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(JingXuanActivity.this, "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRecRen(List<JingXuanRen.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        //设置RecyclerView 布局
        rec_tuijianyonghu.setLayoutManager(layoutmanager);
        JingXuanRenAdapter jingXuanRenAdapter = new JingXuanRenAdapter(R.layout.item_quanzi_zhaoren,list);
        rec_tuijianyonghu.setAdapter(jingXuanRenAdapter);
        jingXuanRenAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_zhaoren_gaunzhu = view.findViewById(R.id.bt_zhaoren_gaunzhu);
                if (!utils.isDoubleClick()){
                    if (list.get(position).getIsAttention() == 1){
                        initNoGuanZhu(0,list.get(position),bt_zhaoren_gaunzhu);
                    }else if (list.get(position).getIsAttention() == 0){
                        initGuanZhu(1,list.get(position),bt_zhaoren_gaunzhu);
                    }
                }
            }
        });
    }

    private void initGuanZhu(int type, JingXuanRen.ResultBean.ListBean listBean, TextView bt_zhaoren_gaunzhu) {
        int userId = listBean.getUserId();
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
                                listBean.setIsAttention(1);
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                bt_zhaoren_gaunzhu.setBackgroundResource(R.drawable.yiguanzhu);
                                bt_zhaoren_gaunzhu.setText("已关注");
                                bt_zhaoren_gaunzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorWhite));
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initNoGuanZhu(int type, JingXuanRen.ResultBean.ListBean listBean, TextView bt_zhaoren_gaunzhu) {
        int userId = listBean.getUserId();
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
                                listBean.setIsAttention(0);
                                bt_zhaoren_gaunzhu.setText("+关注");
                                bt_zhaoren_gaunzhu.setBackgroundResource(R.drawable.guanzhu);
                                bt_zhaoren_gaunzhu.setTextColor(getApplicationContext().getResources().getColor(R.color.black));
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private void initRec(QuanZiFaXian faxian) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置RecyclerView 布局
        rec_jingxuan_wenzhang.setLayoutManager(layoutmanager);
        JingXuanAdapter wodeadapter = new JingXuanAdapter(R.layout.item_quanzi_jingxuanwenzhang,faxian.getResult().getDatas().getList());
        rec_jingxuan_wenzhang.setAdapter(wodeadapter);
        wodeadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("dId",faxian.getResult().getDatas().getList().get(position).getId());
                startActivity(intent.setClass(JingXuanActivity.this,WenZhangDetailActivity.class));
            }
        });
    }

//    private void initRecWoDe(List<MyCaQuan.ResultBean> result) {
//        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
//        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
//        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        //设置RecyclerView 布局
//        rec_jingxuan_wenzhang.setLayoutManager(layoutmanager);
//        JingXuanAdapter wodeadapter = new JingXuanAdapter(R.layout.item_quanzi_jingxuanwenzhang,result);
//        rec_jingxuan_wenzhang.setAdapter(wodeadapter);
//    }
    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
         rec_jingxuan_wenzhang = findViewById(R.id.rec_jingxuan_wenzhang);
         rec_tuijianyonghu = findViewById(R.id.rec_tuijianyonghu);
    }
}
