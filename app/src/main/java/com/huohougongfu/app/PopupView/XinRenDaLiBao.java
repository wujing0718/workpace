package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.XinRenAdapter;
import com.huohougongfu.app.Gson.LiBaoGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.UIUtils;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.util.XPopupUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

public class XinRenDaLiBao extends CenterPopupView {

    private final Context context;
    private List<LiBaoGson.ResultBean.SystemBean> system;
    public XinRenDaLiBao(@NonNull Context context, List<LiBaoGson.ResultBean.SystemBean> system) {
        super(context);
        this.context =context;
        this.system = system;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_xinrendalibao;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        intUI();
    }


    private void intUI() {
        findViewById(R.id.bt_guanbi).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        RecyclerView rec_libao = findViewById(R.id.rec_libao);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        rec_libao.setLayoutManager(layoutManager);
        XinRenAdapter xinRenAdapter = new XinRenAdapter(R.layout.item_wodekaquan, system);
        rec_libao.setAdapter(xinRenAdapter);
        xinRenAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                new XPopup.Builder(getContext())
                        .atView(view)
                        .hasShadowBg(false) // 去掉半透明背景
                        .asCustom(new KaQuanGuiZe(getContext(),system.get(position).getServiceRegulations()))
                        .show();
            }
        });
    }

    @Override
    protected int getMaxWidth() {
        return UIUtils.getScreenWidth(context);
    }
}
