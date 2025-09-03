package com.wisps.user.assemble;

import com.wisps.user.Utils.DateUtil;
import com.wisps.user.dto.UserDto;
import com.wisps.user.entity.UserEntity;
import com.wisps.user.vo.UserVo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<UserDto> assemble2UserDtos(List<UserEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) return Collections.emptyList();
        return entityList.stream().map(entity -> UserDto.builder()
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
                .build()).collect(Collectors.toList());
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

    public static List<UserVo> assemble2UserVos(List<UserDto> dtos) {
        if (CollectionUtils.isEmpty(dtos)) return Collections.emptyList();
        return dtos.stream().map(dto -> UserVo.builder()
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
                .build()).collect(Collectors.toList());
    }

}
