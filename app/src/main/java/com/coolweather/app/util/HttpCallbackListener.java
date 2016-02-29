package com.coolweather.app.util;

/**
 * Created by xufeng on 2016/2/29.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
