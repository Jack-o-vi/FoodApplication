package com.chisw.data.db.entities.v5;

import android.net.Uri;

public interface DatabaseContract {
    String getCreateTableSql();

    String getTableName();

    String getId();

    Uri getContentUri();

    String COMMA = ",";
    String TEXT = " TEXT";
    String INTEGER = " INTEGER";

}
