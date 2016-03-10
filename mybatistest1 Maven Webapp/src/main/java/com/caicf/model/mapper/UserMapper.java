package com.caicf.model.mapper;

import java.util.List;

import com.caicf.model.User;

public interface UserMapper {
	
	/**
	 * 根据条件，查询部分User,choose标签
	 * @param user
	 * @return
	 */
	public List<User> selectPartUserChoose(User user);
	
	/**
	 * 根据条件，查询部分User,if标签
	 * @param user
	 * @return
	 */
	public List<User> selectPartUser(User user);
	
	/**
	 * 根据id查询User
	 * @param id
	 */
	public User selectUser(int id); 
	
	/**
	 * 插入用户
	 * @param user
	 */
	public void insetUser(User user) ;
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 根据id删除用户0
	 * @param id
	 */
	public void deleteUser(int id) ;
	
	/**
	 * 查询所有用户
	 */
	public List<User> selectAllUser();	

}
