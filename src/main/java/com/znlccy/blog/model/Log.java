package com.znlccy.blog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
  * Author: znlccy
  * Date: 2019-08-30-14:31
  * Version: 1.0.0
  * Comment: 日志实体类
  */
@Entity
@Table(name = "tb_log")
@Data
@NoArgsConstructor
@ToString
public class Log {

    /**
     * 日志主键
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 请求地址
     */
    private String ip;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 请求方法
     */
    private String classMethod;

    /**
     * 请求参数
     */
    private Object[] args;
}
