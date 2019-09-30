package com.znlccy.blog.service;

import com.znlccy.blog.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
  * Author: znlccy
  * Date: 2019-08-30-13:16
  * Version: 1.0.0
  * Comment: 标签服务接口
  */
public interface TagService {

    /**
     * 保存标签
     * @param tag
     * @return
     */
    Tag saveTag(Tag tag);

    /**
     * 获取标签
     * @param id
     * @return
     */
    Tag getTag(Long id);

    /**
     * 通过名称查找标签
     * @param name
     * @return
     */
    Tag getTagByName(String name);

    /**
     * 分页查询标签
     * @param pageable
     * @return
     */
    Page<Tag> listTag(Pageable pageable);

    /**
     * 更新标签
     * @param id
     * @param tag
     * @return
     */
    Tag updateTag(Long id, Tag tag);

    /**
     * 删除标签
     * @param id
     */
    void deleteTag(Long id);

    /**
     * 所有标签
     * @return
     */
    List<Tag> listTag();
}
