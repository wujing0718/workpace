package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huohougongfu.app.Gson.ChaTaiYouHuiQuan;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.YouHuiQuanAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CTYouHuiQuan extends BottomPopupView {
    private final Handler mHandler;
    private List<ChaTaiYouHuiQuan.ResultBean.CouponsBean> mYouhuiquan;
    private RecyclerView rec_shop_youhuiquan;
    private Context context;
    private String token,tel,id;


    public CTYouHuiQuan(@NonNull Context context, List<ChaTaiYouHuiQuan.ResultBean.CouponsBean> shopid, Handler mHandler) {
        super(context);
        this.context = context;
        this.mYouhuiquan = shopid;
        this.mHandler = mHandler;
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
                Message msg = Message.obtain();
                msg.what = 0;
                msg.obj = mYouhuiquan.get(position);
                mHandler.sendMessage(msg);
                dismiss();
//                initLingQu(String.valueOf(mYouhuiquan.get(position).getId()));
            }
        });
    }

    private void initLingQu(String couponsId) {
        Map<String,String> map = new HashMap();
        map.put("couponsId",couponsId);
        map.put("tel",tel);
        OkGo.<String>post(Contacts.URl2+"/member/collectStamps")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                    }
                });
    }
    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext()) * .65f);
    }
}
