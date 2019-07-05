package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    Integer selectCount();

    List<User> selectUser(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    void addUser(User user);

    User selectUserById(Integer id);

    void updateUser(User user);

    void deleteUser(Integer id);
}
