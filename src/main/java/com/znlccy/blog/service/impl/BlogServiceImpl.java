package com.znlccy.blog.service.impl;

import com.znlccy.blog.dao.BlogRepository;
import com.znlccy.blog.model.Blog;
import com.znlccy.blog.model.Type;
import com.znlccy.blog.service.BlogService;
import com.znlccy.blog.vo.BlogQuery;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
  * Author: znlccy
  * Date: 2019-08-29-11:13
  * Version: 1.0.0
  * Comment: 博客服务实现类
  */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    /**
     * 依赖注入博客dao层
     */
    @Autowired
    private BlogRepository blogRepository;

    /**
     * 获取博客
     * @param id
     * @return
     */
    @Override
    public Blog getBlog(Long id) {
        return blogRepository.getOne(id);
    }

    /**
     * 分页查找博客
     * @param pageable
     * @param blog
     * @return
     */
    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
                    predicates.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
                }

                if (blog.getTypeId() != null) {
                    predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
                }

                if (blog.isRecommend()) {
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }

                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    /**
     * 添加博客
     * @param blog
     * @return
     */
    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    /**
     * 更新博客
     * @param id
     * @param blog
     * @return
     */
    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog blogSearch = blogRepository.findOne(id);
        if (blogSearch == null) {
            try {
                throw new NotFoundException("该博客不存在");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        BeanUtils.copyProperties(blogSearch, blog);
        return blogRepository.save(blogSearch);
    }

    /**
     * 删除博客
     * @param id
     */
    @Override
    public void deleteBlog(Long id) {
        blogRepository.delete(id);
    }
}
