package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huohougongfu.app.Gson.KuaiDiName;
import com.huohougongfu.app.Gson.KuaiDiZi;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.WoDe.Adapter.KuaiDiNameAdapter;
import com.lxj.xpopup.core.BottomPopupView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KuaiDiGongSi extends BottomPopupView implements View.OnClickListener {
    private final Context context;
    private final Handler mHandler;
    private RecyclerView rec_quxiao_yuanyin;

    public KuaiDiGongSi(@NonNull Context context, Handler mHandler) {
        super(context);
        this.context = context;
        this.mHandler = mHandler;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        rec_quxiao_yuanyin = findViewById(R.id.rec_quxiao_yuanyin);
        findViewById(R.id.vew_guanbi).setOnClickListener(this);
        initData();
    }

    // 返回自定义弹窗的布局
    @Override
    protected int getImplLayoutId() {
        return R.layout.item_kuaidi_gongsi;
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"/kuaidi/company")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        KuaiDiName kuandiname = gson.fromJson(body, KuaiDiName.class);
                        if(kuandiname.getStatus() == 1){
                            try {
                                JSONArray jsonArray = new JSONArray(kuandiname.getResult());
                                Type listType = new TypeToken<List<KuaiDiZi>>() {}.getType();
                                List<KuaiDiZi> kuaiDiZi = gson.fromJson(jsonArray.toString(),listType);
                                LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                                rec_quxiao_yuanyin.setLayoutManager(layoutManager);
                                KuaiDiNameAdapter kuaiDiNameAdapter = new KuaiDiNameAdapter(R.layout.item_dingdan_quxiao_yuanyin,kuaiDiZi);
                                rec_quxiao_yuanyin.setAdapter(kuaiDiNameAdapter);
                                kuaiDiNameAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                        Message msg = Message.obtain();
                                        Map<String,String> map = new HashMap<>();
                                        map.put("expressCompany",kuaiDiZi.get(position).getName());
                                        msg.what = 0;
                                        msg.obj = map;
                                        mHandler.sendMessage(msg);
                                        dismiss();
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.vew_guanbi:
                dismiss();
                break;
        }
    }

}
