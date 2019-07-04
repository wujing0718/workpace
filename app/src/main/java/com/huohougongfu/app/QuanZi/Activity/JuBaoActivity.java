package com.huohougongfu.app.QuanZi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.MultiLineRadioGroup;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JuBaoActivity extends AppCompatActivity implements MultiLineRadioGroup.OnCheckedChangeListener,View.OnClickListener {

    private int dataId;
    private String username,photo,title;
    private MultiLineRadioGroup radio_jubao;
    private TextView tv_tousu_usrname,tv_tousu_title;
    private ImageView img_tousu_photo;
    private  int type = 0;
    private EditText edt_phone;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_bao);
        dataId = getIntent().getIntExtra("dataId", 0);
        username = getIntent().getStringExtra("username");
        title = getIntent().getStringExtra("title");
        photo = getIntent().getStringExtra("photo");

        initUI();
    }

    private void initUI() {
         radio_jubao = findViewById(R.id.radio_jubao);
        radio_jubao.setOnCheckedChangeListener(this);
        findViewById(R.id.bt_tijiao).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        tv_tousu_usrname = findViewById(R.id.tv_tousu_usrname);
        tv_tousu_title = findViewById(R.id.tv_tousu_title);
        img_tousu_photo = findViewById(R.id.img_tousu_photo);
        edt_phone = findViewById(R.id.edt_phone);
        tv_tousu_usrname.setText(username);
        tv_tousu_title.setText(title);
        String[] split = photo.split(",");
        if (split.length>0){
            Glide.with(JuBaoActivity.this).load(split[0]).into(img_tousu_photo);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_tijiao:
                phone = edt_phone.getText().toString();
                if (!utils.isDoubleClick()){
                    if (type != 0){
                        if (!phone.isEmpty()){
                            if (RegexUtils.isMobileExact(phone)){
                                initTiJiao();
                            }else{
                                ToastUtils.showShort("请输入正确手机号");
                            }
                        }else{
                            ToastUtils.showShort("请输入您的手机号");
                        }
                    }else{
                        ToastUtils.showShort("请选择投诉类型");
                    }
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
        }
    }

    private void initTiJiao() {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(dataId));
        map.put("type",String.valueOf(type));
        map.put("tel",phone);
        OkGo.<String>post(Contacts.URl1+"/circle/report")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort("举报成功");
                                finish();
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void onCheckedChanged(MultiLineRadioGroup group, int checkedId) {
        switch (checkedId){
           case  R.id.radiobutton1:
               type = 1;
               break;
            case  R.id.radiobutton2:
                type = 2;
                break;
            case  R.id.radiobutton3:
                type = 3;
                break;
            case  R.id.radiobutton4:
                type = 4;
                break;
            case  R.id.radiobutton5:
                type = 5;
                break;
            case  R.id.radiobutton6:
                type = 6;
                break;
            case  R.id.radiobutton7:
                type = 7;
                break;
            case  R.id.radiobutton8:
                type = 8;
                break;
            case  R.id.radiobutton9:
                type = 9;
                break;

        }
    }
}
