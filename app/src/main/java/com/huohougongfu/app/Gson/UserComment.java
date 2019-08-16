package com.huohougongfu.app.Gson;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class UserComment implements MultiItemEntity {
    public static final int huodong = 1;
    public static final int guanzhu = 2;
    private int itemType;

    public UserComment(int itemType){
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
