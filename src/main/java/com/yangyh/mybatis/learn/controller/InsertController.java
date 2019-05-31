package com.yangyh.mybatis.learn.controller;

import com.yangyh.mybatis.learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: mybatis插入
 * @author: yangyh
 * @create: 2019-05-27 15:52
 */
@RestController
@RequestMapping("/insert")
public class InsertController {

    @Autowired
    private StudentService studentService;

    /**
     * 插入数据
     * url:127.0.0.1:8080/insert/test1?student_no=20140401&name=科比&age=20&major=数学
     **/
    @RequestMapping("test1")
    public String Test1(@RequestParam(value = "student_no") Long studentNo,
                        @RequestParam(value = "name") String name,
                        @RequestParam(value = "age") Integer age,
                        @RequestParam(value = "major") String major) {
        studentService.save(studentNo, name, age, major);
        return "学生信息插入成功";
    }

    /**
     * 批量插入
     * url:127.0.0.1:8080/insert/test2
     */
    @RequestMapping("test2")
    public String Test2() {
        studentService.saveBatch();
        return "学生信息插入多条成功";
    }


}
