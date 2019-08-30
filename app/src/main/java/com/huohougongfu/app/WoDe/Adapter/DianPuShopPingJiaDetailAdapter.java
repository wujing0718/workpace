package com.huohougongfu.app.WoDe.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.MyCollect;
import com.huohougongfu.app.Gson.PingJia;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Adapter.ImageAdapter;
import com.huohougongfu.app.Utils.ListenerManager;
import com.lxj.xpopup.interfaces.XPopupImageLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class DianPuShopPingJiaDetailAdapter extends BaseQuickAdapter<PingJia.ResultBean.ListBean,BaseViewHolder> {
    private final Context context;
    private List<Object> mlist = new ArrayList<>();
    private boolean ishuifu = true;
    public DianPuShopPingJiaDetailAdapter(int layoutResId, @Nullable List<PingJia.ResultBean.ListBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PingJia.ResultBean.ListBean item) {
        RecyclerView pinglun_photo = helper.getView(R.id.pinglun_photo);
        pinglun_photo.setLayoutManager(new GridLayoutManager(context, 3));
        TextView bt_maijia_huifu = helper.getView(R.id.bt_maijia_huifu);
        View bt_pinglun_dianzan = helper.getView(R.id.view_huifu);
        EditText edt_maijiahuifu = helper.getView(R.id.edt_maijiahuifu);
        helper.addOnClickListener(R.id.bt_pinglun_dianzan);
        ImageView touxiang = helper.getView(R.id.img_pinglun_touxiang);
        ImageView img_dianzan = helper.getView(R.id.img_dianzan);
        bt_maijia_huifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ishuifu){
                    edt_maijiahuifu.setVisibility(View.VISIBLE);
                    ishuifu = false;
                }else{
                    edt_maijiahuifu.setVisibility(View.GONE);
                    ishuifu = true;
                }
            }
        });

        edt_maijiahuifu.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                InputMethodManager manager = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    //先隐藏键盘
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(edt_maijiahuifu.getApplicationWindowToken(), 0);
                    }
                    //自己需要的操作
                    ToastUtils.showShort(edt_maijiahuifu.getText().toString());
                }
                //记得返回false
                return false;
            }
        });

        //圆头像
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(context).load(item.getPhoto()).apply(options).into(touxiang);
        helper.setText(R.id.tv_name,item.getVideo());
        helper.setText(R.id.tv_dianzan_num,String.valueOf(item.getFavour()));
        helper.setText(R.id.tv_pingjia_content,item.getAppraiseContent());
        helper.setText(R.id.tv_time,item.getCreateTime());
        helper.setText(R.id.tv_chenghu,item.getLevel());
        if (item.getStatus()){
            img_dianzan.setImageResource(R.mipmap.img_dianzanok);
        }else{
            img_dianzan.setImageResource(R.mipmap.img_dianzan);
        }
        String picture1 = item.getPicture();
        if(item.getAnswerContent()!=null){
            bt_pinglun_dianzan.setVisibility(View.VISIBLE);
            bt_maijia_huifu.setVisibility(View.GONE);
            helper.setText(R.id.tv_huifu_content,item.getAnswerContent());
            helper.setText(R.id.tv_huifu_time,item.getAnswerTime());
        }else{
            bt_pinglun_dianzan.setVisibility(View.GONE);
            bt_maijia_huifu.setVisibility(View.VISIBLE);
        }
        if(picture1 !=null){
            String[] split = picture1.split(",");
            pinglun_photo.setVisibility(View.VISIBLE);
            for (int i = 0; i < split.length; i++) {
                mlist.add(split[i]);
            }
            ImageAdapter pingJiaPhotoAdapter = new ImageAdapter(mlist);
            pinglun_photo.setAdapter(pingJiaPhotoAdapter);
        }else{
            pinglun_photo.setVisibility(View.GONE);
        }
    }
    public static class ImageLoader implements XPopupImageLoader {
        @Override
        public void loadImage(int position, @NonNull Object url, @NonNull ImageView imageView) {
            //必须指定Target.SIZE_ORIGINAL，否则无法拿到原图，就无法享用天衣无缝的动画
            Glide.with(imageView).load(url).apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu).override(Target.SIZE_ORIGINAL)).into(imageView);
        }

        @Override
        public File getImageFile(@NonNull Context context, @NonNull Object uri) {
            try {
                return Glide.with(context).downloadOnly().load(uri).submit().get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

//    //下面两个方法提供给页面刷新和加载时调用
//    public void add(List<PingJia.ResultBean.ListBean> data) {
//        //增加数据
//        int position = data1.size();
//        data1.addAll(position, data);
//        notifyItemRangeChanged(position,data.size());
//    }
//
//    public void refresh(List<PingJia.ResultBean.ListBean> data) {
//        //刷新数据
//        data1.remove(data1);
//        data1.addAll(data);
//        notifyDataSetChanged();
//    }
}
