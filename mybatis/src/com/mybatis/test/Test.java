package com.mybatis.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import com.model.User;
import com.mybatis.db.DbAccess;

public class Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void test() throws IOException, SQLException {
		DbAccess dbAccess=new DbAccess();
		SqlSession sqlSession=dbAccess.getSqlSession();
		
		System.out.println("insert result:"+sqlSession.insert("insertUser"));
		System.out.println("++++++++++++++++++++++++");
		System.out.println();
		System.out.println();
		
		System.out.println("=====查询所有User======");
		List<User> users=sqlSession.selectList("selectAll");
		for (User user : users) {
			System.out.println(user);
			System.out.println("==============");
		}
		
		sqlSession.close();
		
	}

}
