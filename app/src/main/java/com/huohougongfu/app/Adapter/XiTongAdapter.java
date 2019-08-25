package com.huohougongfu.app.Adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.GuanZhuDongTai;
import com.huohougongfu.app.Gson.XiTongGson;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.List;

public class XiTongAdapter  extends BaseMultiItemQuickAdapter<XiTongGson.ResultBean.ListBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    private List<XiTongGson.ResultBean.ListBean> data1;
    public XiTongAdapter(List<XiTongGson.ResultBean.ListBean> data) {
        super(data);
        this.data1 =data;
        for (int i = 0; i <data.size() ; i++) {
            if (data.get(i).getItemType() == 1){
                addItemType(1, R.layout.item_xitong_tuisong);
            }else if (data.get(i).getItemType() == 2){
                addItemType(2, R.layout.item__system_attention);
            }
        }
    }
    @Override
    protected void convert(BaseViewHolder helper, XiTongGson.ResultBean.ListBean item) {
        switch (helper.getItemViewType()) {
            case 1:
                ImageView img_tuisong = helper.getView(R.id.img_tuisong);
                helper.setText(R.id.tv_xitong_time,item.getCreateTime());
                helper.setText(R.id.tv_tuisong_title,item.getTitle());
                helper.setText(R.id.tv_tuisong_content,item.getContent());
                Glide.with(MyApp.context).load(item.getPicture())
                        .apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_tuisong);
                break;
            case 2:
                helper.setText(R.id.tv_guanzhu_content,item.getContent());
                helper.setText(R.id.tv_guanzhu_time,item.getCreateTime());
                helper.setText(R.id.tv_guanzhu_time,item.getCreateTime());
                helper.setText(R.id.img_guanzhu_name,item.getMember().getMaster().getName());
                helper.setText(R.id.img_guanzhu_levle,item.getMember().getMaster().getLevel());
                ImageView img_guanzhu_touxiang = helper.getView(R.id.img_guanzhu_touxiang);
                Glide.with(MyApp.context).load(item.getPicture())
                        .apply(new RequestOptions().placeholder(R.mipmap.img_zhanweitu)).into(img_guanzhu_touxiang);
                break;
        }
    }

    //下面两个方法提供给页面刷新和加载时调用
    public void add(List<XiTongGson.ResultBean.ListBean> data) {
        //增加数据
        int position = data1.size();
        data1.addAll(position, data);
        notifyItemRangeChanged(position, data.size());
    }

    public void refresh(List<XiTongGson.ResultBean.ListBean> data) {
        //刷新数据
        data1.remove(data1);
        data1.addAll(data);
        notifyDataSetChanged();
    }
}
