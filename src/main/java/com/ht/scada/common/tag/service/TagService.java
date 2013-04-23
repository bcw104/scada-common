package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.AbstractDevice;
import com.ht.scada.common.tag.entity.AcquisitionDevice;
import com.ht.scada.common.tag.entity.AreaMinorTag;
import com.ht.scada.common.tag.entity.EndTag;
import com.ht.scada.common.tag.entity.EnergyMinorTag;
import com.ht.scada.common.tag.entity.MajorTag;
import com.ht.scada.common.tag.entity.SensorDevice;
import com.ht.scada.common.tag.entity.TagCfgTpl;
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
	 * 创建主索引
	 * @param majorTag
	 */
	public void createMajorTag(MajorTag majorTag);
	
	/**
	 * 添加末端节点
	 * @param endTag
	 */
	public void createEndTag(EndTag endTag);
	
	/**
	 * 创建常规分类索引
	 * @param areaMinorTag
	 */
	public void createAreaMinorTag(AreaMinorTag areaMinorTag);
	
	/**
	 * 创建能耗分类分项
	 * @param energyMinorTag
	 */
	public void createEnergyMinorTag(EnergyMinorTag energyMinorTag);
	
	/**
	 * 删除主索引
	 * @param id
	 */
	public void deleteMajorTagById(int id);
	
	/**
	 * 删除末端节点
	 * @param id
	 */
	public void deleteEndTagById(int id);
	
	/**
	 * 通过id删除常规索引节点
	 * @param id
	 */
	public void deleteAreaMinorTag(int id);
	
	/**
	 * 通过id删除能耗分类分项
	 * @param id
	 */
	public void deleteEnergyMinorTag(int id);
	
	/**
	 * 修改末端节点
	 * @param endTag
	 */
	public void updateEndTag(EndTag endTag);
	
	/**
	 * 修改主索引
	 * @param majorTag
	 */
	public void updateMajorTag(MajorTag majorTag);
	
	/**
	 * 获取所有子节点
	 * @param id
	 * @return
	 */
	public List<MajorTag> getMajorTagsByParentId(int id);
	
	/**
	 * 通过id获得所有末端节点
	 * @param id
	 * @return
	 */
	public List<EndTag> getEndTagByParentId(int id);
	
	
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
	
	public List<VarIOInfo> getTagIOInfoByEndTagID(int endTagID);
	
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
	 * 获得根主索引
	 * @return
	 */
	public List<MajorTag> getRootMajorTag();
}
