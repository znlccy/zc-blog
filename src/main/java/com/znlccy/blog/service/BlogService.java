package com.znlccy.blog.service;

import com.znlccy.blog.model.Blog;
import com.znlccy.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
  * Author: znlccy
  * Date: 2019-08-29-10:58
  * Version: 1.0.0
  * Comment: 博客服务接口
  */
public interface BlogService {

    /**
     * 获取博客
     * @param id
     * @return
     */
    Blog getBlog(Long id);

    /**
     * 分页查找博客
     * @param pageable
     * @param blog
     * @return
     */
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    /**
     * 添加博客
     * @param blog
     * @return
     */
    Blog saveBlog(Blog blog);

    /**
     * 更新博客
     * @param id
     * @param blog
     * @return
     */
    Blog updateBlog(Long id, Blog blog);

    /**
     * 删除博客
     * @param id
     */
    void deleteBlog(Long id);
}
