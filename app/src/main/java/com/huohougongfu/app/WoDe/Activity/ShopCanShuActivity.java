package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.huohougongfu.app.R;

public class ShopCanShuActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rec_chanpin_canshu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_can_shu);
        initUI();
        initData();
    }

    private void initData() {

    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        rec_chanpin_canshu = findViewById(R.id.rec_chanpin_canshu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
        }
    }
}
