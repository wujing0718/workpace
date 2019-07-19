package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ZhaoRenGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Adapter.ZhaoRenAdapter;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WoDeFenSiActivity extends AppCompatActivity {

    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_wodefensi;
    private ZhaoRenAdapter zhaorendadapter;
    private String token;
    private String mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo_de_fen_si);
        token = MyApp.instance.getString("token");
        mId = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
        initData();
    }

    private void initData() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",mId);
        map.put("pageNo","1");
        map.put("pageSize","10");
        OkGo.<String>post(Contacts.URl1+"/my/fan")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ZhaoRenGson fensi = gson.fromJson(body, ZhaoRenGson.class);
                        if (fensi.getStatus() == 1){
                            if (fensi.getResult().getList().size()>0){
                                initRec(fensi.getResult().getList());
                            }
                        }
                    }
                });
    }

    private void initRec(List<ZhaoRenGson.ResultBean.ListBean> list) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_wodefensi.setLayoutManager(layoutmanager);
        zhaorendadapter = new ZhaoRenAdapter(R.layout.item_quanzi_zhaoren,list);
        rec_wodefensi.setAdapter(zhaorendadapter);
        zhaorendadapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView bt_zhaoren_gaunzhu = view.findViewById(R.id.bt_zhaoren_gaunzhu);
                if (!utils.isDoubleClick()){
                    if (!"".equals(token)){
                        if (list.get(position).getIsAttention() == 1){
                            initNoGuanZhu(0,list.get(position),bt_zhaoren_gaunzhu);
                        }else if (list.get(position).getIsAttention() == 0){
                            initGuanZhu(1,list.get(position),bt_zhaoren_gaunzhu);
                        }
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                    }
                }
            }
        });
    }

    private void initGuanZhu(int type, ZhaoRenGson.ResultBean.ListBean listBean, TextView bt_zhaoren_gaunzhu) {
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

    private void initNoGuanZhu(int type, ZhaoRenGson.ResultBean.ListBean listBean, TextView bt_zhaoren_gaunzhu) {
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

    private void initUI() {
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        rec_wodefensi = findViewById(R.id.rec_wodefensi);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
