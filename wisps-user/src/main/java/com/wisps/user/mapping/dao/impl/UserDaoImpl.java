package com.wisps.user.mapping.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wisps.user.entity.UserEntity;
import com.wisps.user.mapping.dao.UserDao;
import com.wisps.user.mapping.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl extends ServiceImpl<UserMapper, UserEntity> implements UserDao {

    @Override
    public UserEntity selectById(Long id) {
        return getById(id);
    }

}
