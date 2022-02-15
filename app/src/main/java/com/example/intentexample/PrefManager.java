package com.example.intentexample;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    Context context ;
    PrefManager(Context context){
        this.context = context;
    }

    //Ghi du lieu len file
    public void saveLogin(String email , String password ){
        //Tao doi tuong sharePre
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginInfo",Context.MODE_PRIVATE);
        //Lay ra doi tuong editor de thuc hien ghi du lieu len file sharePref
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //Thuc hien day du lieu len fi;e
        editor.putString("Email",email);
        editor.putString("Password",password);
        //Goi phuong thuc commit de hoang thanh viec tao va ghi file sharepre
        editor.commit();
    }
    //Doc du lieu file sharePref
    public String getEmail(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginInfo",Context.MODE_PRIVATE);
        return sharedPreferences.getString("Email","");
    }
    public String getPassword(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginInfo",Context.MODE_PRIVATE);
        return sharedPreferences.getString("Password","");
    }
}
