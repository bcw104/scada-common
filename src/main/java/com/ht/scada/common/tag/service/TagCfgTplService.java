package com.ht.scada.common.tag.service;

import com.ht.scada.common.tag.entity.TagCfgTpl;

import java.util.List;

public interface TagCfgTplService extends BaseService<TagCfgTpl> {
	/**
	 * 找出所有的变量模板名
	 * @author 赵磊
	 * @return
	 */
	public List<String> findAllTplName();


    /**
     * 用于采集程序解析
     * @author 薄成文
     * @return
     */
    List<TagCfgTpl> getAllTagTpl();

    /**
     * 根据模板名和变量名获取单个变量
     * @param tplName 模板名称
     * @param varName 变量名称
     * @return
     */
    Integer getDataIDByVarName(String tplName, String varName);
}
