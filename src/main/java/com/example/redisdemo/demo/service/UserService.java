package com.example.redisdemo.demo.service;

import com.example.redisdemo.demo.entity.User;

import java.util.List;

/**
 * Created by heyou on 2019/3/12 0012
 */
public interface UserService {
    public List<User> getUser(String username);

    public User getUser2(String username);

    User getUserById(Integer id);

    User findByName(String name);

    List<User> getAllUsers();
}
