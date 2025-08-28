package com.wisps.user.biz.impl;

import com.wisps.user.assemble.UserAssemble;
import com.wisps.user.biz.UserBiz;
import com.wisps.user.dto.UserDto;
import com.wisps.user.entity.UserEntity;
import com.wisps.user.mapping.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto getById(Long id) {
        UserEntity userEntity = userDao.selectById(id);
        return userEntity == null? null : UserAssemble.assemble2UserDto(userEntity);
    }

}
