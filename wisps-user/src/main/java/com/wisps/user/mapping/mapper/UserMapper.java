package com.wisps.user.mapping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wisps.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    List<UserEntity> getList(List<Long> ids);
}
