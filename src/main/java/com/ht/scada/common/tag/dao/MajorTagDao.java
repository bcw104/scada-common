package com.ht.scada.common.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.entity.MajorTag;

public interface MajorTagDao extends JpaRepository<MajorTag, Integer>{
	
	public MajorTag findByName(String name);
	
	public List<MajorTag> findByParent(MajorTag parent);

}
