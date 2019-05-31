package com.yangyh.mybatis.learn.mapper;

import com.yangyh.mybatis.learn.entity.StudentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
  * @description:
  * @author: Administrator
  * @create: 2019年5月27日 下午5:03:14
  */
@Repository
public interface StudentMapper {
    /** 单个参数**/
    StudentEntity getStudentByNo(Long studentNo);
    /** 单个参数，多个结果**/
    List<StudentEntity> listStudentByMajor(String major);

    /** 多个参数，占位符 不推荐使用**/
    List<StudentEntity> listStudentByAgeAndMajor1(int age, String major);
    /** 多个参数，默认根据形参名获取**/
    List<StudentEntity> listStudentByAgeAndMajor2(int age, String major);
    /** 多个参数，注解方式**/
    List<StudentEntity> listStudentByAgeAndMajor3(@Param("age1") int age, @Param("major1")String major);

    /** 多个参数，用Map封装多个参数**/
    List<StudentEntity> getStudentByMap(Map<String, Object> paramMap);
    /** 【推荐】多个参数，用Map封装多个参数**/
    List<StudentEntity> queryByMap(Map<String, Object> map);

    /** 多参数查询，List封装多参数**/
    List<StudentEntity> getStudentByList(List<String> idList);

    /** 参数既有String又有List，将String和List放在Map里**/
    List<StudentEntity> getStudentListByMap(Map<String, Object> paramMap);

    /** 根据姓氏模糊查询**/
    List<StudentEntity> getStudentListByfamilyName(@Param("familyName") String familyName);

    int save(StudentEntity entity);

    int saveBatch(List<StudentEntity> list);

    int update(StudentEntity entity);

    int delete(StudentEntity entity);


}