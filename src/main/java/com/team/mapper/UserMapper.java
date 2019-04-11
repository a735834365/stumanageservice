package com.team.mapper;

import com.team.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
//	User findUserByUsername(@Param("username") String username);
//	
//	int addUser(@Param("user")User user);//-----------------------
	
	//List<User> findUserByUserame(@Param("name")String name);
	
	User findUserById(@Param("id") int id);

	List<User> findUserList();

	int addUser(@Param("user") User user);

	User findUserByUserName(@Param("username") String username);

	int updateUser(@Param("user") User user);
	
	int deleteUserByUsername(@Param("username") String username);
}
