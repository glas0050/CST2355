package com.example.glas0050.androidlabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends Activity {
    protected static final String ACTIVITY_NAME = "ListItemsActivityxxx";
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
    }

    protected void setOnCheckedChanged(View view) {
        Switch sw = (Switch) findViewById(R.id.switch1);
        Boolean swState = sw.isChecked();
        CharSequence text;
        int duration;

        if (swState) {
            text =  getString(R.string.swOnText);
            duration = Toast.LENGTH_SHORT;
        } else {
            text = getString(R.string.swOffText);
            duration = Toast.LENGTH_LONG;
        }

        Toast toast = Toast.makeText(this, text, duration); //this is the ListActivity
        toast.show(); //display your message box
    }

    public void onCheckedChanged(View view) {
        //CheckBox cb = (CheckBox) findViewById(R.id.checkBox);
        //Boolean cbState = cb.isChecked();

/*        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Exit Page");
        builder.setMessage("Are you finished");

        AlertDialog dialog = builder.create();*/


        AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
// 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                .setTitle(R.string.dialog_title)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent resultIntent = new Intent(  );
                        resultIntent.putExtra("Response", getString(R.string.listExitResponse));
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })
                .show();


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

    protected void phonePhotoApp(View view) {
        Log.i(ACTIVITY_NAME, "Photo app starting");
        PackageManager pm = this.getPackageManager();

        if (pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Log.i(ACTIVITY_NAME, "camera detected");
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

            }
        } else {
            Log.i(ACTIVITY_NAME, "no camera detected");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ImageView userBox = (ImageView) findViewById(R.id.imageButton);
            userBox.setImageBitmap((imageBitmap));


        }
    }
}
