package com.huohougongfu.app.WoDe.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.ArrayList;

public class GuiGeAdapter extends RecyclerView.Adapter<GuiGeAdapter.ViewHolder>{

    private ArrayList<String> mguige;
    private ArrayList<String> mxianjia;
    private ArrayList<String> myuanjia;

    public GuiGeAdapter(ArrayList<String> mguige, ArrayList<String> mxianjia, ArrayList<String> myuanjia) {
        this.mguige= mguige;
        this.mxianjia= mxianjia;
        this.myuanjia= myuanjia;

    }

    //  添加数据
    public void addguige(int position) {
//      在list中添加数据，并通知条目加入一条
        mguige.add(position, "");
        notifyItemRangeChanged(position, mguige.size());
    }
    //  添加数据
    public void addxianjia(int position) {
//      在list中添加数据，并通知条目加入一条
        mxianjia.add(position, "");
        notifyItemRangeChanged(position, mguige.size());

    }
    public void addyuanjia(int position) {
//      在list中添加数据，并通知条目加入一条
        myuanjia.add(position, "");
        notifyItemRangeChanged(position, mguige.size());

    }

    //  删除数据
    public void removeData(int position) {
        mguige.remove(position);
        mxianjia.remove(position);
        myuanjia.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GuiGeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        GuiGeAdapter.ViewHolder holder = new GuiGeAdapter.ViewHolder(LayoutInflater.from(MyApp.context).inflate(R.layout.item_tianjia_shop_guige , viewGroup, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GuiGeAdapter.ViewHolder viewHolder, int position) {

        if (viewHolder.edt_guige.getTag() instanceof TextWatcher) {
            viewHolder.edt_guige.removeTextChangedListener((TextWatcher) viewHolder.edt_guige.getTag());
        }
        viewHolder.edt_guige.setText(mguige.get(position));
        TextWatcher Watcherguige = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    mguige.set(position,s.toString());
                } else {
                    mguige.set(position,"");
                }
            }
        };
        viewHolder.edt_guige.addTextChangedListener(Watcherguige);
        viewHolder.edt_guige.setTag(Watcherguige);

        if (viewHolder.edt_xianjia.getTag() instanceof TextWatcher) {
            viewHolder.edt_xianjia.removeTextChangedListener((TextWatcher) viewHolder.edt_guige.getTag());
        }
        viewHolder.edt_xianjia.setText(mxianjia.get(position));
        TextWatcher Watcherxianjia = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    mxianjia.set(position,s.toString());
                } else {
                    mxianjia.set(position,"");
                }
            }
        };
        viewHolder.edt_xianjia.addTextChangedListener(Watcherxianjia);
        viewHolder.edt_xianjia.setTag(Watcherxianjia);

        if (viewHolder.edt_yuanjia.getTag() instanceof TextWatcher) {
            viewHolder.edt_yuanjia.removeTextChangedListener((TextWatcher) viewHolder.edt_yuanjia.getTag());
        }
        viewHolder.edt_yuanjia.setText(myuanjia.get(position));
        TextWatcher Watcheryuanjia= new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    myuanjia.set(position,s.toString());
                } else {
                    myuanjia.set(position,"");
                }
            }
        };
        viewHolder.edt_yuanjia.addTextChangedListener(Watcheryuanjia);
        viewHolder.edt_yuanjia.setTag(Watcheryuanjia);

        viewHolder.bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeData(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mguige.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView bt_delete;
        EditText edt_guige,edt_xianjia,edt_yuanjia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bt_delete = itemView.findViewById(R.id.bt_delete);
            edt_guige = itemView.findViewById(R.id.edt_guige);
            edt_xianjia = itemView.findViewById(R.id.edt_xianjia);
            edt_yuanjia = itemView.findViewById(R.id.edt_yuanjia);
        }
    }

    public interface OnCountListener {
        void onChangeCount(int i);
    }

    public void setOnCountListener(GuiGeAdapter.OnCountListener listener) {
        mCountListener = listener;
    }

    private GuiGeAdapter.OnCountListener mCountListener;
}
