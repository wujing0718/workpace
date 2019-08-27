        package com.huohougongfu.app.Activity;

        import android.Manifest;
        import android.annotation.SuppressLint;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.net.Uri;
        import android.os.Build;
        import android.provider.Settings;
        import android.support.annotation.NonNull;
        import android.support.design.internal.BottomNavigationItemView;
        import android.support.design.internal.BottomNavigationMenuView;
        import android.support.design.widget.BottomNavigationView;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.KeyEvent;
        import android.view.MenuItem;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.WindowInsets;
        import android.widget.Toast;

        import com.amap.api.location.AMapLocation;
        import com.amap.api.location.AMapLocationClient;
        import com.amap.api.location.AMapLocationClientOption;
        import com.amap.api.location.AMapLocationListener;
        import com.amap.api.maps.LocationSource;
        import com.blankj.utilcode.util.LogUtils;
        import com.blankj.utilcode.util.ToastUtils;
        import com.gyf.barlibrary.ImmersionBar;
        import com.huohougongfu.app.Fragment.HomeFragment;
        import com.huohougongfu.app.Fragment.MyFragment;
        import com.huohougongfu.app.Fragment.QuanZiFragment;
        import com.huohougongfu.app.Fragment.ShopFragment;
        import com.huohougongfu.app.MyApp;
        import com.huohougongfu.app.PopupView.ChaMiGuiZe;
        import com.huohougongfu.app.PopupView.Paocha;
        import com.huohougongfu.app.QuanZi.Activity.QuanZiDetailActivity;
        import com.huohougongfu.app.R;
        import com.huohougongfu.app.Utils.NoScrollViewPager;
        import com.huohougongfu.app.Utils.PermissionPageUtils;
        import com.kongzue.dialog.v2.SelectDialog;
        import com.lxj.xpopup.XPopup;
        import com.mylhyl.acp.Acp;
        import com.mylhyl.acp.AcpListener;
        import com.mylhyl.acp.AcpOptions;

        import java.lang.reflect.Field;
        import java.util.ArrayList;
        import java.util.List;
        public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,ViewPager.OnPageChangeListener {
    private ArrayList<Fragment> fragments;
    private long firstTime = 0;
    private BottomNavigationView bottomNavigationView;
    private NoScrollViewPager viewPager;
    private MenuItem menuItem;
    private ImmersionBar immersionber;
    public static MainActivity activity;
            //定位需要的声明
            private AMapLocationClient mLocationClient = null;//定位发起端
            private AMapLocationClientOption mLocationOption = null;//定位参数
            private LocationSource.OnLocationChangedListener mListener = null;//定位监听器
            boolean isFirstLoc = true;
            private String lat;
            private String lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(MainActivity.this,mPermissionList,123);
        }
        initLoc();
        activity = this;
        immersionber = ImmersionBar.with(this);
        immersionber.statusBarDarkFont(false).init();
//        new XPopup.Builder(MainActivity.this)
//                .asCustom(new ChaMiGuiZe(MainActivity.this))
//                .show();
        bottomNavigationView = findViewById(R.id.bottomnavigationview);
        bottomNavigationView.setItemIconTintList(null);
        viewPager = findViewById(R.id.viewpager);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        viewPager.addOnPageChangeListener(this);
        bottomNavigationView.setSelectedItemId(R.id.tab_two);
        disableShiftMode(bottomNavigationView);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        findViewById(R.id.navigation_center_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PubActivity.show(MainActivity.this);
            }
        });
    }

        //请求权限后的回调:
            @Override
            public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                if (requestCode==123){
                        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {//允许
                            return;
                        } else if (grantResults[0]==PackageManager.PERMISSION_DENIED){//拒绝
                            SelectDialog.show(MainActivity.this, "提示", "需要打开权限", "确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    PermissionPageUtils.toAppSetting(MainActivity.this);
                                }
                            }, "取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                        }
                }
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            }

            @SuppressLint("RestrictedApi")
    public void disableShiftMode(BottomNavigationView navigationView) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigationView.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(i);
                itemView.setShifting(false);
                itemView.setChecked(itemView.getItemData().isChecked());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onResume() {
        super.onResume();
    }

    //双击退出
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                ToastUtils.showShort("再按一次退出程序");
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyUp(keyCode, event);
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
                                MyApp.instance.put("citycode",aMapLocation.getCityCode(),true);
                                MyApp.instance.put("city",aMapLocation.getCity(),true);
                                MyApp.instance.put("lat",lat,true);
                                MyApp.instance.put("lon",lon,true);
                                if (isFirstLoc) {
                                    //获取定位信息
                                    StringBuffer buffer = new StringBuffer();
                                    buffer.append(aMapLocation.getCountry() + ""
                                            + aMapLocation.getProvince() + ""
                                            + aMapLocation.getCity() + ""
                                            + aMapLocation.getCityCode()+""
                                            + aMapLocation.getProvince() + ""
                                            + aMapLocation.getDistrict() + ""
                                            + aMapLocation.getStreet() + ""
                                            + aMapLocation.getStreetNum()+""
                                    +aMapLocation.getAoiName());
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        switch (itemId){
            case R.id.tab_one:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tab_two:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tab_three:
                viewPager.setCurrentItem(2);
                break;
            case R.id.tab_four:
                viewPager.setCurrentItem(3);
                break;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        menuItem = bottomNavigationView.getMenu().getItem(position);
        menuItem.setChecked(true);
        if (position>=2){
            menuItem = bottomNavigationView.getMenu().getItem(position+1);
            menuItem.setChecked(true);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private Fragment[] mFragments = new Fragment[]{new HomeFragment(), new ShopFragment(), new QuanZiFragment(),new MyFragment()};

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments[position];
        }

        @Override
        public int getCount() {
            return mFragments.length;
        }
    }

    @Override
    protected void onDestroy() {
        if (immersionber!=null){
            immersionber.destroy();
        }
        super.onDestroy();
    }
}
