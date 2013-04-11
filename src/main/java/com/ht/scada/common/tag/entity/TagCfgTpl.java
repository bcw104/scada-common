package com.ht.scada.common.tag.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Index;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.ht.scada.common.tag.util.DataType;


/**
 * 变量词典模板<br>
 * <p>大部分的监控末端都具有相同的变量类型，所有采用通用的变量词典模板来进行定义，开端节点只需要指定模板名称即可</p>
 * @author 薄成文
 * @author 赵磊
 *
 */
@Entity
@Table(name="T_Tag_Cfg_Tpl")
public class TagCfgTpl extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2045500318135780418L;

	@Index(name="idx_tagcfgtpl_tplname")
	@Column(name="tpl_name")
	private String tplName;// 模板名称
	
	/*变量属性*/
	@Column(name="var_name") private String 	varName;	// 变量名称
	@Column(name="var_type") private String 	varType;	// 变量类型
	@Column(name="sub_Type") private String 	subType;	// 变量子类型
	@Column(name="data_type") private DataType 	dataType;	// 值类型（bool, int32, int16, bcd, mod10000, float, double）
	
	@Column(name="fun_code") 	private int		funCode;	// 功能码
	@Column(name="data_id") 	private int 	dataID;		// 数据ID
	@Column(name="byte_offset") private int 	byteOffset = 0;	// 字节偏移量
	@Column(name="bit_offset") private int 		bitOffset = -1;	// 位偏移量(-1表)
	@Column(name="byte_len") private int 		byteLen;	// 字节长度
	@Column(name="base_value") private float 	baseValue = 0;// 基值 
	@Column(name="coef_value") private float 	coefValue = 1;// 系数
	
	/*变量扩展属性*/
	@Transient
	private String trigger;		// 触发采集帧名,如"soe", 需要与采集通道中定义的帧名称对应
	
	/**
	 * 存储器
	 * @see com.ht.scada.common.tag.util.StorageFactory
	 */
	@Transient
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

	public String getVarType() {
		return varType;
	}

	public void setVarType(String varType) {
		this.varType = varType;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
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

	public int getDataID() {
		return dataID;
	}

	public void setDataID(int dataID) {
		this.dataID = dataID;
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

	public float getBaseValue() {
		return baseValue;
	}

	public void setBaseValue(float baseValue) {
		this.baseValue = baseValue;
	}

	public float getCoefValue() {
		return coefValue;
	}

	public void setCoefValue(float coefValue) {
		this.coefValue = coefValue;
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}
	
	
	
}
