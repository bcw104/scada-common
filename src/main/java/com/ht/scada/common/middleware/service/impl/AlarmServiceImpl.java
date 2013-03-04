package com.ht.scada.common.middleware.service.impl;

import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ht.scada.common.data.FaultRecord;
import com.ht.scada.common.data.OffLimitsRecord;
import com.ht.scada.common.data.YXData;
import com.ht.scada.common.middleware.alarm.PushDataListener;
import com.ht.scada.common.middleware.service.AlarmService;
import com.ht.scada.common.middleware.service.JmsService;

public class AlarmServiceImpl implements AlarmService {
	
	@Inject
	private JmsService jmsService;

	private ObjectMapper mapper = new ObjectMapper(); // create once, reuse
	
	@Override
	public void addFaultAlarmListener(final PushDataListener<FaultRecord> listener) {
		jmsService.registTopicMessageListener("/topic/alarm/fault", new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage) message;
				
				FaultRecord record;
				try {
					record = mapper.readValue(textMessage.getText(), FaultRecord.class);
					listener.on(record);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	@Override
	public void addOffLimitsAlarmListener(
			final PushDataListener<OffLimitsRecord> listener) {
		jmsService.registTopicMessageListener("/topic/alarm/offLimit", new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage) message;
				
				OffLimitsRecord record;
				try {
					record = mapper.readValue(textMessage.getText(), OffLimitsRecord.class);
					listener.on(record);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void addYXAlarmListener(final PushDataListener<YXData> listener) {
		jmsService.registTopicMessageListener("/topic/alarm/yx", new MessageListener() {
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage) message;
				
				YXData record;
				try {
					record = mapper.readValue(textMessage.getText(), YXData.class);
					listener.on(record);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

}
