package com.example.redisdemo.demo.controller;

import com.example.redisdemo.demo.UserService.UserService;
import com.example.redisdemo.demo.entity.User;
import com.example.redisdemo.demo.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by heyou on 2019/3/11 0011
 */
@Controller
@RequestMapping("redis")
public class RedisController {
    /**
     * StringRedisTemplate继承了RedisTemplate。继承RedisTempalte，
     * 与RedisTemplate不同的是设置了序列化策略，使用StringRedisSerializer类来
     * 序列化key-value，以及List、Hash、Set。在这里，我们直接用就行了。
     */
    @Autowired
    UserService userService;
    @Autowired
    private StringRedisTemplate redisClient;
    @RequestMapping("setAndsave")
    @ResponseBody
    public String test(String para) throws Exception{
        redisClient.opsForValue().set("test", para);
        String str = redisClient.opsForValue().get("test");
        return str;

    }
    @RequestMapping("getjson")
    @ResponseBody
    public String  getJson(){
        User user1 = new User();
        user1.setNickname("wang");
        user1.setPassword("admin");
        user1.setUsername("admin");
        redisClient.opsForValue().set("user", JsonUtils.objectToJson(user1));
        String str = redisClient.opsForValue().get("user");
        String u1  = JsonUtils.objectToJson(user1);
        return str;
    }

}
