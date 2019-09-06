package com.example.billapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class AddProductActivity extends AppCompatActivity {
AutoCompleteTextView txt_product_name;
EditText etx_quantity,etx_price,etx_gst;
   Button btn_add_item,btn_clear_item;
    private String[] products = {"Sugar","Rice","Panir","Masale"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        //setting title on action bar and back button
        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            //actionBar.setSubtitle("mytest");
            assert actionBar != null;
            actionBar.setTitle("Add Item");
        }
        init();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, products);
        txt_product_name.setThreshold(1); //will start working from first character
        txt_product_name.setAdapter(adapter);
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
    public  void init(){
        txt_product_name=(AutoCompleteTextView)findViewById(R.id.txt_product_name);
        etx_quantity=(EditText)findViewById(R.id.etx_quantity);
        etx_price=(EditText)findViewById(R.id.etx_price);
        etx_gst=(EditText)findViewById(R.id.etx_gst);
        btn_add_item=(Button)findViewById(R.id.btn_add_item);
        btn_clear_item=(Button)findViewById(R.id.btn_clear_item);
        btn_clear_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_product_name.setText("");
                etx_quantity.setText("");
                etx_price.setText("");
                etx_gst.setText("");
            }
        });
        btn_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddProductActivity.this,ProductListActivity.class));
            }
        });

    }
}
