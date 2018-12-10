package becker.andy.drivesafe;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public PrefConfig(Context context) {
        this.context = context;
        sharedPreferences=this.context.getSharedPreferences("pref_file",Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("login_status", status);
        editor.commit();
    }
    public void writeUser(String user){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("user",user);
        editor.commit();
    }
    public String readUser(){
        return sharedPreferences.getString("user","none");
    }
    public boolean readLoginStatus(){
        return sharedPreferences.getBoolean("login_status",false);
    }
    public void writeShopName(String name){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("shop_name",name);
        editor.commit();
    }
    public String readShopName(){
        return sharedPreferences.getString("shop_name","user");
    }
}
