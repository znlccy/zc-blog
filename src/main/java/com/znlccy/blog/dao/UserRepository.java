package com.znlccy.blog.dao;

import com.znlccy.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
  * Author: znlccy
  * Date: 2019-08-29-10:51
  * Version: 1.0.0
  * Comment: 用户Dao层
  */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);
}
