package com.team.mapper;

import com.team.bean.Cla;
import com.team.bean.Cla;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClaMapper {
	List<Cla> findAllClas();
	
	List<Cla> findClasByName(@Param("name") String name);
	
	Cla findClaById(@Param("id") int id);
	
	int addCla(Cla cla);
	
	int updateCla(@Param("cla") Cla cla);
	
	int deleteClaById(@Param("id") int id);
}
