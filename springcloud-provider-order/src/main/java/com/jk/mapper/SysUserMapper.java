package com.jk.mapper;

import com.jk.model.SysUser;

public interface SysUserMapper {

    SysUser findUserByUsername(String username);

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}