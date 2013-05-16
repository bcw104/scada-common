package com.ht.scada.oildata.service.service;

/**
 * URL地址获取接口
 * 
 * @author 薄成文
 *
 */
public interface UrlService {

    public static final String COMM_URL_KEY = "url.comm";
    public static final String COMM_YK_URL_KEY = "url.comm.yk";
    public static final String COMM_YT_URL_KEY = "url.comm.yt";
    public static final String SVG_URL_KEY = "url.svg";

	/**
	 * 获取油井工艺组态图url地址
	 * @param code 编号（井号，回路号等其它编号）
	 * @return
	 */
	String getSvgViewUrl(String code);

}
