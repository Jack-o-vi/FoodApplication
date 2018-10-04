package com.chisw.data.db.mapper.v5.user.db;

import android.content.ContentValues;

import com.chisw.data.db.entities.v5.user.UserContract;
import com.chisw.data.db.mapper.v5.Mapper;
import com.chisw.data.db.model.v5.UserEntity;

public class UserContentValuesMapper implements Mapper<UserEntity, ContentValues> {

    @Override
    public ContentValues map(UserEntity from) {
        ContentValues cv = new ContentValues();
        cv.put(UserContract.ID, from.getId());
        cv.put(UserContract.EMAIL, from.getEmail());
        cv.put(UserContract.NAME, from.getName());
        cv.put(UserContract.SURNAME, from.getSurname());
        return cv;
    }
}
