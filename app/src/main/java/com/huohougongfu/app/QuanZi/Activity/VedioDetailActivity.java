package com.huohougongfu.app.QuanZi.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dingmouren.layoutmanagergroup.viewpager.OnViewPagerListener;
import com.dingmouren.layoutmanagergroup.viewpager.ViewPagerLayoutManager;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.GuanZhuDongTai;
import com.huohougongfu.app.Gson.MyDongTai;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.Gson.QuanZiXiHuan;
import com.huohougongfu.app.Gson.VedioDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.VedioComment;
import com.huohougongfu.app.PopupView.VedioContentDetail;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.WaitDialog;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cn.jzvd.JzvdStd;

public class VedioDetailActivity extends AppCompatActivity {

    private JzvdStd jzvdStd;
    private int dId,mId;
    private String token;
    private RecyclerView mRecyclerView;
    private ViewPagerLayoutManager mLayoutManager;
    private MyAdapter mAdapter;
    private HashMap<String,String> map;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            playVideo();
        }
    };
    private MyAdapter.ViewHolder viewHolderForAdapterPosition;
    private QuanZiFaXian.ResultBean.DatasBean.ListBean shipin;
    private SmartRefreshLayout refreshLayout;
    private int page = 2;
    private GuanZhuDongTai.ResultBean.ListBean shipin2;
    private MyDongTai.ResultBean.ListBean dongtaishipin;
    private QuanZiXiHuan.ResultBean.DatasBean.ListBean likeshipin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_detail);
        dId = getIntent().getIntExtra("dId", 0);

        dongtaishipin = (MyDongTai.ResultBean.ListBean) getIntent().getSerializableExtra("动态视频");
        shipin = (QuanZiFaXian.ResultBean.DatasBean.ListBean) getIntent().getSerializableExtra("小视频");
        shipin2 = (GuanZhuDongTai.ResultBean.ListBean) getIntent().getSerializableExtra("视频");
        likeshipin = (QuanZiXiHuan.ResultBean.DatasBean.ListBean) getIntent().getSerializableExtra("喜欢视频");

        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        map  = new HashMap<>();
        initDeta();
    }

    private void initDeta() {
        map.clear();
        map.put("token",token);
        map.put("mId",String.valueOf(mId));
        map.put("dataId",String.valueOf(dId));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/circle/video")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        WaitDialog.dismiss();
                        Gson gson = new Gson();
                        VedioDetail vedio = gson.fromJson(response.body(), VedioDetail.class);
                        if (vedio.getStatus()==1){
                            if (vedio.getResult().getList().size()>0){
                                initView(vedio.getResult());
                                refreshLayout.finishLoadmore(true);//传入false表示刷新失败
                            }else{
                                refreshLayout.finishLoadmoreWithNoMoreData();
                            }
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        WaitDialog.show(VedioDetailActivity.this,"正在加载。。。");
                        super.onStart(request);

                    }
                });
    }

    private void initView(VedioDetail.ResultBean datas) {
        mRecyclerView = findViewById(R.id.recycler);
        mLayoutManager = new ViewPagerLayoutManager(this, OrientationHelper.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
//        p = shipin.getget(position1).getPage()+1;
        mAdapter = new MyAdapter(datas);
        mRecyclerView.setLayoutManager(mLayoutManager);
        utils.MoveToPosition(mLayoutManager,0);
        mRecyclerView.setAdapter(mAdapter);
        refreshLayout = findViewById(R.id.refreshLayout);
        //下拉刷新设置经典样式
        refreshLayout.setRefreshHeader(new ClassicsHeader(this).setEnableLastTime(true));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        //上拉加载
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                map.clear();
                map.put("token",token);
                map.put("mId",String.valueOf(mId));
                map.put("type",String.valueOf(3));
                map.put("pageNo",String.valueOf(page++));
                map.put("pageSize",String.valueOf(10));
                OkGo.<String>post(Contacts.URl1+"/circle/data")
                        .params(map)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                Gson gson = new Gson();
                                VedioDetail shipin = gson.fromJson(response.body(), VedioDetail.class);
                                if (shipin.getStatus()==1){
                                    if (shipin.getResult().getList()!=null){
                                        mAdapter.add(shipin.getResult());
                                        refreshlayout.finishLoadmore(true);//传入false表示刷新失败
                                    }else{
                                        refreshlayout.finishLoadmoreWithNoMoreData();
                                    }
                                }
                            }
                        });
            }
        });
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Message message = Message.obtain();
                    handler.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initListener(){
        mLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {

            @Override
            public void onInitComplete() {

            }

            @Override
            public void onPageRelease(boolean isNext,int position) {
//                Log.e(TAG,"释放位置:"+position +" 下一页:"+isNext);
                viewHolderForAdapterPosition = (MyAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(position);
                if (viewHolderForAdapterPosition !=null) {
                    if (shipin != null) {
                        Picasso.get().load(shipin.getPicture())
                                .into(viewHolderForAdapterPosition.img_thumb);
                    }else if (shipin2 != null){
                        Picasso.get().load(shipin2.getPicture())
                                .into(viewHolderForAdapterPosition.img_thumb);
                    }else if (dongtaishipin != null){
                        Picasso.get().load(dongtaishipin.getPicture())
                                .into(viewHolderForAdapterPosition.img_thumb);
                    }else if(likeshipin!=null){
                        Picasso.get().load(likeshipin.getPicture())
                                .into(viewHolderForAdapterPosition.img_thumb);
                    }
                    viewHolderForAdapterPosition.img_thumb.setVisibility(View.VISIBLE);
                    viewHolderForAdapterPosition.img_play.animate().alpha(0f).start();
                }
            }

            @Override
            public void onPageSelected(int position,boolean isBottom) {
//                Log.e(TAG,"选中位置:"+position+"  是否是滑动到底部:"+isBottom);

            }

        });
    }
    /**
     * 播放视频
     */
    @SuppressLint("NewApi")
    private void playVideo() {
        int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
        viewHolderForAdapterPosition = (MyAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
        if (shipin2!=null){
            Picasso.get().load(shipin2.getPicture())
                    .into(viewHolderForAdapterPosition.img_thumb);
            viewHolderForAdapterPosition.videoView.setVideoURI(
                    Uri.parse(shipin2.getPicture()));
            viewHolderForAdapterPosition.videoView.start();

            viewHolderForAdapterPosition.img_thumb.setVisibility(View.GONE);
        }else if (shipin != null){
            Picasso.get().load(shipin.getPicture())
                    .into(viewHolderForAdapterPosition.img_thumb);
            viewHolderForAdapterPosition.videoView.setVideoURI(
                    Uri.parse(shipin.getPicture()));
            viewHolderForAdapterPosition.videoView.start();

            viewHolderForAdapterPosition.img_thumb.setVisibility(View.GONE);
        }else if (dongtaishipin != null){
            Picasso.get().load(dongtaishipin.getPicture())
                    .into(viewHolderForAdapterPosition.img_thumb);
            viewHolderForAdapterPosition.videoView.setVideoURI(
                    Uri.parse(dongtaishipin.getPicture()));
            viewHolderForAdapterPosition.videoView.start();

            viewHolderForAdapterPosition.img_thumb.setVisibility(View.GONE);
        }else  if (likeshipin != null){
            Picasso.get().load(likeshipin.getPicture())
                    .into(viewHolderForAdapterPosition.img_thumb);
            viewHolderForAdapterPosition.videoView.setVideoURI(
                    Uri.parse(likeshipin.getPicture()));
            viewHolderForAdapterPosition.videoView.start();

            viewHolderForAdapterPosition.img_thumb.setVisibility(View.GONE);
        }


    }

    /**
     * 停止播放
     */
    private void releaseVideo(){
        int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
        viewHolderForAdapterPosition = (MyAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
        viewHolderForAdapterPosition.videoView.stopPlayback();
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements PopupWindow.OnDismissListener {
        private VedioDetail.ResultBean shipindetail;
        private MediaPlayer mediaPlayer;
//        private SmallVideo.DataBean data;
        private PopupWindow popupWindow;
        private ViewHolder holder;
        private View view;
        private int navigationHeight;
        private EditText edt_video_pinglun;
        private Intent intent;

        public MyAdapter(VedioDetail.ResultBean shipin){
            this.shipindetail = shipin;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            navigationHeight = getResources().getDimensionPixelSize(resourceId);
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager,parent,false);
            intent= new Intent();
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int i) {
            if (holder != null) {
                this.holder = holder;
                if (!shipindetail.getList().get(i).getPicture().isEmpty()){
                    Picasso.get().load(shipindetail.getList().get(i).getPicture());
                    holder.videoView.setVideoURI(
                            Uri.parse(shipindetail.getList().get(i).getPicture()));
                }
                if (shipindetail.getList().get(i).getIsPraise() == 1){
                    holder.img_dianzan.setImageResource(R.mipmap.img_xihuan2);
                }else{
                    holder.img_dianzan.setImageResource(R.mipmap.img_xihuan);
                }
                if (shipindetail.getList().get(i).getMember().getIsAttention() == 1){
                    holder.bt_guanzhu.setImageResource(R.mipmap.img_vedio_yiguanzhu);
                }else{
                    holder.bt_guanzhu.setImageResource(R.mipmap.img_vedio_guanzhu);
                }
                mediaPlayer = new MediaPlayer();
                holder.videoView.start();
                if (shipindetail.getList().get(i).getTitle()!=null){
                    holder.tv_vedio_title.setText(shipindetail.getList().get(i).getTitle());
                }else{
                    holder.tv_vedio_title.setText("");
                }
                RequestOptions requestOptions = new RequestOptions().circleCrop();
                Glide.with(VedioDetailActivity.this).load(shipindetail.getList().get(i).getMember().getPhoto())
                        .apply(requestOptions).into(holder.img_video_touxiang);
                holder.tv_vedio_content.setText(shipindetail.getList().get(i).getContent());
                holder.tv_video_dianzan.setText(String.valueOf(shipindetail.getList().get(i).getPraiseNum()));
                holder.tv_video_pinglun.setText(String.valueOf(shipindetail.getList().get(i).getCommentNum()));
                holder.tv_vedio_time.setText(shipindetail.getList().get(i).getUpdateTime());
                if (shipindetail.getList().get(i).getAddress()!=null){
                    holder.tv_vedio_weizhi.setText(shipindetail.getList().get(i).getAddress());
                }
                holder.bt_fanhui.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                holder.bt_gengduo.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        new XPopup.Builder(VedioDetailActivity.this)
                                .hasShadowBg(false)
                                .offsetY(-10)
                                .offsetX(00)
                                .popupPosition(PopupPosition.Left) //手动指定弹窗的位置
                                .atView(holder.bt_gengduo)  // 依附于所点击的View，内部会自动判断在上方或者下方显示
                                .asAttachList(new String[]{"分享", "举报"},
                                        new int[]{},
                                        new OnSelectListener() {
                                            @Override
                                            public void onSelect(int position, String text) {
                                                if(Build.VERSION.SDK_INT>=23){
                                                    String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,
                                                            Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE,
                                                            Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,
                                                            Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
                                                    ActivityCompat.requestPermissions(VedioDetailActivity.this,mPermissionList,123);
                                                }
                                                if ("分享".equals(text)){
                                                    UMWeb web = new UMWeb("http://www.baidu.com");//连接地址
                                                    web.setTitle("火后功夫");//标题
                                                    web.setDescription("123456");//描述
                                                    if (TextUtils.isEmpty("")) {
                                                        web.setThumb(new UMImage(VedioDetailActivity.this, R.mipmap.img_back));  //本地缩略图
                                                    } else {
                                                        web.setThumb(new UMImage(VedioDetailActivity.this, ""));  //网络缩略图
                                                    }
                                                    new ShareAction(VedioDetailActivity.this)
                                                            .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,
                                                                    SHARE_MEDIA.WEIXIN,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN_CIRCLE)
                                                            .withMedia(web)
                                                            .setCallback(new UMShareListener() {
                                                                @Override
                                                                public void onStart(SHARE_MEDIA share_media) {

                                                                }

                                                                @Override
                                                                public void onResult(SHARE_MEDIA share_media) {

                                                                }

                                                                @Override
                                                                public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                                                                }

                                                                @Override
                                                                public void onCancel(SHARE_MEDIA share_media) {

                                                                }
                                                            }).open();

                                                }else if ("举报".equals(text)){
                                                    intent.putExtra("dataId",String.valueOf(dId));
                                                    intent.putExtra("username",shipindetail.getList().get(i).getMember().getNickName());
                                                    intent.putExtra("photo",shipindetail.getList().get(i).getPicture());
                                                    intent.putExtra("title",shipindetail.getList().get(i).getTitle());
                                                    intent.setClass(VedioDetailActivity.this,JuBaoActivity.class);
                                                    startActivity(intent);
                                                }
                                            }
                                        })
                                .show();
                    }
                });
                //点赞
                holder.bt_video_dianzan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!"".equals(token)){
                            if (shipindetail.getList().get(i).getIsPraise() == 0){
                                initDianZan("1",shipindetail.getList().get(i));
                            }else{
                                if (!utils.isDoubleClick()){
                                    initQuXiaoDianZan("0",shipindetail.getList().get(i));
                                }
                            }
                        }else{
                            ToastUtils.showShort(R.string.denglu);
                        }
                    }
                });

                holder.bt_video_pinglun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!"".equals(token)){
                            new XPopup.Builder(VedioDetailActivity.this)
//                                    .moveUpToKeyboard(false) //如果不加这个，评论弹窗会移动到软键盘上面
                                    .asCustom(new VedioComment(VedioDetailActivity.this,dId)/*.enableDrag(false)*/)
                                    .show();
                        }else{
                            ToastUtils.showShort(R.string.denglu);
                        }
                    }
                });

                holder.tv_chakanxiangqing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (shipindetail.getList().get(i).getContent()!=null){
                            new XPopup.Builder(VedioDetailActivity.this)
                                    .moveUpToKeyboard(false) //如果不加这个，评论弹窗会移动到软键盘上面
                                    .asCustom(new VedioContentDetail(VedioDetailActivity.this,shipindetail.getList().get(i).getContent())/*.enableDrag(false)*/)
                                    .show();
                        }
                    }
                });

                holder.bt_guanzhu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            if (!utils.isDoubleClick()){
                                if (!"".equals(token)){
                                    if (shipindetail.getList().get(i).getMember().getIsAttention() == 1){
                                        initNoGuanZhu(0,shipindetail.getList().get(i),i);
                                    }else if (shipindetail.getList().get(i).getMember().getIsAttention() == 0)
                                        initGuanZhu(1,shipindetail.getList().get(i),i);
                                }
                                }else{
                                    ToastUtils.showShort(R.string.denglu);
                            }
                    }
                });
            }
        }

        private void initGuanZhu(int type, VedioDetail.ResultBean.ListBean userid, int i) {
            Map<String,String> map =new HashMap<>();
            map.put("mId",String.valueOf(mId));
            map.put("attentionId",String.valueOf(userid.getMember().getUserId()));
            map.put("type",String.valueOf(type));
            map.put("token",token);
            OkGo.<String>post(Contacts.URl1+"/circle/attention")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.body());
                                if (jsonObject.getInt("status") == 1){
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                    userid.getMember().setIsAttention(1);
                                    ToastUtils.showShort("关注成功");
                                    holder.bt_guanzhu.setImageResource(R.mipmap.img_vedio_yiguanzhu);
                                }else{
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }

        private void initNoGuanZhu(int type, VedioDetail.ResultBean.ListBean userid, int i) {
            Map<String,String> map =new HashMap<>();
            map.put("mId",String.valueOf(mId));
            map.put("attentionId",String.valueOf(userid.getMember().getUserId()));
            map.put("type",String.valueOf(type));
            map.put("token",token);
            OkGo.<String>post(Contacts.URl1+"/circle/attention")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.body());
                                if (jsonObject.getInt("status") == 1){
                                    ToastUtils.showShort("取消关注");
                                    userid.getMember().setIsAttention(0);
                                    holder.bt_guanzhu.setImageResource(R.mipmap.img_vedio_guanzhu);
                                }else{
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }

        //取消点赞
        private void initQuXiaoDianZan(String type, VedioDetail.ResultBean.ListBean listBean) {
            Map<String,String> map = new HashMap<>();
            map.put("type",type);
            map.put("dataId",String.valueOf(listBean.getId()));
            map.put("mId",String.valueOf(mId));
            map.put("token",token);

            OkGo.<String>post(Contacts.URl1+"/circle/praise")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    String num = holder.tv_video_dianzan.getText().toString();
                                    Integer integer = Integer.valueOf(num);
                                    holder.tv_video_dianzan.setText(String.valueOf(integer-1));
                                    listBean.setIsPraise(0);
                                    holder.img_dianzan.setImageResource(R.mipmap.img_xihuan);
                                    ToastUtils.showShort("取消点赞");
                                }else{
                                    ToastUtils.showShort(jsonObject.getString("msg"));

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }

        //点赞
        private void initDianZan(String type, VedioDetail.ResultBean.ListBean listBean) {
            String num = holder.tv_video_dianzan.getText().toString();
            Map<String,String> map = new HashMap<>();
            map.put("type",type);
            map.put("dataId",String.valueOf(listBean.getId()));
            map.put("mId",String.valueOf(mId));
            map.put("token",token);

            OkGo.<String>post(Contacts.URl1+"/circle/praise")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            String body = response.body();
                            try {
                                JSONObject jsonObject = new JSONObject(body);
                                if (jsonObject.getInt("status") == 1){
                                    ToastUtils.showShort("点赞成功");
                                    Integer integer = Integer.valueOf(num);
                                    holder.tv_video_dianzan.setText(String.valueOf(integer+1));
                                    listBean.setIsPraise(1);
                                    holder.img_dianzan.setImageResource(R.mipmap.img_xihuan2);
                                }else{
                                    ToastUtils.showShort(jsonObject.getString("msg"));

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
        //设置屏幕背景透明效果
        public void setBackgroundAlpha(float alpha) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.alpha = alpha;
            getWindow().setAttributes(lp);
        }


        @Override
        public int getItemCount() {
            return shipindetail.getList().size();
        }

        @Override
        public void onDismiss() {
            setBackgroundAlpha(1);
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView img_thumb;
            VideoView videoView;
            ImageView img_play,img_video_shoucang,img_dianzan,img_video_touxiang,bt_guanzhu;
            RelativeLayout rootView;
            View bt_fanhui,bt_video_dianzan,bt_video_fenxiang,view_fenxiang,bt_video_pinglun,bt_gengduo;
            TextView tv_video_dianzan,tv_video_pinglun,tv_vedio_time,tv_vedio_title,tv_vedio_content,tv_vedio_weizhi,tv_chakanxiangqing;
            EditText edt_video_pinglun;

            public ViewHolder(View itemView) {
                super(itemView);
                img_thumb = itemView.findViewById(R.id.img_thumb);
                videoView = itemView.findViewById(R.id.video_view);
                img_play = itemView.findViewById(R.id.img_play);
                bt_fanhui = itemView.findViewById(R.id.bt_fanhui);
                rootView = itemView.findViewById(R.id.root_view);
                bt_gengduo = itemView.findViewById(R.id.bt_gengduo);
                img_video_touxiang = itemView.findViewById(R.id.img_video_touxiang);
                bt_guanzhu = itemView.findViewById(R.id.bt_guanzhu);
                tv_video_dianzan = itemView.findViewById(R.id.tv_video_dianzan);
                tv_video_pinglun = itemView.findViewById(R.id.tv_video_pinglun);

                tv_vedio_title = itemView.findViewById(R.id.tv_vedio_title);
                tv_vedio_content = itemView.findViewById(R.id.tv_vedio_content);

                tv_vedio_time = itemView.findViewById(R.id.tv_vedio_time);
                tv_vedio_weizhi = itemView.findViewById(R.id.tv_vedio_weizhi);
                img_dianzan = itemView.findViewById(R.id.img_dianzan);

                bt_video_dianzan =itemView.findViewById(R.id.bt_video_dianzan);
                bt_video_pinglun =itemView.findViewById(R.id.bt_video_pinglun);
                tv_chakanxiangqing = itemView.findViewById(R.id.tv_chakanxiangqing);

                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        img_thumb.setVisibility(View.VISIBLE);
//                        img_thumb.animate().alpha(255).setDuration(10).start();
                        videoView.start();
                    }
                });

                videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {

                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        mediaPlayer = mp;
                        mp.setLooping(true);
                        img_thumb.setVisibility(View.GONE);
//                        img_thumb.animate().alpha(0).setDuration(200).start();
                        return false;
                    }

                });

                img_play.setOnClickListener(new View.OnClickListener() {
                    boolean isPlaying = true;
                    @Override
                    public void onClick(View v) {
                        if (videoView.isPlaying()){
                            img_play.animate().alpha(1f).start();
                            videoView.pause();
                            isPlaying = false;
                        }else {
                            img_play.animate().alpha(0f).start();
                            videoView.start();
                            isPlaying = true;
                        }
                    }
                });
            }

        }

        //下面两个方法提供给页面刷新和加载时调用
        public void add(VedioDetail.ResultBean data1) {
            //增加数据
            int position = shipindetail.getList().size();
            shipindetail.getList().addAll(position, data1.getList());
            notifyItemInserted(position);
        }

        public void refresh(VedioDetail.ResultBean data1)  {
            //刷新数据
            shipindetail.getList().removeAll(shipindetail.getList());
            shipindetail.getList().addAll(data1.getList());
            notifyDataSetChanged();
        }

    }
}
