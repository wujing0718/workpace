package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.huohougongfu.app.R;
import com.lxj.xpopup.core.DrawerPopupView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class ShaiXuanDrawerPopupView extends DrawerPopupView {
    public ShaiXuanDrawerPopupView(@NonNull Context context) {
        super(context);
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.shaixuan_drawer_popup;
    }
    @Override
    protected void onCreate() {
        super.onCreate();
        final TagFlowLayout id_flowlayout_fenlei = findViewById(R.id.id_flowlayout_fenlei);
        final TagFlowLayout id_flowlayout_fahuodi = findViewById(R.id.id_flowlayout_fahuodi);
        List<String> datas_fenlei = new ArrayList<>();
        List<String> datas_fahuodi = new ArrayList<>();

        datas_fenlei.add("白茶的种类");
        datas_fenlei.add("白茶的种类");
        datas_fenlei.add("白茶的种类");
        datas_fenlei.add("白茶的种类");
        datas_fenlei.add("白茶的种类");
        datas_fenlei.add("白茶的种类");
        datas_fenlei.add("白茶的种类");
        datas_fahuodi.add("北京");
        datas_fahuodi.add("上海");
        datas_fahuodi.add("广州");
        datas_fahuodi.add("潮汕");
        datas_fahuodi.add("惠州");
        datas_fahuodi.add("南京");
        TagAdapter<String> adapter1 = new TagAdapter<String>(datas_fenlei) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_tag, parent,false);
                view.setText(o);
                return view;
            }
        };
        id_flowlayout_fenlei.setAdapter(adapter1);
        TagAdapter<String> adapter2 = new TagAdapter<String>(datas_fahuodi) {
            @Override
            public View getView(FlowLayout parent, int position, String o) {
                TextView view = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item_fahuodi, parent,false);
                view.setText(o);
                return view;
            }
        };
        id_flowlayout_fahuodi.setAdapter(adapter2);
    }
}
