package com.ht.scada.common.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.user.entity.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer> {
	
	public UserRole findByName(String name);
}
