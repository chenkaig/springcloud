package com.jk.service;

import com.jk.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/error")
@Component
public class OrderServiceError implements OrderServiceFeign{
    @Override
    public User text(User user) {
        return null;
    }
}
