package com.yangyh.mybatis.learn.controller;

import com.yangyh.mybatis.learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: mybatis更新
 * @author: yangyh
 * @create: 2019-05-27 15:52
 */
@RestController
@RequestMapping("/update")
public class UpdateController {

    @Autowired
    private StudentService studentService;

    /**
     * 更新数据
     * url:127.0.0.1:8080/update/test1?student_no=20140401&major=汉语言
     **/
    @RequestMapping("test1")
    public String Test1(@RequestParam(value = "student_no") Long studentNo,
                               @RequestParam(value = "major") String major) {
        studentService.update(studentNo, major);
        return "学生信息更新成功";
    }



}
