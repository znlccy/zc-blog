package com.znlccy.blog.service.impl;

import com.znlccy.blog.dao.UserRepository;
import com.znlccy.blog.model.User;
import com.znlccy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
  * Author: znlccy
  * Date: 2019-08-29-10:52
  * Version: 1.0.0
  * Comment: 用户服务实现类
  */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findUserByUsernameAndPassword(username, password);
        return user;
    }
}
