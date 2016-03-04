package com.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.caicf.model.User;

public class UserTest{

	@Test
	public void saveTest() throws IOException {
		
		String path="configuration.xml";
		Reader reader=Resources.getResourceAsReader(path);
		
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=sessionFactory.openSession();
		String statement = "com.caicf.model.UserMapper.selectUserByID";
		User user=(User)session.selectOne(statement, 1);
		System.out.println(user.getName());
	}
	
}
