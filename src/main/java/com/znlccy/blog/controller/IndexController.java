package com.znlccy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
  * Author: znlccy
  * Date: 2019-08-22-21:48
  * Version: 1.0.0
  * Comment: 首页控制器
  */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        /*int i = 9/0;*/
        return "index";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }
}
