package com.wisps.user.mapping.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wisps.user.entity.UserEntity;

public interface UserDao extends IService<UserEntity> {

    UserEntity selectById(Long id);

}
