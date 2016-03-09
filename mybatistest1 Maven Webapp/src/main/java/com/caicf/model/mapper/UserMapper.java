package com.caicf.model.mapper;

import java.util.List;

import com.caicf.model.User;

public interface UserMapper {
	//根据id查询User
	public User selectUser(int id); 
	public void insetUser(User user) ;
	public void updateUser(User user);
	public void deleteUser(int i) ;
	
//	public List<User> selectAllUser();	
}
