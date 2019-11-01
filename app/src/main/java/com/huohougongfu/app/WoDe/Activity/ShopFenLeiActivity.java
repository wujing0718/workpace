package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.ShopFenLeiGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Adapter.LevelListViewAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ShopFenLeiActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lv_country;
    private ListView lv_province;
    private ListView lv_city;

    private ArrayList<String> countryValues=new ArrayList<String>();
    private ArrayList<String> provinceValues=new ArrayList<String>();
    private ArrayList<String> cityValues=new ArrayList<String>();

    private ArrayList<String> countryValuesid=new ArrayList<String>();
    private ArrayList<String> provinceValuesid=new ArrayList<String>();
    private ArrayList<String> cityValuesid=new ArrayList<String>();

    private int countryPosition=0;
    private int provincePosition=0;
    private int cityPosition=0;

    private int countryNumber=-1;
    private int provinceNumber=-1;

    private long countryTime=0;
    private long provinceTime=0;
    private List<ShopFenLeiGson.ResultBean> result;
    private LevelListViewAdapter cityAdapter;
    private LevelListViewAdapter provinceAdapter;
    private LevelListViewAdapter countryAdapter;
    private ShopFenLeiGson shopFenLeiGson;
    private int position1;
    private Bundle bundle;
    private String categoryName ,categoryNameid,Nameid;
    private View view_zhanweitu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_fen_lei);
        initUI();
        initData();
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"productManage/getSubCategoryByParentName")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        shopFenLeiGson = gson.fromJson(body, ShopFenLeiGson.class);
                        if (shopFenLeiGson.getStatus() == 1){
                            for (int i = 0; i < shopFenLeiGson.getResult().size(); i++) {
                                countryValues.add(shopFenLeiGson.getResult().get(i).getName());
                                countryValuesid.add(String.valueOf(shopFenLeiGson.getResult().get(i).getId()));
                            }
                            setCountry();
                            setProvince();
                            setCity();
                        }
                    }
                });
    }

    private void initUI() {
        view_zhanweitu = findViewById(R.id.view_zhanweitu);
        findViewById(R.id.bt_queding).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        lv_country = findViewById(R.id.lv_country);
        lv_province = findViewById(R.id.lv_province);
        lv_city = findViewById(R.id.lv_city);
    }

    private void setCity() {
        for (int i = 0; i < shopFenLeiGson.getResult().get(countryPosition).getList().get(provincePosition).getList().size(); i++) {
            cityValues.add(shopFenLeiGson.getResult().get(countryPosition).getList().get(provincePosition).getList().get(i).getName());
            cityValuesid.add(String.valueOf(shopFenLeiGson.getResult().get(countryPosition).getList().get(provincePosition).getList().get(i).getId()));
        }
        categoryName = shopFenLeiGson.getResult().get(countryPosition).getList().get(provincePosition).getList().get(0).getName();
        categoryNameid= String.valueOf(shopFenLeiGson.getResult().get(countryPosition).getList().get(provincePosition).getList().get(0).getId());
        if(!(cityValues.isEmpty())){
            lv_city.setVisibility(View.VISIBLE);
            view_zhanweitu.setVisibility(View.GONE);
            cityAdapter=new LevelListViewAdapter(this, cityValues, 3);
            cityAdapter.setSelectedPositionNoNotify(0, cityValues);
            lv_city.setAdapter(cityAdapter);
            cityAdapter.setOnItemClickListener(new LevelListViewAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    categoryName = cityValues.get(position);
                    categoryNameid = cityValuesid.get(position);
                    cityAdapter.setSelectItem(position);
                    cityPosition = position;
                }
            });
        }else{
            view_zhanweitu.setVisibility(View.VISIBLE);
            lv_city.setVisibility(View.GONE);
        }
    }

    private void setProvince() {
            for (int i = 0; i < shopFenLeiGson.getResult().get(countryPosition).getList().size(); i++) {
                provinceValues.add(shopFenLeiGson.getResult().get(countryPosition).getList().get(i).getName());
                provinceValuesid.add(String.valueOf(shopFenLeiGson.getResult().get(countryPosition).getList().get(i).getId()));
            }
        if(!(provinceValues.isEmpty())){
            provinceAdapter=new LevelListViewAdapter(this, provinceValues, 2);
            provinceAdapter.setSelectedPositionNoNotify(0, provinceValues);
            lv_province.setAdapter(provinceAdapter);
            provinceAdapter.setOnItemClickListener(new LevelListViewAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    provincePosition = position;
                    provinceAdapter.setSelectItem(position);
//                    if(provinceNumber!=position){//记录不是当前点击的
//                        provinceNumber=position;//就记录当前条目
//                        provinceTime=System.currentTimeMillis();//并记录第一次时间戳
//                        Timer timer=new Timer();
//                        timer.schedule(new TimerTask() {
//                            @Override
//                            public void run() {
//                                provinceNumber=-1;
//                                provinceTime=0;
//                            }
//                        }, 300);
//                    }else{//记录的是当前点击的
//                        long num = System.currentTimeMillis()-provinceTime;//判断时间差，是不是双击
//                        if(num<=300){//时间差200毫秒内
////                            ToastUtil.showToast(MainActivity.this, provinceValues.get(position).getPlacename());
//                        }
//                        provinceNumber=-1;//重置过的记录
//                        provinceTime=0;//重置时间的记录
//                    }
                    cityValues.clear();
                    cityValuesid.clear();
                    if(!(provinceValues.isEmpty())){
                        for (int i = 0; i < shopFenLeiGson.getResult().get(countryPosition).getList().get(position).getList().size(); i++) {
                            cityValues.add(shopFenLeiGson.getResult().get(countryPosition).getList().get(position).getList().get(i).getName());
                            cityValuesid.add(String.valueOf(shopFenLeiGson.getResult().get(countryPosition).getList().get(position).getList().get(i).getId()));
                        }
                        if (!cityValues.isEmpty()){
                            view_zhanweitu.setVisibility(View.GONE);
                            lv_city.setVisibility(View.VISIBLE);
                        }else{
                            view_zhanweitu.setVisibility(View.VISIBLE);
                            lv_city.setVisibility(View.GONE);
                        }
                        cityAdapter.notifyDataSetChanged();
                        cityAdapter.setSelectedPositionNoNotify(0, cityValues);
                        lv_city.smoothScrollToPosition(0);
                    }else{
                        cityAdapter.notifyDataSetChanged();
                    }
                }
            });}
    }

    private void setCountry() {
        if(!(countryValues.isEmpty())){
            countryAdapter=new LevelListViewAdapter(this, countryValues,1);
            countryAdapter.setSelectedPositionNoNotify(0, countryValues);
            lv_country.setAdapter(countryAdapter);
            countryAdapter.setOnItemClickListener(new LevelListViewAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    countryPosition = position;
                    countryAdapter.setSelectItem(position);
                    provinceAdapter.setSelectItem(0);
//                    if(countryNumber!=position){//记录不是当前点击的
//                        countryNumber=position;//就记录当前条目
//                        countryTime=System.currentTimeMillis();//并记录第一次时间戳
//                        Timer timer=new Timer();
//                        timer.schedule(new TimerTask() {
//                            @Override
//                            public void run() {
//                                countryNumber=-1;
//                                countryTime=0;
//                            }
//                        }, 300);
//                    }else{//记录的是当前点击的
//                        long num = System.currentTimeMillis()-countryTime;//判断时间差，是不是双击
//                        if(num<=300){//时间差200毫秒内
//                        }
//                        countryNumber=-1;//重置过的记录
//                        countryTime=0;//重置时间的记录
//                    }
                    provinceValues.clear();
                    provinceValuesid.clear();
                    if(!(countryValues.isEmpty())){
                        for (int i = 0; i < shopFenLeiGson.getResult().get(position).getList().size(); i++) {
                            provinceValues.add(shopFenLeiGson.getResult().get(position).getList().get(i).getName());
                            provinceValuesid.add(String.valueOf(shopFenLeiGson.getResult().get(position).getList().get(i).getId()));
                        }
                        provinceAdapter.notifyDataSetChanged();
                        provinceAdapter.setSelectedPositionNoNotify(0, provinceValues);
                        lv_province.smoothScrollToPosition(0);
                    }else{
                        provinceAdapter.notifyDataSetChanged();
                    }
                    cityValues.clear();
                    cityValuesid.clear();
                    if(!(provinceValues.isEmpty())){
                        for (int i = 0; i < shopFenLeiGson.getResult().get(position).getList().get(0).getList().size(); i++) {
                                cityValues.add(shopFenLeiGson.getResult().get(position).getList().get(0).getList().get(i).getName());
                                cityValuesid.add(String.valueOf(shopFenLeiGson.getResult().get(position).getList().get(0).getList().get(i).getId()));
                        }
                        if (!cityValues.isEmpty()){
                            view_zhanweitu.setVisibility(View.GONE);
                            lv_city.setVisibility(View.VISIBLE);
                        }else{
                            view_zhanweitu.setVisibility(View.VISIBLE);
                            lv_city.setVisibility(View.GONE);
                        }
//                            categoryName = cityValues.get(0);
//                            categoryNameid  = cityValuesid.get(0);
                        cityAdapter.notifyDataSetChanged();
                        cityAdapter.setSelectedPositionNoNotify(0, cityValues);
                        lv_city.smoothScrollToPosition(0);
                    }else{
                        cityAdapter.notifyDataSetChanged();
                    }
                }
            });}
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                bundle = new Bundle();
                bundle.putString("categoryName",null);
                bundle.putString("categoryNameid",null);
                setResult(101,ShopFenLeiActivity.this.getIntent().putExtras(bundle));
                ShopFenLeiActivity.this.finish();
                break;
            case R.id.bt_queding:
                if (!utils.isDoubleClick()){
                    if (cityValues.size()>0){
                        categoryName = cityValues.get(cityPosition);
                        categoryNameid = cityValuesid.get(cityPosition);
                        Nameid = countryValues.get(countryPosition);
                    }else if (provinceValues.size()>0){
                        categoryName = provinceValues.get(provincePosition);
                        categoryNameid = provinceValuesid.get(provincePosition);
                        Nameid = countryValues.get(countryPosition);
                    }else {
                        categoryName = countryValues.get(countryPosition);
                        categoryNameid = countryValuesid.get(countryPosition);
                        Nameid = countryValues.get(countryPosition);
                    }

                    bundle = new Bundle();
                    bundle.putString("categoryNameid",categoryNameid);
                    bundle.putString("categoryName",categoryName);
                    bundle.putString("Nameid",Nameid);
                    setResult(101,ShopFenLeiActivity.this.getIntent().putExtras(bundle));
                    ShopFenLeiActivity.this.finish();
                }
                break;
        }
    }
    @Override
    public void onBackPressed(){
        bundle = new Bundle();
        bundle.putString("categoryName",null);
        bundle.putString("categoryNameid",null);
        setResult(101,ShopFenLeiActivity.this.getIntent().putExtras(bundle));
        ShopFenLeiActivity.this.finish();
        super.onBackPressed();
    }
}
