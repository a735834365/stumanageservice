package com.team.service;

import com.team.StumanageApplicationTest;
import com.team.bean.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * create by yifeng
 */
public class StudentServiceTest extends StumanageApplicationTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void findAllStudent() {
        List<Student> list = studentService.findAllStudent();
        System.out.println(list);
    }

}
