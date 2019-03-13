package com.example.redisdemo.demo.dao;

import com.example.redisdemo.demo.entity.User;

import java.util.List;

/**
 * Created by heyou on 2019/3/12 0012
 */
public interface UserMapper {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(Integer id);

    User findByName(String name);

    List<User> getAllUsers();

}
