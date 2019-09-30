package com.znlccy.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
  * Author: znlccy
  * Date: 2019-08-28-22:06
  * Version: 1.0.0
  * Comment: 标签实体类
  */
@Entity
@Table(name = "tb_tag")
@Data
@NoArgsConstructor
@ToString
public class Tag {

    /**
     * 标签主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 标签名称
     */
    @NotBlank(message = "标签名称不能为空")
    private String name;

    /**
     * 关联博客
     */
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();
}
