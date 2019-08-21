package com.huohougongfu.app.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.UploadPictures.MainConstant;
import com.huohougongfu.app.UploadPictures.PhotoUtils;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaBuArticleActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout view_wenzhang;
    private String compressPath;
    private boolean isfrast = true;
    private ArrayList<Object> meditview = new ArrayList<>();
    private ArrayList<File> mphotopath = new ArrayList<>();

    private EditText editText1;
    private int mId;
    private String citycode;
    private EditText edt_wenzhang_title;
    private String title;
    private String content = "";
    private String token;

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
        view_wenzhang = findViewById(R.id.view_wenzhang);
        edt_wenzhang_title = findViewById(R.id.edt_wenzhang_title);
        findViewById(R.id.bt_add_editview).setOnClickListener(this);
        findViewById(R.id.bt_add_imageview).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_fabu).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add_editview:
                if (!utils.isDoubleClick()) {
                        editText1 = new EditText(FaBuArticleActivity.this);
                        editText1.setHint("输入正文");
                        editText1.setTextColor(MyApp.context.getResources().getColor(R.color.colorBlack));
                        editText1.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                        editText1.setHeight(100);
                        editText1.setFocusable(true);
                        editText1.setFocusableInTouchMode(true);
                        editText1.requestFocus();
                        editText1.setMaxLines(20);
                        editText1.setBackground(null);
                        editText1.setHintTextColor(MyApp.context.getResources().getColor(R.color.colorHui));
                        editText1.setMovementMethod(LinkMovementMethod.getInstance());
                        view_wenzhang.addView(editText1);
                        meditview.add(editText1);
                }
                break;
            case R.id.bt_add_imageview:
                if (!utils.isDoubleClick()) {
                    PictureSelectorConfig.initMultiConfig(this, 1);
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_fabu:
                if(!utils.isDoubleClick()){
                    if (!"".equals(token)) {
                        title = edt_wenzhang_title.getText().toString();
                        for (int i =0;i<meditview.size();i++){
                            if (meditview.get(i).equals("わわゐゑをわわ")){
                                content += "ゐゑをわわ";
                            }else{
                                EditText editText = (EditText) meditview.get(i);
                                content += editText.getText().toString()+"わわ";
                            }
                        }
                        if (!TextUtils.isEmpty(title)){
                            if (!TextUtils.isEmpty(content)){
                                initFaBu(content);
                            }else{
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
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    refreshAdapter(PictureSelector.obtainMultipleResult(data));
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    break;
            }
        }
//        if (requestCode == MainConstant.REQUEST_CODE_MAIN && resultCode == MainConstant.RESULT_CODE_VIEW_IMG) {
//            //查看大图页面删除了图片
//            ArrayList<String> toDeletePicList = data.getStringArrayListExtra(MainConstant.IMG_LIST); //要删除的图片的集合
//            mPicList.clear();
//            mPicList.addAll(toDeletePicList);
//            mGridViewAddImgAdapter.notifyDataSetChanged();
//        }
//    }
    }

    private void refreshAdapter(List<LocalMedia> picList) {
        //被压缩后的图片路径
        for (LocalMedia localMedia : picList)
            if (localMedia.isCompressed()) {
                compressPath = localMedia.getCompressPath(); //压缩后的图片路径
                meditview.add("わわゐゑをわわ");
                mphotopath.add(new File(compressPath));
                ImageView imageView = new ImageView(FaBuArticleActivity.this);
                RequestOptions placeholder = new RequestOptions().placeholder(R.mipmap.img_zhanweitu);
                Glide.with(FaBuArticleActivity.this).load(compressPath).apply(placeholder).into(imageView);
                view_wenzhang.addView(imageView);
                imageView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if (imageView!=null){
                            view_wenzhang.removeView(imageView);
                        }
                        return true;
                    }
                });
            }
    }
}
