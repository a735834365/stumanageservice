package com.team.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.team.bean.User;

@Mapper
public interface UserMapper {
	User findUserByUserName(@Param("username") String username);
	
	int addUser(User user);
}
