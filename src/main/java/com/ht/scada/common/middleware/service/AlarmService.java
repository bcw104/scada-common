package com.ht.scada.common.middleware.service;

import com.ht.scada.common.data.FaultRecord;
import com.ht.scada.common.data.OffLimitsRecord;
import com.ht.scada.common.data.YXData;
import com.ht.scada.common.middleware.alarm.PushDataListener;

/**
 * 报警服务接口<br>
 * 用于注册监听实时报警，查询报警记录等操作, 控制器可以直接调用该服务。
 * @author 薄成文
 *
 */
public interface AlarmService {
	
	/**
	 * 注册故障报警监听器.<br>
	 * <pre>
	 *  service.addFaultAlarmListern(new PushDataListener<FaultRecord>(){...});
	 * </pre>
	 * @param listener
	 * @throws Exception
	 */
	public void addFaultAlarmListener(PushDataListener<FaultRecord> listener);
	
	/**
	 * 注册越限报警监听器.<br>
	 * <pre>
	 *  service.addOffLimitsAlarmListern(new PushDataListener<OffLimitsRecord>(){...});
	 * </pre>
	 * @param listener
	 * @throws Exception
	 */
	public void addOffLimitsAlarmListener(PushDataListener<OffLimitsRecord> listener);
	
	/**
	 * 注册遥信变位报警监听器.<br>
	 * <pre>
	 *  service.addYXAlarmListern(new PushDataListener<YXData>(){...});
	 * </pre>
	 * @param listener
	 * @throws Exception
	 */
	public void addYXAlarmListener(PushDataListener<YXData> listener);
}
