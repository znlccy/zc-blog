package com.znlccy.blog.dao;

import com.znlccy.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
  * Author: znlccy
  * Date: 2019-08-29-11:21
  * Version: 1.0.0
  * Comment: 博客Dao层
  */
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

}
