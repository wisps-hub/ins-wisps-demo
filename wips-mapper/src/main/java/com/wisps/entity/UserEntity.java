package com.wisps.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TableName("org_user")
public class UserEntity extends BaseEntity{
    private String oid;
    private String uid;
    private String realName;
    private String region;
    private String mobile;
    private String avatarUrl;
    private String email;
    private String password;
}
