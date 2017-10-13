package com.example.glas0050.androidlabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by glas0050 on 10/10/2017.
 */

public class ChatDatabaseHelper extends SQLiteOpenHelper {
    protected static final String ACTIVITY_NAME = "ChatDatabaseHelperxxx";
    private static String DATABASE_NAME = "Messages.db";
    private static int VERSION_NUM = 3;
    private static String KEY_ID = "ID";
    private static String KEY_MESSAGE = "Message";
    private static String TABLE_NAME = "History";
    private ArrayList<String> tempArray;

    private static final String SQL_CREATE =
                    "CREATE TABLE " + TABLE_NAME + " (" +
                   KEY_ID + "INTEGER PRIMARAY KEY," +
                    KEY_MESSAGE + " TEXT)";

    private static final String SQL_UPGRADE =
                    "DROP TABLE IF EXISTS " + TABLE_NAME;

    private String selectQuery = "SELECT * FROM " + TABLE_NAME;

    public ChatDatabaseHelper(Context ctx){
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    public void dbDelete (){
     /*this.deleteDatabase(DATABASE_NAME);*/
        SQLiteDatabase.deleteDatabase(new File("/data/user/0/com.example.glas0050.androidlabs/databases/Messages.db"));
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i(ACTIVITY_NAME, "Calling onCreate");;
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(ACTIVITY_NAME, "Calling onUpgrade, oldVersion = " + oldVersion + " newVersion = " + newVersion);
        db.execSQL(SQL_UPGRADE);
        onCreate(db);
    }
    /*https://www.androidhive.info/2011/11/android-sqlite-database-tutorial/*/
    public ArrayList<String> getEntireTable() {
        tempArray = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        Log.i(ACTIVITY_NAME, "Cursor’s  column count =" + cursor.getColumnCount() );

        for (int i =0 ; i < cursor.getColumnCount(); i++){
            Log.i(ACTIVITY_NAME, "Attribute " + i + ":" + cursor.getColumnName(i) );
        }
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Log.i(ACTIVITY_NAME, "SQL MESSAGE:" + cursor.getString(
                    cursor.getColumnIndex(ChatDatabaseHelper.KEY_MESSAGE)));
                tempArray.add(cursor.getString(
                        cursor.getColumnIndex(ChatDatabaseHelper.KEY_MESSAGE)));
                Log.i(ACTIVITY_NAME, "getting: " + cursor.getString(1));
                cursor.moveToNext();
            }
        }

        return tempArray;
    }
    public void dbAddChat(String s){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MESSAGE,s);

        db.insert(TABLE_NAME, null, values);
        Log.i(ACTIVITY_NAME, "enterd in db: " + values);
        db.close();

    }

}
