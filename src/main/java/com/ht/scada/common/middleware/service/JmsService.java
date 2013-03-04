package com.ht.scada.common.middleware.service;

import java.util.List;

import com.ht.scada.common.data.FaultRecord;
import com.ht.scada.common.data.OffLimitsRecord;
import com.ht.scada.common.data.YXData;
import com.ht.scada.common.middleware.alarm.AlarmListener;

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
	 * @param majorTagCodee
	 * @return
	 */
	List<String> getLatestAlarmInfo(String majorTagCode) throws Exception;
	
	/**
	 * 注册故障报警监听器.<br>
	 *  jmsService.addFaultAlarmListern(new AlarmLister<FaultRecord>(){...});
	 * </pre>
	 * @param listener
	 * @throws Exception
	 */
	public void addFaultAlarmListener(AlarmListener<FaultRecord> listener);
	
	/**
	 * 注册越限报警监听器.<br>
	 *  jmsService.addOffLimitsAlarmListern(new AlarmLister<OffLimitsRecord>(){...});
	 * </pre>
	 * @param listener
	 * @throws Exception
	 */
	public void addOffLimitsAlarmListener(AlarmListener<OffLimitsRecord> listener);
	
	/**
	 * 注册遥信变位报警监听器.<br>
	 *  jmsService.addYXAlarmListern(new AlarmLister<YXData>(){...});
	 * </pre>
	 * @param listener
	 * @throws Exception
	 */
	public void addYXAlarmListener(AlarmListener<YXData> listener);
	
}
