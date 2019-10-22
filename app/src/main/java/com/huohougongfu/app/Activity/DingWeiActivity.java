package com.huohougongfu.app.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ChaTaiAdapter;
import com.huohougongfu.app.Gson.AddressBean;
import com.huohougongfu.app.Gson.JiQiLieBiao;
import com.huohougongfu.app.Gson.MaiChaJiQiGson;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Activity.JiQiAcyivity;
import com.huohougongfu.app.ShouYe.Adapter.DingWeiAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.SmoothCheckBox;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class DingWeiActivity extends AppCompatActivity implements GeocodeSearch.OnGeocodeSearchListener {

    private ShangPinGson shangPinGson;
    private RecyclerView rec_dingwei_sousuo;
    private DingWeiAdapter mAdapter;
    private GeocodeSearch geocodeSearch;
    private String addressName;
    private float Lat,Lon;
    private Intent intent;
    private JiQiLieBiao lieiao;
    private TextView bt_jiqi_sousuo;
    private String lon,lat;
    private AddressBean data1;
    private TextView tv_jiqiweizhi,tv_jiqijuli;
    private MaiChaJiQiGson.ResultBean.ListBean maichajiqi;
    private int 买茶,泡茶;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_wei);
        买茶 = getIntent().getIntExtra("买茶", 0);
        泡茶 = getIntent().getIntExtra("泡茶", 0);
        lon = MyApp.instance.getString("lon");
        lat = MyApp.instance.getString("lat");
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundles = new Bundle();
                bundles.putSerializable("data",null);
                setResult(CONTEXT_RESTRICTED,DingWeiActivity.this.getIntent().putExtras(bundles));
                DingWeiActivity.this.finish();
            }
        });
        bt_jiqi_sousuo = findViewById(R.id.bt_jiqi_sousuo);
        bt_jiqi_sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到新打开Activity关闭后返回的数据
                //第二个参数为请求码，可以根据业务需求自己编号
                startActivityForResult(new Intent(DingWeiActivity.this, JiQiAcyivity.class), CONTEXT_RESTRICTED);
            }
        });
        tv_jiqiweizhi = findViewById(R.id.tv_jiqiweizhi);
        tv_jiqijuli = findViewById(R.id.tv_jiqijuli);
        if (泡茶 == 1){
            initData(lat,lon);
        }else if (买茶 == 1){
            initMaiChaData(lat,lon);
        }
    }

    private void initMaiChaData(String lat, String lon) {
        Map<String, String> map = new HashMap<>();
        map.put("longitude",lon);
        map.put("latitude", lat);
        map.put("pageNo", "1");
        map.put("pageSize", "10");
        OkGo.<String>post(Contacts.URl1+"/machine/nearMachineProduct")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        JiQiLieBiao lieiao = gson.fromJson(response.body(), JiQiLieBiao.class);
                        if (lieiao.getStatus() == 1) {
                            if (lieiao.getResult().getList().size()>0){
                                initRec(lieiao);
                                tv_jiqiweizhi.setText(lieiao.getResult().getList().get(0).getDetailAddress());
                                DecimalFormat formater = new DecimalFormat();
                                formater.setMaximumFractionDigits(2);
                                formater.setGroupingSize(0);
                                formater.setRoundingMode(RoundingMode.FLOOR);
                                String result = formater.format(Double.valueOf(lieiao.getResult().getList().get(0).getDistance()));
                                tv_jiqijuli.setText("距您"+result+"m");
                            }
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
//                        WaitDialog.show(getActivity(), "载入中...");
                        super.onStart(request);
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CONTEXT_RESTRICTED){
            data1 = (AddressBean)data.getSerializableExtra("data");
            if(data1==null){
                bt_jiqi_sousuo.setText("服务地址");
            }else{
                GeocodeSearch(data1.getAddress());
                bt_jiqi_sousuo.setText(data1.getTitle());
            }
        }
    }

    //发起正地理编码搜索
    public void GeocodeSearch(String city) {
        //构造 GeocodeSearch 对象，并设置监听。
        geocodeSearch = new GeocodeSearch(this);
        geocodeSearch.setOnGeocodeSearchListener(this);
    //通过GeocodeQuery设置查询参数,调用getFromLocationNameAsyn(GeocodeQuery geocodeQuery) 方法发起请求。
    //address表示地址，第二个参数表示查询城市，中文或者中文全拼，citycode、adcode都ok
        GeocodeQuery query = new GeocodeQuery(city, city);
        geocodeSearch.getFromLocationNameAsyn(query);
    }

    @Override
    public void onBackPressed() {
        Bundle bundles = new Bundle();
        bundles.putSerializable("data",null);
        setResult(CONTEXT_RESTRICTED,DingWeiActivity.this.getIntent().putExtras(bundles));
        DingWeiActivity.this.finish();
        super.onBackPressed();
    }

    private void initData(String lat, String lon) {
        Map<String, String> map = new HashMap<>();
        map.put("longitude",lon);
        map.put("latitude", lat);
        map.put("pageNo", "1");
        map.put("pageSize", "10");
        OkGo.<String>post(Contacts.URl1+"/machine/near")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        lieiao = gson.fromJson(response.body(), JiQiLieBiao.class);
                        if (lieiao.getStatus() == 1) {
                            if (lieiao.getResult().getList().size()>0){
                                initRec(lieiao);
                                tv_jiqiweizhi.setText(lieiao.getResult().getList().get(0).getDetailAddress());
                                DecimalFormat formater = new DecimalFormat();
                                formater.setMaximumFractionDigits(2);
                                formater.setGroupingSize(0);
                                formater.setRoundingMode(RoundingMode.FLOOR);
                                String result = formater.format(Double.valueOf(lieiao.getResult().getList().get(0).getDistance()));
                                tv_jiqijuli.setText("距您"+result+"m");
                            }
                        }
                    }
                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(DingWeiActivity.this, "载入中...");
                        super.onStart(request);
                    }
                });
    }

    private void initRec(JiQiLieBiao data) {
        rec_dingwei_sousuo = findViewById(R.id.rec_dingwei_sousuo);
        rec_dingwei_sousuo.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DingWeiAdapter(R.layout.item_dingwei_sousuo, data.getResult().getList());
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (泡茶 == 1){
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("data",data.getResult().getList().get(position));
                    bundle.putInt("type",1);
                    setResult(CONTEXT_RESTRICTED,getIntent().putExtras(bundle));
                    DingWeiActivity.this.finish();
                }else if (买茶 == 1){
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("data",data.getResult().getList().get(position));
                    bundle.putInt("type",2);
                    setResult(CONTEXT_RESTRICTED,getIntent().putExtras(bundle));
                    DingWeiActivity.this.finish();
                }
            }
        });
        rec_dingwei_sousuo.setAdapter(mAdapter);
    }

    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {

    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
        if (i == AMapException.CODE_AMAP_SUCCESS) {
            if (geocodeResult != null && geocodeResult.getGeocodeAddressList() != null
                    && geocodeResult.getGeocodeAddressList().size() > 0) {
                GeocodeAddress address = geocodeResult.getGeocodeAddressList().get(0);
                addressName = "经纬度值:" + address.getLatLonPoint() + "\n位置描述:"
                        + address.getFormatAddress();
                //获取到的经纬度
                LatLonPoint latLongPoint = address.getLatLonPoint();
                Lat = (float)latLongPoint.getLatitude();
                Lon = (float)latLongPoint.getLongitude();
                Log.d("111",Double.toString(Lat));

                initData(String.valueOf(Lat),String.valueOf(Lon));
                //然后把经纬度传递给地图界面
//                intent = new Intent();
//                Bundle bundle = new Bundle();
//                bundle.putDouble("Lat",Lat);
//                bundle.putDouble("Lng",Lon);
//                intent.putExtra("LAT",bundle);
//                LogUtils.e(Lat+"经纬度"+Lon);
            }
        }
    }
}
