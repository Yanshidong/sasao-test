package com.wd7.sso;


import com.wd7.sso.dao.SysUserRepository;
import com.wd7.sso.entity.UserEntity;
import com.wd7.sso.support.MyUserDetailsService;
import lombok.Data;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import javax.transaction.Transactional;

@MapperScan("com.wd7.sso")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {


	@Autowired
	MyUserDetailsService myUserDetailsService;

	@Autowired
	SysUserRepository sysUserRepository;


	@Test
	public void contextLoads() {

	}

	@Test
	public void test1(){
		User user=new User(1,"san",99);
		System.out.println(user.toString());
	}

	@Test
	@Transactional
	public void JpaTest()
	{

		UserEntity userEntity=sysUserRepository.getOne(1);
//		Assert.assertNotNull(userEntity.getId());
		System.out.println(userEntity.toString());
	}

	@Test
	@Transactional
	public void JpaUpdatePassword()
	{
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		sysUserRepository.updatePasswordAll(bCryptPasswordEncoder.encode("a").toString());
	}


	@Before
	public void before()
	{
		//初始化数据库
		UserEntity user1=new UserEntity(1,"admin","123",true,true,true,true);
		UserEntity user2=new UserEntity(2,"testor","123",true,true,true,true);
		UserEntity user3=new UserEntity(3,"guest","123",true,true,true,true);
		UserEntity user4=new UserEntity(4,"我是谁","123",true,true,true,true);

		sysUserRepository.save(user1);
		sysUserRepository.save(user2);
		sysUserRepository.save(user3);
		sysUserRepository.save(user4);
	}

	@After
	public void after()
	{
//		sysUserRepository.deleteAll();
	}


}


