package com.ht.scada.common.middleware.service;

import com.ht.scada.common.tag.entity.WellData;

public interface WellDataService {
	
	/**
	 * 通过井号获得最新的油井示功图及相关信息
	 * @param wellNum
	 * @return
	 * @throws Exception
	 * @author 赵磊
	 */
	WellData getLatestWellDataByWellNum(String wellNum) throws Exception;
	
	/**
	 * 通过井号获取油井最新的产液量
	 * @param wellNum
	 * @return
	 * @throws Exception
	 * @author 赵磊
	 */
	String getLatestProductByWellNum(String wellNum) throws Exception;
	
	/**
	 * 通过井号获取油井最新的故障诊断信息，故障信息内容格式待定
	 * @param wellNum
	 * @return
	 * @throws Exception
	 * @author 赵磊
	 */
	String getLatestWellFaultByWellNum(String wellNum) throws Exception;
}
