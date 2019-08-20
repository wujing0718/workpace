package com.huohougongfu.app.WoDe.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.JsonArray;
import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;
import com.huohougongfu.app.WoDe.Activity.ShopCanShuActivity;
import com.huohougongfu.app.WoDe.Activity.ShopDetailActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CanShuAdapter extends RecyclerView.Adapter<CanShuAdapter.ViewHolder>{
    private final Context context;
    private List<String> keys;
    private ArrayList<String> list;

    public CanShuAdapter(List<String> keys, ArrayList<String> list, Context context) {
        this.keys = keys;
        this.list = list;
        this.context =context;
    }

    @NonNull
    @Override
    public CanShuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CanShuAdapter.ViewHolder holder = new CanShuAdapter.ViewHolder(LayoutInflater.from(MyApp.context).inflate(R.layout.item_tianjia_shop_canshu, viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CanShuAdapter.ViewHolder viewHodel, int i) {
        viewHodel.tv_canshu_name.setText(keys.get(i));
        if (viewHodel.edt_canshu.getTag() != null && viewHodel.edt_canshu.getTag() instanceof TextWatcher) {
            viewHodel.edt_canshu.removeTextChangedListener((TextWatcher) viewHodel.edt_canshu.getTag());
        }
        viewHodel.edt_canshu.setText(list.get(i));
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    list.set(i,s.toString());
                } else {
                    list.set(i,"");
                }
            }
        };

        viewHodel.edt_canshu.addTextChangedListener(textWatcher);
        viewHodel.edt_canshu.setTag(textWatcher);

//        bt_queding.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                JSONArray jsonArray = new JSONArray();
//                if (list.size() == keys.size()){
//                    for (int j = 0; j < list.size(); j++) {
//                        JSONObject jsonObject = new JSONObject();
//                        try {
//                            jsonObject.put("key",keys.get(j));
//                            jsonObject.put("value",list.get(j));
//                            jsonArray.put(jsonObject);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }else{
//                    ToastUtils.showShort("请输入参数");
//                }
//            }
//        });
    }
    public interface OnCountListener {
        void onChangeCount(JSONArray jsonArray);
    }

    public void setOnCountListener(OnCountListener listener) {
        mCountListener = listener;
    }

    private OnCountListener mCountListener;

    @Override
    public int getItemCount() {
        return keys.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_canshu_name;
        EditText edt_canshu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             tv_canshu_name = itemView.findViewById(R.id.tv_canshu_name);
            edt_canshu = itemView.findViewById(R.id.edt_canshu);

        }
    }
}
