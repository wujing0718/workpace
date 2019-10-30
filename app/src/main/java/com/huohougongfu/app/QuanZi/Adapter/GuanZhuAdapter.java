package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.GuanZhuDongTai;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.bumptech.glide.request.target.Target.SIZE_ORIGINAL;

public class GuanZhuAdapter extends BaseQuickAdapter<GuanZhuDongTai.ResultBean.ListBean,BaseViewHolder> {
    private List<GuanZhuDongTai.ResultBean.ListBean> data1;
    public GuanZhuAdapter(int layoutResId, @Nullable List<GuanZhuDongTai.ResultBean.ListBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, GuanZhuDongTai.ResultBean.ListBean item) {
        helper.addOnClickListener(R.id.bt_dianzan);
        View view_dingwei = helper.getView(R.id.view_dingwei);
        ImageView img_quanzi_photo = helper.getView(R.id.img_quanzi_photo);
        ImageView img_faixan_touxiang = helper.getView(R.id.img_faixan_touxiang);
        ImageView img_faixan_shoucang = helper.getView(R.id.img_faixan_shoucang);
        ImageView img_type = helper.getView(R.id.img_type);

        if (item.getType() == 1){
            String[] split = item.getPicture().split(",");
            if (split.length>1){
                img_type.setVisibility(View.VISIBLE);
                img_type.setImageResource(R.mipmap.img_photos);
            }
        }if (item.getType() == 2){
            String[] split = item.getPicture().split(",");
            if (split.length>1){
                img_type.setVisibility(View.VISIBLE);
                img_type.setImageResource(R.mipmap.img_photos);
            }
        }else if (item.getType() == 3){
            img_type.setVisibility(View.VISIBLE);
            img_type.setImageResource(R.mipmap.img_video);
        }
        String picture = item.getPicture();
        if (item.getAddress() != null) {
            view_dingwei.setVisibility(View.VISIBLE);
        } else {
            view_dingwei.setVisibility(View.GONE);
        }
        if (item.getMember().getPhoto()!=null){
            RequestOptions options = new RequestOptions().circleCrop();
            Glide.with(MyApp.context).load(item.getMember().getPhoto()).apply(options)
                    .into(img_faixan_touxiang);
        }else{
            RequestOptions options = new RequestOptions().circleCrop();
            Glide.with(MyApp.context).load(R.mipmap.img_wode1).apply(options)
                    .into(img_faixan_touxiang);
        }

        if (item.getIsPraise() == 1) {
            img_faixan_shoucang.setImageResource(R.mipmap.img_xihuan2);
        } else {
            img_faixan_shoucang.setImageResource(R.mipmap.img_xihuan);
        }

        if (picture != null) {
            String[] split = picture.split(",");
            if (split.length > 0) {
                //屏幕的宽度(px值）
                int screenWidth = MyApp.context.getResources().getDisplayMetrics().widthPixels;
                //Item的宽度，或图片的宽度
                int width = screenWidth / 2;
                RequestOptions options = new RequestOptions()
                        .override(width, SIZE_ORIGINAL);
                Glide.with(MyApp.context).load(split[0]).apply(options)
                        .into(img_quanzi_photo);
            }
        } else {
            Picasso.get().load(R.mipmap.ic_launcher).into(img_quanzi_photo);
        }
        String content1 = item.getContent();
        String newcontent = content1.replace("ゐゑを", "");
        String newcontent1 = newcontent.replace("わわ", "");
        String content = newcontent1.replace("\n", " ");
        String newcontent2 = content.replace("@&$,,", "");

        String time = utils.transForDate2(Long.valueOf(item.getCreateTime()));
        helper.setText(R.id.tv_faxian_name, item.getMember().getNickName());
        helper.setText(R.id.tv_faxian_content, newcontent2);
        helper.setText(R.id.tv_faxian_time, time);
        helper.setText(R.id.tv_xihuan_num, String.valueOf(item.getPraiseNum()));

    }

    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<GuanZhuDongTai.ResultBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position, data.size());
    }

    public void refresh(List<GuanZhuDongTai.ResultBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
