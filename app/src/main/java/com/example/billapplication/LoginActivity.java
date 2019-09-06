package com.example.billapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText etx_login_usename,etx_login_password;

    Button btn_login;
    // Creating Volley RequestQueue.
    RequestQueue requestQueue;
    private NotificationUtil notificationUtil;
LinearLayout rootlinearlayout;
    // Create string variable to hold the EditText Value.
    String UserNameHolder, PasswordHolder;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Storing server url into String variable.
    String HttpUrl = "http://www.arinoz.com/webservice/check_login.php";

    Boolean CheckEditText;
    @Override
    @SuppressWarnings("ConstantConditions")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        notificationUtil = new NotificationUtil(this);
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, BasicActivity.class));
        }
        etx_login_usename = (EditText) findViewById(R.id.etx_login_usename);
        etx_login_password = (EditText) findViewById(R.id.etx_login_password);
        rootlinearlayout=(LinearLayout)findViewById(R.id.rootlinearlayout);
        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(LoginActivity.this);
        // Assigning Activity this to progress dialog.
        progressDialog = new ProgressDialog(LoginActivity.this);


        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Validation();
                startActivity(new Intent(LoginActivity.this, BasicActivity.class));
//                CheckEditTextIsEmptyOrNot();
//
//                if (CheckEditText) {
////handelClick();
//                    UserLogin1();
//
//                } else {
//
//                    Toast.makeText(LoginActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();
//
//                }
//
//
//
            }
        });
    }
    private void authenticateUser(String userName, String pass) {
        //first getting the values
        final String username = etx_login_usename.getText().toString();
        final String password = etx_login_password.getText().toString();
        //validating inputs
        if (TextUtils.isEmpty(username)) {
            etx_login_usename.setError("Please enter your username");
            etx_login_usename.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etx_login_password.setError("Please enter your password");
            etx_login_password.requestFocus();
            return;
        }
        User user = new User();
        user.setUsername(userName);
        user.setPassword(pass);
        try {
            final JSONObject requestJson = new JSONObject(new Gson().toJson(user));
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    HttpUrl, requestJson,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            progressDialog.dismiss();
                            UserResponse userResponse = new Gson().fromJson(response.toString(),
                                    UserResponse.class);
                            //Log.e(TAG, userResponse.getMessage());
                            if (userResponse != null) {
                                if (userResponse.getStatus().equalsIgnoreCase(AppConstants.STATUS_SUCCESS)) {
                                   // storeValidUserData(userResponse);
                                    // If response matched then show the toast.
                                    Toast.makeText(LoginActivity.this, "Logged In Successfully", Toast.LENGTH_LONG).show();

                                    // Finish the current Login activity.
                                    finish();

                                    // Opening the user profile activity using intent.
                                    Intent intent = new Intent(LoginActivity.this, BasicActivity.class);

                                    //getApplicationVersion();
                                } else {
                                   // enableLayout(true);
                                    //Fail Response
                                    //MyApplication.getInstance().showMessageDialogWithTitle(userResponse.getMessage(), SignInActivity.this, getString(R.string.title_login_failed));
                                }
                            } else {
                               // enableLayout(true);
                               // MyApplication.getInstance().showMessageDialogWithTitle(getString(R.string.error_msg_processing_massage), SignInActivity.this, getString(R.string.error_msg_processing_title));
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                           // enableLayout(true);
                            progressDialog.dismiss();
                            //MyApplication.getInstance().showMessageDialogWithTitle(getString(R.string.error_msg_processing_massage), SignInActivity.this, getString(R.string.error_msg_processing_title));
                        }
                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("username", username);
                    params.put("password", password);
                    return params;
                }
            };
//            RetryPolicy policy = new DefaultRetryPolicy(AppConstants.REQUEST_TIMEOUT, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
//            jsonObjReq.setRetryPolicy(policy);
            VolleySingleton.getInstance(this).addToRequestQueue(jsonObjReq);
        } catch (Exception e) {
            //Log.e(TAG, "Error : " + e.toString());
            // Cancelling request
           // MyApplication.getInstance().getRequestQueue().cancelAll(TAG);

            progressDialog.dismiss();
        }
    }



    private void userLogin() {
        //first getting the values
        final String username = etx_login_usename.getText().toString();
        final String password = etx_login_password.getText().toString();
        //validating inputs
        if (TextUtils.isEmpty(username)) {
            etx_login_usename.setError("Please enter your username");
            etx_login_usename.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etx_login_password.setError("Please enter your password");
            etx_login_password.requestFocus();
            return;
        }

        //if everything is fine
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, HttpUrl,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e ( "response", "" + response );
                        progressDialog.dismiss();
                        try {
                            JSONArray jsonArray = response.getJSONArray("login");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);
                                String username = hit.getString("username");
                                String password = hit.getString("password");
                                int id = hit.getInt("id");

                                String Shop_Name = hit.getString("Shop_Name");
                                String address = hit.getString("address");
                                String Contact_No = hit.getString("Contact_No");
                                String Registration_No = hit.getString("Registration_No");
                                String License_No = hit.getString("License_No");
                                String GST_No = hit.getString("GST_No");
                                String Email = hit.getString("Email");
                                String Contact_person = hit.getString("Contact_person");

                            }
                            if((response!=null)) {

                                // If response matched then show the toast.
                                Toast.makeText(LoginActivity.this, "Logged In Successfully", Toast.LENGTH_LONG).show();

                                // Finish the current Login activity.
                                finish();

                                // Opening the user profile activity using intent.
                                Intent intent = new Intent(LoginActivity.this, BasicActivity.class);

                                // Sending User Name to another activity using intent.
                                intent.putExtra("UserNameTAG", UserNameHolder);

                                startActivity(intent);
                            }
                            else {

                                // Showing Echo Response Message Coming From Server.
                                Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_LONG).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };
