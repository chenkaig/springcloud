package com.jk.mapper;

import com.jk.model.SysPermission;

import java.util.List;

public interface SysPermissionMapper {

    List<SysPermission> findMenuByUserId(String id);

    int deleteByPrimaryKey(Long id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}