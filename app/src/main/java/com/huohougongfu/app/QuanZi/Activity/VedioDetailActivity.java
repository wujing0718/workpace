package com.huohougongfu.app.QuanZi.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
import com.huohougongfu.app.Gson.OKGson;
import com.huohougongfu.app.Gson.PingLunGson;
import com.huohougongfu.app.Gson.QuanZiDetail;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.Gson.QuanZiShare;
import com.huohougongfu.app.Gson.QuanZiXiHuan;
import com.huohougongfu.app.Gson.VedioDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.PopupView.VedioComment;
import com.huohougongfu.app.PopupView.VedioContentDetail;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.IListener;
import com.huohougongfu.app.Utils.ListenerManager;
import com.huohougongfu.app.Utils.utils;
import com.kongzue.dialog.v2.SelectDialog;
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
import java.util.List;
import java.util.Map;

import cn.jzvd.JzvdStd;

public class VedioDetailActivity extends AppCompatActivity implements IListener {

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
    private QuanZiShare share;
    private VedioDetail vedio;
    private String citycode;
    private int userid;
    public static VedioDetailActivity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_detail);
        activity = this;
        dId = getIntent().getIntExtra("dId", 0);
        userid = getIntent().getIntExtra("userid", 0);
        refreshLayout = findViewById(R.id.refreshLayout);
        ListenerManager.getInstance().registerListtener(this);
        dongtaishipin = (MyDongTai.ResultBean.ListBean) getIntent().getSerializableExtra("动态视频");
        shipin = (QuanZiFaXian.ResultBean.DatasBean.ListBean) getIntent().getSerializableExtra("小视频");
        shipin2 = (GuanZhuDongTai.ResultBean.ListBean) getIntent().getSerializableExtra("关注视频");
        likeshipin = (QuanZiXiHuan.ResultBean.DatasBean.ListBean) getIntent().getSerializableExtra("喜欢视频");
        mId = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        map  = new HashMap<>();
        initDeta();
        initViedioNum();
    }

    private void initViedioNum() {
        OkGo.<String>post(Contacts.URl1+"/circle/addVideoBrowseCount")
                .params("dataId",dId)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                    }
                });
    }

    private void initDeta() {
        map.clear();
        map.put("token",token);
        map.put("mId",String.valueOf(mId));
        map.put("dataId",String.valueOf(dId));
        OkGo.<String>post(Contacts.URl1+"/circle/video")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        vedio = gson.fromJson(response.body(), VedioDetail.class);
                        if (vedio.getStatus()==1){
                            if (vedio.getResult().size()>0){
                                initView(vedio.getResult());
                                refreshLayout.finishLoadmore(true);//传入false表示刷新失败
                            }else{
                                refreshLayout.finishLoadmoreWithNoMoreData();
                            }
                        }
                    }

                    @Override
                    public void onStart(Request<String, ? extends Request> request) {
                        super.onStart(request);

                    }
                });
    }


    private void initView(List<VedioDetail.ResultBean> datas) {
        mRecyclerView = findViewById(R.id.recycler);
        mLayoutManager = new ViewPagerLayoutManager(this, OrientationHelper.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
//        p = shipin.getget(position1).getPage()+1;
        mAdapter = new MyAdapter(datas);
        mRecyclerView.setOnFlingListener(null);
        mRecyclerView.setLayoutManager(mLayoutManager);
        utils.MoveToPosition(mLayoutManager,0);
        mRecyclerView.setAdapter(mAdapter);
        //下拉刷新设置经典样式
        refreshLayout.setRefreshHeader(new ClassicsHeader(this).setEnableLastTime(true));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        //上拉加载
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                map.clear();
                map.put("mId",String.valueOf(mId));
                map.put("type",String.valueOf(3));
                map.put("dataId",String.valueOf(datas.get(datas.size()-1).getId()));
                OkGo.<String>post(Contacts.URl1+"/circle/video")
                        .params(map)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                Gson gson = new Gson();
                                VedioDetail shipin = gson.fromJson(response.body(), VedioDetail.class);
                                shipin.getResult().remove(0);
                                if (shipin.getStatus()==1){
                                    if (shipin.getResult()!=null){
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
                viewHolderForAdapterPosition = (MyAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(position);
                if (viewHolderForAdapterPosition !=null) {
                    if (shipin != null) {
                        viewHolderForAdapterPosition.tv_video_dianzan.setText(String.valueOf(shipin.getPraiseNum()));
                        Picasso.get().load(shipin.getPicture())
                                .into(viewHolderForAdapterPosition.img_thumb);
                    }else if (shipin2 != null){
                        viewHolderForAdapterPosition.tv_video_dianzan.setText(String.valueOf(shipin2.getPraiseNum()));
                        Picasso.get().load(shipin2.getPicture())
                                .into(viewHolderForAdapterPosition.img_thumb);
                    }else if (dongtaishipin != null){
                        viewHolderForAdapterPosition.tv_video_dianzan.setText(String.valueOf(dongtaishipin.getPraiseNum()));
                        Picasso.get().load(dongtaishipin.getPicture())
                                .into(viewHolderForAdapterPosition.img_thumb);
                    }else if(likeshipin!=null){
                        viewHolderForAdapterPosition.tv_video_dianzan.setText(String.valueOf(likeshipin.getPraiseNum()));
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

    // 获取圈子分享链接
    private void initShiPinShare(VedioDetail.ResultBean listBean) {
        Map<String,String> map = new HashMap<>();
        map.put("dataId",String.valueOf(listBean.getId()));
        map.put("type",String.valueOf(listBean.getType()));
        map.put("photoUrl",listBean.getMember().getPhoto());
        OkGo.<String>post(Contacts.URl1+"/circle/getShareUrl")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        QuanZiShare quanZiShare = new Gson().fromJson(body, QuanZiShare.class);
                        if (quanZiShare.getStatus() == 1){
                            share = quanZiShare;
                        }
                    }
                });
    }

//    private void initDongTaiShiPinShare(MyDongTai.ResultBean.ListBean dongtaishipin) {
//        Map<String,String> map = new HashMap<>();
//        map.put("dataId",String.valueOf(shipin.getId()));
//        map.put("type",String.valueOf(shipin.getType()));
//        map.put("photoUrl",shipin.getMember().getPhoto());
//        OkGo.<String>post(Contacts.URl1+"/circle/getShareUrl")
//                .params(map)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        String body = response.body();
//                        QuanZiShare quanZiShare = new Gson().fromJson(body, QuanZiShare.class);
//                        if (quanZiShare.getStatus() == 1){
//                            share = quanZiShare;
//                        }
//                    }
//                });
//    }
//
//    private void initShiPin2Share(GuanZhuDongTai.ResultBean.ListBean shipin) {
//        Map<String,String> map = new HashMap<>();
//        map.put("dataId",String.valueOf(shipin.getId()));
//        map.put("type",String.valueOf(shipin.getType()));
//        map.put("photoUrl",shipin.getMember().getPhoto());
//        OkGo.<String>post(Contacts.URl1+"/circle/getShareUrl")
//                .params(map)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        String body = response.body();
//                        QuanZiShare quanZiShare = new Gson().fromJson(body, QuanZiShare.class);
//                        if (quanZiShare.getStatus() == 1){
//                            share = quanZiShare;
//                        }
//                    }
//                });
//    }
//
//    private void initLikeShiPinShare(QuanZiXiHuan.ResultBean.DatasBean.ListBean likeshipin) {
//        Map<String,String> map = new HashMap<>();
//        map.put("dataId",String.valueOf(shipin.getId()));
//        map.put("type",String.valueOf(shipin.getType()));
//        map.put("photoUrl",shipin.getMember().getPhoto());
//        OkGo.<String>post(Contacts.URl1+"/circle/getShareUrl")
//                .params(map)
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        String body = response.body();
//                        QuanZiShare quanZiShare = new Gson().fromJson(body, QuanZiShare.class);
//                        if (quanZiShare.getStatus() == 1){
//                            share = quanZiShare;
//                        }
//                    }
//                });
//    }


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
            dId = vedio.getResult().get(firstVisibleItemPosition).getId();
            Picasso.get().load(dongtaishipin.getPicture())
                    .into(viewHolderForAdapterPosition.img_thumb);
            viewHolderForAdapterPosition.videoView.setVideoURI(
                    Uri.parse(dongtaishipin.getPicture()));
            viewHolderForAdapterPosition.videoView.start();
            viewHolderForAdapterPosition.img_thumb.setVisibility(View.GONE);
        }else  if (likeshipin != null){
            dId = vedio.getResult().get(firstVisibleItemPosition).getId();
            Picasso.get().load(likeshipin.getPicture())
                    .into(viewHolderForAdapterPosition.img_thumb);
            viewHolderForAdapterPosition.videoView.setVideoURI(
                    Uri.parse(likeshipin.getPicture()));
            viewHolderForAdapterPosition.videoView.start();
            viewHolderForAdapterPosition.img_thumb.setVisibility(View.GONE);
        }


    }

    @Override
    public void notifyAllActivity(int audience_cnt, String status) {
        if (audience_cnt == 1001){
            citycode = status;
            initDeta();
        }
    }

//    /**
//     * 停止播放
//     */
//    private void releaseVideo(){
//        int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
//        viewHolderForAdapterPosition = (MyAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
//        viewHolderForAdapterPosition.videoView.stopPlayback();
//    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements PopupWindow.OnDismissListener ,IListener {
        private List<VedioDetail.ResultBean> shipindetail;
        private MediaPlayer mediaPlayer;
//        private SmallVideo.DataBean data;
        private PopupWindow popupWindow;
        private View view;
        private int navigationHeight;
        private EditText edt_video_pinglun;
        private Intent intent;
        @SuppressLint("HandlerLeak")
        Handler mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        //完成主界面更新,拿到数据
                        boolean data = (boolean)msg.obj;
                        if (data == true){
                            int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
                            viewHolderForAdapterPosition = (MyAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
                            shipindetail.get(firstVisibleItemPosition).setCommentNum(shipindetail.get(firstVisibleItemPosition).getCommentNum()+1);
                            String s = String.valueOf(shipindetail.get(firstVisibleItemPosition).getCommentNum());
                            viewHolderForAdapterPosition.tv_video_pinglun.setText(s);
                        }
                        break;
                    default:
                        break;
                }
            }

        };

        public MyAdapter(List<VedioDetail.ResultBean> datas) {
            shipindetail = datas;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            ListenerManager.getInstance().registerListtener(this);
            navigationHeight = getResources().getDimensionPixelSize(resourceId);
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager,parent,false);
            intent= new Intent();
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int i) {
            String[] split = shipindetail.get(i).getPicture().split(",");
            if (split.length == 1){
                shipindetail.get(i).setPicture(split[0]);
            }else if (split.length == 2){
                shipindetail.get(i).setPicture(split[1]);
            }
                if (!shipindetail.get(i).getPicture().isEmpty()){
                    Picasso.get().load(shipindetail.get(i).getPicture());
                    holder.videoView.setVideoURI(
                            Uri.parse(shipindetail.get(i).getPicture()));
                }
                if (shipindetail.get(i).getIsPraise() == 1){
                    holder.img_dianzan.setImageResource(R.mipmap.img_xihuan2);
                }else{
                    holder.img_dianzan.setImageResource(R.mipmap.img_xihuan);
                }
                if (shipindetail.get(i).getMember().getIsAttention() == 1){
                    holder.bt_guanzhu.setImageResource(R.mipmap.img_vedio_yiguanzhu);
                }else{
                    holder.bt_guanzhu.setImageResource(R.mipmap.img_vedio_guanzhu);
                }
                mediaPlayer = new MediaPlayer();
                holder.videoView.start();
                if (shipindetail.get(i).getTitle()!=null){
                    holder.tv_vedio_title.setText(shipindetail.get(i).getTitle());
                }else{
                    holder.tv_vedio_title.setText("");
                }
                Glide.with(MyApp.context).load(split[0]).into(holder.img_thumb);
                dId = shipindetail.get(i).getId();
                RequestOptions requestOptions = new RequestOptions().circleCrop();
                Glide.with(VedioDetailActivity.this).load(shipindetail.get(i).getMember().getPhoto())
                        .apply(requestOptions).into(holder.img_video_touxiang);
                holder.tv_vedio_content.setText(shipindetail.get(i).getContent());
                holder.tv_video_dianzan.setText(String.valueOf(shipindetail.get(i).getPraiseNum()));
                holder.tv_video_pinglun.setText(String.valueOf(shipindetail.get(i).getCommentNum()));
                holder.tv_vedio_time.setText(shipindetail.get(i).getUpdateTime());
                if (shipindetail.get(i).getAddress()!=null){
                    holder.img_dingwei.setVisibility(View.VISIBLE);
                    holder.tv_vedio_weizhi.setText(shipindetail.get(i).getAddress());
                }else{
                    holder.img_dingwei.setVisibility(View.GONE);
                }
                initShiPinShare(shipindetail.get(i));

                holder.bt_fanhui.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                holder.bt_gengduo.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String[] caozuo;
                        if (userid == MyApp.instance.getInt("id")){
                            caozuo = new String[]{"分享", "举报","删除"};
                        }else{
                            caozuo= new String[]{"分享", "举报"};
                        }
                        new XPopup.Builder(VedioDetailActivity.this)
                                .hasShadowBg(false)
                                .offsetY(-10)
                                .offsetX(00)
                                .popupPosition(PopupPosition.Left) //手动指定弹窗的位置
                                .atView(holder.bt_gengduo)  // 依附于所点击的View，内部会自动判断在上方或者下方显示
                                .asAttachList(caozuo, new int[]{},
                                        new OnSelectListener() {
                                            @Override
                                            public void onSelect(int position, String text) {
                                                if ("分享".equals(text)){
                                                    UMWeb web = new UMWeb(share.getResult().getUrl());//连接地址
                                                    web.setTitle(share.getResult().getTitle());//标题
                                                    web.setDescription(share.getResult().getContent());//描述
                                                    if (share.getResult().getPhoto()!=null) {
                                                        web.setThumb(new UMImage(VedioDetailActivity.this, share.getResult().getPhoto()));  //网络缩略图
                                                    } else {
                                                        web.setThumb(new UMImage(VedioDetailActivity.this, R.mipmap.img_zhanweitu));  //本地缩略图
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
                                                                    ToastUtils.showShort("分享成功");
                                                                }

                                                                @Override
                                                                public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                                                                }

                                                                @Override
                                                                public void onCancel(SHARE_MEDIA share_media) {
                                                                    ToastUtils.showShort("取消分享");
                                                                }
                                                            }).open();

                                                }else if ("举报".equals(text)){
                                                    intent.putExtra("dataId",String.valueOf(dId));
                                                    intent.putExtra("username",shipindetail.get(i).getMember().getNickName());
                                                    intent.putExtra("photo",shipindetail.get(i).getPicture());
                                                    intent.putExtra("title",shipindetail.get(i).getTitle());
                                                    intent.setClass(VedioDetailActivity.this,JuBaoActivity.class);
                                                    startActivity(intent);
                                                }else if ("删除".equals(text))
                                                    SelectDialog.show(VedioDetailActivity.this, "提示", "是否删除该条圈子",
                                                            "确定", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    //删除这条圈子
                                                                    initDel(dId);
                                                                }
                                                            },
                                                            "取消", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                }
                                                            });
                                            }
                                        })
                                .show();
                    }
                });
                //点赞
                holder.bt_video_dianzan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            if (shipindetail.get(i).getIsPraise() == 0){
                                initDianZan("1",shipindetail.get(i),holder);
                            }else{
                                if (!utils.isDoubleClick()){
                                    initQuXiaoDianZan("0",shipindetail.get(i),holder);
                                }
                            }
                    }
                });

                holder.bt_video_pinglun.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        initPingLunLieBiao(shipindetail.get(i).getId());
                    }
                });

                holder.tv_chakanxiangqing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (shipindetail.get(i).getContent()!=null){
                            new XPopup.Builder(VedioDetailActivity.this)
                                    .moveUpToKeyboard(false) //如果不加这个，评论弹窗会移动到软键盘上面
                                    .asCustom(new VedioContentDetail(VedioDetailActivity.this,shipindetail.get(i).getContent())/*.enableDrag(false)*/)
                                    .show();
                        }
                    }
                });

                holder.bt_guanzhu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            if (!utils.isDoubleClick()){
                                if (!"".equals(token)){
                                    if (shipindetail.get(i).getMember().getIsAttention() == 1)
                                        initNoGuanZhu(0, shipindetail.get(i).getMember(), holder);
                                    else if (shipindetail.get(i).getMember().getIsAttention() == 0)
                                        initGuanZhu(1,shipindetail.get(i).getMember(),holder);
                                }
                                }else{
                                    ToastUtils.showShort(R.string.denglu);
                            }
                    }
                });
        }

        private void initPingLunLieBiao(int id) {
            new XPopup.Builder(VedioDetailActivity.this)
//                                                          .moveUpToKeyboard(false) //如果不加这个，评论弹窗会移动到软键盘上面
                    .asCustom(new VedioComment(VedioDetailActivity.this,id,mHandler)/*.enableDrag(false)*/)
                    .show();

        }

        private void initDel(int id) {
            Map<String,String> map = new HashMap<>();
            map.put("mId",String.valueOf(MyApp.instance.getInt("id")));
            map.put("dataIds",String.valueOf(id));
            OkGo.<String>post(Contacts.URl1+"/circle/del")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.body());
                                if (jsonObject.getInt("status") == 1){
                                    finish();
                                }else{
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }

        private void initGuanZhu(int type, VedioDetail.ResultBean.MemberBean member, ViewHolder holder) {
            Map<String,String> map =new HashMap<>();
            map.put("mId",String.valueOf(mId));
            map.put("attentionId",String.valueOf(member.getUserId()));
            map.put("type",String.valueOf(type));
            map.put("token",token);
            OkGo.<String>post(Contacts.URl1+"/circle/attention")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            OKGson okGson = new Gson().fromJson(response.body(), OKGson.class);
                            if (okGson.getStatus() == 1){
                                new Handler(VedioDetailActivity.this.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                                        member.setIsAttention(1);
                                        ToastUtils.showShort("关注成功");
                                        holder.bt_guanzhu.setImageResource(R.mipmap.img_vedio_yiguanzhu);
                                    }
                                });
                            }else{
                                ToastUtils.showShort(okGson.getMsg());
                            }
                        }
                    });
        }

        private void initNoGuanZhu(int type, VedioDetail.ResultBean.MemberBean member, ViewHolder holder) {
            Map<String,String> map =new HashMap<>();
            map.put("mId",String.valueOf(mId));
            map.put("attentionId",String.valueOf(member.getUserId()));
            map.put("type",String.valueOf(type));
            map.put("token",token);
            OkGo.<String>post(Contacts.URl1+"/circle/attention")
                    .params(map)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            OKGson okGson = new Gson().fromJson(response.body(), OKGson.class);
                            if (okGson.getStatus() == 1){
                                new Handler(VedioDetailActivity.this.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                                        ToastUtils.showShort("取消关注");
                                        member.setIsAttention(0);
                                        holder.bt_guanzhu.setImageResource(R.mipmap.img_vedio_guanzhu);
                                    }
                                });
                            }else{
                                ToastUtils.showShort(okGson.getMsg());
                            }
                        }
                    });
        }

        //取消点赞
        private void initQuXiaoDianZan(String type, VedioDetail.ResultBean listBean, ViewHolder holder) {
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
                            OKGson okGson = new Gson().fromJson(response.body(), OKGson.class);
                            if (okGson.getStatus() == 1) {
                                new Handler(VedioDetailActivity.this.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                                        int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
                                        viewHolderForAdapterPosition = (MyAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
                                        listBean.setPraiseNum(listBean.getPraiseNum()-1);
                                        String s = String.valueOf(listBean.getPraiseNum());
//                                        Integer integer = Integer.valueOf(num);
                                        holder.tv_video_dianzan.setText(s );
                                        listBean.setIsPraise(0);
                                        holder.img_dianzan.setImageResource(R.mipmap.img_xihuan);
                                        ToastUtils.showShort("取消点赞");
                                    }
                                });
                            }else{
                                ToastUtils.showShort(okGson.getMsg());
                            }
                        }
                    });
        }

        //点赞
        private void initDianZan(String type, VedioDetail.ResultBean listBean, ViewHolder holder) {
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
                            OKGson okGson = new Gson().fromJson(response.body(), OKGson.class);
                            if (okGson.getStatus() == 1){
                                new Handler(VedioDetailActivity.this.getMainLooper()).post(new Runnable() {
                                    @Override
                                    public void run() {
                                        // 在这里执行你要想的操作 比如直接在这里更新ui或者调用回调在 在回调中更新ui
                                        int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
                                        viewHolderForAdapterPosition = (MyAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
                                        listBean.setPraiseNum(listBean.getPraiseNum()+1);
                                        String s = String.valueOf(listBean.getPraiseNum());
                                        ToastUtils.showShort("点赞成功");
//                                        Integer integer = Integer.valueOf(num);
                                        holder.tv_video_dianzan.setText(s);
                                        listBean.setIsPraise(1);
//                                        listBean.setCommentNum(integer+1);
                                        holder.img_dianzan.setImageResource(R.mipmap.img_xihuan2);
                                    }
                                });
                            }else{
                                ToastUtils.showShort(okGson.getMsg());
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
            return shipindetail.size();
        }

        @Override
        public void onDismiss() {
            setBackgroundAlpha(1);
        }

        @Override
        public void notifyAllActivity(int audience_cnt, String status) {
            if (audience_cnt == 30){
                if ("是".equals(status)){
//                    int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
//                    viewHolderForAdapterPosition = (MyAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(firstVisibleItemPosition);
//                    viewHolderForAdapterPosition.tv_video_pinglun.setText(String.valueOf(Integer.valueOf(shipindetail.getList().get(firstVisibleItemPosition).getCommentNum())));
                }
            }
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView img_thumb;
            VideoView videoView;
            ImageView img_play,img_video_shoucang,img_dianzan,img_video_touxiang,bt_guanzhu,img_dingwei;
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
                img_dingwei = itemView.findViewById(R.id.img_dingwei);
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
        public void add(List<VedioDetail.ResultBean> data1) {
            //增加数据
            int position = shipindetail.size();
            shipindetail.addAll(position, data1);
            notifyItemInserted(position);
        }

        public void refresh(List<VedioDetail.ResultBean> data1)  {
            //刷新数据
            shipindetail.removeAll(shipindetail);
            shipindetail.addAll(data1);
            notifyDataSetChanged();
        }

    }
}
