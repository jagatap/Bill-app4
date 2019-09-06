package com.example.billapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import static android.content.ContentValues.TAG;

public class VolleySingleton {
    private static VolleySingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private VolleySingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleySingleton(context);
        }
        return mInstance;
    }
    public static synchronized VolleySingleton getInstance() {
        return mInstance;
    }
    public boolean isConnectedToNetwork(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        // boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
    }
//    public MaterialDialog getProgressDialog(String msg, Context context) {
//        return new MaterialDialog.Builder(context)
//                .content(msg).progress(true, 0)
//                .contentColor(ContextCompat.getColor(context, R.color.colorPrimary))
//                .positiveColorRes(R.color.colorPrimary)
//                .build();
//    }
//    public void showMessageDialog(String msg, final Context context) {
//        try {
//            if (context != null && !AppConstants.isInternetUnAvailableDialogVisible) {
//                new MaterialDialog.Builder(context).content(msg)
//                        .contentColor(ContextCompat.getColor(context, R.color.colorPrimary))
//                        .positiveText("Ok")
//                        .positiveColorRes(R.color.colorPrimary).show()
//                        .setOnDismissListener(new DialogInterface.OnDismissListener() {
//                            @Override
//                            public void onDismiss(DialogInterface dialogInterface) {
//                                AppConstants.isInternetUnAvailableDialogVisible = false;
//                            }
//                        });
//                AppConstants.isInternetUnAvailableDialogVisible = true;
//            }
//        } catch (Exception e) {
//            Log.e(TAG, "Error : " + e.toString());
//        }
//    }
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
