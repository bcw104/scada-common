package com.ht.scada.common.tag.type.service;

import java.util.List;

import com.ht.scada.common.tag.type.EndTagExtInfoName;
import com.ht.scada.common.tag.type.EndTagExtInfoValue;
import com.ht.scada.common.tag.type.EndTagSubType;
import com.ht.scada.common.tag.type.EndTagType;
import com.ht.scada.common.tag.type.MajorTagType;
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
	
	public List<VarGroupType> getAllVarGroupType();
	public List<VarType> getAllVarType();
	public List<MajorTagType> getAllMajorTagType();
	public List<EndTagType> getAllEndTagType();
	public List<EndTagSubType> getSubTypeByEndTagTypeName(String name);
	public List<EndTagSubType> getSubTypeByEndTagTypeValue(String value);
	
	public List<VarSubType> getAllVarSubType();
	public List<VarSubType> getVarSubTypeByGroupName(String groupName);
	public List<VarSubType> getVarSubTypeByGroupValue(String groupValue);
	public List<VarSubType> getVarSubTypeByVarTypeName(String varTypeName);
	public List<VarSubType> getVarSubTypeByVarTypeValue(String varTypeValue);
	
	public List<EndTagExtInfoName> getExtInfoNamesByEndTagName(String endTagTypeName);
	public List<EndTagExtInfoName> getExtInfoNamesByEndTagValue(String endTagTypeNValue);
	
	public List<EndTagExtInfoValue> getExtInfoValuesByInfoName(String infoName);
	public List<EndTagExtInfoValue> getExtInfoValuesByInfoValue(String infoValue);

}
