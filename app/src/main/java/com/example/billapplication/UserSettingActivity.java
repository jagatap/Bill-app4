package com.example.billapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserSettingActivity extends AppCompatActivity {
Button btn_edit_market_name;
EditText etx_market_name;
TextView txt_help,txt_feedback,txt_userName_user_setting;
    public static PrefConfig prefConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);
        prefConfig=new PrefConfig(this);
        //setting title on action bar and back button
        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            //actionBar.setSubtitle("mytest");
            assert actionBar != null;
            actionBar.setTitle("User Setting");
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user_setting_menu, menu);
        return true;
    }
    public  void init(){
        btn_edit_market_name=(Button)findViewById(R.id.btn_edit_market_name);
        etx_market_name=(EditText) findViewById(R.id.etx_market_name);
        txt_feedback=(TextView) findViewById(R.id.txt_feedback);
        txt_userName_user_setting=(TextView) findViewById(R.id.txt_userName_user_setting);
        txt_help=(TextView) findViewById(R.id.txt_help);
        txt_userName_user_setting.setText(UserSettingActivity.prefConfig.readUserName());

        txt_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserSettingActivity.this,HelpActivity.class));
            }
        });
        txt_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserSettingActivity.this,FeedBackActivity.class));
            }
        });
        btn_edit_market_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etx_market_name.setEnabled(true);
            }
        });
    }
}
