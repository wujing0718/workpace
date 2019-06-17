package com.huohougongfu.app.PopupView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.AmountView;
import com.lxj.xpopup.animator.PopupAnimator;
import com.lxj.xpopup.core.CenterPopupView;

public class Paocha extends CenterPopupView implements View.OnClickListener {
    private String yedi;
    private String nongdu;
    private int amount = 1;

    private AmountView amountview;

    public Paocha(@NonNull Context context) {
        super(context);
    }
    // 返回自定义弹窗的布局
    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_paocha;
    }
    // 执行初始化操作，比如：findView，设置点击，或者任何你弹窗内的业务逻辑
    @Override
    protected void onCreate() {
        super.onCreate();
        initUI();

    }

    private void initUI() {
        RadioGroup radiogroup_yedi = findViewById(R.id.radiogroup_yedi);
        RadioGroup radiogroup_nongdu = findViewById(R.id.radiogroup_nongdu);
        RadioButton radiobutton_youyedi = findViewById(R.id.radiobutton_youyedi);
        RadioButton radiobutton_wuyedi = findViewById(R.id.radiobutton_wuyedi);
        RadioButton radiobutton_biaozhun = findViewById(R.id.radiobutton_biaozhun);
        RadioButton radiobutton_nong = findViewById(R.id.radiobutton_nong);
        RadioButton radiobutton_dan = findViewById(R.id.radiobutton_dan);
        amountview = findViewById(R.id.amountview);
        amountview.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount1) {
                amount = amount1;
            }
        });
        findViewById(R.id.bt_fangruchatai).setOnClickListener(this);
        findViewById(R.id.bt_lijixiadan).setOnClickListener(this);

        radiogroup_yedi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radiobutton_youyedi.getId() == checkedId){
                    yedi = "有叶底";
                }
                if (radiobutton_wuyedi.getId() == checkedId){
                    yedi = "无叶底";
                }
            }
        });
        radiogroup_nongdu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radiobutton_biaozhun.getId() == checkedId){
                    nongdu = "标准";
                }
                if (radiobutton_nong.getId() == checkedId){
                    nongdu = "浓";
                }
                if (radiobutton_dan.getId() == checkedId){
                    nongdu = "淡";
                }
            }
        });


    }

    // 设置最大宽度，看需要而定
    @Override
    protected int getMaxWidth() {
        return super.getMaxWidth();
    }
    // 设置最大高度，看需要而定
    @Override
    protected int getMaxHeight() {
        return super.getMaxHeight();
    }
    // 设置自定义动画器，看需要而定
    @Override
    protected PopupAnimator getPopupAnimator() {
        return super.getPopupAnimator();
    }
    /**
     * 弹窗的宽度，用来动态设定当前弹窗的宽度，受getMaxWidth()限制
     *
     * @return
     */
    protected int getPopupWidth() {
        return 0;
    }

    /**
     * 弹窗的高度，用来动态设定当前弹窗的高度，受getMaxHeight()限制
     *
     * @return
     */
    protected int getPopupHeight() {
        return 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_fangruchatai:
                ToastUtils.showShort(yedi+nongdu+amount);
                break;
            case R.id.bt_lijixiadan:

                break;
        }
    }
}
