package com.chisw.data.db.mapper.v5.user.model;

import com.chisw.data.db.mapper.v5.Mapper;
import com.chisw.data.db.model.v5.UserEntity;
import com.chisw.domain.model.user.User;

public class UserDbToUserModelMapper implements Mapper<UserEntity, User> {
    @Override
    public User map(UserEntity from) {
        User user = new User();
        user.setId(from.getId());
        user.setName(from.getName());
        user.setSurname(from.getSurname());
        user.setEmail(from.getEmail());
        return user;
    }
}
