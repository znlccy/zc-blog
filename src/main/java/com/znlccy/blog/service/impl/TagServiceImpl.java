package com.znlccy.blog.service.impl;

import com.znlccy.blog.dao.TagRepository;
import com.znlccy.blog.model.Tag;
import com.znlccy.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
  * Author: znlccy
  * Date: 2019-08-30-13:17
  * Version: 1.0.0
  * Comment: 标签服务实现类
  */
@Service
@Transactional
public class TagServiceImpl implements TagService {

    /**
     * 注入标签Dao层
     */
    @Autowired
    private TagRepository tagRepository;

    /**
     * 添加标签
     * @param tag
     * @return
     */
    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    /**
     * 获取标签
     * @param id
     * @return
     */
    @Override
    public Tag getTag(Long id) {
        return tagRepository.getOne(id);
    }

    /**
     * 通过名称查找标签
     * @param name
     * @return
     */
    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    /**
     * 分页查找标签
     * @param pageable
     * @return
     */
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    /**
     * 更新标签
     * @param id
     * @param tag
     * @return
     */
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.findOne(id);
        if (t == null) {
            try {
                throw new Exception("不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        BeanUtils.copyProperties(tag,t);
        return tagRepository.save(t);
    }

    /**
     * 删除标签
     * @param id
     */
    @Override
    public void deleteTag(Long id) {
        tagRepository.delete(id);
    }

    /**
     * 所有标签
     * @return
     */
    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }
}
