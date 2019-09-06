package com.example.billapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class BasicActivity extends AppCompatActivity {
    LinearLayout additemlinearlayout, usersettinglinearlayout, sellreportlinearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        init();
    }

    public void init() {
        additemlinearlayout = (LinearLayout) findViewById(R.id.additemlinearlayout);
        usersettinglinearlayout = (LinearLayout) findViewById(R.id.usersettinglinearlayout);
        sellreportlinearlayout = (LinearLayout) findViewById(R.id.sellreportlinearlayout);
        sellreportlinearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BasicActivity.this,SellReportActivity.class));
            }
        });
        usersettinglinearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BasicActivity.this, UserSettingActivity.class));
            }
        });
        additemlinearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BasicActivity.this, ProductListActivity.class));
            }
        });
    }
}
