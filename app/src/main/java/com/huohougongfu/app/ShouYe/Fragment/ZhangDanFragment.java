package com.huohougongfu.app.ShouYe.Fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.BasePickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Adapter.ShangPinAdapter;
import com.huohougongfu.app.Gson.ZhangDan;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Adapter.ZhangDanAdapter;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.DateTimeHelper;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhangDanFragment extends Fragment {


    private View inflate;
    private TimePickerView mStartDatePickerView;
    private TextView tv_time;
    private String phone;
    private TextView tv_zhangdan_zhichu,tv_zhangdan_shouru;
    private RecyclerView rec_zhangdan;

    public ZhangDanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_zhang_dan, container, false);
        phone = SPUtils.getInstance("登录").getString("phone");
        String nowTime = utils.getNowTime2();
        String nowTime2 = utils.getNowTime3();
        tv_time = inflate.findViewById(R.id.tv_time);
        tv_time.setText(nowTime);
        initUI();
        initData(nowTime2);
        initStartTimePicker();
        return inflate;
    }

    private void initData(String nowTime2) {
        Map<String,String> map = new HashMap<>();
        map.put("tel",phone);
        map.put("time",nowTime2+"-01");
        map.put("pageNo",String.valueOf(1));
        OkGo.<String>post(Contacts.URl1+"/wallet/bill")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        ZhangDan zhangdan = gson.fromJson(body, ZhangDan.class);
                        if (zhangdan.getStatus() == 1){
                            tv_zhangdan_zhichu.setText("支出¥"+zhangdan.getResult().getNegative());
                            tv_zhangdan_shouru.setText("收入¥"+zhangdan.getResult().getPositive());
                            initRec(zhangdan.getResult().getRecords());
                        }
                    }
                });
    }

    private void initRec(ZhangDan.ResultBean.RecordsBean records) {
        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getActivity());
        //设置RecyclerView 布局
        rec_zhangdan.setLayoutManager(layoutmanager);
        ZhangDanAdapter madapter = new ZhangDanAdapter(R.layout.item_kabao_zhangdan,records.getList());
        rec_zhangdan.setAdapter(madapter);
    }

    /**初始化开始日期选择器控件*/
    private void initStartTimePicker() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        //设置最小日期和最大日期
        Calendar startDate = Calendar.getInstance();
        try {
            startDate.setTime(DateTimeHelper.parseStringToDate("2010-01-01"));//设置为2006年4月28日
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar endDate = Calendar.getInstance();//最大日期是今天
        //时间选择器
        mStartDatePickerView = new TimePickerBuilder(getActivity(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                tv_time.setText(DateTimeHelper.formatToString(date,"yyyy年MM月"));
                initData(DateTimeHelper.formatToString(date,"yyyy-MM"));
            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, false, false, false, false})
                .setLabel("", "", "", "", "", "")
                .isCenterLabel(false)//是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setContentTextSize(20)//滚轮文字大小
                .setLineSpacingMultiplier(1.8f)//行间距
                .setRangDate(startDate, endDate)//设置最小和最大日期
                .setDate(selectedDate)//设置选中的日期
                .build();
    }

    private void initUI() {
        tv_zhangdan_zhichu = inflate.findViewById(R.id.tv_zhangdan_zhichu);
        tv_zhangdan_shouru = inflate.findViewById(R.id.tv_zhangdan_shouru);
        rec_zhangdan = inflate.findViewById(R.id.rec_zhangdan);
        inflate.findViewById(R.id.bt_timepicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartDatePickerView.show();
            }
        });
    }

    public static Fragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        ZhangDanFragment fragment = new ZhangDanFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
