package com.ht.scada.common.middleware.service.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.ht.scada.common.middleware.service.JmsService;
import com.ht.scada.common.middleware.service.RTUService;

@Service("rtuService")
public class RTUServiceImpl implements RTUService {
	@Inject
	private JmsService jmsService;

	@Override
	public boolean yk(String code, String varName, boolean status) throws Exception {
		boolean ret = false;
		
		Queue requestQueue = jmsService.getQueue(code);
		
		final Session session = jmsService.createSession();
		
		// 创建临时队列用于接收响应
		TemporaryQueue replyQueue = session.createTemporaryQueue();
		
		// 发送操作请
		Message requestMsg = session.createMessage();
		requestMsg.setStringProperty("varName", varName);
		requestMsg.setBooleanProperty("value", status);
		requestMsg.setLongProperty(RTUService.TIME_MILLIS, System.currentTimeMillis() + 5000);
        requestMsg.setJMSReplyTo(replyQueue);
        MessageProducer producer = session.createProducer(requestQueue);
        producer.send(requestMsg);
        
        // 接收遥控响应
		MessageConsumer replyConsumer = session.createConsumer(replyQueue);
        Message replyMessageReceived = replyConsumer.receive(5000);// 超时时间5秒
        if (replyMessageReceived != null) {
        	ret = replyMessageReceived.getBooleanProperty(RTUService.OP_REPLY_KEY);
        }
        //System.out.println("CorrelatedId: " + replyMessageReceived.getJMSCorrelationID());
        replyQueue.delete();
        
		return ret;
	}

	@Override
	public boolean yt(String code, String varName, double value) throws Exception {
		boolean ret = false;
		
		Queue requestQueue = jmsService.getQueue(code);
		
		final Session session = jmsService.createSession();
		
		// 创建临时队列用于接收响应
		TemporaryQueue replyQueue = session.createTemporaryQueue();
		
		// 发送操作请
		Message requestMsg = session.createMessage();
		requestMsg.setStringProperty("varName", varName);
		requestMsg.setDoubleProperty("value", value);
		requestMsg.setLongProperty(RTUService.TIME_MILLIS, System.currentTimeMillis() + 5000);        requestMsg.setJMSReplyTo(replyQueue);
        MessageProducer producer = session.createProducer(requestQueue);
        producer.send(requestMsg);
        
        // 接收遥控响应
		MessageConsumer replyConsumer = session.createConsumer(replyQueue);
        Message replyMessageReceived = replyConsumer.receive(5000);// 超时时间5秒
        if (replyMessageReceived != null) {
        	ret = replyMessageReceived.getBooleanProperty(RTUService.OP_REPLY_KEY);
        }
        //System.out.println("CorrelatedId: " + replyMessageReceived.getJMSCorrelationID());
        replyQueue.delete();
        
		return ret;
	}

}
