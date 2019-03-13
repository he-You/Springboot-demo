package com.example.redisdemo.demo.service;

import com.example.redisdemo.demo.entity.Novel;

import java.util.List;

/**
 * Created by heyou on 2019/3/13 0013
 */
public interface NovelService {
    List<Novel> selectAll();
}
