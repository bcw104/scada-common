package com.ht.scada.common.middleware.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JmsServiceImplTest {

	private JmsServiceImpl jmsService;

	@BeforeTest
	private void beforTest() throws Exception {
		jmsService = new JmsServiceImpl();
		jmsService.initJndiJms();
	}

	@Test(dependsOnMethods="getQueue")
	public void createSession() throws Exception {
		Session session = jmsService.createSession();
		assert session != null;
		
		Topic topic = jmsService.getTopic("testTopic");
		
		MessageConsumer messageConsumer = session.createConsumer(topic);
		messageConsumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				try {
					System.out.println("m1:" + ((TextMessage)message).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		messageConsumer = session.createConsumer(topic, "_HQ_LVQ_NAME='real_time_data1'");
		messageConsumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				try {
					System.out.println("m2:" + ((TextMessage)message).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
		
		session = jmsService.createSession();
		assert session != null;
		
		//Queue queue = jmsService.getQueue("testQueue");
		MessageProducer producer = session.createProducer(topic);
		
		TextMessage message = session.createTextMessage("第1个设置了Last-Value属性的消息");
		message.setStringProperty("_HQ_LVQ_NAME", "real_time_data1");
		producer.send(message);
		
		message = session.createTextMessage("第2个设置了Last-Value属性的消息");
		message.setStringProperty("_HQ_LVQ_NAME", "real_time_data2");
		producer.send(message);
		
		message = session.createTextMessage("第3个设置了Last-Value属性的消息");
		message.setStringProperty("_HQ_LVQ_NAME", "real_time_data3");
		producer.send(message);
		
		message = session.createTextMessage("第4个设置了Last-Value属性的消息");
		message.setStringProperty("_HQ_LVQ_NAME", "real_time_data1");
		producer.send(message);
		
		
		
		messageConsumer = session.createConsumer(topic);
//		TextMessage message2 = (TextMessage)messageConsumer.receive();
//		System.out.println(message2.getText());// 第一个实时消息
//		
//		message2 = (TextMessage)messageConsumer.receive();
//		System.out.println(message2.getText());// 第二个实时消息
//		
		TextMessage messageReceived = (TextMessage) messageConsumer.receive(1000);
		assert messageReceived == null;
	}

	@Test
	public void getQueue() throws Exception {
		Queue queue = jmsService.getQueue("testQueue");
		assert queue != null;
		assert queue.getQueueName().equals("testQueue");
		
		Session session = jmsService.createSession();
		assert session != null;
		
	}
	
	@Test
	public void requestTest() throws Exception  {
		Queue requestQueue = jmsService.getQueue("testQueue");
		assert requestQueue != null;
		assert requestQueue.getQueueName().equals("testQueue");
		
		final Session session = jmsService.createSession();
		assert session != null;
		
		
		
		MessageConsumer messageConsumer = session.createConsumer(requestQueue);
		final MessageProducer replyProducer = session.createProducer(null);
		messageConsumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				try {
					Destination replyDestination = message.getJMSReplyTo();
		            Message replyMessage = session.createTextMessage("reply message ...");
		            replyMessage.setJMSCorrelationID(message.getJMSMessageID());
		            replyProducer.send(replyDestination, replyMessage);
			            
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
//		Thread.sleep(100000);
		TemporaryQueue replyQueue = session.createTemporaryQueue();
		TextMessage requestMsg = session.createTextMessage("A request message");
        requestMsg.setJMSReplyTo(replyQueue);
        MessageProducer producer = session.createProducer(requestQueue);
        producer.send(requestMsg);
        
		MessageConsumer replyConsumer = session.createConsumer(replyQueue);
        TextMessage replyMessageReceived = (TextMessage)replyConsumer.receive();
        System.out.println("Received reply: " + replyMessageReceived.getText());
        System.out.println("CorrelatedId: " + replyMessageReceived.getJMSCorrelationID());
        replyQueue.delete();
	}
	
	@Test
	public void getTopic() throws Exception {
		Topic topic = jmsService.getTopic("testTopic");
		assert topic != null;
		assert topic.getTopicName().equals("testTopic");
				
	}
	
	@AfterTest
	private void afterTest() {
		jmsService.destroy();
	}
}
