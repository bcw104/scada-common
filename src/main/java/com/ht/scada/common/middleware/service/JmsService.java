package com.ht.scada.common.middleware.service;

import java.util.List;

import com.ht.scada.common.data.FaultRecord;
import com.ht.scada.common.data.OffLimitsRecord;
import com.ht.scada.common.data.YXData;
import com.ht.scada.common.middleware.alarm.AlarmListener;

import com.ht.scada.common.tag.entity.WellData;

/**
 * 消息中间件通讯服务调用接口
 * 
 * @author 薄成文
 * @author 赵磊
 */
public interface JmsService {
	
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
	
}
