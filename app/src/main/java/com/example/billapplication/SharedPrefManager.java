package com.example.billapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "volleyregisterlogin";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_ID = "keyid";

    private static final String KEY_CONTACT_NUMBER = "keycontactnumber";
    private static final String KEY_PASSWORD = "keypassword";
    private static final String KEY_SHOP_NAME = "keyshopname";
    private static final String KEY_ADDRESS = "keyaddress";
    private static final String KEY_REGISTRATION_NUMBER = "keyregistrationnumber";
    private static final String KEY_LICENCE_NUMBER = "keylicencenumber";
    private static final String KEY_GST_NUMBER = "keygstnumber";
    private static final String KEY_CONTACT_PERSON = "keycontactperson";

    private static SharedPrefManager mInstance;
    private static Context ctx;

    private SharedPrefManager(Context context) {
        ctx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //this method will store the user data in shared preferences
    public void userLogin(User user) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getId());
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_EMAIL, user.getEmail());

        editor.putString(KEY_CONTACT_NUMBER, user.getContact_No());

        editor.putString(KEY_PASSWORD, user.getPassword());
        editor.putString(KEY_SHOP_NAME, user.getShop_Name());
        editor.putString(KEY_ADDRESS, user.getAddress());
        editor.putString(KEY_REGISTRATION_NUMBER, user.getRegistration_No());
        editor.putString(KEY_LICENCE_NUMBER, user.getLicense_No());
        editor.putString(KEY_GST_NUMBER, user.getGST_No());
        editor.putString(KEY_CONTACT_PERSON, user.getContact_person());


        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null) != null;
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_CONTACT_NUMBER, null),
                sharedPreferences.getString(KEY_PASSWORD, null),
                sharedPreferences.getString(KEY_SHOP_NAME, null),
                sharedPreferences.getString(KEY_ADDRESS, null),

                sharedPreferences.getString(KEY_REGISTRATION_NUMBER, null),
                sharedPreferences.getString(KEY_LICENCE_NUMBER, null),
                sharedPreferences.getString(KEY_GST_NUMBER, null),
                sharedPreferences.getString(KEY_CONTACT_PERSON, null)






        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        ctx.startActivity(new Intent(ctx, LoginActivity.class));
    }

}
