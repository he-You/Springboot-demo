package com.example.redisdemo.demo.dao;

import com.example.redisdemo.demo.entity.User;

/**
 * Created by heyou on 2019/3/12 0012
 */
public interface UserDao {
    public User getUserById(Integer id);
}
