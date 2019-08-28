package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.xlhratingbar_lib.XLHRatingBar;
import com.huohougongfu.app.Activity.FaBuActivity;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.UploadPictures.GridViewAdapter;
import com.huohougongfu.app.UploadPictures.MainConstant;
import com.huohougongfu.app.UploadPictures.PhotoUtils;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.UploadPictures.PlusImageActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.huxq17.handygridview.HandyGridView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.huxq17.handygridview.HandyGridView.MODE.LONG_PRESS;

public class DingDanPingJiaActivity extends AppCompatActivity implements View.OnClickListener {

    private String storeLogo,storeName;
    private GridViewAdapter mGridViewAddImgAdapter;
    private HandyGridView gridView;
    private ArrayList<String> mPicList = new ArrayList<>(); //上传的图片凭证的数据源
    private String compressPath;
    private Bitmap bitmap;
    private ArrayList<File> mphoto = new ArrayList<>(); //上传的图片凭证的数据源
    private EditText edt_pingjia;
    private XLHRatingBar miaoshu,wuliu,fuwu;
    private int shopid;
    private int miaoshunum,fuwunum,wuliunum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_dan_ping_jia);
        storeLogo = getIntent().getStringExtra("storeLogo");
        storeName = getIntent().getStringExtra("storeName");
        shopid = getIntent().getIntExtra("shopid", 0);
        initUI();
        initGridView();
    }

    private void initUI() {
        findViewById(R.id.bt_fabu).setOnClickListener(this);
        edt_pingjia = findViewById(R.id.edt_pingjia);
        miaoshu = findViewById(R.id.xlh1);
        wuliu = findViewById(R.id.xlh2);
        fuwu = findViewById(R.id.xlh3);

        ImageView img_dianpu_logo = findViewById(R.id.img_dianpu_logo);
        ImageView img_dianpu_logo1 = findViewById(R.id.img_dianpu_logo1);
        TextView tv_dianpu_name = findViewById(R.id.img_dianpu_name);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(DingDanPingJiaActivity.this).load(storeLogo).apply(requestOptions).into(img_dianpu_logo);
        Glide.with(DingDanPingJiaActivity.this).load(storeLogo).apply(requestOptions).into(img_dianpu_logo1);
        tv_dianpu_name.setText(storeName);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        miaoshu.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(int countSelected) {
                miaoshunum = countSelected;
            }
        });
        wuliu.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(int countSelected) {
                wuliunum = countSelected;
            }
        });
        fuwu.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(int countSelected) {
                fuwunum = countSelected;
            }
        });
    }
    //初始化展示上传图片的GridView
    private void initGridView(){
        gridView = findViewById(R.id.gridView);
        gridView.setMode(LONG_PRESS);
        mGridViewAddImgAdapter = new GridViewAdapter(DingDanPingJiaActivity.this, mPicList);
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
        Intent intent = new Intent(DingDanPingJiaActivity.this, PlusImageActivity.class);
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
                bitmap = PhotoUtils.getBitmapFromUri(uri,DingDanPingJiaActivity.this);
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
            case R.id.bt_finish:
                finish();
                break;
            case R.id.bt_fabu:
                if (!utils.isDoubleClick()){
                    initFaBu();
                }
                break;
        }
    }

    private void initFaBu() {
        String pingjia = edt_pingjia.getText().toString();
        Map<String,String> map =new HashMap<>();
        miaoshunum = miaoshu.getCountSelected();
        wuliunum = wuliu.getCountSelected();
        fuwunum = fuwu.getCountSelected();
        if (!pingjia.isEmpty()){
            map.put("appraiserId",String.valueOf(MyApp.instance.getInt("id")));
            map.put("productId",String.valueOf(shopid));
            map.put("appraiseContent",pingjia);
            map.put("describeScore",String.valueOf(miaoshunum));
            map.put("logisticSscore",String.valueOf(wuliunum));
            map.put("serviceScore",String.valueOf(fuwunum));
            OkGo.<String>post(Contacts.URl1+"order/apprasise")
                    .tag(this)//
                    .isMultipart(true)
                    .params(map)
                    .addFileParams("picture", mphoto)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    finish();
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }else{
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
        }else{
            ToastUtils.showShort("请输入评价内容");
        }
    }
}
