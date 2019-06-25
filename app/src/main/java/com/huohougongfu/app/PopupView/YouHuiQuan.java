package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huohougongfu.app.Gson.ShopYouHuiQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.YouHuiQuanAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.lxj.xpopup.core.BottomPopupView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YouHuiQuan extends BottomPopupView {
    private List<ShopYouHuiQuan.ResultBean> mYouhuiquan;
    private RecyclerView rec_shop_youhuiquan;
    private Context context;
    private String token,tel,id;


    public YouHuiQuan(@NonNull Context context, List<ShopYouHuiQuan.ResultBean> shopid) {
        super(context);
        this.context = context;
        this.mYouhuiquan = shopid;
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_detail_youhuiquan;
    }
    @Override
    protected void onCreate() {
        super.onCreate();
        //初始化
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        id = String.valueOf(MyApp.instance.getInt("id"));
        initUI();
    }

    private void initUI() {
        findViewById(R.id.bt_wancheng).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        rec_shop_youhuiquan = findViewById(R.id.rec_shop_youhuiquan);
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(context);
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        //设置RecyclerView 布局
        rec_shop_youhuiquan.setLayoutManager(layoutmanager);
        YouHuiQuanAdapter youHuiQuanAdapter = new YouHuiQuanAdapter(R.layout.item_detail_youhuiquan,mYouhuiquan);
        rec_shop_youhuiquan.setAdapter(youHuiQuanAdapter);
        youHuiQuanAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                initLingQu(String.valueOf(mYouhuiquan.get(position).getId()));
            }
        });
    }

    private void initLingQu(String couponsId) {
        Map<String,String> map = new HashMap();
        map.put("couponsId",couponsId);
        map.put("tel",tel);
        OkGo.<String>post(Contacts.URl1+"/member/collectStamps")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                    }
                });
    }
}
