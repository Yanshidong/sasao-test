package com.cjs.example;

import com.cjs.example.dao.SysPermissionMapper;
import com.cjs.example.dao.SysRoleMapper;
import com.cjs.example.dao.SysUserMapper;
import com.cjs.example.entity.SysPermission;
import com.cjs.example.entity.SysRole;
import com.cjs.example.entity.SysUser;
import com.cjs.example.entity.SysUserQuery;
import com.cjs.example.service.SysUserService;
import com.cjs.example.service.impl.SysUserServiceImpl;
import com.cjs.example.support.MyUserDetailsService;
import org.apache.ibatis.session.RowBounds;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@MapperScan("com.cjs.example")
@RunWith(SpringRunner.class)
@SpringBootTest
public class CjsOauth2CodeServerApplicationTests {

	@Autowired
	SysUserServiceImpl sysUserService;

	@Autowired
	SysUserMapper sysUserMapper;

	@Autowired
	SysRoleMapper sysRoleMapper;

	@Autowired
	SysPermissionMapper sysPermissionMapper;

	@Autowired
	MyUserDetailsService myUserDetailsService;



	@Test
	public void contextLoads() {
	}


	@Test
	public void BCrypPasswordEncodeTest()
	{
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		println(bCryptPasswordEncoder.encode("secret"));


	}

	@Test
	public void testMybatis()
	{
		SysUserQuery sysUserExample=new SysUserQuery();
		sysUserExample.createCriteria().andIdIsNotNull();
		RowBounds rowBounds=new RowBounds(10,3);
		SysUser sysUser=sysUserMapper.selectByPrimaryKey(1);
		println(sysUser.toString());

	}

	@Test
	public void testSelectRoleListByUid()
	{
		List<SysRole> listRoles=sysRoleMapper.selectByUid(1);
		println(listRoles.toString());
	}

	@Test
	public void testselectByRoleid()
	{
		List<SysPermission> listpermissions=sysPermissionMapper.selectByRoleid(1);
		Assert.assertNotNull(listpermissions);
		println(listpermissions.toString());
	}


	private void println(String a)
	{
		System.out.println(a);
	}
	private void println(int a)
	{
		System.out.println(a);
	}

	@Test
	public void testFindUserByUserName()
	{
		SysUser aa=sysUserService.findUserByUsername("1234");
		Assert.assertNotNull(aa);
		println(aa.toString());
	}
	@Test
	public void testFindUserAuthorityByUserName()
	{
		UserDetails aa=myUserDetailsService.loadUserByUsername("admin");
		Assert.assertNotNull(aa);
		println(aa.toString());
	}

	@Test
	public void getPassword()
	{
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		String pwd=bCryptPasswordEncoder.encode("a");
		println(pwd);
	}



}
