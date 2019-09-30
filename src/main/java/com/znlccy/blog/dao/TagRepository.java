package com.znlccy.blog.dao;

import com.znlccy.blog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
  * Author: znlccy
  * Date: 2019-08-30-13:19
  * Version: 1.0.0
  * Comment: 标签Dao层
  */
public interface TagRepository extends JpaRepository<Tag, Long> {

    /**
     * 通过名称查找标签
     * @param name
     * @return
     */
    Tag findByName(String name);
}
