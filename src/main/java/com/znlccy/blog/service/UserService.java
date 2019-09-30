package com.znlccy.blog.service;

import com.znlccy.blog.model.User;

/**
  * Author: znlccy
  * Date: 2019-08-29-10:57
  * Version: 1.0.0
  * Comment: 用户服务接口
  */
public interface UserService {

    User checkUser(String username, String password);
}
