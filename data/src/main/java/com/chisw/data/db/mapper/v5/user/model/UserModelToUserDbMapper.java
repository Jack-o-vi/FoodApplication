package com.chisw.data.db.mapper.v5.user.model;

import com.chisw.data.db.mapper.v5.Mapper;
import com.chisw.data.db.model.v5.UserEntity;
import com.chisw.domain.model.user.User;

public class UserModelToUserDbMapper implements Mapper<User, UserEntity> {
    @Override
    public UserEntity map(User from) {
        UserEntity userEntity = new UserEntity();
        if(from.getId() != null){
            userEntity.setId(from.getId());
        }
        userEntity.setName(from.getName());
        userEntity.setSurname(from.getSurname());
        userEntity.setEmail(from.getEmail());
        return userEntity;
    }
}
