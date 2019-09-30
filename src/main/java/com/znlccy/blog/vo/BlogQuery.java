package com.znlccy.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-29-20:49
 * @remark: 博客分装查询对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogQuery {

    /**
     * 博客标题
     */
    private String title;

    /**
     * 分类主键
     */
    private Long typeId;

    /**
     * 是否推荐
     */
    private boolean recommend;
}
