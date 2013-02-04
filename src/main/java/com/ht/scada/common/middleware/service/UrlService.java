package com.ht.scada.common.middleware.service;

/**
 * URL地址获取接口
 * 
 * @author 薄成文
 *
 */
public interface UrlService {

	/**
	 * 获取油井工艺组态图url地址
	 * @param id 编号（井号，回路号等）
	 * @return
	 */
	String getSvgViewUrl(String id);
}
