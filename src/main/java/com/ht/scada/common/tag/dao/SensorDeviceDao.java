package com.ht.scada.common.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.entity.AcquisitionDevice;
import com.ht.scada.common.tag.entity.SensorDevice;

public interface SensorDeviceDao extends JpaRepository<SensorDevice, Integer> {

	/**
	 * 根据设备获取相关的传感器
	 * 
	 * @param deviceObject
	 * @return
	 */
	List<SensorDevice> findByRtuDevice(AcquisitionDevice deviceObject);

}
