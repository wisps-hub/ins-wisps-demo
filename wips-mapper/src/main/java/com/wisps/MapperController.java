package com.wisps;

import com.wisps.mapping.dao.UserDao;
import com.wisps.entity.UserEntity;
import com.wisps.mapping.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mapper")
public class MapperController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable("id") Long id){
        return userDao.selectById(id);
    }

    @GetMapping("/list")
    public List<UserEntity> getById(){
        return userMapper.getList(List.of(1L,2L,3L));
    }


}
