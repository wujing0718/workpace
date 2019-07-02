package com.huohougongfu.app.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

public class PubActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mBtnPub;
    private LinearLayout bt_photo,bt_wenzhang, bt_vedio;
    private List<LinearLayout> mLays = new ArrayList();
    private RelativeLayout mRlMain;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub);
        intent = new Intent();
        initWindow();
        initViews();
    }

    protected void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

        }
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    }

    public static void show(Context context) {
        context.startActivity(new Intent(context, PubActivity.class));
    }

    @Override
    public void onBackPressed() {
        dismiss();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,0);
    }

    private void initViews() {
        mBtnPub = findViewById(R.id.btn_pub);
        bt_photo = findViewById(R.id.ll_pub_photo);
        bt_wenzhang = findViewById(R.id.ll_pub_wenzhang);
        bt_vedio = findViewById(R.id.ll_pub_vedio);
        mRlMain = findViewById(R.id.rl_main);
        mLays.add(bt_photo);
        mLays.add(bt_wenzhang);
        mLays.add(bt_vedio);

        bt_photo.setOnClickListener(this);
        bt_wenzhang.setOnClickListener(this);
        bt_vedio.setOnClickListener(this);
        mRlMain.setOnClickListener(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mBtnPub.animate()
                .rotation(135.0f)
                .setDuration(180)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .start();
        show(0);
        show(1);
        show(2);
    }

    private void show(int position) {
        int angle = 30 + position * 60;
        float x = (float) Math.cos(angle * (Math.PI / 180)) * UIUtils.dipTopx(this, 100);
        float y = (float) -Math.sin(angle * (Math.PI / 180)) * UIUtils.dipTopx(this, position != 1 ? 160 : 100);
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(mLays.get(position), "translationX", 0, x);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(mLays.get(position), "translationY", 0, y);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(180);
        animatorSet.play(objectAnimatorX).with(objectAnimatorY);
        animatorSet.start();
    }

    private void close() {
        mBtnPub.clearAnimation();
        mBtnPub.animate()
                .rotation(0f)
                .setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mBtnPub.setVisibility(View.GONE);
                        finish();
                    }
                })
                .start();
    }

    private void dismiss() {
        close();
        close(0);
        close(1);
        close(2);
    }

    private void close(final int position) {
        int angle = 30 + position * 60;
        float x = (float) Math.cos(angle * (Math.PI / 180)) * UIUtils.dipTopx(this, 100);
        float y = (float) -Math.sin(angle * (Math.PI / 180)) * UIUtils.dipTopx(this, position != 1 ? 160 : 100);
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(mLays.get(position), "translationX", x, 0);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(mLays.get(position), "translationY", y, 0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(180);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(objectAnimatorX).with(objectAnimatorY);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mLays.get(position).setVisibility(View.GONE);
            }
        });
        animatorSet.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_pub_photo:
                intent.setClass(PubActivity.this,FaBuActivity.class);
                startActivity(intent);
                dismiss();
                break;
            case R.id.ll_pub_wenzhang:
                ToastUtils.showShort("文章");
                break;
            case R.id.ll_pub_vedio:
                intent.setClass(PubActivity.this,FaBuVedioActivity.class);
                startActivity(intent);
                dismiss();
                break;
            case R.id.rl_main:
                dismiss();
                break;

        }
    }
}
