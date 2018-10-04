package com.chisw.data.db.manager.v5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;


import com.chisw.data.db.entities.v5.DatabaseContract;

import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = DBHelper.class.getSimpleName();
    private static String DB_NAME = "foodapp_db_name";
    private static int DB_VERSION = 1;
    private List<DatabaseContract> databaseContracts;

    public DBHelper(@Nullable Context context, List<DatabaseContract> databaseContracts) {
        super(context, DB_NAME, null, DB_VERSION);
        this.databaseContracts = databaseContracts;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: DB_NAME: " + DB_NAME + " DB_VERSION: " + DB_VERSION);
        if (databaseContracts != null) {
            for (DatabaseContract item : databaseContracts) {
                if (db != null) {
                    db.execSQL(item.getCreateTableSql());
                }
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
