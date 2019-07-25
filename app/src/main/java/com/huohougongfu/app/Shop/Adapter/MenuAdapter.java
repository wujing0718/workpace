package com.huohougongfu.app.Shop.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huohougongfu.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 左侧菜单ListView的适配器
 *
 * @author Administrator
 */
public class MenuAdapter extends BaseAdapter {

    public static final int NI_ORDER_ITEM_HEAD = 0; // 这要从0按顺序往下变化，否则报错“数组下标溢出”，原因还不清楚
    public static final int NI_ORDER_ITEM_GOODS = 1;
    public static final int NI_ORDER_ITEM_FOOT = 2;
    private Context context;
    private int selectItem = 0;
    private List<String> title;
    private List<Integer> mlist = new ArrayList<>();
    public MenuAdapter(Context context, List<String> title) {
        this.context = context;
        this.title = title;
        mlist.add(0);
        mlist.add(1);
        mlist.add(2);
    }

    public int getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }

    @Override
    public int getItemViewType(int position) {
        try {
            int i = mlist.get(position);
            switch (i){
                case NI_ORDER_ITEM_HEAD:
                    case NI_ORDER_ITEM_GOODS:
                        case NI_ORDER_ITEM_FOOT:
                            return i;
                             }
                     } catch (Exception e) {

                     }
        return super.getItemViewType(position);
    }
    /** 获取布局类型的总数 */     @Override
     public int getViewTypeCount() {
                 return mlist.size();
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int arg0) {
        return title.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup rootview) {
        ViewHolder holder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type){

            }
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_menu, null);
            holder.tv_name = convertView.findViewById(R.id.item_name);
            convertView.setTag(holder);
        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        if (position == selectItem) {
            holder.tv_name.setTextColor(context.getResources().getColor(R.color.sousuoTab));
            holder.tv_name.setBackgroundResource(R.color.white);
        } else {
            holder.tv_name.setBackgroundResource(R.color.colorHui);
            holder.tv_name.setTextColor(context.getResources().getColor(R.color.black));
        }
        holder.tv_name.setText(title.get(position));
        return convertView;
    }

    static class ViewHolder {
        private TextView tv_name;
    }
}
