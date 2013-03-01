package com.ht.scada.common.user.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.user.dao.UserDao;
import com.ht.scada.common.user.dao.UserExtInfoDao;
import com.ht.scada.common.user.dao.UserRoleDao;
import com.ht.scada.common.user.entity.User;
import com.ht.scada.common.user.entity.UserExtInfo;
import com.ht.scada.common.user.entity.UserRole;
import com.ht.scada.common.user.security.ShiroDbRealm.ShiroUser;
import com.ht.scada.common.user.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDao userDao;
	
	@Inject
	private UserRoleDao userRoleDao;

	@Inject
	private UserExtInfoDao userExtInfoDao;
	@Override
	public User getCurrentUser() {
		//final Integer currentUserId = (Integer) SecurityUtils.getSubject().getPrincipal();
		final ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		
        if( shiroUser != null ) {
            return getUserByUsername(shiroUser.userame);
        } else {
            return null;
        }
	}

	@Override
	public void createUser(String username, String password) {
		User user = new User();
        user.setUsername(username);
        user.setPassword( new Sha256Hash(password).toHex() );
        userDao.save(user);
	}
	
	@Override
	public void addNewUser(User newUser) {
		userDao.save(newUser);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUser(int userId) {
		return userDao.findOne(userId);
	}
	
	@Override
	public User getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void deleteUser(int userId) {
		userDao.delete(userId);
	}

	@Override
	public void updateUser(User user) {
		userDao.save(user);
	}

	@Override
	public void createUserRole(String name, String description) {
		UserRole role = new UserRole();
		role.setName(name);
		role.setDescription(description);
		userRoleDao.save(role);
	}
	
	@Override
	public void updateUserRole(UserRole userRole) {
		userRoleDao.save(userRole);
	}
	
	@Override
	public UserRole getUserRoleByName(String name) {
		return userRoleDao.findByName(name);
	}
	@Override
	public void updateUserPassword(String password, int id){
		userDao.updateUserPassword(password, id);
	}
	@Override
	public List<UserExtInfo> getAllUserExtInfo() {
		
		return userExtInfoDao.findAll();
	}
        @Override
        public List<UserRole> getAllUserRole(){
            return userRoleDao.findAll();
        }
        @Override
        public void  saveUserExtInfo(UserExtInfo newUser) {
		userExtInfoDao.save(newUser);
	}
        @Override
        public UserRole getUserRoleById(int id){
            return userRoleDao.findOne(id);
        }
        @Override
        public UserExtInfo findByUserID(int id){
            return userExtInfoDao.findByUserID(id);
        }
}
