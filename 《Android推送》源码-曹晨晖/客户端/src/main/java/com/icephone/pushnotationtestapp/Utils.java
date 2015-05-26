package com.icephone.pushnotationtestapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.UUID;

/**
 * Created by 晨晖 on 2015-04-19.
 */
public class Utils {
    /**
     * 获取本机存储的UUID，若没有则会随机生成一个并存储到本机
     *
     * @param context
     * @return
     */
    public static String getUuid(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SP", Activity.MODE_PRIVATE);
        String result = sharedPreferences.getString("uuid", null);
        if (result == null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            result = UUID.randomUUID().toString();
            editor.putString("uuid", result);
            editor.commit();
        }
        Log.e("SP", result);
        return result;
    }

    public static String changeUuid(Context context) {
        String result = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences("SP", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        result = UUID.randomUUID().toString();
        editor.putString("uuid", result);
        editor.commit();
        return result;
    }
}
