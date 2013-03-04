package com.ht.user.test;

import java.util.Arrays;
import java.util.HashSet;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ht.scada.common.user.entity.User;
import com.ht.scada.common.user.entity.UserRole;
import com.ht.scada.common.user.security.ShiroDbRealm;
import com.ht.scada.common.user.service.UserService;

@ContextConfiguration(locations={"classpath:test-context.xml"})
public class UserTest extends AbstractTestNGSpringContextTests {

	@Inject
	private UserService userService;
	
	@Inject
	private ShiroDbRealm shiroDbRealm;
	
//	private DefaultWebSecurityManager securityManager;
	private DefaultSecurityManager securityManager;
	
	
	@BeforeClass
	public static void beforClass() throws Exception {
		
	}

	@Test
	public void baseTest() {
		securityManager = new DefaultSecurityManager(shiroDbRealm);
		
		SecurityUtils.setSecurityManager(securityManager);
		
		userService.createUser("admin", "admin");
		User user = userService.getUserByUsername("admin");
		assert user != null;
		
		userService.createUserRole("管理员", "系统管理员");
		UserRole role = userService.getUserRoleByName("管理员");
		assert role != null;
		role.setPermissions(new HashSet<>(Arrays.asList("user:*", "a:b")));
		userService.saveUserRole(role);
		
		user.setUserRole(role);
		userService.updateUser(user);
	}
	
	@Test(dependsOnMethods="baseTest", expectedExceptions=AuthenticationException.class)
	public void loginTest() {
		//1. 接受提交的当事人和证书：
		AuthenticationToken token = new UsernamePasswordToken("admin", "xxx");
		//2. 获取当前Subject：
		Subject currentUser = SecurityUtils.getSubject();
		//3. 登录： 
		currentUser.login(token);
	}
	
	@Test(dependsOnMethods="baseTest")
	public void permitTest() {
		//1. 接受提交的当事人和证书：
		AuthenticationToken token = new UsernamePasswordToken("admin", "admin");
		//2. 获取当前Subject：
		Subject currentUser = SecurityUtils.getSubject();
		//3. 登录： 
		currentUser.login(token);
		
		assert currentUser.hasRole("管理员");
		assert !currentUser.hasRole("nop");
		assert currentUser.isPermitted("user:*");
		assert currentUser.isPermitted("user:edit");
		assert currentUser.isPermitted("user:delete");
		assert currentUser.isPermitted("a:b");
		assert !currentUser.isPermitted("a:c");
		assert !currentUser.isPermitted("nop:delete");
	}
	
}
