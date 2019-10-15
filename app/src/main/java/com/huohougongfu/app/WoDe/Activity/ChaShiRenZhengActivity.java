package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
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
import com.bumptech.glide.request.RequestOptions;
import com.huohougongfu.app.Activity.FaBuActivity;
import com.huohougongfu.app.Activity.FaBuArticleActivity;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.QuanZi.Activity.VedioDetailActivity;
import com.huohougongfu.app.R;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.ImageUtils;
import com.huohougongfu.app.Utils.MultiLineRadioGroup;
import com.huohougongfu.app.Utils.MyGlideEngine;
import com.huohougongfu.app.Utils.SDCardUtil;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;
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

import static io.rong.imkit.utilities.RongUtils.screenHeight;
import static io.rong.imkit.utilities.RongUtils.screenWidth;

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
    private ArrayList<File> xingxiangFile = new ArrayList<>();
    private ImageView img_xingxiang;
    private String xingxiangpath;
    private String chashi_qita;


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
        img_xingxiang = findViewById(R.id.img_xingxiang);
        img_xingxiang.setOnClickListener(this);
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

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()){
                    radio_qita.setChecked(true);
                }else{
                    radio_qita.setChecked(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt_shanchang_qita.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()){
                    check_qita.setChecked(true);
                }else{
                    check_qita.setChecked(false);
                }
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
                    callGallery(2);
                }
                break;
            case R.id.img_positive:
                if (!utils.isDoubleClick()) {
                    callGallery(1);
                }
                break;
            case R.id.img_yingyezizhi:
                if (!utils.isDoubleClick()) {
                    callGallery(3);
                }
                break;
            case R.id.img_qitazizhi:
                if (!utils.isDoubleClick()) {
                    callGallery(4);
                }
                break;
            case R.id.img_xingxiang:
                if (!utils.isDoubleClick()) {
                    callGallery(5);
                }
                break;
            case R.id.bt_chashi_tijiao:
                if (check_qita.isChecked()){
                    specialty_qita = edt_shanchang_qita.getText().toString();
                }else{
                    specialty_qita = "";
                }
                if (radio_qita.isChecked()){
                    chashi_qita = edt_zhicheng_qita.getText().toString();
                }else{
                    chashi_qita = "";
                }
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
                if (radio_qita.isChecked()){
                    level = edt_zhicheng_qita.getText().toString();
                }
                    if (!"".equals(stringBuilder.toString())){
                        String specialty = stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
                        if (!"".equals(level)){
                            if (!"".equals(specialty)){
                                if (positivePath!=null){
                                    if (reversePath!=null){
                                        if (xingxiangpath !=null){
                                            if (yingyezizhiPath!=null){
                                                map.put("specialty",specialty);
                                                map.put("level",level);
                                                map.put("mId",String.valueOf(id));
                                                initData(map);
                                            }else{
                                                ToastUtils.showShort("请上传资格证书");
                                            }
                                        }else{
                                            ToastUtils.showShort("请上传形象照片");
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
                        ToastUtils.showShort("擅长内容不能为空");
                    }
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

    private void initData(Map<String, String> map) {
        OkGo.<String>post(Contacts.URl1+"/my/teaMasterCertification")
                .tag(this)
                .isMultipart(true)
                .params(map)
                .addFileParams("idCardFile",shenfenFile)
                .addFileParams("qualificationFile",zizhiFile)
                .addFileParams("portrait",xingxiangFile)
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
                                intent.setClass(ChaShiRenZhengActivity.this,ReviewViewActivity.class);
                                startActivity(intent);
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(ChaShiRenZhengActivity.this,"请稍后。。。");
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
                    refreshAdapter(data);
                    break;
                case 2:
                    // 图片选择结果回调
                    refreshAdapter2(data);
                    break;
                case 3:
                    // 图片选择结果回调
                    yingyezizhi(data);
                    break;
                case 4:
                    // 图片选择结果回调
                    qitazizhi(data);
                    break;
                case 5:
                    // 图片选择结果回调
                    xingxiang(data);
                    break;
            }
        }
    }

    private void xingxiang(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(ChaShiRenZhengActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //Log.e(TAG, "###path=" + imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            xingxiangpath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
            xingxiangFile.add(new File(xingxiangpath));
            Glide.with(ChaShiRenZhengActivity.this).load(xingxiangpath).into(img_xingxiang);
        }
    }

    private void qitazizhi(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(ChaShiRenZhengActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            qitazizhiPath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
            zizhiFile.add(new File(qitazizhiPath));
            Glide.with(ChaShiRenZhengActivity.this).load(qitazizhiPath).into(img_qitazizhi);
        }
    }

    private void yingyezizhi(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(ChaShiRenZhengActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            yingyezizhiPath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
            zizhiFile.add(new File(yingyezizhiPath));
                Glide.with(ChaShiRenZhengActivity.this).load(yingyezizhiPath).into(img_yingyezizhi);
            }
    }

    private void refreshAdapter(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(ChaShiRenZhengActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            positivePath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
            shenfenFile.add(new File(positivePath));
                Glide.with(ChaShiRenZhengActivity.this).load(positivePath).into(img_positive);
        }
    }

    private void refreshAdapter2(Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        //被压缩后的图片路径
        for (Uri imageUri : mSelected) {
            String imagePath = SDCardUtil.getFilePathFromUri(ChaShiRenZhengActivity.this, imageUri);
            Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
            //读取图片的旋转的角度
            int degree  = ImageUtils.getBitmapDegree(imagePath);
            //将图片按照某个角度进行旋转
            Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
            reversePath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
                shenfenFile.add(new File(reversePath));
                Glide.with(ChaShiRenZhengActivity.this).load(reversePath).into(img_reverse);
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
                String s = edt_zhicheng_qita.getText().toString();
                level = s;
                break;

        }
    }
}
