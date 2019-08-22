package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.BankLIst;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShangHuRenZhengActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_positive,img_reverse,img_yingyezhizhao,img_mentou_photo,img_shouquan_photo;
    private EditText edt_dianpu_name,edt_kaihu_name,edt_kaihu_kahao;
    private String positivePath,reversePath,zhizhaoPath,mentouPath,shouquanPath;
    private ArrayList<File> shenfenFile = new ArrayList<>();
    private ArrayList<File> zhizhaoFile = new ArrayList<>();
    private ArrayList<File> mentouFile = new ArrayList<>();
    private ArrayList<File> shouquanFile = new ArrayList<>();
    private TextView tv_kaihu_yinhang;
    private String[] blank = new String[]{};
    private String dianpu_name,kaihu_name,kaihu_kahao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shang_hu_ren_zheng);
        ininUI();
        initbankList();
    }

    private void initbankList() {
        OkGo.<String>get(Contacts.URl1+"/my/bankList")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        BankLIst bankLIst = gson.fromJson(body, BankLIst.class);
                        if (bankLIst.getStatus() == 1){
                            for(int i=0;i<bankLIst.getResult().size();i++)    //在链接好数据库的实战中，这个地方2可以改为re.length
                            {
                                blank = Arrays.copyOf(blank, blank.length+1);
                                blank[blank.length-1] = bankLIst.getResult().get(i).getBankName(); //在链接好数据库的实战中，这个地方第一行可以改为re.title
                            }
                        }
                    }
                });

    }

    private void ininUI() {
        img_positive = findViewById(R.id.img_positive);
        img_reverse = findViewById(R.id.img_reverse);
        edt_dianpu_name = findViewById(R.id.edt_dianpu_name);
        edt_kaihu_name = findViewById(R.id.edt_kaihu_name);
        edt_kaihu_kahao = findViewById(R.id.edt_kaihu_kahao);
        img_yingyezhizhao = findViewById(R.id.img_yingyezhizhao);
        img_mentou_photo = findViewById(R.id.img_mentou_photo);
        img_shouquan_photo = findViewById(R.id.img_shouquan_photo);
        tv_kaihu_yinhang = findViewById(R.id.tv_kaihu_yinhang);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_shanghu_tijiao).setOnClickListener(this);
        findViewById(R.id.bt_kaihu_yinhang).setOnClickListener(this);
        img_yingyezhizhao.setOnClickListener(this);
        img_mentou_photo.setOnClickListener(this);
        img_shouquan_photo.setOnClickListener(this);

        img_positive.setOnClickListener(this);
        img_reverse.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.img_positive:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,1);
                }
                break;
            case R.id.img_reverse:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,2);
                }
                break;
            case R.id.img_yingyezhizhao:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,3);
                }
                break;
            case R.id.img_shouquan_photo:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,4);
                }
                break;
            case R.id.img_mentou_photo:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initSingleConfig(this,5);
                }
                break;
            case R.id.bt_shanghu_tijiao:
                dianpu_name = edt_dianpu_name.getText().toString();
                kaihu_name = edt_kaihu_name.getText().toString();
                kaihu_kahao = edt_kaihu_kahao.getText().toString();
                if (positivePath!=null){
                    if (reversePath!=null){
                        if (!dianpu_name.isEmpty()){
                            if (zhizhaoPath!=null){
                                if (mentouPath!=null){
                                    if (!kaihu_name.isEmpty()){
                                        if (!kaihu_kahao.isEmpty()){
                                            if (utils.checkBankCard(kaihu_kahao)){
                                                if (!tv_kaihu_yinhang.getText().toString().equals("请选择开户银行")){
                                                    initShangHu();
                                                }else{
                                                    ToastUtils.showShort("请选择开户银行");
                                                }
                                            }else{
                                                ToastUtils.showShort("请输入正确银行卡号");
                                            }
                                        }else{
                                            ToastUtils.showShort("请输入银行卡号");
                                        }
                                    }else{
                                        ToastUtils.showShort("请输入银行开户名");
                                    }
                                }else{
                                    ToastUtils.showShort("请上传门头照片");
                                }
                            }else{
                                ToastUtils.showShort("请上传执照");
                            }
                        }else{
                            ToastUtils.showShort("请输入店铺名");
                        }
                    }else{
                        ToastUtils.showShort("请上传背面照");
                    }
                }else{
                    ToastUtils.showShort("请上传正面照");
                }
                break;
            case R.id.bt_kaihu_yinhang:
                new XPopup.Builder(ShangHuRenZhengActivity.this)
//                        .enableDrag(false)
                        .offsetY(400)
                        .asBottomList("",blank, new OnSelectListener() {
                                    @Override
                                    public void onSelect(int position, String text) {
                                        tv_kaihu_yinhang.setText(text);
                                    }
                                })
                        .show();
                break;
        }
    }

    private void initShangHu() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
        map.put("storeName",dianpu_name);
        map.put("accountName",kaihu_name);
        map.put("bankCardNo",kaihu_kahao);
        map.put("bankName",tv_kaihu_yinhang.getText().toString());
        OkGo.<String>post(Contacts.URl1+"/my/storeCertification")
                .tag(this)
                .isMultipart(true)
                .params(map)
                .addFileParams("idCardFile",shenfenFile)
                .addFileParams("businessLicenseFile",zhizhaoFile)
                .addFileParams("doorPhotoFile",mentouFile)
                .addFileParams("authorizationFile",shouquanFile)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                finish();
                                Intent intent = new Intent();
                                intent.setClass(ShangHuRenZhengActivity.this,ReviewViewActivity.class);
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
                    Positive(PictureSelector.obtainMultipleResult(data));
                    break;
                case 2:
                    // 图片选择结果回调
                    Reverse(PictureSelector.obtainMultipleResult(data));
                    break;
                case 3:
                    // 图片选择结果回调
                    YinYwZhiZhao(PictureSelector.obtainMultipleResult(data));
                    break;
                case 4:
                    // 图片选择结果回调
                    ShouQuan(PictureSelector.obtainMultipleResult(data));
                    break;
                case 5:
                    // 图片选择结果回调
                    MenTou(PictureSelector.obtainMultipleResult(data));
                    break;
            }
        }
    }

    private void ShouQuan(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                shouquanPath = localMedia.getCompressPath(); //压缩后的图片路径
                shouquanFile.add(new File(shouquanPath));
                Glide.with(ShangHuRenZhengActivity.this).load(shouquanPath).into(img_shouquan_photo);
            }
        }
    }

    private void MenTou(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                mentouPath = localMedia.getCompressPath(); //压缩后的图片路径
                mentouFile.add(new File(mentouPath));
                Glide.with(ShangHuRenZhengActivity.this).load(mentouPath).into(img_mentou_photo);
            }
        }
    }

    private void YinYwZhiZhao(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                zhizhaoPath = localMedia.getCompressPath(); //压缩后的图片路径
                zhizhaoFile.add(new File(zhizhaoPath));
                Glide.with(ShangHuRenZhengActivity.this).load(zhizhaoPath).into(img_yingyezhizhao);
            }
        }
    }

    private void Reverse(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                reversePath = localMedia.getCompressPath(); //压缩后的图片路径
                shenfenFile.add(new File(reversePath));
                Glide.with(ShangHuRenZhengActivity.this).load(reversePath).into(img_reverse);
            }
        }
    }

    private void Positive(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                positivePath = localMedia.getCompressPath(); //压缩后的图片路径
                shenfenFile.add(new File(positivePath));
                Glide.with(ShangHuRenZhengActivity.this).load(positivePath).into(img_positive);
            }
        }
    }
}
