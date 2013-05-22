package com.ht.scada.common.tag.type.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ht.scada.common.tag.type.entity.EndTagSubType;

public interface EndTagSubTypeDao extends JpaRepository<EndTagSubType, Integer> {
	@Query("select e from EndTagSubType e where e.endTagType.name = ?1")
	public List<EndTagSubType> findByEndTagTypeName(String endTagTypeName);
	
	@Query("select e from EndTagSubType e where e.endTagType.value = ?1")
	public List<EndTagSubType> findByEndTagTypeValue(String endTagTypeValue);
}
