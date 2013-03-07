package com.ht.scada.common.middleware;

import java.util.List;

import com.ht.scada.common.data.FaultDiagnoseRecord;
import com.ht.scada.common.data.FaultRecord;
import com.ht.scada.common.data.OffLimitsRecord;
import com.ht.scada.common.data.YXData;

/**
 * 推送数据监听器接口<br>
 * 需要向消息中间件注册, 用于监听报警信息等实时推送的数据.
 * <pre>
 * 例：
 * alarmService.addFaultAlarmListern(new PushDataListener<FaultRecord>(){...}); 
 * </pre>
 * @author 薄成文
 *
 */
public interface AlarmDataListener {
	
	/**
	 * 遥信变位
	 * @param list
	 */
	public void onYX(YXData data);
	
	/**
	 * 故障报警列表
	 * @param list
	 */
	public void onFault(FaultRecord data);
	
	/**
	 * 遥测越限报警
	 * @param list
	 */
	public void onOffLimits(OffLimitsRecord data);
	
	/**
	 * 故障诊断报警
	 * @param list
	 */
	public void onFaultDiagnose(FaultDiagnoseRecord data);
}
