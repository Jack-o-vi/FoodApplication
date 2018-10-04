package com.chisw.foodapplication.core;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.chisw.data.db.datasource.v5.DataSource;
import com.chisw.data.db.datasource.v5.user.UserLocalDataSource;
import com.chisw.data.db.entities.v5.DatabaseContract;
import com.chisw.data.db.entities.v5.user.UserContract;
import com.chisw.data.db.manager.v5.DBHelper;
import com.chisw.data.db.mapper.v5.Mapper;
import com.chisw.data.db.mapper.v5.user.db.UserContentValuesMapper;
import com.chisw.data.db.mapper.v5.user.db.UserCursorMapper;
import com.chisw.data.db.mapper.v5.user.model.UserDbListToUserListModelMapper;
import com.chisw.data.db.mapper.v5.user.model.UserDbToUserModelMapper;
import com.chisw.data.db.mapper.v5.user.model.UserModelToUserDbMapper;
import com.chisw.data.db.model.v5.UserEntity;
import com.chisw.data.db.repository.v5.UserRepositoryImp;
import com.chisw.domain.abstraction.repository.Repository;
import com.chisw.domain.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private static SQLiteDatabase sqLiteDatabase;


    public static DBHelper getDbHelper(Context context, List<DatabaseContract> databaseContracts) {
        return new DBHelper(context, databaseContracts);
    }

    public static SQLiteDatabase sqLiteDatabase() {
        return sqLiteDatabase;
    }

    public static List<DatabaseContract> databaseContracts() {
        List<DatabaseContract> databaseContracts = new ArrayList<>();
        databaseContracts.add(new UserContract());
        return databaseContracts;
    }

    public static Mapper<List<UserEntity>, List<User>> userDbListToUserList() {
        return new UserDbListToUserListModelMapper();
    }

    public static Mapper<User, UserEntity> userModelToUserDb() {
        return new UserModelToUserDbMapper();
    }

    public static Mapper<Cursor, UserEntity> cursorUserEntityMapper() {
        return new UserCursorMapper();
    }

    public static Mapper<UserEntity, ContentValues> contentValuesMapper() {
        return new UserContentValuesMapper();
    }

    public static DataSource<UserEntity> userLocalDataSource() {
        return new UserLocalDataSource(sqLiteDatabase(),
                databaseContract(),
                contentValuesMapper(),
                cursorUserEntityMapper());
    }

    public static DatabaseContract databaseContract() {
        return new UserContract();
    }

    public static Mapper<UserEntity, User> userEntityUserMapper() {
        return new UserDbToUserModelMapper();
    }

    public static Repository<User> userRepository() {
        return new UserRepositoryImp(userLocalDataSource(),
                userEntityUserMapper(),
                userModelToUserDb());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sqLiteDatabase = getDbHelper(this, databaseContracts()).getWritableDatabase();
    }
}
