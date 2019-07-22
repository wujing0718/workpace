package com.huohougongfu.app.Gson;

import java.io.Serializable;

public class AddressBean implements Serializable {
    private double longitude;//经度
    private double latitude;//纬度
    private String title;//信息标题
    private String text;//信息内容
    private String citycode;//城市编码
    private String adcode;//
    private String address;

    public AddressBean(double longitude, double latitude, String title, String text, String address, String citycode, String adcode) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.title = title;
        this.text = text;
        this.address = address;
        this.citycode = citycode;
        this.adcode = adcode;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getAddress() {
        return address;
    }

    public String getCityCode() {
        return citycode;
    }

    public String getAdCode() {
        return adcode;
    }
}