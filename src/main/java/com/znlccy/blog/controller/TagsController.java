package com.znlccy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * Author: znlccy
  * Date: 2019-08-28-14:20
  * Version: 1.0.0
  * Comment: 标签控制器
  */
@Controller
@RequestMapping(value = "/tags")
public class TagsController {

    @GetMapping(value = "")
    public String index() {
        return "tags";
    }
}
