package com.huohougongfu.app.Adapter;

import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huohougongfu.app.Gson.ShangPinGson;
import com.huohougongfu.app.R;
import com.huohougongfu.app.Utils.AmountView;
import com.huohougongfu.app.Utils.SmoothCheckBox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChaTaiAdapter  extends BaseQuickAdapter<ShangPinGson.DataBean.ListBean,BaseViewHolder> {
    private Map<Integer, Boolean> map;
    private List<ShangPinGson.DataBean.ListBean> data;

    public ChaTaiAdapter(int layoutResId, @Nullable List<ShangPinGson.DataBean.ListBean> data) {
        super(layoutResId, data);
        this.data = data;
        map = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            //Checkbox初始状态置为false
            map.put(i, false);
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, ShangPinGson.DataBean.ListBean item) {
        final SmoothCheckBox checkbox = helper.getView(R.id.checkbox);
        checkbox.setChecked(map.get(helper.getPosition()),true);
        AmountView amoutview = helper.getView(R.id.amoutview);
        amoutview.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
            @Override
            public void onAmountChange(View view, int amount) {
                checkbox.setChecked(true);
            }
        });


    }

    //刷新数据
    /**
     ? ? ?* 全选，
     ? ? ?*/
    public void selectAll() {
        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
        boolean shouldall = false;
        for (Map.Entry<Integer, Boolean> entry : entries) {
            Boolean value = entry.getValue();
            if (!value) {
                shouldall = true;
                break;
            }
        }
        for (Map.Entry<Integer, Boolean> entry : entries) {
            entry.setValue(shouldall);
        }
        notifyDataSetChanged();
    }
    /**
     ? ? ?* 反选
     ? ? ?*/
    public void revertSelected() {
        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
        for (Map.Entry<Integer, Boolean> entry : entries) {
            entry.setValue(!entry.getValue());
        }
        notifyDataSetChanged();
    }
}