package com.huohougongfu.app.Adapter;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ChaTaiDingDan;
import com.huohougongfu.app.Gson.DaShiSouSuo;
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
    //用于退出 Activity,避免 Countdown，造成资源浪费。
    private SparseArray<CountDownTimer> countDownCounters ;
    private List<ChaTaiDingDan.ResultBean.ListBean> data1;
    public ChaTaiDingDanAdapter(int layoutResId, @Nullable List<ChaTaiDingDan.ResultBean.ListBean> data) {
        super(layoutResId, data);
        this.countDownCounters = new SparseArray<>();
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ChaTaiDingDan.ResultBean.ListBean item) {
        tv_chatai_orderStatus = helper.getView(R.id.tv_chatai_orderStatus);
        if (timer != null) {
            //将复用的倒计时清除
            timer.cancel();
        }
        Button btn_queidng = helper.getView(R.id.btn_queidng);
        String nowTime = utils.getNowTime();
        String s = utils.dateToStamp(nowTime);
        String createTime = item.getCreateTime();
        String s1 = utils.dateToStamp2(createTime);
        long aLong = Long.valueOf(s);
        long aLong1 = Long.valueOf(s1);
        long q = (aLong1+900) - aLong;
        helper.addOnClickListener(R.id.btn_queidng);
        helper.setText(R.id.tv_chatai_verificationCode,item.getVerificationCode());
        if (timer != null) {
            timer.cancel();
        }
                if ("0".equals(item.getOrderStatus())){
                    tv_chatai_orderStatus.setTextColor(MyApp.context.getResources().getColor(R.color.colorRed));
                    tv_chatai_orderStatus.setText("待支付");
                    btn_queidng.setText("确认支付");
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
                                tv_chatai_orderStatus.setTextColor(MyApp.context.getResources().getColor(R.color.colorRed));
//                                tv_chatai_orderStatus.setText("待支付："+utils.formatTime(millisUntilFinished));
                                tv_chatai_orderStatus.setText("待支付");

                            }

                            /**
                             * 倒计时完成时被调用
                             */
                            @Override
                            public void onFinish() {
                                tv_chatai_orderStatus.setTextColor(MyApp.context.getResources().getColor(R.color.colorBlack));
                                tv_chatai_orderStatus.setText("已过期");
                            }
                        }.start();
                        //将此 countDownTimer 放入list.
                        countDownCounters.put(tv_chatai_orderStatus.hashCode(), timer);
                    }else{
                        btn_queidng.setText("删除订单");
                        tv_chatai_orderStatus.setText("已过期");
                        tv_chatai_orderStatus.setTextColor(MyApp.context.getResources().getColor(R.color.colorBlack));
                    }
                }else if ("1".equals(item.getOrderStatus())){
                    helper.setText(R.id.tv_chatai_orderStatus,"待提货");
                }else if ("2".equals(item.getOrderStatus())){
                    btn_queidng.setText("删除订单");
                    helper.setText(R.id.tv_chatai_orderStatus,"已消费");
                }
        helper.setText(R.id.tv_chatai_teas,item.getTeas());
        helper.setText(R.id.tv_chatai_teaNum,"共"+item.getDetails().size()+"件");
        helper.setText(R.id.tv_chatai_orderTotal,"合计：¥ "+item.getOrderTotal());
        helper.setText(R.id.tv_chatai_createTime,"下单时间："+item.getCreateTime());
    }

    public void cancelAllTimers() {
        if (countDownCounters == null) {
            return;
        }
        for (int i = 0, length = countDownCounters.size(); i < length; i++) {
            CountDownTimer cdt = countDownCounters.get(countDownCounters.keyAt(i));
            if (cdt != null) {
                cdt.cancel();
            }
        }
    }
    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<ChaTaiDingDan.ResultBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<ChaTaiDingDan.ResultBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
