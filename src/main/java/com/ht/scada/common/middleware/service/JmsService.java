package com.ht.scada.common.middleware.service;

import java.util.List;

import javax.jms.MessageListener;
import javax.naming.NamingException;

/**
 * 消息中间件通讯服务调用接口
 * 
 * @author 薄成文
 *
 */
public interface JmsService {
	
	/**
	 * 获取最新的报警信息 
	 * TODO: 报警信息格式待定
	 * @param area
	 * @return
	 */
	List<String> getLatestAlarmInfo(String area) throws Exception;
	
	void addAlarmMessageListener(MessageListener listener) throws Exception;
}
