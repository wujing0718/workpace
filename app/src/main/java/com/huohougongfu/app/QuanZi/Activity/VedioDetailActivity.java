package com.huohougongfu.app.QuanZi.Activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.dingmouren.layoutmanagergroup.viewpager.OnViewPagerListener;
import com.dingmouren.layoutmanagergroup.viewpager.ViewPagerLayoutManager;
import com.google.gson.Gson;
import com.huohougongfu.app.Gson.QuanZiDetail;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.Gson.VedioDetail;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.CircleTransform;
import com.huohougongfu.app.Utils.Contacts;
import com.huohougongfu.app.Utils.utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import okhttp3.Call;

public class VedioDetailActivity extends AppCompatActivity {

    private JzvdStd jzvdStd;
    private int dId,mid;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_detail);
        dId = getIntent().getIntExtra("dId", 0);
        shipin = (QuanZiFaXian.ResultBean.DatasBean.ListBean) getIntent().getSerializableExtra("小视频");
        mid = MyApp.instance.getInt("id");
        token = MyApp.instance.getString("token");
        map  = new HashMap<>();
        initDeta();
    }

    private void initDeta() {
        map.clear();
        map.put("token",token);
        map.put("mId",String.valueOf(mid));
        map.put("dataId",String.valueOf(dId));
        map.put("pageNo",String.valueOf(1));
        map.put("pageSize",String.valueOf(10));
        OkGo.<String>post(Contacts.URl1+"/circle/video")
                .params(map)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
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
                map.put("mId",String.valueOf(mid));
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
                    Thread.sleep(3000);
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

    @Override
    protected void onStop() {
        super.onStop();
        finish();
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
                    if (!shipin.getPicture().isEmpty()) {
                        Picasso.get().load(shipin.getPicture())
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
        Picasso.get().load(shipin.getPicture())
                .into(viewHolderForAdapterPosition.img_thumb);
        viewHolderForAdapterPosition.videoView.setVideoURI(
                Uri.parse(shipin.getPicture()));
        viewHolderForAdapterPosition.videoView.start();

        viewHolderForAdapterPosition.img_thumb.setVisibility(View.GONE);

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
        private VedioDetail.ResultBean shipin;
        private MediaPlayer mediaPlayer;
//        private SmallVideo.DataBean data;
        private PopupWindow popupWindow;
        private ViewHolder holder;
        private View view;
        private int navigationHeight;
        private EditText edt_video_pinglun;

        public MyAdapter(VedioDetail.ResultBean shipin){
            this.shipin = shipin;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
            navigationHeight = getResources().getDimensionPixelSize(resourceId);
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int i) {
            if (holder != null) {
                this.holder = holder;
//                initFengXiang(i);
                if (!shipin.getList().get(i).getPicture().isEmpty()){
                    Picasso.get().load(shipin.getList().get(i).getPicture());
                    holder.videoView.setVideoURI(
                            Uri.parse(shipin.getList().get(i).getPicture()));
                }
                mediaPlayer = new MediaPlayer();
                holder.videoView.start();
                holder.tv_name.setText(shipin.getList().get(i).getTitle());
                holder.tv_title.setText(shipin.getList().get(i).getContent());

//                Picasso.get()
//                        .load(shipin.getList().get(i).getMember().getPhoto())
//                        .transform(new CircleTransform())
//                        .into(holder.img_touxiang);
//                //点赞
//                holder.bt_video_dianzan.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Map<String, String> map = new HashMap<>();
//                        if (token!=null && token.length()>0){
//                            map.put("token", token);
//                        }else{
////                            Toast.makeText(YuLeActivity.this, "未登录或登录状态过期", Toast.LENGTH_SHORT).show();
//                        }
//                        map.put("target_id", String.valueOf(data.getId()));
//                        if (data.getIs_laud() == 0) {
//                            map.put("status", "1");
//                            OkGo.get(Contacts.WenZhangDianZanlurl)
//                                    .params(map)
//                                    .execute(new StringCallback() {
//                                        @Override
//                                        public void onSuccess(String s, Call call, okhttp3.Response response) {
//                                            Gson gson = new Gson();
//                                            TongYong2Gson dianzan = gson.fromJson(s, TongYong2Gson.class);
//                                            if (dianzan.getCode().equals("1")) {
//                                                data.setIs_laud(1);
//                                                holder.tv_video_dianzan.setText(String.valueOf(data.getLaud_num() + 1));
//                                                holder.img_dianzan.setImageResource(R.mipmap.ic_dianzan_hong2);
//                                            } else if (dianzan.getCode().equals("0")) {
//
//                                            }
//                                        }
//                                    });
//                        } else if (data.getIs_laud() == 1) {
//                            map.put("status", "0");
//                            OkGo.get(Contacts.WenZhangDianZanlurl)
//                                    .params(map)
//                                    .execute(new StringCallback() {
//                                        @Override
//                                        public void onSuccess(String s, Call call, okhttp3.Response response) {
//                                            Gson gson = new Gson();
//                                            TongYong2Gson dianzan = gson.fromJson(s, TongYong2Gson.class);
//                                            if (dianzan.getCode().equals("1")) {
//                                                data.setIs_laud(0);
//                                                holder.img_dianzan.setImageResource(R.mipmap.ic_dianzan_bai);
//                                                holder.tv_video_dianzan.setText(String.valueOf(data.getLaud_num()));
//                                            } else if (dianzan.getCode().equals("0")) {
//                                            }
//                                        }
//                                    });
//                        }
//                    }
//                });
//                //分享
//                holder.bt_video_fenxiang.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (holder.view_fenxiang.getVisibility() == View.GONE) {
//                            holder.view_fenxiang.setVisibility(View.VISIBLE);
//                        } else if (holder.view_fenxiang.getVisibility() == View.VISIBLE) {
//                            holder.view_fenxiang.setVisibility(View.GONE);
//                        }
//                    }
//                });
//                //收藏
//                holder.img_video_shoucang.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Map<String, String> map = new HashMap<>();
//                        if (token!=null && token.length()>0){
//                            map.put("token", token);
//                        }else{
//                            Toast.makeText(YuLeActivity.this, "未登录或登录状态过期", Toast.LENGTH_SHORT).show();
//                        }
//                        map.put("target_id", String.valueOf(data.getId()));
//                        if (data.getIs_collect() == 0) {
//                            map.put("status", "1");
//                            OkGo.get(Contacts.WenZhangShouCanglurl)
//                                    .params(map)
//                                    .execute(new StringCallback() {
//                                        @Override
//                                        public void onSuccess(String s, Call call, okhttp3.Response response) {
//                                            Gson gson = new Gson();
//                                            TongYong2Gson shoucang = gson.fromJson(s, TongYong2Gson.class);
//                                            if (shoucang.getCode().equals("1")) {
//                                                data.setIs_collect(1);
//                                                holder.img_video_shoucang.setImageResource(R.mipmap.ic_video_shoucang);
//                                            } else {
//                                            }
//                                        }
//                                    });
//                        } else if (data.getIs_collect() == 1) {
//                            map.put("status", "0");
//                            OkGo.get(Contacts.WenZhangShouCanglurl)
//                                    .params(map)
//                                    .execute(new StringCallback() {
//                                        @Override
//                                        public void onSuccess(String s, Call call, okhttp3.Response response) {
//                                            Gson gson = new Gson();
//                                            TongYong2Gson shoucang = gson.fromJson(s, TongYong2Gson.class);
//                                            if (shoucang.getCode().equals("1")) {
//                                                data.setIs_collect(0);
//                                                holder.img_video_shoucang.setImageResource(R.mipmap.ic_shoucang_bai);
//                                            } else {
//
//                                            }
//                                        }
//                                    });
//                        }
//                    }
//
//                });

                holder.bt_fanhui.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });

//                holder.bt_fengxiang_quxiao.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        holder.view_fenxiang.setVisibility(View.GONE);
//                    }
//                });
//
//                holder.bt_video_pinglun.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        openPopupWindow(v,i);
//                    }
//                });

            }
        }

//        private void openPopupWindow(View v, int i) {
//            //防止重复按按钮
//            if (popupWindow != null && popupWindow.isShowing()) {
//                return;
//            }
//            //设置PopupWindow的View
//            view = LayoutInflater.from(YuLeActivity.this).inflate(R.layout.include_video_pinglun, null);
//            popupWindow = new PopupWindow(view, RelativeLayout.LayoutParams.MATCH_PARENT,
//                    RelativeLayout.LayoutParams.WRAP_CONTENT);
//            //设置背景,这个没什么效果，不添加会报错
//            popupWindow.setBackgroundDrawable(new BitmapDrawable());
//            //设置点击弹窗外隐藏自身
//            popupWindow.setFocusable(true);
//            popupWindow.setOutsideTouchable(true);
//            //设置动画
//            popupWindow.setAnimationStyle(R.style.PopupWindow);
//            //设置位置
//            popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, navigationHeight);
//            //设置消失监听
//            popupWindow.setOnDismissListener(this);
//            //设置PopupWindow的View点击事件
//            setOnPopupViewClick(view,i);
//            //设置背景色
//            setBackgroundAlpha(0.5f);
//        }
//
//        private void setOnPopupViewClick(View view, int i) {
//            initPinglunLieBiao(i);
//
//            edt_video_pinglun = view.findViewById(R.id.edt_video_pinglun);
//            view.findViewById(R.id.bt_guanbi).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    popupWindow.dismiss();
//                }
//            });
//            //添加评论
//            view.findViewById(R.id.bt_pinglun).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    initPingLun(i);
//                }
//            });
//
//
//        }
//
//        private void initPinglunLieBiao(int i) {
//            Map<String,String> map = new HashMap<>();
//            map.put("target_id",shipin.getData().get(i).getId()+"");
//            map.put("type","1");
//            OkGo.get(Contacts.WenZhangPingLunlurl)
//                    .params(map)
//                    .execute(new StringCallback() {
//                        @Override
//                        public void onSuccess(String s, Call call, okhttp3.Response response) {
//                            Gson gson = new Gson();
//                            WenZhangPingLunGson pingLunGson = gson.fromJson(s, WenZhangPingLunGson.class);
//                            if(pingLunGson.getCode() == 1){
//                                RecyclerView rcv_video_pinglun = view.findViewById(R.id.rcv_video_pinglun);
//                                View zanwuneirong = view.findViewById(R.id.zanwuneirong);
//                                if (pingLunGson.getData().size()>0) {
//                                    SmallVideoPinglunAdapter smallvideo = new SmallVideoPinglunAdapter(YuLeActivity.this, pingLunGson.getData());
//                                    LinearLayoutManager layoutManager = new LinearLayoutManager(YuLeActivity.this, LinearLayoutManager.VERTICAL, false) {
//                                        @Override
//                                        public boolean canScrollVertically() {
//                                            return true;
//                                        }
//                                    };
//                                    //设置布局管理器
//                                    rcv_video_pinglun.setLayoutManager(layoutManager);
//                                    rcv_video_pinglun.setAdapter(smallvideo);
//                                }else{
//                                    zanwuneirong.setVisibility(View.VISIBLE);
//                                    rcv_video_pinglun.setVisibility(View.GONE);
//                                }
//                            }
//                        }
//                    });
//        }
//
//        private void initPingLun(int i) {
//            String pinglun = edt_video_pinglun.getText().toString();
//            if (pinglun!=null && pinglun.length()>0){
//                Map<String,String> map = new HashMap<>();
//                if (token!=null && token.length()>0){
//                    map.put("token", token);
//                }else{
//                    Toast.makeText(YuLeActivity.this, "未登录或登录状态过期", Toast.LENGTH_SHORT).show();
//                }
//                map.put("target_id",shipin.getData().get(i).getId()+"");
//                map.put("type",String.valueOf(1));
//                map.put("content",pinglun);
//                OkGo.post(Contacts.TianJiaPingLunlurl)
//                        .params(map)
//                        .execute(new StringCallback() {
//                            @Override
//                            public void onSuccess(String s, Call call, okhttp3.Response response) {
//                                Gson gson = new Gson();
//                                TongYong2Gson pinglun = gson.fromJson(s, TongYong2Gson.class);
//                                if (pinglun.getCode().equals("1")){
//                                    Toast.makeText(YuLeActivity.this, "评论成功", Toast.LENGTH_SHORT).show();
//                                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); //得到InputMethodManager的实例
//                                    imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,InputMethodManager.HIDE_NOT_ALWAYS
//                                    );//关闭/开启软键盘
//                                    popupWindow.dismiss();
//                                }
//                            }
//                        });
//            }else{
//                Toast.makeText(YuLeActivity.this, "评论内容不能为空", Toast.LENGTH_SHORT).show();
//            }
//        }
        //设置屏幕背景透明效果
        public void setBackgroundAlpha(float alpha) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.alpha = alpha;
            getWindow().setAttributes(lp);
        }


        @Override
        public int getItemCount() {
            return shipin.getList().size();
        }

        @Override
        public void onDismiss() {
            setBackgroundAlpha(1);
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView img_thumb;
            VideoView videoView;
            ImageView img_play,img_video_shoucang,img_dianzan;
            RelativeLayout rootView;
            View bt_fanhui,bt_video_dianzan,bt_video_fenxiang,view_fenxiang,bt_video_pinglun;
            TextView tv_video_dianzan,tv_video_pinglun,tv_video_fenxiang,tv_title,tv_name;
            EditText edt_video_pinglun;
            View rl_fenxiang_QQ,rl_fenxiang_WX,rl_fenxiang_QQKJ,rl_fenxiang_PYQ,rl_fenxiang_XLWB,bt_fengxiang_quxiao;

            public ViewHolder(View itemView) {
                super(itemView);
                img_thumb = itemView.findViewById(R.id.img_thumb);
                videoView = itemView.findViewById(R.id.video_view);
                img_play = itemView.findViewById(R.id.img_play);
                bt_fanhui = itemView.findViewById(R.id.bt_fanhui);
                rootView = itemView.findViewById(R.id.root_view);
//                edt_video_pinglun = itemView.findViewById(R.id.edt_video_pinglun);
//                tv_video_dianzan = itemView.findViewById(R.id.tv_video_dianzan);
//                tv_video_pinglun = itemView.findViewById(R.id.tv_video_pinglun);
//                tv_video_fenxiang = itemView.findViewById(R.id.tv_video_fenxiang);
//                img_touxiang = itemView.findViewById(R.id.img_touxiang);
//                view_fenxiang = itemView.findViewById(R.id.view_fenxiang);
//                bt_video_pinglun = itemView.findViewById(R.id.bt_video_pinglun);
                tv_name = itemView.findViewById(R.id.tv_name);
                tv_title = itemView.findViewById(R.id.tv_title);
                img_dianzan = itemView.findViewById(R.id.img_dianzan);
//                rl_fenxiang_QQ = itemView.findViewById(R.id.rl_fenxiang_QQ);
//                rl_fenxiang_QQKJ = itemView.findViewById(R.id.rl_fenxiang_QQKJ);
//                rl_fenxiang_WX =itemView.findViewById(R.id.rl_fenxiang_WX);
//                rl_fenxiang_PYQ =itemView.findViewById(R.id.rl_fenxiang_PYQ);
//                rl_fenxiang_XLWB =itemView.findViewById(R.id.rl_fenxiang_XLWB);
//                bt_fengxiang_quxiao = itemView.findViewById(R.id.bt_fengxiang_quxiao);


//                bt_video_dianzan =itemView.findViewById(R.id.bt_video_dianzan);
//                bt_video_fenxiang =itemView.findViewById(R.id.bt_video_fenxiang);
//                img_video_shoucang = itemView.findViewById(R.id.img_video_shoucang);

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
            int position = shipin.getList().size();
            shipin.getList().addAll(position, data1.getList());
            notifyItemInserted(position);
        }

        public void refresh(VedioDetail.ResultBean data1)  {
            //刷新数据
            shipin.getList().removeAll(shipin.getList());
            shipin.getList().addAll(data1.getList());
            notifyDataSetChanged();
        }

    }
}
