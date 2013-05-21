package com.ht.scada.common.tag.type.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ht.scada.common.tag.type.VarSubType;

public interface VarSubTypeDao extends JpaRepository<VarSubType, Integer> {
	
	/**
	 * 通过变量类型英文名获得变量子类型
	 * @author 赵磊
	 * @param varTypeName
	 * @return
	 */
	@Query("select v from VarSubType v where v.varType.name = ?1")
	public List<VarSubType> findByVarTypeName(String varTypeName);
	
	/**
	 * 通过变量类型中文名获得变量子类型
	 * @author 赵磊
	 * @param varTypeName
	 * @return
	 */
	@Query("select v from VarSubType v where v.varType.value = ?1")
	public List<VarSubType> findByVarTypeValue(String varTypeValue);
	
	/**
	 * 通过变量分组英文名获得变量子类型
	 * @author 赵磊
	 * @param varTypeName
	 * @return
	 */
	@Query("select v from VarSubType v where v.varGroupCfg.name = ?1")
	public List<VarSubType> findByVarGroupName(String varGroupName);
	
	/**
	 * 通过变量分组中文名获得变量子类型
	 * @author 赵磊
	 * @param varTypeName
	 * @return
	 */
	@Query("select v from VarSubType v where v.varGroupCfg.value = ?1")
	public List<VarSubType> findByVarGroupValue(String varGroupValue);

}
