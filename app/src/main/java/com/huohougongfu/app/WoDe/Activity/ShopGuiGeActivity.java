package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.R;
import com.huohougongfu.app.WoDe.Adapter.GuiGeAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShopGuiGeActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rec_shop_guige;
    private ArrayList<String> mguige;
    private ArrayList<String> mxianjia;
    private ArrayList<String> myuanjia;
    private GuiGeAdapter adapter;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_gui_ge);
        initUI();
        initRecycle();
    }

    private void initUI() {
        rec_shop_guige = findViewById(R.id.rec_shop_guige);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_queding).setOnClickListener(this);
        findViewById(R.id.bt_tijiao).setOnClickListener(this);
    }

    private void initAdd() {
        adapter.addguige(mguige.size());
        adapter.addxianjia(mxianjia.size());
        adapter.addyuanjia(myuanjia.size());
    }

    private void initRecycle() {
        //  纵向滑动
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rec_shop_guige.setLayoutManager(linearLayoutManager);
//      获取数据，向适配器传数据，绑定适配器
        mguige = initGuige();
        mxianjia = initxianjia();
        myuanjia = inityuanjia();
        adapter = new GuiGeAdapter(mguige, mxianjia, myuanjia);
        rec_shop_guige.setAdapter(adapter);

    }

    protected ArrayList<String> initGuige() {
        ArrayList<String> mDatas = new ArrayList<String>();
        for (int i = 0; i < 1; i++) {
            mDatas.add("");
        }
        return mDatas;
    }
    protected ArrayList<String> initxianjia() {
        ArrayList<String> mYouFeiData = new ArrayList<String>();
        for (int i = 0; i < 1; i++) {
            mYouFeiData.add("");
        }
        return mYouFeiData;
    }
    protected ArrayList<String> inityuanjia() {
        ArrayList<String> mYouFeiData = new ArrayList<String>();
        for (int i = 0; i < 1; i++) {
            mYouFeiData.add("");
        }
        return mYouFeiData;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                bundle = new Bundle();
                bundle.putStringArrayList("Shopguige",null);
                setResult(100,ShopGuiGeActivity.this.getIntent().putExtras(bundle));
                ShopGuiGeActivity.this.finish();
                super.onBackPressed();
                break;
            case R.id.bt_queding:
                initAdd();
                break;
            case R.id.bt_tijiao:
                ArrayList<String> customSettings = new ArrayList<>();
                for (int i = 0; i < mguige.size(); i++) {
                    if (!"".equals(mguige.get(i))){
                        if (!"".equals(mxianjia.get(i))){
                            if (!"".equals(myuanjia.get(i))){
                                customSettings.add(mguige.get(i)+"~"+mxianjia.get(i)+"~"+myuanjia.get(i));
                            }else{
                                ToastUtils.showShort("请输入原价");
                            }
                        }else{
                            ToastUtils.showShort("请输入现价");
                        }
                    }else{
                        ToastUtils.showShort("请输入规格参数");
                    }
                }
                bundle = new Bundle();
                bundle.putStringArrayList("Shopguige",customSettings);
                setResult(100,ShopGuiGeActivity.this.getIntent().putExtras(bundle));
                ShopGuiGeActivity.this.finish();
                super.onBackPressed();
                break;
        }
    }
    @Override
    public void onBackPressed(){
        bundle = new Bundle();
        bundle.putStringArrayList("Shopguige",null);
        setResult(100,ShopGuiGeActivity.this.getIntent().putExtras(bundle));
        ShopGuiGeActivity.this.finish();
        super.onBackPressed();
    }
}
