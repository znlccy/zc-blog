package com.znlccy.blog.dao;

import com.znlccy.blog.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
  * Author: znlccy
  * Date: 2019-08-30-13:07
  * Version: 1.0.0
  * Comment: 类型Dao层
  */
public interface TypeRepository extends JpaRepository<Type, Long> {

    /**
     * 通过名称查找分类
     * @param name
     * @return
     */
    Type findByName(String name);
}
