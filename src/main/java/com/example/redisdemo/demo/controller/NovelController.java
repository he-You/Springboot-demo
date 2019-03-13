package com.example.redisdemo.demo.controller;

import com.example.redisdemo.demo.service.NovelService;
import com.example.redisdemo.demo.entity.Novel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by heyou on 2019/3/13 0013
 */
@Controller
@RequestMapping(value = "/novel")
public class NovelController {
    @Autowired
    private NovelService novelService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Novel> list = novelService.selectAll();
        model.addAttribute("novelList", list);
        return "novel_list";
    }
}
