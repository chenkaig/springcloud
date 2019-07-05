package com.jk.service;

import com.jk.model.User;

import java.util.HashMap;

public interface UserService {
    HashMap<String, Object> selectUser(Integer start, Integer pageSize);

    void addUser(User user);

    User selectUserById(Integer id);

    void updateUser(User user);

    void deleteUser(Integer id);
}
