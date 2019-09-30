package com.znlccy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * Author: znlccy
  * Date: 2019-08-28-13:47
  * Version: 1.0.0
  * Comment: 博客分类控制器
  */
@Controller
@RequestMapping(value = "/types")
public class TypesController {

    @GetMapping(value = "")
    public String index() {
        return "types";
    }
}
