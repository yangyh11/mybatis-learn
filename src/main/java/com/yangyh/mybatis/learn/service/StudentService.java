package com.yangyh.mybatis.learn.service;

import com.yangyh.mybatis.learn.entity.StudentEntity;

import java.util.List;

/**
 * @description:
 * @author: yangyh
 * @create: 2019-05-27 15:58
 */
public interface StudentService {

    /** 根据学号查询学生信息**/
    StudentEntity getStudentByNo(Long studentNo);

    /** 根据主修课程查询学生信息**/
    List<StudentEntity> listStudentByMajor(String major);

    /** 根据年龄和主修课程查询学生信息**/
    List<StudentEntity> listStudentByAgeAndMajor(int age, String major);

    /** 根据年龄和主修课程查询学生信息**/
    List<StudentEntity> getStudentByMap(int age, String major);

    /** 根据id列表查询学生信息**/
    List<StudentEntity> getStudentByList(String[] array);

    /** 根据id列表和主修课程查询学生信息**/
    List<StudentEntity> getStudentListByMap(String[] array, String major);

    /** 根据姓氏查询学生用户信息**/
    List<StudentEntity> getStudentListByfamilyName(String familyName);

    void update(Long studentNo, String major);

    void save(Long studentNo, String name, Integer age, String major);

    void delete(Long studentNo);

    void saveBatch();
}
