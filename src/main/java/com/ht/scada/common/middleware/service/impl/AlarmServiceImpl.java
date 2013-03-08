package com.ht.scada.common.middleware.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ht.scada.common.data.FaultRecord;
import com.ht.scada.common.data.OffLimitsRecord;
import com.ht.scada.common.data.YXData;
import com.ht.scada.common.data.entity.FaultDiagnoseRecord;
import com.ht.scada.common.middleware.AlarmDataListener;
import com.ht.scada.common.middleware.service.AlarmService;
import com.ht.scada.common.middleware.service.JmsService;

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService {
	
	@Inject
	private JmsService jmsService;

	private ObjectMapper mapper = new ObjectMapper(); // create once, reuse
	
	@Override
	public void addAlarmListener(final AlarmDataListener listener) {
/*		jmsService.registTopicMessageListener("/topic/alarm/fault", new MessageListener() {
			
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
		});*/
	}

	@Override
	public List<FaultRecord> getCurrentFaultRecord(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OffLimitsRecord> getCurrentOffLimitsRecord(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<YXData> getCurrentYXData(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaultDiagnoseRecord> getCurrentFaultDiagnoseRecord(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
