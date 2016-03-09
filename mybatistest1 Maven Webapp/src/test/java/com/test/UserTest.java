package com.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.caicf.model.User;
import com.caicf.model.mapper.UserMapper;

public class UserTest{

	@Test
	public void saveTest() throws IOException {
		
		String path="configuration.xml";
		Reader reader=Resources.getResourceAsReader(path);
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=sessionFactory.openSession();
		//使用UserMapper接口进行对应的查询
		UserMapper userMapper=session.getMapper(UserMapper.class);
//		User user=userMapper.selectUser(1);
//		System.out.println(user.getName());
//		
		//INSERT语句
		User user1=new User();
		user1.setName("ccccc");
		user1.setPassword("111");
		user1.setType("ddd");
		userMapper.insetUser(user1);
		
//		//根据id删除User
//		userMapper.deleteUser(2);
		
//		//更新User
//		User userUpdate=new User();
//		userUpdate.setId(5);
//		userUpdate.setName("1111");
//		userUpdate.setPassword("111");
//		userUpdate.setType("111");
//		userMapper.updateUser(userUpdate);
		
//		List<User> users=userMapper.selectAllUser();
//		for (User user : users) {
//			System.out.println(user.getName());
//		}
		session.commit();
	}
	
	
}
