package com.znlccy.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * Author: znlccy
  * Date: 2019-08-30-14:01
  * Version: 1.0.0
  * Comment: 归档控制器
  */
@Controller
@RequestMapping(value = "/archives")
public class ArchivesController {

    @GetMapping(value = "")
    public String index() {
        return "archives";
    }
}
