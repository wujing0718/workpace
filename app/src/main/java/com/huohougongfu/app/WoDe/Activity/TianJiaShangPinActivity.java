package com.huohougongfu.app.WoDe.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huohougongfu.app.Gson.JsonBean;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.UploadPictures.GridViewAdapter;
import com.huohougongfu.app.UploadPictures.MainConstant;
import com.huohougongfu.app.UploadPictures.PhotoUtils;
import com.huohougongfu.app.UploadPictures.PictureSelectorConfig;
import com.huohougongfu.app.UploadPictures.PlusImageActivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.CustomGridView;
import com.huohougongfu.app.Utils.GetJsonDataUtil;
import com.huohougongfu.app.Utils.utils;
import com.huxq17.handygridview.HandyGridView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
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

public class TianJiaShangPinActivity extends AppCompatActivity implements View.OnClickListener {

    private GridViewAdapter mGridViewAddImgAdapter;
    private CustomGridView gridView;
    private ArrayList<String> mPicList = new ArrayList<>(); //上传的图片凭证的数据源
    private String compressPath;
    private Bitmap bitmap;
    private ArrayList<File> mphoto = new ArrayList<>(); //上传的图片凭证的数据源
    private ArrayList<File> mshopphoto = new ArrayList<>(); //上传的图片凭证的数据源
    private ArrayList<File> mguige = new ArrayList<>(); //上传商品规格数据源

