package com.jk.service;

import com.jk.model.SysPermission;
import com.jk.model.SysUser;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/error")
@Component
public class SysUserServiceError implements SysUserServiceFeign {
    @Override
    public SysUser findUserByUsername(String username) {
        return null;
    }

    @Override
    public List<SysPermission> findMenuByUserId(String id) {
        return null;
    }
}
