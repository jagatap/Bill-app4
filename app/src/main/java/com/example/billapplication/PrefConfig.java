package com.example.billapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;

public class PrefConfig {
    private SharedPreferences sharedPreferences;
    private Context context;
    public static final String APP_URL="";


    public ProgressDialog prgDialog;

    public PrefConfig(){

    }

    public PrefConfig(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(context.getString(R.string.pref_file),Context.MODE_PRIVATE);

    }
    public String readUserName(){

        return sharedPreferences.getString(context.getString(R.string.pref_user_name),"User");
    }

}
