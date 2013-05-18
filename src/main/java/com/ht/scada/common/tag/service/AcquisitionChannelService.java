package com.ht.scada.common.tag.service;

import com.ht.scada.common.tag.entity.AcquisitionChannel;

import java.util.List;

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
	 * @param channelId
	 * @return
	 */
	List<AcquisitionChannel> getDeviceByChannelId(Integer channelId);

    /**
     * 获取所有采集通道
     * @return
     */
    List<AcquisitionChannel> getAllChannel();

}
