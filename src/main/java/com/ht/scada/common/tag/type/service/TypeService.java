package com.ht.scada.common.tag.type.service;

import java.util.List;

import com.ht.scada.common.tag.entity.VarGroupCfg;
import com.ht.scada.common.tag.type.entity.EndTagExtInfoName;
import com.ht.scada.common.tag.type.entity.EndTagExtInfoValue;
import com.ht.scada.common.tag.type.entity.EndTagSubType;
import com.ht.scada.common.tag.type.entity.EndTagType;
import com.ht.scada.common.tag.type.entity.MajorTagType;
import com.ht.scada.common.tag.type.entity.VarSubType;
import com.ht.scada.common.tag.type.entity.VarType;

/**
 * 系统初始配置相关接口
 * @author 赵磊
 *
 */
public interface TypeService {
	/**
	 * 增加主索引类型
	 * @author 赵磊
	 * @param majorTagType
	 */
	public void insertMajorTagType(MajorTagType majorTagType);
	/**
	 * 增加主索引类型
	 * @author 赵磊
	 * @param majorTagType
	 */
	public void insertMajorTagType(List<MajorTagType> majorTagTypeList);
	
	/**
	 * 增加末端节点类型
	 * @param endTaType
	 */
	public void insertEndTagType(EndTagType endTagType);
	
	/**
	 * 增加末端节点类型
	 * @param endTaType
	 */
	public void insertEndTagType(List<EndTagType> endTagTypeList);
	/**
	 * 增加末端节点子类型
	 * @param endTagSubType
	 */
	public void insertEndTagSubType(EndTagSubType endTagSubType);
	/**
	 * 增加末端节点子类型
	 * @param endTagSubType
	 */
	public void insertEndTagSubType(List<EndTagSubType> endTagSubTypeList);
	/**
	 * 增加变量分组类型
	 * @author 赵磊
	 */
	public void insertVarGroupCgf(VarGroupCfg varGroupCfg);
	
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
	public void insertVarGroupCfg(List<VarGroupCfg> varGroupCfgList);
	
	/**
	 * 增加变量类型
	 * @author 赵磊
	 */
	public void insertVarType(List<VarType> varTypeList);
	
	/**
	 * 增加变量子类型
	 * @author 赵磊
	 */
	public void insertVarSubType(List<VarSubType> varSubTypeList);
	
	/**
	 * 增加末端节点扩展属性名
	 * @author 赵磊
	 */
	public void insertEndTagExtInfoName(List<EndTagExtInfoName> endTagExtInfoNameList);
	/**
	 * 增加末端节点扩展属性值
	 * @author 赵磊
	 */
	public void insertEndTagExtInfoValue(List<EndTagExtInfoValue> endTagExtInfoValueList);
	
	/**
	 * 删除所有类型
	 * @author 赵磊
	 */
	public void deleteAllType();
	
	public List<VarGroupCfg> getAllVarGroupCfg();
	public List<VarType> getAllVarType();
	public List<MajorTagType> getAllMajorTagType();
	public List<EndTagType> getAllEndTagType();
	public List<VarSubType> getAllVarSubType();
	
	
	public List<EndTagSubType> getSubTypeByEndTagTypeName(String name);
	public List<EndTagSubType> getSubTypeByEndTagTypeValue(String value);
	
	public List<VarSubType> getVarSubTypeByGroupName(String groupName);
	public List<VarSubType> getVarSubTypeByGroupValue(String groupValue);
	public List<VarSubType> getVarSubTypeByVarTypeName(String varTypeName);
	public List<VarSubType> getVarSubTypeByVarTypeValue(String varTypeValue);
	
	public List<EndTagExtInfoName> getExtInfoNamesByEndTagName(String endTagTypeName);
	public List<EndTagExtInfoName> getExtInfoNamesByEndTagValue(String endTagTypeNValue);
	
	public List<EndTagExtInfoValue> getExtInfoValuesByInfoName(String infoName);
	public List<EndTagExtInfoValue> getExtInfoValuesByInfoValue(String infoValue);

}
