package com.ht.scada.common.middleware.alarm;

/**
 * 推送数据监听器接口<br>
 * 需要向消息中间件注册, 用于监听报警信息等实时推送的数据.
 * <pre>
 * 例：
 * alarmService.addFaultAlarmListern(new PushDataListener<FaultRecord>(){...}); 
 * </pre>
 * @author 薄成文
 *
 * @param <T>
 */
public interface PushDataListener<T> {
	
	/**
	 * 数据到达时自动调用
	 * @param model
	 */
	public void on(T model);
}
