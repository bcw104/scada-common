package com.ht.scada.common.user.service;

import java.util.List;

import com.ht.scada.common.user.entity.User;
import com.ht.scada.common.user.entity.UserRole;

public interface UserService {
	User getCurrentUser();

	void createUser(String username, String password);
	
	void addNewUser(User newUser);

	List<User> getAllUsers();

	User getUser(int userId);

	User getUserByUsername(String username);

	void deleteUser(int userId);

	void updateUser(User user);
	
	void createUserRole(String name, String description);
	
	void updateUserRole(UserRole userRole);
	
	UserRole getUserRoleByName(String name);
    
	void updateUserPassword(String password, int id);
}
