package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public HashMap<String, Object> selectUser(Integer start, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        Integer sum = userMapper.selectCount();
        map.put("total",sum);
        List<User> list = userMapper.selectUser(start,pageSize);
        map.put("rows",list);
        return map;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public void updateUser(User user) {
            userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}
