package com.chisw.data.db.datasource.v5;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.chisw.data.db.entities.v5.DatabaseContract;
import com.chisw.data.db.mapper.v5.Mapper;

public abstract class AbstractLocalDataSource<T> implements DataSource<T> {

    protected SQLiteDatabase sqLiteDatabase;
    protected DatabaseContract contract;
    protected Mapper<T, ContentValues> userContentValuesMapper;
    protected Mapper<Cursor, T> userCursorMapper;

    public AbstractLocalDataSource(SQLiteDatabase sqLiteDatabase,
                                   DatabaseContract contract,
                                   Mapper<T, ContentValues> userContentValuesMapper,
                                   Mapper<Cursor, T> userCursorMapper) {
        this.sqLiteDatabase = sqLiteDatabase;
        this.contract = contract;
        this.userContentValuesMapper = userContentValuesMapper;
        this.userCursorMapper = userCursorMapper;
    }
}
