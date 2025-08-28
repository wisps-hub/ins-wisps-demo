package com.wisps.user.biz;

import com.wisps.user.dto.UserDto;

public interface UserBiz {
    UserDto getById(Long id);
}
