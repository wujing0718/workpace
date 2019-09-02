package com.huohougongfu.app.SelectVideo;

import android.app.Activity;
import android.media.ThumbnailUtils;
import android.provider.MediaStore.Video.Thumbnails;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.huohougongfu.app.R;

public class PhotoSelectorAdapter extends BaseAdapter {

    ImageDir imageDir;
    Activity context;
    LayoutInflater inflator;
    LocalImageLoader localImageLoad;
    onItemCheckedChangedListener itemCheckListener;

    public interface onItemCheckedChangedListener {
        public void onItemCheckChanged(CompoundButton chBox, boolean isCheced, ImageDir iamgeDir, String path);

        public void onTakePicture(ImageDir imageDir);

        public void onShowPicture(String path);
    }

    public void setOnItemCheckdedChangedListener(onItemCheckedChangedListener listener) {
        this.itemCheckListener = listener;
    }

    public PhotoSelectorAdapter(Activity context, ImageDir imageDir) {
        this.imageDir = imageDir;
        this.context = context;
        this.inflator = LayoutInflater.from(context);
        localImageLoad = new LocalImageLoader();
    }

    @Override
    public int getCount() {
        if(imageDir!=null){
            return imageDir.getFiles().size();
        }else{
            return 0;
        }
    }

    @Override
    public String getItem(int position) {
        return imageDir.getFiles().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHodler viewHolder;
        if (convertView == null) {
            convertView = inflator.inflate(R.layout.grid_item_photo, null);
            viewHolder = new ViewHodler();
            viewHolder.chSelect = (CheckBox) convertView.findViewById(R.id.ch_photo_select);
            viewHolder.photoView = (ImageView) convertView.findViewById(R.id.img_photo);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHodler) convertView.getTag();
        }
        viewHolder.chSelect.setChecked(false);
        viewHolder.photoView.setScaleType(ScaleType.CENTER_CROP);
            viewHolder.chSelect.setVisibility(View.VISIBLE);
            viewHolder.chSelect.setTag(position);
            String path = getItem(position);
            viewHolder.chSelect.setOnCheckedChangeListener(null);
            viewHolder.chSelect.setChecked(imageDir.selectedFiles.contains(path));
            viewHolder.chSelect.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    itemCheckListener.onItemCheckChanged(buttonView, isChecked, imageDir, getItem(position));
                }
            });

            if (imageDir.getType() == ImageDir.Type.VEDIO) {
                viewHolder.photoView.setImageBitmap(ThumbnailUtils.createVideoThumbnail(path, Thumbnails.MINI_KIND));
				/*viewHolder.photoView
						.setImageBitmap(ImageUtils.getVedioThubnailPath(imageDir.getIds().get(position - 1), context));*/
            } else {
                localImageLoad.displayImage(viewHolder.photoView, getItem(position));
            }

        viewHolder.photoView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                itemCheckListener.onShowPicture(getItem(position));
            }
        });
        return convertView;
    }

    public static class ViewHodler {
        ImageView photoView;
        CheckBox chSelect;
    }
}
