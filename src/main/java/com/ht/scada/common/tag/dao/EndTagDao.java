package com.ht.scada.common.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.entity.EndTag;
import com.ht.scada.common.tag.entity.MajorTag;

public interface EndTagDao extends JpaRepository<EndTag, Integer> {
	
	public List<EndTag> findByMajorTag(MajorTag majorTag);

}
