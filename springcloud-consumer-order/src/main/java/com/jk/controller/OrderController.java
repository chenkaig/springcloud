package com.jk.controller;

import com.jk.model.User;
import com.jk.service.OrderServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceFeign  feign;

    @RequestMapping("aaa")
    public User text(){
        User user = new User();
        user.setUserName("张淑恒");
        user.setSex(1);
        user.setAge(22);
       User user1 = feign.text(user);
       return user1;
    }
}
