package com.test;

import java.io.IOException;
import java.io.Reader;

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
		User user=userMapper.selectUser(1);
		session.commit();
		System.out.println(user.getName());
	}
	
}
