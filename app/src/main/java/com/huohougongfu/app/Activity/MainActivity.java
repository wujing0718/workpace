        package com.huohougongfu.app.Activity;

        import android.Manifest;
        import android.annotation.SuppressLint;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Build;
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

        import com.blankj.utilcode.util.ToastUtils;
        import com.gyf.barlibrary.ImmersionBar;
        import com.huohougongfu.app.Fragment.HomeFragment;
        import com.huohougongfu.app.Fragment.MyFragment;
        import com.huohougongfu.app.Fragment.QuanZiFragment;
        import com.huohougongfu.app.Fragment.ShopFragment;
        import com.huohougongfu.app.R;
        import com.huohougongfu.app.Utils.NoScrollViewPager;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        immersionber = ImmersionBar.with(this);
        immersionber.statusBarDarkFont(false).init();
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
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyUp(keyCode, event);
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
