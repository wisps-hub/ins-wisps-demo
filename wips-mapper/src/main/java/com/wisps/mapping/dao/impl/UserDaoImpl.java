package com.wisps.mapping.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wisps.entity.UserEntity;
import com.wisps.mapping.dao.UserDao;
import com.wisps.mapping.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl extends ServiceImpl<UserMapper, UserEntity> implements UserDao {

    @Override
    public UserEntity selectById(Long id) {
        return getById(id);
    }

}
