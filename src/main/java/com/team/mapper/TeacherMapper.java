package com.team.mapper;

import com.team.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
	List<Teacher> findAllTeacher();
	
	List<Teacher> findTeacherByTeachername(@Param("name") String name);
	
	Teacher findTeacherById(@Param("id") int id);
	
	int addTeacher(Teacher teacher);
	
	int updateTeacher(@Param("tea") Teacher teacher);
	
	int deleteTeacherById(@Param("id") int id);
	
}
