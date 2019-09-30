package com.znlccy.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
  * Author: znlccy
  * Date: 2019-08-28-22:06
  * Version: 1.0.0
  * Comment: 博客实体类
  */
@Entity
@Table(name = "tb_blog")
@Data
@ToString
@NoArgsConstructor
public class Blog {

    /**
     * 博客主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 博客内容
     */
    private String content;

    /**
     * 博客首图
     */
    private String firstPicture;

    /**
     * 博客标签
     */
    private String flag;

    /**
     * 博客浏览数
     */
    private Integer views;

    /**
     * 是否开启赞赏
     */
    private boolean appreciation;

    /**
     * 是否开启声明
     */
    private boolean shareStatement;

    /**
     * 是否开启评论
     */
    private boolean commented;

    /**
     * 是否开启发布
     */
    private boolean published;

    /**
     * 是否开启推荐
     */
    private boolean recommend;

    /**
     * 关联类型
     */
    @ManyToOne
    private Type type;

    /**
     * 关联标签
     */
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    /**
     * 关联用户
     */
    @ManyToOne
    private User user;

    /**
     * 关联评论
     */
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

}
