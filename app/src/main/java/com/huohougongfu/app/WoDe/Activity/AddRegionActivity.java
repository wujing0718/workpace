package com.huohougongfu.app.WoDe.Activity;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.AddRess;
import com.huohougongfu.app.Gson.JsonBean;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.GetJsonDataUtil;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.WaitDialog;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.suke.widget.SwitchButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddRegionActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<JsonBean> options1Items = new ArrayList<>(); //省
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();//市
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();//区
    private TextView tv_dizhi;
    private EditText edt_shouhuoren,edt_dizhi_phone,edt_xiangxidizhi;
    private String name,phone,xiangxidizhi;
    private int id;
    private String provinceName,cityName,areaName;
    private SwitchButton bt_switch;
    private int isDefault = 0;
    private AddRess.ResultBean resultBean;
    private TextView tv_zhuangtai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_region);
        id = MyApp.instance.getInt("id");
        resultBean = (AddRess.ResultBean) getIntent().getSerializableExtra("地址");
        //解析数据 （省市区三级联动）
        initJsonData();
        initUI();
    }

    private void initUI() {
        tv_dizhi = findViewById(R.id.tv_dizhi);
        tv_zhuangtai = findViewById(R.id.tv_zhuangtai);
        edt_shouhuoren = findViewById(R.id.edt_shouhuoren);
        edt_dizhi_phone = findViewById(R.id.edt_dizhi_phone);
        edt_xiangxidizhi = findViewById(R.id.edt_xiangxidizhi);
        findViewById(R.id.bt_xuanze_dizhi).setOnClickListener(this);
        findViewById(R.id.bt_baocun_dizhi).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        bt_switch = findViewById(R.id.bt_switch);
        bt_switch.setShadowEffect(true);//disable shadow effect
        bt_switch.setEnableEffect(false);
        bt_switch.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked){
                    SelectDialog.show(AddRegionActivity.this, "提示", "是否设置为默认地址",
                            "确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    isDefault = 1;
                                    bt_switch.setChecked(true);
                                }
                            },
                            "取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    bt_switch.setChecked(false);
                                }
                            });
                }else{
                    isDefault = 0;
                }
            }
        });
        if (resultBean!=null){
            tv_dizhi.setText(resultBean.getProvinceName()+" "+resultBean.getCityName()+" "+resultBean.getAreaName());
            provinceName = resultBean.getProvinceName();
            cityName = resultBean.getCityName();
            areaName = resultBean.getAreaName();
            edt_shouhuoren.setText(resultBean.getReceiverName());
            edt_dizhi_phone.setText(resultBean.getPhone());
            edt_xiangxidizhi.setText(resultBean.getDetailAddr());
            tv_zhuangtai.setText("修改");
            if (resultBean.getIsDefault() == 1){
                bt_switch.setChecked(true);
            }else{
                bt_switch.setChecked(false);
            }
        }else{
            tv_zhuangtai.setText("保存");
            bt_switch.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                    if (isChecked){
                        SelectDialog.show(AddRegionActivity.this, "提示", "是否设置为默认地址",
                                "确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        isDefault = 1;
                                        bt_switch.setChecked(true);
                                    }
                                },
                                "取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        bt_switch.setChecked(false);
                                    }
                                });
                    }else{
                        isDefault = 0;
                    }
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_xuanze_dizhi:
                hideInput();
                //条件选择器
                OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                        //返回的分别是三个级别的选中位置
                        provinceName = options1Items.get(options1).getPickerViewText();
                        cityName = options2Items.get(options1).get(option2);
                        areaName = options3Items.get(options1).get(option2).get(options3);

                        tv_dizhi.setText(provinceName+" "+cityName+" "+areaName);
                    }
                }).setTitleText("城市选择").build();
                pvOptions.setPicker(options1Items, options2Items, options3Items);
                pvOptions.show();
                break;
            case R.id.bt_baocun_dizhi:
                name = edt_shouhuoren.getText().toString();
                phone = edt_dizhi_phone.getText().toString();
                xiangxidizhi = edt_xiangxidizhi.getText().toString();
                if (resultBean!=null){
                    initXiuGai(resultBean.getId());
                }else{
                    initBaoCun();
                }
                break;
            case R.id.bt_finish:
                finish();
                break;
        }
    }

    private void initXiuGai(int dizhiid) {
        if (!name.isEmpty()){
            if (!phone.isEmpty()){
                if (RegexUtils.isMobileExact(phone)){
                    if (!tv_dizhi.toString().isEmpty()){
                        if (!xiangxidizhi.isEmpty()){
                            SelectDialog.show(AddRegionActivity.this, "提示", "是否修改收货地址", "确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Map<String,String> map = new HashMap<>();
                                    map.put("id",String.valueOf(dizhiid));
                                    map.put("createBy",String.valueOf(id));
                                    map.put("provinceName",provinceName);
                                    map.put("cityName",cityName);
                                    map.put("areaName",areaName);
                                    map.put("detailAddr",xiangxidizhi);
                                    map.put("receiverName",name);
                                    map.put("phone",phone);
                                    map.put("isDefault",String.valueOf(isDefault));
                                    OkGo.<String>post(Contacts.URl1+"/receiveAddress/update")
                                            .params(map)
                                            .execute(new StringCallback() {
                                                @Override
                                                public void onSuccess(Response<String> response) {
                                                    WaitDialog.dismiss();
                                                    String body = response.body();
                                                    try {
                                                        JSONObject jsonObject = new JSONObject(body);
                                                        if (jsonObject.getInt("status") == 1){
                                                            finish();
                                                            ToastUtils.showShort("修改成功");
                                                        }
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }
                                                }

                                                @Override
                                                public void onStart(Request<String, ? extends Request> request) {
                                                    WaitDialog.show(AddRegionActivity.this, "载入中...");
                                                    super.onStart(request);
                                                }
                                            });
                                }
                            }, "取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                        }else{
                            ToastUtils.showShort("请输入详细地址");
                        }
                    }else{
                        ToastUtils.showShort("请选择所在区域");
                    }
                }else{
                    ToastUtils.showShort("请输入正确手机号");
                }
            }else{
                ToastUtils.showShort("请输入收货人手机号");
            }
        }else{
            ToastUtils.showShort("请输入收货人姓名");
        }
    }

    private void initBaoCun() {
        if (!name.isEmpty()){
            if (!phone.isEmpty()){
                if (RegexUtils.isMobileExact(phone)){
                    if (!tv_dizhi.toString().isEmpty()){
                        if (!xiangxidizhi.isEmpty()){
                            SelectDialog.show(AddRegionActivity.this, "提示", "是否保存当前收货地址",
                                    "确定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Map<String,String> map = new HashMap<>();
                                            map.put("createBy",String.valueOf(id));
                                            map.put("provinceName",provinceName);
                                            map.put("cityName",cityName);
                                            map.put("areaName",areaName);
                                            map.put("detailAddr",xiangxidizhi);
                                            map.put("receiverName",name);
                                            map.put("phone",phone);
                                            map.put("isDefault",String.valueOf(isDefault));
                                            OkGo.<String>post(Contacts.URl1+"/receiveAddress/add")
                                                    .params(map)
                                                    .execute(new StringCallback() {
                                                        @Override
                                                        public void onSuccess(Response<String> response) {
                                                            WaitDialog.dismiss();
                                                            String body = response.body();
                                                            try {
                                                                JSONObject jsonObject = new JSONObject(body);
                                                                if (jsonObject.getInt("status") == 1){
                                                                    finish();
                                                                    ToastUtils.showShort("添加成功");
                                                                }
                                                            } catch (JSONException e) {
                                                                e.printStackTrace();
                                                            }
                                                        }

                                                        @Override
                                                        public void onStart(Request<String, ? extends Request> request) {
                                                            WaitDialog.show(AddRegionActivity.this, "载入中...");
                                                            super.onStart(request);
                                                        }
                                                    });
                                        }
                                    },
                                    "取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    });
                        }else{
                            ToastUtils.showShort("请输入详细地址");
                        }
                    }else{
                        ToastUtils.showShort("请选择所在区域");
                    }
                }else{
                    ToastUtils.showShort("请输入正确手机号");
                }
            }else{
                ToastUtils.showShort("请输入收货人手机号");
            }
        }else{
            ToastUtils.showShort("请输入收货人姓名");
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

    /**
     * 隐藏键盘
     */
    protected void hideInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View v = getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}
