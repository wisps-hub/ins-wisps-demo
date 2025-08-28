package com.wisps.user.vo;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserVo {
    private Long id;
    private String oid;
    private String uid;
    private String realName;
    private String region;
    private String mobile;
    private String avatarUrl;
    private String email;
    private String password;
    private String createtime;
    private String modifytime;
}
