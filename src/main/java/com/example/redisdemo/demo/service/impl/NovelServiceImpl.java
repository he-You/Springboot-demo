package com.example.redisdemo.demo.service.impl;

import com.example.redisdemo.demo.service.NovelService;
import com.example.redisdemo.demo.dao.NovelMapper;
import com.example.redisdemo.demo.entity.Novel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by heyou on 2019/3/13 0013
 */
@Service
public class NovelServiceImpl implements NovelService {
    @Autowired
    private NovelMapper novelDao;
    @Override
    @Cacheable(cacheNames = "my-redis-cache2" ,key="'list'")//使用过期时间2，测试OK
    public List<Novel> selectAll() {
        return novelDao.getAllInfo();
    }
}
