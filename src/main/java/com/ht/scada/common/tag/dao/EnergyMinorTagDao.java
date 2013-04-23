package com.ht.scada.common.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.entity.EnergyMinorTag;
import com.ht.scada.common.tag.entity.MajorTag;

public interface EnergyMinorTagDao extends JpaRepository<EnergyMinorTag, Integer> {
	
	public MajorTag findByName(String name);
	
	public List<EnergyMinorTag> findByParent(EnergyMinorTag parent);

}
