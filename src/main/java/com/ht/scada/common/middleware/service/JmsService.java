package com.ht.scada.common.middleware.service;

import java.util.List;

import javax.jms.MessageListener;
import javax.naming.NamingException;

import com.ht.scada.common.tag.entity.WellData;

/**
 * 消息中间件通讯服务调用接口
 * 
 * @author 薄成文
 * @author 赵磊
 */
public interface JmsService {
	
	/**
	 * 获取最新的报警信息 
	 * TODO: 报警信息格式待定
	 * @param area
	 * @return
	 */
	List<String> getLatestAlarmInfo(String area) throws Exception;
	
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
	
	void addAlarmMessageListener(MessageListener listener) throws Exception;
}
