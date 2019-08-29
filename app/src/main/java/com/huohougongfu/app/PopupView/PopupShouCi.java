package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.huohougongfu.app.Gson.LiBaoGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.UIUtils;
import com.lxj.xpopup.core.CenterPopupView;

import java.util.List;

public class PopupShouCi extends CenterPopupView {
    private final Context context;
    private LiBaoGson.ResultBean.TeariceRecordsBean receiveBean;
    private TextView tv_conttent_one,tv_conttent_two,tv_conttent_three,tv_qiaoqoanhua;

    public PopupShouCi(@NonNull Context context, LiBaoGson.ResultBean.TeariceRecordsBean receiveBean) {
        super(context);
        this.receiveBean = receiveBean;
        this.context = context;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        initUI();
    }

    private void initUI() {
        tv_conttent_one = findViewById(R.id.tv_conttent_one);
        tv_conttent_two = findViewById(R.id.tv_conttent_two);
        tv_conttent_three = findViewById(R.id.tv_conttent_three);
        tv_qiaoqoanhua = findViewById(R.id.tv_qiaoqoanhua);
        tv_conttent_one.setText("您的好友"+" “ "+receiveBean.getSendName()+" ” 赠送了您");
        tv_conttent_two.setText(String.valueOf(receiveBean.getCount()));
        tv_qiaoqoanhua.setText(receiveBean.getPillowtalk());
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.popup_home_kaquan;
    }

    @Override
    protected int getMaxWidth() {
        return UIUtils.getScreenWidth(context);
    }

    @Override
    protected int getMaxHeight() {
        return (int)(UIUtils.getScreenHeight(context)*0.6f);
    }
}
