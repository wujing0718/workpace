package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.YunFeiZiDingYiAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YunFeiSettingActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean Isjichu;
    private boolean Ismanjian;
    private boolean Iszidingyi;

    private ImageView img_check_zidingyi,img_check_jichuyoufei,img_check_manjianbaoyou;
    private RecyclerView rec_zidingyi_youfei;
    private ArrayList<String> list;
    private ArrayList<String> mlist;

    private YunFeiZiDingYiAdapter adapter;
    private Handler mHandler =new Handler();
    private ArrayList<String> dizhi = new ArrayList<>();
    private View bt_queding;
    private EditText edt_jichu_yunfei,edt_manjian_baoyou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yun_fei_setting);
        initUI();
        initRecycle();
    }

    private void initRecycle() {
        //  纵向滑动
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rec_zidingyi_youfei.setLayoutManager(linearLayoutManager);
//      获取数据，向适配器传数据，绑定适配器
        list = initData();
        mlist = initYouFei();
        adapter = new YunFeiZiDingYiAdapter(list,mlist);
        rec_zidingyi_youfei.setAdapter(adapter);
        adapter.setOnCountListener(new YunFeiZiDingYiAdapter.OnCountListener() {
            @Override
            public void onChangeCount(int i) {
                Intent intent = new Intent();
                intent.putExtra("position",i);
                intent.setClass(MyApp.context,DiQuXuanZeActivity.class);
                startActivityForResult(intent,1);
            }
        });

    }

    private void initUI() {
        edt_jichu_yunfei = findViewById(R.id.edt_jichu_yunfei);
        edt_manjian_baoyou = findViewById(R.id.edt_manjian_baoyou);
        rec_zidingyi_youfei = findViewById(R.id.rec_zidingyi_youfei);
        img_check_zidingyi = findViewById(R.id.img_check_zidingyi);
        img_check_jichuyoufei = findViewById(R.id.img_check_jichuyoufei);
        img_check_manjianbaoyou = findViewById(R.id.img_check_manjianbaoyou);
        bt_queding = findViewById(R.id.bt_queding);
        bt_queding.setOnClickListener(this);
        findViewById(R.id.bt_jichuyunfei).setOnClickListener(this);
        findViewById(R.id.bt_manjianbaoyou).setOnClickListener(this);
        findViewById(R.id.bt_zidingyi).setOnClickListener(this);
        findViewById(R.id.bt_tianjia_zidingyi).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            Bundle extras = data.getExtras();
            if (extras!=null){
                ArrayList<String> dizhi = (ArrayList<String>) extras.getSerializable("地址");
                int position = extras.getInt("position");
                if (dizhi!=null){
                    adapter.setData(position,dizhi);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_jichuyunfei:
                if (Isjichu){
                    img_check_jichuyoufei.setImageResource(R.mipmap.unselect);
                    Isjichu = false;
                }else{
                    img_check_jichuyoufei.setImageResource(R.mipmap.select);
                    Isjichu = true;
                }
                break;
            case R.id.bt_manjianbaoyou:
                if (Ismanjian){
                    img_check_manjianbaoyou.setImageResource(R.mipmap.unselect);
                    Ismanjian = false;
                }else{
                    img_check_manjianbaoyou.setImageResource(R.mipmap.select);
                    Ismanjian = true;

                }
                break;
            case R.id.bt_zidingyi:
                if (Iszidingyi){
                    img_check_zidingyi.setImageResource(R.mipmap.unselect);
                    Iszidingyi = false;
                }else{
                    img_check_zidingyi.setImageResource(R.mipmap.select);
                    Iszidingyi = true;
                }
                break;
            case R.id.bt_tianjia_zidingyi:
                    initAdd();
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_queding:
                List<String>  customSettings = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if (!"".equals(list.get(i))){
                        if (!"".equals(mlist.get(i))){
                            customSettings.add(list.get(i)+"~"+mlist.get(i));
                        }else{
                            ToastUtils.showShort("请输入金额");
                        }
                    }else{
                        ToastUtils.showShort("请选择地区");
                    }
                }
                initQueDing(customSettings);
                break;
        }
    }

    private void initQueDing(List<String> customSettings) {
        Map<String,String> map = new HashMap<>();
        String yunfei = edt_jichu_yunfei.getText().toString();
        String manjian = edt_manjian_baoyou.getText().toString();
        if (!yunfei.isEmpty()){
            if (!manjian.isEmpty()){
                map.put("basicExpressFee",yunfei);
                map.put("freeAmountOfExpressFee",manjian);
                map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
                OkGo.<String>post(Contacts.URl1+"/store/deliveryFeeSetting")
                        .tag(this)
                        .isMultipart(true)
                        .params(map)
                        .addUrlParams("customSettings",customSettings)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                String body = response.body();
                                try {
                                    JSONObject jsonObject = new JSONObject(body);
                                    if (jsonObject.getInt("status")==1){
                                        finish();
                                        ToastUtils.showShort("设置成功");
                                    }else{
                                        ToastUtils.showShort(jsonObject.getString("msg"));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }else{
                ToastUtils.showShort("满减包邮不能为空");
            }
        }else{
            ToastUtils.showShort("满减运费不能为空");
        }
    }

    private void initAdd() {
        adapter.addData(list.size());
        adapter.addYouFei(mlist.size());
    }

    protected ArrayList<String> initData() {
        ArrayList<String> mDatas = new ArrayList<String>();
        for (int i = 0; i < 1; i++) {
            mDatas.add("");
        }
        return mDatas;
    }
    protected ArrayList<String> initYouFei() {
        ArrayList<String> mYouFeiData = new ArrayList<String>();
        for (int i = 0; i < 1; i++) {
            mYouFeiData.add("");
        }
        return mYouFeiData;
    }
}
