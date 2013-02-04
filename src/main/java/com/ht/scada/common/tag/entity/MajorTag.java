package com.ht.scada.common.tag.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 主索引节点
 * @author 薄成文
 *
 */
@Entity
@Table(name="T_Major_Tag")
public class MajorTag extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7410063196427742148L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;	// 节点名称
	
	/**
	 * 不同的节点类型有对应的扩展信息表
	 * type=="配电回路"  		TagExtPower.class
	 * type=="油井A/B/C/D" 	TagExtOilA.class,TagExtOilB.class,TagExtOilC.class,TagExtOilD.class
	 * type=="水井"			TagExtWater.class 
	 */
	private String type;	// 节点类型
	
	/**
	 * 变量模版名称
	 */
	@Column(name="tpl_name")
	private String tplName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="channel_id")
	private AcquisitionChannel channel;// 采集通道
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="device_id")
	private AcquisitionDevice device;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private MajorTag parent;
	
	@OneToMany(mappedBy="parent")
	private List<MajorTag> 		children;	// 子节点
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="energy_id")
	private EnergyMinorTag 		energyTag;	// 能耗次索引节点
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="area_id")
	private AreaMinorTag 		areaTag;	// 分区次索引节点

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTplName() {
		return tplName;
	}

	public void setTplName(String tplName) {
		this.tplName = tplName;
	}

	public AcquisitionChannel getChannel() {
		return channel;
	}

	public void setChannel(AcquisitionChannel channel) {
		this.channel = channel;
	}

	public AcquisitionDevice getDevice() {
		return device;
	}

	public void setDevice(AcquisitionDevice device) {
		this.device = device;
	}

	public MajorTag getParent() {
		return parent;
	}

	public void setParent(MajorTag parent) {
		this.parent = parent;
	}

	public List<MajorTag> getChildren() {
		return children;
	}

	public void setChildren(List<MajorTag> children) {
		this.children = children;
	}

	public EnergyMinorTag getEnergyTag() {
		return energyTag;
	}

	public void setEnergyTag(EnergyMinorTag energyTag) {
		this.energyTag = energyTag;
	}

	public AreaMinorTag getAreaTag() {
		return areaTag;
	}

	public void setAreaTag(AreaMinorTag areaTag) {
		this.areaTag = areaTag;
	}
	
	
}
