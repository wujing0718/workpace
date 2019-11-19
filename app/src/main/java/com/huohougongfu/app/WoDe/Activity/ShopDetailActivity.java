package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.huohougongfu.app.Activity.FaBuActivity;
import com.huohougongfu.app.Gson.ShopDetail;
import com.huohougongfu.app.R;
import com.huohougongfu.app.UploadPictures.GridViewAdapter;
import com.huohougongfu.app.UploadPictures.GridViewAdapter6;
import com.huohougongfu.app.UploadPictures.MainConstant;
import com.huohougongfu.app.UploadPictures.PhotoUtils;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.UploadPictures.PlusImageActivity;
import com.huohougongfu.app.Utils.CustomGridView;
import com.huohougongfu.app.Utils.ImageUtils;
import com.huohougongfu.app.Utils.MyGlideEngine;
import com.huohougongfu.app.Utils.SDCardUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.huxq17.handygridview.HandyGridView.MODE.LONG_PRESS;
import static io.rong.imkit.utilities.RongUtils.screenHeight;
import static io.rong.imkit.utilities.RongUtils.screenWidth;

public class ShopDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private GridViewAdapter6 mGridViewAddImgAdapter;
    private CustomGridView gridView;
    private ArrayList<String> mPicList = new ArrayList<>(); //上传的图片凭证的数据源
    private Bitmap bitmap;
    private ArrayList<File> mphoto = new ArrayList<>(); //上传的图片凭证的数据源
    private Bundle bundle;
    private String positivePath;
    private static final int REQUEST_CODE_CHOOSE =23 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        mPicList = getIntent().getStringArrayListExtra("mshopphoto");
        initUI();
        initGridView();

    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_queding).setOnClickListener(this);
    }

    //初始化展示上传图片的GridView
    private void initGridView(){
        gridView = findViewById(R.id.gridView);
        gridView.setMode(LONG_PRESS);
        mGridViewAddImgAdapter = new GridViewAdapter6(ShopDetailActivity.this, mPicList);
        gridView.setAdapter(mGridViewAddImgAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == parent.getChildCount() - 1){
                    //如果“增加按钮形状的”图片的位置是最后一张，且添加了的图片的数量不超过5张，才能点击
                    if (mPicList.size() == MainConstant.MAX_SELECT_PIC_NUM_THREE) {
                        //最多添加6张图片
                        viewPluImg(position);
                    } else {
                        if (mPicList.size()<7){
                            callGallery();
                        }
                    }
                } else {
                    viewPluImg(position);
                }
            }
        });
    }

    //查看大图
    private void viewPluImg(int position) {
        Intent intent = new Intent(ShopDetailActivity.this, PlusImageActivity.class);
        intent.putStringArrayListExtra(MainConstant.IMG_LIST, mPicList);
        intent.putExtra(MainConstant.POSITION, position);
        startActivityForResult(intent, MainConstant.REQUEST_CODE_MAIN);
    }
    /**
     * 调用图库选择
     */
    private void callGallery(){
        Matisse.from(ShopDetailActivity.this)
                .choose(MimeType.ofImage(),false)//照片视频全部显示MimeType.allOf()
                .countable(true)//true:选中后显示数字;false:选中后显示对号
                .maxSelectable(6)//最大选择数量为9
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

    // 处理选择的照片的地址
    private void refreshAdapter(Intent data) {
        if (mPicList.size()<7){
            List<Uri> mSelected = Matisse.obtainResult(data);
            //被压缩后的图片路径
            for (Uri imageUri : mSelected) {
                String imagePath = SDCardUtil.getFilePathFromUri(ShopDetailActivity.this, imageUri);
                Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
                //读取图片的旋转的角度
                int degree  = ImageUtils.getBitmapDegree(imagePath);
                //将图片按照某个角度进行旋转
                Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
                positivePath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
                if (positivePath!=null) {
                    //compressPath 存放所有的照片的路径
                    if (mPicList.size()>5){
                        ToastUtils.showShort("最多上传6张");
                    }else{
                        mPicList.add(positivePath); //把图片添加到将要上传的图片数组中
                        mphoto.add(new File(positivePath));
                        mGridViewAddImgAdapter.notifyDataSetChanged();
                    }
                }else{
                    ToastUtils.showShort("该图片错误");
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_CHOOSE:
                    // 图片选择结果回调
                    refreshAdapter(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    break;
            }
        }
        if (requestCode == MainConstant.REQUEST_CODE_MAIN && resultCode == MainConstant.RESULT_CODE_VIEW_IMG) {
            //查看大图页面删除了图片
            ArrayList<String> toDeletePicList = data.getStringArrayListExtra(MainConstant.IMG_LIST); //要删除的图片的集合
            mPicList.clear();
            mPicList.addAll(toDeletePicList);
            mGridViewAddImgAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_queding:
                bundle = new Bundle();
                bundle.putStringArrayList("Shopphoto",mPicList);
                bundle.putString("type","1");
                setResult(103,ShopDetailActivity.this.getIntent().putExtras(bundle));
                ShopDetailActivity.this.finish();
                break;
            case R.id.bt_finish:
                bundle = new Bundle();
                bundle.putString("type","finish");
                bundle.putStringArrayList("Shopphoto",mPicList);
                setResult(103,ShopDetailActivity.this.getIntent().putExtras(bundle));
                ShopDetailActivity.this.finish();
                break;
        }
    }
    @Override
    public void onBackPressed(){
        bundle = new Bundle();
        bundle.putString("type","finish");
        bundle.putStringArrayList("Shopphoto",mPicList);
        setResult(103,ShopDetailActivity.this.getIntent().putExtras(bundle));
        ShopDetailActivity.this.finish();
        super.onBackPressed();
    }
}
