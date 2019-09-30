package com.znlccy.blog.service.impl;

import com.znlccy.blog.dao.TypeRepository;
import com.znlccy.blog.model.Type;
import com.znlccy.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
  * Author: znlccy
  * Date: 2019-08-30-13:08
  * Version: 1.0.0
  * Comment: 类型服务实现类
  */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    /**
     * 保存分类
     * @param type
     * @return
     */
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    /**
     * 获取分类
     * @param id
     * @return
     */
    @Override
    public Type getType(Long id) {
        return typeRepository.findOne(id);
    }

    /**
     * 通过名称查找分类
     * @param name
     * @return
     */
    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    /**
     * 分页查询分类
     * @param pageable
     * @return
     */
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    /**
     * 更新分类
     * @param id
     * @param type
     * @return
     */
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findOne(id);
        if (t == null) {
            try {
                throw new Exception("不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }

    /**
     * 删除分类
     * @param id
     */
    @Override
    public void deleteType(Long id) {
        typeRepository.delete(id);
    }

    /**
     * 查询所有分类
     * @return
     */
    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }
}
