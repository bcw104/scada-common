package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.AcquisitionDevice;
import com.ht.scada.common.tag.entity.SensorDevice;
import com.ht.scada.common.tag.entity.TagCfgTpl;
import com.ht.scada.common.tag.entity.VarIOInfo;

/**
 * 提供标签配置信息查询服务
 * 
 * @author 薄成文
 * @author 赵磊
 * @author 陈志强
 * 
 */
public interface TagService {


	public TagCfgTpl getTagCfgTpl(int id);

	/**
	 * @param id
	 * @return
	 */
	public String getTagTplNameByMajorTagID(int id);

	/**
	 * 根据变量词典模板名称获取变量词典
	 * 
	 * @param name
	 * @return
	 */
	public List<TagCfgTpl> getTagTplByName(String name);

	public List<VarIOInfo> getTagIOInfoByEndTagID(int endTagID);



	/**
	 * 获取RTU设备下面的所有传感器设备
	 * 
	 * @param id
	 * @return
	 */
	public List<SensorDevice> getSensorDeviceByRTUDeviceID(int id);

	/**
	 * 获取所有采集通道名称（含带通讯规约）
	 * 
	 * @return
	 */
	public List<String> getAllChannel();

	/**
	 * 通过采集通道名称获取
	 * 
	 * @param name
	 * @return
	 */
	public List<AcquisitionDevice> getDeviceByChannelName(String name);





}
