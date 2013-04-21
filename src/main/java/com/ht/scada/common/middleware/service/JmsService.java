package com.ht.scada.common.middleware.service;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

/**
 * 消息中间件通讯服务调用接口, 控制器不需要直接调用该接口<br>
 * <pre>
 * Topic:/topic/[末端编号] 用于实现变化数据推送.<br>
 * Queue:/queue/[末端编号] 用于实时数据存储,遥调设定,遥控.<br>
 * 读取实时数据时必须通过QueueBrowse读取，避免数据接收后被自动删除.<br>
 * 采集程序通过监听对应的遥控和遥调队列执行遥调和遥控操作时r
 * </pre>
 * @author 薄成文
 * @author 赵磊
 */
public interface JmsService {
	
	/**
	 * 队列实时数据变量属性名, 对应的值为变量名, 该名称为HornetQ指定，请不要修改
	 */
	public static final String LVQ_NAME = "_HQ_LVQ_NAME";
	
	/**
	 * 变化数据推送频道名称
	 */
	public static final String TOPIC_CHANGED_DATA_NAME = "changedData";
	
	/**
	 * 变化数据推送消息末端编码属性名
	 */
	public static final String MSG_CHANGED_DATA_CODE = "code";

	/**
	 * 注册广播消息监听器<br>
	 * 用于监听报警信息等实时推送的广播消息
	 * @param topicPath
	 * @param listener
	 */
	void registTopicMessageListener(String topicPath, MessageListener listener);
	
	String test(String a);
	
	Session createSession() throws JMSException;
	
	Queue getQueue(String queueName) throws Exception;
	Topic getTopic(String topicName) throws Exception;
}
