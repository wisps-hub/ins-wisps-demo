package com.wisps.user.controller;

import com.wisps.user.assemble.UserAssemble;
import com.wisps.user.biz.UserBiz;
import com.wisps.user.dto.UserDto;
import com.wisps.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @GetMapping("/{id}")
    public UserVo getById(@PathVariable("id") Long id){
        UserDto userDto = userBiz.getById(id);
        return userDto == null? null : UserAssemble.assemble2UserVo(userDto);
    }

}
