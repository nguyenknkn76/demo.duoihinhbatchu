package com.example.duoihinhbatchu.object;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    private String nameData = "appData";
    public  int money;
    public void saveInfo(Context ct){
        SharedPreferences settings = ct.getSharedPreferences(nameData,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("money",money);
        editor.commit();
    }
    public void getInfo(Context ct){
        SharedPreferences settings = ct.getSharedPreferences(nameData,0);
        money = settings.getInt("money", 100); // defause value = 100
    }
}
