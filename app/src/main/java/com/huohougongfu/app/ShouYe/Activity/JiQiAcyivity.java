package com.huohougongfu.app.ShouYe.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.blankj.utilcode.util.ToastUtils;
import com.googlecode.mp4parser.authoring.Edit;
import com.huohougongfu.app.Gson.AddressBean;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.PoiAdapter;
import com.huohougongfu.app.Utils.ListenerManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnTextChanged;

public class JiQiAcyivity extends AppCompatActivity  implements PoiSearch.OnPoiSearchListener{

    private EditText edt_jiqi_sousuo;
    private RecyclerView rcv_dizhi_sousuo;
    private ArrayList<AddressBean> data = new ArrayList<AddressBean>();
    private PoiAdapter poiAdapter;
    private PoiSearch.Query query;
    private PoiSearch poiSearch;
    private PoiResult poiResult;
    private InputMethodManager manager;
    private String aoiName;
    private String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ji_qi_acyivity);
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        aoiName = MyApp.instance.getString("AoiName");
        title = getIntent().getStringExtra("title");
        initView();

    }

    private void initView() {
        edt_jiqi_sousuo = findViewById(R.id.edt_jiqi_sousuo);
        rcv_dizhi_sousuo = findViewById(R.id.rcv_dizhi_sousuo);
        edt_jiqi_sousuo.setText(aoiName);
        seach();
        edt_jiqi_sousuo.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(edt_jiqi_sousuo.getApplicationWindowToken(), 0);
                    }
                    aoiName = edt_jiqi_sousuo.getText().toString();
                    //自己需要的操作
                    seach();
                }
                //记得返回false
                return false;
            }
        });
        findViewById(R.id.bt_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundles = new Bundle();
                bundles.putSerializable("data",null);
                bundles.putString("title","所在位置");
                setResult(CONTEXT_RESTRICTED,JiQiAcyivity.this.getIntent().putExtras(bundles));
                JiQiAcyivity.this.finish();
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(JiQiAcyivity.this);
        //设置布局管理器
        rcv_dizhi_sousuo.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper. VERTICAL);
        poiAdapter = new PoiAdapter(data);
        rcv_dizhi_sousuo.setAdapter(poiAdapter);
        //搜索地址后的监听
        poiAdapter.setOnItemClickListener(new PoiAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Bundle bundle = new Bundle();
                bundle.putString("title",title);
                bundle.putSerializable("data",data.get(position));
//                data.get(position).getAddress();
                setResult(CONTEXT_RESTRICTED,getIntent().putExtras(bundle));
                JiQiAcyivity.this.finish();
            }

            @Override
            public void onLongClick(int position) {

            }
        });
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundles = new Bundle();
                bundles.putString("title",title);
                bundles.putSerializable("data",null);
                setResult(CONTEXT_RESTRICTED,JiQiAcyivity.this.getIntent().putExtras(bundles));
                JiQiAcyivity.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Bundle bundles = new Bundle();
        bundles.putSerializable("data",null);
        bundles.putString("title",title);
        setResult(CONTEXT_RESTRICTED,JiQiAcyivity.this.getIntent().putExtras(bundles));
        JiQiAcyivity.this.finish();
        super.onBackPressed();
    }

    private void seach(){
        int currentPage = 0;
        // 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        query = new PoiSearch.Query(aoiName, "", "");
        // 设置每页最多返回多少条poiitem
        query.setPageSize(20);
        // 设置查询页码
        query.setPageNum(currentPage);
        //设置城市界限不然不输入城市名称有些地方搜索不到
        query.setCityLimit(true);
        //构造 PoiSearch 对象，并设置监听
        poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(this);
        //调用 PoiSearch 的 searchPOIAsyn() 方法发送请求。
        poiSearch.searchPOIAsyn();
    }


    @Override
    public void onPoiSearched(PoiResult result, int i) {
        data.clear();
        //rCode 为1000 时成功,其他为失败
        if (1000 == AMapException.CODE_AMAP_SUCCESS) {
            // 解析result   获取搜索poi的结果
            if (result != null && result.getQuery() != null) {
                if (result.getQuery().equals(query)) {  // 是否是同一条
                    poiResult = result;
                    // 取得第一页的poiitem数据，页数从数字0开始
                    //poiResult.getPois()可以获取到PoiItem列表
                    List<PoiItem> poiItems = poiResult.getPois();

                    //解析获取到的PoiItem列表
                    for(PoiItem item : poiItems){
                        //获取经纬度对象
                        LatLonPoint llp = item.getLatLonPoint();
                        double lon = llp.getLongitude();
                        double lat = llp.getLatitude();
                        String cityCode = item.getCityCode();
                        String adCode = item.getAdCode();
                        //获取标题
                        String title = item.getTitle();
                        //获取内容
                        String text = item.getSnippet();
                        String name=item.getAdName();
                        String cityName=item.getCityName();
                        String area=item.getBusinessArea();
                        String  provinceName=item.getProvinceName();
                        String addressInfo=provinceName+cityName+name+text;
                        data.add(new AddressBean(lon, lat, title, text,addressInfo,adCode,cityCode));
                    }
                }
            } else {
                ToastUtils.showShort("无搜索结果");
            }
        } else {
            ToastUtils.showShort("错误码");
        }
            poiAdapter.refreshData(data);
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }
}
