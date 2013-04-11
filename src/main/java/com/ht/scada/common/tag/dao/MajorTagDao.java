package com.ht.scada.common.tag.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.entity.MajorTag;

public interface MajorTagDao extends JpaRepository<MajorTag, Integer>{

}
