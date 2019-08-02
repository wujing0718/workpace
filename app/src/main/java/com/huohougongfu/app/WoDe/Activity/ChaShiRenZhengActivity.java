package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huohougongfu.app.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class ChaShiRenZhengActivity extends AppCompatActivity {

    private TagFlowLayout id_flowlayout_zhicheng;
    private List<String> datas_zhicheng = new ArrayList<>();
    private TagAdapter<String> zhichengadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha_shi_ren_zheng);
        initData();
        initUI();
        
    }

    private void initData() {
        datas_zhicheng.add("评茶师");
        datas_zhicheng.add("制茶师");
        datas_zhicheng.add("茶艺师");
        datas_zhicheng.add("匠人");
    }

    private void initUI() {
        id_flowlayout_zhicheng = findViewById(R.id.id_flowlayout_zhicheng);
        zhichengadapter = new TagAdapter<String>(datas_zhicheng) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                View inflate = LayoutInflater.from(ChaShiRenZhengActivity.this).inflate(R.layout.item_renzheng, parent, false);
                TextView item_name = inflate.findViewById(R.id.item_name);
                ImageView img_renzheng = inflate.findViewById(R.id.img_renzheng);
                img_renzheng.setImageResource(R.drawable.selector_renzehng);
                item_name.setText(o);
                return inflate;
            }
        };
        id_flowlayout_zhicheng.setAdapter(zhichengadapter);
    }
}
