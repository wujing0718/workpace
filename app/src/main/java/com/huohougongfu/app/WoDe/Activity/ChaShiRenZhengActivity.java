package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.huohougongfu.app.Activity.FaBuArticleActivity;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.VedioDetailActivity;
import com.huohougongfu.app.R;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.MultiLineRadioGroup;
import com.huohougongfu.app.Utils.utils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChaShiRenZhengActivity extends AppCompatActivity implements View.OnClickListener ,MultiLineRadioGroup.OnCheckedChangeListener{

    private TagFlowLayout id_flowlayout_zhicheng;
    private List<String> datas_zhicheng = new ArrayList<>();
    private TagAdapter<String> zhichengadapter;
    private int id;
    private RadioButton pingchashi,zhichashi,radio_chayishi,jiangren,radio_qita;
    private EditText edt_zhicheng_qita,edt_shanchang_qita;
    private String level = "";
    private String specialty_baicha = "";
    private String specialty_lvhca = "";
    private String specialty_huangcha = "";
    private String specialty_wulongcha = "";
    private String specialty_hongcha = "";
    private String specialty_heicha = "";
    private String specialty_qita = "";

    private CheckBox check_baicha,check_lvcha,check_huangcha,check_wulongcha,check_hongcha,check_heicha,check_qita;
    private MultiLineRadioGroup radio_zhicheng;
    private ImageView img_positive,img_reverse,img_qitazizhi,img_yingyezizhi;
    private String positivePath,reversePath,yingyezizhiPath,qitazizhiPath;
    private ArrayList<File> shenfenFile = new ArrayList<>();
    private ArrayList<File> zizhiFile = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha_shi_ren_zheng);
        id = MyApp.instance.getInt("id");
        initUI();
    }

    private void initUI() {
        img_positive = findViewById(R.id.img_positive);
        img_reverse = findViewById(R.id.img_reverse);
        img_positive.setOnClickListener(this);
        img_reverse.setOnClickListener(this);
        img_yingyezizhi = findViewById(R.id.img_yingyezizhi);
        img_qitazizhi = findViewById(R.id.img_qitazizhi);
        img_yingyezizhi.setOnClickListener(this);
        img_qitazizhi.setOnClickListener(this);

        findViewById(R.id.bt_chashi_tijiao).setOnClickListener(this);
        radio_zhicheng = findViewById(R.id.radio_zhicheng);
        radio_zhicheng.setOnCheckedChangeListener(this);
        OnBoxClickListener onBoxClickListener = new OnBoxClickListener();
        edt_zhicheng_qita = findViewById(R.id.edt_zhicheng_qita);
        pingchashi = findViewById(R.id.radio_pingchashi);
        zhichashi = findViewById(R.id.radio_zhichashi);
        radio_chayishi = findViewById(R.id.radio_chayishi);
        jiangren = findViewById(R.id.radio_jiangren);
        radio_qita = findViewById(R.id.radio_qita);
        check_baicha = findViewById(R.id.check_baicha);
        check_lvcha = findViewById(R.id.check_lvcha);
        check_huangcha = findViewById(R.id.check_huangcha);
        check_wulongcha = findViewById(R.id.check_wulongcha);
        check_hongcha = findViewById(R.id.check_hongcha);
        check_heicha = findViewById(R.id.check_heicha);
        check_qita = findViewById(R.id.check_qita);

        edt_shanchang_qita = findViewById(R.id.edt_shanchang_qita);
        check_baicha.setOnCheckedChangeListener(onBoxClickListener);
        check_lvcha.setOnCheckedChangeListener(onBoxClickListener);
        check_huangcha.setOnCheckedChangeListener(onBoxClickListener);
        check_wulongcha.setOnCheckedChangeListener(onBoxClickListener);
        check_hongcha.setOnCheckedChangeListener(onBoxClickListener);
        check_heicha.setOnCheckedChangeListener(onBoxClickListener);

        edt_zhicheng_qita.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().isEmpty()){
                    radio_qita.setChecked(true);
                }else{
                    radio_qita.setChecked(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt_shanchang_qita.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().isEmpty()){
                    check_qita.setChecked(true);
                }else{
                    check_qita.setChecked(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        findViewById(R.id.bt_finish).setOnClickListener(this);
    }
    class OnBoxClickListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (check_baicha.isChecked()){
                specialty_baicha = check_baicha.getText().toString();
            }else{
                specialty_baicha = "";
            }
            if (check_lvcha.isChecked()){
                specialty_lvhca = check_lvcha.getText().toString();
            }else{
                specialty_lvhca = "";
            }
            if (check_huangcha.isChecked()){
                specialty_huangcha = check_huangcha.getText().toString();
            }else{
                specialty_huangcha = "";
            }
            if (check_wulongcha.isChecked()){
                specialty_wulongcha = check_wulongcha.getText().toString();
            }else{
                specialty_wulongcha = "";
            }
            if (check_hongcha.isChecked()){
                specialty_hongcha = check_hongcha.getText().toString();
            }else{
                specialty_hongcha = "";
            }
            if (check_heicha.isChecked()){
                specialty_heicha = check_heicha.getText().toString();
            }else{
                specialty_heicha ="";
            }
            if (check_qita.isChecked()){
                specialty_qita = edt_shanchang_qita.getText().toString();
            }else{
                specialty_qita = "";
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.img_reverse:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,2);
                }
                break;
            case R.id.img_positive:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,1);
                }
                break;
            case R.id.img_yingyezizhi:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,3);
                }
                break;
            case R.id.img_qitazizhi:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,4);
                }
                break;
            case R.id.bt_chashi_tijiao:
                Map <String,String> map = new HashMap<>();
                StringBuilder stringBuilder = new StringBuilder();
                if (!"".equals(specialty_baicha)){
                    stringBuilder.append(specialty_baicha+",");
                }
                if (!"".equals(specialty_lvhca)){
                    stringBuilder.append(specialty_lvhca+",");
                }
                if (!"".equals(specialty_huangcha)){
                    stringBuilder.append(specialty_huangcha+",");
                }
                if (!"".equals(specialty_wulongcha)){
                    stringBuilder.append(specialty_wulongcha+",");
                }
                if (!"".equals(specialty_hongcha)){
                    stringBuilder.append(specialty_hongcha+",");
                }
                if (!"".equals(specialty_heicha)){
                    stringBuilder.append(specialty_heicha+",");
                }
                if (!"".equals(specialty_qita)){
                    stringBuilder.append(specialty_qita+",");
                }
                if (!"".equals(stringBuilder.toString())){
                    String specialty = stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
                    if (!"".equals(level)){
                        if (!"".equals(specialty)){
                            if (positivePath!=null){
                                if (reversePath!=null){
                                    if (yingyezizhiPath!=null){
                                        map.put("specialty",specialty);
                                        map.put("level",level);
                                        map.put("mId",String.valueOf(id));
                                        initData(map);
                                    }else{
                                        ToastUtils.showShort("请上传资格证书");
                                    }
                                }else{
                                    ToastUtils.showShort("请上传背面面照");
                                }
                            }else{
                                ToastUtils.showShort("请上传正面照");
                            }
                        }else{
                            ToastUtils.showShort("请选择擅长类目");
                        }

                    }else{
                        ToastUtils.showShort("请选择职称");
                    }
                }else{
                    ToastUtils.showShort("选择内容不能为空");
                }
                break;
        }
    }

    private void initData(Map<String, String> map) {
        OkGo.<String>post(Contacts.URl1+"/my/teaMasterCertification")
                .tag(this)
                .isMultipart(true)
                .params(map)
                .addFileParams("idCardFile",shenfenFile)
                .addFileParams("qualificationFile",zizhiFile)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                finish();
                                Intent intent = new Intent();
                                intent.setClass(ChaShiRenZhengActivity.this,ReviewViewActivity.class);
                                startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    // 图片选择结果回调
                    refreshAdapter(PictureSelector.obtainMultipleResult(data));
                    break;
                case 2:
                    // 图片选择结果回调
                    refreshAdapter2(PictureSelector.obtainMultipleResult(data));
                    break;
                case 3:
                    // 图片选择结果回调
                    yingyezizhi(PictureSelector.obtainMultipleResult(data));
                    break;
                case 4:
                    // 图片选择结果回调
                    qitazizhi(PictureSelector.obtainMultipleResult(data));
                    break;
            }
        }
    }

    private void qitazizhi(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                qitazizhiPath = localMedia.getCompressPath(); //压缩后的图片路径
                zizhiFile.add(new File(qitazizhiPath));
                Glide.with(ChaShiRenZhengActivity.this).load(qitazizhiPath).into(img_qitazizhi);
            }
        }
    }

    private void yingyezizhi(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                yingyezizhiPath = localMedia.getCompressPath(); //压缩后的图片路径
                zizhiFile.add(new File(yingyezizhiPath));
                Glide.with(ChaShiRenZhengActivity.this).load(yingyezizhiPath).into(img_yingyezizhi);
            }
        }
    }

    private void refreshAdapter(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                positivePath = localMedia.getCompressPath(); //压缩后的图片路径
                shenfenFile.add(new File(positivePath));
                Glide.with(ChaShiRenZhengActivity.this).load(positivePath).into(img_positive);
            }
        }
    }

    private void refreshAdapter2(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                reversePath = localMedia.getCompressPath(); //压缩后的图片路径
                shenfenFile.add(new File(reversePath));
                Glide.with(ChaShiRenZhengActivity.this).load(reversePath).into(img_reverse);
            }
        }
    }



    @Override
    public void onCheckedChanged(MultiLineRadioGroup group, int checkedId) {
        switch (checkedId){
            case  R.id.radio_pingchashi:
                level = "评茶师";
                break;
            case  R.id.radio_zhichashi:
                level = "制茶师";
                break;
            case  R.id.radio_chayishi:
                level = "茶艺师";
                break;
            case  R.id.radio_jiangren:
                level = "匠人";
                break;
            case  R.id.radio_qita:
                level = edt_zhicheng_qita.getText().toString();
                break;

        }
    }
}
