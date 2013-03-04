package com.ht.scada.common.middleware.service;

import javax.jms.MessageListener;

/**
 * 消息中间件通讯服务调用接口, 控制器不需要直接调用该接口<br>
 * @author 薄成文
 * @author 赵磊
 */
public interface JmsService {

	/**
	 * 注册广播消息监听器<br>
	 * 用于监听报警信息等实时推送的广播消息
	 * @param topicPath
	 * @param listener
	 */
	void registTopicMessageListener(String topicPath, MessageListener listener);
	
}
