package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.huohougongfu.app.Gson.LiBaoGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.ShouDaoQuanAdapter;
import com.lxj.xpopup.core.CenterPopupView;

import java.util.List;

public class PopupShouDaoQuan extends CenterPopupView {
    private List<LiBaoGson.ResultBean.ReceiveBean> receive;
    private Context context;

    public PopupShouDaoQuan(@NonNull Context context, List<LiBaoGson.ResultBean.ReceiveBean> receive) {
        super(context);
        this.receive = receive;
        this.context = context;

    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_home_shoudaoquan;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        initUI();
    }

    private void initUI() {
        RecyclerView rec_shoudaoquan = findViewById(R.id.rec_shoudaoquan);
        TextView tv_shoudaoquan_title = findViewById(R.id.tv_shoudaoquan_title);
        tv_shoudaoquan_title.setText("恭喜您获得"+receive.size()+"张免费券！");
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(context);
        //设置RecyclerView 布局
        rec_shoudaoquan.setLayoutManager(layoutmanager);
        ShouDaoQuanAdapter shouDaoQuanAdapter = new ShouDaoQuanAdapter(R.layout.item_shoudanquan,receive);
        rec_shoudaoquan.setAdapter(shouDaoQuanAdapter);
    }
}