requestQueue.add(request);
//        VolleySingleton.getInstance(this).addToRequestQueue(request);
    }







    public void Validation() {
        if (isEmpty(etx_login_usename)) {
            etx_login_usename.setError("Username is required!");
        }
        if (isEmpty(etx_login_password)) {
            etx_login_password.setError("Password is required!");
        }
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    private void handelClick() {
        boolean isUserOk, isPassOk;
        String[] result = validateUserInput();

        isUserOk = Boolean.parseBoolean(result[0]);
        isPassOk = Boolean.parseBoolean(result[1]);
        final Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake_animation);

        if (!isPassOk) {
          //  enableLayout(true);
            etx_login_password.clearAnimation();
            etx_login_password.startAnimation(shake);
            showMessage(("enter correct password"));
        }
        if (!isUserOk) {
            //enableLayout(true);
            etx_login_usename.clearAnimation();
            etx_login_usename.startAnimation(shake);
            showMessage("enter correct username");
        }
        if (isUserOk && isPassOk) {
            if (VolleySingleton.getInstance().isConnectedToNetwork(this)) {
              //  enableLayout(false);
                authenticateUser(etx_login_usename.getText().toString(), etx_login_password.getText().toString());
            } else {
               // enableLayout(true);
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
               // VolleySingleton.getInstance().showMessageDialog(getString(R.string.error_msg_no_internet), this);
            }
        }
    }
    private void showMessage(String message) {
        notificationUtil.showSnackBar(rootlinearlayout, message);
    }

    private String[] validateUserInput() {
        boolean isUserOk = false, isPassOk = false;
        if (etx_login_usename.getText() != null) {
            String userName = etx_login_usename.getText().toString();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                isUserOk = !userName.isEmpty() || !userName.equalsIgnoreCase("") || !"".equalsIgnoreCase(userName);
            }
        }

        if (etx_login_password.getText() != null) {
            String passName = etx_login_password.getText().toString();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                isPassOk = !passName.isEmpty() || !passName.equalsIgnoreCase("") || !"".equalsIgnoreCase(passName);
            }
        }
        return new String[]{String.valueOf(isUserOk), String.valueOf(isPassOk)};
    }

    // Creating user login function.
    public void UserLogin1() {

        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        // Creating string request with post method.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String ServerResponse) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Matching server responce message to our text.
                        if(!ServerResponse.equalsIgnoreCase("Invalid")) {

                            // If response matched then show the toast.
                            Toast.makeText(LoginActivity.this, "Logged In Successfully", Toast.LENGTH_LONG).show();

                            // Finish the current Login activity.
                            finish();

                            // Opening the user profile activity using intent.
                            Intent intent = new Intent(LoginActivity.this, BasicActivity.class);

                            // Sending User Name to another activity using intent.
                            intent.putExtra("UserNameTAG", UserNameHolder);

                            startActivity(intent);
                        }
                        else {

                            // Showing Echo Response Message Coming From Server.
                            Toast.makeText(LoginActivity.this, ServerResponse, Toast.LENGTH_LONG).show();

                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                        // Showing error message if something goes wrong.
                        Toast.makeText(LoginActivity.this, volleyError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The firs argument should be same sa your MySQL database table columns.
                params.put("username", UserNameHolder);
                params.put("password", PasswordHolder);

                return params;
            }

        };

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);

    }


    public void CheckEditTextIsEmptyOrNot() {

        // Getting values from EditText.
        UserNameHolder = etx_login_usename.getText().toString().trim();
        PasswordHolder = etx_login_password.getText().toString().trim();

        // Checking whether EditText value is empty or not.
        if (TextUtils.isEmpty(UserNameHolder) || TextUtils.isEmpty(PasswordHolder)) {

            // If any of EditText is empty then set variable value as False.
            CheckEditText = false;

        } else {

            // If any of EditText is filled then set variable value as True.
            CheckEditText = true;
        }
    }
}