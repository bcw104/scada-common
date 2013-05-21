package com.ht.scada.common.tag.type.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ht.scada.common.tag.type.EndTagExtInfoValue;

public interface EndTagExtInfoValueDao extends JpaRepository<EndTagExtInfoValue, Integer> {
	/**
	 * 通过属性英文名获得属性值
	 * @param extName
	 * @return
	 */
	@Query("select e from EndTagExtInfoValue e where e.endTagExtInfoName.name = ?1")
	public List<EndTagExtInfoValue> findByExtName(String extName);
	
	/**
	 * 通过属性中文名获得属性值
	 * @param extName
	 * @return
	 */
	@Query("select e from EndTagExtInfoValue e where e.endTagExtInfoName.value = ?1")
	public List<EndTagExtInfoValue> findByExtValue(String extValue);

}
