package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.KuaiDiName;
import com.huohougongfu.app.Gson.KuaiDiZi;
import com.huohougongfu.app.R;

import java.util.List;

public class KuaiDiNameAdapter extends BaseQuickAdapter<KuaiDiZi,BaseViewHolder> {
    public KuaiDiNameAdapter(int layoutResId, @Nullable List<KuaiDiZi> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, KuaiDiZi item) {
        helper.setText(R.id.tv_quxiao_yuanyin,item.getName());
    }
}
