package com.wisps.user.assemble;

import com.wisps.user.Utils.DateUtil;
import com.wisps.user.dto.UserDto;
import com.wisps.user.entity.UserEntity;
import com.wisps.user.vo.UserVo;

public class UserAssemble {

    public static UserDto assemble2UserDto(UserEntity entity) {
        if (entity == null) return null;
        return UserDto.builder()
                .id(entity.getId())
                .oid(entity.getOid())
                .uid(entity.getUid())
                .realName(entity.getRealName())
                .region(entity.getRegion())
                .mobile(entity.getMobile())
                .avatarUrl(entity.getAvatarUrl())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .createtime(DateUtil.formatDateTime(entity.getCreatetime(), DateUtil.DATE_TIME_PATTERN))
                .modifytime(DateUtil.formatDateTime(entity.getModifytime(), DateUtil.DATE_TIME_PATTERN))
                .build();
    }

    public static UserVo assemble2UserVo(UserDto dto) {
        if (dto == null) return null;
        return UserVo.builder()
                .id(dto.getId())
                .oid(dto.getOid())
                .uid(dto.getUid())
                .realName(dto.getRealName())
                .region(dto.getRegion())
                .mobile(dto.getMobile())
                .avatarUrl(dto.getAvatarUrl())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .createtime(dto.getCreatetime())
                .modifytime(dto.getModifytime())
                .build();
    }

}
