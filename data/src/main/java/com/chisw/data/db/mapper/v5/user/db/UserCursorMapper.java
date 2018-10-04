package com.chisw.data.db.mapper.v5.user.db;

import android.database.Cursor;

import com.chisw.data.db.entities.v5.user.UserContract;
import com.chisw.data.db.mapper.v5.Mapper;
import com.chisw.data.db.model.v5.UserEntity;

public class UserCursorMapper implements Mapper<Cursor, UserEntity> {
    @Override
    public UserEntity map(Cursor from) {
        UserEntity user = new UserEntity();
        user.setId(from.getLong(from.getColumnIndex(UserContract.ID)));
        user.setName(from.getString(from.getColumnIndex(UserContract.NAME)));
        user.setSurname(from.getString(from.getColumnIndex(UserContract.SURNAME)));
        user.setEmail(from.getString(from.getColumnIndex(UserContract.EMAIL)));
        return user;
    }
}
