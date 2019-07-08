package com.jk.service;

import com.jk.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface OrderService {
    @RequestMapping("aaa")
    User text(@RequestBody User user);
}
