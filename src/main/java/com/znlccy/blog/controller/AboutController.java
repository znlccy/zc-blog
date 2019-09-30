package com.znlccy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * Author: znlccy
  * Date: 2019-08-30-14:11
  * Version: 1.0.0
  * Comment: 关于我控制器
  */
@Controller
@RequestMapping(value = "about")
public class AboutController {

    @GetMapping(value = "")
    public String index() {
        return "about";
    }
}
