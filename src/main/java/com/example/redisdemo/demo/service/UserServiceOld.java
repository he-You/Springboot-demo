package com.example.redisdemo.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@CacheConfig(cacheNames="my-cache-redis-1")//使用此处缓存名，若方法上注解有写，则按后者
public class UserServiceOld {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Cacheable(value = "user", key ="#id", unless = "#result==null")
    public String getUser(int id) {
        System.out.println("i am from userService");
        System.out.println(stringRedisTemplate.getValueSerializer());
        System.out.println(redisTemplate.getValueSerializer());
        return "fee";
    }

}
