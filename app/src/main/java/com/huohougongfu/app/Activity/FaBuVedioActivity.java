package com.huohougongfu.app.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.huohougongfu.app.Gson.AddressBean;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.SelectVideo.BackgroundBlurPopupWindow;
import com.huohougongfu.app.SelectVideo.BaseActivity;
import com.huohougongfu.app.SelectVideo.ImageDir;
import com.huohougongfu.app.SelectVideo.PermissionUtil;
import com.huohougongfu.app.SelectVideo.PhotoSelectorActivity;
import com.huohougongfu.app.ShouYe.Activity.JiQiAcyivity;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.listener.OnMenuItemClickListener;
import com.kongzue.dialog.v2.BottomMenu;
import com.kongzue.dialog.v2.SelectDialog;
import com.kongzue.dialog.v2.WaitDialog;
import com.luck.picture.lib.photoview.PhotoView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.squareup.picasso.Picasso;
import com.zyf.vc.ui.PlayVideoActiviy;
import com.zyf.vc.ui.RecorderActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class FaBuVedioActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout back,rl_commit;
    private ImageView start;
    private TextView pathTv;
    private EditText et_content;
    private ImageView video_looksee;
    private FrameLayout rl_look_see;

    private static final int REQUEST_CODE_GET_VEDIOS = 2000;
    private static final int REQUEST_TAKE_VIDEO_CODE = 1001;
    private String contents,titles,token,select_path,select_type;
    private ArrayList<String> selectedVedioPaths = new ArrayList<String>();
    private File file = null;
    private View v;
    private BackgroundBlurPopupWindow mPopupWindow;
    private int mId;
    private TextView tv_weizhi;
    private AddressBean data1;
    private File photouri;
    private String SPcontent;
    private String SPvediopath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_bu_vedio);
        findViewById(R.id.start).setOnClickListener(this);
        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        //获取保存的草稿箱
        SPcontent = SPUtils.getInstance("视频").getString("content");
        SPvediopath = SPUtils.getInstance("视频").getString("vedio");
        initView();
        init();
        BackgroundBlurPopupWindows();
        if (SPcontent!=null && !"".equals(SPcontent)){
            et_content.setText(SPcontent);
        }
        if (SPvediopath!=null && !"".equals(SPvediopath)){
            file = new File(SPvediopath);
            rl_look_see.setVisibility(View.VISIBLE);
            start.setVisibility(View.GONE);
            MediaMetadataRetriever media = new MediaMetadataRetriever();
            media.setDataSource(SPvediopath);// videoPath 本地视频的路径
            Bitmap bitmap  = media.getFrameAtTime(1, MediaMetadataRetriever.OPTION_CLOSEST_SYNC );
            Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, null,null));
            photouri = utils.getFile(bitmap);
            //视频封面图截取展示
            Picasso.get().load(uri).into(video_looksee);
            JzvdStd video1 = v.findViewById(R.id.video1);
            video1.setUp(SPvediopath,"",JzvdStd.SCREEN_WINDOW_NORMAL);
            video1.thumbImageView.setImageBitmap(bitmap);
            JzvdStd.releaseAllVideos();
        }
    }

    private void initView() {
        back = findViewById(R.id.bt_finish);
        back.setOnClickListener(this);
        start = findViewById(R.id.start);
        start.setOnClickListener(this);
        findViewById(R.id.view_fabud_dingwei).setOnClickListener(this);
        tv_weizhi = findViewById(R.id.tv_weizhi);
        findViewById(R.id.bt_shanchu).setOnClickListener(this);
        findViewById(R.id.bt_finish).setOnClickListener(this);
        pathTv = findViewById(R.id.path);
        rl_commit = findViewById(R.id.rl_commit);
        rl_commit.setOnClickListener(this);
        et_content = findViewById(R.id.et_content);
        rl_look_see = findViewById(R.id.rl_look_see);
        rl_look_see.setOnClickListener(this);
        video_looksee = findViewById(R.id.video_looksee);
        video_looksee.setOnClickListener(this);
    }

    private void BackgroundBlurPopupWindows(){
        v = getLayoutInflater().inflate(R.layout.dialog_looksee, null);
        mPopupWindow = new BackgroundBlurPopupWindow(v, WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT, this, true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                JzvdStd.releaseAllVideos();
            }
        });
    }



    //选择视频
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_GET_VEDIOS:
                if (resultCode == RESULT_OK) {
                    selectedVedioPaths = data.getStringArrayListExtra("selectPaths");
                    if (selectedVedioPaths.size()>0){
                        select_path = selectedVedioPaths.get(0);
                        file = new File(select_path);
                        boolean exists = file.exists();
                        if (!exists){
                            rl_look_see.setVisibility(View.GONE);
                            start.setVisibility(View.VISIBLE);
                            ToastUtils.showShort("该视频错误");
                        }else {
                            rl_look_see.setVisibility(View.VISIBLE);
                            start.setVisibility(View.GONE);
                            MediaMetadataRetriever media = new MediaMetadataRetriever();
                            media.setDataSource(select_path);// videoPath 本地视频的路径
                            Bitmap bitmap  = media.getFrameAtTime(1, MediaMetadataRetriever.OPTION_CLOSEST_SYNC );
                            Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, null,null));
                            photouri = utils.getFile(bitmap);
                            //视频封面图截取展示
                            Picasso.get().load(uri).into(video_looksee);
                            JzvdStd video1 = v.findViewById(R.id.video1);
                            video1.setUp(select_path,"",JzvdStd.SCREEN_WINDOW_NORMAL);
                            video1.thumbImageView.setImageBitmap(bitmap);
                            JzvdStd.releaseAllVideos();
                         }
                        }
                    }else{
                        finish();
                }
                break;
        }
        if (requestCode == CONTEXT_RESTRICTED){
            data1 = (AddressBean)data.getSerializableExtra("data");
            if(data1==null){
                tv_weizhi.setText("所在位置");
            }else{
                tv_weizhi.setText(data1.getTitle());
            }
        }
    }

    //拍视频
    private void init(){
        PlayVideoActiviy.setOnPickFinishListener(new PlayVideoActiviy.PickFinishListener() {
            @Override
            public void onPickFinish(String path) {
                select_path = path;
                pathTv.setText(path);
                file = new File(path);
                if (select_path.isEmpty()){
                    rl_look_see.setVisibility(View.GONE);
                    start.setVisibility(View.VISIBLE);
                }else {
                    rl_look_see.setVisibility(View.VISIBLE);
                    start.setVisibility(View.GONE);
                    MediaMetadataRetriever media = new MediaMetadataRetriever();
                    media.setDataSource(select_path);// videoPath 本地视频的路径
                    Bitmap bitmap  = media.getFrameAtTime(1, MediaMetadataRetriever.OPTION_CLOSEST_SYNC );
                    photouri = utils.getFile(bitmap);
                    Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, null,null));
                    //视频封面图截取展示
                    Picasso.get().load(uri).into(video_looksee);
                    JzvdStd video1 = v.findViewById(R.id.video1);
                    video1.setUp(select_path, "",JzvdStd.SCREEN_WINDOW_NORMAL);
                    video1.thumbImageView.setImageBitmap(bitmap);
                    JzvdStd.releaseAllVideos();
//                    Toast.makeText(FaBuVedioActivity.this,"视频已保存在"+path,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_fabud_dingwei:
                if (!utils.isDoubleClick()){
                    startActivityForResult(new Intent(FaBuVedioActivity.this, JiQiAcyivity.class), CONTEXT_RESTRICTED);
                }
                break;
            case R.id.start:
                requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, new BaseActivity.RequestPermissionCallBack() {
                    @Override
                    public void granted() {
                        if (hasSdcard()) {
                            List<String> list = new ArrayList<>();
                            list.add("拍视频");
                            list.add("选视频");
                            BottomMenu.show(FaBuVedioActivity.this, list, new OnMenuItemClickListener(){
                                @Override
                                public void onClick(String text, int index){
                                    if (text.equals("拍视频")){
                                        select_type = "1";
                                        checkTakeMediaPermission();
                                    }else if (text.equals("选视频")){
                                        select_type = "2";
                                        Intent i = new Intent(FaBuVedioActivity.this, PhotoSelectorActivity.class);
                                        i.putStringArrayListExtra("selectedPaths", selectedVedioPaths);
                                        i.putExtra("loadType", ImageDir.Type.VEDIO.toString());
                                        i.putExtra("sizeLimit", 1 * 1024 * 1024);
                                        startActivityForResult(i, REQUEST_CODE_GET_VEDIOS);
                                    }
                                }
                            }, true).setTitle("请选择上传视频的方式");
                        } else {
                            Toast.makeText(FaBuVedioActivity.this, "设备没有SD卡！", Toast.LENGTH_SHORT).show();
                            Log.e("asd", "设备没有SD卡");
                        }
                    }
                    @Override
                    public void denied() {
                        Toast.makeText(FaBuVedioActivity.this, "部分权限获取失败，正常功能受到影响", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case R.id.video_looksee:
                mPopupWindow.setBlurRadius(10);
                mPopupWindow.setDownScaleFactor(1.2f);
                mPopupWindow.setDarkColor(Color.parseColor("#a0000000"));
                mPopupWindow.resetDarkPosition();
                mPopupWindow.darkFillScreen();
                mPopupWindow.showAtLocation(rl_look_see, Gravity.CENTER, 0, 0);
                break;
            case R.id.rl_commit:
                initVedio();
                break;
            case R.id.bt_shanchu:
                SPUtils.getInstance("视频").remove("vedio");
                rl_look_see.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_finish:
                String content = et_content.getText().toString();
                if (!"".equals(content) || !"".equals(select_path) && select_path!=null){
                    SelectDialog.show(FaBuVedioActivity.this, "提示", "是否当前编辑",
                            "确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (!"".equals(content)){
                                        SPUtils.getInstance("视频").put("content",content);
                                    }
                                    if (!"".equals(select_path)){
                                        SPUtils.getInstance("视频").put("vedio",select_path);
                                    }
                                    finish();
                                }
                            },
                            "取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    SPUtils.getInstance("视频").clear(true);
                                    finish();
                                }
                            });
                }else{
                    SPvediopath = null;
                    SPUtils.getInstance("视频").clear(true);
                    finish();
                }
                break;
        }
    }


    @Override
    public void onBackPressed() {
        mPopupWindow.dismiss();
        String content = et_content.getText().toString();
        if (!"".equals(content) || !"".equals(select_path) && select_path!=null){
            SelectDialog.show(FaBuVedioActivity.this, "提示", "是否当前编辑",
                    "确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (!"".equals(content)){
                                SPUtils.getInstance("视频").put("content",content);
                            }
                            if (!"".equals(select_path)){
                                SPUtils.getInstance("视频").put("vedio",select_path);
                            }
                            finish();
                        }
                    },
                    "取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SPUtils.getInstance("视频").clear(true);
                            finish();
                        }
                    });
        }else {
            SPvediopath = null;
            SPUtils.getInstance("视频").clear(true);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initVedio() {
        String content = et_content.getText().toString();
        Map<String,String> map = new HashMap<>();
        ArrayList<File> filelist = new ArrayList<>();
        filelist.add(photouri);
        filelist.add(file);
        if (!"".equals(token)) {
            if (file!=null){
                map.put("content",content);
                map.put("type","3");
                map.put("mId",String.valueOf(mId));
                map.put("token",token);
                OkGo.<String>post(Contacts.URl1+"/circle/pub")
                        .tag(this)//
                        .isMultipart(true)
                        .params(map)
                        .addFileParams("file",filelist)
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
                                WaitDialog.show(FaBuVedioActivity.this, "上传中...");
                                super.onStart(request);
                            }
                        });
            }else{
                ToastUtils.showShort("请选择上传的视频");
            }
        }else{
            ToastUtils.showShort(R.string.denglu);
        }
    }

    private void checkTakeMediaPermission(){
        int permissionState_Camera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int permissionState_Storage = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permissionState_Audio = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
        if (permissionState_Camera != PackageManager.PERMISSION_GRANTED || permissionState_Storage != PackageManager.PERMISSION_GRANTED
                || permissionState_Audio != PackageManager.PERMISSION_GRANTED) {
            // 用户已经拒绝过一次，给用户解释提示对话框
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)){
                // 展示自定义提醒框
                SelectDialog.show(FaBuVedioActivity.this, "提示", "你必须允许相应权限,才能调起相机录制", "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PermissionUtil.requestPermissionForCamera(FaBuVedioActivity.this);
                    }
                }, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
            } else {
                PermissionUtil.requestPermissionForCamera(this);
            }
        } else {
            skipToVideoTaker();
        }
    }
    /**
     * 跳转视频拍摄
     */
    private void skipToVideoTaker(){
        startActivityForResult(new Intent(this, RecorderActivity.class),REQUEST_TAKE_VIDEO_CODE);
    }
    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED);
    }
}
