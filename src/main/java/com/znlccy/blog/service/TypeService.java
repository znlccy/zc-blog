package com.znlccy.blog.service;

import com.znlccy.blog.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
  * Author: znlccy
  * Date: 2019-08-30-13:13
  * Version: 1.0.0
  * Comment: 
  */
public interface TypeService {

    /**
     * 保存分类
     * @param type
     * @return
     */
    Type saveType(Type type);

    /**
     * 获取分类
     * @param id
     * @return
     */
    Type getType(Long id);

    /**
     * 通过名称查找分类
     * @param name
     * @return
     */
    Type getTypeByName(String name);

    /**
     * 分页查询分类
     * @param pageable
     * @return
     */
    Page<Type> listType(Pageable pageable);

    /**
     * 更新分类
     * @param id
     * @param type
     * @return
     */
    Type updateType(Long id, Type type);

    /**
     * 删除分类
     * @param id
     */
    void deleteType(Long id);

    /**
     * 获取所有分类
     * @return
     */
    List<Type> listType();
}
