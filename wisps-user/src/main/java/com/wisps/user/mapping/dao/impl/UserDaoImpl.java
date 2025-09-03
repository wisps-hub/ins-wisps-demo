package com.wisps.user.mapping.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wisps.user.entity.UserEntity;
import com.wisps.user.mapping.dao.UserDao;
import com.wisps.user.mapping.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl extends ServiceImpl<UserMapper, UserEntity> implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity selectById(Long id) {
        return getById(id);
    }

    @Override
    public List<UserEntity> getList(List<Long> ids) {
        return userMapper.getList(ids);
    }

}
