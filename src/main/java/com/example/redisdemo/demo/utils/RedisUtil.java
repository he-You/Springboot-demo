package com.example.redisdemo.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by heyou on 2019/3/12 0012
 * redis操作CURD的工具类
 */

@Component
@Slf4j
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    /*********************缓存对象,最常用，适合所有类***********************/
    public boolean set(String key, Object value) {
        try {
            //因为redisTemplate已经设置了序列化，不需要再次配置
            ValueOperations operations = redisTemplate.opsForValue();
            operations.set(key, value);
            return true;
        } catch (Exception e) {
            log.error("写入value缓存异常，{}", e);
        }
        return false;
    }

    /**
     * 写入缓存，使用过期时间
     *
     * @param key
     * @param value
     * @param expireTime 过期时间
     * @param timeUnit 单位
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime, TimeUnit timeUnit) {
        try {
            ValueOperations operations = redisTemplate.opsForValue();
            operations.set(key, value, expireTime, timeUnit);
            return true;
        } catch (Exception e) {
            log.error("写入value缓存异常，{}", e);
        }
        return false;
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
// ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        ValueOperations operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }


    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public boolean remove(final String key) {
        if (exists(key)) {
            return redisTemplate.delete(key);
        }else {
            return false;
        }
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 根据正则表达式，批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /*********************以下为哈希，list等类型的基本操作***********************/


    public boolean hmSet(String key, Object hk, Object hv) {
        try {
            HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
            hash.put(key, hk, hv);
            return true;
        } catch (Exception e) {
            log.error("写入hash缓存异常，{}", e);
        }
        return false;
    }


    /**
     * 哈希获取数据
     *
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(String key, Object hashKey) {
// HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * 列表添加
     *
     * @param k
     * @param v
     */
    public void listSet(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    /**
     * 列表获取
     *
     * @param k
     * @param start
     * @param end
     * @return
     */
    public List<Object> listGet(String k, long start, long end) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, start, end);
    }

    /**
     * 集合添加
     *
     * @param key
     * @param value
     */
    public void setAdd(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * 集合获取
     *
     * @param key
     * @return
     */
    public Set<Object> setPop(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     * @param scoure
     */
    public void zSetAdd(String key, Object value, double scoure) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    /**
     * 有序集合获取
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> zSetPop(String key, double scoure, double scoure1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }

}
