package com.ht.scada.common.tag.type.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ht.scada.common.tag.type.entity.EndTagExtInfoName;

public interface EndTagExtInfoNameDao extends JpaRepository<EndTagExtInfoName, Integer> {
	/**
	 * 通过末端节点类型英文名获得属性名
	 * @param endTagName
	 * @return
	 * @author 赵磊
	 */
	@Query("select e from EndTagExtInfoName e where e.endTagType.name = ?1")
	public List<EndTagExtInfoName> findByEndTagName(String endTagName);
	
	/**
	 * 通过末端节点类型中文名获得属性名
	 * @param endTagValue
	 * @return
	 * @author 赵磊
	 */
	@Query("select e from EndTagExtInfoName e where e.endTagType.value = ?1")
	public List<EndTagExtInfoName> findByEndTagValue(String endTagValue);

}
