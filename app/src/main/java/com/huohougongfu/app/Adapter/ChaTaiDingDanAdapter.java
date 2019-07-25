package com.huohougongfu.app.Adapter;

import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
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

    public ChaTaiDingDanAdapter(int layoutResId, @Nullable List<ChaTaiDingDan.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChaTaiDingDan.ResultBean.ListBean item) {
        String nowTime = utils.getNowTime();
        String s = utils.dateToStamp(nowTime);
        String createTime = item.getCreateTime();
        String s1 = utils.dateToStamp2(createTime);
        long aLong = Long.valueOf(s);
        long aLong1 = Long.valueOf(s1);
        long q = (aLong1+900) - aLong;
        helper.addOnClickListener(R.id.btn_queidng);
        tv_chatai_orderStatus = helper.getView(R.id.tv_chatai_orderStatus);
        helper.setText(R.id.tv_chatai_verificationCode,item.getVerificationCode());

        if ("0".equals(item.getOrderStatus())){
            if (q>0){
                time = q;
                CountDownTimer timer = new CountDownTimer(time * 1000, 1000) {
                    /**
                     * 固定间隔被调用,就是每隔countDownInterval会回调一次方法onTick
                     * @param millisUntilFinished
                     */
                    @Override
                    public void onTick(long millisUntilFinished) {
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
}
