package com.huohougongfu.app.Shop.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.huohougongfu.app.MyApp;
import com.huohougongfu.app.R;

public class PingJiaPhotoAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(MyApp.context).inflate(R.layout.item_pingjia_photo, null);
            holder = new ViewHolder();
            holder.img_pingjia_photo = convertView.findViewById(R.id.img_pingjia_photo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;

    }
    class ViewHolder {
        ImageView img_pingjia_photo;
    }

}
