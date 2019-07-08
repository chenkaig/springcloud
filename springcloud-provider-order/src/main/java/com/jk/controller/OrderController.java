package com.jk.controller;

import com.jk.mapper.OrderMapper;
import com.jk.model.User;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderController implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Override
    @RequestMapping("aaa")
    public User text(@RequestBody User user) {
        user.setUserId(111);
        user.setBirthday(new Date());
        return user;
    }
}
