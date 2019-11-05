package com.huohougongfu.app.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.JsonArray;
import com.huohougongfu.app.Gson.AddressBean;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.ShouYe.Activity.JiQiAcyivity;
import com.huohougongfu.app.UploadPictures.GridViewAdapter;
import com.huohougongfu.app.UploadPictures.MainConstant;
import com.huohougongfu.app.UploadPictures.PhotoUtils;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.UploadPictures.PlusImageActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.ImageUtils;
import com.huohougongfu.app.Utils.MyGlideEngine;
import com.huohougongfu.app.Utils.SDCardUtil;
import com.huohougongfu.app.Utils.utils;
import com.huohougongfu.app.WoDe.Activity.AddRegionActivity;
import com.huxq17.handygridview.HandyGridView;
import com.kongzue.dialog.v2.SelectDialog;
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
import com.zhihu.matisse.internal.model.SelectedItemCollection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.huxq17.handygridview.HandyGridView.MODE.LONG_PRESS;
import static com.huxq17.handygridview.HandyGridView.MODE.TOUCH;
import static io.rong.imkit.utilities.RongUtils.screenHeight;
import static io.rong.imkit.utilities.RongUtils.screenWidth;

public class FaBuActivity extends AppCompatActivity implements View.OnClickListener {

    private FaBuActivity mContext;
    private ArrayList<String> mPicList = new ArrayList<>(); //上传的图片凭证的数据源
    private ArrayList<File> mphoto = new ArrayList<>(); //上传的图片凭证的数据源
    private GridViewAdapter mGridViewAddImgAdapter;
    private HandyGridView gridView;
    private Bitmap bitmap;
    private String compressPath;
    private EditText edt_content;
    private String tel,id,token;
    //定位需要的声明
    private AMapLocationClient mLocationClient = null;//定位发起端
    private AMapLocationClientOption mLocationOption = null;//定位参数
    private LocationSource.OnLocationChangedListener mListener = null;//定位监听器
    boolean isFirstLoc = true;
    private String lat;
    private String lon;
    private String citycode;
    private TextView tv_weizhi;
    private AddressBean data1;
    private static final int REQUEST_CODE_CHOOSE =23 ;
    private String SPcontent,SPphotopath;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_bu);
        token = MyApp.instance.getString("token");
        tel = MyApp.instance.getString("phone");
        citycode = MyApp.instance.getString("citycode");
        id = String.valueOf(MyApp.instance.getInt("id"));
        mContext = this;
        tv_weizhi = findViewById(R.id.tv_weizhi);
        //获取保存的草稿箱
        SPcontent = SPUtils.getInstance("动态").getString("content");
        SPphotopath = SPUtils.getInstance("动态").getString("photo");
        findViewById(R.id.bt_fabu).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.view_fabud_dingwei).setOnClickListener(this);
        edt_content = findViewById(R.id.edt_content);
        if (SPcontent!=null && !"".equals(SPcontent)){
            edt_content.setText(SPcontent);
        }
        if (SPphotopath!=null && !"".equals(SPphotopath)){
            try {
                JSONArray jsArr = new JSONArray(SPphotopath);
                if(jsArr != null) for (int i = 0; i < jsArr.length(); i++) {
                    String picturepath = (String) jsArr.get(i);
                    mPicList.add(picturepath);
                }
                for (int i = 0; i < mPicList.size(); i++) {
                    mphoto.add(new File(mPicList.get(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        initGridView();
    }

    @Override
    protected void onResume() {
        //设置定位监听
        initLoc();
        super.onResume();
    }
    //定位
    private void initLoc() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                        //获取纬度
                        double lat1 = aMapLocation.getLatitude();
                        double lon1 = aMapLocation.getLongitude();//获取经度
                        lat = String.valueOf(lat1);
                        lon = String.valueOf(lon1);
                        if (isFirstLoc) {
                            //获取定位信息
                            StringBuffer buffer = new StringBuffer();
                            buffer.append(aMapLocation.getCountry() + ""
                                    + aMapLocation.getProvince() + ""
                                    + aMapLocation.getCity() + ""
                                    + aMapLocation.getProvince() + ""
                                    + aMapLocation.getDistrict() + ""
                                    + aMapLocation.getStreet() + ""
                                    + aMapLocation.getStreetNum());
                            isFirstLoc = false;
                        }
                    }else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("地图错误","定位失败, 错误码:" + aMapLocation.getErrorCode() + ", 错误信息:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        });
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(true);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }
    //初始化展示上传图片的GridView
    private void initGridView(){
        gridView = findViewById(R.id.gridView);
        gridView.setMode(LONG_PRESS);
        mGridViewAddImgAdapter = new GridViewAdapter(mContext, mPicList);
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
                        if (mPicList.size()<10){
                            callGallery();
                        }
                        //添加凭证图片
//                        selectPic(MainConstant.MAX_SELECT_PIC_NUM - mPicList.size());
                    }
                } else {
                    viewPluImg(position);
                }
            }
        });
    }

    /**
     * 调用图库选择
     */
    private void callGallery(){
        Matisse.from(FaBuActivity.this)
                .choose(MimeType.ofImage(),false)//照片视频全部显示MimeType.allOf()
                .countable(true)//true:选中后显示数字;false:选中后显示对号
                .maxSelectable(9)//最大选择数量为9
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
    //查看大图
    private void viewPluImg(int position) {
        Intent intent = new Intent(mContext, PlusImageActivity.class);
        intent.putStringArrayListExtra(MainConstant.IMG_LIST, mPicList);
        intent.putExtra(MainConstant.POSITION, position);
        startActivityForResult(intent, MainConstant.REQUEST_CODE_MAIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_CHOOSE:
                    // 处理选择的照片的地址
                    insertImagesSync(data);
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
        if (requestCode == CONTEXT_RESTRICTED){
            data1 = (AddressBean)data.getSerializableExtra("data");
            title = data.getStringExtra("title");
            if(data1==null){
                tv_weizhi.setText("所在位置");
            }else{
                title = data1.getTitle();
                tv_weizhi.setText(data1.getTitle());
            }
            if (null!=title){
                tv_weizhi.setText(title);
            }
        }
    }

    private void insertImagesSync(final Intent data) {
        List<Uri> mSelected = Matisse.obtainResult(data);
        if (mPicList.size()<10){
            //被压缩后的图片路径
            for (Uri imageUri : mSelected) {
                String imagePath = SDCardUtil.getFilePathFromUri(FaBuActivity.this, imageUri);
                Bitmap bitmap1 = ImageUtils.getSmallBitmap(imagePath, screenWidth, screenHeight);//压缩图片
                //读取图片的旋转的角度
                int degree  = ImageUtils.getBitmapDegree(imagePath);
                //Log.e(TAG, "###path=" + imagePath);
                //将图片按照某个角度进行旋转
                Bitmap bitmap = ImageUtils.rotateBitmapByDegree(bitmap1, degree);
                String compressPath = SDCardUtil.saveToSdCard(bitmap);//压缩后的图片路径
                if (compressPath!=null) {
                    //compressPath 存放所有的照片的路径
                    if (mPicList.size()>8){
                        ToastUtils.showShort("最多上传9张");
                    }else{
                        mPicList.add(compressPath); //把图片添加到将要上传的图片数组中
                        mphoto.add(new File(compressPath));
                        mGridViewAddImgAdapter.notifyDataSetChanged();
                    }
                }else{
                    ToastUtils.showShort("该图片错误");
                }
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_fabu:
                if (!utils.isDoubleClick()){
                    initFaBu();
                }
            break;
            case R.id.bt_finish:
                String content = edt_content.getText().toString();
                String jsonpathString  = new JSONArray(mPicList).toString();
                if (!"".equals(content) || !mPicList.isEmpty()){
                    SelectDialog.show(FaBuActivity.this, "提示", "是否保留当前编辑",
                            "确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (!content.isEmpty()){
                                        SPUtils.getInstance("动态").put("content",content);
                                    }
                                    if (!jsonpathString.isEmpty()){
                                        SPUtils.getInstance("动态").put("photo",jsonpathString);
                                    }
                                    finish();
                                }
                            },
                            "取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    SPUtils.getInstance("动态").clear(true);
                                    finish();
                                }
                            });
                }else{
                    finish();
                }

                break;
            case R.id.view_fabud_dingwei:
                if (!utils.isDoubleClick()){
                    Intent intent = new Intent();
                    intent.setClass(FaBuActivity.this,JiQiAcyivity.class);
                    intent.putExtra("title",tv_weizhi.getText().toString());
                    startActivityForResult(intent, CONTEXT_RESTRICTED);

                }
                break;
        }
    }

    private void initFaBu() {
        String content = edt_content.getText().toString();
        if (!"".equals(token)) {
            if (!mphoto.isEmpty()) {
                Map<String, String> map = new HashMap<>();
                map.put("content", content);
                map.put("tel", tel);
                map.put("type", "1");
                map.put("mId", id);
                map.put("token", token);
                if (data1!=null){
                    map.put("longitude", String.valueOf(data1.getLongitude()));
                    map.put("latitude", String.valueOf(data1.getLatitude()));
                    map.put("cityCode", data1.getAdCode());
                    map.put("address", data1.getTitle());
                }
                OkGo.<String>post(Contacts.URl1 + "/circle/pub")
                        .tag(this)//
                        .isMultipart(true)
                        .params(map)
                        .addFileParams("file", mphoto)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                String body = response.body();
                                JSONObject jsonObject = null;
                                try {
                                    jsonObject = new JSONObject(body);
                                    if (jsonObject.getInt("status") == 1) {
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
                                WaitDialog.show(FaBuActivity.this, "载入中...");
                                super.onStart(request);
                            }
                        });
            } else {
                ToastUtils.showShort("请选择上传的图片");
            }
        }else{
            ToastUtils.showShort(R.string.denglu);
        }
    }

    @Override
    public void onBackPressed() {
        String content = edt_content.getText().toString();
        String jsonpathString  = new JSONArray(mPicList).toString();
        if (!"".equals(content) || !mPicList.isEmpty()){
            SelectDialog.show(FaBuActivity.this, "提示", "是否保留当前编辑",
                    "确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (!content.isEmpty()){
                                SPUtils.getInstance("动态").put("content",content);
                            }
                            if (!jsonpathString.isEmpty()){
                                SPUtils.getInstance("动态").put("photo",jsonpathString);
                            }
                            finish();
                        }
                    },
                    "取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SPUtils.getInstance("动态").clear(true);
                            finish();
                        }
                    });
        }else{
            finish();
        }
    }
}
