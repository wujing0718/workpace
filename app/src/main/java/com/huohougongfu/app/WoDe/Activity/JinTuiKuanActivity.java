package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.googlecode.mp4parser.authoring.Edit;
import com.huohougongfu.app.Gson.MyDingDanDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.KuaiDiGongSi;
import com.huohougongfu.app.PopupView.TuiKuanQuXiao;
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
import com.lxj.xpopup.XPopup;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.huxq17.handygridview.HandyGridView.MODE.LONG_PRESS;

public class JinTuiKuanActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_shop_photo;
    private TextView tv_shop_title,tv_shop_guige,tv_shop_num,tv_shop_price,tv_quxiao_yuanyin;
    private int id;
    private String orderNo;
    private MyDingDanDetail.ResultBean.MallStoresBean.MallProductsBean bean;
    private GridViewAdapter mGridViewAddImgAdapter;
    private HandyGridView gridView;
    private ArrayList<String> mPicList = new ArrayList<>(); //上传的图片凭证的数据源
    private String compressPath;
    private Bitmap bitmap;
    private ArrayList<File> mphoto = new ArrayList<>(); //上传的图片凭证的数据源
    private int orderStatus;

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    yuanyin = (Map<String,String>)msg.obj;
                    tv_quxiao_yuanyin.setText(yuanyin.get("ocrname"));
                    tv_quxiao_yuanyin.setTextColor(getResources().getColor(R.color.colorBlack));
                    break;
                default:
                    break;
            }
        }
    };
    private Map<String,String> yuanyin;
    private EditText tuikuanshuoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jin_tui_kuan);
        id = MyApp.instance.getInt("id");
        orderNo = getIntent().getStringExtra("orderNo");
        orderStatus = getIntent().getIntExtra("orderStatus",0);
        bean = (MyDingDanDetail.ResultBean.MallStoresBean.MallProductsBean)getIntent().getSerializableExtra("shop");
        initUI();
        initGridView();
    }

    private void initUI() {
        img_shop_photo = findViewById(R.id.img_shop_photo);
        tv_shop_title = findViewById(R.id.tv_shop_title);
        tv_shop_guige = findViewById(R.id.tv_shop_guige);
        img_shop_photo = findViewById(R.id.img_shop_photo);
        tv_shop_title = findViewById(R.id.tv_shop_title);
        tv_shop_guige = findViewById(R.id.tv_shop_guige);
        tv_shop_num = findViewById(R.id.tv_shop_num);
        tv_shop_price = findViewById(R.id.tv_shop_price);
        tv_quxiao_yuanyin = findViewById(R.id.tv_quxiao_yuanyin);
        tuikuanshuoming = findViewById(R.id.edt_tuikuanshuoming);
        findViewById(R.id.bt_tuikuan_yuanyin).setOnClickListener(this);
        findViewById(R.id.bt_tijiao).setOnClickListener(this);
        Glide.with(JinTuiKuanActivity.this).load(bean.getCoverUrl()).into(img_shop_photo);
        tv_shop_title.setText(bean.getName());
        tv_shop_guige.setText(bean.getStandard());
        tv_shop_num.setText(String.valueOf(bean.getNum()));
        tv_shop_price.setText("¥"+bean.getPrice());
        findViewById(R.id.bt_finish).setOnClickListener(this);
    }

    //初始化展示上传图片的GridView
    private void initGridView(){
        gridView = findViewById(R.id.gridView);
        gridView.setMode(LONG_PRESS);
        mGridViewAddImgAdapter = new GridViewAdapter(JinTuiKuanActivity.this, mPicList);
        gridView.setAdapter(mGridViewAddImgAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == parent.getChildCount() - 1){
                    //如果“增加按钮形状的”图片的位置是最后一张，且添加了的图片的数量不超3张，才能点击
                    if (mPicList.size() == 3) {
                        //最多添加6张图片
                        viewPluImg(position);
                    } else {
                        //添加凭证图片
                        selectPic(3 - mPicList.size());
                    }
                } else {
                    viewPluImg(position);
                }
            }
        });
    }

    //查看大图
    private void viewPluImg(int position) {
        Intent intent = new Intent(JinTuiKuanActivity.this, PlusImageActivity.class);
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
                bitmap = PhotoUtils.getBitmapFromUri(uri,JinTuiKuanActivity.this);
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
            case R.id.bt_tuikuan_yuanyin:
                if (!utils.isDoubleClick()){
                    initQuanXiao(orderNo,orderStatus);
                }
                break;
            case R.id.bt_tijiao:
                if (!utils.isDoubleClick()){
                    if (yuanyin!=null){
                        initTiJiao();
                    }else{
                        ToastUtils.showShort("请选择退款原因");
                    }
                }
                break;
        }
    }

    private void initTiJiao() {
        Map<String,String> map = new HashMap<>();
        map.putAll(yuanyin);
        map.put("orderNo",orderNo);
        map.remove("ocrname");
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            jsonObject.put("orderNo",orderNo);
            jsonObject.put("createBy",String.valueOf(MyApp.instance.getInt("id")));
            jsonObject.put("productId",String.valueOf(bean.getId()));
            jsonObject.put("standardId",String.valueOf(bean.getStandardId()));
            jsonObject.put("refundMoney",String.valueOf(bean.getPrice()));
            jsonObject.put("ocrId",String.valueOf(map.get("ocrId")));
            jsonObject.put("productNum",String.valueOf(bean.getNum()));
            if (!tuikuanshuoming.getText().toString().isEmpty()){
                jsonObject.put("remark",tuikuanshuoming.getText().toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(jsonObject);
        OkGo.<String>post(Contacts.URl1+"order/cancelOrderOnlyRefundMoney")
                .tag(this)//
                .isMultipart(true)
                .params("json",jsonArray.toString())
                .addFileParams("picture", mphoto)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }else{
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    //  取消订单
    private void initQuanXiao(String orderNo, int orderStatus) {
        new XPopup.Builder(JinTuiKuanActivity.this)
                .asCustom(new TuiKuanQuXiao(JinTuiKuanActivity.this,orderStatus,orderNo,mHandler))
                .show();
    }

}
