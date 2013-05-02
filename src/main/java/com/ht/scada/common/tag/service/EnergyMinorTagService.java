package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.EnergyMinorTag;

public interface EnergyMinorTagService extends BaseService<EnergyMinorTag> {
	/***
	 * 根据父id获得能耗分类
	 * 
	 * @param id
	 * @return
	 */
	List<EnergyMinorTag> getEnergyMinorTagsByParentId(int parentId);

	/**
	 * 获得根能耗
	 * 
	 * @return
	 */
	List<EnergyMinorTag> getRootEnergyMinorTag();

}
