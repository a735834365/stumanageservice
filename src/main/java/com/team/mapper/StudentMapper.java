package com.team.mapper;

import com.team.bean.Cla;
import com.team.bean.Dept;
import com.team.bean.Professional;
import com.team.bean.Student;
import com.team.bean.Cla;
import com.team.bean.Dept;
import com.team.bean.Professional;
import com.team.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
	List<Student> findAllStudent();
	List<Professional> findAllProfessional();
	List<Dept> findAllDept();
	int addStudent(Student student);
	int updateStudent(@Param("stu") Student student);
	List<Cla> findAllClass();
	Student findStudentById(@Param("id") int id);
	List<Student> findStudentByName(@Param("name") String name);
	int deleteStudentById(@Param("id") int id);
}
