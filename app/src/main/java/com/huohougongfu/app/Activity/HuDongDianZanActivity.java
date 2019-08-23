package com.huohougongfu.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.HuDongDianZanAdapter;
import com.huohougongfu.app.Adapter.HuDongPingLunAdapter;
import com.huohougongfu.app.Gson.HuDongPingLun;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.QuanZiDetailActivity;
import com.huohougongfu.app.QuanZi.Activity.VedioDetailActivity;
import com.huohougongfu.app.QuanZi.Activity.WenZhangDetailActivity;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuDongDianZanActivity extends AppCompatActivity {

    private SmartRefreshLayout smartrefreshlayout;
    private RecyclerView rec_hudong_pinglun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hu_dong_dian_zan);
        findViewById(R.id.bt_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
    }

    private void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
//        map.put("mId", String.valueOf(43));
        map.put("pageNo", String.valueOf(1));
        map.put("pageSize", String.valueOf(10));
        OkGo.<String>post(Contacts.URl1 + "/my/interactive/praiseList")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        HuDongPingLun huDongPingLun = new Gson().fromJson(body, HuDongPingLun.class);
                        if (huDongPingLun.getStatus() == 1) {
                            initUI(huDongPingLun.getResult().getList());
                        }
                    }
                });
    }


    private void initUI(List<HuDongPingLun.ResultBean.ListBean> list) {
        smartrefreshlayout = findViewById(R.id.smartrefreshlayout);
        rec_hudong_pinglun = findViewById(R.id.rec_hudong_pinglun);
        LinearLayoutManager layoutManager = new LinearLayoutManager(HuDongDianZanActivity.this);
        rec_hudong_pinglun.setLayoutManager(layoutManager);
        HuDongDianZanAdapter dianzanadapter = new HuDongDianZanAdapter(R.layout.item_hudong_pinglun, list);
        rec_hudong_pinglun.setAdapter(dianzanadapter);
        dianzanadapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (list.get(position).getCircleData().getType() == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("userid",list.get(position).getMember().getUserId());
                    intent.putExtra("dId",list.get(position).getDataId());
                    startActivity(intent.setClass(HuDongDianZanActivity.this,QuanZiDetailActivity.class));
                } else if (list.get(position).getCircleData().getType() == 2) {
                    Intent intent = new Intent();
                    intent.putExtra("userid",list.get(position).getMember().getUserId());
                    intent.putExtra("dId",list.get(position).getDataId());
                    startActivity(intent.setClass(HuDongDianZanActivity.this,WenZhangDetailActivity.class));
                } else if (list.get(position).getCircleData().getType() == 3) {
//                    Intent intent = new Intent();
//                    intent.putExtra("userid",list.get(position).getMember().getUserId());
//                    intent.putExtra("dId",list.get(position).getDataId());
//                    intent.putExtra("小视频",faxian.getResult().getDatas().getList().get(position));
//                    intent.putExtra("position",position);
//                    startActivity(intent.setClass(HuDongDianZanActivity.this,VedioDetailActivity.class));
                }
            }
        });
    }
}
