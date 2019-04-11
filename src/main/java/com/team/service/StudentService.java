package com.team.service;

import com.team.bean.Student;
import com.team.bean.User;
import com.team.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by yifeng
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();
    }


}
