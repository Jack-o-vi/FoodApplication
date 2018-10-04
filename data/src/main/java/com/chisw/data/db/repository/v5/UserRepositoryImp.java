package com.chisw.data.db.repository.v5;

import com.chisw.data.db.datasource.v5.DataSource;
import com.chisw.data.db.mapper.v5.Mapper;
import com.chisw.data.db.model.v5.UserEntity;
import com.chisw.domain.abstraction.repository.Repository;
import com.chisw.domain.abstraction.specification.Specification;
import com.chisw.domain.model.user.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class UserRepositoryImp implements Repository<User> {

    private DataSource<UserEntity> localDataSource;
    private Mapper<UserEntity, User> userEntityUserMapper;
    private Mapper<User, UserEntity> userModelToUserDb;

    public UserRepositoryImp(DataSource<UserEntity> localDataSource,
                             Mapper<UserEntity, User> userEntityUserMapper,
                             Mapper<User, UserEntity> userModelToUserDb) {
        this.localDataSource = localDataSource;
        this.userEntityUserMapper = userEntityUserMapper;
        this.userModelToUserDb = userModelToUserDb;
    }

    @Override
    public Observable<User> getItems(Specification specification) {
        return localDataSource.query(specification)
                .map(userEntity -> userEntityUserMapper.map(userEntity));
    }

    @Override
    public Observable<User> getItem(Specification specification) {
        return localDataSource.query(specification).map(userEntities -> userEntityUserMapper.map(userEntities));
    }

    @Override
    public Observable<User> getAllItems() {
        return localDataSource.query().flatMap((Function<UserEntity, ObservableSource<User>>) userEntities -> list -> userEntityUserMapper.map(userEntities));
    }

    @Override
    public Observable<Integer> updateItems(User user, Specification specification) {
        return localDataSource.update(userModelToUserDb.map(user), specification);
    }

    @Override
    public Observable<Integer> deleteItem(Specification specification) {
        return localDataSource.remove(specification);
    }

    @Override
    public Observable<Long> addItem(User item) {
        return localDataSource.add(userModelToUserDb.map(item));
    }
}
