package com.ht.scada.common.tag.service;

import com.ht.scada.common.tag.entity.EndTag;

import java.util.List;

public interface EndTagService extends BaseService<EndTag>{
	
	/**
	 * 通过id获得所有末端节点
	 * 
	 * @param id
	 * @return
	 */
	public List<EndTag> getEndTagByParentId(int id);

    List<EndTag> getEndTag4Comm();

    EndTag getByCode(String code);
}
