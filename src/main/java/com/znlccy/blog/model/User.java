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
  * Date: 2019-08-27-13:24
  * Version: 1.0.0
  * Comment: 用户实体类
  */
@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@ToString
public class User {

    /**
     * 用户主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户类型
     */
    private Integer type;

    /**
     * 用户登录图片
     */
    private String loginPicture;

    /**
     * 关联用户
     */
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();

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
