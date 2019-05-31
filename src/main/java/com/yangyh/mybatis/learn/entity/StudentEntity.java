package com.yangyh.mybatis.learn.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.lang.Integer;

/**
  * @description:
  * @author: Administrator
  * @create: 2019年5月27日 下午5:03:14
  */
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long studentNo;
    private String name;
    private Integer age;
    private String major;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Long studentNo) {
        this.studentNo = studentNo;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}