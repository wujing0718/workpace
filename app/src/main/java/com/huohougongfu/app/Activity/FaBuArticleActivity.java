package com.huohougongfu.app.Activity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.UploadPictures.MainConstant;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.UploadPictures.PlusImageActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.ImageUtils;
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
import com.sendtion.xrichtext.RichTextEditor;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;

import static io.rong.imkit.utilities.RongUtils.screenHeight;
import static io.rong.imkit.utilities.RongUtils.screenWidth;

public class FaBuArticleActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_CHOOSE =23 ;
    private LinearLayout view_wenzhang;
    private String compressPath;
    private boolean isfrast = true;
    private ArrayList<Object> meditview = new ArrayList<>();
    private ArrayList<File> mphotopath = new ArrayList<>();
    private ArrayList<String> mPicList = new ArrayList<>(); //上传的图片凭证的数据源
    private ProgressDialog loadingDialog;
    private ProgressDialog insertDialog;
    
    private EditText editText1;
    private int mId;
    private String citycode;
    private EditText edt_wenzhang_title;
    private String title;
    private String content = "わわ";
    private String token;
    private boolean iswenben = true;
    private ImageView imageView;
    private RichTextEditor et_new_content;
    private Disposable subsInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_bu_article);
        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        citycode = MyApp.instance.getString("citycode");
        initUI();
    }

    private void initUI() {
        et_new_content = (RichTextEditor) findViewById(R.id.et_new_content);
        insertDialog = new ProgressDialog(this);
        insertDialog.setMessage("正在插入图片...");
        insertDialog.setCanceledOnTouchOutside(false);
        view_wenzhang = findViewById(R.id.view_wenzhang);
        edt_wenzhang_title = findViewById(R.id.edt_wenzhang_title);
        findViewById(R.id.bt_add_editview).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_fabu).setOnClickListener(this);
        et_new_content.post(new Runnable() {
            @Override
            public void run() {
                dealWithContent();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add_editview:
                if (!utils.isDoubleClick()) {
                    callGallery();
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_fabu:
                if(!utils.isDoubleClick()){
                    if (!"".equals(token)) {
                        title = edt_wenzhang_title.getText().toString();
                        if (!TextUtils.isEmpty(title)){
                            List<RichTextEditor.EditData> editData = et_new_content.buildEditData();
                            for (int i =0;i<editData.size();i++){
                                if (editData.get(i).imagePath!=null ){
                                    content += "ゐゑをわわ";
                                }else if (editData.get(i).inputStr!=null&& !"".equals(editData.get(i).inputStr)){
                                    content+=editData.get(i).inputStr+"わわ";
                                }
                            }
                            if (!TextUtils.isEmpty(content)){
                                initFaBu(content);
                            }else{
                                content ="わわ";
                                ToastUtils.showShort("发布内容不能为空");
                            }
                        }else{
                            ToastUtils.showShort("发布标题不能为空");
                        }
                    }else{
                        ToastUtils.showShort(R.string.denglu);
                    }
                }
                break;
        }
    }

    /**
     * 调用图库选择
     */
    private void callGallery(){
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
                .forResult(REQUEST_CODE_CHOOSE);//请求码
    }

    private void dealWithContent(){
        et_new_content.clearAllLayout();
        // 图片删除事件
        et_new_content.setOnRtImageDeleteListener(new RichTextEditor.OnRtImageDeleteListener() {

            @Override
            public void onRtImageDelete(String imagePath) {
                if (!TextUtils.isEmpty(imagePath)) {
                    boolean isOK = SDCardUtil.deleteFile(imagePath);
                    if (isOK) {
                        ToastUtils.showShort("删除成功");
                        content.replace("わわ","\n");
                    }
                }
            }
        });
    }


    private void initFaBu(String content) {
        Map<String,String> map = new HashMap<>();
            map.put("content",content);
            map.put("type","2");
            map.put("title",title);
            map.put("mId",String.valueOf(mId));
            map.put("cityCode",citycode);
            map.put("token",token);
        OkGo.<String>post(Contacts.URl1+"/circle/pub")
                    .tag(this)
                    .isMultipart(true)
                    .params(map)
                    .addFileParams("file",mphotopath)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            WaitDialog.dismiss();
                            String body = response.body();
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                    finish();
                                }else{
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onStart(Request<String, ? extends Request> request) {
                            WaitDialog.show(FaBuArticleActivity.this,"载入中...");
                            super.onStart(request);
                        }
                    });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_CHOOSE:
                    insertImagesSync(data);
                    break;
            }
        }
    }

    private void insertImagesSync(final Intent data) {
                    List<Uri> mSelected = Matisse.obtainResult(data);
                    //被压缩后的图片路径
                    for (Uri imageUri : mSelected) {
                        String imagePath = SDCardUtil.getFilePathFromUri(FaBuArticleActivity.this, imageUri);
                        //Log.e(TAG, "###path=" + imagePath);
                        Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
                        String compress = SDCardUtil.saveToSdCard(bitmap1);//压缩后的图片路径
                        String compressPath = ImageUtils.amendRotatePhoto(compress,FaBuArticleActivity.this);
                        if (compressPath!=null){
//                            compressPath = SDCardUtil.saveToSdCard(bitmap);
                            //Log.e(TAG, "###imagePath="+imagePath);
                            mPicList.add(compressPath); //把图片添加到将要上传的图片数组中
                            mphotopath.add(new File(compressPath));
                            imageView = new ImageView(FaBuArticleActivity.this);
                            RequestOptions placeholder = new RequestOptions().placeholder(R.mipmap.img_zhanweitu);
                            Glide.with(FaBuArticleActivity.this).load(compressPath).apply(placeholder).into(imageView);
                            et_new_content.insertImage(imagePath, et_new_content.getMeasuredWidth());
                        }else{
                            ToastUtils.showShort("该图片错误");
                        }
                    }
    }

}
