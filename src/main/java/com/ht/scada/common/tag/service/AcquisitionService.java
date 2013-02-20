package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.AcquisitionChannel;
import com.ht.scada.common.tag.entity.AcquisitionDevice;

/**
 * 采集配置信息查询服务接口
 * @author 薄成文
 *
 */
public interface AcquisitionService {

	/**
	 * 获取所有采集通道
	 * @return
	 */
	public List<AcquisitionChannel> getAllChannel();
	
	/**
	 * 查询采集通道数量
	 * @return
	 */
	public int getChannelSize();
	
	/**
	 * 查询采集通道中的采集设备数量
	 * @param channelID
	 * @return
	 */
	public int getDeviceSizeByChannel(int channelID);
	
	/**
	 * 通过主键获取采集通道
	 * @param id
	 * @return
	 */
	public AcquisitionChannel getChannel(int id);
	
	/**
	 * 通过主键获取采集设备
	 * @param id
	 * @return
	 */
	public AcquisitionDevice getDevice(int id);
	
	/**
	 * 根据通讯ID和设备地址查询采集设备
	 * @param channelID
	 * @param address
	 * @return
	 */
	public AcquisitionDevice getDeviceByChannelAndAddress(int channelID, int address);
}
