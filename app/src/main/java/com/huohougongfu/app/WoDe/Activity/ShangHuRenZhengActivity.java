package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
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
import com.huohougongfu.app.Utils.ImageUtils;
import com.huohougongfu.app.Utils.MyGlideEngine;
import com.huohougongfu.app.Utils.SDCardUtil;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.rong.imkit.utilities.RongUtils.screenHeight;
import static io.rong.imkit.utilities.RongUtils.screenWidth;

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
                    callGallery(1);
                }
                break;
            case R.id.img_reverse:
                if (!utils.isDoubleClick()) {
                    callGallery(2);
                }
                break;
            case R.id.img_yingyezhizhao:
                if (!utils.isDoubleClick()) {
                    callGallery(3);
                }
                break;
            case R.id.img_shouquan_photo:
                if (!utils.isDoubleClick()) {
                    callGallery(4);
                }
                break;
            case R.id.img_mentou_photo:
                if (!utils.isDoubleClick()) {
                    callGallery(5);
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

    /**
     * 调用图库选择
     */
    private void callGallery(int code){
        Matisse.from(this)
                .choose(MimeType.of(MimeType.JPEG, MimeType.PNG, MimeType.GIF))//照片视频全部显示MimeType.allOf()
                .countable(true)//true:选中后显示数字;false:选中后显示对号
                .maxSelectable(1)//最大选择数量为9
                //.addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
//                .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))//图片显示表格的大小
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_USER)//图像选择和预览活动所需的方向
                .theme(R.style.Matisse_Zhihu)//主题  暗色主题 R.style.Matisse_Dracula
                .imageEngine(new MyGlideEngine())//图片加载方式，Glide4需要自定义实现
                .capture(true) //是否提供拍照功能，兼容7.0系统需要下面的配置
                //参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                .captureStrategy(new CaptureStrategy(true,"com.huohougongfu.app.FileProvider"))//存储到哪里
                .forResult(code);//请求码
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
                        WaitDialog.dismiss();
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

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(ShangHuRenZhengActivity.this,"请稍后。。。");
                        super.onStart(request);
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
                    Positive(data);
                    break;
                case 2:
                    // 图片选择结果回调
                    Reverse(data);
                    break;
                case 3:
                    // 图片选择结果回调
                    YinYwZhiZhao(data);
                    break;
                case 4:
                    // 图片选择结果回调
                    ShouQuan(data);
                    break;
                case 5:
                    // 图片选择结果回调
                    MenTou(data);
                    break;
            }
        }
    }

    private void ShouQuan(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(ShangHuRenZhengActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //Log.e(TAG, "###path=" + imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            shouquanPath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
            shouquanFile.add(new File(shouquanPath));
                Glide.with(ShangHuRenZhengActivity.this).load(shouquanPath).into(img_shouquan_photo);
        }
    }

    private void MenTou(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(ShangHuRenZhengActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //Log.e(TAG, "###path=" + imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            mentouPath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
                mentouFile.add(new File(mentouPath));
                Glide.with(ShangHuRenZhengActivity.this).load(mentouPath).into(img_mentou_photo);
        }
    }

    private void YinYwZhiZhao(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(ShangHuRenZhengActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //Log.e(TAG, "###path=" + imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            zhizhaoPath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
                zhizhaoFile.add(new File(zhizhaoPath));
                Glide.with(ShangHuRenZhengActivity.this).load(zhizhaoPath).into(img_yingyezhizhao);
            }
    }

    private void Reverse(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(ShangHuRenZhengActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //Log.e(TAG, "###path=" + imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            reversePath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
                shenfenFile.add(new File(reversePath));
                Glide.with(ShangHuRenZhengActivity.this).load(reversePath).into(img_reverse);
        }
    }

    private void Positive(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(ShangHuRenZhengActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //Log.e(TAG, "###path=" + imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            positivePath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
                shenfenFile.add(new File(positivePath));
                Glide.with(ShangHuRenZhengActivity.this).load(positivePath).into(img_positive);
        }
    }
}
