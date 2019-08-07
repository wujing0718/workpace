package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SpecialBrandActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_shangbiao,img_qita_zizhi;
    private TextView bt_special_tijiao;
    private String shangbiaoPath;
    private String qitazizhiPath;
    private ArrayList<File> shenfenFile = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_brand);
        initUI();
    }

    private void initUI() {
        img_shangbiao = findViewById(R.id.img_shangbiao);
        img_qita_zizhi = findViewById(R.id.img_qita_zizhi);
        img_shangbiao.setOnClickListener(this);
        img_qita_zizhi.setOnClickListener(this);
        bt_special_tijiao = findViewById(R.id.bt_special_tijiao);
        bt_special_tijiao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_shangbiao:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,1);
                }
                break;
            case R.id.img_qita_zizhi:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,2);
                }
                break;
            case R.id.bt_special_tijiao:
                if (!utils.isDoubleClick()){
                    if (shangbiaoPath!=null){
                        initSpecialBrand();
                    }else{
                        ToastUtils.showShort("请上传商标证明");
                    }
                }
                break;
        }
    }

    private void initSpecialBrand() {
        OkGo.<String>post(Contacts.URl1+"/my/brandCertification")
                .tag(this)
                .isMultipart(true)
                .params("mId",MyApp.instance.getInt("id"))
                .addFileParams("pictureFiles",shenfenFile)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                finish();
                                Intent intent = new Intent();
                                intent.setClass(SpecialBrandActivity.this,ReviewViewActivity.class);
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
                    ShangBiao(PictureSelector.obtainMultipleResult(data));
                    break;
                case 2:
                    // 图片选择结果回调
                    QiTaZiZhi(PictureSelector.obtainMultipleResult(data));
                    break;
            }
        }
    }

    private void QiTaZiZhi(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                qitazizhiPath = localMedia.getCompressPath(); //压缩后的图片路径
                shenfenFile.add(new File(qitazizhiPath));
                Glide.with(SpecialBrandActivity.this).load(qitazizhiPath).into(img_qita_zizhi);
            }
        }
    }

    private void ShangBiao(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                shangbiaoPath = localMedia.getCompressPath(); //压缩后的图片路径
                shenfenFile.add(new File(shangbiaoPath));
                Glide.with(SpecialBrandActivity.this).load(shangbiaoPath).into(img_shangbiao);
            }
        }
    }
}
