package com.ht.scada.common.tag.entity;

import com.ht.scada.common.tag.util.DataType;
import com.ht.scada.common.tag.util.VarGroupEnum;
import com.ht.scada.common.tag.util.VarSubTypeEnum;
import com.ht.scada.common.tag.util.VarTypeEnum;
import org.hibernate.annotations.Index;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * 变量词典模板<br>
 * <p>
 * 大部分的监控末端都具有相同的变量类型，所有采用通用的变量词典模板来进行定义，开端节点只需要指定模板名称即可
 * </p>
 * 
 * @author 薄成文
 * @author 赵磊
 * 
 */
@Entity
@Table(name = "T_Tag_Cfg_Tpl")
public class TagCfgTpl extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3948279960114335095L;

	@Index(name = "idx_tagcfgtpl_tplname")
	@Column(name = "tpl_name")
	private String tplName;// 模板名称

	/* 变量属性 */
	@Column(name = "var_name")
	private String varName; // 变量key,用于程序脚本
	@Column(name = "tag_name")
	private String tagName;	//变量名，中文
	@Column(name = "var_group")
	@Enumerated(EnumType.STRING)
	private VarGroupEnum varGroup; // 变量分组,可以为空
	@Column(name = "var_type")
	@Enumerated(EnumType.STRING)
	private VarTypeEnum varType; // 变量类型
	@Column(name = "sub_Type")
	@Enumerated(EnumType.STRING)
	private VarSubTypeEnum subType; // 变量子类型
	

	/* IO信息 */
	@Column(name = "fun_code")
	private int funCode = -1; // 功能码
	@Column(name = "data_id")
	private int dataId = -1; // 数据ID
	@Column(name = "byte_offset")
	private int byteOffset = 0; // 字节偏移量
	@Column(name = "bit_offset")
	private int bitOffset = -1; // 位偏移量(-1表)
	@Column(name = "byte_len")
	private int byteLen = -1; // 字节长度
	@Column(name = "data_type")
	@Enumerated(EnumType.STRING)
	private DataType dataType; // 值类型（bool, int32, int16, bcd, mod10000, float,
								// double）
	@Column(name = "base_value")
	private Float baseValue;// 基值
	@Column(name = "coef_value")
	private Float coefValue;// 系数

	/* YM信息 */
	@Column(name = "max_value")
	private Double maxValue;// 最大值
	@Column(name = "min_value")
	private Double minValue;// 最小值
	@Column(name = "unit_value")
	private Integer unitValue;// 遥脉单位

	/* 变量扩展属性 */
	@Column(name = "trigger_name")
	private String triggerName; // 触发采集帧名,如"soe", 需要与采集通道中定义的帧名称对应

	/**
	 * 存储器
	 * 
	 * @see com.ht.scada.common.tag.util.StorageFactory
	 */
	@Column(name = "var_storage ")
	@Lob
	private String storage = "ym|0|599999999|1|0";

	public TagCfgTpl() {
	}

	public TagCfgTpl(Integer id) {
		setId(id);
	}

	public String getTplName() {
		return tplName;
	}

	public void setTplName(String tplName) {
		this.tplName = tplName;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public VarGroupEnum getVarGroup() {
		return varGroup;
	}

	public void setVarGroup(VarGroupEnum varGroup) {
		this.varGroup = varGroup;
	}

	public VarTypeEnum getVarType() {
		return varType;
	}

	public void setVarType(VarTypeEnum varType) {
		this.varType = varType;
	}



	public VarSubTypeEnum getSubType() {
		return subType;
	}

	public void setSubType(VarSubTypeEnum subType) {
		this.subType = subType;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public int getFunCode() {
		return funCode;
	}

	public void setFunCode(int funCode) {
		this.funCode = funCode;
	}

	public int getDataId() {
		return dataId;
	}

	public void setDataId(int dataID) {
		this.dataId = dataID;
	}

	public int getByteOffset() {
		return byteOffset;
	}

	public void setByteOffset(int byteOffset) {
		this.byteOffset = byteOffset;
	}

	public int getBitOffset() {
		return bitOffset;
	}

	public void setBitOffset(int bitOffset) {
		this.bitOffset = bitOffset;
	}

	public int getByteLen() {
		return byteLen;
	}

	public void setByteLen(int byteLen) {
		this.byteLen = byteLen;
	}

	public Float getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(Float baseValue) {
		this.baseValue = baseValue;
	}

	public Float getCoefValue() {
		return coefValue;
	}

	public void setCoefValue(Float coefValue) {
		this.coefValue = coefValue;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String trigger) {
		this.triggerName = trigger;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double max) {
		this.maxValue = max;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double min) {
		this.minValue = min;
	}

	public Integer getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(Integer unit) {
		this.unitValue = unit;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
