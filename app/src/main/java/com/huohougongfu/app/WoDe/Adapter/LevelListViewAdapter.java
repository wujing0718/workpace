package com.huohougongfu.app.WoDe.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

import java.util.ArrayList;

public class LevelListViewAdapter extends BaseAdapter {
    private final int type;
    private Context mContext;
    private View.OnClickListener onClickListener;
    private OnItemClickListener mOnItemClickListener;
    private int selectedPos = -1;
    private String selectedText = "";
    private int selectItem = 0;
    private ArrayList<String> mData;
    public LevelListViewAdapter(Context context, ArrayList<String> level, int i) {
        this.mContext=context;
        this.mData=level;
        this.type=i;
        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPos = (Integer) view.getTag();
                setSelectedPosition(selectedPos);
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, selectedPos);
                }
            }
        };
    }
    @Override
    public int getCount() {
        return mData==null?0:mData.size();
    }
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }
    /**
     * 设置选中的position,但不通知刷新
     */
    public void setSelectedPositionNoNotify(int pos,ArrayList<String> level) {
        selectedPos = pos;
        mData = level;
        if (mData != null && pos < mData.size()) {
            selectedText = mData.get(pos);
        }
    }
    /**
     * 设置选中的position,并通知刷新其它列表
     */
    public void setSelectedPosition(int pos) {
        if (mData != null && pos < mData.size()) {
            selectedPos = pos;
            selectedText = mData.get(pos);
            notifyDataSetChanged();
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.item_menu, null);
        TextView continent_text = (TextView) view.findViewById(R.id.item_name);
        String placeName = mData.get(position);

        if (type == 1){
            if (position == selectItem) {
                continent_text.setTextColor(MyApp.context.getResources().getColor(R.color.sousuoTab));
                continent_text.setBackgroundResource(R.color.white);
            } else {
                continent_text.setTextColor(MyApp.context.getResources().getColor(R.color.white));
                continent_text.setBackgroundResource(R.color.colorZi);
            }
        }else if (type == 2){
            if (position == selectItem) {
                continent_text.setTextColor(MyApp.context.getResources().getColor(R.color.sousuoTab));
                continent_text.setBackgroundResource(R.color.white);
            } else {
                continent_text.setTextColor(MyApp.context.getResources().getColor(R.color.colorZi));
                continent_text.setBackgroundResource(R.color.hui2);
            }
        }else{
            if (position == selectItem) {
                continent_text.setTextColor(MyApp.context.getResources().getColor(R.color.sousuoTab));
                continent_text.setBackgroundResource(R.color.white);
            } else {
                continent_text.setTextColor(MyApp.context.getResources().getColor(R.color.colorBlack));
                continent_text.setBackgroundResource(R.color.white);
            }
        }
        continent_text.setText(placeName);
        view.setTag(position);
        view.setOnClickListener(onClickListener);
        return view;
    }
    /**
     * 重新定义菜单选项单击接口
     */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    public void setOnItemClickListener(OnItemClickListener l) {
        mOnItemClickListener = l;
    }
}