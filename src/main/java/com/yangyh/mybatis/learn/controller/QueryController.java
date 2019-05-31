package com.yangyh.mybatis.learn.controller;

import com.yangyh.mybatis.learn.entity.StudentEntity;
import com.yangyh.mybatis.learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: mybatis查询
 * @author: yangyh
 * @create: 2019-05-27 15:52
 */
@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private StudentService studentService;

    /**
     * 单个参数查询, 返回一个结果
     * url:127.0.0.1:8080/query/test1?student_no=20140401
     **/
    @RequestMapping("test1")
    public StudentEntity Test1(@RequestParam(value = "student_no") Long studentNo) {
        StudentEntity student = studentService.getStudentByNo(studentNo);
        return student;
    }

    /**
     * 单个参数查询, 返回多个结果
     * url:127.0.0.1:8080/query/test2?major=历史
     **/
    @RequestMapping("test2")
    public List<StudentEntity> Test2(@RequestParam(value = "major") String major) {
        List<StudentEntity> list = studentService.listStudentByMajor(major);
        return list;
    }

    /**
     * 多参数查询
     * url:127.0.0.1:8080/query/test3?age=19&major=历史
     **/
    @RequestMapping("test3")
    public List<StudentEntity> Test3(@RequestParam(value = "age") Integer age,
                                     @RequestParam(value = "major") String major) {
        List<StudentEntity> list = studentService.listStudentByAgeAndMajor(age, major);
        return list;
    }

    /**
     * 多参数查询，用Map封装多参数
     * url:127.0.0.1:8080/query/test4?age=19&major=历史
     **/
    @RequestMapping("test4")
    public List<StudentEntity> Test4(@RequestParam(value = "age") Integer age,
                                     @RequestParam(value = "major") String major) {
        List<StudentEntity> list = studentService.getStudentByMap(age, major);
        return list;
    }

    /**
     * 多参数查询，List封装多参数
     * url:127.0.0.1:8080/query/test5?id_array=1,2
     **/
    @RequestMapping("test5")
    public List<StudentEntity> Test5(@RequestParam(value = "id_array") String idArray) {
        String[] array = idArray.split(",");
        List<StudentEntity> list = studentService.getStudentByList(array);
        return list;
    }

    /**
     * 参数既有String又有List
     * url:127.0.0.1:8080/query/test6?id_array=1,2&major=计算机
     **/
    @RequestMapping("test6")
    public List<StudentEntity> Test6(@RequestParam(value = "id_array") String idArray,
                                     @RequestParam(value = "major") String major) {
        String[] array = idArray.split(",");
        List<StudentEntity> list = studentService.getStudentListByMap(array, major);
        return list;
    }

    /**
     * 模糊查询
     * url:127.0.0.1:8080/query/test7?family_name=蔡
     **/
    @RequestMapping("test7")
    public List<StudentEntity> Test7(@RequestParam(value = "family_name") String familyName) {
        List<StudentEntity> list = studentService.getStudentListByfamilyName(familyName);
        return list;
    }



}
