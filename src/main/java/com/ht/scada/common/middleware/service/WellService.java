package com.ht.scada.common.middleware.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.ht.scada.common.well.WellData;
import com.ht.scada.common.well.WellStatus;

public interface WellService {
	
	/**
	 * 保存油井示功图数据
	 * @param code 油井编号
	 * @param zaihe
	 * @param weiyi
	 * @param chongcheng
	 * @param chongci
	 */
	void saveWellSGTData(String code, float[] zaihe, float[] weiyi, float chongcheng, float chongci);
	
	/**
	 * 通过井号和时间获得历史的油井示功图及相关信息
	 * @param wellNum
	 * @param datetime 日期时间，精确到小时
	 * @return
	 * @throws Exception
	 * @author 赵磊
	 */
	WellData getWellDataByWellNumAndDatetime(String wellNum, Date datetime) throws Exception;
	
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
	
	/**
	 * 通过油井编号和日期计算产液量
	 * @param code
	 * @param date
	 * @return
	 */
	double getDailyOilProduct(String code, Date date);
	
	/**
	 * 获取启停井状态
	 * @param codes 油井编号集合
	 * @return
	 */
	List<WellStatus> getWellStatus(Collection<String> codes);
	
}
