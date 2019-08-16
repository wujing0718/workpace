package com.huohougongfu.app.Shop.Adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.SouSuoDianPu;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Shop.Activity.ShangPinDetailActivity;

import java.util.List;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

public class SouSuoDianPuAdapter extends BaseQuickAdapter<SouSuoDianPu.ResultBean.ListBean,BaseViewHolder> {
    private List<SouSuoDianPu.ResultBean.ListBean> data;
    public SouSuoDianPuAdapter(int layoutResId, @Nullable List<SouSuoDianPu.ResultBean.ListBean> data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, SouSuoDianPu.ResultBean.ListBean item) {
        ImageView img_sousuo_dianpu_logo = helper.getView(R.id.img_sousuo_dianpu_logo);
        RecyclerView rec_dianpu_shangpin = helper.getView(R.id.rec_dianpu_shangpin);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(MyApp.context).load(item.getStoreLogo()).apply(requestOptions).into(img_sousuo_dianpu_logo);
        helper.setText(R.id.tv_sousuo_dianpu_name,item.getStoreName());
        helper.setText(R.id.tv_sousuo_dianpu_year,item.getYear()+"年老店");
        helper.setText(R.id.tv_sousuo_dianpu_favorableRate,"好评率"+item.getFavorableRate()+"%");
        helper.setText(R.id.tv_sousuo_dianpu_fensNum,"粉丝数"+item.getFensNum());

        //创建LinearLayoutManager 对象 这里使用 LinearLayoutManager 是线性布局的意思
        GridLayoutManager layoutmanager = new GridLayoutManager(MyApp.getInstances(),3);
        //设置RecyclerView 布局
        rec_dianpu_shangpin.setLayoutManager(layoutmanager);
        int firstVisibleItemPosition = layoutmanager.findFirstVisibleItemPosition()+1;
        if (data.get(firstVisibleItemPosition).getMallProductList().size()>0){
            DianPuItemAdapter shangPinTuiJianAdapter = new DianPuItemAdapter(MyApp.getInstances(),data.get(firstVisibleItemPosition).getMallProductList());
            rec_dianpu_shangpin.setAdapter(shangPinTuiJianAdapter);
            shangPinTuiJianAdapter.setOnItemClickListener(new DianPuItemAdapter.OnItemClickListener() {
                @Override
                public void onItemClickListener(int pos) {
                    Intent intent = new Intent();
                    intent.putExtra("id",item.getMallProductList().get(pos).getId());
                    intent.setClass(MyApp.context,ShangPinDetailActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
