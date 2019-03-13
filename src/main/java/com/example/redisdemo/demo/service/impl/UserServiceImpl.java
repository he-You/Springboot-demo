package com.example.redisdemo.demo.service.impl;

import com.example.redisdemo.demo.dao.UserMapper;
import com.example.redisdemo.demo.service.UserService;
import com.example.redisdemo.demo.entity.PhotoInfo;
import com.example.redisdemo.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by heyou on 2019/3/12 0012
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Cacheable(cacheNames = "my-redis-cache1",key = "'cache1-'.concat(#username)",unless = "#result==null||#result.get(0).photoInfo.thumbs.size()<=0")
    public List<User> getUser(String username) {
        log.info("进入实现类获取数据: {}" + username);
        Random random = new Random();
        PhotoInfo photoInfo = new PhotoInfo();
        List<String> urls = new ArrayList<>();
        urls.add("http://xxx.com");
        photoInfo.setThumbs(urls);
        User user1 =new User(username, random.nextInt(30),photoInfo);
        User user2 =new User(username, random.nextInt(30),photoInfo);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        return users;
    }

    @Override
    @Cacheable(cacheNames = "my-redis-cache2",key = "'cache2-'.concat(#username)")//使用过期时间2，测试OK
    public User getUser2(String username) {
        log.info("进入实现类获取数据: {}" + username);
        Random random = new Random();
        PhotoInfo photoInfo = new PhotoInfo();
        List<String> urls = new ArrayList<>();
        urls.add("http://xxx.com");
        photoInfo.setThumbs(urls);
        int age = random.nextInt(30);
        if (age < 20) {
            return null; //测试返回空，不缓存的策略
        }else {
            return new User(username, age,photoInfo);
        }
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
