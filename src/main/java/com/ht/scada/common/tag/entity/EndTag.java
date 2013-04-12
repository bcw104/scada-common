package com.ht.scada.common.tag.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 单井、回路等末端节点
 * 
 * @author 薄成文
 * 
 */
@Entity
@Table(name = "T_end_tag")
public class EndTag extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3057724029168765439L;

	private String name;

	/**
	 * 末端编号(油井编号/回路编号)
	 */
	private String code;

	/**
	 * 节点类型<br>
	 * 不同的节点类型有对应的扩展信息表<br>
	 * type=="配电回路" TagExtPower.class<br>
	 * type=="油井A/B/C/D"
	 * TagExtOilA.class,TagExtOilB.class,TagExtOilC.class,TagExtOilD.class<br>
	 * type=="水井" TagExtWater.class<br>
	 */
	private String type;

	/**
	 * 变量模版名称,主要用于数据采集程序<br>
	 * <p>
	 * 当该标签节点是一个末端时（如油井）需要指定末端对应的变量模版，
	 * 变量模版中定义了末端所涉及到的所有变量，大部分的末端都具有相同的变量，所以采用模版来定义。
	 * </p>
	 */
	@Column(name = "tpl_name")
	private String tplName;
	
	@OneToMany(mappedBy = "endTag")
	private List<VarIOInfo> ioInfo;

	@OneToMany(mappedBy = "endTag")
	private List<EndTagExtInfo> extInfo;

	/**
	 * 关联的采集通道中的设备<br>
	 * <p>
	 * 主要用于采集程序，如果需要显示采集通道的状态也会用到其中的信息
	 * </p>
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id")
	private AcquisitionDevice device;

	/**
	 * 能耗索引节点（树形结构）<br>
	 * <p>
	 * 如果该节点是一个用电末端，则可以指定能耗索引（能耗索引用于进行用电统计、能效分析等）
	 * </p>
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "major_id")
	private MajorTag majorTag;

	/**
	 * 分区索引节点（树形结构）<br>
	 * <p>
	 * 用于定义该节点对应的分区，可以不指定
	 * </p>
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "area_id")
	private AreaMinorTag areaMinorTag;

	/**
	 * 能耗索引节点（树形结构）<br>
	 * <p>
	 * 如果该节点是一个用电末端，则可以指定能耗索引（能耗索引用于进行用电统计、能效分析等）
	 * </p>
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "energy_id")
	private EnergyMinorTag energyMinorTag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
	
	public List<VarIOInfo> getIoInfo() {
		return ioInfo;
	}
	
	public void setIoInfo(List<VarIOInfo> ioInfo) {
		this.ioInfo = ioInfo;
	}

	public List<EndTagExtInfo> getExtInfo() {
		return extInfo;
	}

	public void setExtInfo(List<EndTagExtInfo> extInfo) {
		this.extInfo = extInfo;
	}

	public AcquisitionDevice getDevice() {
		return device;
	}

	public void setDevice(AcquisitionDevice device) {
		this.device = device;
	}

	public MajorTag getMajorTag() {
		return majorTag;
	}

	public void setMajorTag(MajorTag majorTag) {
		this.majorTag = majorTag;
	}

	public AreaMinorTag getAreaMinorTag() {
		return areaMinorTag;
	}

	public void setAreaMinorTag(AreaMinorTag areaMinorTag) {
		this.areaMinorTag = areaMinorTag;
	}

	public EnergyMinorTag getEnergyMinorTag() {
		return energyMinorTag;
	}

	public void setEnergyMinorTag(EnergyMinorTag energyMinorTag) {
		this.energyMinorTag = energyMinorTag;
	}

}
