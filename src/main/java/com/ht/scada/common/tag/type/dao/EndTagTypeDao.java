package com.ht.scada.common.tag.type.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.type.entity.EndTagType;

public interface EndTagTypeDao extends JpaRepository<EndTagType, Integer> {
	public EndTagType findByName(String name);
	public EndTagType findByValue(String value);
}
