package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.VarGroupCfg;

/**
 * 变量分组
 * 
 * @author 陈志强
 * 
 */
public interface VarGroupCfgService extends BaseService<VarGroupCfg> {

	/**
	 * 获取所有的变量组配置信息
	 * 
	 * @return
	 */
	List<VarGroupCfg> getAllVarGroupCfg();
}
