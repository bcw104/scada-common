package com.ht.scada.common.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ht.scada.common.tag.entity.EndTagExtInfo;
/**
 * 
 * @author 陈志强
 * 
 */
public interface EndTagExtInfoDao extends JpaRepository<EndTagExtInfo, Integer> {
	/**
	 * 根据单井、回路等末端节点id获取末端节点扩展信息
	 * @return
	 */
	@Query("select e from EndTagExtInfo e where e.endTag.id = ?1")
	public List<EndTagExtInfo> getByEndTagId(int endTagId);
}
