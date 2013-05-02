package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.AcquisitionChannel;

/**
 * 提供通道查询服务
 * 
 * @author 陈志强
 * 
 */
public interface AcquisitionChannelService extends
		BaseService<AcquisitionChannel> {

	/**
	 * 获得根通道
	 * 
	 * @return
	 */
	List<AcquisitionChannel> getRootAcquisitionChannel();

	/***
	 * 根据父id获取通道
	 * 
	 * @param id
	 * @return
	 */
	List<AcquisitionChannel> getDeviceByChannelId(Integer channelId);


}
