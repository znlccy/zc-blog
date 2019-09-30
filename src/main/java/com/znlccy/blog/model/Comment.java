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
  * Date: 2019-08-28-22:07
  * Version: 1.0.0
  * Comment: 评论实体类
  */
@Entity
@Table(name = "tb_comment")
@Data
@NoArgsConstructor
@ToString
public class Comment {

    /**
     * 评论主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 评论昵称
     */
    private String nickname;

    /**
     * 评论邮箱
     */
    private String email;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论头像
     */
    private String avatar;

    /**
     * 回复评论
     */
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();

    /**
     * 父级评论
     */
    @ManyToOne
    private Comment parentComment;

    /**
     * 关联博客
     */
    @ManyToOne
    private Blog blog;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
}
