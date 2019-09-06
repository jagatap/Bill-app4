package com.example.billapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

import org.json.JSONObject;

public class NotificationUtil {

    private Context context;

    public NotificationUtil(Context context) {
        this.context = context;
    }


    public void showSnackBar(View container, String message) {
        Snackbar snackbar = Snackbar.make(container, message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.black));
        snackbar.show();
    }

    public void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new android.app.AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", okListener)
                .create()
                .show();
    }

    /*
        This Method will only create dialog and return its object
        we need to explicitly handle show and dismiss using return object
     */
    public AlertDialog showDialog(AppCompatActivity activity, String[] internalContain, View.OnClickListener okListener) {
        int typeOfDialog = Integer.parseInt(internalContain[0]);
        String title = internalContain[1];
        String message = internalContain[2];
        String okBtn = internalContain[3];
        String canBtn = internalContain[4];

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_with_ok, null);
        builder.setView(view);


        TextView textViewTitle = (TextView) view.findViewById(R.id.title_tv);
        TextView textViewContain = (TextView) view.findViewById(R.id.contain_tv);

        textViewTitle.setText(title);
        textViewContain.setText(message);

        Button buttonPositive = (Button) view.findViewById(R.id.positive_btn_dia);
        Button buttonNegative = (Button) view.findViewById(R.id.negative_btn_dia);
        buttonPositive.setText(okBtn);
        buttonNegative.setText(canBtn);

        buttonPositive.setOnClickListener(okListener);
        buttonNegative.setOnClickListener(okListener);

        if (typeOfDialog == 2 && buttonNegative != null) {
            buttonNegative.setVisibility(View.GONE);
        } else {
            if (buttonNegative != null)
                buttonNegative.setVisibility(View.VISIBLE);
        }

        AlertDialog alertDialog = builder.create();

        return alertDialog;
    }

    public void showMessage(JSONObject response) {
        try {
            String message = (String) response.get("message");
            if (message != null) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
