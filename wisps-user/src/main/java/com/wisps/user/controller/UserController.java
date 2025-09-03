package com.wisps.user.controller;

import com.wisps.user.assemble.UserAssemble;
import com.wisps.user.biz.UserBiz;
import com.wisps.user.dto.UserDto;
import com.wisps.user.vo.UserVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

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

    @GetMapping("/list")
    public List<UserVo> getById(@RequestParam("ids") List<Long> ids){
        List<UserDto> list = userBiz.getList(ids);
        return CollectionUtils.isEmpty(list) ? Collections.emptyList() : UserAssemble.assemble2UserVos(list);
    }



}
