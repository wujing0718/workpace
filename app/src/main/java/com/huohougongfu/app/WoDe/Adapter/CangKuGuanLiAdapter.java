package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.haozhang.lib.SlantedTextView;
import com.huohougongfu.app.Gson.ShopGuanLiLieBiao;
import com.huohougongfu.app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CangKuGuanLiAdapter extends BaseQuickAdapter<ShopGuanLiLieBiao.ResultBean.ListBean,BaseViewHolder> {
    private List<ShopGuanLiLieBiao.ResultBean.ListBean> mMyLiveList;
    private CangKuGuanLiAdapter.OnItemClickListener mOnItemClickListener;
    private static final int MYLIVE_MODE_CHECK = 0;
    int mEditMode = MYLIVE_MODE_CHECK;

    public void setOnItemClickListener(CangKuGuanLiAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClickListener(int pos, List<ShopGuanLiLieBiao.ResultBean.ListBean> myLiveList);

    }
    public CangKuGuanLiAdapter(int layoutResId, @Nullable List<ShopGuanLiLieBiao.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }
    public List<ShopGuanLiLieBiao.ResultBean.ListBean> getMyLiveList() {
        if (mMyLiveList == null) {
            mMyLiveList = new ArrayList<>();
        }
        return mMyLiveList;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopGuanLiLieBiao.ResultBean.ListBean item) {
        final ShopGuanLiLieBiao.ResultBean.ListBean myLive = mMyLiveList.get(helper.getAdapterPosition());
        SlantedTextView slanted = helper.getView(R.id.slanted);
        TextView tv_yinli = helper.getView(R.id.tv_yinli);
        if (item.getOfCheap() == 1){
            slanted.setVisibility(View.VISIBLE);
            slanted.setText("特惠");
        }else{
            slanted.setVisibility(View.GONE);
        }
        ImageView img_jingxuan_photo = helper.getView(R.id.img_jingxuan_photo);
        Picasso.get().load(item.getCoverUrl()).into(img_jingxuan_photo);
        helper.setText(R.id.tv_jingxuan_title,item.getName());
        helper.setText(R.id.tv_jingxuan_price,String.valueOf(item.getPrice()));
        helper.setText(R.id.tv_jingxuan_name,"【"+item.getModel()+"】");
        helper.setText(R.id.tv_jingxuan_num,item.getSellNum()+"人付款");
        ImageView iv_select = helper.getView(R.id.img_guanli);
        if (item.getCommission() != null){
            tv_yinli.setVisibility(View.GONE);
            tv_yinli.setText("赚 ¥"+item.getCommission().toString());
        }
        if (mEditMode == MYLIVE_MODE_CHECK) {
            iv_select.setVisibility(View.GONE);
            myLive.setSelect(false);
        } else {
            iv_select.setVisibility(View.VISIBLE);
            if (myLive.isSelect()) {
                iv_select.setImageResource(R.mipmap.select);
            } else {
                iv_select.setImageResource(R.mipmap.unselect);
            }
        }
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClickListener(helper.getAdapterPosition(), mMyLiveList);
                }
            }
        });

    }
    public void setEditMode(int editMode) {
        mEditMode = editMode;
        notifyDataSetChanged();
    }
    public void notifyAdapter(List<ShopGuanLiLieBiao.ResultBean.ListBean> myLiveList, boolean isAdd) {
        if (!isAdd) {
            this.mMyLiveList = myLiveList;
        } else {
            this.mMyLiveList.addAll(myLiveList);
        }
        notifyDataSetChanged();
    }
}