    private TextView tv_zhutu_num;
    private Intent intent;
    private TextView tv_categoryName,tv_city;
    private String categoryName;
    private ArrayList<JsonBean> options1Items = new ArrayList<>(); //省
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();//市
    private String provinceName,cityName;
    private EditText edt_shop_title,edt_shop_num,edt_shop_yongjin;
    private String categoryNameid,Nameid;
    private String canshu;
    private String shopguige;
    private TextView tv_shuo_guige,tv_yitianxie,tv_shop_yitianxie;
    private ArrayList<String> shopphoto = new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tian_jia_shang_pin);
        intent = new Intent();
        //解析数据 （省市区三级联动）
        initJsonData();
        initUI();
        initGridView();

    }

    private void initUI() {
        edt_shop_title = findViewById(R.id.edt_shop_title);
        edt_shop_num = findViewById(R.id.edt_shop_num);
        edt_shop_yongjin = findViewById(R.id.edt_shop_yongjin);
        tv_shuo_guige = findViewById(R.id.tv_shuo_guige);
        tv_categoryName = findViewById(R.id.tv_categoryName);
        tv_yitianxie = findViewById(R.id.tv_yitianxie);
        tv_shop_yitianxie = findViewById(R.id.tv_shop_yitianxie);
        tv_city = findViewById(R.id.tv_city);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_shop_canshu).setOnClickListener(this);
        findViewById(R.id.bt_shop_fenlei).setOnClickListener(this);
        findViewById(R.id.bt_fahuo_city).setOnClickListener(this);
        findViewById(R.id.bt_shop_detail).setOnClickListener(this);
        findViewById(R.id.bt_shop_guige).setOnClickListener(this);
        findViewById(R.id.bt_tijiao).setOnClickListener(this);
        tv_zhutu_num = findViewById(R.id.tv_zhutu_num);
    }

    //初始化展示上传图片的GridView
    private void initGridView(){
        gridView = findViewById(R.id.gridView);
        gridView.setMode(LONG_PRESS);
        mGridViewAddImgAdapter = new GridViewAdapter(TianJiaShangPinActivity.this, mPicList);
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
        Intent intent = new Intent(TianJiaShangPinActivity.this, PlusImageActivity.class);
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
                bitmap = PhotoUtils.getBitmapFromUri(uri,TianJiaShangPinActivity.this);
            }
        }
        tv_zhutu_num.setText("("+mPicList.size()+"/6)");
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
        //商品分类
        if (requestCode == 101){
            Bundle extras = data.getExtras();
            categoryName = extras.getString("categoryName");
            categoryNameid = extras.getString("categoryNameid");
            Nameid = extras.getString("Nameid");
            if (categoryName!=null ){
                tv_categoryName.setText(categoryName);
            }
        }
        //商品详情
        if (requestCode == 103){
            Bundle extras = data.getExtras();
            shopphoto = extras.getStringArrayList("Shopphoto");
            String type = extras.getString("type");
            mshopphoto.clear();
            if (!"finish".equals(type)){
                tv_shop_yitianxie.setText("完成");
                tv_shop_yitianxie.setTextColor(getResources().getColor(R.color.colorBlack));
                for (int i = 0; i < shopphoto.size(); i++) {
                    mshopphoto.add(new File(shopphoto.get(i)));
                }
            }
        }
        //商品参数
        if (requestCode == 102){
            Bundle extras = data.getExtras();
            canshu = extras.getString("canshu");
            String type = extras.getString("type");
            if (canshu!=null){
                tv_yitianxie.setText("完成");
                tv_yitianxie.setTextColor(getResources().getColor(R.color.colorBlack));
            }else{
                tv_yitianxie.setText("");
            }
        }
        //商品规格
        if (requestCode == 100){
            Bundle extras = data.getExtras();
            shopguige = extras.getString("Shopguige");
            if (shopguige!=null){
                tv_shuo_guige.setText("完成");
                tv_shuo_guige.setTextColor(getResources().getColor(R.color.colorBlack));
            }
//            mguige.clear();
//            if (shopguige!=null){
//                for (int i = 0; i < shopguige.size(); i++) {
//                    mguige.add(new File(shopguige.get(i)));
//                }
//            }
        }
        if (requestCode == MainConstant.REQUEST_CODE_MAIN && resultCode == MainConstant.RESULT_CODE_VIEW_IMG) {
            //查看大图页面删除了图片
            ArrayList<String> toDeletePicList = data.getStringArrayListExtra(MainConstant.IMG_LIST); //要删除的图片的集合
            mPicList.clear();
            mPicList.addAll(toDeletePicList);
            mGridViewAddImgAdapter.notifyDataSetChanged();
            tv_zhutu_num.setText("("+mPicList.size()+"/6)");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_tijiao:
                if (!utils.isDoubleClick()){
                    JSONObject mallproduct  = new JSONObject();
                    if (!edt_shop_title.getText().toString().isEmpty()){
                        if (!edt_shop_num.getText().toString().isEmpty()){
                                if (mguige!=null){
                                    if (categoryNameid!=null){
                                        if (cityName!=null){
                                            try {
                                                mallproduct .put("createBy",String.valueOf(MyApp.instance.getInt("id")));
                                                mallproduct .put("name",edt_shop_title.getText().toString());
                                                mallproduct .put("stock",edt_shop_num.getText().toString());
                                                mallproduct .put("categoryId",String.valueOf(categoryNameid));
                                                if (!edt_shop_yongjin.getText().toString().isEmpty()){
                                                    mallproduct .put("commission",edt_shop_yongjin.getText().toString());
                                                }
                                                mallproduct .put("sendAddress",cityName);
                                                initShangChuan(mallproduct);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }else{
                                            ToastUtils.showShort("请选择发货城市");
                                        }
                                    }else{
                                        ToastUtils.showShort("请选择商品分类");
                                    }
                                }else{
                                    ToastUtils.showShort("请选择规格");
                                }
                        }else{
                            ToastUtils.showShort("请输入商品数量");
                        }
                    }else{
                        ToastUtils.showShort("请填写标题");
                    }
                }
                break;
            case R.id.bt_shop_fenlei:
                if (!utils.isDoubleClick()){
                    intent.setClass(TianJiaShangPinActivity.this,ShopFenLeiActivity.class);
                    startActivityForResult(intent,101);
                }
                break;
            case R.id.bt_shop_canshu:
                if (!utils.isDoubleClick()){
                    if (Nameid != null && !"".equals(Nameid)){
                        intent.putExtra("categoryName",Nameid);
                        intent.putExtra("canshu",canshu);
                        intent.setClass(TianJiaShangPinActivity.this,ShopCanShuActivity.class);
                        startActivityForResult(intent,102);
                    }else{
                        ToastUtils.showShort("请选择商品分类");
                    }
                }
                break;
            case R.id.bt_shop_detail:
                if (!utils.isDoubleClick()){
                    intent.putStringArrayListExtra("mshopphoto",shopphoto);
                    intent.setClass(TianJiaShangPinActivity.this,ShopDetailActivity.class);
                    startActivityForResult(intent,103);
                }
                break;
            case R.id.bt_fahuo_city:
                if (!utils.isDoubleClick()){
                    //条件选择器
                    OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                            //返回的分别是三个级别的选中位置
                            provinceName = options1Items.get(options1).getPickerViewText();
                            cityName = options2Items.get(options1).get(option2);
                            tv_city.setText(cityName);
                        }
                    }).setTitleText("城市选择").build();
                    pvOptions.setPicker(options1Items, options2Items);
                    pvOptions.show();
                }
                break;
            case R.id.bt_shop_guige:
                if (!utils.isDoubleClick()){
                    intent.setClass(TianJiaShangPinActivity.this,ShopGuiGeActivity.class);
                    startActivityForResult(intent,100);
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
        }
    }

    private void initShangChuan(JSONObject jsonObject) {
        JSONArray mallproduct = new JSONArray();
        mallproduct.put(jsonObject);
        Map<String,String> map = new HashMap<>();
        map.put("mallproduct",mallproduct.toString());
        map.put("standards",shopguige);
        map.put("productAttribute",canshu);
        OkGo.<String>post(Contacts.URl1+"productManage/addProduct")
                .tag(this)
                .isMultipart(true)
                .params(map)
                .addFileParams("productPicture",mphoto)
                .addFileParams("detailPic",mshopphoto)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        JSONObject jsonObject1 = null;
                        try {
                            jsonObject1 = new JSONObject(body);
                            if (jsonObject1.getInt("status") == 1){
                                ToastUtils.showShort(jsonObject1.getString("msg"));
                                finish();
                            }else{
                                ToastUtils.showShort(jsonObject1.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });


    }

    private void initJsonData() {//解析数据 （省市区三级联动）
        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三级）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市
                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {
                    City_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
//            options3Items.add(Province_AreaList);
        }
    }

    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

}
