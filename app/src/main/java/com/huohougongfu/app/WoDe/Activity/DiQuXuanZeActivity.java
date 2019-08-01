package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.JsonBean;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.GetJsonDataUtil;
import com.huohougongfu.app.WoDe.Adapter.DiQUXuanZeAdapter;

import org.json.JSONArray;

import java.util.ArrayList;

public class DiQuXuanZeActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rec_diquxuanze;
    ArrayList<String> NameList = new ArrayList<>();//该省的城市列表（第二级）
    private DiQUXuanZeAdapter diQUXuanZeAdapter;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di_qu_xuan_ze);
        position = getIntent().getIntExtra("position", 0);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_queding).setOnClickListener(this);
        initData();
        rec_diquxuanze = findViewById(R.id.rec_diquxuanze);
        initRec();
    }

    private void initRec() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rec_diquxuanze.setLayoutManager(layoutManager);
        diQUXuanZeAdapter = new DiQUXuanZeAdapter(NameList);
        rec_diquxuanze.setAdapter(diQUXuanZeAdapter);
    }

    private void initData() {
        String JsonData = new GetJsonDataUtil().getJson(this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体
        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            String pickerViewText = jsonBean.get(i).getName();
            NameList.add(pickerViewText);
        }
    }

    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                setResult(RESULT_CANCELED,DiQuXuanZeActivity.this.getIntent());
                DiQuXuanZeActivity.this.finish();
                break;
            case R.id.bt_queding:
                Bundle bundle = new Bundle();
                bundle.putInt("position",position);
                bundle.putSerializable("地址",diQUXuanZeAdapter.getSelectedItem());
                setResult(RESULT_CANCELED,DiQuXuanZeActivity.this.getIntent().putExtras(bundle));
                DiQuXuanZeActivity.this.finish();
                break;
        }
    }
}
