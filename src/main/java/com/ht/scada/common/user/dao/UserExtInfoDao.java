package com.ht.scada.common.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ht.scada.common.user.entity.UserExtInfo;


public interface UserExtInfoDao extends JpaRepository<UserExtInfo, Integer> {
	
	public UserExtInfo findByRealName(String realName);
}