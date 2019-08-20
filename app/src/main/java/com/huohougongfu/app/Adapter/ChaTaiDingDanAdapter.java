package com.huohougongfu.app.Adapter;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ChaTaiDingDan;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ChaTaiDingDanAdapter extends BaseQuickAdapter<ChaTaiDingDan.ResultBean.ListBean,BaseViewHolder> {
    private Timer mTimer;
    private TimerTask mTimerTask;
    private TextView tv_chatai_orderStatus;
    private long time;
    private CountDownTimer timer;

    public ChaTaiDingDanAdapter(int layoutResId, @Nullable List<ChaTaiDingDan.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChaTaiDingDan.ResultBean.ListBean item) {
        Button btn_queidng = helper.getView(R.id.btn_queidng);
        String nowTime = utils.getNowTime();
        String s = utils.dateToStamp(nowTime);
        String createTime = item.getCreateTime();
        String s1 = utils.dateToStamp2(createTime);
        long aLong = Long.valueOf(s);
        long aLong1 = Long.valueOf(s1);
        long q = (aLong1+900) - aLong;
        helper.addOnClickListener(R.id.btn_queidng);
        tv_chatai_orderStatus = helper.getView(R.id.tv_chatai_orderStatus);
        if (timer != null){
            timer.cancel();
        }
        helper.setText(R.id.tv_chatai_verificationCode,item.getVerificationCode());
                if ("0".equals(item.getOrderStatus())){
                    btn_queidng.setVisibility(View.VISIBLE);
                    if (q>0){
                        time = q;
                        timer = new CountDownTimer(time * 1000, 1000) {
                            /**
                             * 固定间隔被调用,就是每隔countDownInterval会回调一次方法onTick
                             * @param millisUntilFinished
                             */
                            @Override
                            public void onTick(long millisUntilFinished) {
                                // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                                tv_chatai_orderStatus.setTextColor(MyApp.context.getResources().getColor(R.color.colorRed));
                                tv_chatai_orderStatus.setText("待支付："+utils.formatTime(millisUntilFinished));
                            }

                            /**
                             * 倒计时完成时被调用
                             */
                            @Override
                            public void onFinish() {
                                tv_chatai_orderStatus.setText("已过期");
                            }
                        };
                        timer.start();
                    }else{
                        btn_queidng.setVisibility(View.GONE);
                        tv_chatai_orderStatus.setText("已过期");
                    }
                }else if ("1".equals(item.getOrderStatus())){
                    helper.setText(R.id.tv_chatai_orderStatus,"待提货");
                }else if ("2".equals(item.getOrderStatus())){
                    helper.setText(R.id.tv_chatai_orderStatus,"已消费");
                }
        helper.setText(R.id.tv_chatai_teas,item.getTeas());
        helper.setText(R.id.tv_chatai_teaNum,"共"+item.getTeaNum()+"件");
        helper.setText(R.id.tv_chatai_orderTotal,"合计：¥ "+item.getOrderTotal());
        helper.setText(R.id.tv_chatai_createTime,"下单时间："+item.getCreateTime());
    }

    @Override
    public void onViewRecycled(@NonNull BaseViewHolder holder) {
        super.onViewRecycled(holder);
        if (timer != null) {
            timer.cancel();
            timer=null;
        }
    }
}
