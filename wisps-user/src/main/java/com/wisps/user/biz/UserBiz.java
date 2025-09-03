package com.wisps.user.biz;

import com.wisps.user.dto.UserDto;

import java.util.List;

public interface UserBiz {
    UserDto getById(Long id);
    List<UserDto> getList(List<Long> ids);
}
