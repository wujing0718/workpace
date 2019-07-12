package com.huohougongfu.app.WoDe.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceActivity;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.HuiXian;
import com.huohougongfu.app.Gson.JsonBean;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.SelectVideo.BaseActivity;
import com.huohougongfu.app.UploadPictures.PhotoUtils;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GetJsonDataUtil;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.DialogSettings;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.wildma.pictureselector.PictureSelector;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.huohougongfu.app.Activity.FaBuVedioActivity.hasSdcard;

public class PersonalActivity extends BaseActivity implements View.OnClickListener {

    private int id;
    private ImageView img_wode_touxiang;
    private EditText edt_wode_name,edt_wode_jianjie;
    private ArrayList<JsonBean> options1Items = new ArrayList<>(); //省
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();//市
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();//区
    private TextView tv_wode_weizhi;
    private PopupWindow popupWindow;
    private String cityName;
    private String provinceName;
    private String areaName;
    private String picturePath;
    private File touxiangurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        id = MyApp.instance.getInt("id");
        initJsonData();
        initUI();
        initData();
    }

    private void initData() {
        OkGo.<String>get(Contacts.URl1+"/my/personal/info/"+id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        Gson gson = new Gson();
                        HuiXian huiXian = gson.fromJson(body, HuiXian.class);
                        if (huiXian.getStatus() == 1){
                            initView(huiXian.getResult());
                        }
                    }
                });
    }

    private void initView(HuiXian.ResultBean result) {
        RequestOptions requestCoordinator = new RequestOptions().circleCrop();
        Glide.with(this).load(result.getPhoto()).apply(requestCoordinator).into(img_wode_touxiang);
        edt_wode_name.setText(result.getNickName());
        if (result.getPersonalProfile()!=null){
            edt_wode_jianjie.setText(result.getPersonalProfile());
        }
    }

    private void initUI() {
        findViewById(R.id.bt_finish).setOnClickListener(this);
        findViewById(R.id.bt_xuanzediqu).setOnClickListener(this);
        findViewById(R.id.bt_xiugai_xinxi).setOnClickListener(this);
        tv_wode_weizhi = findViewById(R.id.tv_wode_weizhi);
        img_wode_touxiang = findViewById(R.id.img_wode_touxiang);
        img_wode_touxiang.setOnClickListener(this);
        edt_wode_name = findViewById(R.id.edt_wode_name);
        edt_wode_jianjie = findViewById(R.id.edt_wode_jianjie);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_finish:
                finish();
                break;
            case R.id.img_wode_touxiang:
                if (!utils.isDoubleClick()){
                    PictureSelector
                            .create(PersonalActivity.this, PictureSelector.SELECT_REQUEST_CODE)
                            .selectPicture(true, 480, 480, 1, 1);
                }
                break;
            case R.id.bt_xiugai_xinxi:
                if (!utils.isDoubleClick()){
                    SelectDialog.show(PersonalActivity.this, "提示", "是否修改信息", "确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            initXiuGai();
                        }
                    }, "取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                }
                break;
            case R.id.bt_xuanzediqu:
               //条件选择器
                OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                        //返回的分别是三个级别的选中位置
                        provinceName = options1Items.get(options1).getPickerViewText();
                        cityName = options2Items.get(options1).get(option2);
                        areaName = options3Items.get(options1).get(option2).get(options3);
                        tv_wode_weizhi.setText(cityName);
                    }
                }).setTitleText("城市选择").build() ;
                pvOptions.setPicker(options1Items,options2Items,options3Items);
                pvOptions.show();
                break;
        }
    }

    private void initXiuGai() {
        Map<String,String> map = new HashMap<>();
        map.put("mId",String.valueOf(id));
        map.put("nickName",edt_wode_name.getText().toString());
        map.put("personalProfile",edt_wode_jianjie.getText().toString());
        map.put("place",cityName);
        OkGo.<String>post(Contacts.URl1+"/my/personalInfo/edit")
                .isMultipart(true)
                .tag(this)
                .params("file",touxiangurl)
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        String body = response.body();
                        try {
                            JSONObject jsonObject = new JSONObject(body);
                            if (jsonObject.getInt("status") == 1){
                                ToastUtils.showShort("上传成功");
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
                        WaitDialog.show(PersonalActivity.this,"请稍后。。。");
                        super.onStart(request);
                    }
                });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*结果回调*/
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (data != null) {
                picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
                touxiangurl = new File(picturePath);
//                mIvImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));

                /*如果使用 Glide 加载图片，则需要禁止 Glide 从缓存中加载，因为裁剪后保存的图片地址是相同的*/
                RequestOptions requestOptions = RequestOptions
                        .circleCropTransform()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true);
                Glide.with(this).load(picturePath).apply(requestOptions).into(img_wode_touxiang);
            }
        }
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
            options3Items.add(Province_AreaList);
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
