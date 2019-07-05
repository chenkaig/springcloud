package com.jk.controller;

import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("selectUser")
    public HashMap<String,Object> selectUser(@RequestParam(value = "start") Integer start,
                                             @RequestParam(value = "pageSize") Integer pageSize){
        HashMap<String,Object> map = restTemplate.getForObject("http://provider-user/selectUser"+"/"+start+"/"+pageSize, HashMap.class);
        return map;

    }

    @PostMapping("addUser")
    public void addUser(User user){
          restTemplate.postForObject("http://provider-user/addUser", user,User.class);
    }


    @PutMapping("updateUser")
    public void  updateUser(User user){
        restTemplate.put("http://provider-user/updateUser",user,User.class);
    }

    @DeleteMapping("deleteUser")
    public void  deleteUser(@RequestParam(value = "id")Integer id){
        restTemplate.delete("http://provider-user/deleteUser/"+id);
    }
}
