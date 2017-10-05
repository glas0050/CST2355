package com.example.glas0050.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.view.View;

import android.util.Log;

public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "LoginActivityxxx";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*get email from share preferences*/
        /*SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(getActivity());*/
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        String user = sharedPreferences.getString("Default Email", "bob@someaddress.com");
        EditText userBox = (EditText) findViewById(R.id.etUser);
        userBox.setText(user);
    }

    private void callback() {
        Log.i(ACTIVITY_NAME, "In callback()");
        SharedPreferences sp = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Default Email", ((EditText) findViewById(R.id.etUser)).getText().toString());
        editor.commit();
    }


    protected void onResume() {
        Log.i(ACTIVITY_NAME, "In onResume()");
        super.onResume();

    }

    protected void onStart() {
        Log.i(ACTIVITY_NAME, "In onStart()");
        super.onStart();

    }

    protected void onPause() {
        Log.i(ACTIVITY_NAME, "In onPause()");
        super.onPause();
    }

    protected void onStop() {
        Log.i(ACTIVITY_NAME, "In onStop()");
        super.onStop();
    }

    protected void onDestroy() {
        Log.i(ACTIVITY_NAME, "In onDestroy()");
        super.onDestroy();
    }

    public void login(View view) {
        Log.i(ACTIVITY_NAME, "In login()");
        callback();

        Intent intent = new Intent(LoginActivity.this, StartActivity.class);
        startActivity(intent);


/*      playing....
        EditText username = (EditText) findViewById(R.id.etUser);
        EditText password = (EditText) findViewById(R.id.etPassword);*/



/*        if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            callback();
            //correcct password
        } else {
            //wrong password
        }*/
    }
}
