package com.ht.scada.common.middleware.service;

import java.util.List;

import com.ht.scada.common.data.FaultRecord;
import com.ht.scada.common.data.OffLimitsRecord;
import com.ht.scada.common.data.YXData;
import com.ht.scada.common.data.entity.FaultDiagnoseRecord;
import com.ht.scada.common.middleware.AlarmDataListener;

/**
 * 报警服务接口<br>
 * 用于注册监听实时报警，查询报警记录等操作, 控制器可以直接调用该服务。
 * @author 薄成文
 *
 */
public interface AlarmService {
	
	/**
	 * 注册故障报警监听器,用于实时推送报警信息.<br>
	 * <pre>
	 *  service.addFaultAlarmListern(new PushDataListener(){...});
	 * </pre>
	 * @param listener
	 * @throws Exception
	 */
	public void addAlarmListener(AlarmDataListener listener);
	
	/**
	 * 返回当前的故障报警记录
	 * @param code
	 * @return
	 */
	public List<FaultRecord> getCurrentFaultRecord(String code);
	
	/**
	 * 返回当前的遥测越限报警记录
	 * @param code
	 * @return
	 */
	public List<OffLimitsRecord> getCurrentOffLimitsRecord(String code);
	
	/**
	 * 返回当前的遥信变位记录
	 * @param code
	 * @return
	 */
	public List<YXData> getCurrentYXData(String code);
	
	/**
	 * 返回当前的故障诊断记录
	 * @param code
	 * @return
	 */
	public List<FaultDiagnoseRecord> getCurrentFaultDiagnoseRecord(String code);
}
