package com.ht.scada.common.tag.type.service;

import java.util.List;

import com.ht.scada.common.tag.type.VarGroupType;
import com.ht.scada.common.tag.type.VarSubType;
import com.ht.scada.common.tag.type.VarType;

/**
 * 系统初始配置相关接口
 * @author 赵磊
 *
 */
public interface TypeService {
	
	/**
	 * 增加变量分组类型
	 * @author 赵磊
	 */
	public void insertVarGroupType(VarGroupType varGroupType);
	
	/**
	 * 增加变量类型
	 * @author 赵磊
	 */
	public void insertVarType(VarType varType);
	
	/**
	 * 增加变量子类型
	 * @author 赵磊
	 */
	public void insertVarSubType(VarSubType varSubType);
	
	/**
	 * 增加变量分组类型
	 * @author 赵磊
	 */
	public void insertVarGroupTypeList(List<VarGroupType> varGroupTypeList);
	
	/**
	 * 增加变量类型
	 * @author 赵磊
	 */
	public void insertVarTypeList(List<VarType> varTypeList);
	
	/**
	 * 增加变量子类型
	 * @author 赵磊
	 */
	public void insertVarSubTypeList(List<VarSubType> varSubTypeList);
	

}
