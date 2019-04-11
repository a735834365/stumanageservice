package com.team.mapper;

import com.team.bean.Dept;
import com.team.bean.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeptMapper {
	List<Dept> findAllDepts();
	
	List<Dept> findDeptByName(@Param("name") String name);
	
	Dept findDeptById(@Param("id") int id);
	
	int addDept(Dept dept);
	
	int updateDept(@Param("dept") Dept dept);
	
	int deleteDeptById(@Param("id") int id);
}
