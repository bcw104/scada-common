package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.SensorDevice;

public interface SensorDeviceService extends BaseService<SensorDevice> {
	/**
	 * 根据设备id获得相应传感器
	 * 
	 * @param id
	 * @return
	 */
	List<SensorDevice> getSensorByDeviceId(Integer id);

}
