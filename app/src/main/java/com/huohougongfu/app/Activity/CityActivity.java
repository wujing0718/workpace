package com.huohougongfu.app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.desmond.citypicker.bean.BaseCity;
import com.desmond.citypicker.bin.CityPicker;
import com.desmond.citypicker.callback.IOnCityPickerCheckedCallBack;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import org.json.JSONArray;


public class CityActivity extends AppCompatActivity{

    private JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.desmond.citypicker.R.layout.city_picker);
        String city = MyApp.instance.getString("city");
        String citycode = MyApp.instance.getString("citycode");
        //高德定位
        CityPicker.with(this)
                .setUseGpsCity(true)
                .setTitleBarDrawable(R.color.colorBlack)
                .setMaxHistory(6)
                .setCustomDBName("city.sqlite")
                .setUseImmerseBar(false)
                .setOnCityPickerCallBack(new IOnCityPickerCheckedCallBack() {
                    @Override
                    public void onCityPickerChecked(BaseCity baseCity) {
                        Bundle bundle = new Bundle();
                        bundle.putString("code",baseCity.getCodeByAMap());
                        bundle.putString("cityname",baseCity.getCityName());
                        setResult(RESULT_OK,CityActivity.this.getIntent().putExtras(bundle));
                        CityActivity.this.finish();
                    }
                }).open();
        CityPicker.setGpsCityByAMap(city,citycode);

    }

    @Override
    public void onBackPressed() {
        Bundle bundle = new Bundle();
        bundle.putString("code","");
        bundle.putString("cityname","");
        setResult(RESULT_OK,CityActivity.this.getIntent().putExtras(bundle));
        CityActivity.this.finish();
    }

}
