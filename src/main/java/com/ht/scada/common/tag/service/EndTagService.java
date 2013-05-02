package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.EndTag;

public interface EndTagService extends BaseService<EndTag>{
	
	/**
	 * 通过id获得所有末端节点
	 * 
	 * @param id
	 * @return
	 */
	public List<EndTag> getEndTagByParentId(int id);

}
