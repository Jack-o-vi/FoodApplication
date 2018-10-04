package com.chisw.data.db.entities.v5.user;

import android.net.Uri;

import com.chisw.data.db.entities.v5.DatabaseContract;

public class UserContract implements DatabaseContract {

    public static String NAME = "name";

    public static String SURNAME = "surname";

    public static String EMAIL = "email";

    public static String ID = "_id";

    public static String TABLE_NAME = "users";

    private static Uri CONTENT_URI = Uri.parse("content://${BuildConfig.CONTENT_URI_AUTHORITY}/$tableName");

    private static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
            "(" + ID + " INTEGER primary key AUTOINCREMENT, "
            + EMAIL + TEXT + COMMA
            + NAME + TEXT + COMMA
            + SURNAME + " text);";

    @Override
    public String getCreateTableSql() {
        return CREATE_TABLE;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public Uri getContentUri() {
        return CONTENT_URI;
    }
}
