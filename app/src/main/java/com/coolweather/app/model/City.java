package com.coolweather.app.model;

/**
 * Created by xufeng on 2016/2/29.
 */
public class City {
    private int id;
    private String cityName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvicneId() {
        return provicneId;
    }

    public void setProvicneId(int provicneId) {
        this.provicneId = provicneId;
    }

    private String cityCode;
    private int provicneId;


}
