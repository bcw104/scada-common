package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.MajorTag;
import com.ht.scada.common.tag.entity.TagCfgTpl;

/**
 * 提供标签配置信息查询服务
 * 
 * @author 薄成文
 * @author 赵磊
 *
 */
public interface TagService {
	
	/**
	 * 通过主键查询主标签节点
	 * @param id
	 * @return
	 */
	public MajorTag getMajorTag(int id);
	
	/**
	 * @param id
	 * @return
	 */
	public String getTagTplNameByMajorTagID(int id);
	
	/**
	 * 根据变量词典模板名称获取变量词典
	 * @param name
	 * @return
	 */
	public List<TagCfgTpl> getTagTplByName(String name);
}
