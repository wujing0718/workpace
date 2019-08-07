package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.XingBie;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GeRenRenZhengActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edt_name,edt_youxiang,edt_shenfenzheng;
    private TextView tv_xingie,tv_shengri;
    private TextView bt_xingbie_xuanze,bt_shengri_xuanze;
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String xingbie = (String)msg.obj;
                    bt_xingbie_xuanze.setText(xingbie);
                    bt_xingbie_xuanze.setTextColor(getResources().getColor(R.color.colorBlack));
                    break;
                default:
                    break;
            }
        }
    };
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ge_ren_ren_zheng);
        id = MyApp.instance.getInt("id");
        initUI();
    }

    private void initUI() {
        edt_name = findViewById(R.id.edt_renzheng_name);
        tv_xingie = findViewById(R.id.bt_xingbie_xuanze);
        tv_shengri = findViewById(R.id.bt_shengri_xuanze);
        edt_youxiang = findViewById(R.id.edt_renzheng_youxiang);
        edt_shenfenzheng = findViewById(R.id.edt_renzheng_shenfenzheng);

        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_tijiao).setOnClickListener(this);
        bt_xingbie_xuanze = findViewById(R.id.bt_xingbie_xuanze);
        bt_xingbie_xuanze.setOnClickListener(this);
        bt_shengri_xuanze = findViewById(R.id.bt_shengri_xuanze);
        bt_shengri_xuanze.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_xingbie_xuanze:
                if (!utils.isDoubleClick()){
                    new XPopup.Builder(GeRenRenZhengActivity.this)
                            .asCustom(new XingBie(GeRenRenZhengActivity.this,mHandler))
                            .show();
                }
                break;
            case R.id.bt_shengri_xuanze:
                //时间选择器
                TimePickerView oldTime = new TimePickerBuilder(GeRenRenZhengActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        SimpleDateFormat formatter_day = new SimpleDateFormat("yyyy-MM-dd");
                        String format = formatter_day.format(date);
                        bt_shengri_xuanze.setText(format);
                        bt_shengri_xuanze.setTextColor(getResources().getColor(R.color.colorBlack));
                    }
                }).build();
                oldTime.show();
                break;
            case R.id.bt_chashi_renzheng:
                Intent intent = new Intent();
                startActivity(intent.setClass(GeRenRenZhengActivity.this,ChaShiRenZhengActivity.class));
                break;
            case R.id.bt_shanghu_renzheng:
                ToastUtils.showShort("456");
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_tijiao:
                initGeRen();
                break;
        }
    }

    private void initGeRen() {
        String name = edt_name.getText().toString();
        String xingbie = tv_xingie.getText().toString();
        String shengri = tv_shengri.getText().toString();
        String youxiang = edt_youxiang.getText().toString();
        String shenfenzheng = edt_shenfenzheng.getText().toString();
        if (!"".equals(name) || !name.isEmpty()){
            if (!"".equals(xingbie) || !xingbie.isEmpty()){
                if (!"".equals(shengri) || !shengri.isEmpty()){
                    if (!"".equals(youxiang) || !youxiang.isEmpty()){
                        if (RegexUtils.isEmail(youxiang)){
                            if (!"".equals(shenfenzheng) || !shenfenzheng.isEmpty()){
                                if (RegexUtils.isIDCard18Exact(shenfenzheng)){
                                    TiJiaoGeRen(name,xingbie,shengri,youxiang,shenfenzheng);
                                }else{
                                    ToastUtils.showShort("请输入正确身份证号");
                                }
                            }else{
                                ToastUtils.showShort("请输入身份证号");
                            }
                        }else{
                            ToastUtils.showShort("请输入正确邮箱");
                        }
                    }else{
                        ToastUtils.showShort("请输入邮箱");
                    }
                }else{
                    ToastUtils.showShort("请选择生日");
                }
            }else{
                ToastUtils.showShort("请选择性别");
            }
        }else{
            ToastUtils.showShort("请输入姓名");
        }
    }

    private void TiJiaoGeRen(String name, String xingbie, String shengri, String youxiang, String shenfenzheng) {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(id));
        map.put("realName",name);
        if ("男".equals(xingbie)) {
            map.put("gender","1");
        }else{
            map.put("gender","2");
        }
        map.put("birthday",shengri);
        map.put("email",youxiang);
        map.put("idCard",shenfenzheng);
        OkGo.<String>post(Contacts.URl1+"/my/verified")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort(jsonObject.getString("msg"));
                                Intent intent = new Intent();
                                intent.putExtra("code","个人认证成功");
                                intent.setClass(GeRenRenZhengActivity.this,SucceedViewActivity.class);
                                startActivity(intent);
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
