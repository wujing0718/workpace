package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ChanPinCanShu;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.CanShuAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShopCanShuActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rec_chanpin_canshu;
    private String categoryName;
    private View bt_queding;
    private ArrayList<Object> list = new ArrayList<>();
    private ArrayList<Integer> typelist = new ArrayList<>();

    private List<String> keys;
    private Bundle bundle;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_can_shu);
        v = getWindow().peekDecorView();
        categoryName = getIntent().getStringExtra("categoryName");
        initUI();
        initData();
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"productManage/getProductAttributByCategory")
                .params("categoryName",categoryName)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        ChanPinCanShu canshu = new Gson().fromJson(body, ChanPinCanShu.class);
                        if (canshu.getStatus() == 1){
                            keys = canshu.getResult().getKeys();
                            initRec(canshu);
                        }
                    }
                });
    }

    private void initRec(ChanPinCanShu keys) {
        for (int i = 0; i < keys.getResult().getKeys().size(); i++) {
            list.add(i,"");
            typelist.add(keys.getResult().getType().get(i));
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rec_chanpin_canshu.setLayoutManager(layoutManager);
        CanShuAdapter canShuAdapter = new CanShuAdapter(keys,list,typelist,ShopCanShuActivity.this,v);
        rec_chanpin_canshu.setAdapter(canShuAdapter);
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        bt_queding = findViewById(R.id.bt_queding);
        bt_queding.setOnClickListener(this);
        rec_chanpin_canshu = findViewById(R.id.rec_chanpin_canshu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                bundle = new Bundle();
                bundle.putString("canshu",null);
                setResult(101,ShopCanShuActivity.this.getIntent().putExtras(bundle));
                ShopCanShuActivity.this.finish();
                break;
            case R.id.bt_queding:
                JSONArray jsonArray = new JSONArray();
                if (list.size() == keys.size()){
                    for (int j = 0; j < list.size(); j++) {
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("key",keys.get(j));
                            if (list.get(j).equals("是")){
                                jsonObject.put("value","1");
                            }else if (list.get(j).equals("否")){
                                jsonObject.put("value","0");
                            }else{
                                jsonObject.put("value",list.get(j));
                            }
                            jsonArray.put(jsonObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    bundle = new Bundle();
                    bundle.putString("canshu",jsonArray.toString());
                    setResult(102,ShopCanShuActivity.this.getIntent().putExtras(bundle));
                    ShopCanShuActivity.this.finish();
                }else{
                    ToastUtils.showShort("请输入参数");
                }
                break;
        }
    }
    @Override
    public void onBackPressed(){
        bundle = new Bundle();
        bundle.putString("canshu",null);
        setResult(101,ShopCanShuActivity.this.getIntent().putExtras(bundle));
        ShopCanShuActivity.this.finish();
        super.onBackPressed();
    }
}
