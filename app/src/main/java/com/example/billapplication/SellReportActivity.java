package com.example.billapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class SellReportActivity extends AppCompatActivity  {
    Button btn_filter_search,btn_sell_report,btn_gst_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_report);
        //setting title on action bar and back button
        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            //actionBar.setSubtitle("mytest");
            assert actionBar != null;
            actionBar.setTitle("Sell Report");
        }
        init();
    }

    //on back press of action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void init() {
       // final BottomNavigationView navigation = findViewById(R.id.navigation);

        btn_filter_search = (Button) findViewById(R.id.btn_filter_search);
        btn_gst_report = (Button) findViewById(R.id.btn_gst_report);
        btn_sell_report = (Button) findViewById(R.id.btn_sell_report);
        btn_sell_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // btn_sell_report.setBackgroundColor(Color.RED);
                startActivity(new Intent(SellReportActivity.this,SellReportActivity.class));

            }
        });
        btn_gst_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // btn_gst_report.setBackgroundColor(Color.RED);
                startActivity(new Intent(SellReportActivity.this,GstActivity.class));
            }
        });
        btn_filter_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SellReportActivity.this, FilterSellReport.class));
            }
        });
//        btn_gst_report.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                btn_gst_report.setPressed(true);
//                btn_sell_report.setPressed(false);
//                return true;
//            }
//        });


    }


}
