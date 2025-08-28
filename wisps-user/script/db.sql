create table org_user
(
    id varchar(64) not null comment '主键Id' primary key,
    oid        varchar(64)   default ''                not null comment '组织id',
    uid        varchar(64)   default ''                not null comment '用户id',
    real_name  varchar(100)  default ''                not null comment '名字',
    region     varchar(5)    default ''                not null comment '国家码',
    mobile     varchar(128)  default ''                not null comment '手机号',
    avatar_url varchar(1024) default ''                not null comment '用户头像',
    email      varchar(320)  default ''                not null comment '邮箱',
    password   varchar(255)  default ''                not null comment '密码',
    createtime timestamp     default CURRENT_TIMESTAMP not null comment '创建时间',
    modifytime timestamp     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
);