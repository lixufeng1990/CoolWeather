package com.coolweather.app.util;

import android.text.TextUtils;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

/**
 * Created by xufeng on 2016/2/29.
 */
public class Utility {
    /*
    parse and deal province data from server
     */
    public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response){
        if (!TextUtils.isEmpty(response)){
            String[]  allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0){
                for(String p : allProvinces){
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    //save new ins
                    coolWeatherDB.saveProvince(province);
                }
                return  true;
            }
        }
        return  false;
    }

    /*
    parse and deal city data from server
     */
    public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            String[]  allCities = response.split(",");
            if (allCities != null && allCities.length > 0){
                for(String c : allCities){
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvicneId(provinceId);
                    //save new ins
                    coolWeatherDB.saveCity(city);
                }
                return  true;
            }
        }
        return  false;
    }

    /*
    parse and deal county data from server
     */
    public static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB,String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            String[]  allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0){
                for(String c : allCounties){
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    //save new ins
                    coolWeatherDB.saveCounty(county);
                }
                return  true;
            }
        }
        return  false;
    }
}
