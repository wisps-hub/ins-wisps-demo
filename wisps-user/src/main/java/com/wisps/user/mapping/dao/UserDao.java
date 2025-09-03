package com.wisps.user.mapping.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wisps.user.entity.UserEntity;

import java.util.List;

public interface UserDao extends IService<UserEntity> {

    UserEntity selectById(Long id);

    List<UserEntity> getList(List<Long> ids);

}
