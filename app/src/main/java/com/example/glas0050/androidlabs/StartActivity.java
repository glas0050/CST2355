package com.example.glas0050.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends Activity {
    protected static final String ACTIVITY_NAME = "StartActivityxxx";
    Button b1;
    Button b2Chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(handle);

        b2Chat = (Button) findViewById(R.id.btnChat);
        b2Chat.setOnClickListener(handleChat);

    }

    View.OnClickListener handleChat = new View.OnClickListener() {
        public void onClick(View v) {
            Log.i(ACTIVITY_NAME, "User clicked Start Chat");

            Intent intent = new Intent(StartActivity.this, ChatWindow.class);
            startActivity(intent);
        }
    };


    View.OnClickListener handle = new View.OnClickListener() {
        public void onClick(View v) {
            Log.i(ACTIVITY_NAME, "button clicked()");

            Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
            startActivityForResult(intent, 10);

        }
    };

    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        CharSequence text;
        int duration;

        String messagePassed = data.getStringExtra("Response");
        if ((requestCode == 10)) {
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
            if (responseCode == Activity.RESULT_OK) {
                text = messagePassed;
                duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(this, text, duration); //this is the ListActivity
                toast.show(); //display your message box
            }


          //  edfghjkl
        }
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
}
