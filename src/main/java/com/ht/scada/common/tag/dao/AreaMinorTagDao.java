package com.ht.scada.common.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.entity.AreaMinorTag;

public interface AreaMinorTagDao extends JpaRepository<AreaMinorTag, Integer> {
	public AreaMinorTag findByName(String name);
	
	public List<AreaMinorTag> findByParent(AreaMinorTag parent);

}
