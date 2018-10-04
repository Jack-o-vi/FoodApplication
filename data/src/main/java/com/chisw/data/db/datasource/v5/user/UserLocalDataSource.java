package com.chisw.data.db.datasource.v5.user;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.chisw.data.db.datasource.v5.AbstractLocalDataSource;
import com.chisw.data.db.entities.v5.DatabaseContract;
import com.chisw.data.db.mapper.v5.Mapper;
import com.chisw.data.db.model.v5.UserEntity;
import com.chisw.data.db.specification.DefaultSqlSpecification;
import com.chisw.data.db.specification.SqlSpecification;
import com.chisw.domain.abstraction.specification.Specification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;

public class UserLocalDataSource extends AbstractLocalDataSource<UserEntity> {

    private static final String TAG = UserLocalDataSource.class.getSimpleName();

    public UserLocalDataSource(SQLiteDatabase sqLiteDatabase,
                               DatabaseContract contract,
                               Mapper<UserEntity, ContentValues> userContentValuesMapper,
                               Mapper<Cursor, UserEntity> userCursorMapper) {
        super(sqLiteDatabase, contract, userContentValuesMapper, userCursorMapper);

    }

    @Override
    public Observable<Long> add(UserEntity data) {
        return add(Collections.singleton(data))
                .map(longs -> longs.iterator().next());
//        return Observable.create(emitter -> add(Collections.singleton(data))
//                .subscribe(new Observer<Iterable<Long>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.i(TAG, "onSubscribe: ");
//                    }
//
//                    @Override
//                    public void onNext(Iterable<Long> longs) {
//                        if (longs.iterator().hasNext()) {
//                            emitter.onNext(longs.iterator().next());
//                        }
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.i(TAG, "onComplete: add(item)");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: add(item)", e);
//                    }
//                }));
    }


    @Override
    public Observable<Iterable<Long>> add(Iterable<UserEntity> data) {
        return Observable.create(emitter -> {
            List<Long> list = new ArrayList<>();
            if (sqLiteDatabase != null) {
                sqLiteDatabase.beginTransaction();
                try {
                    for (UserEntity item : data) {
                        final long insert = sqLiteDatabase.insert(contract.getTableName(), null, userContentValuesMapper.map(item));
                        list.add(insert);
                        Log.i(TAG, "add: " + insert);
                    }
                    sqLiteDatabase.setTransactionSuccessful();
                } finally {
                    sqLiteDatabase.endTransaction();
                }

                if (!emitter.isDisposed()) {
                    emitter.onNext(list);
                }
            } else {
                if (!emitter.isDisposed()) {
                    emitter.onError(new Exception("add(Iterable) SqlDatabase is null"));
                }
            }
        });

    }

    @Override
    public Observable<Integer> remove() {
        return remove(new DefaultSqlSpecification());
    }

    @Override
    public Observable<Integer> remove(Specification specification) {
        return Observable.create(emitter -> {
            if (sqLiteDatabase != null) {
                sqLiteDatabase.beginTransaction();
                try {
                    SqlSpecification sqlSpecification = (SqlSpecification) specification;
                    Integer res = sqLiteDatabase.delete(contract.getTableName(),
                            sqlSpecification.selection(),
                            ((SqlSpecification) specification).selectionArgs());

                    if (!emitter.isDisposed()) {
                        emitter.onNext(res);
                        emitter.onComplete();
                    }
                    sqLiteDatabase.setTransactionSuccessful();
                } finally {
                    sqLiteDatabase.endTransaction();
                }
            } else {
                emitter.onError(new Exception("SqlDatabase in remove(specification) == null"));
            }
        });
    }

    @Override
    public Observable<Integer> update(UserEntity data, Specification specification) {
        return update(Collections.singleton(data), specification)
                .map((ids) -> ids.iterator().next());
    }

    @Override
    public Observable<Iterable<Integer>> update(Iterable<UserEntity> data, Specification specification) {
        return Observable.create(emitter -> {
            if (sqLiteDatabase != null) {
                sqLiteDatabase.beginTransaction();
                try {
                    List<Integer> list = new ArrayList<>();
                    SqlSpecification sqlSpecification = (SqlSpecification) specification;
                    for (UserEntity item : data) {
                        final int update = sqLiteDatabase.update(contract.getTableName(),
                                userContentValuesMapper.map(item),
                                sqlSpecification.selection(),
                                sqlSpecification.selectionArgs());
                        list.add(update);
                    }
                    if (!emitter.isDisposed()) {
                        emitter.onNext(list);
                        emitter.onComplete();
                    }
                    sqLiteDatabase.setTransactionSuccessful();
                } finally {
                    sqLiteDatabase.endTransaction();
                }
            } else {
                emitter.onError(new Exception("SqlDatabase in update(specification) == null"));
            }
        });
    }

    @Override
    public Observable<UserEntity> query() {
        return query(new DefaultSqlSpecification());
    }

    @Override
    public Observable<UserEntity> query(Specification specification) {
        return Observable.create(emitter ->
                {
                    if (sqLiteDatabase != null) {
                        sqLiteDatabase.beginTransaction();
                        try {
                            SqlSpecification sqlSpecification = (SqlSpecification) specification;

                            try (Cursor cursor = sqLiteDatabase.query(contract.getTableName(),
                                    sqlSpecification.projection(),
                                    sqlSpecification.selection(),
                                    sqlSpecification.selectionArgs(),
                                    null,
                                    null,
                                    sqlSpecification.sortOrder())) {
                                final boolean isCursorOpened = !cursor.isClosed();
                                final boolean moveToFirst = cursor.moveToFirst();
//                                final boolean moveToNext = cursor.moveToNext();
                                Log.i(TAG, "query: isCursorOpened" + isCursorOpened + " moveToFirst " + moveToFirst + " emitter.isDisposed() " + emitter.isDisposed());
                                if (isCursorOpened && moveToFirst) {
                                    do {
                                        if (!emitter.isDisposed()) {
                                            emitter.onNext(userCursorMapper.map(cursor));
                                        }
                                    } while (cursor.moveToNext());
                                } else {
                                    if (!emitter.isDisposed()) {
                                        emitter.onError(new Exception("Cursor is closed"));
                                    }
                                }
                            }


                            sqLiteDatabase.setTransactionSuccessful();
                        } finally {
                            sqLiteDatabase.endTransaction();
                        }
                    } else {
                        emitter.onError(new Exception("SqlDatabase in remove(specification) == null"));
                    }
                }
        );
    }
}
