package com.jk.controller;

import com.jk.model.SysPermission;
import com.jk.model.SysUser;
import com.jk.service.SysUserService;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements SysUserService {

    @Autowired
    private UserService userService;

    @RequestMapping("/findUserByUsername")
    public SysUser findUserByUsername(@RequestParam(value = "username") String username){
        return userService.findUserByUsername(username);
    }

    @RequestMapping("/findMenuByUserId")
    public List<SysPermission> findMenuByUserId(@RequestParam(value = "id") String id){
        return userService.findMenuByUserId(id);
    }
}
