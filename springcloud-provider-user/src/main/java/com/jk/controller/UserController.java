package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    private UserService  userService;

    @GetMapping("selectUser/{start}/{pageSize}")
    public HashMap<String,Object> selectUser(@PathVariable(value = "start") Integer start,
                                             @PathVariable(value = "pageSize") Integer pageSize){
        HashMap<String,Object>  map = userService.selectUser(start,pageSize);
        return map;

    }

    @PostMapping("addUser")
    public void  addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("selectUserById/{id}")
    public User selectUserById(@PathVariable(value = "id")Integer id){
        User user = userService.selectUserById(id);
        return user;
    }

    @PutMapping("updateUser")
    public  void updateUser(@RequestBody User  user){
        userService.updateUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable(value = "id")Integer id){
        userService.deleteUser(id);
    }
}
