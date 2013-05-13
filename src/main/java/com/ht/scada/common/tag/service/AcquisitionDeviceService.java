package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.AcquisitionDevice;

public interface AcquisitionDeviceService extends
		BaseService<AcquisitionDevice> {
	/**
	 * 根据通道id获取设备
	 * 
	 * @param id
	 * @return
	 */
	List<AcquisitionDevice> getDeviceByChannelId(Integer id);

	/**
	 * 创建采集设备
	 * 
	 * @param acquisitionDevice
	 */
	void create(AcquisitionDevice acquisitionDevice);
	
	

}
