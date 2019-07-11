package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.huohougongfu.app.Gson.ShopFuWuGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.CanShuContentAdapter;
import com.huohougongfu.app.Shop.Adapter.ShopFuWuAdapter;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;

public class FuWu extends BottomPopupView {
    private ShopFuWuGson.ResultBean fuwu;
    private Context context;
    private ShopFuWuAdapter fuwuadapter;

    public FuWu(@NonNull Context context, ShopFuWuGson.ResultBean fuwu) {
        super(context);
        this.fuwu = fuwu;
        this.context = context;
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_detail_fuwu;
    }
    @Override
    protected void onCreate() {
        super.onCreate();
        RecyclerView rec_shangpin_fuwu = findViewById(R.id.rec_shangpin_fuwu);
        TextView tv_fuwu_qita = findViewById(R.id.tv_fuwu_qita);
        View view_qita = findViewById(R.id.view_qita);
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(context);
        //设置RecyclerView 布局
        rec_shangpin_fuwu.setLayoutManager(layoutmanager);
        fuwuadapter = new ShopFuWuAdapter(R.layout.item_shaop_fuwu,fuwu.getBasicService());
        rec_shangpin_fuwu.setAdapter(fuwuadapter);
        //初始化
        findViewById(R.id.bt_wancheng).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        if (fuwu.getOther()!=null){
            view_qita.setVisibility(VISIBLE);
            tv_fuwu_qita.setText(fuwu.getOther());
        }else{
            view_qita.setVisibility(GONE);
        }
    }
    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext()) * .65f);
    }
}
