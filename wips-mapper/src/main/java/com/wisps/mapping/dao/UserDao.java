package com.wisps.mapping.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wisps.entity.UserEntity;

public interface UserDao extends IService<UserEntity> {

    UserEntity selectById(Long id);

}
