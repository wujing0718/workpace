package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

public class YunFeiZiDingYiAdapter extends RecyclerView.Adapter<YunFeiZiDingYiAdapter.ViewHolder> {

    private List<String> list;
    private List<String> mlist = new ArrayList<>();
    private List<String> mHandler = new ArrayList<>();
    private HttpCookie bean;
    /**
     * 已经绑定文本变化监听器
     */
    private final boolean mBoundWatcher = true;
    /**
     * 输入框文本缓存
     */
    private SparseArray<String> mTextCache = new SparseArray<>();


    public YunFeiZiDingYiAdapter(ArrayList<String> list, ArrayList<String> mlist) {
        this.list = list;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(MyApp.context).inflate(R.layout.item_yunfei_zidingyi, viewGroup, false));
        return holder;
    }

    //  添加数据
    public void addData(int position) {
//      在list中添加数据，并通知条目加入一条
        list.add(position, "");
        notifyItemRangeChanged(position, list.size());
    }
    //  添加数据
    public void addYouFei(int position) {
//      在list中添加数据，并通知条目加入一条
        mlist.add(position, "");
        notifyItemRangeChanged(position, list.size());
    }

    //  删除数据
    public void removeData(int position) {
        list.remove(position);
        mlist.remove(position);
        notifyDataSetChanged();
    }
    //  修改数据
    public void setData(int position, ArrayList<String> dizhi) {
        this.mHandler = dizhi;
        String fahuocity = "";
        for (int y = 0; y <mHandler.size() ; y++) {
            fahuocity = fahuocity+" "+mHandler.get(y);
        }
        list.set(position,fahuocity);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHodel, int position) {
        if (viewHodel.edt_zidingyi_youfei.getTag() instanceof TextWatcher) {
            viewHodel.edt_zidingyi_youfei.removeTextChangedListener((TextWatcher) viewHodel.edt_zidingyi_youfei.getTag());
        }
        viewHodel.edt_zidingyi_youfei.setText(mlist.get(position));
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if (listener != null) {
//                    listener.onTextChange(position);
//                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    mlist.set(position,s.toString());
                } else {
                    mlist.set(position,"");
                }
            }
        };
        viewHodel.edt_zidingyi_youfei.addTextChangedListener(textWatcher);
        viewHodel.edt_zidingyi_youfei.setTag(textWatcher);

        viewHodel.bt_delete_zidingyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    removeData(position);
            }
        });
        viewHodel.bt_diqu_xuanze.setText(list.get(position));
        viewHodel.bt_diqu_xuanze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCountListener != null) {
                    mCountListener.onChangeCount(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView bt_delete_zidingyi,bt_diqu_xuanze;
        EditText edt_zidingyi_youfei;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bt_delete_zidingyi = itemView.findViewById(R.id.bt_delete_zidingyi);
            bt_diqu_xuanze = itemView.findViewById(R.id.bt_diqu_xuanze);
            edt_zidingyi_youfei = itemView.findViewById(R.id.edt_zidingyi_youfei);
        }
    }

    public interface OnCountListener {
        void onChangeCount(int i);
    }

    public void setOnCountListener(YunFeiZiDingYiAdapter.OnCountListener listener) {
        mCountListener = listener;
    }

    private YunFeiZiDingYiAdapter.OnCountListener mCountListener;
}
