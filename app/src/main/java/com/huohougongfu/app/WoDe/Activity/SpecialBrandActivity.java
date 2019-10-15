package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
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
import com.huohougongfu.app.Utils.ImageUtils;
import com.huohougongfu.app.Utils.MyGlideEngine;
import com.huohougongfu.app.Utils.SDCardUtil;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
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
import java.util.List;

import static io.rong.imkit.utilities.RongUtils.screenHeight;
import static io.rong.imkit.utilities.RongUtils.screenWidth;

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
        findViewById(R.id.bt_finish).setOnClickListener(this);
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
                    callGallery(1);
                }
                break;
            case R.id.img_qita_zizhi:
                if (!utils.isDoubleClick()) {
                    callGallery(2);
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
            case R.id.bt_finish:
                finish();
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

    private void initSpecialBrand() {
        OkGo.<String>post(Contacts.URl1+"/my/brandCertification")
                .tag(this)
                .isMultipart(true)
                .params("mId",MyApp.instance.getInt("id"))
                .addFileParams("pictureFiles",shenfenFile)
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
                                intent.setClass(SpecialBrandActivity.this,ReviewViewActivity.class);
                                startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(SpecialBrandActivity.this,"请稍后。。。");
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
                    ShangBiao(data);
                    break;
                case 2:
                    // 图片选择结果回调
                    QiTaZiZhi(data);
                    break;
            }
        }
    }

    private void QiTaZiZhi(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(SpecialBrandActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            qitazizhiPath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
                shenfenFile.add(new File(qitazizhiPath));
                Glide.with(SpecialBrandActivity.this).load(qitazizhiPath).into(img_qita_zizhi);
            }
    }

    private void ShangBiao(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(SpecialBrandActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            shangbiaoPath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
            shenfenFile.add(new File(shangbiaoPath));
            Glide.with(SpecialBrandActivity.this).load(shangbiaoPath).into(img_shangbiao);
        }
    }
}
