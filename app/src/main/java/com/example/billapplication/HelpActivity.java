package com.example.billapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {
Button btn_add_item,btn_see_user_setting;
TextView txt_how_add_item,txt_how_check_user_setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        //setting title on action bar and back button
        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            //actionBar.setSubtitle("mytest");
            assert actionBar != null;
            actionBar.setTitle("Help");
            init();
        }
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
    public void init(){
        btn_add_item=(Button)findViewById(R.id.btn_add_item);
        txt_how_add_item=(TextView) findViewById(R.id.txt_how_add_item);
        txt_how_check_user_setting=(TextView) findViewById(R.id.txt_how_check_user_setting);
        btn_see_user_setting=(Button) findViewById(R.id.btn_see_user_setting);
        btn_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_how_add_item.getVisibility() == View.GONE) {
                    txt_how_add_item.setVisibility(View.VISIBLE);
                    txt_how_add_item.setFocusable(true);
                    txt_how_add_item.setFocusableInTouchMode(true);
                    txt_how_add_item.requestFocus();

                } else if (txt_how_add_item.getVisibility() == View.VISIBLE) {
                    txt_how_add_item.setVisibility(View.GONE);
                    txt_how_add_item.clearFocus();
                }
            }
        });
        btn_see_user_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_how_check_user_setting.getVisibility() == View.GONE) {
                    txt_how_check_user_setting.setVisibility(View.VISIBLE);
                    txt_how_check_user_setting.setFocusable(true);
                    txt_how_check_user_setting.setFocusableInTouchMode(true);
                    txt_how_check_user_setting.requestFocus();

                } else if (txt_how_check_user_setting.getVisibility() == View.VISIBLE) {
                    txt_how_check_user_setting.setVisibility(View.GONE);
                    txt_how_check_user_setting.clearFocus();
                }
            }
        });
    }
}
