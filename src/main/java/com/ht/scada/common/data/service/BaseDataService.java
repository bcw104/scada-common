package com.ht.scada.common.data.service;

import java.util.Map;


public interface BaseDataService {
	
	/**
	 * 根据编号获取工况最新的实时数据（设备通讯状态变量会自动过滤）
	 * @param code
	 * @return
	 */
	Map<String, Object> getRealTimeData(String code);
}
