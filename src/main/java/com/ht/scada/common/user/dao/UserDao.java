package com.ht.scada.common.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ht.scada.common.user.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);
	
	public List<User> findByName(String user);
	
	@Modifying
	@Query("update User u set u.password = ?1 where u.id = ?2")
	public void updateUserPassword(String password, int id);
}
