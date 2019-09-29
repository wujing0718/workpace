package com.huohougongfu.app.QuanZi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.MultiLineRadioGroup;
import com.huohougongfu.app.Utils.MyRadioGroup;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JuBaoActivity extends AppCompatActivity implements View.OnClickListener{

    private String dataId;
    private String username,photo,title;
//    private MultiLineRadioGroup radio_jubao;
    private TextView tv_tousu_usrname,tv_tousu_title;
    private ImageView img_tousu_photo;
    private EditText edt_phone;
    private String phone;
    private String token;
    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();
    private String[] titles = new String[]{"垃圾营销","色情低俗","虚假欺骗","广告骚扰","政治敏感","违法信息","侵权投诉","违禁内容","其他违规"};
    private CheckBox radio_button1,radio_button2,radio_button3,radio_button4,radio_button5,radio_button6,radio_button7,radio_button8,radio_button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_bao);
        dataId = getIntent().getStringExtra("dataId");
        username = getIntent().getStringExtra("username");
        title = getIntent().getStringExtra("title");
        photo = getIntent().getStringExtra("photo");
        token = MyApp.instance.getString("token");
        initUI();
    }

    private void initUI() {
//         radio_jubao = findViewById(R.id.radio_jubao);
////        radio_jubao.setOnCheckedChangeListener(this);
        radio_button1 = findViewById(R.id.radio_button1);
        radio_button2 = findViewById(R.id.radio_button2);
        radio_button3 = findViewById(R.id.radio_button3);
        radio_button4 = findViewById(R.id.radio_button4);
        radio_button5 = findViewById(R.id.radio_button5);
        radio_button6 = findViewById(R.id.radio_button6);
        radio_button7 = findViewById(R.id.radio_button7);
        radio_button8 = findViewById(R.id.radio_button8);
        radio_button9 = findViewById(R.id.radio_button9);
        radio_button1.setOnCheckedChangeListener(cb);
        radio_button2.setOnCheckedChangeListener(cb);
        radio_button3.setOnCheckedChangeListener(cb);
        radio_button4.setOnCheckedChangeListener(cb);
        radio_button5.setOnCheckedChangeListener(cb);
        radio_button6.setOnCheckedChangeListener(cb);
        radio_button7.setOnCheckedChangeListener(cb);
        radio_button8.setOnCheckedChangeListener(cb);
        radio_button9.setOnCheckedChangeListener(cb);
        checkBoxList.add(radio_button1);
        checkBoxList.add(radio_button2);
        checkBoxList.add(radio_button3);
        checkBoxList.add(radio_button4);
        checkBoxList.add(radio_button5);
        checkBoxList.add(radio_button6);
        checkBoxList.add(radio_button7);
        checkBoxList.add(radio_button8);
        checkBoxList.add(radio_button9);

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
                StringBuffer sb = new StringBuffer();
                phone = edt_phone.getText().toString();
                for (int i = 0; i < checkBoxList.size(); i++) {
                    CheckBox checkBox = checkBoxList.get(i);
                    if (checkBox.isChecked()){
                        sb.append(i + ",");
                    }
                }
                if (!utils.isDoubleClick()){
                    if (!sb.toString().isEmpty()){
                        if (!phone.isEmpty()){
                            //遍历集合中的checkBox,判断是否选择，获取选中的文本
                            initTiJiao(sb);
                        }else{
                            ToastUtils.showShort("请输入备注");
                        }
                    }else{
                        ToastUtils.showShort("至少选择一个投诉类型");
                    }
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
        }
    }

    private void initTiJiao(StringBuffer sb) {
        String type = sb.substring(0, sb.toString().length() - 1);
        Map<String,String> map = new HashMap<>();
        map.put("dataId",dataId);
        map.put("type",String.valueOf(type));
        map.put("tel",phone);
        map.put("token",token);
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

    private CompoundButton.OnCheckedChangeListener cb = new CompoundButton.OnCheckedChangeListener() { //实例化一个cb
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        }
    };

}
