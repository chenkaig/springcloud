package com.jk.service;

import com.jk.model.SysPermission;
import com.jk.model.SysUser;

import java.util.List;

public interface UserService {

    public SysUser findUserByUsername(String username);

    public List<SysPermission> findMenuByUserId(String id);
}
