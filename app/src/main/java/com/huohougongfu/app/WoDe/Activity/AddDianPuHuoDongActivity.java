package com.huohougongfu.app.WoDe.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.OKGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AddDianPuHuoDongActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_endtime,tv_starttime;
    private EditText edt_huodong_name,tv_reduceNumber,tv_fullAmount;
    private String huodongname,starttime,endtime,reduceNumber,fullAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dian_pu_huo_dong);
        initUI();
    }

    private void initUI() {
        tv_starttime = findViewById(R.id.tv_starttime);
        tv_endtime = findViewById(R.id.tv_endtime);
        edt_huodong_name = findViewById(R.id.edt_huodong_name);
        tv_reduceNumber = findViewById(R.id.tv_reduceNumber);
        tv_fullAmount = findViewById(R.id.tv_fullAmount);

        findViewById(R.id.tv_guanli).setOnClickListener(this);
        findViewById(R.id.starttime).setOnClickListener(this);
        findViewById(R.id.oldertime).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_wancheng).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.starttime:
                //时间选择器
                TimePickerView staTime = new TimePickerBuilder(AddDianPuHuoDongActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String nowTime2 = utils.getNowTime4();
                        SimpleDateFormat formatter_day = new SimpleDateFormat("yyyy-MM-dd");
                        String format = formatter_day.format(date);
                        tv_starttime.setText(format);
                    }
                }).build();
                staTime.show();
                break;
            case R.id.oldertime:
                //时间选择器
                TimePickerView oldTime = new TimePickerBuilder(AddDianPuHuoDongActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        String nowTime2 = utils.getNowTime4();
                        SimpleDateFormat formatter_day = new SimpleDateFormat("yyyy-MM-dd");
                        String format = formatter_day.format(date);
                        tv_endtime.setText(format);
                    }
                }).build();
                oldTime.show();
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_wancheng:
                break;
            case R.id.tv_guanli:
                huodongname = edt_huodong_name.getText().toString();
                starttime = tv_starttime.getText().toString();
                endtime = tv_endtime.getText().toString();
                reduceNumber = tv_reduceNumber.getText().toString();
                fullAmount = tv_fullAmount.getText().toString();
                if (!huodongname.isEmpty()){
                    if (!starttime.isEmpty()){
                        if (!endtime.isEmpty()){
                            if (!fullAmount.isEmpty()){
                                if (!reduceNumber.isEmpty()){
                                    initAdd();
                                }else{
                                    ToastUtils.showShort("请输入满减金额");
                                }
                            }else{
                                ToastUtils.showShort("请输入满减条件");
                            }
                        }else{
                            ToastUtils.showShort("请选择活动结束时间");
                        }
                    }else{
                        ToastUtils.showShort("请选择活动开始时间");
                    }
                }else{
                    ToastUtils.showShort("请输入店铺活动");
                }
                break;
        }
    }

    private void initAdd() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("activeName",huodongname);
        map.put("beginTime",starttime);
        map.put("endTime",endtime);
        map.put("reduceNumber",tv_reduceNumber.getText().toString());
        map.put("fullAmount",tv_fullAmount.getText().toString());
        OkGo.<String>post(Contacts.URl1+"/store/addActive")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        OKGson okGson = gson.fromJson(response.body(), OKGson.class);
                        if (okGson.getStatus() == 1){
                            finish();
                            ToastUtils.showShort("添加成功");
                        }else{
                            ToastUtils.showShort(okGson.getMsg());
                        }
                    }
                });
    }
}
