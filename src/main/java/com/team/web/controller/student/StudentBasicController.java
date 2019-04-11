package com.team.web.controller.student;

import com.team.common.beans.ResultBean;
import com.team.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by yifeng
 */
@RestController
@RequestMapping("/student/basic")
public class StudentBasicController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "basicdata", method = RequestMethod.GET)
    public ResultBean<List> getAllStudent() {
        return new ResultBean<>(studentService.findAllStudent());
    }



}
