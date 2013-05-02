package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.TagCfgTpl;

public interface TagCfgTplService extends BaseService<TagCfgTpl> {
	/**
	 * 找出所有的变量模板名
	 * @author 赵磊
	 * @return
	 */
	public List<String> findAllTplName();

}