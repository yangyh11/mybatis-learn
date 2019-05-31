package com.yangyh.mybatis.learn.controller;

import com.yangyh.mybatis.learn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: mybatis删除
 * @author: yangyh
 * @create: 2019-05-27 15:52
 */
@RestController
@RequestMapping("/delete")
public class DeleteController {

    @Autowired
    private StudentService studentService;

    /**
     * 删除数据
     * url:127.0.0.1:8080/delete/test1?student_no=20140401
     **/
    @RequestMapping("test1")
    public String Test1(@RequestParam(value = "student_no") Long studentNo) {
        studentService.delete(studentNo);
        return "学生信息删除成功";
    }
}
