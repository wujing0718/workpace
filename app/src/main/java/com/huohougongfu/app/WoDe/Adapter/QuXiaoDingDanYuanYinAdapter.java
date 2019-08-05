package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.DingDanQuXiaoYuanYin;
import com.huohougongfu.app.R;

import java.util.List;

public class QuXiaoDingDanYuanYinAdapter extends BaseQuickAdapter<DingDanQuXiaoYuanYin.ResultBean,BaseViewHolder> {
    public QuXiaoDingDanYuanYinAdapter(int layoutResId, @Nullable List<DingDanQuXiaoYuanYin.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DingDanQuXiaoYuanYin.ResultBean item) {
        helper.setText(R.id.tv_quxiao_yuanyin,item.getReason());
    }
}
