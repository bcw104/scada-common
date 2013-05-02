package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.AreaMinorTag;

public interface AreaMinorTagService extends BaseService<AreaMinorTag>{
	/**
	 * 获得根常规索引
	 * @return
	 */
	public List<AreaMinorTag> getRootAreaMinorTag();
	/**
	 * 通过父id获得所有末端节点
	 * @param name
	 * @return
	 */
	public List<AreaMinorTag> getAreaMinorTagsByParentId(Integer id);
}
