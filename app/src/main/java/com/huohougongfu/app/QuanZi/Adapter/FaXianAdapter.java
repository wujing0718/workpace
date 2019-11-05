package com.huohougongfu.app.QuanZi.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.QuanZiFaXian;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.utils;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.bumptech.glide.request.target.Target.SIZE_ORIGINAL;

public class FaXianAdapter extends BaseQuickAdapter<QuanZiFaXian.ResultBean.DatasBean.ListBean,BaseViewHolder> {

    private List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data1;
    public FaXianAdapter(int layoutResId, @Nullable List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data) {
        super(layoutResId, data);
        this.data1 = data;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        //屏幕的宽度(px值）
        int screenWidth = MyApp.context.getResources().getDisplayMetrics().widthPixels;
        //Item的宽度，或图片的宽度
        int width = screenWidth/2+10;
    }


    @Override
    protected void convert(BaseViewHolder helper, QuanZiFaXian.ResultBean.DatasBean.ListBean item) {
        helper.addOnClickListener(R.id.bt_dianzan);
        View view_dingwei = helper.getView(R.id.view_dingwei);
        ImageView img_quanzi_photo = helper.getView(R.id.img_quanzi_photo);
        ViewGroup.LayoutParams para = img_quanzi_photo.getLayoutParams();
        ImageView img_faixan_touxiang = helper.getView(R.id.img_faixan_touxiang);
        ImageView img_faixan_shoucang = helper.getView(R.id.img_faixan_shoucang);
        ImageView img_type = helper.getView(R.id.img_type);

        if (item.getAddress()!=null){
            view_dingwei.setVisibility(View.VISIBLE);
            helper.setText(R.id.tv_address,item.getAddress());
        }else{
            view_dingwei.setVisibility(View.GONE);
        }


        String picture = item.getPicture();
        if (item.getMember()!=null){
            if (item.getMember().getPhoto()!=null){
                RequestOptions options = new RequestOptions().circleCrop();
                Glide.with(MyApp.context).load(item.getMember().getPhoto()).apply(options)
                        .into(img_faixan_touxiang);
            }else{
                RequestOptions options = new RequestOptions().circleCrop();
                Glide.with(MyApp.context).load(R.mipmap.img_wode1).apply(options)
                        .into(img_faixan_touxiang);
            }
        }
        if (item.getIsPraise() == 1){
            img_faixan_shoucang.setImageResource(R.mipmap.img_xihuan2);
        }else{
            img_faixan_shoucang.setImageResource(R.mipmap.img_xihuan);
        }

        if (picture!= null){
            String[] split = picture.split(",");
            if (split.length>0){
                //屏幕的宽度(px值）
                int screenWidth = MyApp.context.getResources().getDisplayMetrics().widthPixels;
                //Item的宽度，或图片的宽度
                int width1 = screenWidth/2;
                if (item.getPictureHeight()!=0){
                    double wth =  (double)width1/item.getPictureWidth();
                    double hight1 = (double)wth*item.getPictureHeight();
                    para.height = (int) hight1;
                    para.width = (int)width1;
                    img_quanzi_photo.setLayoutParams(para);
                    RequestOptions options = new RequestOptions()
                            .override(width1, (int)hight1);
                    Glide.with(MyApp.context).load(split[0]).apply(options)
                            .into(img_quanzi_photo);
                }else{
                    RequestOptions options = new RequestOptions()
                            .override(width1, width1);
                    para.height = width1;
                    para.width = width1;
                    img_quanzi_photo.setLayoutParams(para);
                    Glide.with(MyApp.context).load(split[0]).apply(options)
                            .into(img_quanzi_photo);
                }
            }
        }else{
            Picasso.get().load(R.mipmap.img_zhanweitu).into(img_quanzi_photo);
        }
        String content1 = item.getContent();
        String newcontent = content1.replace("ゐゑを", "");
        String newcontent1 = newcontent.replace("わわ", "");
        String content = newcontent1.replace("\n", " ");
        String time = utils.transForDate2(Long.valueOf(item.getCreateTime()));
        helper.setText(R.id.tv_faxian_name,item.getMember().getNickName());
        helper.setText(R.id.tv_faxian_content,content);
        helper.setText(R.id.tv_faxian_time,time);
        helper.setText(R.id.tv_xihuan_num,String.valueOf(item.getPraiseNum()));

        if (item.getType() == 3){
            img_type.setVisibility(View.VISIBLE);
            img_type.setImageResource(R.mipmap.img_video);
        }else if (item.getType() == 1){
            String[] split = item.getPicture().split(",");
            if (split.length>1){
                img_type.setVisibility(View.VISIBLE);
                img_type.setImageResource(R.mipmap.img_photos);
            }else{
                img_type.setVisibility(View.GONE);
            }
        }else if (item.getType() == 2){
            String[] split = item.getPicture().split(",");
            if (split.length>1){
                img_type.setVisibility(View.VISIBLE);
                img_type.setImageResource(R.mipmap.img_photos);
            }else{
                img_type.setVisibility(View.GONE);
            }
        }
    }

    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position,data.size());
    }

    public void refresh(List<QuanZiFaXian.ResultBean.DatasBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
