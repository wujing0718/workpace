package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.googlecode.mp4parser.authoring.Edit;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.Gson.OKGson;
import com.huohougongfu.app.Gson.PingJia;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.DianPuShopPingJiaAdapter;
import com.huohougongfu.app.WoDe.Adapter.DianPuShopPingJiaDetailAdapter;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopPingJiaDetailActivity extends AppCompatActivity {

    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_shop_pingjia_detail;
    private int shopid;
    private boolean ishuifu = true;
    private EditText edt_maijiahuifu;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_ping_jia_detail);
        shopid = getIntent().getIntExtra("shopid", 0);
        initUI();
        initData();
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("id",String.valueOf(shopid));
        map.put("page","1");
        map.put("pageSize","10");
        map.put("userId",String.valueOf(MyApp.instance.getInt("id")));
        OkGo.<String>get(Contacts.URl2+"/selectAppraise")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        PingJia shangPinGson = gson.fromJson(response.body(), PingJia.class);
                        if (shangPinGson.getStatus() == 1) {
                            initRec(shangPinGson.getResult().getList());
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);
                    }
                });
    }


    private void initRec(List<PingJia.ResultBean.ListBean> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(ShopPingJiaDetailActivity.this);
        rec_shop_pingjia_detail.setLayoutManager(layoutManager);
        DianPuShopPingJiaDetailAdapter dianPuShopPingJiaAdapter = new DianPuShopPingJiaDetailAdapter(R.layout.item_dianpu_pingjia, list,
                ShopPingJiaDetailActivity.this,shopid);
        rec_shop_pingjia_detail.setAdapter(dianPuShopPingJiaAdapter);
        dianPuShopPingJiaAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                pos = position;
                edt_maijiahuifu = (EditText)dianPuShopPingJiaAdapter.getViewByPosition(rec_shop_pingjia_detail, position, R.id.edt_maijiahuifu);
                if (ishuifu){
                    edt_maijiahuifu.setVisibility(View.VISIBLE);
                    ishuifu = false;
                }else{
                    edt_maijiahuifu.setVisibility(View.GONE);
                    ishuifu = true;
                }
                edt_maijiahuifu.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        InputMethodManager manager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                        if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                            //先隐藏键盘
                            if (manager.isActive()) {
                                manager.hideSoftInputFromWindow(edt_maijiahuifu.getApplicationWindowToken(), 0);
                            }
                            //自己需要的操作
                            initHuiFu(list.get(position));
                        }
                        //记得返回false
                        return false;
                    }
                });

            }

        });

    }
    private void initHuiFu(PingJia.ResultBean.ListBean item) {
        if (!edt_maijiahuifu.getText().toString().isEmpty()){
            Map<String,String> map = new HashMap<>();
            map.put("productId",String.valueOf(shopid));
            map.put("appraiseId",String.valueOf(item.getId()));
            map.put("answerId",String.valueOf(MyApp.instance.getInt("id")));
            map.put("content",edt_maijiahuifu.getText().toString());
            OkGo.<String>post(Contacts.URl1+"/createAnswerAppraiseOnlySeller")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            Gson gson = new Gson();
                            OKGson okGson = gson.fromJson(body, OKGson.class);
                            if (okGson.getStatus() == 1){
                                edt_maijiahuifu.setText("");
                                edt_maijiahuifu.setVisibility(View.GONE);
                            }
                        }
                    });
        }else{
            ToastUtils.showShort("请输入回复内容");
        }

    }

    private void initUI() {
        rec_shop_pingjia_detail = findViewById(R.id.rec_shop_pingjia_detail);
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
