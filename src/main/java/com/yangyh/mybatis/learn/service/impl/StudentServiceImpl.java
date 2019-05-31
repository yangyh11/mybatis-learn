package com.yangyh.mybatis.learn.service.impl;

import com.yangyh.mybatis.learn.entity.StudentEntity;
import com.yangyh.mybatis.learn.mapper.StudentMapper;
import com.yangyh.mybatis.learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: yangyh
 * @create: 2019-05-27 16:01
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    /**
     * 根据学号查询学生信息
     **/
    @Override
    public StudentEntity getStudentByNo(Long studentNo) {
        StudentEntity entity = studentMapper.getStudentByNo(studentNo);
        return entity;
    }

    /**
     * 根据主修课程查询学生信息
     **/
    @Override
    public List<StudentEntity> listStudentByMajor(String major) {
        List<StudentEntity> list = studentMapper.listStudentByMajor(major);
        return list;
    }

    /**
     * 根据年龄和主修课程查询学生信息
     **/
    @Override
    public List<StudentEntity> listStudentByAgeAndMajor(int age, String major) {
        List<StudentEntity> list = studentMapper.listStudentByAgeAndMajor3(age, major);
        return list;
    }

    @Override
    public List<StudentEntity> getStudentByMap(int age, String major) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("age", age);
        paramMap.put("major", major);
        List<StudentEntity> list = studentMapper.queryByMap(paramMap);
        return list;
    }

    @Override
    public List<StudentEntity> getStudentByList(String[] array) {
        List<String> idList = Arrays.asList(array);
        List<StudentEntity> resultList = studentMapper.getStudentByList(idList);
        return resultList;
    }

    /**
     * 根据id列表和主修课程查询学生信息
     **/
    @Override
    public List<StudentEntity> getStudentListByMap(String[] array, String major) {
        Map<String, Object> paramMap = new HashMap<>();
        List<String> idList = Arrays.asList(array);
        paramMap.put("list", idList);
        paramMap.put("major", major);
        List<StudentEntity> list = studentMapper.getStudentListByMap(paramMap);
        return list;
    }

    /**
     * 根据姓氏查询学生用户信息
     **/
    @Override
    public List<StudentEntity> getStudentListByfamilyName(String familyName) {
        List<StudentEntity> list = studentMapper.getStudentListByfamilyName(familyName);
        return list;
    }

    @Override
    public void update(Long studentNo, String major) {
        StudentEntity entity = new StudentEntity();
        entity.setStudentNo(studentNo);
        entity.setMajor(major);
        studentMapper.update(entity);
    }

    @Override
    public void save(Long studentNo, String name, Integer age, String major) {
        StudentEntity entity = new StudentEntity();
        entity.setStudentNo(studentNo);
        entity.setName(name);
        entity.setAge(age);
        entity.setMajor(major);
        studentMapper.save(entity);
    }

    @Override
    public void delete(Long studentNo) {
        StudentEntity entity = new StudentEntity();
        entity.setStudentNo(studentNo);
        studentMapper.delete(entity);
    }

    @Override
    public void saveBatch() {
        StudentEntity entity = new StudentEntity();
        entity.setStudentNo(20140411L);
        entity.setName("库里");
        entity.setAge(19);
        entity.setMajor("体育");

        StudentEntity entity2 = new StudentEntity();
        entity2.setStudentNo(20140412L);
        entity2.setName("哈登");
        entity2.setAge(19);
        entity2.setMajor("体育");

        List<StudentEntity> list = new ArrayList<>();
        list.add(entity);
        list.add(entity2);
        studentMapper.saveBatch(list);

    }
}
