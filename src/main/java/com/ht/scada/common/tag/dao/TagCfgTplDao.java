package com.ht.scada.common.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ht.scada.common.tag.entity.TagCfgTpl;

public interface TagCfgTplDao extends JpaRepository<TagCfgTpl, Integer>{
	
	/**
	 * 查找不同的模板
	 * @return
	 */
	@Query("select distinct t.tplName from TagCfgTpl t")
	public List<String> findDistinctByTplName();

}
