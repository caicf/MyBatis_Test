package com.test;

import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.caicf.model.User;
import com.caicf.model.mapper.UserMapper;

public class UserTest{

	private String path;
	private Reader reader;
	private SqlSessionFactory sessionFactory;
	private SqlSession session;
	private UserMapper userMapper;
	
	@Before
	public void before() throws Exception {
		path="configuration.xml";
		reader=Resources.getResourceAsReader(path);
		sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		session=sessionFactory.openSession();
		//使用UserMapper接口进行对应的查询
		userMapper=session.getMapper(UserMapper.class);
	}
	
	/**
	 * 动态SQL查询,where，set
	 */
	@Test
	public void whereSetTrim() {
		
		//查询用户，where标签
//		User user1=new User();
//		user1.setName("hj%");
//		user1.setId(83);
//		List<User> users=userMapper.selectPartUserWhere(user1);
//		for (User u: users) {
//			System.out.println(u.getId()+":"+u.getName()+":"+u.getPassword()+":"+u.getType());
//		}
		
		//更新用户，set标签
		User user2=new User();
		user2.setId(83);
		user2.setPassword("123456");
		int result = userMapper.updateUserSet(user2);
		System.out.println(result);
	}
	
	/**
	 * 动态SQL查询,if,choose,when,otherwise
	 */
	@Test
	public void dynamicalSQL() {
//		//根据条件，查询部分User,if标签
//		User user=new User();
//		user.setId(82);
//		List<User> users=userMapper.selectPartUser(user);
//		for (User u: users) {
//			System.out.println(u.getId()+":"+u.getName()+":"+u.getPassword()+":"+u.getType());
//		}
		
		//choose标签
		User user1=new User();
		user1.setName("hj%");
		user1.setType("aaa");
		List<User> users=userMapper.selectPartUserChoose(user1);
		for (User u: users) {
			System.out.println(u.getId()+":"+u.getName()+":"+u.getPassword()+":"+u.getType());
		}
		
	}
	
	/**
	 * 基本的CURD
	 */
	@Test
	public void curdTest() {
		//根据id查询用户
//		User user=userMapper.selectUser(1);
//		System.out.println(user.getName());
		
//		//INSERT语句
//		User user1=new User();
//		user1.setName("ccccc");
//		user1.setPassword("111");
//		user1.setType("ddd");
//		userMapper.insetUser(user1);
		
//		//根据id删除User
//		userMapper.deleteUser(2);
		
//		//更新User
//		User userUpdate=new User();
//		userUpdate.setId(5);
//		userUpdate.setName("1111");
//		userUpdate.setPassword("111");
//		userUpdate.setType("111");
//		userMapper.updateUser(userUpdate);
		
//		//查询所有User
//		List<User> users=userMapper.selectAllUser();
//		for (User user : users) {
//			System.out.println(user.getId()+":"+user.getName()+":"+user.getPassword()+":"+user.getType());
//		}
	}
	
	@After
	public void after() {
		session.commit();
	}
	
}
