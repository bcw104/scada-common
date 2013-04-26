package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.AcquisitionDevice;
import com.ht.scada.common.tag.entity.EndTag;
import com.ht.scada.common.tag.entity.MajorTag;
import com.ht.scada.common.tag.entity.SensorDevice;
import com.ht.scada.common.tag.entity.TagCfgTpl;
import com.ht.scada.common.tag.entity.VarGroupCfg;
import com.ht.scada.common.tag.entity.VarIOInfo;

/**
 * 提供标签配置信息查询服务
 * 
 * @author 薄成文
 * @author 赵磊
 *
 */
public interface TagService {
	
	/**
	 * 通过主键查询主标签节点
	 * @param id
	 * @return
	 */
	public MajorTag getMajorTag(int id);
	
	/**
	 * 通过主键查询末端节点
	 * @param id
	 * @return
	 */
	public EndTag getEndTag(int id);
	
	public TagCfgTpl getTagCfgTpl(int id);
	
	/**
	 * @param id
	 * @return
	 */
	public String getTagTplNameByMajorTagID(int id);
	
	/**
	 * 根据变量词典模板名称获取变量词典
	 * @param name
	 * @return
	 */
	public List<TagCfgTpl> getTagTplByName(String name);
	
	/**
	 * 获取所有模板变量
	 * @return
	 */
	public List<TagCfgTpl> getAllTagTpl();
	
	public List<VarIOInfo> getTagIOInfoByEndTagID(int endTagID);
	
	/**
	 * 获取所有变量IO信息
	 * @return
	 */
	public List<VarIOInfo> getAllTagIOInfo();
	
	/**
	 * 通过主标签名称获取标签列表(用于模拟树型结构)
	 * @param name
	 * @return
	 */
	public List<MajorTag> getMajorTagByNodeName(String name);
	
	
	/**
	 * 通过主标签ID和末端类型获取所有末端, 如果末端类型为空负不过滤
	 * @param majorTagID 	主标签主键 
	 * @param type			末端类型
	 * @return
	 */
	public List<EndTag> getEndTagByMajorTagAndType(int majorTagID, String type);
	
	/**
	 * 获取所有已经关联了采集通道和设备的末端(deviceIsNotNull)
	 * @return
	 */
	public List<EndTag> getEndTag4Comm();
	
	/**
	 * 获取RTU设备下面的所有传感器设备
	 * @param id
	 * @return
	 */
	public List<SensorDevice> getSensorDeviceByRTUDeviceID(int id);
	
	/**
	 * 获取所有采集通道名称（含带通讯规约）
	 * @return
	 */
	public List<String> getAllChannel();
	
	/**
	 * 通过采集通道名称获取
	 * @param name
	 * @return
	 */
	public List<AcquisitionDevice> getDeviceByChannelName(String name);
	
	/**
	 * 获取所有变量分组配置信息
	 * @return
	 */
	public List<VarGroupCfg> getAllVarGroupCfg();
}
