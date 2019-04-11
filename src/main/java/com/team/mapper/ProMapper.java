package com.team.mapper;

import com.team.bean.Professional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProMapper {
	
	List<Professional> findAllPros();
	
	List<Professional> findProsByName(@Param("name") String name);
	
	Professional findProById(@Param("id") int id);
	
	int addPro(Professional professional);
	
	int updatePro(@Param("pro") Professional professional);
	
	int deleteProById(@Param("id") int id);
}
