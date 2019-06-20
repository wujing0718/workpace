package com.huohougongfu.app.UploadPictures;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.huohougongfu.app.R;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnConfirmListener;

import java.util.ArrayList;

public class PlusImageActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager viewPager; //展示图片的ViewPager
    private TextView positionTv; //图片的位置，第几张图片
    private ArrayList<String> imgList; //图片的数据源
    private int mPosition; //第几张图片
    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus_image);

        imgList = getIntent().getStringArrayListExtra(MainConstant.IMG_LIST);
        mPosition = getIntent().getIntExtra(MainConstant.POSITION, 0);
        initView();
    }

    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        positionTv = findViewById(R.id.position_tv);
        findViewById(R.id.rl_back).setOnClickListener(this);
        findViewById(R.id.delete_iv).setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);

        mAdapter = new ViewPagerAdapter(this, imgList);
        viewPager.setAdapter(mAdapter);
        positionTv.setText(mPosition + 1 + "/" + imgList.size());
        viewPager.setCurrentItem(mPosition);
    }

    //删除图片
    private void deletePic() {
        new XPopup.Builder(PlusImageActivity.this).asConfirm("要删除这张图片吗", "确定",
                new OnConfirmListener() {
                    @Override
                    public void onConfirm() {
                        imgList.remove(mPosition); //从数据源移除删除的图片
                        setPosition();
                        if (imgList.size()<1){
                            back();
                        }
                    }
                })
                .show();
    }

    //设置当前位置
    private void setPosition(){
        positionTv.setText(mPosition + 1 + "/" + imgList.size());
        viewPager.setCurrentItem(mPosition);
        mAdapter.notifyDataSetChanged();
    }

    //返回上一个页面
    private void back() {
        Intent intent = getIntent();
        intent.putStringArrayListExtra(MainConstant.IMG_LIST, imgList);
        setResult(MainConstant.RESULT_CODE_VIEW_IMG, intent);
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mPosition = position;
        positionTv.setText(position + 1 + "/" + imgList.size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                //返回
                back();
                break;
            case R.id.delete_iv:
                //删除图片
                deletePic();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //按下了返回键
            back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
