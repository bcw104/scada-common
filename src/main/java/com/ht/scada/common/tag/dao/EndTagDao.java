package com.ht.scada.common.tag.dao;

import com.ht.scada.common.tag.entity.EndTag;
import com.ht.scada.common.tag.entity.MajorTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EndTagDao extends JpaRepository<EndTag, Integer> {
	
	public List<EndTag> findByMajorTag(MajorTag majorTag);
    public List<EndTag> findByChannelIdxNotNullAndDeviceAddrNotNull();
    public EndTag findByCode(String code);
}
