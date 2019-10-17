package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.huohougongfu.app.Gson.ShopDetail;
import com.huohougongfu.app.R;
import com.huohougongfu.app.UploadPictures.GridViewAdapter;
import com.huohougongfu.app.UploadPictures.MainConstant;
import com.huohougongfu.app.UploadPictures.PhotoUtils;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.UploadPictures.PlusImageActivity;
import com.huohougongfu.app.Utils.CustomGridView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.huxq17.handygridview.HandyGridView.MODE.LONG_PRESS;

public class ShopDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private GridViewAdapter mGridViewAddImgAdapter;
    private CustomGridView gridView;
    private ArrayList<String> mPicList = new ArrayList<>(); //上传的图片凭证的数据源
    private String compressPath;
    private Bitmap bitmap;
    private ArrayList<File> mphoto = new ArrayList<>(); //上传的图片凭证的数据源
    private Bundle bundle;

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
        mGridViewAddImgAdapter = new GridViewAdapter(ShopDetailActivity.this, mPicList);
        gridView.setAdapter(mGridViewAddImgAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == parent.getChildCount() - 1){
                    //如果“增加按钮形状的”图片的位置是最后一张，且添加了的图片的数量不超过5张，才能点击
                    if (mPicList.size() == MainConstant.MAX_SELECT_PIC_NUM) {
                        //最多添加6张图片
                        viewPluImg(position);
                    } else {
                        //添加凭证图片
                        selectPic(MainConstant.MAX_SELECT_PIC_NUM - mPicList.size());
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
     * 打开相册或者照相机选择凭证图片，最多5张
     *
     * @param maxTotal 最多选择的图片的数量
     */
    private void selectPic(int maxTotal) {
        PictureSelectorConfig.initMultiConfig(this, maxTotal);
    }

    // 处理选择的照片的地址
    private void refreshAdapter(List<LocalMedia> picList) {
        for (LocalMedia localMedia : picList) {
            //被压缩后的图片路径
            if (localMedia.isCompressed()) {
                compressPath = localMedia.getCompressPath(); //压缩后的图片路径
                //compressPath 存放所有的照片的路径
                mPicList.add(compressPath); //把图片添加到将要上传的图片数组中
                mphoto.add(new File(compressPath));
                mGridViewAddImgAdapter.notifyDataSetChanged();
                Uri uri = Uri.fromFile(new File(compressPath));
                bitmap = PhotoUtils.getBitmapFromUri(uri,ShopDetailActivity.this);
            }
        }
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
