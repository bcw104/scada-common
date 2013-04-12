package com.ht.scada.common.data.service;

import java.util.Map;

/**
 * 实时数据库服务类<br>
 * 存储浮点型的数据时采用Double.doubleToLongBits(v)的方式<br>
 * 存储布尔型的数据时采用Boolean.toString(b)的方式<br>
 * @author 薄成文
 *
 */
public interface RealtimeDataService {

	void putValue(String code, String name, double value);

	void putValue(String code, String name, boolean value);

	boolean getBoolValue(String code, String name);

	double getNumValue(String code, String name);

	double[] getBatchNumValue(String code, String[] name);

	boolean[] getBatchBoolValue(String code, String[] name);

	void putBatchValue(String code, String[] name, boolean[] value);

	void putBatchValue(String code, String[] name, double[] value);

	void putBatchValue(String code, String[] name, String[] value);
	
	void putBatchValue(Map<String, String> kvMap);

}
