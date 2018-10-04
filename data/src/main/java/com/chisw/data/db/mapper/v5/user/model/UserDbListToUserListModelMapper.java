package com.chisw.data.db.mapper.v5.user.model;

import com.chisw.data.db.mapper.v5.Mapper;
import com.chisw.data.db.model.v5.UserEntity;
import com.chisw.domain.model.user.User;

import java.util.LinkedList;
import java.util.List;

public class UserDbListToUserListModelMapper implements Mapper<List<UserEntity>, List<User>> {
    @Override
    public List<User> map(List<UserEntity> from) {
        List<User> users = new LinkedList<>();

        for (UserEntity userEntity : from) {
            users.add(new User(userEntity.getId(), userEntity.getName(), userEntity.getSurname(), userEntity.getEmail()));
        }

        return users;
    }
}
