package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.MajorTag;

public interface MajorTagService extends BaseService<MajorTag>{
	/**
	 * 获取所有子节点
	 * 
	 * @param id
	 * @return
	 */
	public List<MajorTag> getMajorTagsByParentId(int id);
	
	/**
	 * 获得根主索引
	 * 
	 * @return
	 */
	public List<MajorTag> getRootMajorTag();
void create(MajorTag domain);

    void deleteById(int id);

    MajorTag getById(int id);

    void update(MajorTag domain);
}
