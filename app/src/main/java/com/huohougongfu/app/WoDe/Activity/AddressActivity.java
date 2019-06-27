package com.huohougongfu.app.WoDe.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.AddRess;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.AddRessAdapter;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class AddressActivity extends AppCompatActivity {

    private RecyclerView rec_shouhuodizhi;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        id = MyApp.instance.getInt("id");
        findViewById(R.id.bt_add_dizhi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AddressActivity.this,AddRegionActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        initData();
        super.onResume();
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"/receiveAddress/findAll/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        Gson gson = new Gson();
                        AddRess addRess = gson.fromJson(body, AddRess.class);
                        if (addRess.getStatus() == 1){
                            initRec(addRess.getResult());
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(AddressActivity.this, "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(List<AddRess.ResultBean> result) {
         rec_shouhuodizhi = findViewById(R.id.rec_shouhuodizhi);
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        rec_shouhuodizhi.setLayoutManager(layoutmanager);
        AddRessAdapter addRessAdapter = new AddRessAdapter(R.layout.item_address, result);
        rec_shouhuodizhi.setAdapter(addRessAdapter);
        addRessAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.bt_bianji_address:
                        AddRess.ResultBean resultBean = result.get(position);
                        Intent intent = new Intent();
                        intent.putExtra("地址",resultBean);
                        intent.setClass(AddressActivity.this,AddRegionActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        addRessAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                SelectDialog.show(AddressActivity.this, "提示", "是否删除收货地址",
                        "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                initDelete(result.get(position).getId());
                            }
                        },
                        "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                return false;
            }
        });
    }

    private void initDelete(int id) {
        OkGo.<String>get(Contacts.URl1+"/receiveAddress/delete/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort("删除成功");
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

}
