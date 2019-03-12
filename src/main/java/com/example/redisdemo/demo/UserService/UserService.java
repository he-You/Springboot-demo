package com.example.redisdemo.demo.UserService;

import com.example.redisdemo.demo.entity.User;

import java.util.List;

/**
 * Created by heyou on 2019/3/12 0012
 */
public interface UserService {
    public List<User> getUser(String username);

    public User getUser2(String username);
}
