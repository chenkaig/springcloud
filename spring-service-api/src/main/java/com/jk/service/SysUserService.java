package com.jk.service;

import com.jk.model.SysPermission;
import com.jk.model.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SysUserService {

    @RequestMapping("/findUserByUsername")
    SysUser findUserByUsername(@RequestParam(value = "username") String username);

    @RequestMapping("/findMenuByUserId")
    List<SysPermission> findMenuByUserId(@RequestParam(value = "id") String id);
}
