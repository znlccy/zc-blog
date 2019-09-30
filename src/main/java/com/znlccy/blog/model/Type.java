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
  * Comment: 分类实体类
  */
@Entity
@Table(name = "tb_type")
@Data
@NoArgsConstructor
@ToString
public class Type {

    /**
     * 类型主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 类型名称
     */
    @NotBlank(message = "分类名称不能为空")
    private String name;

    /**
     * 关联类型
     */
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
